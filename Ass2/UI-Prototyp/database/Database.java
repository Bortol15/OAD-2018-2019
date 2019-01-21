package database;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Category;
import Models.Destination;
import Models.DestinationInterest;
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
