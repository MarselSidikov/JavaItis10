package ru.itis;

public class MainObjectsGenerator {
    public static void main(String[] args) {
        ObjectsGenerator generator = new ObjectsGenerator();
        User user = generator.createObject(User.class, "Марсель", 25);
        System.out.println(user.getName() + " " + user.age);
    }
}
