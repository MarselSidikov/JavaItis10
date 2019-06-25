package ru.itdrive.step2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Hello");
        lines.add("Marsel");

        TextProcessor processor = new TextProcessor();

        Consumer consumer = new Consumer() {
            @Override
            public void apply(String line) {
                System.out.println("Результат: " + line);
            }
        };

        processor.print(lines, consumer);
    }
}
