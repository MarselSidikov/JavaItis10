package ru.itis.collections.strings;

public interface StringsList extends StringsCollection {
    String get(int index);
    void removeAt(int index);
}
