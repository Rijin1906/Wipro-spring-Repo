package com.wipro.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wipro.model.User;

@Repository
public class UserDaoImp implements UserDAO {
	private static List<User> userList = new ArrayList<>();
static {
		
		userList.add(new User("admin","admin@123"));
		userList.add(new User("user1","user1@123"));
		userList.add(new User("user2","user2@123"));
		userList.add(new User("user3","user3@123"));
		
	}
	@Override
	public User getUserByName(String username) {
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		
		return null;
	}
	@Override
	public List<User> getAllUsers() {
		
		return userList;
	}
	@Override
	public User addUser(User user) {
		userList.add(user);
		return user;
	}
	@Override
	public String deleteUser(String username) {
		Iterator<User> iterator = userList.iterator();		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getUsername().equals(username)) {
				userList.remove(user);
				return username+ " deleted";
			}
		}
		return username+" not deleted";
	}
	@Override
	public User updateUserPassword(User user) {
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()) {
			User existingUser = iterator.next();
			if(existingUser.getUsername().equals(user.getUsername())) {
				existingUser.setPassword(user.getPassword());
				return existingUser;
			}
		}
		return user;
	}
}
