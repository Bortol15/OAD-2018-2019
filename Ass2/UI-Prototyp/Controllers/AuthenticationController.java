package Controllers;

import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.JOptionPane;

import org.hibernate.criterion.Restrictions;

import Models.TREC;
import Models.User;
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
		
		User user = (User) Database.getSession().createCriteria(User.class)
				.add(Restrictions.eq("EMail", email)).uniqueResult();
		if (user != null && user.getPassword().equals(password)) {
			Database.setLoggedIn(true);
			trec.setCurrentLoggedInUser(user);
		} else {
			System.out.println("Something wrong");
		}		
		
		if(trec.getCurrentLoggedInUser() != null)
		{						
			trec.Frames.get("Index").dispose();
			index = new Index();
			index.lbl_user_logged_in.setText("user logged in: " + user.getEMail());
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
		TREC trec = TREC.getInstance();
		Registration registration = (Registration) trec.Frames.get("Registration");
		registration.getEmail().setText("");
		registration.getFirstname().setText("");
		registration.getLastname().setText("");
		registration.getBirthdate().setText("");
		registration.getAdress().setText("");
		registration.getCountry().setText("");
		registration.getZIP().setText("");
		registration.setVisible(true);
		trec.Frames.get("Login").setVisible(false);
	}
	
	public static boolean checkValidity(String email, String password, String repeat_password, String user_type)
	{
		return !(email.isEmpty() || password.isEmpty() || repeat_password.isEmpty() || user_type.isEmpty() || 
		   !Objects.equals(password, repeat_password));
	}
	
	public static void register(User user)
	{
		org.hibernate.Session sess = Database.getSession();
		sess.save(user);
		sess.close();
		
		JOptionPane.showMessageDialog(null, "Registration successfull!");
		TREC.getInstance().Frames.get("Registration").setVisible(false);
	}
}





