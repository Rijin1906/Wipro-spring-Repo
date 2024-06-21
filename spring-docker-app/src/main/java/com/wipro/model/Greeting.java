package com.wipro.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Greeting {
	private String message;
	
	public Greeting() {
		this.message=new String("Hello");
	}
	
	public Greeting(String message) {
		this.message=message;
	}
}
