package com.wipro.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "producer-service", fallback = Fallback.class)
public interface FeignService {
	@GetMapping("/gc/greet")
	public String consumeGreeting();
	
	
}
