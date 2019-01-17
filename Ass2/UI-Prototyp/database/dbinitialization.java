package database;

import java.util.ArrayList;
import java.util.List;

import Models.Hotel;

public class dbinitialization {
	
	public void fillDatabase()
	{
		//name, destination, country, address, stars
		List<Hotel> hotels = new ArrayList<Hotel>();
		
		hotels.add(new Hotel("Hotel Park Inn","Linz", "Österreich", "Hessenplatz", 4));
		hotels.add(new Hotel("Arcotel Nike","Linz", "Österreich", "Rathausviertel", 4));
		hotels.add(new Hotel("Hotel Donauwelle", "Linz", "Österreich", "Hafenviertel", 4));
		hotels.add(new Hotel("Hotel Schillerpark","Linz", "Österreich", "Schillerpark", 4));
		hotels.add(new Hotel("Prielmayerhof","Linz", "Österreich", "Kaplanhofviertel", 4));
		hotels.add(new Hotel("Domhotel","Linz", "Österreich", "Altstadtviertel", 4));
		hotels.add(new Hotel("City Hotel","Linz", "Österreich", "Neustadtviertel", 4));
		hotels.add(new Hotel("Hotel Spitz","Linz", "Österreich", "Alturfahr", 4));
		hotels.add(new Hotel("Hotel Goldener Adler","Linz", "Österreich", "Alturfahr", 3));
		hotels.add(new Hotel("Hotel Ibis","Linz", "Österreich", "Hauptbahnhof", 3));
		
	}
	

}
