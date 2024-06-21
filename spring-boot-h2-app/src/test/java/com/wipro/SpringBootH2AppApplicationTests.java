package com.wipro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootH2AppApplicationTests implements CommandLineRunner{
@Autowired
	private CountryRepository countryRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run.(SpringBootH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
	}

}
