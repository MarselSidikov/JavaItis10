package ru.itis;

import java.util.Arrays;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        // создали массив объектных переменных ни на что не указывающих
        Rectangle rectangles[] = new Rectangle[100];
        // создали объект-генератор случайных чисел
        Random random = new Random();
        // создали объект спец. класса для генерации прямоугольников

        // бежим по всем переменным массива прямоугольников
        for (int i = 0; i < rectangles.length; i++) {
            // создаем прямоугольник по случайной площади
            rectangles[i] = RectanglesUtils.byArea(random.nextInt(1000));
            // выводим прямоугольник на экран
            System.out.println(rectangles[i].getWidth() + "x" + rectangles[i].getHeight());
        }

        rectangles[55].setWidth(-132);
        // создаем массив для подсчета количество
        // полученных широт прямоугольников
        int widths[] = new int[32];

        // бежим по массиву широт
        for (int i = 0; i < rectangles.length; i++) {
            // под индексом, соответствующем
            // ширине данного прямоугольника
            // кладем значение, равное предыдущему + 1
            widths[(int)rectangles[i].getWidth()]++;
        }

        for (int i = 0; i < widths.length; i++) {
            System.out.print(i + " -> " + widths[i] + ", ");
        }

    }
}
