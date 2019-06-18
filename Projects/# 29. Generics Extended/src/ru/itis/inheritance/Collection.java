package ru.itis.inheritance;

public interface Collection<T> {
    void add(T element);
    boolean contains(T element);
    int size();
}
