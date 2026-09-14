package com.axa.payment.dto.eip;

import com.google.gson.annotations.Expose;

public class BodyDto {
	@Expose
	private String transactionId;
	@Expose
	private String operation;
	@Expose
	private String appID;
	@Expose
	private String entity;
	@Expose
	private String service;
	@Expose
	private CustomerDto Customer;

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setCustomer(CustomerDto customer) {
		Customer = customer;
	}

	public CustomerDto getCustomer() {
		return Customer;
	}
}
