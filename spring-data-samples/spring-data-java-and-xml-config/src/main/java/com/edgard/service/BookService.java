package com.edgard.service;

import java.util.List;

import com.edgard.domain.Book;

public interface BookService {

	public Book save(Book book);
	
	public List<Book> findAll();
}
