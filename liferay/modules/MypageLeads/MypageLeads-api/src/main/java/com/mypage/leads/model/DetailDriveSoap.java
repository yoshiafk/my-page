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
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.DetailDriveServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DetailDriveSoap implements Serializable {

	public static DetailDriveSoap toSoapModel(DetailDrive model) {
		DetailDriveSoap soapModel = new DetailDriveSoap();

		soapModel.setDetailDriveId(model.getDetailDriveId());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVehicleCode(model.getVehicleCode());
		soapModel.setVehicleManufacture(model.getVehicleManufacture());
		soapModel.setVehicleModel(model.getVehicleModel());
		soapModel.setVehicleSubModel(model.getVehicleSubModel());
		soapModel.setVehicleBody(model.getVehicleBody());
		soapModel.setManufactureYear(model.getManufactureYear());
		soapModel.setManufactureAge(model.getManufactureAge());
		soapModel.setCoverageType(model.getCoverageType());
		soapModel.setVehicleType(model.getVehicleType());
		soapModel.setTypeOfUse(model.getTypeOfUse());
		soapModel.setVehicleInsured(model.getVehicleInsured());
		soapModel.setAccessoriesInsured(model.getAccessoriesInsured());
		soapModel.setSumInsured(model.getSumInsured());
		soapModel.setRegionPlate(model.getRegionPlate());
		soapModel.setCc(model.getCc());
		soapModel.setMake(model.getMake());
		soapModel.setDpg(model.getDpg());
		soapModel.setSeatCapacity(model.getSeatCapacity());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setCommercialOffers(model.getCommercialOffers());
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
		soapModel.setPoliceNumber(model.getPoliceNumber());
		soapModel.setChassisNumber(model.getChassisNumber());
		soapModel.setEngineNumber(model.getEngineNumber());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setReferenceNumber(model.getReferenceNumber());
		soapModel.setPolicyStatus(model.getPolicyStatus());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setPolicyCost(model.getPolicyCost());
		soapModel.setStampDuty(model.getStampDuty());
		soapModel.setPremium(model.getPremium());
		soapModel.setNetPremium(model.getNetPremium());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setCommission(model.getCommission());
		soapModel.setLeads(model.getLeads());
		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setBussinesModel(model.getBussinesModel());
		soapModel.setChannel(model.getChannel());
		soapModel.setPromoCode(model.getPromoCode());
		soapModel.setStep1(model.getStep1());
		soapModel.setStep2(model.getStep2());
		soapModel.setStep3(model.getStep3());
		soapModel.setDailyReportStatus(model.getDailyReportStatus());
		soapModel.setDailyReportFile(model.getDailyReportFile());
		soapModel.setDailyReportAgentStatus(model.getDailyReportAgentStatus());
		soapModel.setDailyReportAgentFile(model.getDailyReportAgentFile());
		soapModel.setUtmSource(model.getUtmSource());
		soapModel.setUtmMedium(model.getUtmMedium());
		soapModel.setUtmCampaign(model.getUtmCampaign());
		soapModel.setUtmTerm(model.getUtmTerm());
		soapModel.setUtmContent(model.getUtmContent());
		soapModel.setClickId(model.getClickId());
		soapModel.setManagedBy(model.getManagedBy());
		soapModel.setAgentCode(model.getAgentCode());
		soapModel.setSubAgent(model.getSubAgent());
		soapModel.setMarketingCode(model.getMarketingCode());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static DetailDriveSoap[] toSoapModels(DetailDrive[] models) {
		DetailDriveSoap[] soapModels = new DetailDriveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DetailDriveSoap[][] toSoapModels(DetailDrive[][] models) {
		DetailDriveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DetailDriveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DetailDriveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DetailDriveSoap[] toSoapModels(List<DetailDrive> models) {
		List<DetailDriveSoap> soapModels = new ArrayList<DetailDriveSoap>(
			models.size());

		for (DetailDrive model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DetailDriveSoap[soapModels.size()]);
	}

	public DetailDriveSoap() {
	}

	public long getPrimaryKey() {
		return _detailDriveId;
	}

	public void setPrimaryKey(long pk) {
		setDetailDriveId(pk);
	}

	public long getDetailDriveId() {
		return _detailDriveId;
	}

	public void setDetailDriveId(long detailDriveId) {
		_detailDriveId = detailDriveId;
	}

	public long getLeadsId() {
		return _leadsId;
	}

	public void setLeadsId(long leadsId) {
		_leadsId = leadsId;
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

	public String getVehicleCode() {
		return _vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		_vehicleCode = vehicleCode;
	}

	public String getVehicleManufacture() {
		return _VehicleManufacture;
	}

	public void setVehicleManufacture(String VehicleManufacture) {
		_VehicleManufacture = VehicleManufacture;
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

	public String getVehicleBody() {
		return _vehicleBody;
	}

	public void setVehicleBody(String vehicleBody) {
		_vehicleBody = vehicleBody;
	}

	public int getManufactureYear() {
		return _manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		_manufactureYear = manufactureYear;
	}

	public int getManufactureAge() {
		return _manufactureAge;
	}

	public void setManufactureAge(int manufactureAge) {
		_manufactureAge = manufactureAge;
	}

	public String getCoverageType() {
		return _coverageType;
	}

	public void setCoverageType(String coverageType) {
		_coverageType = coverageType;
	}

	public String getVehicleType() {
		return _vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		_vehicleType = vehicleType;
	}

	public String getTypeOfUse() {
		return _typeOfUse;
	}

	public void setTypeOfUse(String typeOfUse) {
		_typeOfUse = typeOfUse;
	}

	public double getVehicleInsured() {
		return _vehicleInsured;
	}

	public void setVehicleInsured(double vehicleInsured) {
		_vehicleInsured = vehicleInsured;
	}

	public double getAccessoriesInsured() {
		return _accessoriesInsured;
	}

	public void setAccessoriesInsured(double accessoriesInsured) {
		_accessoriesInsured = accessoriesInsured;
	}

	public double getSumInsured() {
		return _sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		_sumInsured = sumInsured;
	}

	public String getRegionPlate() {
		return _regionPlate;
	}

	public void setRegionPlate(String regionPlate) {
		_regionPlate = regionPlate;
	}

	public int getCc() {
		return _cc;
	}

	public void setCc(int cc) {
		_cc = cc;
	}

	public String getMake() {
		return _make;
	}

	public void setMake(String make) {
		_make = make;
	}

	public String getDpg() {
		return _dpg;
	}

	public void setDpg(String dpg) {
		_dpg = dpg;
	}

	public int getSeatCapacity() {
		return _seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		_seatCapacity = seatCapacity;
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

	public int getCommercialOffers() {
		return _commercialOffers;
	}

	public void setCommercialOffers(int commercialOffers) {
		_commercialOffers = commercialOffers;
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

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
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

	public int getDiscount() {
		return _discount;
	}

	public void setDiscount(int discount) {
		_discount = discount;
	}

	public String getCommission() {
		return _commission;
	}

	public void setCommission(String commission) {
		_commission = commission;
	}

	public long getLeads() {
		return _leads;
	}

	public void setLeads(long leads) {
		_leads = leads;
	}

	public String getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(String transactionId) {
		_transactionId = transactionId;
	}

	public String getBussinesModel() {
		return _bussinesModel;
	}

	public void setBussinesModel(String bussinesModel) {
		_bussinesModel = bussinesModel;
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

	public int getStep2() {
		return _step2;
	}

	public void setStep2(int step2) {
		_step2 = step2;
	}

	public int getStep3() {
		return _step3;
	}

	public void setStep3(int step3) {
		_step3 = step3;
	}

	public int getDailyReportStatus() {
		return _dailyReportStatus;
	}

	public void setDailyReportStatus(int dailyReportStatus) {
		_dailyReportStatus = dailyReportStatus;
	}

	public long getDailyReportFile() {
		return _dailyReportFile;
	}

	public void setDailyReportFile(long dailyReportFile) {
		_dailyReportFile = dailyReportFile;
	}

	public int getDailyReportAgentStatus() {
		return _dailyReportAgentStatus;
	}

	public void setDailyReportAgentStatus(int dailyReportAgentStatus) {
		_dailyReportAgentStatus = dailyReportAgentStatus;
	}

	public long getDailyReportAgentFile() {
		return _dailyReportAgentFile;
	}

	public void setDailyReportAgentFile(long dailyReportAgentFile) {
		_dailyReportAgentFile = dailyReportAgentFile;
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

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _detailDriveId;
	private long _leadsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _vehicleCode;
	private String _VehicleManufacture;
	private String _vehicleModel;
	private String _vehicleSubModel;
	private String _vehicleBody;
	private int _manufactureYear;
	private int _manufactureAge;
	private String _coverageType;
	private String _vehicleType;
	private String _typeOfUse;
	private double _vehicleInsured;
	private double _accessoriesInsured;
	private double _sumInsured;
	private String _regionPlate;
	private int _cc;
	private String _make;
	private String _dpg;
	private int _seatCapacity;
	private Date _startDate;
	private Date _expiredDate;
	private int _commercialOffers;
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
	private String _policeNumber;
	private String _chassisNumber;
	private String _engineNumber;
	private String _policyNumber;
	private String _referenceNumber;
	private String _policyStatus;
	private String _currency;
	private double _policyCost;
	private double _stampDuty;
	private double _premium;
	private double _netPremium;
	private int _discount;
	private String _commission;
	private long _leads;
	private String _transactionId;
	private String _bussinesModel;
	private String _channel;
	private String _promoCode;
	private int _step1;
	private int _step2;
	private int _step3;
	private int _dailyReportStatus;
	private long _dailyReportFile;
	private int _dailyReportAgentStatus;
	private long _dailyReportAgentFile;
	private String _utmSource;
	private String _utmMedium;
	private String _utmCampaign;
	private String _utmTerm;
	private String _utmContent;
	private String _clickId;
	private long _managedBy;
	private String _agentCode;
	private long _subAgent;
	private String _marketingCode;
	private int _active;

}