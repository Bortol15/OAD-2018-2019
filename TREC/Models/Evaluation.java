package Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.*;

@Entity
@Table(name = "evaluation")
public class Evaluation {

	private int id;
	private Hotel hotel;
	private List<HotelActivity> Activities = new ArrayList<HotelActivity>();
	private User user;
	private int NightsSpend = 0;
	private String Comment = "";
	private String Date;
	
	public Evaluation(Hotel hotel, User user, int nightsSpend, String comment, String date)
	{
		this.hotel = hotel;
		this.user = user;
		NightsSpend = nightsSpend;
		Comment = comment;
		Date = date;
	}
	
	public Evaluation() 
	{
		
	}
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "Evaluation_Id")
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	@ManyToOne(cascade = CascadeType.MERGE)
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Column(name = "date")
	public String getDate()
	{
		return Date;
	}
	
	public void setDate(String date)
	{
		Date = date;
	}
	
	
	@Column(name = "nights")
	public int getNightsSpend()
	{
		return NightsSpend;
	}
	
	public void setNightsSpend(int nightsSpend)
	{
		NightsSpend = nightsSpend;
	}
	
	@Column(name = "comment")
	public String getComment()
	{
		return Comment;
	}
	
	public void setComment(String comment)
	{
		Comment = comment;
	}
	
	@Transient
	public List<HotelActivity> getActivities()
	{
		return Activities;
	}
	
	public void setActivities(List<HotelActivity> activities)
	{
		Activities = activities;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
