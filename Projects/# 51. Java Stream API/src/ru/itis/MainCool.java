package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class MainCool {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Marsel");
        lines.add("hello");
        lines.add("how");
        lines.add("yeah");

        lines.stream()
                .map(line -> line.length())
                .filter(lineLength -> lineLength % 2 == 0)
                .forEach(evenLineLength -> System.err.println("NUMBER = " + evenLineLength));
    }
}
