package ru.itis.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ru.itis.web.dto.CarForm;
import ru.itis.web.models.Car;
import ru.itis.web.services.CarsService;
import ru.itis.web.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    private CarsService carsService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void init(ServletConfig config) throws ServletException {
        carsService = (CarsService) config.getServletContext().getAttribute("carsService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdAsString = request.getParameter("user");
        Long userId = Long.parseLong(userIdAsString);
        List<Car> cars = carsService.getCarsByUserId(userId);
        request.setAttribute("cars", cars);
        request.setAttribute("userId", userId);
        request.getRequestDispatcher("WEB-INF/jsp/cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdAsString = request.getParameter("user");
        Long userId = Long.parseLong(userIdAsString);
        String body = request.getReader().lines().collect(Collectors.joining());
        System.out.println(body);
        CarForm form = objectMapper.readValue(body, CarForm.class);
        carsService.addCarToUser(userId, form);
        List<Car> cars = carsService.getCarsByUserId(userId);
        String responseBody = objectMapper.writeValueAsString(cars);
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(responseBody);
    }
}
