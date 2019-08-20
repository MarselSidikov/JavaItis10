package ru.itis.web.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.web.dto.UserDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RolesFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
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
