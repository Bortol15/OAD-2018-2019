package Controllers;
import ViewModels.CategorySlider;
import Views.Activities;
import Views.Interests;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Models.Category;
import Models.Customer;
import Models.TREC;

public class UserController {
	
	Customer customer1 = new Customer();
	
	public void ShowInterests()
	{	 	
		List<CategorySlider> catSlider = new ArrayList<CategorySlider>();
		//load from DB
		customer1.getInterests().put("Lifestyle",5);
		customer1.getInterests().put("Sport", 3);
		customer1.getInterests().put("Abenteuer", 4);
		customer1.getInterests().put("Familie", 7);
		customer1.getInterests().put("Kultur", 8);
		
		MainController.createCategorySlider(customer1.getInterests(),catSlider);
		
		Interests newInterests = new Interests(catSlider);
		newInterests.setVisible(true);
		TREC.getInstance().Frames.put("Interests", newInterests);
	}
	
	public void saveInterests(List<CategorySlider> catSlider)
	{
		//save into DB
	}
	
	public void saveActivities(List<CategorySlider> catSlider)
	{
		//save into DB
	}
	
	public void ShowActivities()
	{	
		List<CategorySlider> catSlider = new ArrayList<CategorySlider>();
		customer1.getActivities().clear();
		//load from DB
		customer1.getActivities().put("Tennis",5);
		customer1.getActivities().put("Schwimmen", 3);
		customer1.getActivities().put("Sauna", 4);
		customer1.getActivities().put("Museum", 7);
		customer1.getActivities().put("Massage", 8);
		
		MainController.createCategorySlider(customer1.getActivities(),catSlider);
		
		Activities newActivities = new Activities(catSlider);
		newActivities.setVisible(true);
		TREC.getInstance().Frames.put("Interests", newActivities);
	}
}
