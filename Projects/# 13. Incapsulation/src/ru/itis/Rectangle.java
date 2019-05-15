package ru.itis;

public class Rectangle {
    double width;
    double height;

    // пустой конструктор
    Rectangle() {
       width = 1;
       height = 1;
    }

    // конструктор с параметрами
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // конструктор копирования
    Rectangle(Rectangle other) {
        width = other.width;
        height = other.height;
    }

    double getArea() {
        return width * height;
    }
}
