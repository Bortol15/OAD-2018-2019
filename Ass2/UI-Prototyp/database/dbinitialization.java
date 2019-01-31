package database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import Controllers.UserController;
import Models.Destination;
import Models.DestinationInterest;
import Models.Evaluation;
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
		List<Evaluation> evaluations = new ArrayList<Evaluation>();

		
		User admin = new User("admin", "admin",true);
		User admin2 = new User("admin2", "admin2",true);
		User admin3 = new User("admin3", "admin3",true);
		User admin4 = new User("admin4", "admin4",true);
		User admin5 = new User("admin5", "admin5",true);
		
		User user1 = new User("root","root", false);
		User user2 = new User("root2","root2", false);
		User user3 = new User("root3","root3", false);
		User user4 = new User("root4","root4", false);
		User user5 = new User("root5","root5", false);
		User user6 = new User("root6","root6", false);
		User user7 = new User("root7","root7", false);
		User user8 = new User("root8","root8", false);
		User user9 = new User("root9","root9", false);
		User user10 = new User("root10","root10", false);
		User user11 = new User("root11","root11", false);
		User user12 = new User("root12","root12", false);
		User user13 = new User("root13","root13", false);
		User user14 = new User("root14","root14", false);
		User user15 = new User("root15","root15", false);
		User user16 = new User("root16","root16", false);
		User user17 = new User("root17","root17", false);
		User user18 = new User("root18","root18", false);
		User user19 = new User("root19","root19", false);
		User user20 = new User("root20","root20", false);
		User user21 = new User("root21","root21", false);
		User user22 = new User("root22","root22", false);
		User user23 = new User("root23","root23", false);
		User user24 = new User("root24","root24", false);
		User user25 = new User("root25","root25", false);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		users.add(user9);
		users.add(user10);
		users.add(user11);
		users.add(user12);
		users.add(user13);
		users.add(user14);
		users.add(user15);
		users.add(user16);
		users.add(user17);
		users.add(user18);
		users.add(user19);
		users.add(user20);
		users.add(user21);
		users.add(user22);
		users.add(user23);
		users.add(user24);
		users.add(user25);
		
		users.add(admin);
		users.add(admin2);
		users.add(admin3);
		users.add(admin4);
		users.add(admin5);
		
		Destination linz = new Destination("Linz", "Austria");
		Destination graz = new Destination("Graz", "Austria");
		Destination wien = new Destination("Wien", "Austria");
		Destination salzburg = new Destination("Salzburg", "Austria");
		Destination innsbruck = new Destination("Innsbruck", "Austria");
		
		Destination berlin = new Destination("Berlin", "Germany");
		Destination hamburg = new Destination("Hamburg", "Germany");
		Destination muenchen = new Destination("Muenchen", "Germany");
		
		Destination peking = new Destination("Peking", "China");
		Destination shanghai = new Destination("Shanghai", "China");
		
		Destination atlanta = new Destination("Atlanta", "USA");
		Destination chicago = new Destination("Chicago", "USA");
		
		Destination tokio = new Destination("Tokio", "Japan");
		Destination osaka = new Destination("Osaka", "Japan");
		
		Destination kairo = new Destination("Kairo", "Aegypten");
		Destination alexandria = new Destination("Alexandria", "Aegypten");
		
		Destination melbourne = new Destination("Melbourne", "Australien");
		Destination perth = new Destination("Perth", "Australien");
		
		Destination toronto = new Destination("Toronto", "Kanada");
		Destination montreal = new Destination("Montreal", "Kanada");
		
		destinations.add(linz);
		destinations.add(graz);
		destinations.add(wien);
		destinations.add(salzburg);
		destinations.add(innsbruck);
		destinations.add(berlin);
		destinations.add(hamburg);
		destinations.add(muenchen);
		destinations.add(peking);
		destinations.add(shanghai);
		destinations.add(atlanta);
		destinations.add(chicago);
		destinations.add(tokio);
		destinations.add(osaka);
		destinations.add(kairo);
		destinations.add(alexandria);
		destinations.add(melbourne);
		destinations.add(perth);
		destinations.add(toronto);
		destinations.add(montreal);
		
		
		Hotel hotel_park_inn = new Hotel("Hotel Park Inn", linz, "Hessenplatz", 4, admin);
		Hotel arcotel_nike = new Hotel("Arcotel Nike", linz, "Rathausviertel", 4, admin);
		Hotel hotel_donauwelle = new Hotel("Hotel Donauwelle", linz, "Hafenviertel", 4, admin);
		Hotel hotel_schillerpark = new Hotel("Hotel Schillerpark", linz, "Schillerpark", 4, admin2);
		Hotel prielmayerhof = new Hotel("Prielmayerhof", linz, "Kaplanhofviertel", 4, admin2);
		Hotel domhotel = new Hotel("Domhotel", linz, "Altstadtviertel", 4, admin2);
		Hotel city_hotel = new Hotel("City Hotel", linz, "Neustadtviertel", 4, admin2);
		Hotel hotel_spitz = new Hotel("Hotel Spitz", linz, "Alturfahr", 4, admin2);
		Hotel hotel_goldener_adler = new Hotel("Hotel Goldener Adler", linz, "Alturfahr", 3, admin2);
		Hotel hotel_ibis = new Hotel("Hotel Ibis", linz, "Hauptbahnhof", 3, admin2);
		
		Hotel lendhotel = new Hotel("Lendhotel", graz, "GrueneGasse", 2, admin3);
		Hotel hotel_daniel = new Hotel("Hotel Daniel", graz, "Europaplatz", 4, admin3);
		Hotel weitzer = new Hotel("Weitzer", graz, "Lendkai", 4, admin3);
		
		Hotel graben_hotel = new Hotel("Graben Hotel", wien, "Dorotheumsgasse", 4, admin3);
		Hotel pentahotel_vienna = new Hotel("Pentahotel Vienna", wien, "Margaretenstrasse", 3, admin3);
		Hotel ibis = new Hotel("Ibis", wien, "Hauptbahnhof", 3, admin3);
		Hotel regina = new Hotel("Hotel Regina", wien, "Rooseveltplatz", 4, admin3);
		
		Hotel hotel_sacher = new Hotel("Hotel Sacher", salzburg, "Schwarzstrasse", 5, admin4);
		Hotel auersperg = new Hotel("Hotel Auersberg", salzburg, "Auerspergstrasse", 4, admin4);
		Hotel bristol = new Hotel("Bristol Hotel", salzburg, "Makartplatz", 4, admin4);
		Hotel kasererbräu = new Hotel("Altstadthotel Kasererbräu", salzburg, "Kaigasse", 4, admin4);
		Hotel hofwirt = new Hotel("Hotel Hofwirt", salzburg, "Schallmoserstraße", 4, admin4);
		
		Hotel central = new Hotel("Hotel Central", innsbruck, "Gilmstrasse", 4, admin4);
		Hotel schwarzer_adler = new Hotel("Schwarzer Adler", innsbruck, "Kaiserjagerstrasse", 3, admin4);
		Hotel penz = new Hotel("The Penz Hotel", innsbruck, "Adolf-Pichler-Platz", 3, admin4);
		Hotel dollinger = new Hotel("Hotel Dollinger", innsbruck, "Haller Straße", 4, admin4);
		Hotel grand_europa = new Hotel("Grand Hotel Europa", innsbruck, "Seudtiroler Platz", 2, admin4);
		
		Hotel maritim = new Hotel("Maritim Hotel Berlin", berlin, "Stauffenbergstrasse", 3, admin4);
		Hotel mandela = new Hotel("The Mandela Hotel", berlin, "Potsdamer Straße", 3, admin4);
		Hotel pestana = new Hotel("Pestana Hotel Berlin", berlin, "Stuelerstrasse", 5, admin4);
		Hotel movenpick = new Hotel("Movenpick Hotel Berlin", berlin, "Schoenbergstrasse", 3, admin4);
		Hotel steigenberger = new Hotel("Steigenberger Hotel", berlin, "Gartenstrasse", 4, admin4);
		
		Hotel lindner = new Hotel("Lindner Hotel", hamburg, "Neanderstrasse", 3, admin4);
		Hotel parkhotel = new Hotel("Park Hotel", hamburg, "Borgfelderstrasse", 4, admin4);
		Hotel luckys = new Hotel("Luckys Hotel", hamburg, "Reeperbahn", 2, admin4);
		Hotel amplatz = new Hotel("Hotel am Platz", hamburg, "Neutorstrasse", 4, admin4);
		Hotel novum_style = new Hotel("Novum Style Hotel", hamburg, "Steindamm", 4, admin4);
		
		Hotel kings = new Hotel("King's Hotel", muenchen, "Marsstrasse", 3, admin);
		Hotel louis = new Hotel("Louis Hotel", muenchen, "Viktualienmarkt", 4, admin);
		Hotel platzl = new Hotel("Platzl Hotel", muenchen, "Sparkassenstrasse", 4, admin);
		Hotel torbraeu = new Hotel("Hotel Torbräu", muenchen, "Tal", 4, admin);
		Hotel eden = new Hotel("Eden Hotel", muenchen, "Arnulfstrasse", 4, admin);
		
		Hotel sunworld = new Hotel("Sunworld Dynasty Hotel", peking, "Wangfujing", 4, admin);
		Hotel peace = new Hotel("Peace Hotell", peking, "Jinboa", 4, admin2);
		Hotel xin_qiao = new Hotel("Xin Qiao Hotel", peking, "Chong Wen Men", 5, admin);
		Hotel shangri = new Hotel("Snagri Hotel", peking, "Zizhuayan", 4, admin);
		Hotel peninsula = new Hotel("Peninsula Hotel", peking, "Jian Gou Men Wai", 4, admin);

		Hotel kempinski = new Hotel("Kempinski Hotel", shanghai, "Lujiazui Road", 4, admin);
		Hotel four_seasons = new Hotel("Four Seasons Hotel", shanghai, "Weihai Road", 5, admin);
		Hotel sofitel = new Hotel("Sofitel Hyland", shanghai, "Nanjing Road", 4, admin);
		Hotel waldorf = new Hotel("Waldorf Astoria Hotel", shanghai, "Zhong Shan", 4, admin);
		Hotel dorsett = new Hotel("Dorsett Shanghai", shanghai, "Hua Mu Road", 3, admin);
		
		Hotel artmore = new Hotel("Artmore Hotel", atlanta, "West Peachtree Street", 3, admin5);
		Hotel loews = new Hotel("Loews Atlanta Hotel", atlanta, "Peachtree Street", 4, admin5);
		Hotel highland = new Hotel("The Highland Inn", atlanta, "North Hifland Avenue", 3, admin5);

		Hotel freehand = new Hotel("Freehand Chicago", chicago, "East Ohio Street", 4, admin5);
		Hotel virgin = new Hotel("Virgin Hotels", chicago, "Wabash", 4, admin5);
		Hotel viceroy = new Hotel("Viceroy Chicago", chicago, "North State Street", 3, admin5);

		Hotel nippon = new Hotel("Nippon Hotel", tokio, "Kasumigaoka cho", 4, admin5);
		Hotel keio = new Hotel("Keio Hotels", tokio, "Nishi-Shinjuku", 3, admin5);

		Hotel namba = new Hotel("Namba Oriental Hotel", osaka, "Sennichimae", 4, admin5);
		Hotel swissotel = new Hotel("Swissotel Osaka", osaka, "Chuo-ko", 5, admin5);

		Hotel safir = new Hotel("Safir Hotel", kairo, "Orman Square", 3, admin5);
		Hotel pyramids = new Hotel("3 Pyramids Hotel", kairo, "Abou Al Hool", 4, admin5);

		Hotel windsor = new Hotel("Windsor Place Hotel", alexandria, "El Shohada", 4, admin5);
		Hotel tolip = new Hotel("Tolip Alexandria", alexandria, "Moustafa", 5, admin4);
		
		Hotel oaks = new Hotel("Oaks On Market", melbourne, "Market Street", 4, admin4);
		Hotel causeway = new Hotel("Causeway 353 Hotel", melbourne, "Little Collins", 5, admin4);

		Hotel pensione = new Hotel("Pensione Hotel", perth, "Pier Street", 3, admin4);
		Hotel sage = new Hotel("Sage Perth", perth, "Adelaide Terrace", 3, admin4);

		Hotel thompson = new Hotel("Thompson Toronto", toronto, "Wellington Street", 4, admin4);
		Hotel bond = new Hotel("Bond Place Hotel", toronto, "King Street", 5, admin3);

		Hotel nelligan = new Hotel("Hotel Nelligan", montreal, "Paul Street", 4, admin3);
		Hotel omni = new Hotel("Hotel Omni Mont-Royal", montreal, "Sherbrooke", 4, admin3);
		Hotel crystal = new Hotel("Hotel Le Crystal", montreal, "rue de la Montagne", 5, admin3);

		hotels.add(crystal);
		hotels.add(oaks);
		hotels.add(causeway);
		hotels.add(pensione);
		hotels.add(sage);
		hotels.add(thompson);
		hotels.add(bond);
		hotels.add(nelligan);
		hotels.add(omni);
		hotels.add(windsor);
		hotels.add(tolip);
		hotels.add(safir);
		hotels.add(pyramids);
		hotels.add(namba);
		hotels.add(swissotel);
		hotels.add(nippon);
		hotels.add(keio);
		hotels.add(freehand);
		hotels.add(virgin);
		hotels.add(viceroy);
		hotels.add(artmore);
		hotels.add(loews);
		hotels.add(highland);
		hotels.add(kempinski);
		hotels.add(four_seasons);
		hotels.add(sofitel);
		hotels.add(waldorf);
		hotels.add(dorsett);
		hotels.add(sunworld);
		hotels.add(peace);
		hotels.add(xin_qiao);
		hotels.add(shangri);
		hotels.add(peninsula);
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
		hotels.add(lendhotel);
		hotels.add(hotel_daniel);
		hotels.add(weitzer);
		hotels.add(graben_hotel);
		hotels.add(pentahotel_vienna);
		hotels.add(ibis);
		hotels.add(regina);
		hotels.add(hotel_sacher);
		hotels.add(auersperg);
		hotels.add(bristol);
		hotels.add(kasererbräu);
		hotels.add(hofwirt);
		hotels.add(central);
		hotels.add(schwarzer_adler);
		hotels.add(penz);
		hotels.add(dollinger);
		hotels.add(maritim);
		hotels.add(mandela);
		hotels.add(pestana);
		hotels.add(movenpick);
		hotels.add(steigenberger);
		hotels.add(lindner);
		hotels.add(parkhotel);
		hotels.add(luckys);
		hotels.add(amplatz);
		hotels.add(novum_style);
		hotels.add(kings);
		hotels.add(louis);
		hotels.add(platzl);
		hotels.add(torbraeu);
		hotels.add(eden);
		
		
		
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
		
		hotelactivities.add(new HotelActivity("Schwimmen", true, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Klettern",true, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Museen",true, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Tierpark",true, hotel_park_inn));
		hotelactivities.add(new HotelActivity("Sauna",true, hotel_park_inn));
		
		hotelactivities.add(new HotelActivity("Schwimmen", true, arcotel_nike));
		hotelactivities.add(new HotelActivity("Klettern",true, arcotel_nike));
		hotelactivities.add(new HotelActivity("Museen",true, arcotel_nike));
		hotelactivities.add(new HotelActivity("Tierpark",true, arcotel_nike));
		hotelactivities.add(new HotelActivity("Einkaufszentrum", true, arcotel_nike));
		
		hotelactivities.add(new HotelActivity("Schwimmen", true, hotel_donauwelle));
		hotelactivities.add(new HotelActivity("Klettern",true, hotel_donauwelle));
		hotelactivities.add(new HotelActivity("Museen",true, hotel_donauwelle));
		hotelactivities.add(new HotelActivity("Tierpark",true, hotel_donauwelle));
		hotelactivities.add(new HotelActivity("Einkaufszentrum", true, hotel_donauwelle));
		
		
		useractivities.add(new UserActivity("Einkaufszentrum", 9, user1));
		useractivities.add(new UserActivity("Schwimmen",3, user1));
		useractivities.add(new UserActivity("Klettern",4, user1));
		useractivities.add(new UserActivity("Tierpark",3, user1));
		useractivities.add(new UserActivity("Museen",4, user1));
		
		useractivities.add(new UserActivity("Einkaufszentrum", 4, user2));
		useractivities.add(new UserActivity("Schwimmen",4, user2));
		useractivities.add(new UserActivity("Klettern",5, user2));
		useractivities.add(new UserActivity("Tierpark",6, user2));
		useractivities.add(new UserActivity("Museen",6, user2));

		useractivities.add(new UserActivity("Einkaufszentrum", 7, user3));
		useractivities.add(new UserActivity("Schwimmen",7, user3));
		useractivities.add(new UserActivity("Klettern",1, user3));
		useractivities.add(new UserActivity("Tierpark",8, user3));
		useractivities.add(new UserActivity("Museen",9, user3));
		
		userinterests.add(new UserInterest("Lifestyle",4, user1));
		userinterests.add(new UserInterest("Sport",7, user1));
		userinterests.add(new UserInterest("Abenteuer",8, user1));
		userinterests.add(new UserInterest("Familie",3, user1));
		userinterests.add(new UserInterest("Kultur",7, user1));
		
		Evaluation eval1 = new Evaluation(hotel_park_inn, user1, 2, "war eh nice",
						   new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss").format(Calendar.getInstance().getTime()).toString());
		hotelactivities.add(new HotelActivity("Schwimmen", 3, hotel_park_inn, eval1));
		hotelactivities.add(new HotelActivity("Klettern",4, hotel_park_inn, eval1));
		hotelactivities.add(new HotelActivity("Museen",5, hotel_park_inn, eval1));
		hotelactivities.add(new HotelActivity("Tierpark",6, hotel_park_inn, eval1));
		hotelactivities.add(new HotelActivity("Einkaufszentrum", 8, hotel_park_inn, eval1));
		evaluations.add(eval1);

		
		Session sess = Database.getSession();	
		
		for(User user: users)
			sess.save(user);
		
		for(Destination destination: destinations)
			sess.save(destination);	
		
		for(Hotel hotel: hotels)
			sess.save(hotel);
		
		for(DestinationInterest destinationinterest: destinationinterests)
			sess.save(destinationinterest);
		
		for(UserInterest userinterest: userinterests)
			sess.save(userinterest);
		
		for(Evaluation eval : evaluations)
			sess.save(eval);
		
		for(HotelActivity hotelactivity: hotelactivities)
			sess.save(hotelactivity);
		
		for(UserActivity useractivity: useractivities)
			sess.save(useractivity);
		
		UserController.updateAllUserActivities();
		UserController.initializeUserInterests();
		
		sess.close();
	}
}