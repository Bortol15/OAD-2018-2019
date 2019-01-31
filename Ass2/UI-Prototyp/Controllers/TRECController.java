package Controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.dbinitialization;

public class TRECController {

    public static void main(String[] args) {

    	dbinitialization.fillDatabase();
    	MainController.setupTREC();
        MainController.showIndex();
    }
}