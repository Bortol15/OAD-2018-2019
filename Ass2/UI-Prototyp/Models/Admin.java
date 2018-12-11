package Models;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
	
	private List<Hotel> ManagedHotels = new ArrayList<Hotel>();

	public List<Hotel> getManagedHotels() {
		return ManagedHotels;
	}

	public void setManagedHotels(List<Hotel> managedHotels) {
		ManagedHotels = managedHotels;
	}
}
