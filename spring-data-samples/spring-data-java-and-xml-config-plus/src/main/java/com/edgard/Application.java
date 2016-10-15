package com.edgard;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edgard.domain.Book;
import com.edgard.repository.BookRepository;

public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) throws ParseException {
		
		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("application-context.xml")){
		
			logger.info("Starting the application");
			
			BookRepository bookRepository = context.getBean(BookRepository.class);
			Book book = new Book("Edgard NDOUNA", 75, new Date(), new BigDecimal("25.00"));
			bookRepository.save(book);
			System.out.println("--- Saved : "+bookRepository.findOne(book.getBookId()));
			
			/* *********** Modifying queries ********** */
			System.out.println("--- return update "+ bookRepository.setPageCount("Edgard Alan Poe", 980));
			bookRepository.findAll().stream().forEach(item -> System.out.println("-- "+item));
			
			System.out.println("--- return version 2 of update  "+ bookRepository.setPageCount("%dgard%", 1200));
			bookRepository.findAll().stream().forEach(item -> System.out.println("-- "+item));
		} 
		
	}
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	  //bookRepository.findAll().stream().forEach(b -> System.out.println("--- "+b));
			//bookRepository.findByIds(1L, 4L).stream().forEach(b -> System.out.println("--- "+b));
			//for(long x = 0; x < 4; x++){
			//	bookRepository.findByIds(x);
			//}
			
		
	
		BookService bookService = context.getBean(BookService.class);
		Book book = new Book("Edgard NDOUNA", 75, new Date(), new BigDecimal("25.00"));
		book = bookService.save(book);
		logger.info("Book freshly saved : "+book);
		logger.info("All the books : ");
		bookService.findAll().stream().forEach(item -> System.out.println("-- "+item));
		
		logger.info("------- Now performing operation directly on BookRepository------");
		BookRepository bookRepository = context.getBean(BookRepository.class);
		logger.info("Book #2 : "+bookRepository.findOne(2L));
	
		logger.info("------- Ids Matching ------");
	
		logger.info("3 Books : "+bookRepository.findAll(new ArrayList<Long>(){{
			add(1L); 
			add(2L);
			add(7L);
			}})
		);
		
		bookRepository.deleteAllInBatch();
		logger.info("All the books : ");
		bookService.findAll().stream().forEach(item -> System.out.println("-- "+item));
	 */
	
	
	
	/*
	 * 
	 	try (AnnotationConfigApplicationContext context = 
		//		new AnnotationConfigApplicationContext(DataConfiguration.class) ){
		
		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("application-context.xml")){
		
			logger.info("Starting the application");
			
			//BookService bookService = context.getBean(BookService.class);
			BookRepository bookRepository = context.getBean(BookRepository.class);
			
			//bookRepository.findAll(new PageRequest(0, 2)).stream().forEach(item -> System.out.println("-- "+item));
			for(Book book : bookRepository.findAll(new PageRequest(0, 10))){
				System.out.println("--- "+book);
			}
			
			
			//System.out.println("--> " +bookRepository.findByPageCountGreaterThan(100, new PageRequest(0, 10)));
			//bookRepository.findByPageCountGreaterThan(120, new PageRequest(0, 10)).stream().forEach(item -> System.out.println("-- "+item));
			
			for(Book book : bookRepository.findAll(new Sort(Sort.Direction.DESC,  "pageCount").and(new Sort(Sort.Direction.ASC, "price")))){
				System.out.println("--- "+book);
			}
			
			Slice<Book> slice = bookRepository.findByPageCountGreaterThan(120, new PageRequest(0,3));
			slice.forEach(item -> System.out.println("---> "+item));
		} 
	 * 
	 * 
	 * 
	 */
	
}
