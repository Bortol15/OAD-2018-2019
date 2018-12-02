package Controller;
import Model.Category;
import Model.Hotel;
import View.ShowHotel;

public class HotelController {

	public static void showHotel()
	{
		Hotel hotel1 = new Hotel();
		hotel1.Activities.add(new Category("Volleyball", 10));
		hotel1.Activities.add(new Category("Schwimmen", 10));
		hotel1.Activities.add(new Category("Geschichte", 8));
		hotel1.Activities.add(new Category("Tennis", 7));
		
		new ShowHotel(hotel1).setVisible(true);
	}
	
	public static void rateHotel()
	{
		
	}
}