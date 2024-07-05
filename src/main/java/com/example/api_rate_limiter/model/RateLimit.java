package com.example.api_rate_limiter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foodzy")
public class RateLimit {

    @Id
    private String id;
    private String title;
    private int request_per_min;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRequestPerMin() {
        return request_per_min;
    }

    public void setRequestPerMin(int request_per_min) {
        this.request_per_min = request_per_min;
    }
}
