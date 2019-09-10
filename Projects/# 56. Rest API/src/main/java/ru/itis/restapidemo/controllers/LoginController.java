package ru.itis.restapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.restapidemo.dto.TokenResponseDto;
import ru.itis.restapidemo.forms.UserCredentialsForm;
import ru.itis.restapidemo.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<TokenResponseDto> login(@RequestBody UserCredentialsForm form) {
        TokenResponseDto responseBody = TokenResponseDto.builder()
                .data(loginService.login(form))
                .build();
        return ResponseEntity.ok(responseBody);
    }
}
