package Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Models.Category;
import Models.Destination;
import Models.Evaluation;
import Models.Hotel;
import Models.HotelActivity;
import Models.TREC;
import Models.User;
import Models.UserActivity;
import ViewModels.HotelViewModel;
import ViewModels.MaintainHotelModel;
import ViewModels.NewHotelModel;
import ViewModels.SearchViewModel;
import Views.Index;
import Views.MaintainHotel;
import Views.NewHotel;
import Views.RateHotel;
import Views.Search;
import Views.ShowHotel;
import database.Database;

public class HotelController {
	
	public static void showNewHotel()
	{
		NewHotelModel model = new NewHotelModel();
		Session session = Database.getSession();
		List<Destination> all_destinations = Database.loadAllData(Destination.class, session);
		for(Destination dest : all_destinations)
			model.destinations.put(dest.getId(), dest);
		
		session.close();
		new NewHotel(model).setVisible(true);
	}
	
	public static void saveNewHotel(Hotel hotel)
	{
		User user = TREC.getInstance().getCurrentLoggedInUser();
		Index index = (Index) TREC.getInstance().Frames.get("Index");
		index.cbx_MaintainHotel.addItem(hotel);
		user.getHotels().add(hotel);
		
		hotel.setOwner(user);
		Session session = Database.getSession();
		session.save(hotel);
		session.close();
	}
	
	public static void showHotel(int id)
	{
		Hotel hotel = loadHotel(id);
		Map<String, Integer> rated_activities = RecommendationController.calculateHotelRating(hotel.getEvaluations());
		for(Map.Entry<String, Integer> entry : rated_activities.entrySet())
		{
			if(hotel.getActivities().containsKey(entry.getKey()))
				hotel.getActivities().put(entry.getKey(), entry.getValue());
		}
		
		ShowHotel showHotel = new ShowHotel(hotel);
		showHotel.setVisible(true);
		if(TREC.getInstance().getCurrentLoggedInUser() == null)
			showHotel.btnRate.setVisible(false);
		TREC.getInstance().Frames.put("ShowHotel", showHotel);
	}
	
	public static Hotel loadHotel(int id)
	{	
		Session session = Database.getSession();
		Hotel hotel = session.get(Hotel.class, id);
	    List<HotelActivity> hotelactivities = Database.loadAllData(HotelActivity.class, session);
	    Map<Integer, Evaluation> eval_map = new HashMap<Integer, Evaluation>();
		List<Evaluation> evaluations = Database.loadAllData(Evaluation.class, session);
		session.close();
		
	    for(Evaluation eva : evaluations) // select evaluations which belong to the hotel
	    {
	    	if(eva.getHotel().getId() == hotel.getId())
	    		eval_map.put(eva.getId(), eva);
	    }
	    
	    for(HotelActivity ha: hotelactivities) // feed the evaluations with activities
	    {
	    	if(ha.getHotel().getId() == hotel.getId())
	    	{
	    		if(!ha.isActivityEntry())
		    		eval_map.get(ha.getEvaluation().getId()).getActivities().add(ha);
	    		else
	    			hotel.getActivities().put(ha.getName(), ha.getValue());
	    	}
	    }
	    
	    for(Evaluation eva : eval_map.values()) // convert evaluations back to list
	    	hotel.getEvaluations().add(eva);
	    
	    return hotel;
	}
	
	public static void deleteHotel(Hotel hotel)
	{
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		session.delete(hotel);
		trans.commit();
		session.close();
		
		Index index = (Index) TREC.getInstance().Frames.get("Index");
	}

	public static void rateHotel(Hotel hotel)
	{
		HotelViewModel model = new HotelViewModel();
		model.hotel = hotel;
		for(Map.Entry<String, Integer> entry : model.hotel.getActivities().entrySet())
			entry.setValue(5);
		MainController.createCategorySlider(model.hotel.getActivities(), model.CategorySliders);
		new RateHotel(model).setVisible(true);
	}
	
