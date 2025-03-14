package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

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

    public Greeting saveGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + " from BridgeLabz";
        } else if (firstName != null) {
            message = "Hello " + firstName + " from BridgeLabz";
        } else if (lastName != null) {
            message = "Hello " + lastName + " from BridgeLabz";
        } else {
            message = "Hello World from BridgeLabz";
        }
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return Optional.of(greetingRepository.save(greeting));
        }
        return Optional.empty();
    }
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
