package com.example.phonebook.security;

import com.example.phonebook.model.entity.User;
import com.example.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            final User user = userRepository.findByEmail(username);
            if(user == null){
                throw  new UsernameNotFoundException(("This user Not found with selected username :"+ username));
            }
            UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                    .password(user.getPassword())
                    .authorities("USER").build();

            return userDetails;
    }

}
