package com.wipro.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.entity.User;
import com.wipro.repository.UserRepository;

import jakarta.annotation.PostConstruct;
@Component
public class DataLoader {
	@Autowired
   private UserRepository userRepository;
  
   @PostConstruct
   public void init() {
       userRepository.save(new User(null,"admin","admin@123","admin@gmail.com"));
       userRepository.save(new User(null,"srini","srini@123","srini@gmail.com"));
   }
}
