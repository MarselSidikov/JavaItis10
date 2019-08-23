package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.springboot.forms.SignUpForm;
import ru.itis.springboot.services.UsersService;

@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;

    @GetMapping( value = "/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(SignUpForm form) {
        usersService.signUp(form);
        return "redirect:/signIn";
    }
}
