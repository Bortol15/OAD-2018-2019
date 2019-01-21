package Controllers;

import database.dbinitialization;

public class TRECController {

    public static void main(String[] args) {

//    	dbinitialization.fillDatabase();
//    	RecommendationController.calculateCustomerRecommendation();
    	MainController.setupTREC();
        MainController.showIndex();
    }
}