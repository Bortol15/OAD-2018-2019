package Controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import Models.Destination;
import Models.DestinationInterest;
import Models.Evaluation;
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
		List<User> users = getAdminRecommendation();
		
		RecommendationsAdmin rec = new RecommendationsAdmin(users);
		rec.setVisible(true);
	}
	
	public static List<User> getAdminRecommendation()
	{
		User admin = TREC.getInstance().getCurrentLoggedInUser();
		Session session = Database.getSession();
		List<Hotel> all_hotels = Database.loadAllData(Hotel.class, session);
		List<HotelActivity> hotelactivities = Database.loadAllData(HotelActivity.class, session);
		Map<Integer, Hotel> admin_hotels_map = new HashMap<Integer, Hotel>();
		List<User> users = new ArrayList<User>();
		Map<Integer, User> user_map = new HashMap<Integer, User>();
		
		for(Hotel hotel : all_hotels)
		{
			if(hotel.getOwner().getUserId() == admin.getUserId())
				admin_hotels_map.put(hotel.getId(), hotel);
		}
		
		for(HotelActivity ha : hotelactivities)
		{
			if(ha.isActivityEntry())
				admin_hotels_map.get(ha.getHotel().getId()).getActivities().put(ha.getName(), null);
		}
		
		for(Map.Entry<Integer, Hotel> entry : admin_hotels_map.entrySet())
		{
			
			if(entry.getValue().getActivities() != null && entry.getValue().getActivities().size() != 0)
			{
				User user = calculateUserRecommendationForHotel(entry.getValue());
				if(user != null)
				{
					user.getHotels().add(entry.getValue());
					users.add(user);
				}
			}
		}
		
		for(User user : users)
		{
			
			if(!user_map.containsKey(user.getUserId()))
				user_map.put(user.getUserId(), user);
			
			if(user_map.size() >= 3)
				break;
		}
		users.clear();
		for(User user : user_map.values())
			users.add(user);
		
		return users;
	}
	
	public static User calculateUserRecommendationForHotel(Hotel hotel)
	{
		Session session = Database.getSession();
		Map<Integer, User> customers = new HashMap<Integer, User>();
		List<User> customer_list = new ArrayList<User>();
		List<UserActivity> useractivities = Database.loadAllData(UserActivity.class, session);
		List<User> all_users = Database.loadAllData(User.class, session);
		List<Evaluation> all_evaluations = Database.loadAllData(Evaluation.class, session);
		
		for(Evaluation eva : all_evaluations)
		{
			if(eva.getHotel().getId() == hotel.getId())
				hotel.getEvaluations().add(eva);
		}
		
		for(User user : all_users)
		{
			if(!user.getIs_admin())
			{
				customers.put(user.getUserId(), user);
				customer_list.add(user);
			}
		}

		for(UserActivity ua : useractivities)
			customers.get(ua.getUser().getUserId()).getActivities().put(ua.getName(), ua.getValue());
		
		Map<Integer, List<Integer>> user_scores = new HashMap<Integer, List<Integer>>();
		
		for(User user : customer_list)
		{
			boolean has_evaluation = false;
			for(Evaluation eva : hotel.getEvaluations())
			{
				if(eva.getUser().getUserId() == user.getUserId())
				{
					has_evaluation = true;
					break;
				}
			}
			if(has_evaluation == true)
				continue;
			for(Map.Entry<String, Integer> entry : hotel.getActivities().entrySet())
			{
				if(user.getActivities().containsKey(entry.getKey()))
				{
					if(!user_scores.containsKey(user.getUserId()))
						user_scores.put(user.getUserId(), new ArrayList<Integer>());
					
						user_scores.get(user.getUserId()).add(user.getActivities().get(entry.getKey()));
				}
			}
		}
		
		Map<Integer, Integer> sum_user_scores = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, List<Integer>> entry : user_scores.entrySet())
		{
			int sum = 0;
			for(Integer value : entry.getValue())
				sum += value;
			
			sum_user_scores.put(entry.getKey(), sum);
		}
		
		Map.Entry<Integer, Integer> maxEntry = null;

		for (Map.Entry<Integer, Integer> entry : sum_user_scores.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		
		session.close();
		return customers.get(maxEntry.getKey());
	}
	
	public static Map<String, Integer> calculateHotelRating(List<Evaluation> evaluations)
	{
		Map<String, List<Integer>> rating_values = new HashMap<String, List<Integer>>();
		Map<String, Integer> ratings = new HashMap<String, Integer>();
		
		for(Evaluation eva : evaluations)
		{
			for(HotelActivity ha : eva.getActivities())
			{
				if(rating_values.containsKey(ha.getName()))
				{
					rating_values.get(ha.getName()).add(ha.getValue());
				}
				else
				{
					List<Integer> values = new ArrayList<Integer>();
					values.add(ha.getValue());
					rating_values.put(ha.getName(), values);
				}
			}
		}
		
		for (Map.Entry<String, List<Integer>> entry : rating_values.entrySet())
		{
			int sum = 0;
			for(Integer value : entry.getValue())
				sum += value;
			
			ratings.put(entry.getKey(), sum/entry.getValue().size());
		}
		
		return ratings;
	}
	
	public static List<Hotel> createHotelRecommendation()
	{
		Session session = Database.getSession();
	    List<Hotel> hotels = Database.loadAllData(Hotel.class, session);
	    Map<Integer, Hotel> hotels_map = new HashMap<Integer, Hotel>();
	    Map<Integer, Evaluation> evaluation_map = new HashMap<Integer, Evaluation>();
	    List<Evaluation> all_hotel_evaluations = Database.loadAllData(Evaluation.class, session);
		List<HotelActivity> all_hotel_activities = Database.loadAllData(HotelActivity.class, session);
		session.close();
		
		for(Hotel hotel: hotels) //put hotels on map
			hotels_map.put(hotel.getId(), hotel);
		
		for(Evaluation eva: all_hotel_evaluations) //put evaluations on map
		    evaluation_map.put(eva.getId(), eva);
		
		for(HotelActivity ha : all_hotel_activities)
		{
			if(ha.getEvaluation() != null)
				evaluation_map.get(ha.getEvaluation().getId()).getActivities().add(ha);
		}

		for(Evaluation eva : all_hotel_evaluations)
			hotels_map.get(eva.getHotel().getId()).getEvaluations().add(eva);
		
		for(Hotel hotel: hotels)
			hotel.setActivities(calculateHotelRating(hotel.getEvaluations()));
		
		return hotels;
	}
	
	
	public static RecommendationViewModel calculateCustomerRecommendation()
	{
	    Session session = Database.getSession();
	    
	    List<Destination> destinations = Database.loadAllData(Destination.class, session);
	    List<DestinationInterest> destinationinterests = Database.loadAllData(DestinationInterest.class, session);
	    List<UserActivity> useractivities = Database.loadAllData(UserActivity.class, session);
	    List<UserInterest> userinterests = Database.loadAllData(UserInterest.class, session);
		session.close();
	    
		List<Hotel> hotels = createHotelRecommendation();
	    
		Map<Integer, Destination> destination_map = new HashMap<Integer, Destination>();
	    Map<Integer, Hotel> hotels_map = new HashMap<Integer, Hotel>();
	    

	    
	    User user = TREC.getInstance().getCurrentLoggedInUser();

	    
	    for(Destination dest: destinations) //convert destinations to map
	    	destination_map.put(dest.getId(), dest);	    
	    
	    for(Hotel hotel : hotels)
	    {
	    	hotels_map.put(hotel.getId(), hotel);
	    	destination_map.get(hotel.getDestination().getId()).getHotels().add(hotel);
	    }
	    
		for(DestinationInterest di: destinationinterests) //add Interests to Destinations
			destination_map.get(di.getDestination().getId()).getInterests().put(di.getName(), di.getValue());
		
		for(UserActivity ua: useractivities)
			user.getActivities().put(ua.getName(), ua.getValue());
	    
		for(UserInterest ui: userinterests)
			user.getInterests().put(ui.getName(), ui.getValue());
		
		
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
		
		// for debugging
//		String result = "";
//		for(Map.Entry<Integer, Double> entry : HotelRatings.entrySet())
//		{
//			double value = Double.valueOf(new DecimalFormat("#.##").format(entry.getValue()));
//			result += hotels_map.get(entry.getKey()).toString() + ": " + value + "\n";
//		}
//		JOptionPane.showMessageDialog(null, result);
		
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
