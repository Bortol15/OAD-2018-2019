package Controllers;
import ViewModels.CategorySlider;
import Views.Activities;
import Views.Interests;
import database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Models.Customer;
import Models.Hotel;
import Models.TREC;
import Models.User;
import Models.UserActivity;
import Models.UserInterest;

public class UserController {
	
	User user1 = TREC.getInstance().getCurrentLoggedInUser();
	public void ShowInterests()
	{	 	
		List<CategorySlider> catSlider = new ArrayList<CategorySlider>();

		Session session = Database.getSession();
		List<UserInterest> all_interests = Database.loadAllData(UserInterest.class, session);
		
		for(UserInterest ui : all_interests)
		{
			if(ui.getUser() != null && ui.getUser().getUserId() == user1.getUserId())
				user1.getInterests().put(ui.getName(), ui.getValue());
		}
		
		MainController.createCategorySlider(user1.getInterests(),catSlider);
		
		Interests newInterests = new Interests(catSlider);
		newInterests.setVisible(true);
		TREC.getInstance().Frames.put("Interests", newInterests);
	}
	
	public void saveInterests(List<CategorySlider> catSlider)
	{
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		List<UserInterest> all_interests = Database.loadAllData(UserInterest.class, session);
		Map<String, UserInterest> interest_map = new HashMap<String, UserInterest>();
		
		for(UserInterest ui : all_interests)
			interest_map.put(ui.getName(), ui);
		
		for(CategorySlider cat : catSlider)
		{
			UserInterest ui = interest_map.get(cat.Name.getText());
			ui.setValue(Integer.parseInt(cat.Value.getText()));
			session.update(ui);
		}
		trans.commit();	
	}
	
	public void saveActivities(List<CategorySlider> catSlider)
	{
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		List<UserActivity> all_activities = Database.loadAllData(UserActivity.class, session);
		Map<String, UserActivity> activity_map = new HashMap<String, UserActivity>();
		
		for(UserActivity ua : all_activities)
			activity_map.put(ua.getName(), ua);
		
		for(CategorySlider cat : catSlider)
		{
			UserActivity ua = activity_map.get(cat.Name.getText());
			ua.setValue(Integer.parseInt(cat.Value.getText()));
			session.update(ua);
		}
		trans.commit();	
	}
	
	public void ShowActivities()
	{	
		List<CategorySlider> catSlider = new ArrayList<CategorySlider>();
		
		Session session = Database.getSession();
		List<UserActivity> all_activities = Database.loadAllData(UserActivity.class, session);
		
		for(UserActivity ua : all_activities)
		{
			if(ua.getUser() != null && ua.getUser().getUserId() == user1.getUserId())
				user1.getActivities().put(ua.getName(), ua.getValue());
		}
		
		MainController.createCategorySlider(user1.getActivities(),catSlider);
		
		Activities newActivities = new Activities(catSlider);
		newActivities.setVisible(true);
		TREC.getInstance().Frames.put("Activities", newActivities);
	}
}
