package com.mypage.agencyportal.dto;

import com.google.gson.annotations.Expose;

public class PartyDetailsDto {
	private String key;
	@Expose
	private String partyID;
	private String partyNO;
	
	public String getKey() {
		return key;
	}
	
	public String getPartyID() {
		return partyID;
	}

	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}

	public String getPartyNO() {
		return partyNO;
	}
}
