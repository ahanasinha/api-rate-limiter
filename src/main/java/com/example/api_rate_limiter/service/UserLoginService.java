package com.example.api_rate_limiter.service;

import com.example.api_rate_limiter.model.UserLogin;
import com.example.api_rate_limiter.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository userRepository;

    public String authenticate(String username, String password) {
        Optional<UserLogin> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            UserLogin user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return UUID.randomUUID().toString(); // Generate a random token
            }
        }
        return null;
    }
    
    public Map<String, String> loginService(String username, String password) {
        String token = authenticate(username, password);
        Map<String, String> response = new HashMap<>();
        if (token != null) {
            response.put("token", token);
        } else {
            response.put("error", "Invalid username or password");
        }
        return response;
    }
}
