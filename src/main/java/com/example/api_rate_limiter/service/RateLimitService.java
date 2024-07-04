package com.example.api_rate_limiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api_rate_limiter.model.RateLimit;
import com.example.api_rate_limiter.repository.RateLimitRepository;

@Service
public class RateLimitService {

    @Autowired
    private RateLimitRepository rateLimitRepository;

    public RateLimit getRequestPerMin(String title) {
        return rateLimitRepository.findByTitle(title);
    }
}
