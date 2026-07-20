package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> authenticationRequest) throws Exception {
        String username = authenticationRequest.get("username");
        String password = authenticationRequest.get("password");

        // Hardcoded authentication check for the exercise
        if ("admin".equals(username) && "admin".equals(password)) {
            final String jwt = jwtUtil.generateToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
