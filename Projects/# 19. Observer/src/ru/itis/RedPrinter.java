package ru.itis;

public class RedPrinter implements Observer {
    public void printInRed(String message) {
        System.err.println("Was clicked: " + message);
    }

    public void handleEvent(String arg) {
        printInRed(arg);
    }
}
