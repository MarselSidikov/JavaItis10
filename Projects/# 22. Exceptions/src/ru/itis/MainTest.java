package ru.itis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainTest {
    public static void main(String[] args) {
        try {
            InputStream inputStream =
                    new FileInputStream("input.txt");
            throw new IllegalArgumentException();
        } catch (FileNotFoundException e) {
            try {
                throw new IOException();
            } catch (IOException e1) {
                System.out.println("4");
            }
        } catch (IOException e) {
            System.out.println("1");
        } catch (IllegalArgumentException e) {
            System.out.println("2");
        } finally {
            System.out.println("3");
        }
    }
}
