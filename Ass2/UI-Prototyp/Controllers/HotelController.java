package Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import Models.Category;
import Models.Evaluation;
import Models.Hotel;
import Models.TREC;
import Views.Activities;
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
		hotel.Activities.add(new Category("Volleyball", 10));
		hotel.Activities.add(new Category("Schwimmen", 10));
		hotel.Activities.add(new Category("Geschichte", 8));
		hotel.Activities.add(new Category("Tennis", 7));
		
		
		List<Category> reviewedActivities1 = new ArrayList<Category>();
		reviewedActivities1.add(new Category("Volleyball", 8));
		reviewedActivities1.add(new Category("Schwimmen", 9));
		reviewedActivities1.add(new Category("Geschichte", 9));
		reviewedActivities1.add(new Category("Tennis", 4));
		reviewedActivities1.add(new Category("Sauna", 8));
		reviewedActivities1.add(new Category("Wandern", 4));
		
		List<Category> reviewedActivities2 = new ArrayList<Category>();
		reviewedActivities2.add(new Category("Volleyball", 6));
		reviewedActivities2.add(new Category("Schwimmen", 6));
		reviewedActivities2.add(new Category("Geschichte", 9));
		reviewedActivities2.add(new Category("Tennis", 8));
		reviewedActivities1.add(new Category("Sauna", 7));
		reviewedActivities1.add(new Category("Wandern", 7));
		
		Evaluation eva1 = new Evaluation();
		eva1.setCustomerName("Eva");
		eva1.setActivities(reviewedActivities1);
		eva1.setNightsSpend(4);
		eva1.setComment("blablabal..now comes a long long text\n");
		eva1.setDate(new Date());
		
		Evaluation eva2 = new Evaluation();
		eva2.setCustomerName("Adam");
		eva2.setActivities(reviewedActivities1);
		eva2.setNightsSpend(4);
		eva2.setComment("asdfasdfölkjölkjasdfasdfölkjölk\njasdfasdf");
		eva2.setDate(new Date());
		
		hotel.getEvaluations().add(eva1);
		hotel.getEvaluations().add(eva2);
		
		ShowHotel showHotel = new ShowHotel(hotel);
		showHotel.setVisible(true);
		TREC.getInstance().Frames.put("ShowHotel", showHotel);
	}

	public static void rateHotel() {

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
}