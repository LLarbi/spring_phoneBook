package com.example.phonebook.controller;

import com.example.phonebook.model.entity.User;
import com.example.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path="/register")
    public String FormCreateUser(Model model) {
        model.addAttribute("user",new User());
        return "add-user";
    }

    @PostMapping(path="/register")
    public String CreateUser(@ModelAttribute User user){
        userService.create(user);
        return "redirect:/users/register";
    }

}
