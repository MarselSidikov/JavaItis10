package ru.itdrive.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Hello");
        lines.add("Marsel");

        TextProcessor processor = new TextProcessor();
        // лямбда выражение
//        Consumer consumer = line -> System.out.println(line);
//        processor.print(lines, consumer);
        processor.print(lines, line -> System.out.println(line));
    }
}
