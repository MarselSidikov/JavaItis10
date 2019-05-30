package ru.itis.throws_checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SimpleByteReader {
    private InputStream inputStream;

    public SimpleByteReader(String fileName) {
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public byte read() throws IOException {
        int byteFromFile = inputStream.read();
        if (byteFromFile == -1) {
            throw new IllegalArgumentException("Поток кончился");
        }
        return (byte)byteFromFile;
    }
}
