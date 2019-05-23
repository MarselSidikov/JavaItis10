package ru.itis;

import java.util.Scanner;
import java.util.UUID;

public class ByEmailRegistrationStrategy implements Strategy{

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите email");
        String email = scanner.nextLine();
        System.out.println("На емейл " + email + " пришла ссылка с регистрацией " + "https://my-site.com/confirm=" + UUID.randomUUID().toString());
    }
}
