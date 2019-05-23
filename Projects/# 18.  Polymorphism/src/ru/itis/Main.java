package ru.itis;

public class Main {

    public static void main(String[] args) {
        Ellipse ellipse = new Ellipse(1, 2, 1, 1);
        Circle circle = new Circle(3, 4, 1);
        Rectangle rectangle = new Rectangle(5, 6, 1, 1);
        Square square = new Square(7, 8, 1);
        Triangle triangle = new Triangle(9, 10, 1, 1, 1);
        Point point = new Point(11, 12);
        Shape shapes[] = {ellipse, circle, rectangle, square, triangle, point};
//        PlaneFigure planeFigures[] = {ellipse, circle, rectangle, square, triangle, point};
        PlaneFigure planeFigures[] = {ellipse, circle, rectangle, square, triangle};
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getCenterModule());
        }

        for (int i = 0; i < planeFigures.length; i++) {
            System.out.println(planeFigures[i].getArea());
        }

//        Shape shape = new Shape(1, 1);
    }
}
