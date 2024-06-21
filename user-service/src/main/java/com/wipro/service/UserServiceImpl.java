package com.wipro.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.User;
import com.wipro.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
}
