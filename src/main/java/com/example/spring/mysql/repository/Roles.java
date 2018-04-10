package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface Roles extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long roleId);
}
