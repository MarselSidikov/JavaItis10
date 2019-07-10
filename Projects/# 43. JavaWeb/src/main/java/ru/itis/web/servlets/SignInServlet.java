package ru.itis.web.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if (!isAuthorized(request)) {
                writer.print("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "\t<title>Войти на сайт</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\t<form method='post'>\n" +
                        "\t\t<input type=\"text\" name=\"login\" placeholder=\"Login\">\n" +
                        "\t\t<input type=\"password\" name=\"password\" placeholder=\"Password\">\n" +
                        "\t\t<input type=\"submit\" value=\"Sign In\">\n" +
                        "</body>\n" +
                        "</html>");

            } else {
                response.sendRedirect("/profile");
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
       if (isCorrectCredentials(request)) {
           response.setHeader("set-cookie", "name=marsel");
           try {
               response.sendRedirect("/profile");
           } catch (IOException e) {
               throw new IllegalStateException(e);
           }
       } else {
           try {
               response.sendRedirect("/signIn");
           } catch (IOException e) {
               throw new IllegalArgumentException(e);
           }
       }
    }

    private boolean isCorrectCredentials(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        return  login.equals("marsel") && password.equals("qwerty007");
    }

    private boolean isAuthorized(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    return true;
                }
            }
        }
        return false;
    }
}
