package ru.itis;

public class Car {
    private String model;
    private int weight;
    private int carNumber;

    private Driver driver;
    private Engine engine;

    public Car(String model, int weight, int carNumber, Engine engine) {
        this.model = model;
        this.weight = weight;
        this.carNumber = carNumber;
        this.engine = engine;
        engine.setCar(this);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        driver.addCar(this);
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void beginMove() {
        engine.start();
    }


    public int getCarNumber() {
        return carNumber;
    }
}
