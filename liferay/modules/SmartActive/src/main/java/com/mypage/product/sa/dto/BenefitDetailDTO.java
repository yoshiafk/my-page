package com.mypage.product.sa.dto;

import java.util.List;

public class BenefitDetailDTO {
	private String BenefitType;
	List<BenefitListDTO> BenefitList;
	
	public String getBenefitType() {
		return BenefitType;
	}
	
	public void setBenefitType(String benefitType) {
		BenefitType = benefitType;
	}
	
	public List<BenefitListDTO> getBenefitList() {
		return BenefitList;
	}
	
	public void setBenefitList(List<BenefitListDTO> benefitList) {
		BenefitList = benefitList;
	}
}