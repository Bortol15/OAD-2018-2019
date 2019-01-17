package Models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

	private Map<String, Integer> Activities;
	private Map<String, Integer> Interests;
	private String Name;
	private String Destination;
	private String Country;
	private List<Evaluation> Evaluations;
	private int Stars;
	
	
	public Map<String, Integer> getInterests() {
		return Interests;
	}

	public void setInterests(Map<String, Integer> interests) {
		Interests = interests;
	}

	private String Address;
	
	public Hotel(String name, String destination, String country)
	{
		Name = name;
		Destination = destination;
		Country = country;
		Activities = new HashMap();
		Evaluations = new ArrayList<Evaluation>();
	}
	
	public Hotel(String name, String destination, String country, String adress, int stars)
	{
		Name = name;
		Destination = destination;
		Country = country;
		Activities = new HashMap();
		Evaluations = new ArrayList<Evaluation>();
		Address = adress;
		Stars = stars;
	}
	
	public Hotel()
	{
		Activities = new HashMap();
		Evaluations = new ArrayList<Evaluation>();
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public String getDestination()
	{
		return Destination;
	}

	public void setDestination(String destination)
	{
		Destination = destination;
	}

	public String getCountry()
	{
		return Country;
	}

	public void setCountry(String country)
	{
		Country = country;
	}

	public List<Evaluation> getEvaluations()
	{
		return Evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations)
	{
		Evaluations = evaluations;
	}

	public Map<String, Integer> getActivities() {
		return Activities;
	}

	public void setActivities(Map<String, Integer> activities) {
		Activities = activities;
	}
	
	public String toString()
	{
		return this.Name;
	}

	public int getStars() {
		return Stars;
	}

	public void setStars(int stars) {
		Stars = stars;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
}
