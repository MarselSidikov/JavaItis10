package ru.itis.humans;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Human humans[] = new Human[10];
        
        Scanner scanner = new Scanner(System.in);
        Human human = new Human();

        human.name = scanner.nextLine();
        human.age = scanner.nextInt();

        System.out.println(human.name);
        System.out.println(human.age);

    }
}
