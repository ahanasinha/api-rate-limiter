package com.example.api_rate_limiter.controller;

import com.example.api_rate_limiter.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserLoginController {

    @Autowired
    private UserLoginService userService;

    @GetMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        return userService.loginService(username, password);
    }
    
    @GetMapping("/getHotel")
    public Map<String, Object> getHotel(@RequestParam String token) {
        boolean isValidToken = userService.validateJwtToken(token);
        Map<String, Object> response = new HashMap<>();
        if (isValidToken) {
            List<String> hotels = Arrays.asList("Hotel1", "Hotel2", "Hotel3");
            response.put("hotels", hotels);
        } else {
            response.put("error", "Token mismatch");
        }
        return response;
    }
}
