package com.axa.payment.dto.eip;

import com.google.gson.annotations.Expose;

public class SecurityContextDto {
	@Expose
	private String username;
	@Expose
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
