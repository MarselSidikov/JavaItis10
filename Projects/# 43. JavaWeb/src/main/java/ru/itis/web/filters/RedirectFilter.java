package ru.itis.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // если запрос был авторизован
        if (isAuthorized(request)) {
            // если запрошена страница корня, входа или регистрации
            if (isRootPage(request) || isSignInPage(request) || isSignUpPage(request)) {
                // отправляем клиента на страницу профиля
                response.sendRedirect("/profile");
            } else {
                // если была запрошена любая другая странциа - разрешаем запрос и отправляем дальше
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            // если пользователь не был авторизован, и просит любую странцу, кроме регистрации и авторизации
            if (!isSignInPage(request) && !isSignUpPage(request)) {
                // отправляем его на авторизацию
                response.sendRedirect("/signIn");
            } else {
                // в противном случае отдаем ему ту страницу, которую он просил
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    // проверяет наличие атрибута user в запросе 
    private boolean isAuthorized(ServletRequest request) {
        return request.getAttribute("user") != null;
    }

    private boolean isSignInPage(HttpServletRequest request) {
        return request.getServletPath().equals("/signIn");
    }

    private boolean isRootPage(HttpServletRequest request) {
        return request.getServletPath().equals("/");
    }

    private boolean isSignUpPage(HttpServletRequest request) {
        return request.getServletPath().equals("/signUp");
    }


}
