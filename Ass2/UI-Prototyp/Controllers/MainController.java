package Controllers;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Models.TREC;
import ViewModels.CategorySlider;
import Views.*;

public class MainController {

	//load from Database
	
	public static void setupTREC()
	{
		Index index = new Index();
		Activities activities = new Activities();
		Interests interests = new Interests();
		Login login = new Login();
		RateHotel rateHotel = new RateHotel(null);
		RecommendationsCustomer recommendationsCustomer = new RecommendationsCustomer(null);
		Registration registration = new Registration();
		Search search = new Search();
		ShowHotel showHotel = new ShowHotel();
		Statistics statistics = new Statistics(null);
		MaintainHotel maintainHotel = new MaintainHotel();
		
		TREC.getInstance().Frames.put("Activities", activities);
		TREC.getInstance().Frames.put("Index", index);
		TREC.getInstance().Frames.put("Interests", interests);
		TREC.getInstance().Frames.put("Login", login);
		TREC.getInstance().Frames.put("RateHotel", rateHotel);
		TREC.getInstance().Frames.put("RecommendationsCustomer", recommendationsCustomer);
		TREC.getInstance().Frames.put("Registration", registration);
		TREC.getInstance().Frames.put("Search", search);
		TREC.getInstance().Frames.put("ShowHotel", showHotel);
		TREC.getInstance().Frames.put("Statistics", statistics);
		TREC.getInstance().Frames.put("MaintainHotel", maintainHotel);
	}
	
	public static void showIndex()
	{
		TREC.getInstance().Frames.get("Index").setVisible(true);
	}
	
	public static void createCategorySlider(Map<String, Integer> map, List<CategorySlider> CategorySliders)
	{
		int i = 0;
		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			JLabel name = new JLabel(entry.getKey());
			name.setBounds(12, 53+i*20, 140, 15);
			JSlider slider = new JSlider();
			slider.setMaximum(10);
			slider.setMinimum(0);
			slider.setBounds(150, 53+i*20, 114, 16);
			slider.setValue(entry.getValue());
			JLabel value_label = new JLabel(String.valueOf(slider.getValue()));
			value_label.setBounds(280, 53+i*20, 80, 15);
			
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					value_label.setText(String.valueOf(slider.getValue()));
				}
			});
			i++;
			CategorySliders.add(new CategorySlider(name, slider, value_label));
		}
	}
	
	public static void showStatistics(String query)
	{
		query = "asldfksaldf";
		String[] columnNames = new String[1];
		Object[][] data = new Object[1][1];
		
		if(query == "asldfksaldf")
		{
			columnNames = new String[]{"Vorname",
	                "Nachname",
	                "Anzahl Evaluierungen"
	                };
			
			 data = new Object[][]{
					{"Max","Mustermann", 5},
					{"Susi","Sonnenschein", 4},
					{"Christoph","Proß", 3},
				};
		}
		
		new Statistics(new JTable(data,columnNames)).setVisible(true);
	}
}






