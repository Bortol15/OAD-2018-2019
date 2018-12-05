package Controllers;

import Models.TREC;
import Models.User;

public class TRECController {

    public static void main(String[] args) {
    	MainController.setupTREC();
//    	TREC.getInstance().setCurrentLoggedInUser(new User("chris", "christoph.pross@gmx.at", "asdf"));
        MainController.showIndex();
    }
}