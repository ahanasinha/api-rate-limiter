package com.example.api_rate_limiter.service;

import com.example.api_rate_limiter.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantService {
    public List<Restaurant> getNearbyRestaurants() {
        // Mock data for nearby restaurants
        return Arrays.asList(
            new Restaurant("Restaurant A", "123 Main St"),
            new Restaurant("Restaurant B", "456 Oak St"),
            new Restaurant("Restaurant C", "789 Pine St")
        );
    }
}