	public static void submitEvaluation(HotelViewModel model)
	{
		model.evaluation.setHotel(model.hotel);
		User user = TREC.getInstance().getCurrentLoggedInUser();
		model.evaluation.setUser(user);
		model.evaluation.setDate(new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss").format(Calendar.getInstance().getTime()).toString());
		Session session = Database.getSession();
		session.save(model.evaluation);
		for(HotelActivity ua: model.evaluation.getActivities())
			session.save(ua);
		
		session.close();
		showHotel(model.hotel.getId());
	}

	public static void searchHotels(String searchstring)
	{
		Session session = Database.getSession();
		List<Hotel> all_hotels = Database.loadAllData(Hotel.class, session);
		session.close();
		List<Hotel> Result = new ArrayList<Hotel>();
		String regex = ".*" + searchstring.toLowerCase()+".*";
		
		for(Hotel hotel: all_hotels)
		{
			if(hotel.getName().toLowerCase().matches(regex) || 
				hotel.getDestination().getName().toLowerCase().matches(regex) || 
				hotel.getDestination().getCountry().toLowerCase().matches(regex))
				Result.add(hotel);
		}

		if (Result.isEmpty())
		{
			Search search = new Search(null);
			search.setVisible(true);
			TREC.getInstance().Frames.put("Search", search);
			return;
		}

		Object[][] data = new Object[Result.size()][4];
		for (int i = 0; i < Result.size(); i++)
		{
			data[i][0] = Result.get(i).getName();
			data[i][1] = Result.get(i).getDestination().getName();
			data[i][2] = Result.get(i).getDestination().getCountry();
			data[i][3] = Result.get(i).getId();
		}

		Search search = new Search(new SearchViewModel(data, searchstring));
		search.setVisible(true);
		TREC.getInstance().Frames.put("Search", search);
	}
	
	public static void maintainHotel(Hotel hotel)
	{
		MaintainHotelModel model = new MaintainHotelModel();
		model.hotel = loadHotel(hotel.getId());
		Session session = Database.getSession();
		List<Destination> all_destinations = Database.loadAllData(Destination.class, session);
		for(Destination dest : all_destinations)
			model.destinations.put(dest.getId(), dest);
		model.activities_suggestions = Database.loadAllUniqueActivities();
		session.close();
		new MaintainHotel(model).setVisible(true);
	}
	
	public static void saveHotelData(Hotel hotel)
	{
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		session.update(hotel);
		trans.commit();
		session.close();
//		maintainHotel(hotel);
	}
	
	public static void deleteEvaluation(Evaluation evaluation)
	{
		int hotelid = evaluation.getHotel().getId();
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		for(HotelActivity ha: evaluation.getActivities())
			session.delete(ha);
		session.delete(evaluation);
		trans.commit();
		Hotel hotel = session.load(Hotel.class, hotelid);
		session.close();
		maintainHotel(hotel);
	}
	
	
	public static void addActivity(String combobox_text, String textbox_text, Hotel hotel)
	{
		String add_activity = "";
		boolean update_user_activities_necessary = false;
		
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher_combobox = pattern.matcher(combobox_text);
		Matcher matcher_textbox = pattern.matcher(textbox_text);
		boolean combobox_valid = matcher_combobox.find();
		boolean textbox_valid = matcher_textbox.find();
		
		if(hotel.getActivities().size() >= 12)
		{
			maintainHotel(hotel);
			return;
		}
			
		if(combobox_valid) 
		{
			add_activity = combobox_text;
		}
		else if(textbox_valid)
		{
			add_activity = textbox_text;
			update_user_activities_necessary = true;
		}
		else
		{
			maintainHotel(hotel);
			return;
		}
		
		for(String key : hotel.getActivities().keySet())
		{
			if(key.equals(add_activity))
			{
				maintainHotel(hotel);
				return;
			}
		}
		
		HotelActivity ha = new HotelActivity(add_activity, true, hotel);
		Session session = Database.getSession();
		session.save(ha);
		session.close();
		if(update_user_activities_necessary == true)
			UserController.updateAllUserActivities();
		
		TREC.getInstance().Frames.get("MaintainHotel").dispose();
		maintainHotel(hotel);
	}
	
	public static void deleteActivity(String key, Hotel hotel)
	{
		Session session = Database.getSession();
		Transaction trans = session.beginTransaction();
		
		List<HotelActivity> activities = Database.loadAllData(HotelActivity.class, session);
		for(HotelActivity ha : activities)
		{
			if(ha.getName().equals(key) && ha.getHotel().getId()==(hotel.getId()))
			{
				session.delete(ha);
				break;
			}
		}
		
		trans.commit();
		session.close();
		UserController.updateAllUserActivities();
		maintainHotel(hotel);
	}
}



