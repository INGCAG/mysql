package com.example.spring.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.mysql.model.User;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface Users extends CrudRepository<User, Long> {
    Optional<User> findById(Long userId);
}
