package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

public class DataDetailsLeadsDto {
	

	@SerializedName("PolicyType")
    private String policyType;
	
	@SerializedName("ReferenceNumber")
    private String referenceNumber;

    @SerializedName("Status")
    private String status;
    
    @SerializedName("Category")
    private String category;
    
    @SerializedName("BussinesModel")
    private String businessModel;

    @SerializedName("Channel")
    private String channel;

    @SerializedName("OrderDate")
    private String orderDate;
    
    @SerializedName("StartDate")
    private String startDate;

    @SerializedName("ExpiredDate")
    private String expiredDate;
    
    @SerializedName("Currency")
    private String currency;

    @SerializedName("PolicyCost")
    private double policyCost;

    @SerializedName("PromoCode")
    private String promoCode;

    @SerializedName("StampDuty")
    private double stampDuty;

    @SerializedName("Premium")
    private double premium;

    @SerializedName("NetPremium")
    private double netPremium;

    @SerializedName("Discount")
    private double discount;

    @SerializedName("Commission")
    private double commission;

    @SerializedName("UtmSource")
    private String utmSource;

    @SerializedName("UtmMedium")
    private String utmMedium;

    @SerializedName("UtmCampaign")
    private String utmCampaign;

    @SerializedName("UtmTerm")
    private String utmTerm;

    @SerializedName("UtmContent")
    private String utmContent;

    @SerializedName("CampaignId")
    private String campaignId;

    @SerializedName("CampaignSource")
    private String campaignSource;

    @SerializedName("CommercialOffers")
    private boolean commercialOffers;
    
    @SerializedName("StatusQuotation")
    private String statusQuotation;
    
    @SerializedName("StatusPayment")
    private String statusPayment;
    
    @SerializedName("Temp")
    private boolean temp;

    @SerializedName("Product")
    private ProductDTO product;

    @SerializedName("Detail")
    private Object detail; 

    @SerializedName("PolicyHolder")
    private PolicyHolderDTO policyHolder;

    @SerializedName("Insured")
    private Object insured; 

    
	/* button action */
    @SerializedName("UrlDownloadPolis")
    private String urlDownloadPolis;
    
    @SerializedName("LinkBayar")
    private String linkBayar;
    
    @SerializedName("CsrfToken")
    private String csrfToken;
    
    @SerializedName("Id")
    private String id;
    
    @SerializedName("TempCode")
    private String tempCode;
    
    @SerializedName("LinkXls")
    private String linkXls;
    
    @SerializedName("isFromExcel")
    private boolean isFromExcel;
    
	/* end button action */
    
    @SerializedName("Pep")
    private Pep pep;
    
    @SerializedName("UWApproval")
    private UWApproval uwApproval;
    
    @SerializedName("Renewal")
    private Renewal renewal;
    
	public String getPolicyType() {
		return policyType;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public String getStatus() {
		return status;
	}

	public String getCategory() {
		return category;
	}

	public String getBusinessModel() {
		return businessModel;
	}

	public String getChannel() {
		return channel;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getExpiredDate() {
		return expiredDate;
	}
	
	public String getCurrency() {
		return currency;
	}

	public double getPolicyCost() {
		return policyCost;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public double getStampDuty() {
		return stampDuty;
	}

	public double getPremium() {
		return premium;
	}

	public double getNetPremium() {
		return netPremium;
	}

	public double getDiscount() {
		return discount;
	}

	public double getCommission() {
		return commission;
	}

	public String getUtmSource() {
		return utmSource;
	}

	public String getUtmMedium() {
		return utmMedium;
	}

	public String getUtmCampaign() {
		return utmCampaign;
	}

	public String getUtmTerm() {
		return utmTerm;
	}

	public String getUtmContent() {
		return utmContent;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public String getCampaignSource() {
		return campaignSource;
	}

	public boolean isCommercialOffers() {
		return commercialOffers;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public Object getDetail() {
		return detail;
	}

	public PolicyHolderDTO getPolicyHolder() {
		return policyHolder;
	}

	public Object getInsured() {
		return insured;
	}
	
	//getter button
	public String getUrlDownloadPolis() {
		return urlDownloadPolis;
	}

	public String getLinkBayar() {
		return linkBayar;
	}

	public String getCsrfToken() {
		return csrfToken;
	}

	public String getId() {
		return id;
	}

	public String getTempCode() {
		return tempCode;
	}

	public String getLinkXls() {
		return linkXls;
	}

	public boolean isFromExcel() {
		return isFromExcel;
	}

	public String getStatusQuotation() {
		return statusQuotation;
	}

	public String getStatusPayment() {
		return statusPayment;
	}

	public boolean isTemp() {
		return temp;
	}

	public Pep getPep() {
		return pep;
	}

	public UWApproval getUwApproval() {
		return uwApproval;
	}

	public Renewal getRenewal() {
		return renewal;
	}

	public static class Pep {
		@SerializedName("PepLeads")
		private boolean pepLeads;
		
		@SerializedName("StatusPep")
		private String statusPep;

		public boolean isPepLeads() {
			return pepLeads;
		}

		public String getStatusPep() {
			return statusPep;
		}
	}
	
	public static class UWApproval {
		@SerializedName("PropertyRiskLeads")
		private boolean propertyRiskLeads;
		
		@SerializedName("StatusPropertyRisk")
		private String statusPropertyRisk;

		public boolean isPropertyRiskLeads() {
			return propertyRiskLeads;
		}

		public String getStatusPropertyRisk() {
			return statusPropertyRisk;
		}
	}
	
	public static class Renewal {
		@SerializedName("Renewal1DateFlag")
		private boolean renewal1DateFlag;
		
		@SerializedName("Renewal2DateFlag")
		private boolean renewal2DateFlag;
		
		@SerializedName("Renewal3DateFlag")
		private boolean renewal3DateFlag;

		public boolean isRenewal1DateFlag() {
			return renewal1DateFlag;
		}

		public boolean isRenewal2DateFlag() {
			return renewal2DateFlag;
		}

		public boolean isRenewal3DateFlag() {
			return renewal3DateFlag;
		}
	}
}
