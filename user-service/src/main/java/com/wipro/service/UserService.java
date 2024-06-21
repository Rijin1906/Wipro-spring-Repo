package com.wipro.service;
import java.util.List;

import com.wipro.entity.User;
public interface UserService {
	public abstract User addUser(User user);
	public abstract List<User> getAllUsers();
}
