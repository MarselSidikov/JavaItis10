package ru.itis;

public class Printer implements Observer {
    public void print(String message) {
        System.out.println("Was clicked: " + message);
    }

    public void handleEvent(String args) {
        print(args);
    }
}
