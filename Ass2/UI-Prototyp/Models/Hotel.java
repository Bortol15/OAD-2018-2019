package Models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Hotel {

	private int id;
	private String Name;
	private String Destination;
	private String Country;
	private String Address;
	private int Stars;

	private List<Category> Activities;
	private List<Evaluation> Evaluations;
	
	public Hotel(String name, String destination, String country)
	{
		Name = name;
		Destination = destination;
		Country = country;
		Activities = new ArrayList<Category>();
		Evaluations = new ArrayList<Evaluation>();
	}
	
	public Hotel(String name, String destination, String country, String adress, int stars)
	{
		Name = name;
		Destination = destination;
		Country = country;
		Activities = new ArrayList<Category>();
		Evaluations = new ArrayList<Evaluation>();
		Address = adress;
		Stars = stars;
	}
	
	public Hotel()
	{
		Activities = new ArrayList<Category>();
		Evaluations = new ArrayList<Evaluation>();
	}
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "HOTEL_ID")
	
	public int getHotelId()
	{
		return this.id;
	}
	
	public void setHotelId(int id )
	{
		this.id = id;
	}

	
	@Column(name = "name")
	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	
	@Column(name = "destination")
	public String getDestination()
	{
		return Destination;
	}

	public void setDestination(String destination)
	{
		Destination = destination;
	}

	
	@Column(name = "country")
	public String getCountry()
	{
		return Country;
	}

	public void setCountry(String country)
	{
		Country = country;
	}

	@Transient
	public List<Evaluation> getEvaluations()
	{
		return Evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations)
	{
		Evaluations = evaluations;
	}

	@Transient
	public List<Category> getActivities() {
		return Activities;
	}

	public void setActivities(List<Category> activities) {
		Activities = activities;
	}
	
	public String toString()
	{
		return this.Name;
	}

	
	@Column(name = "stars")
	public int getStars() {
		return Stars;
	}

	public void setStars(int stars) {
		Stars = stars;
	}

	
	@Column(name = "address")
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
}
