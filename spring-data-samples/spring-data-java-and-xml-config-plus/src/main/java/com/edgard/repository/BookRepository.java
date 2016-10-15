package com.edgard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edgard.domain.Book;

@Repository
public interface BookRepository extends BaseRepository<Book, Long>{

	public Book findByTitle(String title);
	
	@Query("select b from Book b ")
	public List<Book> queryOne();
	
	@Query("select b from Book b where b.pageCount > ?1")
	public List<Book> queryTwo(int pageCount);
	
	@Query("select b from Book b where b.title = :title")
	public List<Book> queryThree(@Param("title") String title);
	
	public Collection<Book> findByPageCountGreaterThan(int pageCount);
	
	public Page<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);
	
	public Slice<Book> findByPriceGreaterThan(int pageCount, Pageable pageable);
	
	public List<Book> findByPageCountGreaterThan(int pageCount, Sort sort);
	
	
	/* ******* Modifying queries ******* */
	
	@Transactional
	@Modifying
	@Query("update Book b set b.pageCount = ?2 where b.title like ?1")
	public int setPageCount(String title, int pageCount);
	
	
	
	/*
	 * 
	 * 
	
	public List<Book> queryOne();
	
	public List<Book> queryTwo(int pageCount);
	
	public List<Book> queryThree(@Param("title") String title);
	
	@Query("select b from Book b ")
	public List<Book> queryOne();
	
	@Query("select b from Book b where b.pageCount > ?1")
	public List<Book> queryTwo(int pageCount);
	
	@Query("select b from Book b where b.title = :title")
	public List<Book> queryThree(@Param("title") String title);
	
	public List<Book> findByTitleContainingOrderByTitleAsc(String title);
	public List<Book> findByTitleContainingOrderByTitleDesc(String title);
	
	public List<Book> findTopByOrderByPageCountDesc();
	public List<Book> findFirstByOrderByPageCountAsc();
	
	public List<Book> findTop5ByOrderByPriceDesc();
	public List<Book> findTop5ByTitleContainingOrderByPriceAsc(String title);
	 
	public List<Book> findByPublishedDateAfter(Date date);
	public List<Book> findByPublishedDateBefore(Date date);
	public List<Book> findByPublishedDateBetween(Date date, Date date2);
	
	public List<Book> findByTitleContainingOrTitleContaining(String title1, String title2);
	public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
	public List<Book> findByTitleNot(String title);
	
	public List<Book> findByTitleLike(String title);
	public List<Book> findByTitleContaining(String title);
	public List<Book> findByTitleStartingWith(String title);
	public List<Book> findByTitleEndingWith(String title);
	public List<Book> findByTitleIgnoreCase(String title);
	
	public List<Book> findByPageCountEquals(int pageCount);
	public List<Book> findByPageCountGreaterThan(int pageCount);
	public List<Book> findByPageCountLessThan(int pageCount);
	public List<Book> findByPageCountGreaterThanEqual(int pageCount);
	public List<Book> findByPageCountLessThanEqual(int pageCount);
	public List<Book> findByPageCountBetween(int min, int max);
	*/
}
