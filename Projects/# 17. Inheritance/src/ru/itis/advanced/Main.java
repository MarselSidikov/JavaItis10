package ru.itis.advanced;

public class Main {
    public static void main(String[] args) {
        Transport transport = new Transport();
        Car car = new Car();
        SportCar sportCar = new SportCar();
        Airplane airplane = new Airplane();

        sportCar.выпендриваться();

        Transport t1 = transport;
        Transport t2 = car;
        Transport t3 = sportCar;
        Transport t4 = airplane;

//        SportCar mySportCar = (SportCar)t2;
        SportCar mySportCar = (SportCar)t3;
        mySportCar.выпендриваться();

        Transport transports[] = {t1, t2, t3, t4};

        for (int i = 0; i < transports.length; i++) {
            transports[i].go();
        }
    }
}
