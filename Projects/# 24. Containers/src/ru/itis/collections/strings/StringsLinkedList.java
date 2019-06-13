package ru.itis.collections.strings;

public class StringsLinkedList implements StringsList {
    private StringNode head;
    private StringNode tail;
    private int size;

    public StringsLinkedList() {
        this.head = null;
        this.size = 0;
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
        StringNode newNode = new StringNode(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
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
