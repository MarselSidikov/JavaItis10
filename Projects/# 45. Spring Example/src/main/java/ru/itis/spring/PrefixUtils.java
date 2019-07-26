package ru.itis.spring;

// интерфейс, который описывает классы
// объекты которых так же могут выводить
// сообщения, но с определенным prefix-ом
public interface PrefixUtils {
    void render(String message);
}
