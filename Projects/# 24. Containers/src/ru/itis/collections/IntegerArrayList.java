package ru.itis.collections;

public class IntegerArrayList implements IntegersList {

    private static final int DEFAULT_LENGTH = 10;

    private int elements[];
    private int size = 0;

    public IntegerArrayList() {
        this.elements = new int[DEFAULT_LENGTH];
    }

    public int get(int index) {
        return 0;
    }


    public void removeAt(int index) {

    }


//    public void add(int element) {
//        if (size < elements.length) {
//            elements[size] = element;
//            size++;
//        } else {
//            int newElements[] = new int[elements.length + elements.length / 2];
//
//            for (int i = 0; i < elements.length; i++) {
//                newElements[i] = elements[i];
//            }
//
//            this.elements = newElements;
//
//            elements[size] = element;
//            size++;
//        }
//    }

    public void add(int element) {
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
        int newElements[] = new int[elements.length + elements.length / 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }

    public boolean exists(int element) {
        return false;
    }


    public void remove(int element) {

    }


    public int size() {
        return size;
    }
}
