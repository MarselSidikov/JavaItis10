package ru.itis.chats.services;

import ru.itis.chats.forms.MessageDto;

import java.util.List;

public interface ChatService {
    void addMessage(MessageDto message);
    List<MessageDto> getMessagesFor(String forUser);
}
