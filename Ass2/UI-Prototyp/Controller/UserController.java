package Controller;
import Model.Customer;
import ViewModels.CategoriesViewModel;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import Model.Category;
import View.Activities;
import View.Interests;

public class UserController {
	
	Customer customer1 = new Customer();
	private static JSlider slider;
	private static JLabel lbl_name;
	private static JLabel lbl_value;

	
	public void ShowInterests()
	{	 	
		CategoriesViewModel categoriesViewModel = new CategoriesViewModel();
		customer1.Interests.clear();
		//load from DB
		customer1.Interests.add(new Category("Lifestyle",5));
		customer1.Interests.add(new Category("Sport", 3));
		customer1.Interests.add(new Category("Abenteuer", 4));
		customer1.Interests.add(new Category("Familie", 7));
		customer1.Interests.add(new Category("Kultur", 8));
		
		createCategoriesList(customer1.Interests,categoriesViewModel);
		new Interests(categoriesViewModel).setVisible(true);
	}
	
	public void saveInterests(CategoriesViewModel model)
	{
		//save into DB
	}
	
	public void saveActivities(CategoriesViewModel model)
	{
		//save into DB
	}
	
	public void ShowActivities()
	{	
		CategoriesViewModel categoriesViewModel = new CategoriesViewModel();
		customer1.Activities.clear();
		//load from DB
		customer1.Activities.add(new Category("Tennis",5));
		customer1.Activities.add(new Category("Schwimmen", 3));
		customer1.Activities.add(new Category("Sauna", 4));
		customer1.Activities.add(new Category("Museum", 7));
		customer1.Activities.add(new Category("Massage", 8));
		
		createCategoriesList(customer1.Activities,categoriesViewModel);
		new Activities(categoriesViewModel).setVisible(true);
	}
	
	public void createCategoriesList(List<Category> list, CategoriesViewModel model)
	{
		for(int i = 0; i < list.size(); i++)
		{
			String activity_name = list.get(i).name;
			
			lbl_name = new JLabel(list.get(i).name);
			lbl_name.setBounds(12, 53+i*20, 150, 15);
			model.NameLabels.put(activity_name, lbl_name);
			slider = new JSlider();
			slider.setName("slider_" + activity_name);
			slider.setMaximum(10);
			slider.setMinimum(0);
			slider.setBounds(160, 53+i*20, 114, 16);
			slider.setValue(list.get(i).value);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					JLabel temp_label = model.ValueLabels.get(activity_name);
					JSlider temp_slider = model.Sliders.get(activity_name);
					temp_label.setText(String.valueOf(temp_slider.getValue()));
				}
			});
			model.Sliders.put(activity_name, slider);
			
			lbl_value = new JLabel(String.valueOf(slider.getValue()));
			lbl_value.setBounds(300, 53+i*20, 80, 15);
			model.ValueLabels.put(list.get(i).name, lbl_value);
		}	
	}
}
