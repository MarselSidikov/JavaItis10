package ru.itis.generics;

public class Slip<T> {
    private T phone;

    public void setPhone(T phone) {
        this.phone = phone;
    }

    public T getPhone() {
        return phone;
    }
}
