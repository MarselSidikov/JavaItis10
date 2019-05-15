package ru.itis;

public class Rectangle {
    private double width;
    private double height;

    // пустой конструктор
    public Rectangle() {
       width = 1;
       height = 1;
    }

    // конструктор с параметрами
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // конструктор копирования
    public Rectangle(Rectangle other) {
        width = other.width;
        height = other.height;
    }

    public double getArea() {
        return width * height;
    }

    public void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        } else {
            this.width = 1;
        }
    }

    public void setHeight(double height) {
        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
