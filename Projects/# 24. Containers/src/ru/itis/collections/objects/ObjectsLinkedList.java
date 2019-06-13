package ru.itis.collections.objects;

public class ObjectsLinkedList implements ObjectsList {
    private ObjectNode head;
    private ObjectNode tail;
    private int size;

    public ObjectsLinkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public Object get(int index) {
        if (index >= 0 && index < size) {
            ObjectNode current = head;
            int currentIndex = 0;

            while (currentIndex != index) {
                current = current.getNext();
                currentIndex++;
            }

            return current.getValue();
        }
        throw new IllegalArgumentException("Неверный индекс");
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public void add(Object element) {
        ObjectNode newNode = new ObjectNode(element);

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
