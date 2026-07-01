package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for BookRepository (for Setter Injection)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] BookRepository injected via setter injection.");
    }

    public void executeServiceMethod() {
        System.out.println("[BookService] Delegating call to BookRepository...");
        if (bookRepository != null) {
            bookRepository.executeRepositoryMethod();
        } else {
            System.out.println("[BookService] Error: BookRepository is not injected!");
        }
    }
}
