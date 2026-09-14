package com.axa.payment.dto.eip;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CustomerDto {
	@Expose
	private List<PolicyAccountDto> hasPolicyAccount;
	private List<DeliveryStatusDto> haveCommunicatedMessage;
	
	public void setHasPolicyAccount(List<PolicyAccountDto> hasPolicyAccount) {
		this.hasPolicyAccount = hasPolicyAccount;
	}

	public List<PolicyAccountDto> getHasPolicyAccount() {
		return hasPolicyAccount;
	}
	
	public List<DeliveryStatusDto> getHaveCommunicatedMessage() {
		return haveCommunicatedMessage;
	}
}
