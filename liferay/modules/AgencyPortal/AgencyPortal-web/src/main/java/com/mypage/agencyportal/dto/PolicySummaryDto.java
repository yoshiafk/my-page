package com.mypage.agencyportal.dto;

import java.util.Date;

public class PolicySummaryDto {
    private String policyNO;
    private String applicationRk;
    private String issueDt;
    
    private long issueDtEpoch;
    
    private String fullNM;
    private String insuranceProductRk;
    private Date policyEffectiveDTTM;
    private Date policyExpirationDTTM;
    
    private long policyEffectiveDTTMEpoch;
    private long policyExpirationDTTMEpoch;
    
    private String currencyCD;
    private double premiumAMT;

    // Getters and Setters
    public String getPolicyNO() {
        return policyNO;
    }

    public void setPolicyNO(String policyNO) {
        this.policyNO = policyNO;
    }

    public String getApplicationRk() {
        return applicationRk;
    }

    public void setApplicationRk(String applicationRk) {
        this.applicationRk = applicationRk;
    }

    public String getIssueDt() {
        return issueDt;
    }

    public void setIssueDt(String issueDt) {
        this.issueDt = issueDt;
    }
    

    public long getIssueDtEpoch() {
		return issueDtEpoch;
	}

	public void setIssueDtEpoch(long issueDtEpoch) {
		this.issueDtEpoch = issueDtEpoch;
	}

	public String getFullNM() {
        return fullNM;
    }

    public void setFullNM(String fullNM) {
        this.fullNM = fullNM;
    }

    public String getInsuranceProductRk() {
        return insuranceProductRk;
    }

    public void setInsuranceProductRk(String insuranceProductRk) {
        this.insuranceProductRk = insuranceProductRk;
    }

    public Date getPolicyEffectiveDTTM() {
        return policyEffectiveDTTM;
    }

    public void setPolicyEffectiveDTTM(Date policyEffectiveDTTM) {
        this.policyEffectiveDTTM = policyEffectiveDTTM;
    }

    public Date getPolicyExpirationDTTM() {
        return policyExpirationDTTM;
    }

    public void setPolicyExpirationDTTM(Date policyExpirationDTTM) {
        this.policyExpirationDTTM = policyExpirationDTTM;
    }
    
    

    public long getPolicyEffectiveDTTMEpoch() {
		return policyEffectiveDTTMEpoch;
	}

	public void setPolicyEffectiveDTTMEpoch(long policyEffectiveDTTMEpoch) {
		this.policyEffectiveDTTMEpoch = policyEffectiveDTTMEpoch;
	}

	public long getPolicyExpirationDTTMEpoch() {
		return policyExpirationDTTMEpoch;
	}

	public void setPolicyExpirationDTTMEpoch(long policyExpirationDTTMEpoch) {
		this.policyExpirationDTTMEpoch = policyExpirationDTTMEpoch;
	}

	public String getCurrencyCD() {
        return currencyCD;
    }

    public void setCurrencyCD(String currencyCD) {
        this.currencyCD = currencyCD;
    }

    public double getPremiumAMT() {
        return premiumAMT;
    }

    public void setPremiumAMT(double premiumAMT) {
        this.premiumAMT = premiumAMT;
    }
}
