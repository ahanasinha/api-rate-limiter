package com.example.api_rate_limiter.service;

import com.example.api_rate_limiter.model.RateLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.time.Duration;

@Service
public class RateLimitingService {
    @Autowired
    private RestaurantService restaurantService;
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RateLimitService rateLimitService;

    public boolean isAllowed(String title) {
        RateLimit rateLimitConfig = rateLimitService.getRequestPerMin(title);

        if (rateLimitConfig == null) {
            return false;
        }

        int rateLimit = rateLimitConfig.getRequestPerMin();
        String key = "api_rate_limit:" + title;

        Long currentCount = redisTemplate.opsForValue().increment(key, 1);

        if (currentCount == 1) {
            redisTemplate.expire(key, Duration.ofMinutes(1));
        }

        return currentCount <= rateLimit;
    }
    
    public ResponseEntity<?> checkRateLimitAndGetResponse(String title){
    	if (!isAllowed(title)) {
          return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
      }
      return ResponseEntity.ok(restaurantService.getNearbyRestaurants());
    }
}
