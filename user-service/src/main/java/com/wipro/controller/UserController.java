package com.wipro.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.entity.User;
import com.wipro.service.UserService;
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		try {
			  List<User> userList = userService.getAllUsers();
			  return new ResponseEntity<>(userList,HttpStatus.OK);
			 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		try {
			  User newUser = userService.addUser(user);
			  return new ResponseEntity<>(newUser,HttpStatus.OK);
			 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
}
