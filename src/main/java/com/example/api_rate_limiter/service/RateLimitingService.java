package com.example.api_rate_limiter.service;

import com.example.api_rate_limiter.model.RateLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimitingService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RateLimitService rateLimitService;

    public boolean isAllowed(String title) {
        // Fetch the rate limit configuration for the given client
        RateLimit rateLimitConfig = rateLimitService.getRequestPerMin(title);

        if (rateLimitConfig == null) {
            // If no configuration is found for the client, deny access by default
            return false;
        }

        int rateLimit = rateLimitConfig.getRequestPerMin();
        String key = "api_rate_limit:" + title;

        // Increment the request count
        Long currentCount = redisTemplate.opsForValue().increment(key, 1);

        if (currentCount == 1) {
            // Set the key to expire in 1 minute if it's the first increment
            redisTemplate.expire(key, Duration.ofMinutes(1));
        }

        return currentCount <= rateLimit;
    }
}
