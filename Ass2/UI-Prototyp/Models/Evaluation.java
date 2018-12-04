package Models;

import java.util.List;
import java.util.*;

public class Evaluation {

	private List<Category> Activities;
	private String CustomerName;
	private int NightsSpend;
	private String Comment;
	private Date Date;
	
	public Date getDate()
	{
		return Date;
	}
	
	public void setDate(Date date)
	{
		Date = date;
	}
	
	public String getCustomerName()
	{
		return CustomerName;
	}
	
	public void setCustomerName(String customerName)
	{
		CustomerName = customerName;
	}
	
	public int getNightsSpend()
	{
		return NightsSpend;
	}
	
	public void setNightsSpend(int nightsSpend)
	{
		NightsSpend = nightsSpend;
	}
	
	public String getComment()
	{
		return Comment;
	}
	
	public void setComment(String comment)
	{
		Comment = comment;
	}
	
	public List<Category> getActivities()
	{
		return Activities;
	}
	
	public void setActivities(List<Category> activities)
	{
		Activities = activities;
	}
	
	
}
