package ru.itis.inheritance;

public class ArrayList<K> implements List<K> {

    private static final int DEFAULT_LENGTH = 10;

    private K elements[];
    private int size = 0;

    public ArrayList() {
        this.elements = (K[])new Object[DEFAULT_LENGTH];
    }

    @Override
    public K get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } throw new IllegalArgumentException("Неверный индекс");
    }

    @Override
    public void add(K element) {
        if (notCorrectSize()) {
            resize();
        }

        elements[size] = element;
        size++;
    }

    @Override
    public boolean contains(K element) {
        return false;
    }

    private boolean notCorrectSize() {
        return size == elements.length;
    }

    private void resize() {
        K newElements[] = (K[])new Object[elements.length + elements.length / 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public int size() {
        return size;
    }
}
