package com.wipro.dao;

import java.util.List;

import com.wipro.entity.Book;

import jakarta.persistence.PersistenceException;


public interface BookDAO {

	public Book getBookById(Long isbn) throws PersistenceException;
	public abstract List<Book> getAllBooks() throws PersistenceException;
	public abstract String addBook(Book book) throws PersistenceException;
	public abstract String updateBook(Book book) throws PersistenceException;
	public abstract String deleteBook(Long isbn) throws PersistenceException;
	
	public List<Book> getBooksByAuthor(String author) throws PersistenceException;
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price) throws PersistenceException;
	public List<Book> fetchAllBooks() throws PersistenceException;
	
}
