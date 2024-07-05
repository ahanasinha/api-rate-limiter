package com.example.api_rate_limiter.controller;

import com.example.api_rate_limiter.model.Restaurant;
import com.example.api_rate_limiter.service.RateLimitingService;
import com.example.api_rate_limiter.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RateLimitingService rateLimitingService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getNearbyRestaurants(@RequestHeader("Title") String title) {
        if (!rateLimitingService.isAllowed(title)) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
        return ResponseEntity.ok(restaurantService.getNearbyRestaurants());
    }
}
