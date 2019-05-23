package ru.itis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationContext context = new RegistrationContext();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("0 - регистрация по телефону, 1 - регистрация по почте");
            int command = scanner.nextInt();
            if (command == 0) {
                context.setStrategy(new ByPhoneRegistrationStrategy());
            } else if (command == 1) {
                context.setStrategy(new ByEmailRegistrationStrategy());
            }
            context.registration();
        }

    }
}
