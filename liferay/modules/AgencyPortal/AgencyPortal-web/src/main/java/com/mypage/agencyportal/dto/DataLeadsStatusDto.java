package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

public class DataLeadsStatusDto {
	
	@SerializedName("Name")
	private String name;
	@SerializedName("Value")
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
