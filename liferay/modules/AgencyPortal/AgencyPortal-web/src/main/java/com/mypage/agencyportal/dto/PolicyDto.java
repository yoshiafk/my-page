package com.mypage.agencyportal.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class PolicyDto {
	private String key;
	@Expose
	private String agencyBinderNo;
	@Expose
	private String validFromDttm;
	@Expose
	private String validToDttm;
	private String changeEffectiveFromDttm;
	private String issueDt;
	private String currencyCD;
	private String generalRk;
	private String issueBranchCD;
	private String policyNO;
	private String policyTypeCd;
	private String indivProductCd;
	private String insuranceProductRk;
	
	private String applicationRk;
	
	@Expose
	private List<PartyDetailsDto> hasPartyDetailsIn;
	private List<CustomerInformationDto> hasCustomerInformationIn;
	private List<ProducerInformationDto> hasProducerInformationIn;

	private Date processedDttm;
	private Date changeEffectiveToDttm;
	private Date policyEffectiveDTTM;
	private Date policyExpirationDTTM;
	private Date termProcessDt;

	@Expose(serialize = false)
	private double premiumAMT;
	private double collectedByAgentAmt;
	private double discountAmt;
	private double bonusAmt;
	private int policyValue;
	
	@Expose
	@SerializedName("hasNameValue")
	private List<HasNameValueDto> hasNameValue;
	
	public String getKey() {
		return key;
	}
	
	public String getAgencyBinderNo() {
		return agencyBinderNo;
	}
	
	public void setAgencyBinderNo(String agencyBinderNo) {
		this.agencyBinderNo = agencyBinderNo;
	}
	
	public String getValidFromDttm() {
		return validFromDttm;
	}

	public void setValidFromDttm(String validFromDttm) {
		this.validFromDttm = validFromDttm;
	}

	public String getValidToDttm() {
		return validToDttm;
	}

	public void setValidToDttm(String validToDttm) {
		this.validToDttm = validToDttm;
	}

	public Date getProcessedDttm() {
		return processedDttm;
	}
	
	public String getChangeEffectiveFromDttm() {
		return changeEffectiveFromDttm;
	}

	public Date getChangeEffectiveToDttm() {
		return changeEffectiveToDttm;
	}
	
	public String getCurrencyCD() {
		return currencyCD;
	}
	
	public String getGeneralRk() {
		return generalRk;
	}
	
	public double getPremiumAMT() {
		return premiumAMT;
	}

	public double getCollectedByAgentAmt() {
		return collectedByAgentAmt;
	}

	public List<PartyDetailsDto> getHasPartyDetailsIn() {
		return hasPartyDetailsIn;
	}

	public void setHasPartyDetailsIn(List<PartyDetailsDto> hasPartyDetailsIn) {
		this.hasPartyDetailsIn = hasPartyDetailsIn;
	}

	public List<CustomerInformationDto> getHasCustomerInformationIn() {
		return hasCustomerInformationIn;
	}

	public List<ProducerInformationDto> getHasProducerInformationIn() {
		return hasProducerInformationIn;
	}

	public String getIssueBranchCD() {
		return issueBranchCD;
	}

	public String getPolicyNO() {
		return policyNO;
	}

	public String getPolicyTypeCd() {
		return policyTypeCd;
	}

	public String getIssueDt() {
		return issueDt;
	}

	public Date getPolicyEffectiveDTTM() {
		return policyEffectiveDTTM;
	}

	public Date getPolicyExpirationDTTM() {
		return policyExpirationDTTM;
	}

	public Date getTermProcessDt() {
		return termProcessDt;
	}

	public double getBonusAmt() {
		return bonusAmt;
	}

	public double getDiscountAmt() {
		return discountAmt;
	}

	public String getIndivProductCd() {
		return indivProductCd;
	}

	public String getInsuranceProductRk() {
		return insuranceProductRk;
	}

	public String getApplicationRk() {
		return applicationRk;
	}

	public List<HasNameValueDto> getHasNameValueDtos() {
		return hasNameValue;
	}

	public void setHasNameValueDtos(List<HasNameValueDto> hasNameValueDtos) {
		this.hasNameValue = hasNameValueDtos;
	}

	public int getPolicyValue() {
		return policyValue;
	}
}
