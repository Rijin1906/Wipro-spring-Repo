package com.wipro.dao;

import java.util.List;

import com.wipro.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;


public class CustomerDaoImpl implements CustomerDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-crud-jpa");

	@Override
	public Customer getCustomerById(Integer customerid) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			Customer customer = em.find(Customer.class, customerid);
			return customer;

		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		EntityManager em = null;
		String jql = " select c from Customer c";
		try {
			em = emf.createEntityManager();
			TypedQuery<Customer> query = em.createQuery(jql,Customer.class);
			List<Customer> customerList = query.getResultList();
			return customerList;
		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addCustomer(Customer customer) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			return "customer added";


		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return "Unable to add customer";
	}

	@Override
	public String updateCustomer(Customer customer) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
			return "customer updated";


		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return "Unable to update customer";
	}

	@Override
	public String deleteCustomer(Integer customerid) {
		EntityManager em = null;

		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Customer customer = em.find(Customer.class, customerid);
			em.remove(customer);
			em.getTransaction().commit();
			return "customer deleted";


		}catch(PersistenceException e) {
			em.close();
			e.printStackTrace();
		}
		return "Unable to delete customer";
	}

}
