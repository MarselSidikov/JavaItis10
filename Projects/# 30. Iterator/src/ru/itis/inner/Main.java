package ru.itis.inner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Привет");
        list.add("Пока");
        list.add("Как дела");
        list.add("Что нового");

        for (String line : list) {
            System.out.println(line);
        }

    }
}
