
package com.wipro.service;
import java.util.List;

import com.wipro.entity.Customer;
public interface CustomerService {
   List<Customer> getAllCustomers();
   void createCustomer(CreateCustomerDto dto);
}
