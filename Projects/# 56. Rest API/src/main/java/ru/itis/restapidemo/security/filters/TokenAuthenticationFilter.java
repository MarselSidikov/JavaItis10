package ru.itis.restapidemo.security.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.itis.restapidemo.security.authentication.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenAuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("IN FILTER");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getParameter("token");
        if (token != null) {
            TokenAuthentication authentication = new TokenAuthentication();
            authentication.setToken(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
