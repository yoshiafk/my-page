package com.mypage.product.sa.dto;

import java.util.List;
import java.util.ArrayList;

public class BenefitDTO {
    private List<BenefitDetailDTO> MainBenefit;
    private List<BenefitDetailDTO> AdditionalBenefit;

    // Constructor
    public BenefitDTO(List<BenefitDetailDTO> mainBenefit, List<BenefitDetailDTO> additionalBenefit) {
        this.MainBenefit = mainBenefit != null ? mainBenefit : new ArrayList<>();
        this.AdditionalBenefit = additionalBenefit != null ? additionalBenefit : new ArrayList<>();
    }

    // Getter dan Setter
    public List<BenefitDetailDTO> getMainBenefit() {
        return MainBenefit;
    }

    public void setMainBenefit(List<BenefitDetailDTO> mainBenefit) {
        this.MainBenefit = mainBenefit != null ? mainBenefit : new ArrayList<>();
    }

    public List<BenefitDetailDTO> getAdditionalBenefit() {
        return AdditionalBenefit;
    }

    public void setAdditionalBenefit(List<BenefitDetailDTO> additionalBenefit) {
        this.AdditionalBenefit = additionalBenefit != null ? additionalBenefit : new ArrayList<>();
    }
}
