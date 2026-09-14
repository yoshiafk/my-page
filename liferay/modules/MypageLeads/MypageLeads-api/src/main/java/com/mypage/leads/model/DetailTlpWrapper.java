/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mypage.leads.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DetailTlp}.
 * </p>
 *
 * @author Gositus
 * @see DetailTlp
 * @generated
 */
public class DetailTlpWrapper
	extends BaseModelWrapper<DetailTlp>
	implements DetailTlp, ModelWrapper<DetailTlp> {

	public DetailTlpWrapper(DetailTlp detailTlp) {
		super(detailTlp);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("detailTlpId", getDetailTlpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("mainPolicyStartDate", getMainPolicyStartDate());
		attributes.put("mainPolicyEndDate", getMainPolicyEndDate());
		attributes.put("numberOfDays", getNumberOfDays());
		attributes.put("name", getName());
		attributes.put("birthPlace", getBirthPlace());
		attributes.put("dob", getDob());
		attributes.put("nationality", getNationality());
		attributes.put("idNumber", getIdNumber());
		attributes.put("passportNumber", getPassportNumber());
		attributes.put("kitasNumber", getKitasNumber());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("address2", getAddress2());
		attributes.put("province", getProvince());
		attributes.put("city", getCity());
		attributes.put("postCode", getPostCode());
		attributes.put("commercialOffer", getCommercialOffer());
		attributes.put("driveModel", getDriveModel());
		attributes.put("vehicleManufacture", getVehicleManufacture());
		attributes.put("vehicleModel", getVehicleModel());
		attributes.put("vehicleSubModel", getVehicleSubModel());
		attributes.put("manufactureYear", getManufactureYear());
		attributes.put("vehicleInsured", getVehicleInsured());
		attributes.put("regionPlate", getRegionPlate());
		attributes.put("policeNumber", getPoliceNumber());
		attributes.put("chassisNumber", getChassisNumber());
		attributes.put("engineNumber", getEngineNumber());
		attributes.put("leadsId", getLeadsId());
		attributes.put("transactionId_", getTransactionId_());
		attributes.put("businessModel", getBusinessModel());
		attributes.put("channel", getChannel());
		attributes.put("promoCode", getPromoCode());
		attributes.put("step1", getStep1());
		attributes.put("policyNumber", getPolicyNumber());
		attributes.put("referenceNumber", getReferenceNumber());
		attributes.put("policyStatus", getPolicyStatus());
		attributes.put("packageName", getPackageName());
		attributes.put("packageInfo", getPackageInfo());
		attributes.put("rate", getRate());
		attributes.put("currency_", getCurrency_());
		attributes.put("sumInsured", getSumInsured());
		attributes.put("policyCost", getPolicyCost());
		attributes.put("stampDuty", getStampDuty());
		attributes.put("premium", getPremium());
		attributes.put("netPremium", getNetPremium());
		attributes.put("discount", getDiscount());
		attributes.put("commision", getCommision());
		attributes.put("insuranceName", getInsuranceName());
		attributes.put("insurancePolicyNo", getInsurancePolicyNo());
		attributes.put("managedBy", getManagedBy());
		attributes.put("agentCode", getAgentCode());
		attributes.put("subAgent", getSubAgent());
		attributes.put("marketingCode", getMarketingCode());
		attributes.put("utmSource", getUtmSource());
		attributes.put("utmMedium", getUtmMedium());
		attributes.put("utmCampaign", getUtmCampaign());
		attributes.put("utmTerm", getUtmTerm());
		attributes.put("utmContent", getUtmContent());
		attributes.put("clickId", getClickId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long detailTlpId = (Long)attributes.get("detailTlpId");

		if (detailTlpId != null) {
			setDetailTlpId(detailTlpId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}

		Date mainPolicyStartDate = (Date)attributes.get("mainPolicyStartDate");

		if (mainPolicyStartDate != null) {
			setMainPolicyStartDate(mainPolicyStartDate);
		}

		Date mainPolicyEndDate = (Date)attributes.get("mainPolicyEndDate");

		if (mainPolicyEndDate != null) {
			setMainPolicyEndDate(mainPolicyEndDate);
		}

		Integer numberOfDays = (Integer)attributes.get("numberOfDays");

		if (numberOfDays != null) {
			setNumberOfDays(numberOfDays);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String birthPlace = (String)attributes.get("birthPlace");

		if (birthPlace != null) {
			setBirthPlace(birthPlace);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String passportNumber = (String)attributes.get("passportNumber");

		if (passportNumber != null) {
			setPassportNumber(passportNumber);
		}

		String kitasNumber = (String)attributes.get("kitasNumber");

		if (kitasNumber != null) {
			setKitasNumber(kitasNumber);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String province = (String)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String postCode = (String)attributes.get("postCode");

		if (postCode != null) {
			setPostCode(postCode);
		}

		Integer commercialOffer = (Integer)attributes.get("commercialOffer");

		if (commercialOffer != null) {
			setCommercialOffer(commercialOffer);
		}

		Long driveModel = (Long)attributes.get("driveModel");

		if (driveModel != null) {
			setDriveModel(driveModel);
		}

		String vehicleManufacture = (String)attributes.get(
			"vehicleManufacture");

		if (vehicleManufacture != null) {
			setVehicleManufacture(vehicleManufacture);
		}

		String vehicleModel = (String)attributes.get("vehicleModel");

		if (vehicleModel != null) {
			setVehicleModel(vehicleModel);
		}

		String vehicleSubModel = (String)attributes.get("vehicleSubModel");

		if (vehicleSubModel != null) {
			setVehicleSubModel(vehicleSubModel);
		}

		Integer manufactureYear = (Integer)attributes.get("manufactureYear");

		if (manufactureYear != null) {
			setManufactureYear(manufactureYear);
		}

		Double vehicleInsured = (Double)attributes.get("vehicleInsured");

		if (vehicleInsured != null) {
			setVehicleInsured(vehicleInsured);
		}

		String regionPlate = (String)attributes.get("regionPlate");

		if (regionPlate != null) {
			setRegionPlate(regionPlate);
		}

		String policeNumber = (String)attributes.get("policeNumber");

		if (policeNumber != null) {
			setPoliceNumber(policeNumber);
		}

		String chassisNumber = (String)attributes.get("chassisNumber");

		if (chassisNumber != null) {
			setChassisNumber(chassisNumber);
		}

		String engineNumber = (String)attributes.get("engineNumber");

		if (engineNumber != null) {
			setEngineNumber(engineNumber);
		}

		Long leadsId = (Long)attributes.get("leadsId");

		if (leadsId != null) {
			setLeadsId(leadsId);
		}

		Long transactionId_ = (Long)attributes.get("transactionId_");

		if (transactionId_ != null) {
			setTransactionId_(transactionId_);
		}

		String businessModel = (String)attributes.get("businessModel");

		if (businessModel != null) {
			setBusinessModel(businessModel);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		String promoCode = (String)attributes.get("promoCode");

		if (promoCode != null) {
			setPromoCode(promoCode);
		}

		Integer step1 = (Integer)attributes.get("step1");

		if (step1 != null) {
			setStep1(step1);
		}

		String policyNumber = (String)attributes.get("policyNumber");

		if (policyNumber != null) {
			setPolicyNumber(policyNumber);
		}

		String referenceNumber = (String)attributes.get("referenceNumber");

		if (referenceNumber != null) {
			setReferenceNumber(referenceNumber);
		}

		String policyStatus = (String)attributes.get("policyStatus");

		if (policyStatus != null) {
			setPolicyStatus(policyStatus);
		}

		String packageName = (String)attributes.get("packageName");

		if (packageName != null) {
			setPackageName(packageName);
		}

		Long packageInfo = (Long)attributes.get("packageInfo");

		if (packageInfo != null) {
			setPackageInfo(packageInfo);
		}

		Double rate = (Double)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		String currency_ = (String)attributes.get("currency_");

		if (currency_ != null) {
			setCurrency_(currency_);
		}

		Double sumInsured = (Double)attributes.get("sumInsured");

		if (sumInsured != null) {
			setSumInsured(sumInsured);
		}

		Double policyCost = (Double)attributes.get("policyCost");

		if (policyCost != null) {
			setPolicyCost(policyCost);
		}

		Double stampDuty = (Double)attributes.get("stampDuty");

		if (stampDuty != null) {
			setStampDuty(stampDuty);
		}

		Double premium = (Double)attributes.get("premium");

		if (premium != null) {
			setPremium(premium);
		}

		Double netPremium = (Double)attributes.get("netPremium");

		if (netPremium != null) {
			setNetPremium(netPremium);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Double commision = (Double)attributes.get("commision");

		if (commision != null) {
			setCommision(commision);
		}

		String insuranceName = (String)attributes.get("insuranceName");

		if (insuranceName != null) {
			setInsuranceName(insuranceName);
		}

		String insurancePolicyNo = (String)attributes.get("insurancePolicyNo");

		if (insurancePolicyNo != null) {
			setInsurancePolicyNo(insurancePolicyNo);
		}

		Long managedBy = (Long)attributes.get("managedBy");

		if (managedBy != null) {
			setManagedBy(managedBy);
		}

		String agentCode = (String)attributes.get("agentCode");

		if (agentCode != null) {
			setAgentCode(agentCode);
		}

		Long subAgent = (Long)attributes.get("subAgent");

		if (subAgent != null) {
			setSubAgent(subAgent);
		}

		String marketingCode = (String)attributes.get("marketingCode");

		if (marketingCode != null) {
			setMarketingCode(marketingCode);
		}

		String utmSource = (String)attributes.get("utmSource");

		if (utmSource != null) {
			setUtmSource(utmSource);
		}

		String utmMedium = (String)attributes.get("utmMedium");

		if (utmMedium != null) {
			setUtmMedium(utmMedium);
		}

		String utmCampaign = (String)attributes.get("utmCampaign");

		if (utmCampaign != null) {
			setUtmCampaign(utmCampaign);
		}

		String utmTerm = (String)attributes.get("utmTerm");

		if (utmTerm != null) {
			setUtmTerm(utmTerm);
		}

		String utmContent = (String)attributes.get("utmContent");

		if (utmContent != null) {
			setUtmContent(utmContent);
		}

		String clickId = (String)attributes.get("clickId");

		if (clickId != null) {
			setClickId(clickId);
		}
	}

	/**
	 * Returns the address of this detail tlp.
	 *
	 * @return the address of this detail tlp
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this detail tlp.
	 *
	 * @return the address2 of this detail tlp
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the agent code of this detail tlp.
	 *
	 * @return the agent code of this detail tlp
	 */
	@Override
	public String getAgentCode() {
		return model.getAgentCode();
	}

	/**
	 * Returns the birth place of this detail tlp.
	 *
	 * @return the birth place of this detail tlp
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the business model of this detail tlp.
	 *
	 * @return the business model of this detail tlp
	 */
	@Override
	public String getBusinessModel() {
		return model.getBusinessModel();
	}

	/**
	 * Returns the channel of this detail tlp.
	 *
	 * @return the channel of this detail tlp
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the chassis number of this detail tlp.
	 *
	 * @return the chassis number of this detail tlp
	 */
	@Override
	public String getChassisNumber() {
		return model.getChassisNumber();
	}

	/**
	 * Returns the city of this detail tlp.
	 *
	 * @return the city of this detail tlp
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the click ID of this detail tlp.
	 *
	 * @return the click ID of this detail tlp
	 */
	@Override
	public String getClickId() {
		return model.getClickId();
	}

	/**
	 * Returns the commercial offer of this detail tlp.
	 *
	 * @return the commercial offer of this detail tlp
	 */
	@Override
	public int getCommercialOffer() {
		return model.getCommercialOffer();
	}

	/**
	 * Returns the commision of this detail tlp.
	 *
	 * @return the commision of this detail tlp
	 */
	@Override
	public double getCommision() {
		return model.getCommision();
	}

	/**
	 * Returns the company ID of this detail tlp.
	 *
	 * @return the company ID of this detail tlp
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this detail tlp.
	 *
	 * @return the create date of this detail tlp
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency_ of this detail tlp.
	 *
	 * @return the currency_ of this detail tlp
	 */
	@Override
	public String getCurrency_() {
		return model.getCurrency_();
	}

	/**
	 * Returns the detail tlp ID of this detail tlp.
	 *
	 * @return the detail tlp ID of this detail tlp
	 */
	@Override
	public long getDetailTlpId() {
		return model.getDetailTlpId();
	}

	/**
	 * Returns the discount of this detail tlp.
	 *
	 * @return the discount of this detail tlp
	 */
	@Override
	public double getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the dob of this detail tlp.
	 *
	 * @return the dob of this detail tlp
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the drive model of this detail tlp.
	 *
	 * @return the drive model of this detail tlp
	 */
	@Override
	public long getDriveModel() {
		return model.getDriveModel();
	}

	/**
	 * Returns the email of this detail tlp.
	 *
	 * @return the email of this detail tlp
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the engine number of this detail tlp.
	 *
	 * @return the engine number of this detail tlp
	 */
	@Override
	public String getEngineNumber() {
		return model.getEngineNumber();
	}

	/**
	 * Returns the expired date of this detail tlp.
	 *
	 * @return the expired date of this detail tlp
	 */
	@Override
	public Date getExpiredDate() {
		return model.getExpiredDate();
	}

	/**
	 * Returns the group ID of this detail tlp.
	 *
	 * @return the group ID of this detail tlp
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this detail tlp.
	 *
	 * @return the id number of this detail tlp
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the insurance name of this detail tlp.
	 *
	 * @return the insurance name of this detail tlp
	 */
	@Override
	public String getInsuranceName() {
		return model.getInsuranceName();
	}

	/**
	 * Returns the insurance policy no of this detail tlp.
	 *
	 * @return the insurance policy no of this detail tlp
	 */
	@Override
	public String getInsurancePolicyNo() {
		return model.getInsurancePolicyNo();
	}

	/**
	 * Returns the kitas number of this detail tlp.
	 *
	 * @return the kitas number of this detail tlp
	 */
	@Override
	public String getKitasNumber() {
		return model.getKitasNumber();
	}

	/**
	 * Returns the leads ID of this detail tlp.
	 *
	 * @return the leads ID of this detail tlp
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the main policy end date of this detail tlp.
	 *
	 * @return the main policy end date of this detail tlp
	 */
	@Override
	public Date getMainPolicyEndDate() {
		return model.getMainPolicyEndDate();
	}

	/**
	 * Returns the main policy start date of this detail tlp.
	 *
	 * @return the main policy start date of this detail tlp
	 */
	@Override
	public Date getMainPolicyStartDate() {
		return model.getMainPolicyStartDate();
	}

	/**
	 * Returns the managed by of this detail tlp.
	 *
	 * @return the managed by of this detail tlp
	 */
	@Override
	public long getManagedBy() {
		return model.getManagedBy();
	}

	/**
	 * Returns the manufacture year of this detail tlp.
	 *
	 * @return the manufacture year of this detail tlp
	 */
	@Override
	public int getManufactureYear() {
		return model.getManufactureYear();
	}

	/**
	 * Returns the marketing code of this detail tlp.
	 *
	 * @return the marketing code of this detail tlp
	 */
	@Override
	public String getMarketingCode() {
		return model.getMarketingCode();
	}

	/**
	 * Returns the mobile phone of this detail tlp.
	 *
	 * @return the mobile phone of this detail tlp
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this detail tlp.
	 *
	 * @return the modified date of this detail tlp
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this detail tlp.
	 *
	 * @return the name of this detail tlp
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nationality of this detail tlp.
	 *
	 * @return the nationality of this detail tlp
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the net premium of this detail tlp.
	 *
	 * @return the net premium of this detail tlp
	 */
	@Override
	public double getNetPremium() {
		return model.getNetPremium();
	}

	/**
	 * Returns the number of days of this detail tlp.
	 *
	 * @return the number of days of this detail tlp
	 */
	@Override
	public int getNumberOfDays() {
		return model.getNumberOfDays();
	}

	/**
	 * Returns the package info of this detail tlp.
	 *
	 * @return the package info of this detail tlp
	 */
	@Override
	public long getPackageInfo() {
		return model.getPackageInfo();
	}

	/**
	 * Returns the package name of this detail tlp.
	 *
	 * @return the package name of this detail tlp
	 */
	@Override
	public String getPackageName() {
		return model.getPackageName();
	}

	/**
	 * Returns the passport number of this detail tlp.
	 *
	 * @return the passport number of this detail tlp
	 */
	@Override
	public String getPassportNumber() {
		return model.getPassportNumber();
	}

	/**
	 * Returns the police number of this detail tlp.
	 *
	 * @return the police number of this detail tlp
	 */
	@Override
	public String getPoliceNumber() {
		return model.getPoliceNumber();
	}

	/**
	 * Returns the policy cost of this detail tlp.
	 *
	 * @return the policy cost of this detail tlp
	 */
	@Override
	public double getPolicyCost() {
		return model.getPolicyCost();
	}

	/**
	 * Returns the policy number of this detail tlp.
	 *
	 * @return the policy number of this detail tlp
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the policy status of this detail tlp.
	 *
	 * @return the policy status of this detail tlp
	 */
	@Override
	public String getPolicyStatus() {
		return model.getPolicyStatus();
	}

	/**
	 * Returns the post code of this detail tlp.
	 *
	 * @return the post code of this detail tlp
	 */
	@Override
	public String getPostCode() {
		return model.getPostCode();
	}

	/**
	 * Returns the premium of this detail tlp.
	 *
	 * @return the premium of this detail tlp
	 */
	@Override
	public double getPremium() {
		return model.getPremium();
	}

	/**
	 * Returns the primary key of this detail tlp.
	 *
	 * @return the primary key of this detail tlp
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promo code of this detail tlp.
	 *
	 * @return the promo code of this detail tlp
	 */
	@Override
	public String getPromoCode() {
		return model.getPromoCode();
	}

	/**
	 * Returns the province of this detail tlp.
	 *
	 * @return the province of this detail tlp
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the rate of this detail tlp.
	 *
	 * @return the rate of this detail tlp
	 */
	@Override
	public double getRate() {
		return model.getRate();
	}

	/**
	 * Returns the reference number of this detail tlp.
	 *
	 * @return the reference number of this detail tlp
	 */
	@Override
	public String getReferenceNumber() {
		return model.getReferenceNumber();
	}

	/**
	 * Returns the region plate of this detail tlp.
	 *
	 * @return the region plate of this detail tlp
	 */
	@Override
	public String getRegionPlate() {
		return model.getRegionPlate();
	}

	/**
	 * Returns the stamp duty of this detail tlp.
	 *
	 * @return the stamp duty of this detail tlp
	 */
	@Override
	public double getStampDuty() {
		return model.getStampDuty();
	}

	/**
	 * Returns the start date of this detail tlp.
	 *
	 * @return the start date of this detail tlp
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the step1 of this detail tlp.
	 *
	 * @return the step1 of this detail tlp
	 */
	@Override
	public int getStep1() {
		return model.getStep1();
	}

	/**
	 * Returns the sub agent of this detail tlp.
	 *
	 * @return the sub agent of this detail tlp
	 */
	@Override
	public long getSubAgent() {
		return model.getSubAgent();
	}

	/**
	 * Returns the sum insured of this detail tlp.
	 *
	 * @return the sum insured of this detail tlp
	 */
	@Override
	public double getSumInsured() {
		return model.getSumInsured();
	}

	/**
	 * Returns the transaction id_ of this detail tlp.
	 *
	 * @return the transaction id_ of this detail tlp
	 */
	@Override
	public long getTransactionId_() {
		return model.getTransactionId_();
	}

	/**
	 * Returns the user ID of this detail tlp.
	 *
	 * @return the user ID of this detail tlp
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail tlp.
	 *
	 * @return the user name of this detail tlp
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail tlp.
	 *
	 * @return the user uuid of this detail tlp
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm campaign of this detail tlp.
	 *
	 * @return the utm campaign of this detail tlp
	 */
	@Override
	public String getUtmCampaign() {
		return model.getUtmCampaign();
	}

	/**
	 * Returns the utm content of this detail tlp.
	 *
	 * @return the utm content of this detail tlp
	 */
	@Override
	public String getUtmContent() {
		return model.getUtmContent();
	}

	/**
	 * Returns the utm medium of this detail tlp.
	 *
	 * @return the utm medium of this detail tlp
	 */
	@Override
	public String getUtmMedium() {
		return model.getUtmMedium();
	}

	/**
	 * Returns the utm source of this detail tlp.
	 *
	 * @return the utm source of this detail tlp
	 */
	@Override
	public String getUtmSource() {
		return model.getUtmSource();
	}

	/**
	 * Returns the utm term of this detail tlp.
	 *
	 * @return the utm term of this detail tlp
	 */
	@Override
	public String getUtmTerm() {
		return model.getUtmTerm();
	}

	/**
	 * Returns the vehicle insured of this detail tlp.
	 *
	 * @return the vehicle insured of this detail tlp
	 */
	@Override
	public double getVehicleInsured() {
		return model.getVehicleInsured();
	}

	/**
	 * Returns the vehicle manufacture of this detail tlp.
	 *
	 * @return the vehicle manufacture of this detail tlp
	 */
	@Override
	public String getVehicleManufacture() {
		return model.getVehicleManufacture();
	}

	/**
	 * Returns the vehicle model of this detail tlp.
	 *
	 * @return the vehicle model of this detail tlp
	 */
	@Override
	public String getVehicleModel() {
		return model.getVehicleModel();
	}

	/**
	 * Returns the vehicle sub model of this detail tlp.
	 *
	 * @return the vehicle sub model of this detail tlp
	 */
	@Override
	public String getVehicleSubModel() {
		return model.getVehicleSubModel();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this detail tlp.
	 *
	 * @param address the address of this detail tlp
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address2 of this detail tlp.
	 *
	 * @param address2 the address2 of this detail tlp
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the agent code of this detail tlp.
	 *
	 * @param agentCode the agent code of this detail tlp
	 */
	@Override
	public void setAgentCode(String agentCode) {
		model.setAgentCode(agentCode);
	}

	/**
	 * Sets the birth place of this detail tlp.
	 *
	 * @param birthPlace the birth place of this detail tlp
	 */
	@Override
	public void setBirthPlace(String birthPlace) {
		model.setBirthPlace(birthPlace);
	}

	/**
	 * Sets the business model of this detail tlp.
	 *
	 * @param businessModel the business model of this detail tlp
	 */
	@Override
	public void setBusinessModel(String businessModel) {
		model.setBusinessModel(businessModel);
	}

	/**
	 * Sets the channel of this detail tlp.
	 *
	 * @param channel the channel of this detail tlp
	 */
	@Override
	public void setChannel(String channel) {
		model.setChannel(channel);
	}

	/**
	 * Sets the chassis number of this detail tlp.
	 *
	 * @param chassisNumber the chassis number of this detail tlp
	 */
	@Override
	public void setChassisNumber(String chassisNumber) {
		model.setChassisNumber(chassisNumber);
	}

	/**
	 * Sets the city of this detail tlp.
	 *
	 * @param city the city of this detail tlp
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the click ID of this detail tlp.
	 *
	 * @param clickId the click ID of this detail tlp
	 */
	@Override
	public void setClickId(String clickId) {
		model.setClickId(clickId);
	}

	/**
	 * Sets the commercial offer of this detail tlp.
	 *
	 * @param commercialOffer the commercial offer of this detail tlp
	 */
	@Override
	public void setCommercialOffer(int commercialOffer) {
		model.setCommercialOffer(commercialOffer);
	}

	/**
	 * Sets the commision of this detail tlp.
	 *
	 * @param commision the commision of this detail tlp
	 */
	@Override
	public void setCommision(double commision) {
		model.setCommision(commision);
	}

	/**
	 * Sets the company ID of this detail tlp.
	 *
	 * @param companyId the company ID of this detail tlp
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this detail tlp.
	 *
	 * @param createDate the create date of this detail tlp
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency_ of this detail tlp.
	 *
	 * @param currency_ the currency_ of this detail tlp
	 */
	@Override
	public void setCurrency_(String currency_) {
		model.setCurrency_(currency_);
	}

	/**
	 * Sets the detail tlp ID of this detail tlp.
	 *
	 * @param detailTlpId the detail tlp ID of this detail tlp
	 */
	@Override
	public void setDetailTlpId(long detailTlpId) {
		model.setDetailTlpId(detailTlpId);
	}

	/**
	 * Sets the discount of this detail tlp.
	 *
	 * @param discount the discount of this detail tlp
	 */
	@Override
	public void setDiscount(double discount) {
		model.setDiscount(discount);
	}

	/**
	 * Sets the dob of this detail tlp.
	 *
	 * @param dob the dob of this detail tlp
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the drive model of this detail tlp.
	 *
	 * @param driveModel the drive model of this detail tlp
	 */
	@Override
	public void setDriveModel(long driveModel) {
		model.setDriveModel(driveModel);
	}

	/**
	 * Sets the email of this detail tlp.
	 *
	 * @param email the email of this detail tlp
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the engine number of this detail tlp.
	 *
	 * @param engineNumber the engine number of this detail tlp
	 */
	@Override
	public void setEngineNumber(String engineNumber) {
		model.setEngineNumber(engineNumber);
	}

	/**
	 * Sets the expired date of this detail tlp.
	 *
	 * @param expiredDate the expired date of this detail tlp
	 */
	@Override
	public void setExpiredDate(Date expiredDate) {
		model.setExpiredDate(expiredDate);
	}

	/**
	 * Sets the group ID of this detail tlp.
	 *
	 * @param groupId the group ID of this detail tlp
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this detail tlp.
	 *
	 * @param idNumber the id number of this detail tlp
	 */
	@Override
	public void setIdNumber(String idNumber) {
		model.setIdNumber(idNumber);
	}

	/**
	 * Sets the insurance name of this detail tlp.
	 *
	 * @param insuranceName the insurance name of this detail tlp
	 */
	@Override
	public void setInsuranceName(String insuranceName) {
		model.setInsuranceName(insuranceName);
	}

	/**
	 * Sets the insurance policy no of this detail tlp.
	 *
	 * @param insurancePolicyNo the insurance policy no of this detail tlp
	 */
	@Override
	public void setInsurancePolicyNo(String insurancePolicyNo) {
		model.setInsurancePolicyNo(insurancePolicyNo);
	}

	/**
	 * Sets the kitas number of this detail tlp.
	 *
	 * @param kitasNumber the kitas number of this detail tlp
	 */
	@Override
	public void setKitasNumber(String kitasNumber) {
		model.setKitasNumber(kitasNumber);
	}

	/**
	 * Sets the leads ID of this detail tlp.
	 *
	 * @param leadsId the leads ID of this detail tlp
	 */
	@Override
	public void setLeadsId(long leadsId) {
		model.setLeadsId(leadsId);
	}

	/**
	 * Sets the main policy end date of this detail tlp.
	 *
	 * @param mainPolicyEndDate the main policy end date of this detail tlp
	 */
	@Override
	public void setMainPolicyEndDate(Date mainPolicyEndDate) {
		model.setMainPolicyEndDate(mainPolicyEndDate);
	}

	/**
	 * Sets the main policy start date of this detail tlp.
	 *
	 * @param mainPolicyStartDate the main policy start date of this detail tlp
	 */
	@Override
	public void setMainPolicyStartDate(Date mainPolicyStartDate) {
		model.setMainPolicyStartDate(mainPolicyStartDate);
	}

	/**
	 * Sets the managed by of this detail tlp.
	 *
	 * @param managedBy the managed by of this detail tlp
	 */
	@Override
	public void setManagedBy(long managedBy) {
		model.setManagedBy(managedBy);
	}

	/**
	 * Sets the manufacture year of this detail tlp.
	 *
	 * @param manufactureYear the manufacture year of this detail tlp
	 */
	@Override
	public void setManufactureYear(int manufactureYear) {
		model.setManufactureYear(manufactureYear);
	}

	/**
	 * Sets the marketing code of this detail tlp.
	 *
	 * @param marketingCode the marketing code of this detail tlp
	 */
	@Override
	public void setMarketingCode(String marketingCode) {
		model.setMarketingCode(marketingCode);
	}

	/**
	 * Sets the mobile phone of this detail tlp.
	 *
	 * @param mobilePhone the mobile phone of this detail tlp
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this detail tlp.
	 *
	 * @param modifiedDate the modified date of this detail tlp
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this detail tlp.
	 *
	 * @param name the name of this detail tlp
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the nationality of this detail tlp.
	 *
	 * @param nationality the nationality of this detail tlp
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the net premium of this detail tlp.
	 *
	 * @param netPremium the net premium of this detail tlp
	 */
	@Override
	public void setNetPremium(double netPremium) {
		model.setNetPremium(netPremium);
	}

	/**
	 * Sets the number of days of this detail tlp.
	 *
	 * @param numberOfDays the number of days of this detail tlp
	 */
	@Override
	public void setNumberOfDays(int numberOfDays) {
		model.setNumberOfDays(numberOfDays);
	}

	/**
	 * Sets the package info of this detail tlp.
	 *
	 * @param packageInfo the package info of this detail tlp
	 */
	@Override
	public void setPackageInfo(long packageInfo) {
		model.setPackageInfo(packageInfo);
	}

	/**
	 * Sets the package name of this detail tlp.
	 *
	 * @param packageName the package name of this detail tlp
	 */
	@Override
	public void setPackageName(String packageName) {
		model.setPackageName(packageName);
	}

	/**
	 * Sets the passport number of this detail tlp.
	 *
	 * @param passportNumber the passport number of this detail tlp
	 */
	@Override
	public void setPassportNumber(String passportNumber) {
		model.setPassportNumber(passportNumber);
	}

	/**
	 * Sets the police number of this detail tlp.
	 *
	 * @param policeNumber the police number of this detail tlp
	 */
	@Override
	public void setPoliceNumber(String policeNumber) {
		model.setPoliceNumber(policeNumber);
	}

	/**
	 * Sets the policy cost of this detail tlp.
	 *
	 * @param policyCost the policy cost of this detail tlp
	 */
	@Override
	public void setPolicyCost(double policyCost) {
		model.setPolicyCost(policyCost);
	}

	/**
	 * Sets the policy number of this detail tlp.
	 *
	 * @param policyNumber the policy number of this detail tlp
	 */
	@Override
	public void setPolicyNumber(String policyNumber) {
		model.setPolicyNumber(policyNumber);
	}

	/**
	 * Sets the policy status of this detail tlp.
	 *
	 * @param policyStatus the policy status of this detail tlp
	 */
	@Override
	public void setPolicyStatus(String policyStatus) {
		model.setPolicyStatus(policyStatus);
	}

	/**
	 * Sets the post code of this detail tlp.
	 *
	 * @param postCode the post code of this detail tlp
	 */
	@Override
	public void setPostCode(String postCode) {
		model.setPostCode(postCode);
	}

	/**
	 * Sets the premium of this detail tlp.
	 *
	 * @param premium the premium of this detail tlp
	 */
	@Override
	public void setPremium(double premium) {
		model.setPremium(premium);
	}

	/**
	 * Sets the primary key of this detail tlp.
	 *
	 * @param primaryKey the primary key of this detail tlp
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promo code of this detail tlp.
	 *
	 * @param promoCode the promo code of this detail tlp
	 */
	@Override
	public void setPromoCode(String promoCode) {
		model.setPromoCode(promoCode);
	}

	/**
	 * Sets the province of this detail tlp.
	 *
	 * @param province the province of this detail tlp
	 */
	@Override
	public void setProvince(String province) {
		model.setProvince(province);
	}

	/**
	 * Sets the rate of this detail tlp.
	 *
	 * @param rate the rate of this detail tlp
	 */
	@Override
	public void setRate(double rate) {
		model.setRate(rate);
	}

	/**
	 * Sets the reference number of this detail tlp.
	 *
	 * @param referenceNumber the reference number of this detail tlp
	 */
	@Override
	public void setReferenceNumber(String referenceNumber) {
		model.setReferenceNumber(referenceNumber);
	}

	/**
	 * Sets the region plate of this detail tlp.
	 *
	 * @param regionPlate the region plate of this detail tlp
	 */
	@Override
	public void setRegionPlate(String regionPlate) {
		model.setRegionPlate(regionPlate);
	}

	/**
	 * Sets the stamp duty of this detail tlp.
	 *
	 * @param stampDuty the stamp duty of this detail tlp
	 */
	@Override
	public void setStampDuty(double stampDuty) {
		model.setStampDuty(stampDuty);
	}

	/**
	 * Sets the start date of this detail tlp.
	 *
	 * @param startDate the start date of this detail tlp
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the step1 of this detail tlp.
	 *
	 * @param step1 the step1 of this detail tlp
	 */
	@Override
	public void setStep1(int step1) {
		model.setStep1(step1);
	}

	/**
	 * Sets the sub agent of this detail tlp.
	 *
	 * @param subAgent the sub agent of this detail tlp
	 */
	@Override
	public void setSubAgent(long subAgent) {
		model.setSubAgent(subAgent);
	}

	/**
	 * Sets the sum insured of this detail tlp.
	 *
	 * @param sumInsured the sum insured of this detail tlp
	 */
	@Override
	public void setSumInsured(double sumInsured) {
		model.setSumInsured(sumInsured);
	}

	/**
	 * Sets the transaction id_ of this detail tlp.
	 *
	 * @param transactionId_ the transaction id_ of this detail tlp
	 */
	@Override
	public void setTransactionId_(long transactionId_) {
		model.setTransactionId_(transactionId_);
	}

	/**
	 * Sets the user ID of this detail tlp.
	 *
	 * @param userId the user ID of this detail tlp
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail tlp.
	 *
	 * @param userName the user name of this detail tlp
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail tlp.
	 *
	 * @param userUuid the user uuid of this detail tlp
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm campaign of this detail tlp.
	 *
	 * @param utmCampaign the utm campaign of this detail tlp
	 */
	@Override
	public void setUtmCampaign(String utmCampaign) {
		model.setUtmCampaign(utmCampaign);
	}

	/**
	 * Sets the utm content of this detail tlp.
	 *
	 * @param utmContent the utm content of this detail tlp
	 */
	@Override
	public void setUtmContent(String utmContent) {
		model.setUtmContent(utmContent);
	}

	/**
	 * Sets the utm medium of this detail tlp.
	 *
	 * @param utmMedium the utm medium of this detail tlp
	 */
	@Override
	public void setUtmMedium(String utmMedium) {
		model.setUtmMedium(utmMedium);
	}

	/**
	 * Sets the utm source of this detail tlp.
	 *
	 * @param utmSource the utm source of this detail tlp
	 */
	@Override
	public void setUtmSource(String utmSource) {
		model.setUtmSource(utmSource);
	}

	/**
	 * Sets the utm term of this detail tlp.
	 *
	 * @param utmTerm the utm term of this detail tlp
	 */
	@Override
	public void setUtmTerm(String utmTerm) {
		model.setUtmTerm(utmTerm);
	}

	/**
	 * Sets the vehicle insured of this detail tlp.
	 *
	 * @param vehicleInsured the vehicle insured of this detail tlp
	 */
	@Override
	public void setVehicleInsured(double vehicleInsured) {
		model.setVehicleInsured(vehicleInsured);
	}

	/**
	 * Sets the vehicle manufacture of this detail tlp.
	 *
	 * @param vehicleManufacture the vehicle manufacture of this detail tlp
	 */
	@Override
	public void setVehicleManufacture(String vehicleManufacture) {
		model.setVehicleManufacture(vehicleManufacture);
	}

	/**
	 * Sets the vehicle model of this detail tlp.
	 *
	 * @param vehicleModel the vehicle model of this detail tlp
	 */
	@Override
	public void setVehicleModel(String vehicleModel) {
		model.setVehicleModel(vehicleModel);
	}

	/**
	 * Sets the vehicle sub model of this detail tlp.
	 *
	 * @param vehicleSubModel the vehicle sub model of this detail tlp
	 */
	@Override
	public void setVehicleSubModel(String vehicleSubModel) {
		model.setVehicleSubModel(vehicleSubModel);
	}

	@Override
	protected DetailTlpWrapper wrap(DetailTlp detailTlp) {
		return new DetailTlpWrapper(detailTlp);
	}

}