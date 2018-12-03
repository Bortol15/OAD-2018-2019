package Models;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;


public class TREC {
	
	private static TREC instance;
	
	public  User currentLoggedInUser;
	
	public  Map<String, JFrame> Frames = new HashMap<String,JFrame>();
	
	private TREC(){}
	
	public static TREC getInstance()
	{
		if(TREC.instance == null)
		{
			TREC.instance = new TREC();
		}
		return TREC.instance;
	}
}
