package com.example.api_rate_limiter.controller;

import com.example.api_rate_limiter.model.Restaurant;
import com.example.api_rate_limiter.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getNearbyRestaurants() {
        return restaurantService.getNearbyRestaurants();
    }
    
    @GetMapping("/")
    public String home() {
        return "Welcome to API Rate Limiter Application!";
    }
}