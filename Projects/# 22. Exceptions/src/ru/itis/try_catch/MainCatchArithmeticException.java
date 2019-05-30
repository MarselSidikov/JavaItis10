package ru.itis.try_catch;

import java.util.Scanner;

public class MainCatchArithmeticException {
    public static int div(int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int y = div(a, b);
                System.out.println(y);
            } catch (ArithmeticException e) {
                System.err.println("На ноль делить нельзя. Потому что - " + e.getMessage());
                System.out.println("Подробнее - ");
                e.printStackTrace();
            }
        }

    }
}
