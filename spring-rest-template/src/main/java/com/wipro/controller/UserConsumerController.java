package com.wipro.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.model.User;
/*
* spring-rest-template application is a consumer application
* spring-boot-jpa application is producer application
*
* Consumer application makes calls to producer application through RestTemplate object
*/
@RestController
@RequestMapping("/cc")
public class UserConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> consumeUserById(@PathVariable(value="userid" )Integer userid){
		//API end-point of producer application
		final String uri = "http://localhost:9091/api/v1/users/{userid}";	  
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("userid", userid);
			User user =
					restTemplate.getForObject(uri, User.class, params);
			System.out.println(user);
			return  new ResponseEntity<>(user,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
}
