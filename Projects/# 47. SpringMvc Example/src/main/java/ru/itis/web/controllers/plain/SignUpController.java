package ru.itis.web.controllers.plain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements Controller {

    @Autowired
    private UsersService usersService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            return new ModelAndView("signUp");
        } else {
            SignUpForm form = SignUpForm.builder()
                    .firstName(httpServletRequest.getParameter("firstName"))
                    .lastName(httpServletRequest.getParameter("lastName"))
                    .login(httpServletRequest.getParameter("login"))
                    .password(httpServletRequest.getParameter("password"))
                    .build();

            usersService.signUp(form);
            return new ModelAndView("redirect:/signIn");
        }
    }
}
