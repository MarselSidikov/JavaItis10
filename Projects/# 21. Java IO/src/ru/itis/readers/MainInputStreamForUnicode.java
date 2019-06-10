package ru.itis.readers;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainInputStreamForUnicode {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("input2.txt");
        int byteFromFile = inputStream.read();
        System.out.println(byteFromFile);
    }
}
