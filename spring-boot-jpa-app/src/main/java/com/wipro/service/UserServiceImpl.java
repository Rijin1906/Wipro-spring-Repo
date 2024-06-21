
package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.UserDAO;
import com.wipro.entity.User;
import com.wipro.exception.UserException;

import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;


	@Override
	public User getUserById(Integer userid) throws UserException {
		try {
			return userDAO.getUserById(userid);
			
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}

	}

	@Override
	public List<User> getAllUsers() throws UserException {
		try {
			return userDAO.getAllUsers();
			
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}

	}

	@Override
	public User addUser(User user) throws UserException {
		try {
			return userDAO.addUser(user);
			
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}

	}

	@Override
	public User deleteUser(Integer userID) throws UserException {
		try {
			return userDAO.deleteUser(userID);
			
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}

	}

	@Override
	public User updateUser(User user) throws UserException {
		try {
			return userDAO.updateUser(user);
			
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}

	}
	
}
