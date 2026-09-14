package com.mypage.agencyportal.dto;

import java.util.List;

public class AssociationDto {
	private String areaCD;
	private List<StaffInformationDto> hasStaffInformationIn;
	
	public String getAreaCD() {
		return areaCD;
	}
	
	public List<StaffInformationDto> getHasStaffInformationIn() {
		return hasStaffInformationIn;
	}
}
