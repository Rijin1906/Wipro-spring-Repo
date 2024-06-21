package com.wipro.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/*
 *  Named queries: Named queries are used for building static queries using the following annotations
 *  @NamedQuery and @NamedQueries
 */

@Entity
@Table(name = "book_ch")
@NamedQueries(
		@NamedQuery(name = "fetchAllBooks",query = "select b from Book b")
		
		)
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long isbn;
	private String title;
	private String author;
	private LocalDate publishDate;
	private Double price;
	
	public Book() {
		
	}
	
	public Book(Long isbn, String title, String author, LocalDate publishDate, Double price) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publishDate=" + publishDate
				+ ", price=" + price + "]";
	}

	
}
