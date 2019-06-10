package ru.itis.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class MainBufferedReader {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("input2.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println(line);
    }
}
