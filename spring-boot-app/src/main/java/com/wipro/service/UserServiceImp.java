package com.wipro.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.UserDAO;
import com.wipro.model.User;

@Service
public class UserServiceImp implements UserService{
	//Tight-coupling
//	UserDAO userDao = new UserDaoImpl();
	@Autowired
	private UserDAO userDao;
	
	
	@Override
	public User getUserByName(String username) {
		//business-logic applied here
		return userDao.getUserByName(username);
	}
	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}
	@Override
	public User addUser(User user) {
		
		return userDao.addUser(user);
	}
	@Override
	public String deleteUser(String username) {
		
		return userDao.deleteUser(username);
	}
	@Override
	public User updateUserPassword(User user) {
		
		return userDao.updateUserPassword(user);
	}
}

