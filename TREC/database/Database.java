package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Category;
import Models.Destination;
import Models.DestinationInterest;
import Models.Evaluation;
import Models.Hotel;
import Models.HotelActivity;
import Models.User;
import Models.UserActivity;
import Models.UserInterest;

public class Database {

	private static SessionFactory sf;
	private static boolean loggedIn;
	
	private static Database singleton = new Database();
	
	
	private Database(){
    	Configuration conf = new Configuration();
    	conf.configure("/src/main/resources/hibernate.cfg.xml");
    	conf.addAnnotatedClass(User.class);
    	conf.addAnnotatedClass(Category.class);
    	conf.addAnnotatedClass(Hotel.class);
    	conf.addAnnotatedClass(Destination.class);
    	conf.addAnnotatedClass(HotelActivity.class);
    	conf.addAnnotatedClass(UserActivity.class);
    	conf.addAnnotatedClass(DestinationInterest.class);
    	conf.addAnnotatedClass(UserInterest.class);
    	conf.addAnnotatedClass(Evaluation.class);
    	Database.sf = conf.buildSessionFactory();
	}
	
	public static <T> List<T> loadAllData(Class<T> type, Session session)
	{
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	}
	
	public static List<String> loadAllUniqueActivities()
	{
		Session session = Database.getSession();
		List<HotelActivity> all_activities = Database.loadAllData(HotelActivity.class, session);
		Map<String, String> activity_map = new HashMap<String, String>();
		for(HotelActivity ha : all_activities)
		{
			if(!ha.isActivityEntry())
				continue;
			if(!activity_map.containsKey(ha.getName()));
				activity_map.put(ha.getName(), ha.getName());
		}
		session.close();
		List<String> uniqueactivities = new ArrayList<String>();
		for(String activity : activity_map.keySet())
			uniqueactivities.add(activity);
		return uniqueactivities;
	}
	
	public static Session getSession() {
		return sf.openSession();
	}
	
	public static void setLoggedIn(boolean loggedIn) {
		Database.loggedIn = loggedIn;
	}
	
	public static boolean loggedIn() {
		return Database.loggedIn;
	}
}
