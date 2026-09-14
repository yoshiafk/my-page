package com.mypage.agencyportal.dto.axamiles;

import com.google.gson.annotations.Expose;

import java.util.List;

public class PolicyDto {
	private String key;
	@Expose
	private String agencyBinderNo;
	
	@Expose
	private List<PartyDetailsDto> hasPartyDetailsIn;
	private List<CustomerInformationDto> hasCustomerInformationIn;
	
	public String getKey() {
		return key;
	}
	
	public String getAgencyBinderNo() {
		return agencyBinderNo;
	}
	
	public void setAgencyBinderNo(String agencyBinderNo) {
		this.agencyBinderNo = agencyBinderNo;
	}

	public List<PartyDetailsDto> getHasPartyDetailsIn() {
		return hasPartyDetailsIn;
	}

	public void setHasPartyDetailsIn(List<PartyDetailsDto> hasPartyDetailsIn) {
		this.hasPartyDetailsIn = hasPartyDetailsIn;
	}

	public List<CustomerInformationDto> getHasCustomerInformationIn() {
		return hasCustomerInformationIn;
	}
}
