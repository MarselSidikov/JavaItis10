package ru.itis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springboot.dto.CarDto;
import ru.itis.springboot.dto.CarModelDto;
import ru.itis.springboot.forms.CarForm;
import ru.itis.springboot.services.CarsService;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    private CarsService carsService;

    @GetMapping(value = "/cars")
    public String getCarsPage(Model model, @RequestParam("user") Long userId) {
        List<CarDto> cars = carsService.getCarsByUserId(userId);
        model.addAttribute("cars", cars);
        model.addAttribute("userId", userId);
        return "cars";
    }

    @PostMapping(value = "/cars")
    @ResponseBody
    public List<CarDto> addCarToUser(@RequestParam("user") Long userId,
                                     @RequestBody CarForm form) {
        carsService.addCarToUser(userId, form);
        return carsService.getCarsByUserId(userId);
    }

    @GetMapping(value = "/cars/search")
    @ResponseBody
    public List<CarModelDto> getCarModelsBySearch(@RequestParam("q") String query) {
        return carsService.getCarModelsBySearch(query);
    }
}
