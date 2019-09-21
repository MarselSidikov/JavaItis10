package ru.itis.chats.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.itis.chats.forms.MessageDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatServiceILongPollingImpl implements ChatService {

    /**
     *
     * Таблица Пользователь (id, id-страницы)
     * Чат (id-чата, пользователи чата)
     * Сообщение (текст, от кого, id-чата)
     * ПрочитанностьСообщений (id-сообщения, id-прочитавшего)
     *
     *
     */

    private static Map<String, List<MessageDto>> messages = new ConcurrentHashMap<>();

    @Override
    public void addMessage(MessageDto message) {
        // смотрим, от кого пришло сообщение
        String from = message.getFrom();
        // если раньше этой страницы не было в списке рассылок
        if (!messages.containsKey(from)) {
            // добавляем его в список рассылок
            messages.put(from, new ArrayList<>());
        }
        // Пробегаем всю карту с парами UUID-страницы-список сообщений
        for (Map.Entry<String, List<MessageDto>> entry : messages.entrySet()) {
            // блокируем список сообщений для текущего пользователя
            synchronized (entry.getValue()) {
                // добавляем в этот список само сообщение
                entry.getValue().add(message);
                // оповещаем потоки, которые ждут на этом списке,
                // что данным списком сообщений можно пользоваться
                entry.getValue().notifyAll();
            }
        }
    }

    // получаем список текущих сообщений для пользователя
    @SneakyThrows
    @Override
    public List<MessageDto> getMessagesFor(String forUser) {
        // блокируем сообщения текущего пользователя
        synchronized (messages.get(forUser)) {
            // если в текущий момент список пустой
            if (messages.get(forUser).isEmpty()) {
                // отправляем поток (запрос пользователя) в ожидание
                messages.get(forUser).wait();
            }
            // если у списка был вызван notify то мы приходим сюда
            // вытаскиваем все сообщения для пользователя
            List<MessageDto> result = new ArrayList<>(messages.get(forUser));
            // очищаем исходный список
            messages.get(forUser).clear();
            // и отправляем список сообщений пользователю
            return result;
        }
    }
}
