package ru.itis.custom_exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (password.length() < 7) {
//            throw new IllegalArgumentException("Неверная длина пароля");
            throw new PasswordLengthException("Неверная длина пароля");
        }
        System.out.println("Все окей");
    }
}
