package com.wipro.service;
import org.springframework.stereotype.Component;
import com.wipro.entity.Customer;
import com.wipro.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
@Component
public class DataLoader {
   private final CustomerRepository customerRepository;
   public DataLoader(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }
   @PostConstruct
   public void init() {
       customerRepository.save(new Customer("Gozde", "Yalcin"));
       customerRepository.save(new Customer("Boncuk", "Yalcin"));
   }
}
