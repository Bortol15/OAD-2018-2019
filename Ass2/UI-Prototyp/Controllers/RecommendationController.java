package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Models.Category;
import Models.Destination;
import Models.Hotel;
import Models.HotelActivity;
import Models.User;
import database.Database;



public class RecommendationController 
{
	
	public static void calculateCustomerRecommendation()
	{
		Hotel hotelx = new Hotel();
		HotelActivity ha = new HotelActivity("asdf", 3);
		
	    Session session = Database.getSession();
	    List<Hotel> hotels = Database.loadAllData(Hotel.class, session);
	    
		
		Destination dest1 = new Destination(1, "Graz", "Austria");
		Hotel hotel1 = new Hotel(1,"Name", dest1,"Adress",4);
		hotels.add(hotel1);
		Map<String, Integer> activities1 = new HashMap<String, Integer>();
		Map<String, Integer> interests1 = new HashMap<String, Integer>();
		//		activities1.put("Schwimmen", 4);
		//		activities1.put("Klettern",6);
		//		activities1.put("Museen",8);
		//		activities1.put("Tierpark",5);
		//		activities1.put("Einkaufszentrum", 8);
		
		interests1.put("Lifestyle",8);
		interests1.put("Sport",5);
		interests1.put("Abenteuer",7);
		interests1.put("Familie",4);
		interests1.put("Kultur",4);
		hotel1.setActivities(interests1);
		
		
		Hotel hotel2 = new Hotel(2, "Name", dest1,"Adress",4);
		hotels.add(hotel2);
		Map<String, Integer> activities2 = new HashMap<String, Integer>();
		Map<String, Integer> interests2 = new HashMap<String, Integer>();
		//		hotel1.setActivities(activities2);
		//		activities2.put("Schwimmen", 7);
		//		activities2.put("Klettern",8);
		//		activities2.put("Museen",5);
		//		activities2.put("Tierpark",8);
		//		activities2.put("Einkaufszentrum", 7);
		
		interests2.put("Lifestyle",4);
		interests2.put("Sport",9);
		interests2.put("Abenteuer",10);
		interests2.put("Familie",1);
		interests2.put("Kultur",3);
		hotel2.setActivities(interests2);
		
		
		Hotel hotel3 = new Hotel(3, "Name", dest1,"Adress",4);
		hotels.add(hotel3);
		Map<String, Integer> activities3 = new HashMap<String, Integer>();
		Map<String, Integer> interests3 = new HashMap<String, Integer>();
		//		hotel1.setActivities(activities3);
		//		activities3.put("Schwimmen", 9);
		//		activities3.put("Klettern",3);
		//		activities3.put("Museen",4);
		//		activities3.put("Tierpark",3);
		//		activities3.put("Einkaufszentrum", 5);
			
		interests3.put("Lifestyle",4);
		interests3.put("Sport",10);
		interests3.put("Abenteuer",10);
		interests3.put("Familie",3);
		interests3.put("Kultur",10);
		hotel3.setActivities(interests3);
		
		
		User user1 = new User();
		Map<String, Integer> useractivities1 = new HashMap<String, Integer>();
		Map<String, Integer> userinterests = new HashMap<String, Integer>();
		user1.setActivities(useractivities1);
		user1.setInterests(userinterests);
		
		useractivities1.put("Einkaufszentrum", 9);
		useractivities1.put("Schwimmen",3);
		useractivities1.put("Klettern",4);
		useractivities1.put("Tierpark",3);
		useractivities1.put("Museen",4);
		
		userinterests.put("Lifestyle",4);
		userinterests.put("Sport",7);
		userinterests.put("Abenteuer",8);
		userinterests.put("Familie",3);
		userinterests.put("Kultur",7);
				
		int sumInterests = 0;
		for(int val : user1.getInterests().values())
			sumInterests += val;
		
		Map<String, Double> UserImportance = new HashMap<String, Double>();
		
		for (Map.Entry<String, Integer> entry : user1.getInterests().entrySet()) 
		    UserImportance.put(entry.getKey(), (double) entry.getValue()/sumInterests);
		
		
		Map<Integer, Double> HotelsMap = new HashMap<Integer,Double>();
		
		for(Hotel hotel : hotels)
		{
			double overallRating = 0.0;
			for(Map.Entry<String, Integer> entry : hotel.getActivities().entrySet())
			{
				overallRating += entry.getValue() * UserImportance.get(entry.getKey());
			}
			
			HotelsMap.put(hotel.getId(), overallRating);
		}
		
		
		
		double importanceLifestyle = user1.getInterests().get("Lifestyle") / sumInterests;
		double importanceSport = user1.getInterests().get("Sport") / sumInterests;
		double importanceAbenteuer = user1.getInterests().get("Abenteuer") / sumInterests;
		double importanceFamilie = user1.getInterests().get("Familie") / sumInterests;
		double importanceKultur = user1.getInterests().get("Kultur") / sumInterests;
		
		
		
	}
	
}
