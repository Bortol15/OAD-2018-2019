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
		customer1.Interests.clear();
		//load from DB
		customer1.Interests.add(new Category("Lifestyle",5));
		customer1.Interests.add(new Category("Sport", 3));
		customer1.Interests.add(new Category("Abenteuer", 4));
		customer1.Interests.add(new Category("Familie", 7));
		customer1.Interests.add(new Category("Kultur", 8));
		
		MainController.createCategorySlider(customer1.Interests,catSlider);
		
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
		customer1.Activities.clear();
		//load from DB
		customer1.Activities.add(new Category("Tennis",5));
		customer1.Activities.add(new Category("Schwimmen", 3));
		customer1.Activities.add(new Category("Sauna", 4));
		customer1.Activities.add(new Category("Museum", 7));
		customer1.Activities.add(new Category("Massage", 8));
		
		MainController.createCategorySlider(customer1.Activities,catSlider);
		
		Activities newActivities = new Activities(catSlider);
		newActivities.setVisible(true);
		TREC.getInstance().Frames.put("Interests", newActivities);
	}
}
