package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Engine engine = new Engine("Bugatti", 7.9);
	    Driver driver = new Driver("Марсель", 25);
	    Car car = new Car("ВАЗ-2114", 1000, 777, engine);
	    car.setDriver(driver);
	    driver.ride();
    }
}
