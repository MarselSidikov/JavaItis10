package ru.itis.restapidemo.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itis.restapidemo.dto.CommunitiesResponseDto;
import ru.itis.restapidemo.dto.UserResponseDto;
import ru.itis.restapidemo.dto.UsersResponseDto;
import ru.itis.restapidemo.forms.CommunityForUserForm;
import ru.itis.restapidemo.services.UsersService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/{user-id}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @ApiOperation(value = "Получить данные о личном профиле", notes = "Данные профиля возрващаются только в том случае, " +
            "когда token пользователя соответствует id, если роль пользователя - USER")
    public ResponseEntity<UserResponseDto> getUser(@RequestHeader("token") String token,
                                                    @PathVariable("user-id") Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserResponseDto responseBody = UserResponseDto.builder()
                .data(usersService.getUser(authentication, userId))
                .build();

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{user-id}/communities")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @ApiOperation(value = "Получить все сообщества пользователя",
            notes = "Доступно Администратору и Пользователю")
    public ResponseEntity<CommunitiesResponseDto> getCommunitiesByUser(@RequestHeader("token") String token, @PathVariable("user-id") Long userId) {
        // формируем ответ
        CommunitiesResponseDto responseBody = CommunitiesResponseDto.builder()
                .data(usersService.getCommunitiesByUser(userId))
                .build();
        // возвращаем его как результат
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/{user-id}/communities")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<CommunitiesResponseDto> addCommunityToUser(@RequestHeader("token") String token,
                                                                     @PathVariable("user-id") Long userId,
                                                                     @RequestBody CommunityForUserForm community) {
        CommunitiesResponseDto responseBody = CommunitiesResponseDto.builder()
                .data(usersService.addCommunityToUser(userId, community))
                .build();
        return ResponseEntity.status(201).body(responseBody);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<UsersResponseDto> getAllUsers(@RequestHeader("token") String token) {
        UsersResponseDto responseBody = UsersResponseDto.builder()
                .data(usersService.getAllUsers())
                .build();
        return ResponseEntity.ok(responseBody);
    }
}
