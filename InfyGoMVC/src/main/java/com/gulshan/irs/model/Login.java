package com.gulshan.irs.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	
	@NotNull(message="please enter your UserID")
	@Size(min=4,max=15,message="UserId must be between 4 to 15 characters")
	private String userName;
	
	@NotNull(message="Please enter your password")
	@Size(min=4,max=15,message="Password size is between 8 to 15")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
