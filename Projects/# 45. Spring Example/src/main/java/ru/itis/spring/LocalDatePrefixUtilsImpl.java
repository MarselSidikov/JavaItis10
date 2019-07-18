package ru.itis.spring;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

public class LocalDatePrefixUtilsImpl implements PrefixUtils {
    private MessageRenderer renderer;

    public LocalDatePrefixUtilsImpl(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public void render(String message) {
        System.out.println(LocalDateTime.now().toString());
        renderer.render(message);
        System.out.println(LocalDateTime.now().toString());

    }

    @Override
    public void setPrefix(String prefix) {
        throw new NotImplementedException();
    }
}
