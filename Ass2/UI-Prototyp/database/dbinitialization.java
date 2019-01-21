package database;

import java.util.ArrayList;
import java.util.List;
import Models.Destination;
import Models.DestinationInterest;
import Models.Hotel;
import Models.HotelActivity;
import Models.User;
import Models.UserActivity;
import Models.UserInterest;

public class dbinitialization {
	
	public static void fillDatabase()
	{
		List<Hotel> hotels = new ArrayList<Hotel>();
		List<Destination> destinations = new ArrayList<Destination>();
		List<User> users = new ArrayList<User>();
		List<HotelActivity> hotelactivities = new ArrayList<HotelActivity>();
		List<UserActivity> useractivities = new ArrayList<UserActivity>();
		List<DestinationInterest> destinationinterests = new ArrayList<DestinationInterest>();
		List<UserInterest> userinterests = new ArrayList<UserInterest>();

		Destination linz = new Destination("Linz", "Austria");
		Destination graz = new Destination("Graz", "Austria");
		destinations.add(linz);
		destinations.add(graz);
		
		Hotel hotel_park_inn = new Hotel("Hotel Park Inn", linz, "Hessenplatz", 4);
		Hotel arcotel_nike = new Hotel("Arcotel Nike", linz, "Rathausviertel", 4);
		Hotel hotel_donauwelle = new Hotel("Hotel Donauwelle", linz, "Hafenviertel", 4);
		Hotel hotel_schillerpark = new Hotel("Hotel Schillerpark", linz, "Schillerpark", 4);
		Hotel prielmayerhof = new Hotel("Prielmayerhof", linz, "Kaplanhofviertel", 4);
		Hotel domhotel = new Hotel("Domhotel", linz, "Altstadtviertel", 4);
		Hotel city_hotel = new Hotel("City Hotel", linz, "Neustadtviertel", 4);
		Hotel hotel_spitz = new Hotel("Hotel Spitz", linz, "Alturfahr", 4);
		Hotel hotel_goldener_adler = new Hotel("Hotel Goldener Adler", linz, "Alturfahr", 3);
		Hotel hotel_ibis = new Hotel("Hotel Ibis", linz, "Hauptbahnhof", 3);
		hotels.add(hotel_park_inn);
		hotels.add(arcotel_nike);
		hotels.add(hotel_donauwelle);
		hotels.add(hotel_schillerpark);
		hotels.add(prielmayerhof);
		hotels.add(domhotel);
		hotels.add(city_hotel);
		hotels.add(hotel_spitz);
		hotels.add(hotel_goldener_adler);
		hotels.add(hotel_ibis);
		
		destinationinterests.add(new DestinationInterest("Lifestyle",8, linz));
		destinationinterests.add(new DestinationInterest("Sport",6, linz));
		destinationinterests.add(new DestinationInterest("Abenteuer",8, linz));
		destinationinterests.add(new DestinationInterest("Familie",5, linz));
		destinationinterests.add(new DestinationInterest("Kultur", 8, linz));
		
		destinationinterests.add(new DestinationInterest("Lifestyle", 3, graz));
		destinationinterests.add(new DestinationInterest("Sport",8, graz));
		destinationinterests.add(new DestinationInterest("Abenteuer",8, graz));
		destinationinterests.add(new DestinationInterest("Familie",2, graz));
		destinationinterests.add(new DestinationInterest("Kultur", 8, graz));
		
		hotelactivities.add(new HotelActivity("Schwimmen", 4, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Klettern",6, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Museen",8, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Tierpark",5, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Einkaufszentrum", 8, hotel_park_inn));
		
		hotelactivities.add(new HotelActivity("Schwimmen", 3, arcotel_nike));
		hotelactivities.add(new HotelActivity("Klettern",8, arcotel_nike));
		hotelactivities.add(new HotelActivity("Museen",8, arcotel_nike));
		hotelactivities.add(new HotelActivity("Tierpark",2, arcotel_nike));
		hotelactivities.add(new HotelActivity("Einkaufszentrum", 8, arcotel_nike));
		
		User user1 = new User("root","root");
		useractivities.add(new UserActivity("Einkaufszentrum", 9, user1));
		useractivities.add(new UserActivity("Schwimmen",3, user1));
		useractivities.add(new UserActivity("Klettern",4, user1));
		useractivities.add(new UserActivity("Tierpark",3, user1));
		useractivities.add(new UserActivity("Museen",4, user1));
		
		userinterests.add(new UserInterest("Lifestyle",4, user1));
		userinterests.add(new UserInterest("Sport",7, user1));
		userinterests.add(new UserInterest("Abenteuer",8, user1));
		userinterests.add(new UserInterest("Familie",3, user1));
		userinterests.add(new UserInterest("Kultur",7, user1));
		
		org.hibernate.Session sess = Database.getSession();	
		
		for(Destination destination: destinations)
			sess.save(destination);	
		
		for(Hotel hotel: hotels)
			sess.save(hotel);
		
		for(User user: users)
			sess.save(user);
		
		for(DestinationInterest destinationinterest: destinationinterests)
			sess.save(destinationinterest);
		
		for(UserInterest userinterest: userinterests)
			sess.save(userinterest);
		
		for(HotelActivity hotelactivity: hotelactivities)
			sess.save(hotelactivity);
		
		for(UserActivity useractivity: useractivities)
			sess.save(useractivity);

		sess.close();
	}
}
