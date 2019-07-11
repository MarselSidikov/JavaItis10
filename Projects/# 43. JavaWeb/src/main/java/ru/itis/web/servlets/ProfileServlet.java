package ru.itis.web.servlets;

import lombok.SneakyThrows;
import ru.itis.web.models.User;
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

public class ProfileServlet extends HttpServlet {

    private UsersService usersService;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) throws ServletException {
        usersService = (UsersService)config.getServletContext().getAttribute("usersService");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cookie cookies[] = request.getCookies();

        boolean isFindCookie = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("clientId")) {
                    Optional<User> userCandidate = usersService.getUserByCookie(cookie.getValue());
                    if (userCandidate.isPresent()) {
                        isFindCookie = true;
                        request.setAttribute("user", userCandidate.get());
                        request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(request, response);
                    }
                }
            }
        }
        if (!isFindCookie) {
            response.sendRedirect("/signIn");
        }
    }
}
