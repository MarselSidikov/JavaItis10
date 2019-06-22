package ru.itis.custom;

public interface Collection<T> extends Iterable<T> {
    void add(T element);
    boolean contains(T element);
    int size();
}
