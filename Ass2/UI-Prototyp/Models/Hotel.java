package Models;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private List<Category> Activities;
	private String Name;
	private String Destination;
	private String Country;
	private List<Evaluation> Evaluations;
	
	public Hotel(String name, String destination, String country)
	{
		setName(name);
		setDestination(destination);
		setCountry(country);
		setActivities(new ArrayList<Category>());
		Evaluations = new ArrayList<Evaluation>();
	}
	
	public Hotel()
	{
		setActivities(new ArrayList<Category>());
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

	public List<Category> getActivities() {
		return Activities;
	}

	public void setActivities(List<Category> activities) {
		Activities = activities;
	}
}
