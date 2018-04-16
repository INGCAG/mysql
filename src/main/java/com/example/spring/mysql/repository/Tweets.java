package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Tweets extends CrudRepository<Tweet, Long> {
        Optional<Tweet> findById(Long userId);
}
