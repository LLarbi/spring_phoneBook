package com.example.phonebook.service;

import com.example.phonebook.model.entity.User;
import com.example.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findById(Integer id) {
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            return userOpt.get();
        }
        return new User();
    }

    public void update(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

}
