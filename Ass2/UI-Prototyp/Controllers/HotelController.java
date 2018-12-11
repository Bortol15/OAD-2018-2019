package Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Models.Category;
import Models.Evaluation;
import Models.Hotel;
import Models.TREC;
import Models.User;
import ViewModels.CategorySlider;
import ViewModels.HotelViewModel;
import Views.Activities;
import Views.MaintainHotel;
import Views.RateHotel;
import Views.Search;
import Views.ShowHotel;

public class HotelController {
	
	public static void showHotel(String whichHotel) {
		// Load right Hotel from DB
		List<Hotel> Result = new ArrayList<Hotel>();
		fillHotelListWithDummyData(Result);

		Hotel hotel = Result.stream().filter(p -> p.getName().equals(whichHotel)).findAny().get();
		fillHotelWithDummyData(hotel);
		
		ShowHotel showHotel = new ShowHotel(hotel);
		showHotel.setVisible(true);
		TREC.getInstance().Frames.put("ShowHotel", showHotel);
	}

	public static void rateHotel(Hotel hotel)
	{
		List<Category> Activities = hotel.getActivities();
		
		for(Category elem : Activities)
			elem.Value = 5;
		HotelViewModel model = new HotelViewModel();
		MainController.createCategorySlider(Activities, model.CategorySliders);
		model.HotelName = hotel.getName();
		model.evaluation = new Evaluation();
		RateHotel rate_hotel = new RateHotel(model);
		
		rate_hotel.setVisible(true);
		TREC.getInstance().Frames.put("RateHotel", rate_hotel);
	}
	
	public static void submitEvaluation(HotelViewModel model)
	{
		//Save Evaluation in DB
		//Add Evaluation to Hotel
		//Adjust Hotel Rating
		//Show Hotel
	}

	public static void searchHotels(String SearchString) {
		// SELECT * FROM Hotels WHERE name = Searchstring OR destination = Searchstring
		// or Country = Searchstring
		// also name LIKE Searchstring% and name LIKE %Searchstring and name LIKE
		// %Searchstring% ...

		List<Hotel> Result = new ArrayList<Hotel>();
		fillHotelListWithDummyData(Result);

		if (Result.isEmpty()) {
			Search search = new Search(null);
			search.setVisible(true);
			TREC.getInstance().Frames.put("Search", search);
			return;
		}

		Object[][] data = new Object[Result.size()][3];
		for (int i = 0; i < Result.size(); i++) {
			data[i][0] = Result.get(i).getName();
			data[i][1] = Result.get(i).getDestination();
			data[i][2] = Result.get(i).getCountry();
		}

		Search search = new Search(data);
		search.setVisible(true);
		TREC.getInstance().Frames.put("Search", search);
	}
	
	public static void maintainHotel(Hotel hotel)
	{
		hotel.getActivities().clear();
		hotel.getEvaluations().clear();
		fillHotelWithDummyData(hotel);
		MaintainHotel maintainHotel = new MaintainHotel(hotel);
		maintainHotel.setVisible(true);
		TREC.getInstance().Frames.put("MaintainHotel", maintainHotel);
	}
	
	public static void deleteEvaluation(Evaluation evaluation)
	{
		// Delete Evaluation from DB
		// load User again
		Hotel hotel = new Hotel("Schlossberg Hotel", "Graz", "Österreich", "Kaiser-Franz-Josef-Kai 30, 8010 Graz", 4);
		fillHotelWithDummyData(hotel);
		hotel.getEvaluations().remove(0);
		TREC.getInstance().Frames.put("MaintainHotel", new MaintainHotel(hotel));
		TREC.getInstance().Frames.get("MaintainHotel").setVisible(true);
	}
	
	public static void fillHotelListWithDummyData(List<Hotel> hotels) // for testing
	{
		hotels.add(new Hotel("Schlossberg Hotel", "Graz", "Österreich", "Kaiser-Franz-Josef-Kai 30, 8010 Graz", 4));
		hotels.add(new Hotel("Hotel Alpina", "Breil-Brigels", "Schweiz", "Dorfplatz, 7165 Breil-Brigels", 3));
		hotels.add(new Hotel("Hôtel Lavaux", "Genfer-See", "Schweiz", "Route Cantonale 51, 1096 Bourg-en-Lavaux", 4));
		hotels.add(new Hotel("Apartment Sole di Pola", "Pula", "Kroatien","Rikarda Katalinića Jeretova 40, 52100 Pula", 3));
		hotels.add(new Hotel("Palacio Ca Sa Galesa", "Palma de Mallorca", "Spanien", "Carrer de Miramar 8, 07001 Palma", 5));
	}
	
