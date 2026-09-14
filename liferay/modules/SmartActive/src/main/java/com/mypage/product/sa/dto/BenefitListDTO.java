package com.mypage.product.sa.dto;

import java.math.BigDecimal;

public class BenefitListDTO {
	private BigDecimal Premium;
    private BigDecimal LimitBenefitValue;
    private BigDecimal MainBenefitValue;
    private String Code;
    private BigDecimal Rate;
    private String Name;

    // Constructor
    public BenefitListDTO(BigDecimal premium, BigDecimal limitBenefitValue, BigDecimal mainBenefitValue, String code, BigDecimal rate, String name) {
        this.Premium = premium;
        this.LimitBenefitValue = limitBenefitValue;
        this.MainBenefitValue = mainBenefitValue;
        this.Code = code;
        this.Rate = rate;
        this.Name = name;
    }

    // Getter dan Setter
    public BigDecimal getPremium() {
        return Premium;
    }

    public void setPremium(BigDecimal premium) {
        this.Premium = premium;
    }
    
    public BigDecimal getLimitBenefitValue() {
		return LimitBenefitValue;
	}

	public void setLimitBenefitValue(BigDecimal limitBenefitValue) {
		this.LimitBenefitValue = limitBenefitValue;
	}

	public BigDecimal getMainBenefitValue() {
		return MainBenefitValue;
	}

	public void setMainBenefitValue(BigDecimal mainBenefitValue) {
		this.MainBenefitValue = mainBenefitValue;
	}

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }
    
    public BigDecimal getRate() {
        return Rate;
    }

    public void setRate(BigDecimal rate) {
        this.Rate = rate;
    }
	
	public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
