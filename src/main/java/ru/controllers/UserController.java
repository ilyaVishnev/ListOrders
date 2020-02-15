package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.dao.services.UserService;
import ru.models.Order;
import ru.models.User;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/")
    public String getMenu(){
        return "menu";
    }

    @PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Order> getUserById(@RequestBody(required = false) String id) {
        User user = userService.findUserById(id);
        return user.getOrders();
    }
}
