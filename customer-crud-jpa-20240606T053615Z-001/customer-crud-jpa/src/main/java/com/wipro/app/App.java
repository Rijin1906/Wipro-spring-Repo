package com.wipro.app;

import java.time.LocalDate;

import org.apache.log4j.Logger;

import com.wipro.entity.Book;
import com.wipro.exception.BookException;
import com.wipro.service.BookService;
import com.wipro.service.BookServiceImpl;


public class App {
	private static BookService bookService = new BookServiceImpl();
	private static Logger appLogger = Logger.getLogger(App.class);



	//	private static CustomerService service  = new CustomerServiceImpl();
	//	private static BookService service = new BookServiceImpl();




	public static void main(String[] args) {
		//		service.addCustomer(new Customer(null,"charu","ch@gmail.com",7906796900l));
		//		service.addCustomer(new Customer(null,"deep","dee@gmail.com",8907896910l));

		//		Customer customer1 = service.getCustomerById(1);
		//		System.out.println(customer1);
		//		
		//		Customer customer2 = service.getCustomerById(2);
		//		System.out.println(customer2);

		//		List<Customer> customerList = service.getAllCustomers();
		//		Iterator<Customer> iterator = customerList.iterator();
		//		while(iterator.hasNext())
		//		{
		//			System.out.println(iterator.next());
		//		}
		//		
		//		Customer customer1 = service.getCustomerById(1);
		//		System.out.println("Befor : " + customer1);
		//		customer1.setEmail("charu@gmail.com");
		//		
		//		String status = service.updateCustomer(customer1);
		//		System.out.println(status);
		//		
		//		customer1 = service.getCustomerById(1);
		//		System.out.println("After : "+ customer1);

		//		String status = service.deleteCustomer(2);
		//		System.out.println(status);
		//		
		//		List<Customer> customerList = service.getAllCustomers();
		//		Iterator<Customer> iterator = customerList.iterator();
		//		while(iterator.hasNext())
		//		{
		//			System.out.println(iterator.next());
		//		}

		//		service.addBook(new Book(null,"Book1","abc",LocalDate.of(2021, 05, 01),599.0) );
		//		service.addBook(new Book(null,"Book2","def",LocalDate.of(2002, 03, 07),899.0) );
		//		service.addBook(new Book(null,"Book3","ghi",LocalDate.of(2023, 12, 29),698.0) );
		//		service.addBook(new Book(null,"Book4","jkl",LocalDate.of(2000, 11, 02),789.0) );

		//		List<Book> bookList = service.getAllBooks();
		//		Iterator<Book> iterator = bookList.iterator();
		//		while(iterator.hasNext()) {
		//			System.out.println(iterator.next());
		//		}
		//		
		//		String status = service.deleteBook(52);
		//		String status1 = service.deleteBook(53);
		//		String status2 = service.deleteBook(54);
		//		String status3 = service.deleteBook(55);


		//		List<Book> bookList = service.getBooksByAuthor("abc");
		//		Iterator<Book> iterator = bookList.iterator();
		//		while(iterator.hasNext()) {
		//			System.out.println(iterator.next());
		//		}

		//		List<Book> bookList = service.getBooksByAuthorGreaterThanPrice("abc", 600.0);
		//		Iterator<Book> iterator = bookList.iterator();
		//		while(iterator.hasNext()) {
		//			System.out.println(iterator.next());
		//		}

		//		List<Book> bookList = service.fetchAllBooks();
		//		Iterator<Book> iterator = bookList.iterator();
		//		while(iterator.hasNext()) {
		//			System.out.println(iterator.next());
		//		}


		try {
			//invalid isbn
			//			Book book = bookService.getBookById(1234L);

			//valid isbn
			Book book = bookService.getBookById(1L);
			System.out.println(book);

		}catch(BookException e) {

		}
	}
}



