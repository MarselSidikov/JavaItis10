package ru.itis;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainInputStreamReadMoreThanOneByte {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("input.txt");
        InputStream inputStream1 = new FileInputStream("input.txt");
        byte bytes[] = new byte[100];
        int count = inputStream.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char)bytes[i]);
        }
        System.out.println(inputStream1.read());
    }

}
