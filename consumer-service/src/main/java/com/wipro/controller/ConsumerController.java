package com.wipro.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("cc")
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consume")
	public String consumeFromProducer() {
//		String uri = "http://localhost:8201/gc/greet";
		String uri = "http://producer-service/gc/greet";
		
		String response = restTemplate.getForObject(uri, String.class);
		return response;
	}
}
