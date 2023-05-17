package com.adnanmaulana.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adnanmaulana.restapi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByTitle(String title);

    List<Book> findByYear(Integer year);

    List<Book> findByAuthor(String author);
    
}
