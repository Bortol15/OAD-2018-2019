package Models;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

	public List<Category> Activities;
	public String Name;
	public String Destination;
	public String Country;
	
	public Hotel(String name, String destination, String country)
	{
		Name = name;
		Destination = destination;
		Country = country;
		Activities = new ArrayList<Category>();
	}
	
	public Hotel()
	{
		Activities = new ArrayList<Category>();
	}
}
