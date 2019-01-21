package Models;
		
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userinterest")
public class UserInterest extends Category{
	
	private User User;
	
	public UserInterest(String name, int value, User User) 
	{
		this.Name = name;
		this.Value = value;
		this.User = User;
	}
	
	public UserInterest() 
	{
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public User getUser()
	{
		return User;
	}

	public void setUser(User User)
	{
		this.User = User;
	}
}