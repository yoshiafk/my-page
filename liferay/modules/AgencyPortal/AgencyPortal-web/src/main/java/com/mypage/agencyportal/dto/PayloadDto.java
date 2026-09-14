package com.mypage.agencyportal.dto;

import com.google.gson.annotations.Expose;

public class PayloadDto<T> {
	@Expose
	private HeaderDto Header;
	@Expose
	private T Body;
	
	public void setHeader(HeaderDto header) {
		Header = header;
	}
	
	public T getBody() {
		return Body;
	}

	public void setBody(T requestBody) {
		this.Body = requestBody;
	}
}
