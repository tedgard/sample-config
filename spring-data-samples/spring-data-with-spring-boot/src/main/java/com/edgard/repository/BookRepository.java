package com.edgard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgard.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
