package ru.itis.chats.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.itis.chats.forms.MessageDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatServiceImpl implements ChatService {

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
        // добавляем в каждый список пришедшее сообщение
        for (Map.Entry<String, List<MessageDto>> entry : messages.entrySet()) {
            synchronized (entry.getValue()) {
                entry.getValue().add(message);
                entry.getValue().notifyAll();
            }
        }
    }

    @SneakyThrows
    @Override
    public List<MessageDto> getMessagesFor(String forUser) {
        synchronized (messages.get(forUser)) {
            if (messages.get(forUser).isEmpty()) {
                messages.get(forUser).wait();
            }
            List<MessageDto> result = new ArrayList<>(messages.get(forUser));
            messages.get(forUser).clear();
            return result;
        }
    }
}
