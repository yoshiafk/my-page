package com.mypage.agencyportal.dto;

import java.util.Date;
import java.util.List;

public class ProducerInformationDto {
	private String producerID;
	private String producerRk;
	private String producerStatusCD;
	private String producerTypeCD;
	private String sharedAgentCD;
	
	private Date effectiveDT;
	
	private List<LicensingInformationDto> hasLicensingIInformationIn;
	private List<PersonalDetailsDto> hasPersonalDetailsIn;
	private List<AssociationDto> hasAssociationWith;
	
	public String getProducerID() {
		return producerID;
	}

	public String getProducerRk() {
		return producerRk;
	}

	public Date getEffectiveDT() {
		return effectiveDT;
	}
	
	public String getProducerStatusCD() {
		return producerStatusCD;
	}
	
	public String getProducerTypeCD() {
		return producerTypeCD;
	}
	
	public List<LicensingInformationDto> getHasLicensingIInformationIn() {
		return hasLicensingIInformationIn;
	}
	
	public String getSharedAgentCD() {
		return sharedAgentCD;
	}
	
	public List<PersonalDetailsDto> getHasPersonalDetailsIn() {
		return hasPersonalDetailsIn;
	}
	
	public List<AssociationDto> getHasAssociationWith() {
		return hasAssociationWith;
	}
}
