package Controllers;
import Models.TREC;
import Views.*;

public class MainController {

	//load from Database
	
	public static void setupTREC()
	{
		Index index = new Index();
		Activities activities = new Activities();
		Interests interests = new Interests();
		Login login = new Login();
		RateHotel rateHotel = new RateHotel();
		RecommendationsAdmin recommendationsAdmin = new RecommendationsAdmin();
		RecommendationsCustomer recommendationsCustomer = new RecommendationsCustomer();
		Registration registration = new Registration();
		Search search = new Search();
		ShowHotel showHotel = new ShowHotel();
		Statistics statistics = new Statistics();
		
		TREC.getInstance().Frames.put("Activities", activities);
		TREC.getInstance().Frames.put("Index", index);
		TREC.getInstance().Frames.put("Interests", interests);
		TREC.getInstance().Frames.put("Login", login);
		TREC.getInstance().Frames.put("RateHotel", rateHotel);
		TREC.getInstance().Frames.put("RecommendationsAdmin", recommendationsAdmin);
		TREC.getInstance().Frames.put("RecommendationsCustomer", recommendationsCustomer);
		TREC.getInstance().Frames.put("Registration", registration);
		TREC.getInstance().Frames.put("Search", search);
		TREC.getInstance().Frames.put("ShowHotel", showHotel);
		TREC.getInstance().Frames.put("Statistics", statistics);
	}
	
	public static void showIndex()
	{
		TREC.getInstance().Frames.get("Index").setVisible(true);
	}
}
