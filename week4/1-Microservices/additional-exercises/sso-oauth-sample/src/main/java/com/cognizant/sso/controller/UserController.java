package com.cognizant.sso.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
@RestController
public class UserController {
    
    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @GetMapping("/secure")
    public String getSecureData() {
        return "This is secured by OAuth2 Resource Server / Custom JWT";
    }
}
