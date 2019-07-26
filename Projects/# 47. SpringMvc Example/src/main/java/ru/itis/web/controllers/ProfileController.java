package ru.itis.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    @RequestMapping(value = "/profile")
    public String getProfilePage() {
        return "profile";
    }
}
