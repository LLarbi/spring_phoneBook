package com.example.phonebook.service;

import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.User;
import com.example.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public void addContact(Contact contact){
        contactRepository.save(contact);
    }

    public Contact findById(Integer id) {
        Optional<Contact> contactOpt = contactRepository.findById(id);
        if(contactOpt.isPresent()){
            return contactOpt.get();
        }
        return new Contact();
    }

    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }
}
