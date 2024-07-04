package com.example.api_rate_limiter.model;

public class Restaurant {
    private String name;
    private String address;

    // Constructors, getters, and setters
    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}