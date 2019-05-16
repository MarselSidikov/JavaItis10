package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Singleton a = Singleton.getInstance();
	    Singleton b = Singleton.getInstance();

	    Logger logger = Logger.getLogger();

	    logger.setPrefix("MESSAGE");
	    logger.log("Hello");


    }
}
