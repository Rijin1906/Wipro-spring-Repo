package com.wipro.service;

import java.util.List;

import com.wipro.entity.Customer;

public interface CustomerService {
	
	public Customer getCustomerById(Integer customerid);
	public abstract List<Customer> getAllCustomers();
	public abstract String addCustomer(Customer customer);
	public abstract String updateCustomer(Customer customer);
	public abstract String deleteCustomer(Integer customerid);

}
