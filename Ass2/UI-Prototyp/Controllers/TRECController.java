package Controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Category;
import Models.User;

public class TRECController {

    public static void main(String[] args) {
    	
//    	Configuration conf = new Configuration();
//    	conf.configure("/src/main/resources/hibernate.cfg.xml");
//    	conf.addAnnotatedClass(User.class);
//    	conf.addAnnotatedClass(Category.class);
//    	
//    	SessionFactory factory = conf.buildSessionFactory();
//    	Session session = factory.getCurrentSession();
//    	
//    	try
//    	{
//	    	Category cat = new Category("asdf", 10);
//	    	session.beginTransaction();
//	    	session.save(cat);
//	    	session.getTransaction().commit();
//    	}
//    	finally  
//    	{
//    		factory.close();
//    	}
    	
    	MainController.setupTREC();
        MainController.showIndex();
    }
}