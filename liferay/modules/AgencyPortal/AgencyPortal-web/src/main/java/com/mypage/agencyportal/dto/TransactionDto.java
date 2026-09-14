package com.mypage.agencyportal.dto;

public class TransactionDto {
	private String fulldate;
	private String currency;
	private String productCode;
	private String policyTypeCode;
	private int date;
	private int month;
	private int year;
	private int policyValue;
	private double amount;
	
	public String getFulldate() {
		return fulldate;
	}
	
	public void setFulldate(String fulldate) {
		this.fulldate = fulldate;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPolicyTypeCode() {
		return policyTypeCode;
	}

	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}

	public int getDate() {
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPolicyValue() {
		return policyValue;
	}

	public void setPolicyValue(int policyValue) {
		this.policyValue = policyValue;
	}
}
