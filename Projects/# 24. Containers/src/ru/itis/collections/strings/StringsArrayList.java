package ru.itis.collections.strings;

public class StringsArrayList implements StringsList {

    private static final int DEFAULT_LENGTH = 10;

    private String elements[];
    private int size = 0;

    public StringsArrayList() {
        this.elements = new String[DEFAULT_LENGTH];
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public void add(String element) {
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
        String newElements[] = new String[elements.length + elements.length / 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public boolean exists(String element) {
        return false;
    }

    @Override
    public void remove(String element) {

    }

    @Override
    public int size() {
        return size;
    }
}
