package com.axa.payment.dto;

import java.util.List;

public class ProductSummaryDto {
	private String fullName;
	private String emailAddress;
	private String mobileNumber;
	private String policyNumber;
	private String policyPeriod;
	private String productName;
	private double sumInsured;
	private int total;
	private List<PolicyDto> policies;
	private SettlementDto settlement;
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyPeriod() {
		return policyPeriod;
	}

	public void setPolicyPeriod(String policyPeriod) {
		this.policyPeriod = policyPeriod;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public List<PolicyDto> getPolicies() {
		return policies;
	}

	public void setPolicies(List<PolicyDto> policies) {
		this.policies = policies;
	}

	public SettlementDto getSettlement() {
		return settlement;
	}

	public void setSettlement(SettlementDto settlement) {
		this.settlement = settlement;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}