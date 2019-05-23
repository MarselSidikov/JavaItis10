package ru.itis;

public class Button implements Observable {
    private static final int MAX_OBSERVERS_COUNT = 5;

    private String text;

    private Observer observers[];
    private int observersCount;

    public Button(String text) {
        this.text = text;
        this.observers = new Observer[5];
        this.observersCount = 0;
    }

    public void click() {
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        if (observersCount < MAX_OBSERVERS_COUNT) {
            this.observers[observersCount] = observer;
            observersCount++;
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observersCount; i++) {
            observers[i].handleEvent(this.text);
        }
    }
}
