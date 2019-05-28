package ru.itis;

public class MainStackOverflowError {

    public static void f(int n) {
        System.out.println(n);
        f(n - 1);
    }

    public static void main(String[] args) {
        f(100);
    }
}
