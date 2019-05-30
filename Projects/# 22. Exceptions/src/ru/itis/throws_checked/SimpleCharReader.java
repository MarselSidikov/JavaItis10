package ru.itis.throws_checked;

import java.io.IOException;

public class SimpleCharReader {
    private SimpleByteReader simpleByteReader;

    public SimpleCharReader(String fileName) {
        simpleByteReader = new SimpleByteReader(fileName);
    }

    public char read() {
        try {
            byte byteFromFile = simpleByteReader.read();
            return (char)byteFromFile;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
