package ru.itis;

import java.util.Arrays;
import java.util.Scanner;

public class MainCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char text[] = scanner.nextLine().toCharArray();
        System.out.println(Arrays.toString(text));
    }
}
