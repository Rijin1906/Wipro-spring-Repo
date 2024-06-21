package com.wipro.feign;
import org.springframework.stereotype.Component;
@Component
public class Fallback implements FeignService{
	@Override
	public String consumeGreeting() {
		
		return "Currently the service is down";
	}
	
	
	
	
	
}
