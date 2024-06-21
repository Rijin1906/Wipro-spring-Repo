package com.wipro.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.wipro.dao.BookDAO;
import com.wipro.dao.BookDaoImpl;
import com.wipro.entity.Book;
import com.wipro.exception.BookException;

import jakarta.persistence.PersistenceException;


public class BookServiceImpl implements BookService {

	private BookDAO bookDAO = new BookDaoImpl();	
	private Logger serviceLogger = Logger.getLogger(BookServiceImpl.class);

	@Override
	public Book getBookById(Long isbn) throws BookException {
		try {
			Book book = bookDAO.getBookById(isbn);
			return book;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public List<Book> getAllBooks() throws BookException {
		try {
			List<Book> bookList = bookDAO.getAllBooks();
			return bookList;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public String addBook(Book book) throws BookException {
		try {
			String status = bookDAO.addBook(book);
			return status;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public String updateBook(Book book) throws BookException {
		try {
			String status = bookDAO.updateBook(book);
			return status;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public String deleteBook(Long isbn) throws BookException {
		try {
			String status = bookDAO.deleteBook(isbn);
			return status;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public List<Book> getBooksByAuthor(String author) throws BookException {
		try {
			List<Book> bookList = bookDAO.getBooksByAuthor(author);
			return bookList;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price) throws BookException {
		try {
			List<Book> bookList = bookDAO.getBooksByAuthorGreaterThanPrice(author, price);
			return bookList;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}
	@Override
	public List<Book> fetchAllBooks() throws BookException {
		try {
			List<Book> bookList = bookDAO.fetchAllBooks();
			return bookList;
		}catch(PersistenceException e) {
			serviceLogger.error("Error caugth in service layer", e);
			throw new BookException(e.getMessage(),e);
		}
	}


}
