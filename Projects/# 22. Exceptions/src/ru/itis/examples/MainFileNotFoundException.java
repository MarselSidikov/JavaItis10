package ru.itis.examples;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainFileNotFoundException {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("файл которого нет");
    }
}
