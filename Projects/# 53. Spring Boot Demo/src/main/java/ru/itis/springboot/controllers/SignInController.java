package ru.itis.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping(value = "/signIn")
    public String getSignInPage() {
        return "signIn";
    }
}
