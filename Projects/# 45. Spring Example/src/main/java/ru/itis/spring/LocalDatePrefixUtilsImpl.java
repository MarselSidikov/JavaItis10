package ru.itis.spring;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

// реализация вывода с префиксом, префикс представляет собой - текущее время
public class LocalDatePrefixUtilsImpl implements PrefixUtils {
    // есть зависимость на MessageRenderer
    private MessageRenderer renderer;

    public LocalDatePrefixUtilsImpl(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public void render(String message) {
        System.out.println(LocalDateTime.now().toString());
        renderer.render(message);
        System.out.println(LocalDateTime.now().toString());

    }
}
