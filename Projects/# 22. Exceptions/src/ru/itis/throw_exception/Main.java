package ru.itis.throw_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (password.length() < 7) {
            throw new IllegalArgumentException("Неверная длина пароля");
        }
        System.out.println("Все окей");
    }
}
