package com.mypage.agencyportal.dto;

import java.util.List;

public class GroupCobDto {
	private String cob;
	private List<TransactionCobDto> transaction;
	
	public String getCob() {
		return cob;
	}
	
	public void setCob(String cob) {
		this.cob = cob;
	}
	
	public List<TransactionCobDto> getTransaction() {
		return transaction;
	}
	
	public void setTransaction(List<TransactionCobDto> transaction) {
		this.transaction = transaction;
	}
}
