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
import ViewModels.CategorySlider;
import ViewModels.HotelViewModel;
import Views.Activities;
import Views.RateHotel;
import Views.Search;
import Views.ShowHotel;

public class HotelController {
	
	public static void showHotel(String whichHotel) {
		// Load right Hotel from DB
		List<Hotel> Result = new ArrayList<Hotel>();
		Result.add(new Hotel("Schlossberg Hotel", "Graz", "Österreich"));
		Result.add(new Hotel("Hotel Alpina", "Breil-Brigels", "Schweiz"));
		Result.add(new Hotel("Hôtel Lavaux", "Genfer-See", "Schweiz"));
		Result.add(new Hotel("Apartment Sole di Pola", "Pula", "Kroatien"));
		Result.add(new Hotel("Palacio Ca Sa Galesa", "Palma de Mallorca", "Spanien"));

		Hotel hotel = Result.stream().filter(p -> p.getName().equals(whichHotel)).findAny().get();
		hotel.getActivities().add(new Category("Volleyball", 10));
		hotel.getActivities().add(new Category("Schwimmen", 10));
		hotel.getActivities().add(new Category("Geschichte", 8));
		hotel.getActivities().add(new Category("Tennis", 7));
		
		
		List<Category> reviewedActivities1 = new ArrayList<Category>();
		reviewedActivities1.add(new Category("Volleyball", 8));
		reviewedActivities1.add(new Category("Schwimmen", 9));
		reviewedActivities1.add(new Category("Geschichte", 9));
		reviewedActivities1.add(new Category("Tennis", 4));
		reviewedActivities1.add(new Category("Sauna", 8));
		reviewedActivities1.add(new Category("Wandern", 4));
		
		Evaluation eva1 = new Evaluation();
		eva1.setCustomerName("Eva");
		eva1.setActivities(reviewedActivities1);
		eva1.setNightsSpend(4);
		eva1.setComment("blablabal..now comes a long long text\n");
		eva1.setDate(new Date());
		
		List<Category> reviewedActivities2 = new ArrayList<Category>();
		reviewedActivities2.add(new Category("Volleyball", 6));
		reviewedActivities2.add(new Category("Schwimmen", 6));
		reviewedActivities2.add(new Category("Geschichte", 9));
		reviewedActivities2.add(new Category("Tennis", 8));
		reviewedActivities1.add(new Category("Sauna", 7));
		reviewedActivities1.add(new Category("Wandern", 7));
		
		Evaluation eva2 = new Evaluation();
		eva2.setCustomerName("Adam");
		eva2.setActivities(reviewedActivities1);
		eva2.setNightsSpend(4);
		eva2.setComment("asdfasdfölkjölkjasdfasdfölkjölk\njasdfasdf");
		eva2.setDate(new Date());
		
		List<Category> reviewedActivities3 = new ArrayList<Category>();
		reviewedActivities3.add(new Category("Volleyball", 8));
		reviewedActivities3.add(new Category("Schwimmen", 9));
		reviewedActivities3.add(new Category("Geschichte", 9));
		reviewedActivities3.add(new Category("Tennis", 4));
		reviewedActivities3.add(new Category("Sauna", 8));
		reviewedActivities3.add(new Category("Wandern", 4));
		
		Evaluation eva3 = new Evaluation();
		eva3.setCustomerName("Eva");
		eva3.setActivities(reviewedActivities1);
		eva3.setNightsSpend(4);
		eva3.setComment("blablabal..now comes a long long text\n");
		eva3.setDate(new Date());
		
		hotel.getEvaluations().add(eva1);
		hotel.getEvaluations().add(eva2);
		hotel.getEvaluations().add(eva3);
		
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
		Result.add(new Hotel("Schlossberg Hotel", "Graz", "Österreich"));
		Result.add(new Hotel("Hotel Alpina", "Breil-Brigels", "Schweiz"));
		Result.add(new Hotel("Hôtel Lavaux", "Genfer-See", "Schweiz"));
		Result.add(new Hotel("Apartment Sole di Pola", "Pula", "Kroatien"));
		Result.add(new Hotel("Palacio Ca Sa Galesa", "Palma de Mallorca", "Spanien"));

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
	
	public static void maintainHotel(String hotelName)
	{
		TREC.getInstance().Frames.get("MaintainHotel").setVisible(true);
	}
}