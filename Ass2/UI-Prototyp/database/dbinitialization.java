package database;

import java.util.ArrayList;
import java.util.List;

import Models.Category;
import Models.Destination;
import Models.Hotel;
import Models.HotelActivity;
import Models.User;

public class dbinitialization {
	
	public static void fillDatabase()
	{
		//name, destination, country, address, stars
		List<Hotel> hotels = new ArrayList<Hotel>();

		Destination dest1 = new Destination(1, "Linz", "Austria");
		Destination dest2 = new Destination(2, "Graz", "Austria");
		hotels.add(new Hotel("Hotel Park Inn", dest1, "Hessenplatz", 4));
		hotels.add(new Hotel("Arcotel Nike", dest1, "Rathausviertel", 4));
		hotels.add(new Hotel("Hotel Donauwelle", dest1, "Hafenviertel", 4));
		hotels.add(new Hotel("Hotel Schillerpark", dest1, "Schillerpark", 4));
		hotels.add(new Hotel("Prielmayerhof", dest1, "Kaplanhofviertel", 4));
		hotels.add(new Hotel("Domhotel", dest1, "Altstadtviertel", 4));
		hotels.add(new Hotel("City Hotel", dest1, "Neustadtviertel", 4));
		hotels.add(new Hotel("Hotel Spitz", dest1, "Alturfahr", 4));
		hotels.add(new Hotel("Hotel Goldener Adler", dest1, "Alturfahr", 3));
		hotels.add(new Hotel("Hotel Ibis", dest1, "Hauptbahnhof", 3));
		HotelActivity ha1 = new HotelActivity("asdf", 3, hotels.get(0));
		
		User user = new User("asdf", "asdf2", "asdf3");

		org.hibernate.Session sess = Database.getSession();	
		
		for(Hotel hotel: hotels)
			sess.save(hotel);
		sess.save(dest1);
		sess.save(dest2);
		sess.save(ha1);
		sess.save(user);
		
		sess.close();
		
	}
}
