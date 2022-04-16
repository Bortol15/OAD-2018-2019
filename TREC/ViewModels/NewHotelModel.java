package ViewModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Destination;
import Models.Hotel;

public class NewHotelModel {
	public Hotel hotel = new Hotel();
	public Map<Integer, Destination> destinations = new HashMap<Integer, Destination>();

}
