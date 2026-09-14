package com.mypage.agencyportal.dto;

public class ResponseDto<T> {
	private T Body;
	private int StatusCode;
	private String Exception;

	public T getBody() {
		return Body;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	
	public String getException() {
		return Exception;
	}
}
