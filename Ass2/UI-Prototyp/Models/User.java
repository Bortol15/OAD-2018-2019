package Models;

import java.util.Date;

public class User {
	
	public String Firstname;
	public String LastName;
	public String Gender;
	public String Birthdate;
	public String Adress;
	public String ZIP;
	public String Country;
	public String EMail;
	public String Password;
	
	public User(String firstname, String lastname, String email, String password,
				String gender, String birthdate, String adress, String zip, String country)
	{
		EMail = email;
		Firstname = firstname;
		LastName = lastname;
		Gender = gender;
		Birthdate = birthdate;
		Adress = adress;
		ZIP = zip;
		Country = country;
		EMail = email;
		Password = password;
	}
	
	public User(String firstname, String email, String password) 
	{
		Firstname = firstname;
		EMail = email;
		Password = password;
	}
	
	public User() {}
}
