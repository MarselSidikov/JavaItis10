package ru.itis.inner;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private int size = 0;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        Node<T> current;

        LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public T get(int index) {
        if (size > 0 && index >= 0 && index < size) {
            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.value;
        } else throw new IllegalArgumentException();
    }

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

    public boolean contains(T element) {
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}
