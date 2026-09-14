package com.mypage.agencyportal.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HasNameValueDto {
	
	@Expose
	@SerializedName("name")
	private String name;
	
	@Expose
	@SerializedName("value")
	private String value;
	
	public HasNameValueDto(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
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
