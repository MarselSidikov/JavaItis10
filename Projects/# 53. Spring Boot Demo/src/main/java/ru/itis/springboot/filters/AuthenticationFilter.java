package ru.itis.springboot.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springboot.dto.UserDto;
import ru.itis.springboot.services.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Component
public class AuthenticationFilter implements Filter {

    @Autowired
    private UsersService usersService;

    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Request in Filter");
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
