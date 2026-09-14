package com.axa.payment.dto.eip;

import java.util.List;

public class CustomerInformationDto {
	private IndividualDto canBeIndividual;
	private List<PolicyAccountDto> hasPolicyAccount; 
	
	public IndividualDto getCanBeIndividual() {
		return canBeIndividual;
	}

	public List<PolicyAccountDto> getHasPolicyAccount() {
		return hasPolicyAccount;
	}
}
