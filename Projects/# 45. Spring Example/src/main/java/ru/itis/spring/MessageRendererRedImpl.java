package ru.itis.spring;

public class MessageRendererRedImpl implements MessageRenderer {
    public void render(String message) {
        System.err.println(message);
    }
}
