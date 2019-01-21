package ViewModels;
import java.util.List;

import Models.Destination;
import Models.Hotel;

public class RecommendationViewModel {
	public List<Hotel> hotels;
	public List<Destination> destinations;
	
	public RecommendationViewModel(List<Hotel> hotels, List<Destination> destination)
	{
		this.hotels = hotels;
		this.destinations = destination;
	}

}
