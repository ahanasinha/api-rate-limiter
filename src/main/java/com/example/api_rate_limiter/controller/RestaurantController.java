package com.example.api_rate_limiter.controller;

import com.example.api_rate_limiter.service.RateLimitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RateLimitingService rateLimitingService;

    @GetMapping("/restaurants")
    public ResponseEntity<?> getNearbyRestaurants(@RequestHeader("Title") String title) {
        return rateLimitingService.checkRateLimitAndGetResponse(title);
    }
}