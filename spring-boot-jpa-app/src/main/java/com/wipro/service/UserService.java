
package com.wipro.service;

import java.util.List;

import com.wipro.entity.User;
import com.wipro.exception.UserException;

public interface UserService {
	public User getUserById(Integer userid) throws UserException;
	public List<User> getAllUsers() throws UserException;
	public User addUser(User user) throws UserException;
	public User deleteUser(Integer userID) throws UserException;
	public User updateUser(User user) throws UserException;


}
