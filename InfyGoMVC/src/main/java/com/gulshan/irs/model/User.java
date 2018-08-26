package com.gulshan.irs.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
@NotEmpty(message="UserId must not be blank")
@Size(min=4 ,max=25 , message="user Id must be between 4 to 25 character")
	private String userId;

@NotEmpty(message="Password must not be blank")
@Size(min=8, max=15, message="password must be greater then 8 and less than 15 char")
	private String password;

@NotEmpty(message="Name must not be blank")
@Size(min=4 ,max=25 , message="Name must be between 4 to 25 character")
	private String name;

@NotEmpty(message="Name must not be blank")
	private String city;
@NotEmpty(message="Name must not be blank")
@Email
private String email;

@NotEmpty(message="Name must not be blank")
@Size(min=10 ,max=10 , message="Phone must be of 10 digits")	
private String phone;
	
public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
