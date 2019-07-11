package ru.itis.web.servlets;

import lombok.SneakyThrows;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.models.CookieValue;
import ru.itis.web.repositories.CookieValuesRepository;
import ru.itis.web.repositories.CookieValuesRepositoryJdbcImpl;
import ru.itis.web.repositories.UsersRepository;
import ru.itis.web.repositories.UsersRepositoryJdbcImpl;
import ru.itis.web.services.UsersService;
import ru.itis.web.services.UsersServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.Properties;

public class SignInServlet extends HttpServlet {

    private UsersService usersService;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) throws ServletException {
        usersService = (UsersService)config.getServletContext().getAttribute("usersService");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/signIn.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SignInForm form = SignInForm.builder()
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .build();

        Optional<String> cookieCandidate = usersService.signIn(form);

        if (cookieCandidate.isPresent()) {
            Cookie cookie = new Cookie("clientId", cookieCandidate.get());
            response.addCookie(cookie);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/signIn");
        }
    }
}
