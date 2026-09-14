package com.axa.payment.dto.eip;

import com.google.gson.annotations.Expose;

public class HeaderDto {
	@Expose
	private SecurityContextDto SecurityContext;

	public void setSecurityContext(SecurityContextDto securityContext) {
		SecurityContext = securityContext;
	}
}
