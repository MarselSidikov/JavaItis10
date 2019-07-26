package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SignInController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(SignInForm form, HttpServletResponse response) {
        usersService.signIn(form);
        Optional<String> cookieCandidate = usersService.signIn(form);

        if (cookieCandidate.isPresent()) {
            Cookie cookie = new Cookie("clientId", cookieCandidate.get());
            response.addCookie(cookie);
            return new ModelAndView("redirect:/profile");
        } else {
            return new ModelAndView("redirect:/signIn");
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage() {
        return "signIn";
    }
}
