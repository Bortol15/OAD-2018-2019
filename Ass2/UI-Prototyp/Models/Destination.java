package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "destination")
public class Destination {

	private int Id;
	private String Name;
	private String Country;
	
	private List<Hotel> Hotels;
	private Map<String, Integer> Interests;
	
	public Destination(int id, String name, String country)
	{
		this.Id = id;
		this.Name = name;
		this.Country = country;
	}
	
	public Destination() {}
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "ID")
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name = "country")
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	@Transient
	public List<Hotel> getHotels() {
		return Hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		Hotels = hotels;
	}
	
	@Transient
	public Map<String, Integer> getInterests() {
		return Interests;
	}
	public void setInterests(Map<String, Integer> interests) {
		Interests = interests;
	}
}