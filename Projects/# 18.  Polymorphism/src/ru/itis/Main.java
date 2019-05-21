package ru.itis;

public class Main {

    public static void main(String[] args) {
        Ellipse ellipse = new Ellipse(1, 2, 1, 1);
        Circle circle = new Circle(3, 4, 1);
        Rectangle rectangle = new Rectangle(5, 6, 1, 1);
        Square square = new Square(7, 8, 1);
        Triangle triangle = new Triangle(9, 10, 1, 1, 1);

        Shape shapes[] = {ellipse, circle, rectangle, square, triangle};

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getArea() + " " + shapes[i].getCenterModule());
        }

//        Shape shape = new Shape(1, 1);
    }
}
