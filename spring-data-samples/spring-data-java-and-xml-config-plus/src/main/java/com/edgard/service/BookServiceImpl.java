package com.edgard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgard.domain.Book;
import com.edgard.repository.BookRepository;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository; 
	
	public Book save(Book book){
		return bookRepository.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
}
