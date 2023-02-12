package com.example.phonebook.controller;

import com.example.phonebook.model.entity.User;
import com.example.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path="/register")
    public String createUserForm(Model model) {
        model.addAttribute("user",new User());
        return "add-user";
    }

    @PostMapping(path="/register")
    public String createUser(@ModelAttribute User user){
        userService.create(user);
        return "redirect:/login";
    }

    @GetMapping(path="/edit/{id}")
    public String editUserForm(Model model, @PathVariable Integer id) {
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "edit-user";
    }

    @PostMapping(path="/edit/{id}")
    public String editUser(User user){
        userService.update(user);
        return "redirect:/contacts/all";
    }

}
