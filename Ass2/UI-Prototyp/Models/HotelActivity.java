package Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotelactivity")
public class HotelActivity extends Category{
	
	private Hotel hotel;
	
	public HotelActivity(String name, int value, Hotel hotel) 
	{
		this.Name = name;
		this.Value = value;
		this.hotel = hotel;
	}
	public HotelActivity() 
	{
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
