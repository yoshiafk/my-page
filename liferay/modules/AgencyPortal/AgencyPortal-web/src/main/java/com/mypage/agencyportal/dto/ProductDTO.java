package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

public class ProductDTO {
	
	@SerializedName("Name")
	private String name;

	@SerializedName("Code")
	private String code;
	
	@SerializedName("Url")
	private Url url;
	
	@SerializedName("RenewalSetting")
	private RenewalSetting renewalSetting;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Url getUrl() {
		return url;
	}

	public RenewalSetting getRenewalSetting() {
		return renewalSetting;
	}

	public static class Url {
		@SerializedName("Url")
		private String url;

		public String getUrl() {
			return url;
		}
	}
	
	public static class RenewalSetting {
		@SerializedName("RenewalMaxDays")
		private int renewalMaxDays;

		public int getRenewalMaxDays() {
			return renewalMaxDays;
		}
	}
}
