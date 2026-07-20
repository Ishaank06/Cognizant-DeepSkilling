package com.cognizant.product.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController {
    @Value("${dummy.config.message:Fallback Message}")
    private String configMessage;
    
    @GetMapping("/products/config")
    public String getConfig() { return configMessage; }
}
