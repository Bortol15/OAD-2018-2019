package Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Category {
	
	protected int Id;
	protected String Name;
	protected int Value;
	
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

	public int getId() {
	return this.Id;

	}
	
	public void setId(int Id) {
		this.Id = Id;
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
