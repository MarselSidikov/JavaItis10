package ru.itis.examples;

import java.util.Scanner;

public class MainArithmeticException {

    public static int div(int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int y = div(a, b);
        System.out.println(y);
    }
}
