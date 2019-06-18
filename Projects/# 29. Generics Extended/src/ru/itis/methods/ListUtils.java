package ru.itis.methods;

import ru.itis.inheritance.LinkedList;
import ru.itis.inheritance.List;

public class ListUtils {
    public static <T> void addAll(List<T> list, T ... elements) {
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
    }

    public static <T> List<T> from(T ... elements) {
        List<T> list = new LinkedList<>();
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
        return list;
    }
}
