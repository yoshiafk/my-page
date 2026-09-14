package com.mypage.agencyportal.dto;

import java.util.List;

public class GroupTransactionDto {
	private String month;
	private List<TransactionDto> transaction;
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}

	public List<TransactionDto> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<TransactionDto> transaction) {
		this.transaction = transaction;
	}
}
