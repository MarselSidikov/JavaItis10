package ru.itis.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class MainReader {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("input2.txt");
        int fromFile = reader.read();
        System.out.println(fromFile);
        System.out.println((char)fromFile);
        reader.close();
    }
}
