package ru.itis.collections.objects;

public interface ObjectsList extends ObjectsCollection {
    Object get(int index);
    void removeAt(int index);
}
