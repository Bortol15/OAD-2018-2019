package Controllers;

import java.util.Objects;

import javax.swing.JOptionPane;

import Models.TREC;
import Models.User;
import Views.Index;
import Views.Login;
import Views.Registration;

public class AuthenticationController {

	public static void login()
	{
		TREC trec = TREC.getInstance();
		Index index = (Index) trec.Frames.get("Index");
		
		if(trec.currentLoggedInUser != null)
		{
			trec.currentLoggedInUser = null;
			index.getLogin().setText("Login");
			index.invalidate();
		    index.validate();
			index.repaint();
		}
		else
		{
			Login login = (Login) trec.Frames.get("Login");
			login.getEmail().setText("");
			login.getPassword().setText("");
			login.setVisible(true);
		}
	}
	
	public static boolean checkLogin(String email, String password) {

		TREC trec = TREC.getInstance();
		Index index = (Index) trec.Frames.get("Index");
		

		// check if user.email exist in DB
		// if yes, check if user.password is identically with the entry in the DB
		// then load user from DB
		User user = new User();
		
		boolean user_in_db = true;
		
		if(user_in_db)
		{
			trec.currentLoggedInUser = user;
			index.getLogin().setText("Logout");
			
			index.invalidate();
		    index.validate();
			index.repaint();
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
		//save User in DB
		JOptionPane.showMessageDialog(null, "Registration successfull!");
		TREC.getInstance().Frames.get("Registration").setVisible(false);
	}
}





