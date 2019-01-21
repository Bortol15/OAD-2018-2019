package Models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD

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
=======
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hotel")
public class Hotel {

	private int Id;
	private String Name;
	private Destination Destination;
	private String Address;
	private int Stars;

	private Map<String,Integer> Activities;
>>>>>>> recommendation
	private List<Evaluation> Evaluations;
	
	public Hotel(String name, Destination destination)
	{
		Name = name;
		Destination = destination;
		Activities = new HashMap<String, Integer>();
		Evaluations = new ArrayList<Evaluation>();
	}
	
	public Hotel( String name, Destination destination, String address, int stars)
	{
		Name = name;
		Destination = destination;
		Activities = new HashMap<String, Integer>();
		Evaluations = new ArrayList<Evaluation>();
		Address = address;
		Stars = stars;
	}
	
	public Hotel()
	{
		Activities = new HashMap<String, Integer>();
		Evaluations = new ArrayList<Evaluation>();
	}
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "HOTEL_ID")
	
<<<<<<< HEAD
	public int getHotelId()
	{
		return this.id;
	}
	
	public void setHotelId(int id )
	{
		this.id = id;
=======
	public int getId()
	{
		return this.Id;
	}
	
	public void setId(int id )
	{
		this.Id = id;
>>>>>>> recommendation
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

<<<<<<< HEAD
	
	@Column(name = "destination")
	public String getDestination()
=======
	@ManyToOne(cascade = CascadeType.MERGE)
	public Destination getDestination()
>>>>>>> recommendation
	{
		return Destination;
	}

	public void setDestination(Destination destination)
	{
		Destination = destination;
	}
<<<<<<< HEAD

	
	@Column(name = "country")
	public String getCountry()
	{
		return Country;
	}

	public void setCountry(String country)
	{
		Country = country;
=======
	public void setAddress(String address) {
		Address = address;
>>>>>>> recommendation
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
<<<<<<< HEAD
	public List<Category> getActivities() {
=======
	public Map<String, Integer> getActivities() {
>>>>>>> recommendation
		return Activities;
	}

	public void setActivities(Map<String, Integer> activities) {
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
}