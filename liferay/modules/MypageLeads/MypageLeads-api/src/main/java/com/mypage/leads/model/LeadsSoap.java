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
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.LeadsServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LeadsSoap implements Serializable {

	public static LeadsSoap toSoapModel(Leads model) {
		LeadsSoap soapModel = new LeadsSoap();

		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setLeadsParentId(model.getLeadsParentId());
		soapModel.setLeadsType(model.getLeadsType());
		soapModel.setBussinesModel(model.getBussinesModel());
		soapModel.setCommercialOffers(model.getCommercialOffers());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setReferenceNumber(model.getReferenceNumber());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setPolicyCost(model.getPolicyCost());
		soapModel.setStampDuty(model.getStampDuty());
		soapModel.setPremium(model.getPremium());
		soapModel.setNetPremium(model.getNetPremium());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setDiscountAmount(model.getDiscountAmount());
		soapModel.setCommission(model.getCommission());
		soapModel.setChannel(model.getChannel());
		soapModel.setPromoCode(model.getPromoCode());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setUtmSource(model.getUtmSource());
		soapModel.setUtmMedium(model.getUtmMedium());
		soapModel.setUtmCampaign(model.getUtmCampaign());
		soapModel.setUtmTerm(model.getUtmTerm());
		soapModel.setUtmContent(model.getUtmContent());
		soapModel.setClickId(model.getClickId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setGender(model.getGender());
		soapModel.setDob(model.getDob());
		soapModel.setBirthPlace(model.getBirthPlace());
		soapModel.setNationality(model.getNationality());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setPassportNumber(model.getPassportNumber());
		soapModel.setKitasNumber(model.getKitasNumber());
		soapModel.setIdPhotoFileEntryId(model.getIdPhotoFileEntryId());
		soapModel.setAddress(model.getAddress());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setProvince(model.getProvince());
		soapModel.setCity(model.getCity());
		soapModel.setZip(model.getZip());
		soapModel.setActive(model.getActive());
		soapModel.setToken(model.getToken());
		soapModel.setPolicyStartDate(model.getPolicyStartDate());
		soapModel.setPolicyEndDate(model.getPolicyEndDate());
		soapModel.setTempCode(model.getTempCode());
		soapModel.setStatus(model.getStatus());
		soapModel.setPaymentStatus(model.getPaymentStatus());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setManagedBy(model.getManagedBy());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIsPep(model.getIsPep());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setJob(model.getJob());
		soapModel.setJobOther(model.getJobOther());
		soapModel.setAge(model.getAge());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setPhone(model.getPhone());
		soapModel.setPhotoFileUrl(model.getPhotoFileUrl());
		soapModel.setWorkLocation(model.getWorkLocation());
		soapModel.setWorkLocationOther(model.getWorkLocationOther());
		soapModel.setMonthlyIncome(model.getMonthlyIncome());
		soapModel.setPaymentSource(model.getPaymentSource());
		soapModel.setPaymentSourceOther(model.getPaymentSourceOther());
		soapModel.setBeneficiary(model.getBeneficiary());
		soapModel.setBeneficiaryRelationship(
			model.getBeneficiaryRelationship());

		return soapModel;
	}

	public static LeadsSoap[] toSoapModels(Leads[] models) {
		LeadsSoap[] soapModels = new LeadsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeadsSoap[][] toSoapModels(Leads[][] models) {
		LeadsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeadsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeadsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeadsSoap[] toSoapModels(List<Leads> models) {
		List<LeadsSoap> soapModels = new ArrayList<LeadsSoap>(models.size());

		for (Leads model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeadsSoap[soapModels.size()]);
	}

	public LeadsSoap() {
	}

	public long getPrimaryKey() {
		return _LeadsId;
	}

	public void setPrimaryKey(long pk) {
		setLeadsId(pk);
	}

	public long getLeadsId() {
		return _LeadsId;
	}

	public void setLeadsId(long LeadsId) {
		_LeadsId = LeadsId;
	}

	public long getLeadsParentId() {
		return _LeadsParentId;
	}

	public void setLeadsParentId(long LeadsParentId) {
		_LeadsParentId = LeadsParentId;
	}

	public String getLeadsType() {
		return _LeadsType;
	}

	public void setLeadsType(String LeadsType) {
		_LeadsType = LeadsType;
	}

	public String getBussinesModel() {
		return _BussinesModel;
	}

	public void setBussinesModel(String BussinesModel) {
		_BussinesModel = BussinesModel;
	}

	public int getCommercialOffers() {
		return _CommercialOffers;
	}

	public void setCommercialOffers(int CommercialOffers) {
		_CommercialOffers = CommercialOffers;
	}

	public String getPolicyNumber() {
		return _PolicyNumber;
	}

	public void setPolicyNumber(String PolicyNumber) {
		_PolicyNumber = PolicyNumber;
	}

	public String getReferenceNumber() {
		return _ReferenceNumber;
	}

	public void setReferenceNumber(String ReferenceNumber) {
		_ReferenceNumber = ReferenceNumber;
	}

	public String getCurrency() {
		return _Currency;
	}

	public void setCurrency(String Currency) {
		_Currency = Currency;
	}

	public double getPolicyCost() {
		return _PolicyCost;
	}

	public void setPolicyCost(double PolicyCost) {
		_PolicyCost = PolicyCost;
	}

	public double getStampDuty() {
		return _StampDuty;
	}

	public void setStampDuty(double StampDuty) {
		_StampDuty = StampDuty;
	}

	public double getPremium() {
		return _Premium;
	}

	public void setPremium(double Premium) {
		_Premium = Premium;
	}

	public double getNetPremium() {
		return _NetPremium;
	}

	public void setNetPremium(double NetPremium) {
		_NetPremium = NetPremium;
	}

	public double getDiscount() {
		return _Discount;
	}

	public void setDiscount(double Discount) {
		_Discount = Discount;
	}

	public double getDiscountAmount() {
		return _DiscountAmount;
	}

	public void setDiscountAmount(double DiscountAmount) {
		_DiscountAmount = DiscountAmount;
	}

	public double getCommission() {
		return _Commission;
	}

	public void setCommission(double Commission) {
		_Commission = Commission;
	}

	public String getChannel() {
		return _Channel;
	}

	public void setChannel(String Channel) {
		_Channel = Channel;
	}

	public String getPromoCode() {
		return _PromoCode;
	}

	public void setPromoCode(String PromoCode) {
		_PromoCode = PromoCode;
	}

	public String getProductCode() {
		return _ProductCode;
	}

	public void setProductCode(String ProductCode) {
		_ProductCode = ProductCode;
	}

	public String getUtmSource() {
		return _UtmSource;
	}

	public void setUtmSource(String UtmSource) {
		_UtmSource = UtmSource;
	}

	public String getUtmMedium() {
		return _UtmMedium;
	}

	public void setUtmMedium(String UtmMedium) {
		_UtmMedium = UtmMedium;
	}

	public String getUtmCampaign() {
		return _UtmCampaign;
	}

	public void setUtmCampaign(String UtmCampaign) {
		_UtmCampaign = UtmCampaign;
	}

	public String getUtmTerm() {
		return _UtmTerm;
	}

	public void setUtmTerm(String UtmTerm) {
		_UtmTerm = UtmTerm;
	}

	public String getUtmContent() {
		return _UtmContent;
	}

	public void setUtmContent(String UtmContent) {
		_UtmContent = UtmContent;
	}

	public String getClickId() {
		return _ClickId;
	}

	public void setClickId(String ClickId) {
		_ClickId = ClickId;
	}

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getMobilePhone() {
		return _MobilePhone;
	}

	public void setMobilePhone(String MobilePhone) {
		_MobilePhone = MobilePhone;
	}

	public String getGender() {
		return _Gender;
	}

	public void setGender(String Gender) {
		_Gender = Gender;
	}

	public Date getDob() {
		return _Dob;
	}

	public void setDob(Date Dob) {
		_Dob = Dob;
	}

	public String getBirthPlace() {
		return _BirthPlace;
	}

	public void setBirthPlace(String BirthPlace) {
		_BirthPlace = BirthPlace;
	}

	public String getNationality() {
		return _Nationality;
	}

	public void setNationality(String Nationality) {
		_Nationality = Nationality;
	}

	public String getIdNumber() {
		return _IdNumber;
	}

	public void setIdNumber(String IdNumber) {
		_IdNumber = IdNumber;
	}

	public String getPassportNumber() {
		return _PassportNumber;
	}

	public void setPassportNumber(String PassportNumber) {
		_PassportNumber = PassportNumber;
	}

	public String getKitasNumber() {
		return _KitasNumber;
	}

	public void setKitasNumber(String KitasNumber) {
		_KitasNumber = KitasNumber;
	}

	public long getIdPhotoFileEntryId() {
		return _idPhotoFileEntryId;
	}

	public void setIdPhotoFileEntryId(long idPhotoFileEntryId) {
		_idPhotoFileEntryId = idPhotoFileEntryId;
	}

	public String getAddress() {
		return _Address;
	}

	public void setAddress(String Address) {
		_Address = Address;
	}

	public String getAddress2() {
		return _Address2;
	}

	public void setAddress2(String Address2) {
		_Address2 = Address2;
	}

	public String getProvince() {
		return _Province;
	}

	public void setProvince(String Province) {
		_Province = Province;
	}

	public String getCity() {
		return _City;
	}

	public void setCity(String City) {
		_City = City;
	}

	public String getZip() {
		return _Zip;
	}

	public void setZip(String Zip) {
		_Zip = Zip;
	}

	public int getActive() {
		return _Active;
	}

	public void setActive(int Active) {
		_Active = Active;
	}

	public String getToken() {
		return _Token;
	}

	public void setToken(String Token) {
		_Token = Token;
	}

	public Date getPolicyStartDate() {
		return _PolicyStartDate;
	}

	public void setPolicyStartDate(Date PolicyStartDate) {
		_PolicyStartDate = PolicyStartDate;
	}

	public Date getPolicyEndDate() {
		return _PolicyEndDate;
	}

	public void setPolicyEndDate(Date PolicyEndDate) {
		_PolicyEndDate = PolicyEndDate;
	}

	public String getTempCode() {
		return _TempCode;
	}

	public void setTempCode(String TempCode) {
		_TempCode = TempCode;
	}

	public String getStatus() {
		return _Status;
	}

	public void setStatus(String Status) {
		_Status = Status;
	}

	public String getPaymentStatus() {
		return _PaymentStatus;
	}

	public void setPaymentStatus(String PaymentStatus) {
		_PaymentStatus = PaymentStatus;
	}

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
	}

	public String getManagedBy() {
		return _managedBy;
	}

	public void setManagedBy(String managedBy) {
		_managedBy = managedBy;
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

	public int getIsPep() {
		return _isPep;
	}

	public void setIsPep(int isPep) {
		_isPep = isPep;
	}

	public String getCountryCode() {
		return _CountryCode;
	}

	public void setCountryCode(String CountryCode) {
		_CountryCode = CountryCode;
	}

	public String getJob() {
		return _Job;
	}

	public void setJob(String Job) {
		_Job = Job;
	}

	public String getJobOther() {
		return _JobOther;
	}

	public void setJobOther(String JobOther) {
		_JobOther = JobOther;
	}

	public int getAge() {
		return _Age;
	}

	public void setAge(int Age) {
		_Age = Age;
	}

	public String getMaritalStatus() {
		return _MaritalStatus;
	}

	public void setMaritalStatus(String MaritalStatus) {
		_MaritalStatus = MaritalStatus;
	}

	public String getPhone() {
		return _Phone;
	}

	public void setPhone(String Phone) {
		_Phone = Phone;
	}

	public String getPhotoFileUrl() {
		return _PhotoFileUrl;
	}

	public void setPhotoFileUrl(String PhotoFileUrl) {
		_PhotoFileUrl = PhotoFileUrl;
	}

	public String getWorkLocation() {
		return _WorkLocation;
	}

	public void setWorkLocation(String WorkLocation) {
		_WorkLocation = WorkLocation;
	}

	public String getWorkLocationOther() {
		return _WorkLocationOther;
	}

	public void setWorkLocationOther(String WorkLocationOther) {
		_WorkLocationOther = WorkLocationOther;
	}

	public String getMonthlyIncome() {
		return _MonthlyIncome;
	}

	public void setMonthlyIncome(String MonthlyIncome) {
		_MonthlyIncome = MonthlyIncome;
	}

	public String getPaymentSource() {
		return _PaymentSource;
	}

	public void setPaymentSource(String PaymentSource) {
		_PaymentSource = PaymentSource;
	}

	public String getPaymentSourceOther() {
		return _PaymentSourceOther;
	}

	public void setPaymentSourceOther(String PaymentSourceOther) {
		_PaymentSourceOther = PaymentSourceOther;
	}

	public String getBeneficiary() {
		return _Beneficiary;
	}

	public void setBeneficiary(String Beneficiary) {
		_Beneficiary = Beneficiary;
	}

	public String getBeneficiaryRelationship() {
		return _BeneficiaryRelationship;
	}

	public void setBeneficiaryRelationship(String BeneficiaryRelationship) {
		_BeneficiaryRelationship = BeneficiaryRelationship;
	}

	private long _LeadsId;
	private long _LeadsParentId;
	private String _LeadsType;
	private String _BussinesModel;
	private int _CommercialOffers;
	private String _PolicyNumber;
	private String _ReferenceNumber;
	private String _Currency;
	private double _PolicyCost;
	private double _StampDuty;
	private double _Premium;
	private double _NetPremium;
	private double _Discount;
	private double _DiscountAmount;
	private double _Commission;
	private String _Channel;
	private String _PromoCode;
	private String _ProductCode;
	private String _UtmSource;
	private String _UtmMedium;
	private String _UtmCampaign;
	private String _UtmTerm;
	private String _UtmContent;
	private String _ClickId;
	private String _Name;
	private String _Email;
	private String _MobilePhone;
	private String _Gender;
	private Date _Dob;
	private String _BirthPlace;
	private String _Nationality;
	private String _IdNumber;
	private String _PassportNumber;
	private String _KitasNumber;
	private long _idPhotoFileEntryId;
	private String _Address;
	private String _Address2;
	private String _Province;
	private String _City;
	private String _Zip;
	private int _Active;
	private String _Token;
	private Date _PolicyStartDate;
	private Date _PolicyEndDate;
	private String _TempCode;
	private String _Status;
	private String _PaymentStatus;
	private long _mypageUserId;
	private String _managedBy;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _isPep;
	private String _CountryCode;
	private String _Job;
	private String _JobOther;
	private int _Age;
	private String _MaritalStatus;
	private String _Phone;
	private String _PhotoFileUrl;
	private String _WorkLocation;
	private String _WorkLocationOther;
	private String _MonthlyIncome;
	private String _PaymentSource;
	private String _PaymentSourceOther;
	private String _Beneficiary;
	private String _BeneficiaryRelationship;

}