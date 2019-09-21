package ru.itis.chats.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.chats.forms.MessageDto;
import ru.itis.chats.services.ChatService;

import java.util.List;

//@RestController
public class ChatLongPollingController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<Object> addMessage(@RequestBody MessageDto message) {
        chatService.addMessage(message);
        return ResponseEntity.status(200).build();
    }

    @SneakyThrows
    @GetMapping("/chat")
    public ResponseEntity<List<MessageDto>> receiveMessage(@RequestParam("for") String forUser) {
        return ResponseEntity.ok(chatService.getMessagesFor(forUser));
    }
}
