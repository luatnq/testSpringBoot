package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceInter {
    List<Book> getAllBook();
    List<Book> container(String bookName);
    Optional<Book> findBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
    void deleteAllBook();
}
