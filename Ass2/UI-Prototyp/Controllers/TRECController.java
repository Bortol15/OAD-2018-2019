package Controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.User;
import database.Database;
import database.dbinitialization;

public class TRECController {

    public static void main(String[] args) {

//    	dbinitialization.fillDatabase();
    	MainController.setupTREC();
        MainController.showIndex();
    }
}