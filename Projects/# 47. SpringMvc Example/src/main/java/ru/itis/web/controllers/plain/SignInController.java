package ru.itis.web.controllers.plain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class SignInController implements Controller {

    @Autowired
    private UsersService usersService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            return new ModelAndView("signIn");
        } else {
            SignInForm form = SignInForm.builder()
                    .login(httpServletRequest.getParameter("login"))
                    .password(httpServletRequest.getParameter("password"))
                    .build();

            Optional<String> cookieCandidate = usersService.signIn(form);

            if (cookieCandidate.isPresent()) {
                Cookie cookie = new Cookie("clientId", cookieCandidate.get());
                httpServletResponse.addCookie(cookie);
                return new ModelAndView("redirect:/profile");
            } else {
                return new ModelAndView("redirect:/signIn");
            }
        }
    }
}
