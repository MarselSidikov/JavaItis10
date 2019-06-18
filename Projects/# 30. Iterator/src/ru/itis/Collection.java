package ru.itis;

public interface Collection<T> {
    void add(T element);
    boolean contains(T element);
    int size();
}
