package com.example.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "{ \"message\": \"Hello " + firstName + " " + lastName + " from BridgeLabz\" }";
        } else if (firstName != null) {
            return "{ \"message\": \"Hello " + firstName + " from BridgeLabz\" }";
        } else if (lastName != null) {
            return "{ \"message\": \"Hello " + lastName + " from BridgeLabz\" }";
        } else {
            return "{ \"message\": \"Hello World from BridgeLabz\" }";
        }
    }
}
