package ru.itis;

public abstract class Shape implements Pivoted {
    protected double x;
    protected double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getCenterModule() {
        return Math.sqrt(x * x + y * y);
    }

    public void rotate(double fi) {
        double newX = this.x * Math.cos(fi) - this.y * Math.sin(fi);
        double newY = this.x * Math.sin(fi) + this.y * Math.cos(fi);

        this.x = newX;
        this.y = newY;
    }
}
