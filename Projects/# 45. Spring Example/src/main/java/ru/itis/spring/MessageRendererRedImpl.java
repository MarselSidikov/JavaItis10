package ru.itis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// класс, который выводит сообщение через err-поток, то есть
// в красном цвете, реализация MessageRenderer
@Component(value = "messageRendererRed")
public class MessageRendererRedImpl implements MessageRenderer {

    @Autowired
    private Encoder encoder;

    public void render(String message) {
        System.err.println(message);
        encoder.encodedRender(message);
    }
}
