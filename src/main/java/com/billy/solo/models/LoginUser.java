package com.billy.solo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="email is requried")
	@Email(message="Please enter valid email ")
	private String LoginEmail; 
	
	@NotEmpty(message="password is required")
	@Size(min=8, max=128, message="password must be 8-128 characters")
	private String LoginPassword; 
	
	public LoginUser() {
		
	}

	public String getLoginEmail() {
		return LoginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		LoginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return LoginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}


	
}

