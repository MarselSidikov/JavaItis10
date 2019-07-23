package ru.itis.web.filters;

import ru.itis.web.dto.UserDto;
import ru.itis.web.models.User;
import ru.itis.web.services.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class AuthenticationFilter implements Filter {

    private UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.usersService = (UsersService) filterConfig.getServletContext().getAttribute("usersService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // преобразуем запросы к нужному виду
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // получаем все куки текущего запроса
        Cookie cookies[] = request.getCookies();
        // если какие-то куки есть
        if (cookies != null) {
            // пробегаем все куки
            for (Cookie cookie : cookies) {
                // если нашли нужную куку
                if (cookie.getName().equals("clientId")) {
                    // достаем пользователя по этой куке
                    Optional<UserDto> userCandidate = usersService.getUserByCookie(cookie.getValue());
                    // если пользователь есть
                    // кладем этого пользвателя в сам запрос как атрибут
                    userCandidate.ifPresent(user -> request.setAttribute("user", user));
                }
            }
        }
        // отправляем запрос дальше
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
