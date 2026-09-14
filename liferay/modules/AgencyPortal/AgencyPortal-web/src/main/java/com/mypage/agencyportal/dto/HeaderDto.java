package com.mypage.agencyportal.dto;

import com.google.gson.annotations.Expose;

public class HeaderDto {
	@Expose
	private SecurityContextDto SecurityContext;

	public void setSecurityContext(SecurityContextDto securityContext) {
		SecurityContext = securityContext;
	}
}
