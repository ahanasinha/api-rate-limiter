package com.example.api_rate_limiter.repository;

import com.example.api_rate_limiter.model.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserLoginRepository extends MongoRepository<UserLogin, String> {
    Optional<UserLogin> findByUsername(String username);
}