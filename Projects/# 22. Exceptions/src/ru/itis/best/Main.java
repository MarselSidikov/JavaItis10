package ru.itis.best;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {

//    public static void main(String[] args) throws Exception {
        // открыли поток для чтения байт
//        InputStream inputStream = new FileInputStream("input_1.txt");
        // создали объектную переменную для хранения байта
//        Byte someByte = null;
        // байт прочитали
//        byte byteFromFile = (byte)inputStream.read();
        // создали объект класса Byte и положили туда прочитанное значение
//        someByte = new Byte(byteFromFile);
        // вывели значение байта как символ
//        System.out.println(someByte.getValueAsChar());
//    }

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("input.txt");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }

        Byte someByte = null;
        try {
            int byteFromFile = inputStream.read();
            someByte = new Byte((byte)byteFromFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        System.out.println(someByte.getValueAsChar());
    }
}
