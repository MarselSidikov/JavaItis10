package ru.itis.gui;

import ru.itis.dto.SignUpForm;
import ru.itis.services.UsersService;

import java.util.Scanner;

public class Menu {
    private int currentCommand;
    private UsersService usersService;
    private Scanner scanner = new Scanner(System.in);

    public Menu(UsersService usersService) {
        this.usersService = usersService;
    }

    public void showMainMenu() {
        System.out.println("Добро пожаловать!");
        System.out.println("1. Регистрация");
        System.out.println("2. Просмотр всех пользователей");
        System.out.println("3. Выход");
        currentCommand = scanner.nextInt();
        processCommand();
    }

    public void processCommand() {
        if (currentCommand == 1) {
            showRegistrationMenu();
        } else if (currentCommand == 2) {
            showAllUsers();
        } else {
            System.exit(0);
        }
    }

    public void showRegistrationMenu() {
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        SignUpForm form = new SignUpForm(login, password);
        usersService.signUp(form);
        showMainMenu();
    }

    public void showAllUsers() {

    }
}
