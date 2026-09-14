package com.axa.payment.dto;

public class SettlementDto {
	private String installment;
	private double grossPremium;
	private double discount;
	private double nettoPremium;
	private double policyCost;
	private double stampDuty;
	private double amount;
	private double unpaid;
	
	public String getInstallment() {
		return installment;
	}
	
	public void setInstallment(String installment) {
		this.installment = installment;
	}
	
	public double getGrossPremium() {
		return grossPremium;
	}
	
	public void setGrossPremium(double grossPremium) {
		this.grossPremium = grossPremium;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getNettoPremium() {
		return nettoPremium;
	}
	
	public void setNettoPremium(double nettoPremium) {
		this.nettoPremium = nettoPremium;
	}
	
	public double getPolicyCost() {
		return policyCost;
	}
	
	public void setPolicyCost(double policyCost) {
		this.policyCost = policyCost;
	}
	
	public double getStampDuty() {
		return stampDuty;
	}
	
	public void setStampDuty(double stampDuty) {
		this.stampDuty = stampDuty;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getUnpaid() {
		return unpaid;
	}
	
	public void setUnpaid(double unpaid) {
		this.unpaid = unpaid;
	}
}
