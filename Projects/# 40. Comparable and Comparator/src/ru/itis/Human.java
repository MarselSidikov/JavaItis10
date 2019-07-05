package ru.itis;

/**
 * 05.07.2019
 * Human
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human implements Comparable<Human> {
    private int age;
    private String name;
    private double height;

    public Human(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + height;
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
