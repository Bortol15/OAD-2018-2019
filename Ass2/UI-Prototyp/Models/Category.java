package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	@Column(name = "name")
	public String Name;
	
	@Column(name = "value")
	public int Value;
	
	public Category(String name)
	{
		this.Name = name;
		this.Value = 5;
	}
	
	public Category(String name, int value)
	{
		this.Name = name;
		this.Value = value;
	}
}
