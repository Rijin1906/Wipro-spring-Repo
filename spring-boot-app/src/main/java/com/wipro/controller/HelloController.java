package com.wipro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	//http://localhost:9090/hello
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello, Welcome to Spring booot Application";
	}

}
