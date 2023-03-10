package com.example.phonebook.repository;

import com.example.phonebook.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
