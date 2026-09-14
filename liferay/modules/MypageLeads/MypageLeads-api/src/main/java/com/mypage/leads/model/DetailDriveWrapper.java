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
 * This class is a wrapper for {@link DetailDrive}.
 * </p>
 *
 * @author Gositus
 * @see DetailDrive
 * @generated
 */
public class DetailDriveWrapper
	extends BaseModelWrapper<DetailDrive>
	implements DetailDrive, ModelWrapper<DetailDrive> {

	public DetailDriveWrapper(DetailDrive detailDrive) {
		super(detailDrive);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("detailDriveId", getDetailDriveId());
		attributes.put("leadsId", getLeadsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("vehicleCode", getVehicleCode());
		attributes.put("VehicleManufacture", getVehicleManufacture());
		attributes.put("vehicleModel", getVehicleModel());
		attributes.put("vehicleSubModel", getVehicleSubModel());
		attributes.put("vehicleBody", getVehicleBody());
		attributes.put("manufactureYear", getManufactureYear());
		attributes.put("manufactureAge", getManufactureAge());
		attributes.put("coverageType", getCoverageType());
		attributes.put("vehicleType", getVehicleType());
		attributes.put("typeOfUse", getTypeOfUse());
		attributes.put("vehicleInsured", getVehicleInsured());
		attributes.put("accessoriesInsured", getAccessoriesInsured());
		attributes.put("sumInsured", getSumInsured());
		attributes.put("regionPlate", getRegionPlate());
		attributes.put("cc", getCc());
		attributes.put("make", getMake());
		attributes.put("dpg", getDpg());
		attributes.put("seatCapacity", getSeatCapacity());
		attributes.put("startDate", getStartDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("commercialOffers", getCommercialOffers());
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
		attributes.put("policeNumber", getPoliceNumber());
		attributes.put("chassisNumber", getChassisNumber());
		attributes.put("engineNumber", getEngineNumber());
		attributes.put("policyNumber", getPolicyNumber());
		attributes.put("referenceNumber", getReferenceNumber());
		attributes.put("policyStatus", getPolicyStatus());
		attributes.put("currency", getCurrency());
		attributes.put("policyCost", getPolicyCost());
		attributes.put("stampDuty", getStampDuty());
		attributes.put("premium", getPremium());
		attributes.put("netPremium", getNetPremium());
		attributes.put("discount", getDiscount());
		attributes.put("commission", getCommission());
		attributes.put("leads", getLeads());
		attributes.put("transactionId", getTransactionId());
		attributes.put("bussinesModel", getBussinesModel());
		attributes.put("channel", getChannel());
		attributes.put("promoCode", getPromoCode());
		attributes.put("step1", getStep1());
		attributes.put("step2", getStep2());
		attributes.put("step3", getStep3());
		attributes.put("dailyReportStatus", getDailyReportStatus());
		attributes.put("dailyReportFile", getDailyReportFile());
		attributes.put("dailyReportAgentStatus", getDailyReportAgentStatus());
		attributes.put("dailyReportAgentFile", getDailyReportAgentFile());
		attributes.put("utmSource", getUtmSource());
		attributes.put("utmMedium", getUtmMedium());
		attributes.put("utmCampaign", getUtmCampaign());
		attributes.put("utmTerm", getUtmTerm());
		attributes.put("utmContent", getUtmContent());
		attributes.put("clickId", getClickId());
		attributes.put("managedBy", getManagedBy());
		attributes.put("agentCode", getAgentCode());
		attributes.put("subAgent", getSubAgent());
		attributes.put("marketingCode", getMarketingCode());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long detailDriveId = (Long)attributes.get("detailDriveId");

		if (detailDriveId != null) {
			setDetailDriveId(detailDriveId);
		}

		Long leadsId = (Long)attributes.get("leadsId");

		if (leadsId != null) {
			setLeadsId(leadsId);
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

		String vehicleCode = (String)attributes.get("vehicleCode");

		if (vehicleCode != null) {
			setVehicleCode(vehicleCode);
		}

		String VehicleManufacture = (String)attributes.get(
			"VehicleManufacture");

		if (VehicleManufacture != null) {
			setVehicleManufacture(VehicleManufacture);
		}

		String vehicleModel = (String)attributes.get("vehicleModel");

		if (vehicleModel != null) {
			setVehicleModel(vehicleModel);
		}

		String vehicleSubModel = (String)attributes.get("vehicleSubModel");

		if (vehicleSubModel != null) {
			setVehicleSubModel(vehicleSubModel);
		}

		String vehicleBody = (String)attributes.get("vehicleBody");

		if (vehicleBody != null) {
			setVehicleBody(vehicleBody);
		}

		Integer manufactureYear = (Integer)attributes.get("manufactureYear");

		if (manufactureYear != null) {
			setManufactureYear(manufactureYear);
		}

		Integer manufactureAge = (Integer)attributes.get("manufactureAge");

		if (manufactureAge != null) {
			setManufactureAge(manufactureAge);
		}

		String coverageType = (String)attributes.get("coverageType");

		if (coverageType != null) {
			setCoverageType(coverageType);
		}

		String vehicleType = (String)attributes.get("vehicleType");

		if (vehicleType != null) {
			setVehicleType(vehicleType);
		}

		String typeOfUse = (String)attributes.get("typeOfUse");

		if (typeOfUse != null) {
			setTypeOfUse(typeOfUse);
		}

		Double vehicleInsured = (Double)attributes.get("vehicleInsured");

		if (vehicleInsured != null) {
			setVehicleInsured(vehicleInsured);
		}

		Double accessoriesInsured = (Double)attributes.get(
			"accessoriesInsured");

		if (accessoriesInsured != null) {
			setAccessoriesInsured(accessoriesInsured);
		}

		Double sumInsured = (Double)attributes.get("sumInsured");

		if (sumInsured != null) {
			setSumInsured(sumInsured);
		}

		String regionPlate = (String)attributes.get("regionPlate");

		if (regionPlate != null) {
			setRegionPlate(regionPlate);
		}

		Integer cc = (Integer)attributes.get("cc");

		if (cc != null) {
			setCc(cc);
		}

		String make = (String)attributes.get("make");

		if (make != null) {
			setMake(make);
		}

		String dpg = (String)attributes.get("dpg");

		if (dpg != null) {
			setDpg(dpg);
		}

		Integer seatCapacity = (Integer)attributes.get("seatCapacity");

		if (seatCapacity != null) {
			setSeatCapacity(seatCapacity);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}

		Integer commercialOffers = (Integer)attributes.get("commercialOffers");

		if (commercialOffers != null) {
			setCommercialOffers(commercialOffers);
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

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
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

		Integer discount = (Integer)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String commission = (String)attributes.get("commission");

		if (commission != null) {
			setCommission(commission);
		}

		Long leads = (Long)attributes.get("leads");

		if (leads != null) {
			setLeads(leads);
		}

		String transactionId = (String)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		String bussinesModel = (String)attributes.get("bussinesModel");

		if (bussinesModel != null) {
			setBussinesModel(bussinesModel);
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

		Integer step2 = (Integer)attributes.get("step2");

		if (step2 != null) {
			setStep2(step2);
		}

		Integer step3 = (Integer)attributes.get("step3");

		if (step3 != null) {
			setStep3(step3);
		}

		Integer dailyReportStatus = (Integer)attributes.get(
			"dailyReportStatus");

		if (dailyReportStatus != null) {
			setDailyReportStatus(dailyReportStatus);
		}

		Long dailyReportFile = (Long)attributes.get("dailyReportFile");

		if (dailyReportFile != null) {
			setDailyReportFile(dailyReportFile);
		}

		Integer dailyReportAgentStatus = (Integer)attributes.get(
			"dailyReportAgentStatus");

		if (dailyReportAgentStatus != null) {
			setDailyReportAgentStatus(dailyReportAgentStatus);
		}

		Long dailyReportAgentFile = (Long)attributes.get(
			"dailyReportAgentFile");

		if (dailyReportAgentFile != null) {
			setDailyReportAgentFile(dailyReportAgentFile);
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

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the accessories insured of this detail drive.
	 *
	 * @return the accessories insured of this detail drive
	 */
	@Override
	public double getAccessoriesInsured() {
		return model.getAccessoriesInsured();
	}

	/**
	 * Returns the active of this detail drive.
	 *
	 * @return the active of this detail drive
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the address of this detail drive.
	 *
	 * @return the address of this detail drive
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this detail drive.
	 *
	 * @return the address2 of this detail drive
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the agent code of this detail drive.
	 *
	 * @return the agent code of this detail drive
	 */
	@Override
	public String getAgentCode() {
		return model.getAgentCode();
	}

	/**
	 * Returns the birth place of this detail drive.
	 *
	 * @return the birth place of this detail drive
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the bussines model of this detail drive.
	 *
	 * @return the bussines model of this detail drive
	 */
	@Override
	public String getBussinesModel() {
		return model.getBussinesModel();
	}

	/**
	 * Returns the cc of this detail drive.
	 *
	 * @return the cc of this detail drive
	 */
	@Override
	public int getCc() {
		return model.getCc();
	}

	/**
	 * Returns the channel of this detail drive.
	 *
	 * @return the channel of this detail drive
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the chassis number of this detail drive.
	 *
	 * @return the chassis number of this detail drive
	 */
	@Override
	public String getChassisNumber() {
		return model.getChassisNumber();
	}

	/**
	 * Returns the city of this detail drive.
	 *
	 * @return the city of this detail drive
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the click ID of this detail drive.
	 *
	 * @return the click ID of this detail drive
	 */
	@Override
	public String getClickId() {
		return model.getClickId();
	}

	/**
	 * Returns the commercial offers of this detail drive.
	 *
	 * @return the commercial offers of this detail drive
	 */
	@Override
	public int getCommercialOffers() {
		return model.getCommercialOffers();
	}

	/**
	 * Returns the commission of this detail drive.
	 *
	 * @return the commission of this detail drive
	 */
	@Override
	public String getCommission() {
		return model.getCommission();
	}

	/**
	 * Returns the company ID of this detail drive.
	 *
	 * @return the company ID of this detail drive
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the coverage type of this detail drive.
	 *
	 * @return the coverage type of this detail drive
	 */
	@Override
	public String getCoverageType() {
		return model.getCoverageType();
	}

	/**
	 * Returns the create date of this detail drive.
	 *
	 * @return the create date of this detail drive
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this detail drive.
	 *
	 * @return the currency of this detail drive
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the daily report agent file of this detail drive.
	 *
	 * @return the daily report agent file of this detail drive
	 */
	@Override
	public long getDailyReportAgentFile() {
		return model.getDailyReportAgentFile();
	}

	/**
	 * Returns the daily report agent status of this detail drive.
	 *
	 * @return the daily report agent status of this detail drive
	 */
	@Override
	public int getDailyReportAgentStatus() {
		return model.getDailyReportAgentStatus();
	}

	/**
	 * Returns the daily report file of this detail drive.
	 *
	 * @return the daily report file of this detail drive
	 */
	@Override
	public long getDailyReportFile() {
		return model.getDailyReportFile();
	}

	/**
	 * Returns the daily report status of this detail drive.
	 *
	 * @return the daily report status of this detail drive
	 */
	@Override
	public int getDailyReportStatus() {
		return model.getDailyReportStatus();
	}

	/**
	 * Returns the detail drive ID of this detail drive.
	 *
	 * @return the detail drive ID of this detail drive
	 */
	@Override
	public long getDetailDriveId() {
		return model.getDetailDriveId();
	}

	/**
	 * Returns the discount of this detail drive.
	 *
	 * @return the discount of this detail drive
	 */
	@Override
	public int getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the dob of this detail drive.
	 *
	 * @return the dob of this detail drive
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the dpg of this detail drive.
	 *
	 * @return the dpg of this detail drive
	 */
	@Override
	public String getDpg() {
		return model.getDpg();
	}

	/**
	 * Returns the email of this detail drive.
	 *
	 * @return the email of this detail drive
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the engine number of this detail drive.
	 *
	 * @return the engine number of this detail drive
	 */
	@Override
	public String getEngineNumber() {
		return model.getEngineNumber();
	}

	/**
	 * Returns the expired date of this detail drive.
	 *
	 * @return the expired date of this detail drive
	 */
	@Override
	public Date getExpiredDate() {
		return model.getExpiredDate();
	}

	/**
	 * Returns the group ID of this detail drive.
	 *
	 * @return the group ID of this detail drive
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this detail drive.
	 *
	 * @return the id number of this detail drive
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the kitas number of this detail drive.
	 *
	 * @return the kitas number of this detail drive
	 */
	@Override
	public String getKitasNumber() {
		return model.getKitasNumber();
	}

	/**
	 * Returns the leads of this detail drive.
	 *
	 * @return the leads of this detail drive
	 */
	@Override
	public long getLeads() {
		return model.getLeads();
	}

	/**
	 * Returns the leads ID of this detail drive.
	 *
	 * @return the leads ID of this detail drive
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the make of this detail drive.
	 *
	 * @return the make of this detail drive
	 */
	@Override
	public String getMake() {
		return model.getMake();
	}

	/**
	 * Returns the managed by of this detail drive.
	 *
	 * @return the managed by of this detail drive
	 */
	@Override
	public long getManagedBy() {
		return model.getManagedBy();
	}

	/**
	 * Returns the manufacture age of this detail drive.
	 *
	 * @return the manufacture age of this detail drive
	 */
	@Override
	public int getManufactureAge() {
		return model.getManufactureAge();
	}

	/**
	 * Returns the manufacture year of this detail drive.
	 *
	 * @return the manufacture year of this detail drive
	 */
	@Override
	public int getManufactureYear() {
		return model.getManufactureYear();
	}

	/**
	 * Returns the marketing code of this detail drive.
	 *
	 * @return the marketing code of this detail drive
	 */
	@Override
	public String getMarketingCode() {
		return model.getMarketingCode();
	}

	/**
	 * Returns the mobile phone of this detail drive.
	 *
	 * @return the mobile phone of this detail drive
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this detail drive.
	 *
	 * @return the modified date of this detail drive
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this detail drive.
	 *
	 * @return the name of this detail drive
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nationality of this detail drive.
	 *
	 * @return the nationality of this detail drive
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the net premium of this detail drive.
	 *
	 * @return the net premium of this detail drive
	 */
	@Override
	public double getNetPremium() {
		return model.getNetPremium();
	}

	/**
	 * Returns the passport number of this detail drive.
	 *
	 * @return the passport number of this detail drive
	 */
	@Override
	public String getPassportNumber() {
		return model.getPassportNumber();
	}

	/**
	 * Returns the police number of this detail drive.
	 *
	 * @return the police number of this detail drive
	 */
	@Override
	public String getPoliceNumber() {
		return model.getPoliceNumber();
	}

	/**
	 * Returns the policy cost of this detail drive.
	 *
	 * @return the policy cost of this detail drive
	 */
	@Override
	public double getPolicyCost() {
		return model.getPolicyCost();
	}

	/**
	 * Returns the policy number of this detail drive.
	 *
	 * @return the policy number of this detail drive
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the policy status of this detail drive.
	 *
	 * @return the policy status of this detail drive
	 */
	@Override
	public String getPolicyStatus() {
		return model.getPolicyStatus();
	}

	/**
	 * Returns the premium of this detail drive.
	 *
	 * @return the premium of this detail drive
	 */
	@Override
	public double getPremium() {
		return model.getPremium();
	}

	/**
	 * Returns the primary key of this detail drive.
	 *
	 * @return the primary key of this detail drive
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promo code of this detail drive.
	 *
	 * @return the promo code of this detail drive
	 */
	@Override
	public String getPromoCode() {
		return model.getPromoCode();
	}

	/**
	 * Returns the province of this detail drive.
	 *
	 * @return the province of this detail drive
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the reference number of this detail drive.
	 *
	 * @return the reference number of this detail drive
	 */
	@Override
	public String getReferenceNumber() {
		return model.getReferenceNumber();
	}

	/**
	 * Returns the region plate of this detail drive.
	 *
	 * @return the region plate of this detail drive
	 */
	@Override
	public String getRegionPlate() {
		return model.getRegionPlate();
	}

	/**
	 * Returns the seat capacity of this detail drive.
	 *
	 * @return the seat capacity of this detail drive
	 */
	@Override
	public int getSeatCapacity() {
		return model.getSeatCapacity();
	}

	/**
	 * Returns the stamp duty of this detail drive.
	 *
	 * @return the stamp duty of this detail drive
	 */
	@Override
	public double getStampDuty() {
		return model.getStampDuty();
	}

	/**
	 * Returns the start date of this detail drive.
	 *
	 * @return the start date of this detail drive
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the step1 of this detail drive.
	 *
	 * @return the step1 of this detail drive
	 */
	@Override
	public int getStep1() {
		return model.getStep1();
	}

	/**
	 * Returns the step2 of this detail drive.
	 *
	 * @return the step2 of this detail drive
	 */
	@Override
	public int getStep2() {
		return model.getStep2();
	}

	/**
	 * Returns the step3 of this detail drive.
	 *
	 * @return the step3 of this detail drive
	 */
	@Override
	public int getStep3() {
		return model.getStep3();
	}

	/**
	 * Returns the sub agent of this detail drive.
	 *
	 * @return the sub agent of this detail drive
	 */
	@Override
	public long getSubAgent() {
		return model.getSubAgent();
	}

	/**
	 * Returns the sum insured of this detail drive.
	 *
	 * @return the sum insured of this detail drive
	 */
	@Override
	public double getSumInsured() {
		return model.getSumInsured();
	}

	/**
	 * Returns the transaction ID of this detail drive.
	 *
	 * @return the transaction ID of this detail drive
	 */
	@Override
	public String getTransactionId() {
		return model.getTransactionId();
	}

	/**
	 * Returns the type of use of this detail drive.
	 *
	 * @return the type of use of this detail drive
	 */
	@Override
	public String getTypeOfUse() {
		return model.getTypeOfUse();
	}

	/**
	 * Returns the user ID of this detail drive.
	 *
	 * @return the user ID of this detail drive
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail drive.
	 *
	 * @return the user name of this detail drive
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail drive.
	 *
	 * @return the user uuid of this detail drive
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm campaign of this detail drive.
	 *
	 * @return the utm campaign of this detail drive
	 */
	@Override
	public String getUtmCampaign() {
		return model.getUtmCampaign();
	}

	/**
	 * Returns the utm content of this detail drive.
	 *
	 * @return the utm content of this detail drive
	 */
	@Override
	public String getUtmContent() {
		return model.getUtmContent();
	}

	/**
	 * Returns the utm medium of this detail drive.
	 *
	 * @return the utm medium of this detail drive
	 */
	@Override
	public String getUtmMedium() {
		return model.getUtmMedium();
	}

	/**
	 * Returns the utm source of this detail drive.
	 *
	 * @return the utm source of this detail drive
	 */
	@Override
	public String getUtmSource() {
		return model.getUtmSource();
	}

	/**
	 * Returns the utm term of this detail drive.
	 *
	 * @return the utm term of this detail drive
	 */
	@Override
	public String getUtmTerm() {
		return model.getUtmTerm();
	}

	/**
	 * Returns the vehicle body of this detail drive.
	 *
	 * @return the vehicle body of this detail drive
	 */
	@Override
	public String getVehicleBody() {
		return model.getVehicleBody();
	}

	/**
	 * Returns the vehicle code of this detail drive.
	 *
	 * @return the vehicle code of this detail drive
	 */
	@Override
	public String getVehicleCode() {
		return model.getVehicleCode();
	}

	/**
	 * Returns the vehicle insured of this detail drive.
	 *
	 * @return the vehicle insured of this detail drive
	 */
	@Override
	public double getVehicleInsured() {
		return model.getVehicleInsured();
	}

	/**
	 * Returns the vehicle manufacture of this detail drive.
	 *
	 * @return the vehicle manufacture of this detail drive
	 */
	@Override
	public String getVehicleManufacture() {
		return model.getVehicleManufacture();
	}

	/**
	 * Returns the vehicle model of this detail drive.
	 *
	 * @return the vehicle model of this detail drive
	 */
	@Override
	public String getVehicleModel() {
		return model.getVehicleModel();
	}

	/**
	 * Returns the vehicle sub model of this detail drive.
	 *
	 * @return the vehicle sub model of this detail drive
	 */
	@Override
	public String getVehicleSubModel() {
		return model.getVehicleSubModel();
	}

	/**
	 * Returns the vehicle type of this detail drive.
	 *
	 * @return the vehicle type of this detail drive
	 */
	@Override
	public String getVehicleType() {
		return model.getVehicleType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accessories insured of this detail drive.
	 *
	 * @param accessoriesInsured the accessories insured of this detail drive
	 */
	@Override
	public void setAccessoriesInsured(double accessoriesInsured) {
		model.setAccessoriesInsured(accessoriesInsured);
	}

	/**
	 * Sets the active of this detail drive.
	 *
	 * @param active the active of this detail drive
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the address of this detail drive.
	 *
	 * @param address the address of this detail drive
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address2 of this detail drive.
	 *
	 * @param address2 the address2 of this detail drive
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the agent code of this detail drive.
	 *
	 * @param agentCode the agent code of this detail drive
	 */
	@Override
	public void setAgentCode(String agentCode) {
		model.setAgentCode(agentCode);
	}

	/**
	 * Sets the birth place of this detail drive.
	 *
	 * @param birthPlace the birth place of this detail drive
	 */
	@Override
	public void setBirthPlace(String birthPlace) {
		model.setBirthPlace(birthPlace);
	}

	/**
	 * Sets the bussines model of this detail drive.
	 *
	 * @param bussinesModel the bussines model of this detail drive
	 */
	@Override
	public void setBussinesModel(String bussinesModel) {
		model.setBussinesModel(bussinesModel);
	}

	/**
	 * Sets the cc of this detail drive.
	 *
	 * @param cc the cc of this detail drive
	 */
	@Override
	public void setCc(int cc) {
		model.setCc(cc);
	}

	/**
	 * Sets the channel of this detail drive.
	 *
	 * @param channel the channel of this detail drive
	 */
	@Override
	public void setChannel(String channel) {
		model.setChannel(channel);
	}

	/**
	 * Sets the chassis number of this detail drive.
	 *
	 * @param chassisNumber the chassis number of this detail drive
	 */
	@Override
	public void setChassisNumber(String chassisNumber) {
		model.setChassisNumber(chassisNumber);
	}

	/**
	 * Sets the city of this detail drive.
	 *
	 * @param city the city of this detail drive
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the click ID of this detail drive.
	 *
	 * @param clickId the click ID of this detail drive
	 */
	@Override
	public void setClickId(String clickId) {
		model.setClickId(clickId);
	}

	/**
	 * Sets the commercial offers of this detail drive.
	 *
	 * @param commercialOffers the commercial offers of this detail drive
	 */
	@Override
	public void setCommercialOffers(int commercialOffers) {
		model.setCommercialOffers(commercialOffers);
	}

	/**
	 * Sets the commission of this detail drive.
	 *
	 * @param commission the commission of this detail drive
	 */
	@Override
	public void setCommission(String commission) {
		model.setCommission(commission);
	}

	/**
	 * Sets the company ID of this detail drive.
	 *
	 * @param companyId the company ID of this detail drive
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the coverage type of this detail drive.
	 *
	 * @param coverageType the coverage type of this detail drive
	 */
	@Override
	public void setCoverageType(String coverageType) {
		model.setCoverageType(coverageType);
	}

	/**
	 * Sets the create date of this detail drive.
	 *
	 * @param createDate the create date of this detail drive
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this detail drive.
	 *
	 * @param currency the currency of this detail drive
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the daily report agent file of this detail drive.
	 *
	 * @param dailyReportAgentFile the daily report agent file of this detail drive
	 */
	@Override
	public void setDailyReportAgentFile(long dailyReportAgentFile) {
		model.setDailyReportAgentFile(dailyReportAgentFile);
	}

	/**
	 * Sets the daily report agent status of this detail drive.
	 *
	 * @param dailyReportAgentStatus the daily report agent status of this detail drive
	 */
	@Override
	public void setDailyReportAgentStatus(int dailyReportAgentStatus) {
		model.setDailyReportAgentStatus(dailyReportAgentStatus);
	}

	/**
	 * Sets the daily report file of this detail drive.
	 *
	 * @param dailyReportFile the daily report file of this detail drive
	 */
	@Override
	public void setDailyReportFile(long dailyReportFile) {
		model.setDailyReportFile(dailyReportFile);
	}

	/**
	 * Sets the daily report status of this detail drive.
	 *
	 * @param dailyReportStatus the daily report status of this detail drive
	 */
	@Override
	public void setDailyReportStatus(int dailyReportStatus) {
		model.setDailyReportStatus(dailyReportStatus);
	}

	/**
	 * Sets the detail drive ID of this detail drive.
	 *
	 * @param detailDriveId the detail drive ID of this detail drive
	 */
	@Override
	public void setDetailDriveId(long detailDriveId) {
		model.setDetailDriveId(detailDriveId);
	}

	/**
	 * Sets the discount of this detail drive.
	 *
	 * @param discount the discount of this detail drive
	 */
	@Override
	public void setDiscount(int discount) {
		model.setDiscount(discount);
	}

	/**
	 * Sets the dob of this detail drive.
	 *
	 * @param dob the dob of this detail drive
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the dpg of this detail drive.
	 *
	 * @param dpg the dpg of this detail drive
	 */
	@Override
	public void setDpg(String dpg) {
		model.setDpg(dpg);
	}

	/**
	 * Sets the email of this detail drive.
	 *
	 * @param email the email of this detail drive
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the engine number of this detail drive.
	 *
	 * @param engineNumber the engine number of this detail drive
	 */
	@Override
	public void setEngineNumber(String engineNumber) {
		model.setEngineNumber(engineNumber);
	}

	/**
	 * Sets the expired date of this detail drive.
	 *
	 * @param expiredDate the expired date of this detail drive
	 */
	@Override
	public void setExpiredDate(Date expiredDate) {
		model.setExpiredDate(expiredDate);
	}

	/**
	 * Sets the group ID of this detail drive.
	 *
	 * @param groupId the group ID of this detail drive
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this detail drive.
	 *
	 * @param idNumber the id number of this detail drive
	 */
	@Override
	public void setIdNumber(String idNumber) {
		model.setIdNumber(idNumber);
	}

	/**
	 * Sets the kitas number of this detail drive.
	 *
	 * @param kitasNumber the kitas number of this detail drive
	 */
	@Override
	public void setKitasNumber(String kitasNumber) {
		model.setKitasNumber(kitasNumber);
	}

	/**
	 * Sets the leads of this detail drive.
	 *
	 * @param leads the leads of this detail drive
	 */
	@Override
	public void setLeads(long leads) {
		model.setLeads(leads);
	}

	/**
	 * Sets the leads ID of this detail drive.
	 *
	 * @param leadsId the leads ID of this detail drive
	 */
	@Override
	public void setLeadsId(long leadsId) {
		model.setLeadsId(leadsId);
	}

	/**
	 * Sets the make of this detail drive.
	 *
	 * @param make the make of this detail drive
	 */
	@Override
	public void setMake(String make) {
		model.setMake(make);
	}

	/**
	 * Sets the managed by of this detail drive.
	 *
	 * @param managedBy the managed by of this detail drive
	 */
	@Override
	public void setManagedBy(long managedBy) {
		model.setManagedBy(managedBy);
	}

	/**
	 * Sets the manufacture age of this detail drive.
	 *
	 * @param manufactureAge the manufacture age of this detail drive
	 */
	@Override
	public void setManufactureAge(int manufactureAge) {
		model.setManufactureAge(manufactureAge);
	}

	/**
	 * Sets the manufacture year of this detail drive.
	 *
	 * @param manufactureYear the manufacture year of this detail drive
	 */
	@Override
	public void setManufactureYear(int manufactureYear) {
		model.setManufactureYear(manufactureYear);
	}

	/**
	 * Sets the marketing code of this detail drive.
	 *
	 * @param marketingCode the marketing code of this detail drive
	 */
	@Override
	public void setMarketingCode(String marketingCode) {
		model.setMarketingCode(marketingCode);
	}

	/**
	 * Sets the mobile phone of this detail drive.
	 *
	 * @param mobilePhone the mobile phone of this detail drive
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this detail drive.
	 *
	 * @param modifiedDate the modified date of this detail drive
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this detail drive.
	 *
	 * @param name the name of this detail drive
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the nationality of this detail drive.
	 *
	 * @param nationality the nationality of this detail drive
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the net premium of this detail drive.
	 *
	 * @param netPremium the net premium of this detail drive
	 */
	@Override
	public void setNetPremium(double netPremium) {
		model.setNetPremium(netPremium);
	}

	/**
	 * Sets the passport number of this detail drive.
	 *
	 * @param passportNumber the passport number of this detail drive
	 */
	@Override
	public void setPassportNumber(String passportNumber) {
		model.setPassportNumber(passportNumber);
	}

	/**
	 * Sets the police number of this detail drive.
	 *
	 * @param policeNumber the police number of this detail drive
	 */
	@Override
	public void setPoliceNumber(String policeNumber) {
		model.setPoliceNumber(policeNumber);
	}

	/**
	 * Sets the policy cost of this detail drive.
	 *
	 * @param policyCost the policy cost of this detail drive
	 */
	@Override
	public void setPolicyCost(double policyCost) {
		model.setPolicyCost(policyCost);
	}

	/**
	 * Sets the policy number of this detail drive.
	 *
	 * @param policyNumber the policy number of this detail drive
	 */
	@Override
	public void setPolicyNumber(String policyNumber) {
		model.setPolicyNumber(policyNumber);
	}

	/**
	 * Sets the policy status of this detail drive.
	 *
	 * @param policyStatus the policy status of this detail drive
	 */
	@Override
	public void setPolicyStatus(String policyStatus) {
		model.setPolicyStatus(policyStatus);
	}

	/**
	 * Sets the premium of this detail drive.
	 *
	 * @param premium the premium of this detail drive
	 */
	@Override
	public void setPremium(double premium) {
		model.setPremium(premium);
	}

	/**
	 * Sets the primary key of this detail drive.
	 *
	 * @param primaryKey the primary key of this detail drive
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promo code of this detail drive.
	 *
	 * @param promoCode the promo code of this detail drive
	 */
	@Override
	public void setPromoCode(String promoCode) {
		model.setPromoCode(promoCode);
	}

	/**
	 * Sets the province of this detail drive.
	 *
	 * @param province the province of this detail drive
	 */
	@Override
	public void setProvince(String province) {
		model.setProvince(province);
	}

	/**
	 * Sets the reference number of this detail drive.
	 *
	 * @param referenceNumber the reference number of this detail drive
	 */
	@Override
	public void setReferenceNumber(String referenceNumber) {
		model.setReferenceNumber(referenceNumber);
	}

	/**
	 * Sets the region plate of this detail drive.
	 *
	 * @param regionPlate the region plate of this detail drive
	 */
	@Override
	public void setRegionPlate(String regionPlate) {
		model.setRegionPlate(regionPlate);
	}

	/**
	 * Sets the seat capacity of this detail drive.
	 *
	 * @param seatCapacity the seat capacity of this detail drive
	 */
	@Override
	public void setSeatCapacity(int seatCapacity) {
		model.setSeatCapacity(seatCapacity);
	}

	/**
	 * Sets the stamp duty of this detail drive.
	 *
	 * @param stampDuty the stamp duty of this detail drive
	 */
	@Override
	public void setStampDuty(double stampDuty) {
		model.setStampDuty(stampDuty);
	}

	/**
	 * Sets the start date of this detail drive.
	 *
	 * @param startDate the start date of this detail drive
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the step1 of this detail drive.
	 *
	 * @param step1 the step1 of this detail drive
	 */
	@Override
	public void setStep1(int step1) {
		model.setStep1(step1);
	}

	/**
	 * Sets the step2 of this detail drive.
	 *
	 * @param step2 the step2 of this detail drive
	 */
	@Override
	public void setStep2(int step2) {
		model.setStep2(step2);
	}

	/**
	 * Sets the step3 of this detail drive.
	 *
	 * @param step3 the step3 of this detail drive
	 */
	@Override
	public void setStep3(int step3) {
		model.setStep3(step3);
	}

	/**
	 * Sets the sub agent of this detail drive.
	 *
	 * @param subAgent the sub agent of this detail drive
	 */
	@Override
	public void setSubAgent(long subAgent) {
		model.setSubAgent(subAgent);
	}

	/**
	 * Sets the sum insured of this detail drive.
	 *
	 * @param sumInsured the sum insured of this detail drive
	 */
	@Override
	public void setSumInsured(double sumInsured) {
		model.setSumInsured(sumInsured);
	}

	/**
	 * Sets the transaction ID of this detail drive.
	 *
	 * @param transactionId the transaction ID of this detail drive
	 */
	@Override
	public void setTransactionId(String transactionId) {
		model.setTransactionId(transactionId);
	}

	/**
	 * Sets the type of use of this detail drive.
	 *
	 * @param typeOfUse the type of use of this detail drive
	 */
	@Override
	public void setTypeOfUse(String typeOfUse) {
		model.setTypeOfUse(typeOfUse);
	}

	/**
	 * Sets the user ID of this detail drive.
	 *
	 * @param userId the user ID of this detail drive
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail drive.
	 *
	 * @param userName the user name of this detail drive
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail drive.
	 *
	 * @param userUuid the user uuid of this detail drive
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm campaign of this detail drive.
	 *
	 * @param utmCampaign the utm campaign of this detail drive
	 */
	@Override
	public void setUtmCampaign(String utmCampaign) {
		model.setUtmCampaign(utmCampaign);
	}

	/**
	 * Sets the utm content of this detail drive.
	 *
	 * @param utmContent the utm content of this detail drive
	 */
	@Override
	public void setUtmContent(String utmContent) {
		model.setUtmContent(utmContent);
	}

	/**
	 * Sets the utm medium of this detail drive.
	 *
	 * @param utmMedium the utm medium of this detail drive
	 */
	@Override
	public void setUtmMedium(String utmMedium) {
		model.setUtmMedium(utmMedium);
	}

	/**
	 * Sets the utm source of this detail drive.
	 *
	 * @param utmSource the utm source of this detail drive
	 */
	@Override
	public void setUtmSource(String utmSource) {
		model.setUtmSource(utmSource);
	}

	/**
	 * Sets the utm term of this detail drive.
	 *
	 * @param utmTerm the utm term of this detail drive
	 */
	@Override
	public void setUtmTerm(String utmTerm) {
		model.setUtmTerm(utmTerm);
	}

	/**
	 * Sets the vehicle body of this detail drive.
	 *
	 * @param vehicleBody the vehicle body of this detail drive
	 */
	@Override
	public void setVehicleBody(String vehicleBody) {
		model.setVehicleBody(vehicleBody);
	}

	/**
	 * Sets the vehicle code of this detail drive.
	 *
	 * @param vehicleCode the vehicle code of this detail drive
	 */
	@Override
	public void setVehicleCode(String vehicleCode) {
		model.setVehicleCode(vehicleCode);
	}

	/**
	 * Sets the vehicle insured of this detail drive.
	 *
	 * @param vehicleInsured the vehicle insured of this detail drive
	 */
	@Override
	public void setVehicleInsured(double vehicleInsured) {
		model.setVehicleInsured(vehicleInsured);
	}

	/**
	 * Sets the vehicle manufacture of this detail drive.
	 *
	 * @param VehicleManufacture the vehicle manufacture of this detail drive
	 */
	@Override
	public void setVehicleManufacture(String VehicleManufacture) {
		model.setVehicleManufacture(VehicleManufacture);
	}

	/**
	 * Sets the vehicle model of this detail drive.
	 *
	 * @param vehicleModel the vehicle model of this detail drive
	 */
	@Override
	public void setVehicleModel(String vehicleModel) {
		model.setVehicleModel(vehicleModel);
	}

	/**
	 * Sets the vehicle sub model of this detail drive.
	 *
	 * @param vehicleSubModel the vehicle sub model of this detail drive
	 */
	@Override
	public void setVehicleSubModel(String vehicleSubModel) {
		model.setVehicleSubModel(vehicleSubModel);
	}

	/**
	 * Sets the vehicle type of this detail drive.
	 *
	 * @param vehicleType the vehicle type of this detail drive
	 */
	@Override
	public void setVehicleType(String vehicleType) {
		model.setVehicleType(vehicleType);
	}

	@Override
	protected DetailDriveWrapper wrap(DetailDrive detailDrive) {
		return new DetailDriveWrapper(detailDrive);
	}

}