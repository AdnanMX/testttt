package com.adnanmaulana.restapi.service;

import java.util.List;
import java.util.Optional;

import com.adnanmaulana.restapi.entity.Book;

public interface BookService {
    
    void addBook(Book book);

    List<Book> getAllBook();

    Optional<Book> getBookById(Long id);

    List<Book> getBookByTitle(String title);

    List<Book> getBookByAuthor(String author);

    List<Book> getBookByYear(Integer year);

    void updateBook(Book book);

    void deleteBookById(Long id);
}
