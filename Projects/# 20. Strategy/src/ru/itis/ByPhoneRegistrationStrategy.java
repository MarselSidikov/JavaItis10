package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class ByPhoneRegistrationStrategy implements Strategy {

    public void run() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите телефон: ");
        String phone = scanner.nextLine();
        int code = random.nextInt(10000);
        System.out.println("Смс с кодом " + code + " отправлена на телефон " + phone);
        System.out.println("Введите код: ");
        int userCode = scanner.nextInt();
        if (userCode == code) {
            System.out.println("Все верно");
        } else {
            System.err.println("Ошибка");
        }
    }
}
