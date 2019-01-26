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
		session.close();
		
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
		session.close();
	}
	
	public void saveActivities(List<CategorySlider> catSlider)
	{
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		List<UserActivity> all_activities = Database.loadAllData(UserActivity.class, session);
		Map<String, UserActivity> activity_map = new HashMap<String, UserActivity>();
		
		for(UserActivity ua : all_activities)
			if(ua.getUser().getUserId() == user1.getUserId())
				activity_map.put(ua.getName(), ua);
		
		for(CategorySlider cat : catSlider)
		{
			UserActivity ua = activity_map.get(cat.Name.getText());
			ua.setValue(Integer.parseInt(cat.Value.getText()));
			session.update(ua);
		}
		trans.commit();	
		session.close();
	}
	
	public void ShowActivities()
	{	
		List<CategorySlider> catSlider = new ArrayList<CategorySlider>();
		
		Session session = Database.getSession();
		List<UserActivity> all_activities = Database.loadAllData(UserActivity.class, session);
		session.close();
		
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
	
	public static void updateAllUserActivities()
	{
		Session session = Database.getSession();
		List<User> users = Database.loadAllData(User.class, session);
		List<User> customers = new ArrayList<User>();
		
		for(User user : users)
		{
			if(!user.getIs_admin())
				updateUserActivities(user.getUserId());
		}
	}
	
	public static void updateUserActivities(int user_id)
	{
		Session session = Database.getSession();
		User user = session.get(User.class, user_id);
		List<UserActivity> all_useractivities= Database.loadAllData(UserActivity.class, session);
		Map<String,UserActivity> specific_useractivities = new HashMap<String,UserActivity>();
		Map<String, String> unique_activities = new HashMap<String, String>();
		for(UserActivity ua : all_useractivities)
		{
			if(ua.getUser().getUserId() == user_id)
				specific_useractivities.put(ua.getName(), ua);
		}
		
		for(String activity : Database.loadAllUniqueActivities())
			unique_activities.put(activity, activity);
		
		for(String activity_which_should_exist : unique_activities.keySet())
		{
			if(!specific_useractivities.containsKey(activity_which_should_exist))
				session.save(new UserActivity(activity_which_should_exist, 5, user));
		}
		
		for(String activity_which_exists : specific_useractivities.keySet())
		{
			if(!unique_activities.containsKey(activity_which_exists))
			{
				Transaction trans = session.beginTransaction();
				session.delete(specific_useractivities.get(activity_which_exists));
				trans.commit();
			}
		}
		
		session.close();
	}
}
