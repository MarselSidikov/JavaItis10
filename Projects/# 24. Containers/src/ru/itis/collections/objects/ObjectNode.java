package ru.itis.collections.objects;

public class ObjectNode {
    private Object value;
    private ObjectNode next;

    public ObjectNode(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ObjectNode getNext() {
        return next;
    }

    public void setNext(ObjectNode next) {
        this.next = next;
    }
}
