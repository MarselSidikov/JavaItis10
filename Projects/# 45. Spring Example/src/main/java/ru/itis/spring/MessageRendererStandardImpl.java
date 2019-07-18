package ru.itis.spring;

public class MessageRendererStandardImpl implements MessageRenderer {
    public void render(String message) {
        System.out.println(message);
    }
}
