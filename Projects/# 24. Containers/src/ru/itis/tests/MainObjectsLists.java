package ru.itis.tests;

import ru.itis.collections.objects.ObjectsArrayList;
import ru.itis.collections.objects.ObjectsLinkedList;
import ru.itis.collections.objects.ObjectsList;

public class MainObjectsLists {
    public static void main(String[] args) {
        ObjectsList forIntegerArrayList = new ObjectsArrayList();
        ObjectsList forIntegerLinkedList = new ObjectsLinkedList();

        ObjectsList forStringArrayList = new ObjectsArrayList();
        ObjectsList forStringLinkedList = new ObjectsLinkedList();

        forIntegerArrayList.add(777);
        forIntegerArrayList.add(778);
        forIntegerArrayList.add(779);

        forIntegerLinkedList.add(777);
        forIntegerLinkedList.add(778);
        forIntegerLinkedList.add(779);

        forStringArrayList.add(1);
        forStringArrayList.add("Hello");
        forStringArrayList.add("Marsel");
        forStringArrayList.add("!");

        forStringLinkedList.add("Hello");
        forStringLinkedList.add("Marsel");
        forStringLinkedList.add("!");

        String stringFromList = (String)forStringArrayList.get(2);
        int intFromList = (int)forIntegerLinkedList.get(2);

        System.out.println(stringFromList);
        System.out.println(intFromList);

        stringFromList = (String)forIntegerLinkedList.get(2);
        int i = 0;
    }
}
