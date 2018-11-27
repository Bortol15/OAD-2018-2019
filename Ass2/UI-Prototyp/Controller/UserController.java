package Controller;
import Model.Customer;
import java.util.ArrayList;
import java.util.List;

import Model.Activity;
import Model.Customer;
import View.Interests;

public class UserController {
	
	
	public static void Interests()
	{	 
		Customer customer1 = new Customer();
		customer1.Interests.add(new Activity("Lifestyle"));
		customer1.Interests.add(new Activity("Sport"));
		customer1.Interests.add(new Activity("Abenteuer"));
		customer1.Interests.add(new Activity("Familie"));
		customer1.Interests.add(new Activity("Kultur"));
		
		new Interests(customer1).setVisible(true);
	}
	
	public static void Activities()
	{
		
	}

	
}
