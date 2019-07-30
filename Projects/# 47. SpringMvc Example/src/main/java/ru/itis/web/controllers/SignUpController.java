package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.services.UsersService;

@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage() {
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(SignUpForm form) {
        usersService.signUp(form);
        return "redirect:/signIn";
    }
}
