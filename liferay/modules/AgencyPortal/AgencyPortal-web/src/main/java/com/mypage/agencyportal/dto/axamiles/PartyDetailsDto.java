package com.mypage.agencyportal.dto.axamiles;

import java.util.Date;
import java.util.List;

public class PartyDetailsDto {
	private Date processedDttm;
	
	private String partyStatus;
	private String partyRK;
	private String partyTypeCD;
	private String parentPartyCD;
	
	private IndividualDto canBeIndividual;
	private List<HasNameValueDto> hasNameValue;
	
	public Date getProcessedDttm() {
		return processedDttm;
	}
	
	public void setProcessedDttm(Date processedDttm) {
		this.processedDttm = processedDttm;
	}
	
	public String getPartyStatus() {
		return partyStatus;
	}
	
	public void setPartyStatus(String partyStatus) {
		this.partyStatus = partyStatus;
	}
	
	public String getPartyRK() {
		return partyRK;
	}
	
	public void setPartyRK(String partyRK) {
		this.partyRK = partyRK;
	}
	
	public String getPartyTypeCD() {
		return partyTypeCD;
	}
	
	public void setPartyTypeCD(String partyTypeCD) {
		this.partyTypeCD = partyTypeCD;
	}
	
	public String getParentPartyCD() {
		return parentPartyCD;
	}
	
	public void setParentPartyCD(String parentPartyCD) {
		this.parentPartyCD = parentPartyCD;
	}
	
	public IndividualDto getCanBeIndividual() {
		return canBeIndividual;
	}
	
	public void setCanBeIndividual(IndividualDto canBeIndividual) {
		this.canBeIndividual = canBeIndividual;
	}
	
	public List<HasNameValueDto> getHasNameValue() {
		return hasNameValue;
	}
	
	public void setHasNameValue(List<HasNameValueDto> hasNameValue) {
		this.hasNameValue = hasNameValue;
	}
}
