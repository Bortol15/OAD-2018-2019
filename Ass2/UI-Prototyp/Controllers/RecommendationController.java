package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Models.Category;
import Models.Hotel;
import Models.User;



public class RecommendationController 
{
	
	public void calculateCustomerRecommendation()
	{
		Hotel hotel1 = new Hotel("Name", "Destination", "Country","Adress",4);
		Map<String, Integer> activities1 = new HashMap();
		activities1.put("Schwimmen", 4);
		activities1.put("Klettern",6);
		activities1.put("Museen",8);
		activities1.put("Tierpark",5);
		activities1.put("Einkaufszentrum", 8);

		
		Hotel hotel2 = new Hotel("Name", "Destination", "Country","Adress",4);
		Map<String, Integer> activities2 = new HashMap();
		hotel1.setActivities(activities2);
		activities2.put("Schwimmen", 7);
		activities2.put("Klettern",8);
		activities2.put("Museen",5);
		activities2.put("Tierpark",8);
		activities2.put("Einkaufszentrum", 7);

		
		Hotel hotel3 = new Hotel("Name", "Destination", "Country","Adress",4);
		Map<String, Integer> activities3 = new HashMap();
		hotel1.setActivities(activities3);
		activities3.put("Schwimmen", 9);
		activities3.put("Klettern",3);
		activities3.put("Museen",4);
		activities3.put("Tierpark",3);
		activities3.put("Einkaufszentrum", 5);
		
		
		User user1 = new User();
		Map<String, Integer> useractivities1 = new HashMap();
		user1.setActivities(useractivities1);
		useractivities1.put("Einkaufszentrum", 9);
		useractivities1.put("Schwimmen",3);
		useractivities1.put("Klettern",4);
		useractivities1.put("Tierpark",3);
		useractivities1.put("Museen",4);
		
		Map<String, Integer> interests1 = new HashMap();
		hotel1.setInterests(interests1);
		interests1.put("Lifestyle",8);
		interests1.put("Sport",5);
		interests1.put("Abenteuer",7);
		interests1.put("Familie",4);
		interests1.put("Kultur",4);
		
		Map<String, Integer> interests2 = new HashMap();
		hotel2.setInterests(interests2);
		interests2.put("Lifestyle",4);
		interests2.put("Sport",9);
		interests2.put("Abenteuer",10);
		interests2.put("Familie",1);
		interests2.put("Kultur",3);
		
		Map<String, Integer> interests3 = new HashMap();
		hotel3.setInterests(interests3);
		interests3.put("Lifestyle",7);
		interests3.put("Sport",7);
		interests3.put("Abenteuer",7);
		interests3.put("Familie",7);
		interests3.put("Kultur",7);
		
		Iterator it = user1.getInterests().entrySet().iterator();
		int sumInterests = 0;
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			sumInterests += (int)pair.getValue();
		}
	
		double importanceLifestyle = user1.getInterests().get("Lifestyle")/sumInterests;
		double importanceSport = user1.getInterests().get("Sport")/sumInterests;
		double importanceAbenteuer = user1.getInterests().get("Abenteuer")/sumInterests;
		double importanceFamilie = user1.getInterests().get("Familie")/sumInterests;
		double importanceKultur = user1.getInterests().get("Kultur")/sumInterests;
		
		
		
	}
	
}
