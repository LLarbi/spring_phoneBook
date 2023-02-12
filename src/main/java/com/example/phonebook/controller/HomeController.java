package com.example.phonebook.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path="/login")
public class HomeController {

    @GetMapping()
    public String home() {
        return "login";
    }
}
