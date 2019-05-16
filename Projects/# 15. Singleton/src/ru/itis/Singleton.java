package ru.itis;

public class Singleton {
    final static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
