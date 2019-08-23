package ru.itis.springboot.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.itis.springboot.dto.UserDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RolesFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(RolesFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Request in Filter");
        UserDto currentUser = (UserDto) servletRequest.getAttribute("user");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        if (request.getMethod().equals("POST") && request.getServletPath().equals("/cars")) {
            if (currentUser != null && currentUser.isAdmin()) {
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(403);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
