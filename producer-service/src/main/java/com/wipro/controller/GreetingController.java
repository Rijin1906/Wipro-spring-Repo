package com.wipro.controller;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.User;
@RestController
@RequestMapping("/gc")
public class GreetingController {
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${eureka.instance.instance-id}")
   private String instanceId;
	
		@GetMapping("/greet")
		public String greetings() {
			return "Hello, Welcome to Spring Microservices: "+ serverPort+ ","+ instanceId;
		}
		
		
		@PostMapping("/user")
		public User postUser(@RequestBody User user) {
			user.setLoggedin(LocalDateTime.now());
			
			return user;
		}
}
