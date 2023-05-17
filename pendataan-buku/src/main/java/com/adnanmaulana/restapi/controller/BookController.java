package com.adnanmaulana.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adnanmaulana.restapi.entity.Book;
import com.adnanmaulana.restapi.service.impl.BookServiceImpl;

@RestController
@RequestMapping("/api/book")
public class BookController {
    
    @Autowired
    BookServiceImpl bookService;

    // Post
    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // Get
    @GetMapping
    public ResponseEntity getAllBook() {
        List<Book> book = bookService.getAllBook();

        return ResponseEntity.ok(book);
    }

    @GetMapping
    @RequestMapping("/id")
    public ResponseEntity getBookById(@RequestParam Long id) {
        Optional<Book> book =  bookService.getBookById(id);

        return ResponseEntity.ok(book);
    }

    @GetMapping
    @RequestMapping("/title")
    public ResponseEntity getBookByTitle(@RequestParam String title) {
        List<Book> book =  bookService.getBookByTitle(title);

        return ResponseEntity.ok(book);
    }

    @GetMapping
    @RequestMapping("/author")
    public ResponseEntity getBookByAuthor(@RequestParam String author) {
        List<Book> book =  bookService.getBookByAuthor(author);

        return ResponseEntity.ok(book);
    }

    @GetMapping
    @RequestMapping("/year")
    public ResponseEntity getBookByYear(@RequestParam Integer year) {
        List<Book> book =  bookService.getBookByYear(year);

        return ResponseEntity.ok(book);
    }

    // Put
    @PutMapping
    public ResponseEntity updateBook(@RequestParam Long id, @RequestBody Book book) {
        Optional<Book> existingBook = bookService.getBookById(id);

        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setYear(book.getYear());

            bookService.updateBook(updatedBook);

            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping
    public ResponseEntity deleteBookById(@RequestParam Long id) {
        bookService.deleteBookById(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    
}
