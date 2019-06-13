package ru.itis.collections.objects;

public class ObjectsArrayList implements ObjectsList {

    private static final int DEFAULT_LENGTH = 10;

    private Object elements[];
    private int size = 0;

    public ObjectsArrayList() {
        this.elements = new Object[DEFAULT_LENGTH];
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } throw new IllegalArgumentException("Неверный индекс");
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public void add(Object element) {
        if (notCorrectSize()) {
            resize();
        }

        elements[size] = element;
        size++;
    }

    private boolean notCorrectSize() {
        return size == elements.length;
    }

    private void resize() {
        Object newElements[] = new Object[elements.length + elements.length / 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public boolean exists(Object element) {
        return false;
    }

    @Override
    public void remove(Object element) {

    }

    @Override
    public int size() {
        return size;
    }
}
