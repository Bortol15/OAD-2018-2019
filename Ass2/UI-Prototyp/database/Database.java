package database;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Category;
import Models.Customer;
import Models.User;

public class Database {

	private static SessionFactory sf;
	private static boolean loggedIn;
	
	private static Database singelton = new Database();
	
	private Database(){
    	Configuration conf = new Configuration();
    	conf.configure("/src/main/resources/hibernate.cfg.xml");
    	conf.addAnnotatedClass(User.class);
    	conf.addAnnotatedClass(Category.class);
    	Database.sf = conf.buildSessionFactory();
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
