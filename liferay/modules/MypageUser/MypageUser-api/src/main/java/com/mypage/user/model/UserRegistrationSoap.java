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

package com.mypage.user.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.UserRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserRegistrationSoap implements Serializable {

	public static UserRegistrationSoap toSoapModel(UserRegistration model) {
		UserRegistrationSoap soapModel = new UserRegistrationSoap();

		soapModel.setUserRegistrationId(model.getUserRegistrationId());
		soapModel.setName(model.getName());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setLicenseNumber(model.getLicenseNumber());
		soapModel.setAddress(model.getAddress());
		soapModel.setPostalAddress(model.getPostalAddress());
		soapModel.setProvince(model.getProvince());
		soapModel.setCity(model.getCity());
		soapModel.setZip(model.getZip());
		soapModel.setPhone(model.getPhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthPlace(model.getBirthPlace());
		soapModel.setDob(model.getDob());
		soapModel.setGender(model.getGender());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setResidenceStatus(model.getResidenceStatus());
		soapModel.setStayPeriod(model.getStayPeriod());
		soapModel.setKnowAXAFrom(model.getKnowAXAFrom());
		soapModel.setKnowAXAFromOther(model.getKnowAXAFromOther());
		soapModel.setJoinReason(model.getJoinReason());
		soapModel.setBankName(model.getBankName());
		soapModel.setBankAccountName(model.getBankAccountName());
		soapModel.setBankAccountNo(model.getBankAccountNo());
		soapModel.setNpwp(model.getNpwp());
		soapModel.setNpwpName(model.getNpwpName());
		soapModel.setPortfolioFire(model.getPortfolioFire());
		soapModel.setPortfolioMotor(model.getPortfolioMotor());
		soapModel.setPortfolioMarine(model.getPortfolioMarine());
		soapModel.setPortfolioHealth(model.getPortfolioHealth());
		soapModel.setPortfolioOther(model.getPortfolioOther());
		soapModel.setTargetFire(model.getTargetFire());
		soapModel.setTargetMotor(model.getTargetMotor());
		soapModel.setTargetMarine(model.getTargetMarine());
		soapModel.setTargetHealth(model.getTargetHealth());
		soapModel.setTargetOther(model.getTargetOther());
		soapModel.setAnnualPremiIncome(model.getAnnualPremiIncome());
		soapModel.setTargetCase(model.getTargetCase());
		soapModel.setTargetPremi(model.getTargetPremi());
		soapModel.setProspectSource(model.getProspectSource());
		soapModel.setOtherInsuranceJob(model.getOtherInsuranceJob());
		soapModel.setTnc(model.getTnc());
		soapModel.setAgentAFI(model.getAgentAFI());
		soapModel.setSentToMAS(model.getSentToMAS());
		soapModel.setApproved(model.getApproved());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserRegistrationSoap[] toSoapModels(
		UserRegistration[] models) {

		UserRegistrationSoap[] soapModels =
			new UserRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationSoap[][] toSoapModels(
		UserRegistration[][] models) {

		UserRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationSoap[] toSoapModels(
		List<UserRegistration> models) {

		List<UserRegistrationSoap> soapModels =
			new ArrayList<UserRegistrationSoap>(models.size());

		for (UserRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserRegistrationSoap[soapModels.size()]);
	}

	public UserRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _userRegistrationId;
	}

	public void setPrimaryKey(long pk) {
		setUserRegistrationId(pk);
	}

	public long getUserRegistrationId() {
		return _userRegistrationId;
	}

	public void setUserRegistrationId(long userRegistrationId) {
		_userRegistrationId = userRegistrationId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getIdNumber() {
		return _idNumber;
	}

	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;
	}

	public String getLicenseNumber() {
		return _licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		_licenseNumber = licenseNumber;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPostalAddress() {
		return _postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		_postalAddress = postalAddress;
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

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
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

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public String getResidenceStatus() {
		return _residenceStatus;
	}

	public void setResidenceStatus(String residenceStatus) {
		_residenceStatus = residenceStatus;
	}

	public int getStayPeriod() {
		return _stayPeriod;
	}

	public void setStayPeriod(int stayPeriod) {
		_stayPeriod = stayPeriod;
	}

	public int getKnowAXAFrom() {
		return _knowAXAFrom;
	}

	public void setKnowAXAFrom(int knowAXAFrom) {
		_knowAXAFrom = knowAXAFrom;
	}

	public String getKnowAXAFromOther() {
		return _knowAXAFromOther;
	}

	public void setKnowAXAFromOther(String knowAXAFromOther) {
		_knowAXAFromOther = knowAXAFromOther;
	}

	public String getJoinReason() {
		return _joinReason;
	}

	public void setJoinReason(String joinReason) {
		_joinReason = joinReason;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getBankAccountName() {
		return _bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		_bankAccountName = bankAccountName;
	}

	public String getBankAccountNo() {
		return _bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		_bankAccountNo = bankAccountNo;
	}

	public String getNpwp() {
		return _npwp;
	}

	public void setNpwp(String npwp) {
		_npwp = npwp;
	}

	public String getNpwpName() {
		return _npwpName;
	}

	public void setNpwpName(String npwpName) {
		_npwpName = npwpName;
	}

	public int getPortfolioFire() {
		return _portfolioFire;
	}

	public void setPortfolioFire(int portfolioFire) {
		_portfolioFire = portfolioFire;
	}

	public int getPortfolioMotor() {
		return _portfolioMotor;
	}

	public void setPortfolioMotor(int portfolioMotor) {
		_portfolioMotor = portfolioMotor;
	}

	public int getPortfolioMarine() {
		return _portfolioMarine;
	}

	public void setPortfolioMarine(int portfolioMarine) {
		_portfolioMarine = portfolioMarine;
	}

	public int getPortfolioHealth() {
		return _portfolioHealth;
	}

	public void setPortfolioHealth(int portfolioHealth) {
		_portfolioHealth = portfolioHealth;
	}

	public int getPortfolioOther() {
		return _portfolioOther;
	}

	public void setPortfolioOther(int portfolioOther) {
		_portfolioOther = portfolioOther;
	}

	public int getTargetFire() {
		return _targetFire;
	}

	public void setTargetFire(int targetFire) {
		_targetFire = targetFire;
	}

	public int getTargetMotor() {
		return _targetMotor;
	}

	public void setTargetMotor(int targetMotor) {
		_targetMotor = targetMotor;
	}

	public int getTargetMarine() {
		return _targetMarine;
	}

	public void setTargetMarine(int targetMarine) {
		_targetMarine = targetMarine;
	}

	public int getTargetHealth() {
		return _targetHealth;
	}

	public void setTargetHealth(int targetHealth) {
		_targetHealth = targetHealth;
	}

	public int getTargetOther() {
		return _targetOther;
	}

	public void setTargetOther(int targetOther) {
		_targetOther = targetOther;
	}

	public long getAnnualPremiIncome() {
		return _annualPremiIncome;
	}

	public void setAnnualPremiIncome(long annualPremiIncome) {
		_annualPremiIncome = annualPremiIncome;
	}

	public int getTargetCase() {
		return _targetCase;
	}

	public void setTargetCase(int targetCase) {
		_targetCase = targetCase;
	}

	public long getTargetPremi() {
		return _targetPremi;
	}

	public void setTargetPremi(long targetPremi) {
		_targetPremi = targetPremi;
	}

	public String getProspectSource() {
		return _prospectSource;
	}

	public void setProspectSource(String prospectSource) {
		_prospectSource = prospectSource;
	}

	public int getOtherInsuranceJob() {
		return _otherInsuranceJob;
	}

	public void setOtherInsuranceJob(int otherInsuranceJob) {
		_otherInsuranceJob = otherInsuranceJob;
	}

	public int getTnc() {
		return _tnc;
	}

	public void setTnc(int tnc) {
		_tnc = tnc;
	}

	public int getAgentAFI() {
		return _agentAFI;
	}

	public void setAgentAFI(int agentAFI) {
		_agentAFI = agentAFI;
	}

	public int getSentToMAS() {
		return _sentToMAS;
	}

	public void setSentToMAS(int sentToMAS) {
		_sentToMAS = sentToMAS;
	}

	public int getApproved() {
		return _approved;
	}

	public void setApproved(int approved) {
		_approved = approved;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
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

	private long _userRegistrationId;
	private String _name;
	private String _idNumber;
	private String _licenseNumber;
	private String _address;
	private String _postalAddress;
	private String _province;
	private String _city;
	private String _zip;
	private String _phone;
	private String _mobilePhone;
	private String _email;
	private String _birthPlace;
	private Date _dob;
	private String _gender;
	private String _maritalStatus;
	private String _residenceStatus;
	private int _stayPeriod;
	private int _knowAXAFrom;
	private String _knowAXAFromOther;
	private String _joinReason;
	private String _bankName;
	private String _bankAccountName;
	private String _bankAccountNo;
	private String _npwp;
	private String _npwpName;
	private int _portfolioFire;
	private int _portfolioMotor;
	private int _portfolioMarine;
	private int _portfolioHealth;
	private int _portfolioOther;
	private int _targetFire;
	private int _targetMotor;
	private int _targetMarine;
	private int _targetHealth;
	private int _targetOther;
	private long _annualPremiIncome;
	private int _targetCase;
	private long _targetPremi;
	private String _prospectSource;
	private int _otherInsuranceJob;
	private int _tnc;
	private int _agentAFI;
	private int _sentToMAS;
	private int _approved;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}