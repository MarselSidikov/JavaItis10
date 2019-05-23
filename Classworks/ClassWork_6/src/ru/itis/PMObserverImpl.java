package ru.itis;

public class PMObserverImpl implements PMObserver {

    public void handle(char c) {
        System.out.println("I'm on pm - " + c);
    }
}
