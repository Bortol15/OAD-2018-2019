package ViewModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Destination;
import Models.Hotel;
import Models.HotelActivity;

public class MaintainHotelModel {
	public Hotel hotel = new Hotel();
	public List<String> activities_suggestions = new ArrayList<String>();
	public Map<Integer, Destination> destinations = new HashMap<Integer, Destination>();

}
