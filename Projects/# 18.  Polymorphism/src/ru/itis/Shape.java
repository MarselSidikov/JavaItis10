package ru.itis;

public abstract class Shape {
    protected double x;
    protected double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getCenterModule() {
        return Math.sqrt(x * x + y * y);
    }

    public abstract double getArea();
}
