package com.mypage.agencyportal.dto;

public class PromoCodeDto {
	private String promoCode;
	private String productName;
	private String limit;
	private String formattedStartDate;
	private String formattedEndDate;
	private double discount;
	private int active;
	private Long promoCodeId;
	private String target;
	
	public String getPromoCode() {
		return promoCode;
	}
	
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getLimit() {
		return limit;
	}
	
	public void setLimit(String limit) {
		this.limit = limit;
	}
	
	public String getFormattedStartDate() {
		return formattedStartDate;
	}
	
	public void setFormattedStartDate(String formattedStartDate) {
		this.formattedStartDate = formattedStartDate;
	}
	
	public String getFormattedEndDate() {
		return formattedEndDate;
	}
	
	public void setFormattedEndDate(String formattedEndDate) {
		this.formattedEndDate = formattedEndDate;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}
	
	public Long getPromoCodeId() {
		return promoCodeId;
	}
	
	public void setPromoCodeId(Long promoCodeId) {
		this.promoCodeId = promoCodeId;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
