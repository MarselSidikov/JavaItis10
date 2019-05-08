package ru.itis;

public class Human {
    String name;
    int age;
    double height;
    int passedDistance;

    void go(int km) {
        passedDistance += km;
    }

    void hit(Human other) {
        other.age++;
        age--;
    }
}
