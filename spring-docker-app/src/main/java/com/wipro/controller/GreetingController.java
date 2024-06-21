package com.wipro.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.model.Greeting;
@RestController
@RequestMapping("/api")
public class GreetingController {
	
		@GetMapping("/greet")
		public ResponseEntity<Greeting> sayGreet(){
			try {
				return new ResponseEntity<>(new Greeting("Hello, Welcome to Dockerization.."),
						 HttpStatus.OK );
			}catch(ResponseStatusException e) {
				throw new ResponseStatusException(HttpStatus.CONFLICT,e.getMessage() );
			}
		}
}
