package com.edgard.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "BOOK")
/*@NamedQueries({
	@NamedQuery(name="Book.queryOne", query = "select b from Book b "),
	@NamedQuery(name="Book.queryTwo", query = "select b from Book b where b.pageCount > ?1"),
	@NamedQuery(name="Book.queryThree", query = "select b from Book b where b.title = :title")			
})*/
@EntityListeners(AuditingEntityListener.class)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	private String title;
	private int pageCount;
	private Date publishDate;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String lastModifiedBy;
	
	@CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date lastModifiedDate;

	public Book() {
		
	}
	
	public Book(String title, int pageCount, Date publishDate, BigDecimal price) {
		this.title = title;
		this.pageCount = pageCount;
		this.publishDate = publishDate;
		this.price = price;
	}
	
	public Long getBookId() {
		return bookId;
	}
	
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishedDate) {
		this.publishDate = publishedDate;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [bookId=").append(bookId).append(", title=").append(title).append(", pageCount=")
				.append(pageCount).append(", publishDate=").append(publishDate).append(", price=").append(price)
				.append(", author=").append(author).append(", createdBy=").append(createdBy).append(", lastModifiedBy=")
				.append(lastModifiedBy).append(", createdDate=").append(createdDate).append(", lastModifiedDate=")
				.append(lastModifiedDate).append("]");
		return builder.toString();
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
