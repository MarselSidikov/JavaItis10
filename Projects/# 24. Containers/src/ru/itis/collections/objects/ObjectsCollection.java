package ru.itis.collections.objects;

public interface ObjectsCollection {
    void add(Object element);
    boolean exists(Object element);
    void remove(Object element);
    int size();
}
