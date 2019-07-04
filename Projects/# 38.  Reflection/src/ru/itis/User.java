package ru.itis;

public class User {
    private String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void makeOlder(int years) {
        this.age += years;
    }

    public int getHalfLife() {
        return age / 2;
    }
}
