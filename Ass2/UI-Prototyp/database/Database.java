package database;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Customer;

public class Database {

	private static SessionFactory sf;
	private static boolean loggedIn;
	
	private static Database singelton = new Database();
	
	private Database(){
		Configuration cfg = new Configuration();
    	File cfgFile = new File("hibernate.cfg.xml");
    	cfg.configure(cfgFile);
    	cfg.addAnnotatedClass(Customer.class);
    	Database.sf = cfg.configure().buildSessionFactory();
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
