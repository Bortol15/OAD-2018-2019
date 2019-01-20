package Models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {
	
	private int userId;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "USER_ID")

	public int getUserId() {
	return this.userId;
	}
	
	//@Column
    //@ElementCollection(targetClass=Category.class)
	protected Map<String, Integer> activities;

	//@Column
	//@ElementCollection(targetClass = Category.class)
	protected Map<String, Integer> interests;
	
	@Column(name = "email")
	private String EMail;
	
	@Column(name = "password")
	private String Password;
	
	@Column(name = "firstname")
	private String Firstname;
	
	@Column(name = "lastname")
	private String LastName;
	
	@Column(name = "gender")
	private String Gender;
	
	@Column(name = "birthdate")
	private String Birthdate;
	
	@Column(name = "adress")
	private String Adress;
	
	@Column(name = "zip")
	private String ZIP;
	
	@Column(name = "country")
	private String Country;
	
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
	
	public User()
	{
		this.activities = new HashMap<String,Integer>();
		this.interests = new HashMap<String, Integer>();
	}
	
	@Transient
	public Map<String, Integer> getActivities() {
		return activities;
	}
	public void setUserId(int id) {
		this.userId = id;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getZIP() {
		return ZIP;
	}

	public void setZIP(String zIP) {
		ZIP = zIP;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public void setActivities(Map<String, Integer> activities) {
		this.activities = activities;
	}

	@Transient
	public Map<String, Integer> getInterests() {
		return interests;
	}

	public void setInterests(Map<String, Integer> interests) {
		this.interests = interests;
	}
}
