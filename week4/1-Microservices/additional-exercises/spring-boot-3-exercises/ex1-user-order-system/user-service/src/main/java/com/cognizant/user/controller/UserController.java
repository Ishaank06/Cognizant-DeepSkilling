package com.cognizant.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable String id) {
        // Mock DB retrieval
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "John Doe");
        user.put("email", "john.doe@example.com");
        return user;
    }
}
