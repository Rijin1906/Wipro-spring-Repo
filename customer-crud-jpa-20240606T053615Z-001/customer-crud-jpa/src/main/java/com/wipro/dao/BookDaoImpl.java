package com.wipro.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.wipro.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class BookDaoImpl implements BookDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-crud-jpa");
	private static Logger logger = Logger.getLogger(BookDaoImpl.class);


	@Override
	public Book getBookById(Long isbn) throws PersistenceException {
		EntityManager entityManager = null;
		try {
			entityManager = emf.createEntityManager();
			Book book = entityManager.find(Book.class, isbn);
			if(book == null) {
				throw new PersistenceException("Invalid isbn");
			}
			return book;

		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	@Override
	public List<Book> getAllBooks() throws PersistenceException {
		EntityManager entityManager = null;
		String jql = "select b from Book b";
		try {
			entityManager = emf.createEntityManager();

			TypedQuery<Book> query = entityManager.createQuery(jql,Book.class);
			List<Book> bookList = query.getResultList();
			if(bookList.isEmpty()) {
				throw new PersistenceException("No records in the table");
			}
			return bookList;
		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	@Override
	public String addBook(Book book) throws PersistenceException {
		EntityManager entityManager = null;
		try {
			entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();
			return "Book Added To Database";
		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	@Override
	public String updateBook(Book book) throws PersistenceException {
		EntityManager entityManager = null;
		try {
			entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(book);
			entityManager.getTransaction().commit();
			return "Book Updated To Database";
		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	@Override
	public String deleteBook(Long isbn) throws PersistenceException {
		EntityManager entityManager = null;
		try {
			entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();
			Book book = entityManager.find(Book.class, isbn);
			if(book == null) {
				throw new PersistenceException("Invalid isbn");
			}
			entityManager.remove(book);
			entityManager.getTransaction().commit();
			return "Book Deleted From Database";
		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	//named parameter
	@Override
	public List<Book> getBooksByAuthor(String author) throws PersistenceException {
		EntityManager entityManager = null;
		String jql="select b from Book b where b.author= :pauthor";
		try {
			entityManager = emf.createEntityManager();
			TypedQuery<Book> query = entityManager.createQuery(jql,Book.class);
			query.setParameter("pauthor", author);
			List<Book> bookList = query.getResultList();
			if(bookList.isEmpty()) {
				throw new PersistenceException("No books written by "+ author);
			}
			return bookList;

		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	//positional parameter
	@Override
	public List<Book> getBooksByAuthorGreaterThanPrice(String author, Double price) throws PersistenceException {
		EntityManager entityManager = null;
		String jql="select b from Book b where b.author= ?1 and b.price > ?2";
		try {
			entityManager = emf.createEntityManager();
			TypedQuery<Book> query = entityManager.createQuery(jql,Book.class);
			query.setParameter(1, author);
			query.setParameter(2, price);
			List<Book> bookList = query.getResultList();
			if(bookList.isEmpty()) {
				throw new PersistenceException("No books written by "+ author + " exceeding Rs."+price);
			}
			return bookList;

		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	//named query
	@Override
	public List<Book> fetchAllBooks() throws PersistenceException {
		EntityManager entityManager = null;

		try {
			entityManager = emf.createEntityManager();

			Query query = entityManager.createNamedQuery("fetchAllBooks");
			List<Book> bookList = query.getResultList();
			if(bookList.isEmpty()) {
				throw new PersistenceException("No records in the table");
			}
			return bookList;
		}catch(PersistenceException e) {
			//			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
