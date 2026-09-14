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
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.CustomerServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CustomerSoap implements Serializable {

	public static CustomerSoap toSoapModel(Customer model) {
		CustomerSoap soapModel = new CustomerSoap();

		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setLeadsId(model.getLeadsId());
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
		soapModel.setAddress(model.getAddress());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setRelationship(model.getRelationship());
		soapModel.setProvince(model.getProvince());
		soapModel.setCity(model.getCity());
		soapModel.setZip(model.getZip());
		soapModel.setBeneficiary(model.getBeneficiary());
		soapModel.setBeneficiaryRelationship(
			model.getBeneficiaryRelationship());
		soapModel.setType(model.getType());
		soapModel.setProductCode(model.getProductCode());
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
		soapModel.setIdPhotoFileEntryId(model.getIdPhotoFileEntryId());
		soapModel.setPhotoFileUrl(model.getPhotoFileUrl());

		return soapModel;
	}

	public static CustomerSoap[] toSoapModels(Customer[] models) {
		CustomerSoap[] soapModels = new CustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[][] toSoapModels(Customer[][] models) {
		CustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[] toSoapModels(List<Customer> models) {
		List<CustomerSoap> soapModels = new ArrayList<CustomerSoap>(
			models.size());

		for (Customer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerSoap[soapModels.size()]);
	}

	public CustomerSoap() {
	}

	public long getPrimaryKey() {
		return _customerId;
	}

	public void setPrimaryKey(long pk) {
		setCustomerId(pk);
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public long getLeadsId() {
		return _LeadsId;
	}

	public void setLeadsId(long LeadsId) {
		_LeadsId = LeadsId;
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

	public String getRelationship() {
		return _Relationship;
	}

	public void setRelationship(String Relationship) {
		_Relationship = Relationship;
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

	public String getType() {
		return _Type;
	}

	public void setType(String Type) {
		_Type = Type;
	}

	public String getProductCode() {
		return _ProductCode;
	}

	public void setProductCode(String ProductCode) {
		_ProductCode = ProductCode;
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

	public long getIdPhotoFileEntryId() {
		return _idPhotoFileEntryId;
	}

	public void setIdPhotoFileEntryId(long idPhotoFileEntryId) {
		_idPhotoFileEntryId = idPhotoFileEntryId;
	}

	public String getPhotoFileUrl() {
		return _PhotoFileUrl;
	}

	public void setPhotoFileUrl(String PhotoFileUrl) {
		_PhotoFileUrl = PhotoFileUrl;
	}

	private long _customerId;
	private long _LeadsId;
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
	private String _Address;
	private String _Address2;
	private String _Relationship;
	private String _Province;
	private String _City;
	private String _Zip;
	private String _Beneficiary;
	private String _BeneficiaryRelationship;
	private String _Type;
	private String _ProductCode;
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
	private long _idPhotoFileEntryId;
	private String _PhotoFileUrl;

}