package ru.itis;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}
