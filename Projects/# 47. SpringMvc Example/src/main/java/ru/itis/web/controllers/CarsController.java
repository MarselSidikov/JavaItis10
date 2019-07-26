package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
    public ModelAndView getCarsPage(@RequestParam("user") Long userId) {
        ModelAndView modelAndView = new ModelAndView("cars");
        List<Car> cars = carsService.getCarsByUserId(userId);
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("userId", userId);
        return modelAndView;
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
