package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	private long CategoryId;
	
	private User User;
	

	private String Name;
	

	private int Value;
	
	@Column(name = "name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Column(name = "value")
	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "CATEGORY_ID")

	public long getCategoryId() {
	return this.CategoryId;

	}
	
	public void setCategoryId(long categoryId) {
		this.CategoryId = categoryId;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)

	public User getUser() {
		return this.User;
	}
	
	public void setUser(User user) {
		this.User = user;
	}
	
	
	public Category(String name)
	{
		this.Name = name;
		this.Value = 5;
	}
	
	public Category(String name, int value, User user)
	{
		this.Name = name;
		this.Value = value;
		this.User = user;
	}
	
	
	public Category(String name, int value)
	{
		this.Name = name;
		this.Value = value;
	}
	
	public Category()
	{
		
	}
}
