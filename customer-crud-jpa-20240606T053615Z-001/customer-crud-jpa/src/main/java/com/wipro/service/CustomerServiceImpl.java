package com.wipro.service;

import java.util.List;

import com.wipro.dao.CustomerDAO;
import com.wipro.dao.CustomerDaoImpl;
import com.wipro.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO = new CustomerDaoImpl();
	
	
	@Override
	public Customer getCustomerById(Integer customerid) {
		return customerDAO.getCustomerById(customerid);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDAO.getAllCustomers();
	}

	@Override
	public String addCustomer(Customer customer) {
		
		return customerDAO.addCustomer(customer);
	}

	@Override
	public String updateCustomer(Customer customer) {
		
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public String deleteCustomer(Integer customerid) {
		
		return customerDAO.deleteCustomer(customerid);
	}

}
