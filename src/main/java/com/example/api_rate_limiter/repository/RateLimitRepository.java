package com.example.api_rate_limiter.repository;

import com.example.api_rate_limiter.model.RateLimit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateLimitRepository extends MongoRepository<RateLimit, String> {
    RateLimit findByTitle(String title);
}
