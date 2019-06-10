package ru.itis.readers;

import java.io.FileWriter;
import java.io.Writer;

public class MainWriter {
    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("output.txt");
        writer.write('П');
        writer.close();

    }
}
