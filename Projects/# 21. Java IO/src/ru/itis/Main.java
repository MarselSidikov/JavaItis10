package ru.itis;

import java.io.*;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        byte bytes[] = new byte[Integer.MAX_VALUE - 100];

        InputStream inputStream =
                new URL("https://s2-goods.ozstatic.by/480/742/687/10/10687742_0_Head_First_Patterni_proektirovaniya_Obnovlennoe_yubileynoe_izdanie.jpg").openStream();
//        int size = inputStream.read(bytes, 0, bytes.length);
//        System.out.println(size);
        int c = inputStream.read();
        int i = 0;
        while (c != -1) {
            bytes[i] = (byte)c;
            i++;
            c = inputStream.read();
        }
        System.out.println(i);
        OutputStream outputStream = new FileOutputStream("output.jpg");
        outputStream.write(bytes, 0, i);
        outputStream.close();
        inputStream.close();
    }
}
