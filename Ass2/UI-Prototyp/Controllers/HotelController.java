package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Models.Category;
import Models.Hotel;
import Models.TREC;
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

		Hotel hotel = Result.stream().filter(p -> p.Name.equals(whichHotel)).findAny().get();
		hotel.Activities.add(new Category("Volleyball", 10));
		hotel.Activities.add(new Category("Schwimmen", 10));
		hotel.Activities.add(new Category("Geschichte", 8));
		hotel.Activities.add(new Category("Tennis", 7));

		new ShowHotel(hotel).setVisible(true);
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
			data[i][0] = Result.get(i).Name;
			data[i][1] = Result.get(i).Destination;
			data[i][2] = Result.get(i).Country;
		}

		Search search = new Search(data);
		search.setVisible(true);
		TREC.getInstance().Frames.put("Search", search);
	}
}