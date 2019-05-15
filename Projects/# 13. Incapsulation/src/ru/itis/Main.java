package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Rectangle rectangle = new Rectangle();
	    Rectangle rectangle1 = new Rectangle(2, 5);
	    Rectangle rectangle2 = new Rectangle(rectangle1);
//	    rectangle.height = 5;
//	    rectangle.width = 6;

        RectanglesUtils utils = new RectanglesUtils();
        Rectangle rectangle3 = utils.byArea(-169);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle2.getArea());

        System.out.println("------");
        System.out.println(rectangle3.width + " " + rectangle3.height);
    }
}
