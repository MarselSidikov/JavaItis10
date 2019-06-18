package ru.itis;

public class LinkedList<T> implements List<T> {

    private int size = 0;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    @Override
    public T get(int index) {
        if (size > 0 && index >= 0 && index < size) {
            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.value;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
