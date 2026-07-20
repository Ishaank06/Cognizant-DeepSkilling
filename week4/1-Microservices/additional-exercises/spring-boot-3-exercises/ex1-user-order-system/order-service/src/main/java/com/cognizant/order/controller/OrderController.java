package com.cognizant.order.controller;

import com.cognizant.order.client.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final UserClient userClient;

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/{orderId}")
    public Map<String, Object> getOrder(@PathVariable String orderId) {
        // Mock Order
        Map<String, Object> order = new HashMap<>();
        order.put("orderId", orderId);
        order.put("product", "MacBook Pro");
        order.put("amount", 2000.0);
        
        // Fetch User details via Feign Client (Synchronous HTTP call to port 8080)
        Map<String, Object> user = userClient.getUserById("U1001");
        order.put("user", user);

        return order;
    }
}
