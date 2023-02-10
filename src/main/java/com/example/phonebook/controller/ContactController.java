package com.example.phonebook.controller;

import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.User;
import com.example.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;


    @GetMapping(path="/all")
    public String getAllContacts(Model model) {
        List<Contact> contactList = contactService.getAllContacts();
        model.addAttribute("contacts", contactList);
        return "list-contacts";
    }

    @GetMapping(path="/add")
    public String addContactForm(Model model) {
        model.addAttribute("contact",new Contact());
        return "add-contact";
    }

    @PostMapping(path="/add")
    public String createUser(@ModelAttribute Contact contact){
        contactService.addContact(contact);
        return "redirect:/contacts/all";
    }

}
