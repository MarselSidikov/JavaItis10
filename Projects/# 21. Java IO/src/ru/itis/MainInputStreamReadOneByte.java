package ru.itis;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainInputStreamReadOneByte {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("input.txt");
        int i1 = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();

        char c1 = (char)i1;
        char c2 = (char)i2;
        char c3 = (char)i3;

        System.out.println(c1 + "" + c2 + "" + c3);

        inputStream.close();
    }
}
