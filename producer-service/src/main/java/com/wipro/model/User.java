package com.wipro.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
	private Integer userid;
	private String name;
	private String password;
	private LocalDateTime loggedin;
	
	
	public User() {
		
	}

}
