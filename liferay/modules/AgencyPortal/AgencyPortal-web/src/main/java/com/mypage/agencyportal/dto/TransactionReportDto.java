package com.mypage.agencyportal.dto;

public class TransactionReportDto {
	private int period;
	private int product;
	private double amount;
	
	public int getPeriod() {
		return period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public int getProduct() {
		return product;
	}
	
	public void setProduct(int product) {
		this.product = product;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
