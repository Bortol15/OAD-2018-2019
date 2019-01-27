package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotelactivity")
public class HotelActivity extends Category{
	
	private boolean	activityEntry;
	private Hotel hotel;
	private Evaluation evaluation;
	
	public HotelActivity(String name, int value, Hotel hotel, Evaluation evaluation) 
	{
		this.Name = name;
		this.Value = value;
		this.hotel = hotel;
		this.evaluation = evaluation;
	}
	
	public HotelActivity(String name, boolean activityEntry, Hotel hotel) 
	{
		this.Name = name;
		this.Value = 5;
		this.activityEntry = activityEntry;
		this.hotel = hotel;
	}
	
	
	public HotelActivity() 
	{
		
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	@Column(name = "isactivityentry")
	public boolean isActivityEntry() {
		return activityEntry;
	}
	public void setActivityEntry(boolean activityEntry) {
		this.activityEntry = activityEntry;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
}
