package com.adnanmaulana.restapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adnanmaulana.restapi.entity.Book;
import com.adnanmaulana.restapi.repository.BookRepository;
import com.adnanmaulana.restapi.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        return book;
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        List<Book> book = bookRepository.findByTitle(title);

        return book;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        List<Book> book = bookRepository.findByAuthor(author);

        return book;
    }

    @Override
    public List<Book> getBookByYear(Integer year) {
        List<Book> book = bookRepository.findByYear(year);

        return book;
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }


    
}
