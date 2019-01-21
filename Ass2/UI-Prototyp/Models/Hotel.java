package Models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public int getId()
	{
		return this.Id;
	}
	
	public void setId(int id )
	{
		this.Id = id;
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

	@ManyToOne(cascade = CascadeType.MERGE)
	public Destination getDestination()
	{
		return Destination;
	}

	public void setDestination(Destination destination)
	{
		Destination = destination;
	}
	public void setAddress(String address) {
		Address = address;
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