	public static void addActivity(String activity)
	{
		Hotel hotel = new Hotel("Schlossberg Hotel", "Graz", "Österreich", "Kaiser-Franz-Josef-Kai 30, 8010 Graz", 4);
		hotel.getActivities().clear();
		hotel.getEvaluations().clear();
		fillHotelWithDummyData(hotel);
		hotel.getActivities().add(new Category(activity, 5));
		MaintainHotel maintainHotel = new MaintainHotel(hotel);
		maintainHotel.setVisible(true);
		TREC.getInstance().Frames.put("MaintainHotel", maintainHotel);
	}
	
	public static void deleteActivity(Category activity)
	{
		Hotel hotel = new Hotel("Schlossberg Hotel", "Graz", "Österreich", "Kaiser-Franz-Josef-Kai 30, 8010 Graz", 4);
		hotel.getActivities().clear();
		hotel.getEvaluations().clear();
		fillHotelWithDummyData(hotel);
		hotel.getActivities().remove(0);
		MaintainHotel maintainHotel = new MaintainHotel(hotel);
		maintainHotel.setVisible(true);
		TREC.getInstance().Frames.put("MaintainHotel", maintainHotel);
	}
	
	
	public static void fillHotelWithDummyData(Hotel hotel) // for testing
	{
		hotel.getActivities().add(new Category("Volleyball", 10));
		hotel.getActivities().add(new Category("Swimming", 10));
		hotel.getActivities().add(new Category("History", 8));
		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
//		hotel.getActivities().add(new Category("Tennis", 7));
		
		
		List<Category> reviewedActivities1 = new ArrayList<Category>();
		reviewedActivities1.add(new Category("Volleyball", 8));
		reviewedActivities1.add(new Category("Swimming", 9));
		reviewedActivities1.add(new Category("History", 9));
		reviewedActivities1.add(new Category("Tennis", 4));
		reviewedActivities1.add(new Category("Sauna", 8));
		reviewedActivities1.add(new Category("Hiking", 4));
		
		Evaluation eva1 = new Evaluation();
		eva1.setCustomerName("Eva");
		eva1.setActivities(reviewedActivities1);
		eva1.setNightsSpend(4);
		eva1.setComment("blablabal..now comes a long long text\n");
		eva1.setDate(new Date());
		
		List<Category> reviewedActivities2 = new ArrayList<Category>();
		reviewedActivities2.add(new Category("Volleyball", 6));
		reviewedActivities2.add(new Category("Swimming", 6));
		reviewedActivities2.add(new Category("History", 9));
		reviewedActivities2.add(new Category("Tennis", 8));
		reviewedActivities1.add(new Category("Sauna", 7));
		reviewedActivities1.add(new Category("Hiking", 7));
		
		Evaluation eva2 = new Evaluation();
		eva2.setCustomerName("Adam");
		eva2.setActivities(reviewedActivities1);
		eva2.setNightsSpend(4);
		eva2.setComment("asdfasdfölkjölkjasdfasdfölkjölk\njasdfasdf");
		eva2.setDate(new Date());
		
		List<Category> reviewedActivities3 = new ArrayList<Category>();
		reviewedActivities3.add(new Category("Volleyball", 8));
		reviewedActivities3.add(new Category("Swimming", 9));
		reviewedActivities3.add(new Category("History", 9));
		reviewedActivities3.add(new Category("Tennis", 4));
		reviewedActivities3.add(new Category("Sauna", 8));
		reviewedActivities3.add(new Category("Hiking", 4));
		
		Evaluation eva3 = new Evaluation();
		eva3.setCustomerName("Eva");
		eva3.setActivities(reviewedActivities1);
		eva3.setNightsSpend(4);
		eva3.setComment("blablabal..now comes a long long text\n");
		eva3.setDate(new Date());
		
		hotel.getEvaluations().add(eva1);
		hotel.getEvaluations().add(eva2);
		hotel.getEvaluations().add(eva3);
	}
}



