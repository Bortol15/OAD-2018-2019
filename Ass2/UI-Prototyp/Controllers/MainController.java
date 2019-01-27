package Controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.hibernate.Session;

import Models.Evaluation;
import Models.Hotel;
import Models.HotelActivity;
import Models.TREC;
import ViewModels.CategorySlider;
import Views.*;
import database.Database;

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
		JTable table = new JTable();
		Session session = Database.getSession();
		String[] header = new String[1];
		DefaultTableModel table_model = new DefaultTableModel(header, 0);
		
		List<Evaluation> evas = Database.loadAllData(Evaluation.class, session);
		List<HotelActivity> hotelactivities = Database.loadAllData(HotelActivity.class, session);
		
		if(query == "5 hotels with the highest number of customer evaluations")
		{
			header = new String[2];
			header[0] = "Hotelname";
			header[1] = "Nr. of Evaluations";
			table_model = new DefaultTableModel(header, 0);
			
			Map<String, Integer> hotel_map = new HashMap<String,Integer>();
			for(Evaluation eva : evas)
			{
				String hotelname = eva.getHotel().getName();
				if(hotel_map.containsKey(hotelname))
					hotel_map.put(hotelname, hotel_map.get(hotelname) + 1);
				else
					hotel_map.put(hotelname, 1);
			}
			
			int map_size = hotel_map.size();
			
			for(int i = 0; i < map_size && i < 5; i++)
			{
				Map.Entry<String, Integer> maxEntry = null;
		
				for (Map.Entry<String, Integer> entry : hotel_map.entrySet())
				{
				    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
				    {
				        maxEntry = entry;
				    }
				}
				
				Object[] row = { maxEntry.getKey(), maxEntry.getValue()};
				table_model.addRow(row);
				hotel_map.remove(maxEntry.getKey());
			}
		}
		
		if(query == "5 hotels with the worst overall evaluations")
		{
			header = new String[2];
			header[0] = "Hotelname";
			header[1] = "Average Rating";
			table_model = new DefaultTableModel(header, 0);
			
			Map<String, Integer> hotel_evaluation_map = new HashMap<String, Integer>();
			Map<String, Integer> hotel_map_counter = new HashMap<String, Integer>();
			Map<String, Double> hotel_map_result = new HashMap<String, Double>();
			for(HotelActivity ha : hotelactivities)
			{
				String hotelname = ha.getHotel().getName();
				if(hotel_evaluation_map.containsKey(hotelname))
				{
					hotel_evaluation_map.put(hotelname, hotel_evaluation_map.get(hotelname) + ha.getValue());
					hotel_map_counter.put(hotelname, hotel_map_counter.get(hotelname) + 1);
				}
				else
				{
					hotel_evaluation_map.put(hotelname, ha.getValue());
					hotel_map_counter.put(hotelname, 1);
				}
			}
			
			for (Map.Entry<String, Integer> entry : hotel_evaluation_map.entrySet())
				hotel_map_result.put(entry.getKey(), (double) hotel_evaluation_map.get(entry.getKey()) / (double) hotel_map_counter.get(entry.getKey()));
			
			
			int map_size = hotel_map_result.size();
			for(int i = 0; i < map_size && i < 5; i++)
			{
				Map.Entry<String, Double> maxEntry = null;
				
				for (Map.Entry<String, Double> entry : hotel_map_result.entrySet())
				{
					if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) < 0)
					{
						maxEntry = entry;
					}
				}
				
				Object[] row = { maxEntry.getKey(), maxEntry.getValue()};
				table_model.addRow(row);
				hotel_map_result.remove(maxEntry.getKey());
				
			}
		}
		
		if(query == "5 hotels with the best overall evaluations")
		{
			header = new String[2];
			header[0] = "Hotelname";
			header[1] = "Average Rating";
			table_model = new DefaultTableModel(header, 0);
			
			Map<String, Integer> hotel_evaluation_map = new HashMap<String, Integer>();
			Map<String, Integer> hotel_map_counter = new HashMap<String, Integer>();
			Map<String, Double> hotel_map_result = new HashMap<String, Double>();
			for(HotelActivity ha : hotelactivities)
			{
				String hotelname = ha.getHotel().getName();
				if(hotel_evaluation_map.containsKey(hotelname))
				{
					hotel_evaluation_map.put(hotelname, hotel_evaluation_map.get(hotelname) + ha.getValue());
					hotel_map_counter.put(hotelname, hotel_map_counter.get(hotelname) + 1);
				}
				else
				{
					hotel_evaluation_map.put(hotelname, ha.getValue());
					hotel_map_counter.put(hotelname, 1);
				}
			}
			
			for (Map.Entry<String, Integer> entry : hotel_evaluation_map.entrySet())
				hotel_map_result.put(entry.getKey(), (double) hotel_evaluation_map.get(entry.getKey()) / (double) hotel_map_counter.get(entry.getKey()));
			
			
			int map_size = hotel_map_result.size();
			for(int i = 0; i < map_size; i++)
			{
				Map.Entry<String, Double> maxEntry = null;
		
				for (Map.Entry<String, Double> entry : hotel_map_result.entrySet())
				{
				    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
				    {
				        maxEntry = entry;
				    }
				}
				
				Object[] row = { maxEntry.getKey(), maxEntry.getValue()};
				table_model.addRow(row);
				hotel_map_result.remove(maxEntry.getKey());
				
			}
		}
		
		table = new JTable(table_model);
		
		new Statistics(table).setVisible(true);
	}
}






