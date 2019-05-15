package ru.itis;

public class RectanglesUtils {

    public Rectangle byArea(double area) {
        double width = 1;
        for (int i = 2; i * i <= area; i++) {
            if (area % i == 0) {
                width = i;
                break;
            }
        }

        return new Rectangle(width, area / width);
    }
}
