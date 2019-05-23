package ru.itis;

public class Rectangle extends Shape implements PlaneFigure, Scalable {
    private double height;
    private double width;

    public Rectangle(double x, double y, double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void scale(double value) {
        this.height = this.height * value;
        this.width = this.width * value;
    }
}
