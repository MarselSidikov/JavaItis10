package ru.itis;

public class Driver {
    private static final int MAX_CARS_COUNT = 5;

    private String name;
    private int age;

    private Car currentCar;

    private Car cars[];
    private int carsCount = 0;

    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
        this.cars = new Car[MAX_CARS_COUNT];
    }

    public void addCar(Car car) {
        if (carsCount < MAX_CARS_COUNT) {
            cars[carsCount] = car;
            carsCount++;
        } else {
            System.err.println("Слишком много машин");
        }
    }

    public void chooseCar(int carNumber) {
        for (int i = 0; i < carsCount; i++) {
            if (cars[i].getCarNumber() == carNumber) {
                this.currentCar = cars[i];
                return;
            }
        }
        System.err.println("Такая машина не найдена");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void ride() {
        currentCar.beginMove();
    }
}
