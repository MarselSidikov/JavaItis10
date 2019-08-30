package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private Map<String, User> users;

    @Override
    public void init() throws ServletException {
        users = new HashMap<>();
        User marsel =  User.builder()
                .name("Marsel Sidikov")
                .login("marsel")
                .build();

        User aina = User.builder()
                .name("Aina")
                .login("aina")
                .build();

        User nadir = User.builder()
                .name("Nadir")
                .login("nadir")
                .build();

        users.put("marsel", marsel);
        users.put("aina", aina);
        users.put("nadir", nadir);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            request.setAttribute("user", session.getAttribute("user"));
            request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/jsp/signIn.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String userLogin = request.getParameter("login");
        if (users.get(userLogin) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", users.get(userLogin));
        }
    }
}
