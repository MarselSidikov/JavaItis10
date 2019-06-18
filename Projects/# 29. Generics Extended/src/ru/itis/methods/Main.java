package ru.itis.methods;

import ru.itis.inheritance.LinkedList;
import ru.itis.inheritance.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        List<String> strings = new LinkedList<>();

        ListUtils.addAll(integers, 10, 11, 15);
        ListUtils.addAll(strings, "Hello", "Hello");
//        ListUtils.addAll(strings, 1, 2, 3);
//        ListUtils.addAll(integers, "Hello", "Hello");

//        List<Double> doubles = ListUtils.from("Hello", "Hello");
//        List<Double> doubles = ListUtils.from(1, 2);
        List<Double> doubles = ListUtils.from(1.5, 2.3);
    }
}
