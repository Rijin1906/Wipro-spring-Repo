

package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.entity.User;
import com.wipro.exception.UserException;
import com.wipro.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
//allow any client application to access the API end-points of this RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	//http://9091/api/v1/users/1
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUserById( @PathVariable(value="userid") Integer userid) {
		try {
			User user = userService.getUserById(userid);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}



	//http://9091/api/v1/users
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		try {
			if(bindingResult.hasErrors()) {
				throw new UserException(bindingResult.getAllErrors().toString());
			}
			
			User newUser = userService.addUser(user);
			return new ResponseEntity<>(newUser,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}



	//http://9091/api/v1/users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> userList = userService.getAllUsers();
			return new ResponseEntity<>(userList,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser( @Valid  @RequestBody User user, BindingResult bindingResult){
		try {
			if(bindingResult.hasErrors()) {
				throw new UserException(bindingResult.getAllErrors().toString());
			}
			
			User updatedUser = userService.updateUser(user);
			return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<User> deleteUser( @PathVariable(value="userid") Integer userid) {
		try {
			User deletedUser = userService.deleteUser(userid);
			return new ResponseEntity<>(deletedUser, HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}


}




