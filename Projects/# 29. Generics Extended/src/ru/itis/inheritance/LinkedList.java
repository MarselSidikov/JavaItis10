package ru.itis.inheritance;

public class LinkedList<V> implements List<V> {

    private static class Node<X> {
        X value;
        Node<X> next;

        Node(X value) {
            this.value = value;
        }
    }

    private Node<V> head;
    private Node<V> tail;

    @Override
    public V get(int index) {
        return null;
    }

    @Override
    public void add(V element) {
        Node<V> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public boolean contains(V element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
