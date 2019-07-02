package ru.itis.cooperation;

public class Product {
    private boolean isReady = false;

    public boolean isProduced() {
        return isReady;
    }

    public boolean isConsumed() {
        return !isReady;
    }

    public void consume() {
        this.isReady = false;
    }

    public void produce() {
        this.isReady = true;
    }
}
