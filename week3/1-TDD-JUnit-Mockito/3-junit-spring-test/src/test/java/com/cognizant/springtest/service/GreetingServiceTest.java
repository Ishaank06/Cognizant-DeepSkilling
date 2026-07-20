package com.cognizant.springtest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGreet_ReturnsHello() {
        String result = greetingService.greet();
        assertEquals("Hello", result, "The greet method should return 'Hello'");
    }
}
