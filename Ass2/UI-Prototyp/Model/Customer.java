package Model;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	public List<Activity> Activities;
	public List<Activity> Interests;
	
	public Customer()
	{
		Activities = new ArrayList<Activity>();
		Interests = new ArrayList<Activity>();
	}
}
