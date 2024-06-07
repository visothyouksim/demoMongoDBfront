package com.example.demoMongoDBfront.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.example.demoMongoDBfront.models.User;
import com.example.demoMongoDBfront.services.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RestClient.Builder restClientBuilder;

    @GetMapping("/allUsers")
    public String allUsers(Model model) {
        List<User> user = userService.getUsers("users");
        model.addAttribute("users", user);
        return "users";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        User newUser = new User("", "", "", "");
        model.addAttribute("user", newUser);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/allUsers";
    }

}
