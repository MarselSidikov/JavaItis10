package ru.itis.client;

import ru.itis.gui.Menu;
import ru.itis.repositories.IdGenerator;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UsersService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator("users_id.txt");
        UsersRepository usersRepository = new UsersRepository("users.txt", idGenerator);
        UsersService usersService = new UsersService(usersRepository);
        Menu menu = new Menu(usersService);
        while (true) {
            menu.showMainMenu();
        }
    }
}
