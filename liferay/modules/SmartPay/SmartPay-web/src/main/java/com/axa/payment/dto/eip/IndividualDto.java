package com.axa.payment.dto.eip;

import java.util.List;

public class IndividualDto {
	private List<AddressesDto> hasAddressesIn;
	private String fullNM;
	
	public List<AddressesDto> getHasAddressesIn() {
		return hasAddressesIn;
	}
	
	public String getFullNM() {
		return fullNM;
	}
}
