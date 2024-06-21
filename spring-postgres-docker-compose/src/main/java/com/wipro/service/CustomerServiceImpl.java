package com.wipro.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.wipro.entity.Customer;
import com.wipro.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
   private final CustomerRepository customerRepository;
   public CustomerServiceImpl(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }
   @Override
   public List<Customer> getAllCustomers() {
       return customerRepository.findAll();
   }
   @Override
   public void createCustomer(CreateCustomerDto dto) {
       if (ObjectUtils.isEmpty(dto)) {
           throw new IllegalArgumentException("customer is empty");
       }
       Customer customer = Customer.builder().firstName(dto.getFirstName())
               .lastName(dto.getLastName())
               .build();
       customerRepository.save(customer);
   }
}
