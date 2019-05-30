package ru.itis.try_catch;

public class MainCatchOutOfMemoryError {
    public static void main(String[] args) {
        try {
            String strings[] = new String[Integer.MAX_VALUE - 100];
        } catch (OutOfMemoryError e) {
            System.out.println("Памяти мало=(");
        }

        System.out.println("Я тут");
    }
}
