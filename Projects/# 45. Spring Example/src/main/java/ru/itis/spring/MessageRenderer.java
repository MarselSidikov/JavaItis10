package ru.itis.spring;

// интерфейс, описывающий классы, объекты которых
// выводят какое-либо сообщение на экран
public interface MessageRenderer {
    void render(String message);
}
