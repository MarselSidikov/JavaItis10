package ru.itis.tests;

import ru.itis.collections.strings.StringsLinkedList;
import ru.itis.collections.strings.StringsList;

public class MainStringsLinkedList {
    public static void main(String[] args) {
        StringsList list = new StringsLinkedList();
        list.add("Hello");
        list.add("Marsel");
        list.add("!");
    }
}
