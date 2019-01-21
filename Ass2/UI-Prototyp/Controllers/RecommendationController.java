package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import Models.Destination;
import Models.DestinationInterest;
import Models.Hotel;
import Models.HotelActivity;
import Models.TREC;
import Models.User;
import Models.UserActivity;
import Models.UserInterest;
import ViewModels.RecommendationViewModel;
import Views.RecommendationsAdmin;
import Views.RecommendationsCustomer;
import database.Database;



public class RecommendationController 
{
	public static void showCustomerRecommendation()
	{
		
		RecommendationsCustomer rec = new RecommendationsCustomer(calculateCustomerRecommendation());
		rec.setVisible(true);
	}
	
	public static void showAdminRecommendation()
	{
		RecommendationsAdmin rec = new RecommendationsAdmin(calculateAdminRecommendation());
		rec.setVisible(true);
	}
	
	public static List<User> calculateAdminRecommendation()
	{
		List<User> users = new ArrayList<User>();
		users.add(new User("Christof", "Gartner"));
		users.add(new User("Christoph", "Proß"));
		users.add(new User("Manuel", "Gussmagg"));
		users.add(new User("Stefan", "Bortolas"));
		users.add(new User("Tanja", "Tatschl"));
		users.add(new User("Zdenek", "Zeman"));
		return users;
	}
	
	public static RecommendationViewModel calculateCustomerRecommendation()
	{
	    Session session = Database.getSession();
	    
	    List<Hotel> hotels = Database.loadAllData(Hotel.class, session);
	    List<Destination> destinations = Database.loadAllData(Destination.class, session);
	    List<HotelActivity> hotelactivities = Database.loadAllData(HotelActivity.class, session);
	    List<DestinationInterest> destinationinterests = Database.loadAllData(DestinationInterest.class, session);
	    List<UserActivity> useractivities = Database.loadAllData(UserActivity.class, session);
	    List<UserInterest> userinterests = Database.loadAllData(UserInterest.class, session);
	    
	    Map<Integer, Hotel> hotels_map = new HashMap<Integer, Hotel>();
	    Map<Integer, Destination> destination_map = new HashMap<Integer, Destination>();
	    

	    
	    User user = TREC.getInstance().getCurrentLoggedInUser();
	    
	    for(Hotel hotel: hotels) //convert hotels to map
	    	hotels_map.put(hotel.getId(), hotel);
	    
	    for(HotelActivity ha: hotelactivities) //add Activities to Hotels
	    	hotels_map.get(ha.getHotel().getId()).getActivities().put(ha.getName(), ha.getValue());
	    
	    for(Destination dest: destinations) //convert destinations to map
	    	destination_map.put(dest.getId(), dest);
	    
		for(DestinationInterest di: destinationinterests) //add Interests to Destinations
			destination_map.get(di.getDestination().getId()).getInterests().put(di.getName(), di.getValue());
		
		for(UserActivity ua: useractivities)
			user.getActivities().put(ua.getName(), ua.getValue());
	    
		for(UserInterest ui: userinterests)
			user.getInterests().put(ui.getName(), ui.getValue());
		
		
		//Add the hotels to the Destinations
	    for(Hotel hotel : hotels)
	    	destination_map.get(hotel.getDestination().getId()).getHotels().add(hotel);
		
		
		int sumInterests = 0;
		for(int val : user.getInterests().values())
			sumInterests += val;
				
		int sumActivities = 0;
		for(int val : user.getInterests().values())
			sumActivities += val;
		
		Map<String, Double> ImportanceInterests = new HashMap<String, Double>();
		Map<String, Double> ImportanceActivities = new HashMap<String, Double>();
		
		for (Map.Entry<String, Integer> entry : user.getInterests().entrySet()) 
			ImportanceInterests.put(entry.getKey(), (double) entry.getValue()/sumInterests);
		
		for (Map.Entry<String, Integer> entry : user.getActivities().entrySet()) 
			ImportanceActivities.put(entry.getKey(), (double) entry.getValue()/sumActivities);
		
		
		Map<Integer, Double> HotelRatings = new HashMap<Integer, Double>();
		
		for(Hotel hotel : hotels)
		{
			double overallRating = 0.0;
			if (hotel.getActivities() == null)
				continue;
			for(Map.Entry<String, Integer> entry : hotel.getActivities().entrySet())
				overallRating += entry.getValue() * ImportanceActivities.get(entry.getKey());
			
			HotelRatings.put(hotel.getId(), overallRating);
		}
		
		Map<Integer, Double> DestinationRatings = new HashMap<Integer, Double>();
		for(Destination dest : destinations)
		{
			double overallRating = 0.0;
			if (dest.getInterests() == null)
				continue;
			for(Map.Entry<String, Integer> entry : dest.getInterests().entrySet())
				overallRating += entry.getValue() * ImportanceInterests.get(entry.getKey());
			
			DestinationRatings.put(dest.getId(), overallRating);
		}
		
		
		List<Hotel> recommendetHotels = new ArrayList<Hotel>();
		List<Destination> recommendetDestinations = new ArrayList<Destination>();
		
		Map.Entry<Integer, Double> maxEntry = null;
		
		while(!HotelRatings.isEmpty())
		{
			for (Map.Entry<Integer, Double> entry : HotelRatings.entrySet())
			{
				if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
				{
					maxEntry = entry;
				}
			}
			recommendetHotels.add(hotels_map.get(maxEntry.getKey()));
			HotelRatings.remove(maxEntry.getKey());
			maxEntry = null;
		}
		
		while(!DestinationRatings.isEmpty())
		{
			for (Map.Entry<Integer, Double> entry : DestinationRatings.entrySet())
			{
			    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
			    	maxEntry = entry;
			    }
			}
			recommendetDestinations.add(destination_map.get(maxEntry.getKey()));
			DestinationRatings.remove(maxEntry.getKey());
			maxEntry = null;
		}
		
		return new RecommendationViewModel(recommendetHotels, recommendetDestinations);		
	}
}
