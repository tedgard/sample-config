package com.edgard;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edgard.domain.Book;
import com.edgard.repository.BookRepository;

public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) throws ParseException {
		
		//try (AnnotationConfigApplicationContext context = 
		//		new AnnotationConfigApplicationContext(DataConfiguration.class) ){
		
		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("application-context.xml")){
		
			logger.info("Starting the application");
			
			//BookService bookService = context.getBean(BookService.class);
			BookRepository bookRepository = context.getBean(BookRepository.class);
			Book book = bookRepository.findByTitle("Edgard Alan Poe");
			System.out.println("Book found : "+ book);

			System.out.println("Query One ");
			bookRepository.queryOne().stream().forEach(item -> System.out.println("-- "+item));
			
			System.out.println("Query Two ");
			bookRepository.queryTwo(280).stream().forEach(item -> System.out.println("-- "+item));
			
			System.out.println("Query Three ");
			bookRepository.queryThree("Edgard Alan Poe").stream().forEach(item -> System.out.println("-- "+item));
			
		} 
		
	}
	
	
	/*
	 * 
	 * 
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
	
}
