package com.edgard;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.edgard.domain.Book;
import com.edgard.repository.BookRepository;

@SpringBootApplication
public class SpringDataAppApplication {
	
	public static Logger logger = Logger.getLogger(SpringDataAppApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataAppApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);
		
		Book book = new Book();
		book.setTitle("Edgard Alan Poe");
		book.setPageCount(230);
		book.setPublishedDate(new Date());
		
		logger.info("Getting ready to save "+book);
		
		book = repository.save(book);
		
		logger.info("After being saved : "+book);
	}
}
