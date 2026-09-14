package com.mypage.agencyportal.dto;

import com.google.gson.annotations.Expose;
import com.mypage.agencyportal.base.BodyBase;

import java.util.List;

public class BodyDto implements BodyBase {
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
	private PolicyDto Policy;
	@Expose
	private List<PolicyDto> Policies;
	private ExceptionDto exception;
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
	public PolicyDto getPolicy() {
		return Policy;
	}

	public void setPolicy(PolicyDto policy) {
		Policy = policy;
	}
	
	public List<PolicyDto> getPolicies() {
		return Policies;
	}

	public void setPolicies(List<PolicyDto> policies) {
		Policies = policies;
	}
	
	public ExceptionDto getException() {
		return exception;
	}

	@Override
	public String toString() {
		return "BodyDto [transactionId=" + transactionId + ", operation=" + operation + ", appID=" + appID + ", entity="
				+ entity + ", service=" + service + ", Policy=" + Policy + ", Policies=" + Policies + ", exception="
				+ exception + "]";
	}
}
