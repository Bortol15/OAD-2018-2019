package Controller;
import Model.Activity;
import Model.Hotel;
import View.ShowHotel;

public class HotelController {

	public static void showHotel()
	{
		Hotel hotel1 = new Hotel();
		hotel1.Activities.add(new Activity("Volleyball", 10));
		hotel1.Activities.add(new Activity("Tennis", 7));
		hotel1.Activities.add(new Activity("Schwimmen", 10));
		hotel1.Activities.add(new Activity("Geschichte", 8));
		
		new ShowHotel(hotel1).setVisible(true);
	}
	
	public static void rateHotel()
	{
		
	}
	
}
