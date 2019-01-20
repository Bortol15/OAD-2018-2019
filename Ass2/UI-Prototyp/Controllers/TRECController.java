package Controllers;

import Models.Destination;
import Models.Hotel;
import database.Database;
import database.dbinitialization;

public class TRECController {

    public static void main(String[] args) {


    	dbinitialization.fillDatabase();
    	RecommendationController.calculateCustomerRecommendation();
    	MainController.setupTREC();
        MainController.showIndex();
    }
}