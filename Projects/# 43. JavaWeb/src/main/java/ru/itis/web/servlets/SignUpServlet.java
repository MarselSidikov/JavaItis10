package ru.itis.web.servlets;

import lombok.SneakyThrows;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) throws ServletException {
        usersService = (UsersService)config.getServletContext().getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpForm form = SignUpForm.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .build();

        usersService.signUp(form);
        resp.sendRedirect("/signIn");
    }
}
