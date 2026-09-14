package com.axa.payment.dto.eip;

import com.google.gson.annotations.Expose;

public class PayloadDto {
	@Expose
	private HeaderDto Header;
	@Expose
	private BodyDto Body;
	
	public void setHeader(HeaderDto header) {
		Header = header;
	}
	
	public BodyDto getBody() {
		return Body;
	}

	public void setBody(BodyDto body) {
		this.Body = body;
	}
}
