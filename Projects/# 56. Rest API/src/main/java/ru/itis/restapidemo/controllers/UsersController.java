package ru.itis.restapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.restapidemo.dto.CommunitiesResponseDto;
import ru.itis.restapidemo.dto.UserResponseDto;
import ru.itis.restapidemo.forms.CommunityForUserForm;
import ru.itis.restapidemo.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // запрос на получение всех сообществ конкретного пользователя
    @GetMapping("/{user-id}/communities")
    public ResponseEntity<CommunitiesResponseDto> getCommunitiesByUser(@PathVariable("user-id") Long userId) {
        // формируем ответ
        CommunitiesResponseDto responseBody = CommunitiesResponseDto.builder()
                .data(usersService.getCommunitiesByUser(userId))
                .build();
        // возвращаем его как результат
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/{user-id}/communities")
    public ResponseEntity<CommunitiesResponseDto> addCommunityToUser(@PathVariable("user-id") Long userId,
                                                                     @RequestBody CommunityForUserForm community) {
        CommunitiesResponseDto responseBody = CommunitiesResponseDto.builder()
                .data(usersService.addCommunityToUser(userId, community))
                .build();
        return ResponseEntity.status(201).body(responseBody);
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> getAllUsers() {
        UserResponseDto responseBody = UserResponseDto.builder()
                .data(usersService.getAllUsers())
                .build();
        return ResponseEntity.ok(responseBody);
    }
}
