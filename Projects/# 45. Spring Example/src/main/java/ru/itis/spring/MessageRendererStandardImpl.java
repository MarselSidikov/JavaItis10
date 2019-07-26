package ru.itis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "messageRendererStandard")
public class MessageRendererStandardImpl implements MessageRenderer {

    @Autowired
    private Encoder encoder;

    public MessageRendererStandardImpl(Encoder encoder) {
        this.encoder = encoder;
    }

    public void render(String message) {
        System.out.println(message);
        encoder.encodedRender(message);
    }
}
