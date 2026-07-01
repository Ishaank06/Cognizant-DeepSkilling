package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   Exercise 1: Basic Spring Application Setup       ");
        System.out.println("====================================================");

        // Load application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve beans independently
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        BookService bookService = (BookService) context.getBean("bookService");

        // Use beans
        bookRepository.saveBook("Spring Boot in Action");
        bookService.executeServiceMethod();

        System.out.println("====================================================");
    }
}
