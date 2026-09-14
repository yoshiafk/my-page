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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.DetailTlpServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DetailTlpSoap implements Serializable {

	public static DetailTlpSoap toSoapModel(DetailTlp model) {
		DetailTlpSoap soapModel = new DetailTlpSoap();

		soapModel.setDetailTlpId(model.getDetailTlpId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setMainPolicyStartDate(model.getMainPolicyStartDate());
		soapModel.setMainPolicyEndDate(model.getMainPolicyEndDate());
		soapModel.setNumberOfDays(model.getNumberOfDays());
		soapModel.setName(model.getName());
		soapModel.setBirthPlace(model.getBirthPlace());
		soapModel.setDob(model.getDob());
		soapModel.setNationality(model.getNationality());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setPassportNumber(model.getPassportNumber());
		soapModel.setKitasNumber(model.getKitasNumber());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddress(model.getAddress());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setProvince(model.getProvince());
		soapModel.setCity(model.getCity());
		soapModel.setPostCode(model.getPostCode());
		soapModel.setCommercialOffer(model.getCommercialOffer());
		soapModel.setDriveModel(model.getDriveModel());
		soapModel.setVehicleManufacture(model.getVehicleManufacture());
		soapModel.setVehicleModel(model.getVehicleModel());
		soapModel.setVehicleSubModel(model.getVehicleSubModel());
		soapModel.setManufactureYear(model.getManufactureYear());
		soapModel.setVehicleInsured(model.getVehicleInsured());
		soapModel.setRegionPlate(model.getRegionPlate());
		soapModel.setPoliceNumber(model.getPoliceNumber());
		soapModel.setChassisNumber(model.getChassisNumber());
		soapModel.setEngineNumber(model.getEngineNumber());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setTransactionId_(model.getTransactionId_());
		soapModel.setBusinessModel(model.getBusinessModel());
		soapModel.setChannel(model.getChannel());
		soapModel.setPromoCode(model.getPromoCode());
		soapModel.setStep1(model.getStep1());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setReferenceNumber(model.getReferenceNumber());
		soapModel.setPolicyStatus(model.getPolicyStatus());
		soapModel.setPackageName(model.getPackageName());
		soapModel.setPackageInfo(model.getPackageInfo());
		soapModel.setRate(model.getRate());
		soapModel.setCurrency_(model.getCurrency_());
		soapModel.setSumInsured(model.getSumInsured());
		soapModel.setPolicyCost(model.getPolicyCost());
		soapModel.setStampDuty(model.getStampDuty());
		soapModel.setPremium(model.getPremium());
		soapModel.setNetPremium(model.getNetPremium());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setCommision(model.getCommision());
		soapModel.setInsuranceName(model.getInsuranceName());
		soapModel.setInsurancePolicyNo(model.getInsurancePolicyNo());
		soapModel.setManagedBy(model.getManagedBy());
		soapModel.setAgentCode(model.getAgentCode());
		soapModel.setSubAgent(model.getSubAgent());
		soapModel.setMarketingCode(model.getMarketingCode());
		soapModel.setUtmSource(model.getUtmSource());
		soapModel.setUtmMedium(model.getUtmMedium());
		soapModel.setUtmCampaign(model.getUtmCampaign());
		soapModel.setUtmTerm(model.getUtmTerm());
		soapModel.setUtmContent(model.getUtmContent());
		soapModel.setClickId(model.getClickId());

		return soapModel;
	}

	public static DetailTlpSoap[] toSoapModels(DetailTlp[] models) {
		DetailTlpSoap[] soapModels = new DetailTlpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DetailTlpSoap[][] toSoapModels(DetailTlp[][] models) {
		DetailTlpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DetailTlpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DetailTlpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DetailTlpSoap[] toSoapModels(List<DetailTlp> models) {
		List<DetailTlpSoap> soapModels = new ArrayList<DetailTlpSoap>(
			models.size());

		for (DetailTlp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DetailTlpSoap[soapModels.size()]);
	}

	public DetailTlpSoap() {
	}

	public long getPrimaryKey() {
		return _detailTlpId;
	}

	public void setPrimaryKey(long pk) {
		setDetailTlpId(pk);
	}

	public long getDetailTlpId() {
		return _detailTlpId;
	}

	public void setDetailTlpId(long detailTlpId) {
		_detailTlpId = detailTlpId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public Date getMainPolicyStartDate() {
		return _mainPolicyStartDate;
	}

	public void setMainPolicyStartDate(Date mainPolicyStartDate) {
		_mainPolicyStartDate = mainPolicyStartDate;
	}

	public Date getMainPolicyEndDate() {
		return _mainPolicyEndDate;
	}

	public void setMainPolicyEndDate(Date mainPolicyEndDate) {
		_mainPolicyEndDate = mainPolicyEndDate;
	}

	public int getNumberOfDays() {
		return _numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		_numberOfDays = numberOfDays;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getBirthPlace() {
		return _birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		_birthPlace = birthPlace;
	}

	public Date getDob() {
		return _dob;
	}

	public void setDob(Date dob) {
		_dob = dob;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getIdNumber() {
		return _idNumber;
	}

	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;
	}

	public String getPassportNumber() {
		return _passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		_passportNumber = passportNumber;
	}

	public String getKitasNumber() {
		return _kitasNumber;
	}

	public void setKitasNumber(String kitasNumber) {
		_kitasNumber = kitasNumber;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getProvince() {
		return _province;
	}

	public void setProvince(String province) {
		_province = province;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getPostCode() {
		return _postCode;
	}

	public void setPostCode(String postCode) {
		_postCode = postCode;
	}

	public int getCommercialOffer() {
		return _commercialOffer;
	}

	public void setCommercialOffer(int commercialOffer) {
		_commercialOffer = commercialOffer;
	}

	public long getDriveModel() {
		return _driveModel;
	}

	public void setDriveModel(long driveModel) {
		_driveModel = driveModel;
	}

	public String getVehicleManufacture() {
		return _vehicleManufacture;
	}

	public void setVehicleManufacture(String vehicleManufacture) {
		_vehicleManufacture = vehicleManufacture;
	}

	public String getVehicleModel() {
		return _vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		_vehicleModel = vehicleModel;
	}

	public String getVehicleSubModel() {
		return _vehicleSubModel;
	}

	public void setVehicleSubModel(String vehicleSubModel) {
		_vehicleSubModel = vehicleSubModel;
	}

	public int getManufactureYear() {
		return _manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		_manufactureYear = manufactureYear;
	}

	public double getVehicleInsured() {
		return _vehicleInsured;
	}

	public void setVehicleInsured(double vehicleInsured) {
		_vehicleInsured = vehicleInsured;
	}

	public String getRegionPlate() {
		return _regionPlate;
	}

	public void setRegionPlate(String regionPlate) {
		_regionPlate = regionPlate;
	}

	public String getPoliceNumber() {
		return _policeNumber;
	}

	public void setPoliceNumber(String policeNumber) {
		_policeNumber = policeNumber;
	}

	public String getChassisNumber() {
		return _chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		_chassisNumber = chassisNumber;
	}

	public String getEngineNumber() {
		return _engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		_engineNumber = engineNumber;
	}

	public long getLeadsId() {
		return _leadsId;
	}

	public void setLeadsId(long leadsId) {
		_leadsId = leadsId;
	}

	public long getTransactionId_() {
		return _transactionId_;
	}

	public void setTransactionId_(long transactionId_) {
		_transactionId_ = transactionId_;
	}

	public String getBusinessModel() {
		return _businessModel;
	}

	public void setBusinessModel(String businessModel) {
		_businessModel = businessModel;
	}

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
	}

	public String getPromoCode() {
		return _promoCode;
	}

	public void setPromoCode(String promoCode) {
		_promoCode = promoCode;
	}

	public int getStep1() {
		return _step1;
	}

	public void setStep1(int step1) {
		_step1 = step1;
	}

	public String getPolicyNumber() {
		return _policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		_policyNumber = policyNumber;
	}

	public String getReferenceNumber() {
		return _referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		_referenceNumber = referenceNumber;
	}

	public String getPolicyStatus() {
		return _policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		_policyStatus = policyStatus;
	}

	public String getPackageName() {
		return _packageName;
	}

	public void setPackageName(String packageName) {
		_packageName = packageName;
	}

	public long getPackageInfo() {
		return _packageInfo;
	}

	public void setPackageInfo(long packageInfo) {
		_packageInfo = packageInfo;
	}

	public double getRate() {
		return _rate;
	}

	public void setRate(double rate) {
		_rate = rate;
	}

	public String getCurrency_() {
		return _currency_;
	}

	public void setCurrency_(String currency_) {
		_currency_ = currency_;
	}

	public double getSumInsured() {
		return _sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		_sumInsured = sumInsured;
	}

	public double getPolicyCost() {
		return _policyCost;
	}

	public void setPolicyCost(double policyCost) {
		_policyCost = policyCost;
	}

	public double getStampDuty() {
		return _stampDuty;
	}

	public void setStampDuty(double stampDuty) {
		_stampDuty = stampDuty;
	}

	public double getPremium() {
		return _premium;
	}

	public void setPremium(double premium) {
		_premium = premium;
	}

	public double getNetPremium() {
		return _netPremium;
	}

	public void setNetPremium(double netPremium) {
		_netPremium = netPremium;
	}

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
	}

	public double getCommision() {
		return _commision;
	}

	public void setCommision(double commision) {
		_commision = commision;
	}

	public String getInsuranceName() {
		return _insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		_insuranceName = insuranceName;
	}

	public String getInsurancePolicyNo() {
		return _insurancePolicyNo;
	}

	public void setInsurancePolicyNo(String insurancePolicyNo) {
		_insurancePolicyNo = insurancePolicyNo;
	}

	public long getManagedBy() {
		return _managedBy;
	}

	public void setManagedBy(long managedBy) {
		_managedBy = managedBy;
	}

	public String getAgentCode() {
		return _agentCode;
	}

	public void setAgentCode(String agentCode) {
		_agentCode = agentCode;
	}

	public long getSubAgent() {
		return _subAgent;
	}

	public void setSubAgent(long subAgent) {
		_subAgent = subAgent;
	}

	public String getMarketingCode() {
		return _marketingCode;
	}

	public void setMarketingCode(String marketingCode) {
		_marketingCode = marketingCode;
	}

	public String getUtmSource() {
		return _utmSource;
	}

	public void setUtmSource(String utmSource) {
		_utmSource = utmSource;
	}

	public String getUtmMedium() {
		return _utmMedium;
	}

	public void setUtmMedium(String utmMedium) {
		_utmMedium = utmMedium;
	}

	public String getUtmCampaign() {
		return _utmCampaign;
	}

	public void setUtmCampaign(String utmCampaign) {
		_utmCampaign = utmCampaign;
	}

	public String getUtmTerm() {
		return _utmTerm;
	}

	public void setUtmTerm(String utmTerm) {
		_utmTerm = utmTerm;
	}

	public String getUtmContent() {
		return _utmContent;
	}

	public void setUtmContent(String utmContent) {
		_utmContent = utmContent;
	}

	public String getClickId() {
		return _clickId;
	}

	public void setClickId(String clickId) {
		_clickId = clickId;
	}

	private long _detailTlpId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _startDate;
	private Date _expiredDate;
	private Date _mainPolicyStartDate;
	private Date _mainPolicyEndDate;
	private int _numberOfDays;
	private String _name;
	private String _birthPlace;
	private Date _dob;
	private String _nationality;
	private String _idNumber;
	private String _passportNumber;
	private String _kitasNumber;
	private String _mobilePhone;
	private String _email;
	private String _address;
	private String _address2;
	private String _province;
	private String _city;
	private String _postCode;
	private int _commercialOffer;
	private long _driveModel;
	private String _vehicleManufacture;
	private String _vehicleModel;
	private String _vehicleSubModel;
	private int _manufactureYear;
	private double _vehicleInsured;
	private String _regionPlate;
	private String _policeNumber;
	private String _chassisNumber;
	private String _engineNumber;
	private long _leadsId;
	private long _transactionId_;
	private String _businessModel;
	private String _channel;
	private String _promoCode;
	private int _step1;
	private String _policyNumber;
	private String _referenceNumber;
	private String _policyStatus;
	private String _packageName;
	private long _packageInfo;
	private double _rate;
	private String _currency_;
	private double _sumInsured;
	private double _policyCost;
	private double _stampDuty;
	private double _premium;
	private double _netPremium;
	private double _discount;
	private double _commision;
	private String _insuranceName;
	private String _insurancePolicyNo;
	private long _managedBy;
	private String _agentCode;
	private long _subAgent;
	private String _marketingCode;
	private String _utmSource;
	private String _utmMedium;
	private String _utmCampaign;
	private String _utmTerm;
	private String _utmContent;
	private String _clickId;

}