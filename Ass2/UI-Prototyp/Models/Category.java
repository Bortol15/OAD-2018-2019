package Models;

public class Category {
	public String Name;
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
