package com.wipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.wipro.client.GreetingClient;

@SpringBootApplication
public class SpringReactiveClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
									SpringApplication.run(SpringReactiveClientApplication.class, args);
		
		 GreetingClient greetingClient = context.getBean(GreetingClient.class);
		 
//		  We need to block for the content here or the JVM might exit before the message is logged
		    System.out.println(">> message = " + greetingClient.getMessage().block());
		 
//		 System.out.println(greetingClient.getMessage());
	}

}
