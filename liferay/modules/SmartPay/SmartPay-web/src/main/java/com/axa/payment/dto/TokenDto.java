package com.axa.payment.dto;

public class TokenDto {
	private String token;
	private boolean isValid;
	
	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isValid() {
		return isValid;
	}	
}
