package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

public class DataItemDto {
	private int o_id;
	private String TransactionDate;
	private String ReferenceNumber;
	private String Name;
	private String Product;
	private double NetPremium;
	private String Currency;
	private String Status;
	private String PolicyType;
	
	@SerializedName("Target")
	private String target;

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}

	public String getReferenceNumber() {
		return ReferenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		ReferenceNumber = referenceNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public double getNetPremium() {
		return NetPremium;
	}

	public void setNetPremium(double netPremium) {
		NetPremium = netPremium;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Object getPolicyType() {
		return PolicyType;
	}

	public void setPolicyType(String policyType) {
		PolicyType = policyType;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}