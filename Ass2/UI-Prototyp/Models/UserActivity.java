package Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "useractivity")
public class UserActivity extends Category{
	
	private User User;
	
	public UserActivity(String name, int value, User User) 
	{
		this.Name = name;
		this.Value = value;
		this.User = User;
	}
	
	public UserActivity()
	{
		
	}
	
	@ManyToOne(cascade = CascadeType.DETACH)
	public User getUser() {
		return User;
	}

	public void setUser(User User) {
		this.User = User;
	}
}
