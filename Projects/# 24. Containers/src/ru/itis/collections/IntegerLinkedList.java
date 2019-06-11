package ru.itis.collections;

public class IntegerLinkedList implements IntegersList {
    private Node head;
    private Node tail;
    private int size;

    public IntegerLinkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public void add(int element) {
        Node newNode = new Node(element);

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
    public boolean exists(int element) {
        return false;
    }

    @Override
    public void remove(int element) {

    }

    @Override
    public int size() {
        return 0;
    }
}
