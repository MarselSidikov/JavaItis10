package ru.itis.checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("input_1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        SomeClass someClass = new SomeClass();
        try {
            someClass.doSomething();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
