package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   Exercise 2: Dependency Injection (Setter DI)     ");
        System.out.println("====================================================");

        // Load the context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Invoke the method to test the Dependency Injection
        bookService.executeServiceMethod();

        System.out.println("====================================================");
    }
}
