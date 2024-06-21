
package com.wipro.dao;

import java.util.List;

import com.wipro.entity.User;

import jakarta.persistence.PersistenceException;

public interface UserDAO {
	public User getUserById(Integer userid) throws PersistenceException;
	public List<User> getAllUsers() throws PersistenceException;
	public User addUser(User user) throws PersistenceException;
	public User deleteUser(Integer userID) throws PersistenceException;
	public User updateUser(User user) throws PersistenceException;


}
