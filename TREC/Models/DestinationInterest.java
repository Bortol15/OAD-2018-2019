package Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "destinationinterest")
public class DestinationInterest extends Category{
	
	private Destination destination;
	
	public DestinationInterest(String name, int value, Destination destination) 
	{
		this.Name = name;
		this.Value = value;
		this.destination = destination;
	}
	
	public DestinationInterest() 
	{
		
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Destination getDestination()
	{
		return destination;
	}

	public void setDestination(Destination destination)
	{
		this.destination = destination;
	}
}