package Model;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	public List<Category> Activities;
	public List<Category> Interests;	
	
	public Customer()
	{
		Activities = new ArrayList<Category>();
		Interests = new ArrayList<Category>();
	}
}
