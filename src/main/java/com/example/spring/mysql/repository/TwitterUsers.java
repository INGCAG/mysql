package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.TwitterUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface TwitterUsers extends CrudRepository<TwitterUser, Long> {
    Optional<TwitterUser> findById(Long userId);
}
