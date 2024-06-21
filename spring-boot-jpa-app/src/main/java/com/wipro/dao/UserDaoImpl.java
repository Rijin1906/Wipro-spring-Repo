
package com.wipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wipro.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;


@Repository
public class UserDaoImpl implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUserById(Integer userid) throws PersistenceException {
		try {
			User user = entityManager.find(User.class, userid);
			if(user == null) {
				throw new PersistenceException("Invalid userid");
			}
			return user;
		}catch(PersistenceException e) {
			throw e;
		}
	}

	@Override
	public List<User> getAllUsers() throws PersistenceException {
		String jql = "select u from User u";
		try {
			TypedQuery<User> query = entityManager.createQuery(jql, User.class);
			List<User> userList = query.getResultList();
			if(userList.isEmpty()) {
				throw new PersistenceException("Table is empty");
			}
			return userList;
		}catch(PersistenceException e) {
			throw e;
		}

	}

	@Override
	public User addUser(User user) throws PersistenceException {
		try {
			entityManager.persist(user);
//			entityManager.flush();
			return user;
		}catch(PersistenceException e) {
			throw e;
		}

	}

	@Override
	public User deleteUser(Integer userID) throws PersistenceException {
		try {
			User user= entityManager.find(User.class, userID);
			if(user == null) {
				throw new PersistenceException("Invalid UserId");
			}
			entityManager.remove(user);
			return user;
			
		}catch(PersistenceException e) {
			throw e;
		}

	}

	@Override
	public User updateUser(User user) throws PersistenceException {
try {
			
			entityManager.merge(user);
			return user;
			
		}catch(PersistenceException e) {
			throw e;
		}

	}

}
