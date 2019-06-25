package ru.itdrive.step1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Hello");
        lines.add("Marsel");

        // в объектной переменной processor лежит
        // объект анонимного класса, созданного на основе
        // абстрактного класса TextProcessor с дореализацией
        // метода print
        TextProcessor processor = new TextProcessor() {
            public void print(List<String> lines) {
                for (String line : lines) {
                    System.err.println("Строка: " + line);
                }
            }
        };

        TextProcessor processorAnother = new TextProcessor() {
            @Override
            public void print(List<String> lines) {
                for (String line : lines) {
                    System.out.println(line + " вот так вот");
                }
            }
        };

        List<String> reversed = processor.reverse(lines);

        processor.print(reversed);
        processorAnother.print(reversed);
    }
}
