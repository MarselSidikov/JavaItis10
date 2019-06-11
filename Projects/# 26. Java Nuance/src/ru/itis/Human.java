package ru.itis;

public class Human {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return this.age + " " + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // проверяем, является ли объект, на который указывает obj
        // экземпляром класса Human
        if (obj instanceof Human) {
            Human that = (Human)obj;
            return this.age == that.age && this.name.equals(that.name);
        } else {
            return false;
        }
    }
}
