package com.mypage.agencyportal.dto;

import java.util.List;

public class ProfileAgentDto {
	private String agentCode;
	private String agentName;
	private String agentAge;
	private String agentJoinDate;
	private String agentRegistStatus;
	private String agentRegional;
	private String agentRegionalHead;
	private String agentManager;
	private String branch;
	private String agentAauiStatus;

	private String agentBirthdate;
	private String agentGender;
	private String agentAddress;
	private String agentPhone;
	private String agentMobilePhone;
	private String agentEmail;
	private String agentPrettyUrl;
	private String agentProfileImage;
	private int agentIs24Hours;
	private LocationDto agentLocation;
	private SocialMediaDto agentSocialMedia;
	private List<WorkingHourDto> agentWorkingHour;
	

	public String getAgentCode() {
		return agentCode;
	}
	

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentAge() {
		return agentAge;
	}

	public void setAgentAge(String agentAge) {
		this.agentAge = agentAge;
	}

	public String getAgentJoinDate() {
		return agentJoinDate;
	}

	public void setAgentJoinDate(String agentJoinDate) {
		this.agentJoinDate = agentJoinDate;
	}

	public String getAgentRegistStatus() {
		return agentRegistStatus;
	}

	public void setAgentRegistStatus(String agentRegistStatus) {
		this.agentRegistStatus = agentRegistStatus;
	}

	public String getAgentRegional() {
		return agentRegional;
	}

	public void setAgentRegional(String agentRegional) {
		this.agentRegional = agentRegional;
	}

	public String getAgentRegionalHead() {
		return agentRegionalHead;
	}

	public void setAgentRegionalHead(String agentRegionalHead) {
		this.agentRegionalHead = agentRegionalHead;
	}

	public String getAgentManager() {
		return agentManager;
	}

	public void setAgentManager(String agentManager) {
		this.agentManager = agentManager;
	}
	

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAgentAauiStatus() {
		return agentAauiStatus;
	}

	public void setAgentAauiStatus(String agentAauiStatus) {
		this.agentAauiStatus = agentAauiStatus;
	}

	public String getAgentBirthdate() {
		return agentBirthdate;
	}

	public void setAgentBirthdate(String agentBirthdate) {
		this.agentBirthdate = agentBirthdate;
	}

	public String getAgentGender() {
		return agentGender;
	}

	public void setAgentGender(String agentGender) {
		this.agentGender = agentGender;
	}

	public String getAgentAddress() {
		return agentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	public String getAgentMobilePhone() {
		return agentMobilePhone;
	}

	public void setAgentMobilePhone(String agentMobilePhone) {
		this.agentMobilePhone = agentMobilePhone;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getAgentPrettyUrl() {
		return agentPrettyUrl;
	}

	public void setAgentPrettyUrl(String agentPrettyUrl) {
		this.agentPrettyUrl = agentPrettyUrl;
	}

	public LocationDto getAgentLocation() {
		return agentLocation;
	}

	public void setAgentLocation(LocationDto agentLocation) {
		this.agentLocation = agentLocation;
	}

	public SocialMediaDto getAgentSocialMedia() {
		return agentSocialMedia;
	}

	public void setAgentSocialMedia(SocialMediaDto agentSocialMedia) {
		this.agentSocialMedia = agentSocialMedia;
	}

	public String getAgentProfileImage() {
		return agentProfileImage;
	}

	public void setAgentProfileImage(String agentProfileImage) {
		this.agentProfileImage = agentProfileImage;
	}

	public int getAgentIs24Hours() {
		return agentIs24Hours;
	}

	public void setAgentIs24Hours(int agentIs24Hours) {
		this.agentIs24Hours = agentIs24Hours;
	}

	public List<WorkingHourDto>getAgentWorkingHour() {
		return agentWorkingHour;
	}

	public void setAgentWorkingHour(List<WorkingHourDto> agentWorkingHour) {
		this.agentWorkingHour = agentWorkingHour;
	}

}