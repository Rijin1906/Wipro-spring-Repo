package com.wipro.service;

import java.util.List;

import com.wipro.entity.Book;
import com.wipro.exception.BookException;

public interface BookService {
	
	public Book getBookById(Long isbn) throws BookException;
	public abstract List<Book> getAllBooks() throws BookException;
	public abstract String addBook(Book book) throws BookException;
	public abstract String updateBook(Book book) throws BookException;
	public abstract String deleteBook(Long isbn) throws BookException;
	
	public List<Book> getBooksByAuthor(String author) throws BookException;
	
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price) throws BookException;
	public List<Book> fetchAllBooks() throws BookException;

}
