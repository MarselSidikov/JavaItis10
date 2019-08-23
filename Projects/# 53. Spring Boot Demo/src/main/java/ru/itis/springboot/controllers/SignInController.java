package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.springboot.forms.SignInForm;
import ru.itis.springboot.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SignInController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/signIn")
    public String signIn(SignInForm form, HttpServletResponse response) {
        usersService.signIn(form);
        Optional<String> cookieCandidate = usersService.signIn(form);

        if (cookieCandidate.isPresent()) {
            Cookie cookie = new Cookie("clientId", cookieCandidate.get());
            response.addCookie(cookie);
            return "redirect:/profile";
        } else {
            return "redirect:/signIn";
        }
    }

    @GetMapping(value = "/signIn")
    public String getSignInPage() {
        return "signIn";
    }
}
