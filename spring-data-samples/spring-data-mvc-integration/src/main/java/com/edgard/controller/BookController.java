package com.edgard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgard.domain.Book;
import com.edgard.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	BookRepository repository;

	@RequestMapping("/books")
	public String showBooks(Model model, Pageable pageable, Sort sort) {
		model.addAttribute("sort", (sort == null ? "" : sort.iterator().next().getProperty()));
		model.addAttribute("page", repository.findAll(pageable));
		return "books";
	}

	
	@RequestMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Book book, Model model) {
		model.addAttribute("book", book);
		return "book";
	}
	
	/*
	@RequestMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		model.addAttribute("book", repository.findOne(bookId));
		return "book";
	}
	*/
}
