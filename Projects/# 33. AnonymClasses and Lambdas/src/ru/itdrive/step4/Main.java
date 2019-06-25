package ru.itdrive.step4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("Hello");
        strings.add("Marsel");
        strings.add("How are you");
        strings.add("Ilya");
        strings.add("Bye");

        ListsProcessor processor = new ListsProcessor();

        Function<String, Integer> lengthFunction = line -> line.length();

        List<Integer> lengths = processor.map(strings, lengthFunction);

        System.out.println(lengths);

        Function<String, Character> characterFunction = line -> line.charAt(0);

        List<Character> characters = processor.map(strings, characterFunction);

        System.out.println(characters);

        List<String> evens = processor.filter(strings, line -> line.length() % 2 == 0);
        System.out.println(evens);

        processor.forEach(strings, line -> System.err.println(line));
    }
}
