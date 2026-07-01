package com.library.repository;

public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("[BookRepository] Book '" + bookName + "' saved to the catalog.");
    }
}
