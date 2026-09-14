package com.axa.payment.dto.eip;

import com.google.gson.annotations.Expose;

import java.util.List;

public class PolicyAccountDto {
	@Expose
	private String policyNO;
	@Expose
	private String accountNo;
	private String policyEffectiveDTTM;
	private String policyExpirationDTTM;
	@Expose
	private String policyDueDt;
	private String policyStatusCD;
	private String policyRK;
	private String insuranceProductRk;
	@Expose
	private String applicationRk;
	@Expose
	private String generalRk;
	@Expose
	private String paidToDT;
	@Expose
	private String paymentStatusCd;
	
	@Expose(serialize = false)
	private double grossAnnualPremiumAmt;
	private double discountAMT;
	private double policyFeeAmt;
	private double stampDutyAmt;
	private String premiumAMT;
	private double targetPremiumAmt;
	
	private BillingDto hasBilling;
	
	private List<CustomerInformationDto> hasCustomerInformationIn;
	private List<PolicyDetailDto> hasDetailsOfPolicyTransactionIn;
	
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}

	public String getPolicyNO() {
		return policyNO;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPolicyEffectiveDTTM() {
		return policyEffectiveDTTM;
	}

	public String getPolicyExpirationDTTM() {
		return policyExpirationDTTM;
	}
	
	public String getPolicyDueDt() {
		return policyDueDt;
	}
	
	public String getPolicyStatusCD() { 
		return policyStatusCD;
	}
	
	public String getPolicyRK() {
		return policyRK;
	}

	public String getInsuranceProductRk() {
		return insuranceProductRk;
	}

	public double getGrossAnnualPremiumAmt() {
		return grossAnnualPremiumAmt;
	}
	
	public double getDiscountAMT() {
		return discountAMT;
	}
	
	public double getPolicyFeeAmt() {
		return policyFeeAmt;
	}
	
	public double getStampDutyAmt() {
		return stampDutyAmt;
	}
	
	public String getPremiumAMT() {
		return premiumAMT;
	}
	
	public double getTargetPremiumAmt() {
		return targetPremiumAmt;
	}
	
	public BillingDto getHasBilling() {
		return hasBilling;
	}
	
	public List<CustomerInformationDto> getHasCustomerInformationIn() {
		return hasCustomerInformationIn;
	}
	
	public List<PolicyDetailDto> getHasDetailsOfPolicyTransactionIn() {
		return hasDetailsOfPolicyTransactionIn;
	}

	public void setPolicyDueDt(String policyDueDt) {
		this.policyDueDt = policyDueDt;
	}

	public void setApplicationRk(String applicationRk) {
		this.applicationRk = applicationRk;
	}

	public void setGeneralRk(String generalRk) {
		this.generalRk = generalRk;
	}

	public void setPaidToDT(String paidToDT) {
		this.paidToDT = paidToDT;
	}

	public void setPaymentStatusCd(String paymentStatusCd) {
		this.paymentStatusCd = paymentStatusCd;
	}

	public void setPremiumAMT(String premiumAMT) {
		this.premiumAMT = premiumAMT;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getApplicationRk() {
		return applicationRk;
	}

	public String getGeneralRk() {
		return generalRk;
	}

	public String getPaidToDT() {
		return paidToDT;
	}

	public String getPaymentStatusCd() {
		return paymentStatusCd;
	}
}
