package com.example.api_rate_limiter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.api_rate_limiter.model.RateLimit;

public interface RateLimitRepository extends MongoRepository<RateLimit, String> {
    RateLimit findByTitle(String title);
}
