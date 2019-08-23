package ru.itis.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @GetMapping(value = "/profile")
    public String getProfilePage() {
        return "profile";
    }
}
