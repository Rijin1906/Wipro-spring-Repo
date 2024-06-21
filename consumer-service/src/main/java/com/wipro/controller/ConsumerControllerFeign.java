package com.wipro.controller;
//import org.apache.catalina.realm.JNDIRealm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.feign.FeignService;
@RestController
@RequestMapping("/ccf")
public class ConsumerControllerFeign {
	@Autowired
	private FeignService feignService;
	
	@GetMapping("/consume")
	public String consumeFromProducer() {
		String response = feignService.consumeGreeting();
		return response;
	}
//	@PostMapping("/user")
//	public User postUser(@RequestBody User user) {
//		User userNew = feignService.postUser(user);
//		return userNew;
//	}
	

}
