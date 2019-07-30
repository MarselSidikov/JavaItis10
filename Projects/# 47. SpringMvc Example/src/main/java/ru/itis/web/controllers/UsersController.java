package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.UserDto;
import ru.itis.web.services.UsersService;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        List<UserDto> users = usersService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }
}
