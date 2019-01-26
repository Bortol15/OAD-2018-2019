package Controllers;

import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Models.DestinationInterest;
import Models.Hotel;
import Models.TREC;
import Models.User;
import Models.UserActivity;
import Models.UserInterest;
import Views.Index;
import Views.Login;
import Views.Registration;
import database.Database;

public class AuthenticationController {

	public static void login()
	{	
		Login login = (Login) TREC.getInstance().Frames.get("Login");

		TREC trec = TREC.getInstance();
		
		if(trec.getCurrentLoggedInUser() != null)
		{
			trec.setCurrentLoggedInUser(null);
			trec.Frames.get("Index").dispose();
			Index index = new Index();
			index.lbl_user_logged_in.setText("");
			index.getLogin().setText("Login");
			trec.Frames.put("Index", index);
			index.setVisible(true);
		}
		else
		{
			login.getEmail().setText("");
			login.getPassword().setText("");
			login.setVisible(true);
		}
	}
	
	public static boolean checkLogin(String email, String password) {

		TREC trec = TREC.getInstance();
		Index index = (Index) trec.Frames.get("Index");
		trec.Frames.put("Index", index);
		Session session = Database.getSession();
		
		@SuppressWarnings("deprecation")
		User user = (User) session.createCriteria(User.class)
				.add(Restrictions.eq("EMail", email)).uniqueResult();
		

		session.close();
		if (user != null && user.getPassword().equals(password))
		{
			Session session2 = Database.getSession();
			Database.setLoggedIn(true);
			List<Hotel> all_hotels = Database.loadAllData(Hotel.class, session2);
			for(Hotel hotel : all_hotels)
			{
				if(hotel.getOwner() != null && hotel.getOwner().getUserId() == user.getUserId())
					user.getHotels().add(hotel);
			}
			trec.setCurrentLoggedInUser(user);
			session2.close();
		} 
		else
		{
			System.out.println("Something wrong");
		}		
		
		if(trec.getCurrentLoggedInUser() != null)
		{						
			trec.Frames.get("Index").dispose();
			index = new Index();
			index.lbl_user_logged_in.setText(user.getFirstname() == null || user.getFirstname().isEmpty() ? "Welcome " + user.getEMail()+"!":"Welcome " + user.getFirstname()+"!");
			index.getLogin().setText("Logout");
			trec.Frames.put("Index", index);
			index.setVisible(true);
			trec.Frames.get("Login").dispose();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void showRegistration()
	{
		new Registration().setVisible(true);
	}
	
	
	public static boolean checkValidity(String email, String password, String repeat_password, String user_type)
	{
		return !(email.isEmpty() || password.isEmpty() || repeat_password.isEmpty() || user_type.isEmpty() || 
		   !Objects.equals(password, repeat_password));
	}
	
	public static void register(User user)
	{
		Session sess = Database.getSession();
		sess.save(user);
		List<String> activities = Database.loadAllUniqueActivities();
		for(String activity : activities)
		{
			sess.save(new UserActivity(activity, 5, user));
		}
		sess.save(new UserInterest("Lifestyle", 5, user));
		sess.save(new UserInterest("Sport", 5, user));
		sess.save(new UserInterest("Abenteuer", 5, user));
		sess.save(new UserInterest("Familie", 5, user));
		sess.save(new UserInterest("Kultur", 5, user));
		
		sess.close();
		
		JOptionPane.showMessageDialog(null, "Registration successfull!");
	}
}


