package com.cognizant.payment.controller;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PaymentController {
    
    @GetMapping("/pay")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String processPayment() {
        // Deliberately slow API stub or failure simulation
        if (Math.random() > 0.5) {
            throw new RuntimeException("Third party API failed!");
        }
        return "Payment processed successfully!";
    }
    
    public String fallbackPayment(Throwable t) {
        return "Fallback: Payment processing is currently degraded. Please try again later.";
    }
}
