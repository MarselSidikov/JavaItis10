package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.CarForm;
import ru.itis.web.models.Car;
import ru.itis.web.services.CarsService;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    private CarsService carsService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCarsPage(Model model, @RequestParam("user") Long userId) {
        List<Car> cars = carsService.getCarsByUserId(userId);
        model.addAttribute("cars", cars);
        model.addAttribute("userId", userId);
        return "cars";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Car> addCarToUser(@RequestParam("user") Long userId,
                                  @RequestBody CarForm form) {
        carsService.addCarToUser(userId, form);
        return carsService.getCarsByUserId(userId);
    }
}
