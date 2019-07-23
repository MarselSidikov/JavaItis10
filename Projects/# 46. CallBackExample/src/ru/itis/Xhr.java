package ru.itis;

public class Xhr {
    public OnLoad onLoad;

    public void send() {
        System.out.println("Отправлен запрос");
        onLoad.onLoad();
    }
}
