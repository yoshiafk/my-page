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
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Gositus
 * @see Customer
 * @generated
 */
public class CustomerWrapper
	extends BaseModelWrapper<Customer>
	implements Customer, ModelWrapper<Customer> {

	public CustomerWrapper(Customer customer) {
		super(customer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerId", getCustomerId());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("Name", getName());
		attributes.put("Email", getEmail());
		attributes.put("MobilePhone", getMobilePhone());
		attributes.put("Gender", getGender());
		attributes.put("Dob", getDob());
		attributes.put("BirthPlace", getBirthPlace());
		attributes.put("Nationality", getNationality());
		attributes.put("IdNumber", getIdNumber());
		attributes.put("PassportNumber", getPassportNumber());
		attributes.put("KitasNumber", getKitasNumber());
		attributes.put("Address", getAddress());
		attributes.put("Address2", getAddress2());
		attributes.put("Relationship", getRelationship());
		attributes.put("Province", getProvince());
		attributes.put("City", getCity());
		attributes.put("Zip", getZip());
		attributes.put("Beneficiary", getBeneficiary());
		attributes.put("BeneficiaryRelationship", getBeneficiaryRelationship());
		attributes.put("Type", getType());
		attributes.put("ProductCode", getProductCode());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("isPep", getIsPep());
		attributes.put("CountryCode", getCountryCode());
		attributes.put("Job", getJob());
		attributes.put("JobOther", getJobOther());
		attributes.put("Age", getAge());
		attributes.put("MaritalStatus", getMaritalStatus());
		attributes.put("Phone", getPhone());
		attributes.put("idPhotoFileEntryId", getIdPhotoFileEntryId());
		attributes.put("PhotoFileUrl", getPhotoFileUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String MobilePhone = (String)attributes.get("MobilePhone");

		if (MobilePhone != null) {
			setMobilePhone(MobilePhone);
		}

		String Gender = (String)attributes.get("Gender");

		if (Gender != null) {
			setGender(Gender);
		}

		Date Dob = (Date)attributes.get("Dob");

		if (Dob != null) {
			setDob(Dob);
		}

		String BirthPlace = (String)attributes.get("BirthPlace");

		if (BirthPlace != null) {
			setBirthPlace(BirthPlace);
		}

		String Nationality = (String)attributes.get("Nationality");

		if (Nationality != null) {
			setNationality(Nationality);
		}

		String IdNumber = (String)attributes.get("IdNumber");

		if (IdNumber != null) {
			setIdNumber(IdNumber);
		}

		String PassportNumber = (String)attributes.get("PassportNumber");

		if (PassportNumber != null) {
			setPassportNumber(PassportNumber);
		}

		String KitasNumber = (String)attributes.get("KitasNumber");

		if (KitasNumber != null) {
			setKitasNumber(KitasNumber);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
		}

		String Address2 = (String)attributes.get("Address2");

		if (Address2 != null) {
			setAddress2(Address2);
		}

		String Relationship = (String)attributes.get("Relationship");

		if (Relationship != null) {
			setRelationship(Relationship);
		}

		String Province = (String)attributes.get("Province");

		if (Province != null) {
			setProvince(Province);
		}

		String City = (String)attributes.get("City");

		if (City != null) {
			setCity(City);
		}

		String Zip = (String)attributes.get("Zip");

		if (Zip != null) {
			setZip(Zip);
		}

		String Beneficiary = (String)attributes.get("Beneficiary");

		if (Beneficiary != null) {
			setBeneficiary(Beneficiary);
		}

		String BeneficiaryRelationship = (String)attributes.get(
			"BeneficiaryRelationship");

		if (BeneficiaryRelationship != null) {
			setBeneficiaryRelationship(BeneficiaryRelationship);
		}

		String Type = (String)attributes.get("Type");

		if (Type != null) {
			setType(Type);
		}

		String ProductCode = (String)attributes.get("ProductCode");

		if (ProductCode != null) {
			setProductCode(ProductCode);
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

		Integer isPep = (Integer)attributes.get("isPep");

		if (isPep != null) {
			setIsPep(isPep);
		}

		String CountryCode = (String)attributes.get("CountryCode");

		if (CountryCode != null) {
			setCountryCode(CountryCode);
		}

		String Job = (String)attributes.get("Job");

		if (Job != null) {
			setJob(Job);
		}

		String JobOther = (String)attributes.get("JobOther");

		if (JobOther != null) {
			setJobOther(JobOther);
		}

		Integer Age = (Integer)attributes.get("Age");

		if (Age != null) {
			setAge(Age);
		}

		String MaritalStatus = (String)attributes.get("MaritalStatus");

		if (MaritalStatus != null) {
			setMaritalStatus(MaritalStatus);
		}

		String Phone = (String)attributes.get("Phone");

		if (Phone != null) {
			setPhone(Phone);
		}

		Long idPhotoFileEntryId = (Long)attributes.get("idPhotoFileEntryId");

		if (idPhotoFileEntryId != null) {
			setIdPhotoFileEntryId(idPhotoFileEntryId);
		}

		String PhotoFileUrl = (String)attributes.get("PhotoFileUrl");

		if (PhotoFileUrl != null) {
			setPhotoFileUrl(PhotoFileUrl);
		}
	}

	/**
	 * Returns the address of this customer.
	 *
	 * @return the address of this customer
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this customer.
	 *
	 * @return the address2 of this customer
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the age of this customer.
	 *
	 * @return the age of this customer
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the beneficiary of this customer.
	 *
	 * @return the beneficiary of this customer
	 */
	@Override
	public String getBeneficiary() {
		return model.getBeneficiary();
	}

	/**
	 * Returns the beneficiary relationship of this customer.
	 *
	 * @return the beneficiary relationship of this customer
	 */
	@Override
	public String getBeneficiaryRelationship() {
		return model.getBeneficiaryRelationship();
	}

	/**
	 * Returns the birth place of this customer.
	 *
	 * @return the birth place of this customer
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the city of this customer.
	 *
	 * @return the city of this customer
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this customer.
	 *
	 * @return the company ID of this customer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country code of this customer.
	 *
	 * @return the country code of this customer
	 */
	@Override
	public String getCountryCode() {
		return model.getCountryCode();
	}

	/**
	 * Returns the create date of this customer.
	 *
	 * @return the create date of this customer
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this customer.
	 *
	 * @return the customer ID of this customer
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the dob of this customer.
	 *
	 * @return the dob of this customer
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the email of this customer.
	 *
	 * @return the email of this customer
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the gender of this customer.
	 *
	 * @return the gender of this customer
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this customer.
	 *
	 * @return the group ID of this customer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this customer.
	 *
	 * @return the id number of this customer
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the id photo file entry ID of this customer.
	 *
	 * @return the id photo file entry ID of this customer
	 */
	@Override
	public long getIdPhotoFileEntryId() {
		return model.getIdPhotoFileEntryId();
	}

	/**
	 * Returns the is pep of this customer.
	 *
	 * @return the is pep of this customer
	 */
	@Override
	public int getIsPep() {
		return model.getIsPep();
	}

	/**
	 * Returns the job of this customer.
	 *
	 * @return the job of this customer
	 */
	@Override
	public String getJob() {
		return model.getJob();
	}

	/**
	 * Returns the job other of this customer.
	 *
	 * @return the job other of this customer
	 */
	@Override
	public String getJobOther() {
		return model.getJobOther();
	}

	/**
	 * Returns the kitas number of this customer.
	 *
	 * @return the kitas number of this customer
	 */
	@Override
	public String getKitasNumber() {
		return model.getKitasNumber();
	}

	/**
	 * Returns the leads ID of this customer.
	 *
	 * @return the leads ID of this customer
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the marital status of this customer.
	 *
	 * @return the marital status of this customer
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile phone of this customer.
	 *
	 * @return the mobile phone of this customer
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this customer.
	 *
	 * @return the modified date of this customer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this customer.
	 *
	 * @return the name of this customer
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nationality of this customer.
	 *
	 * @return the nationality of this customer
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the passport number of this customer.
	 *
	 * @return the passport number of this customer
	 */
	@Override
	public String getPassportNumber() {
		return model.getPassportNumber();
	}

	/**
	 * Returns the phone of this customer.
	 *
	 * @return the phone of this customer
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the photo file url of this customer.
	 *
	 * @return the photo file url of this customer
	 */
	@Override
	public String getPhotoFileUrl() {
		return model.getPhotoFileUrl();
	}

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this customer.
	 *
	 * @return the product code of this customer
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the province of this customer.
	 *
	 * @return the province of this customer
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the relationship of this customer.
	 *
	 * @return the relationship of this customer
	 */
	@Override
	public String getRelationship() {
		return model.getRelationship();
	}

	/**
	 * Returns the type of this customer.
	 *
	 * @return the type of this customer
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this customer.
	 *
	 * @return the user ID of this customer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this customer.
	 *
	 * @return the user name of this customer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this customer.
	 *
	 * @return the user uuid of this customer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the zip of this customer.
	 *
	 * @return the zip of this customer
	 */
	@Override
	public String getZip() {
		return model.getZip();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this customer.
	 *
	 * @param Address the address of this customer
	 */
	@Override
	public void setAddress(String Address) {
		model.setAddress(Address);
	}

	/**
	 * Sets the address2 of this customer.
	 *
	 * @param Address2 the address2 of this customer
	 */
	@Override
	public void setAddress2(String Address2) {
		model.setAddress2(Address2);
	}

	/**
	 * Sets the age of this customer.
	 *
	 * @param Age the age of this customer
	 */
	@Override
	public void setAge(int Age) {
		model.setAge(Age);
	}

	/**
	 * Sets the beneficiary of this customer.
	 *
	 * @param Beneficiary the beneficiary of this customer
	 */
	@Override
	public void setBeneficiary(String Beneficiary) {
		model.setBeneficiary(Beneficiary);
	}

	/**
	 * Sets the beneficiary relationship of this customer.
	 *
	 * @param BeneficiaryRelationship the beneficiary relationship of this customer
	 */
	@Override
	public void setBeneficiaryRelationship(String BeneficiaryRelationship) {
		model.setBeneficiaryRelationship(BeneficiaryRelationship);
	}

	/**
	 * Sets the birth place of this customer.
	 *
	 * @param BirthPlace the birth place of this customer
	 */
	@Override
	public void setBirthPlace(String BirthPlace) {
		model.setBirthPlace(BirthPlace);
	}

	/**
	 * Sets the city of this customer.
	 *
	 * @param City the city of this customer
	 */
	@Override
	public void setCity(String City) {
		model.setCity(City);
	}

	/**
	 * Sets the company ID of this customer.
	 *
	 * @param companyId the company ID of this customer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country code of this customer.
	 *
	 * @param CountryCode the country code of this customer
	 */
	@Override
	public void setCountryCode(String CountryCode) {
		model.setCountryCode(CountryCode);
	}

	/**
	 * Sets the create date of this customer.
	 *
	 * @param createDate the create date of this customer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this customer.
	 *
	 * @param customerId the customer ID of this customer
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the dob of this customer.
	 *
	 * @param Dob the dob of this customer
	 */
	@Override
	public void setDob(Date Dob) {
		model.setDob(Dob);
	}

	/**
	 * Sets the email of this customer.
	 *
	 * @param Email the email of this customer
	 */
	@Override
	public void setEmail(String Email) {
		model.setEmail(Email);
	}

	/**
	 * Sets the gender of this customer.
	 *
	 * @param Gender the gender of this customer
	 */
	@Override
	public void setGender(String Gender) {
		model.setGender(Gender);
	}

	/**
	 * Sets the group ID of this customer.
	 *
	 * @param groupId the group ID of this customer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this customer.
	 *
	 * @param IdNumber the id number of this customer
	 */
	@Override
	public void setIdNumber(String IdNumber) {
		model.setIdNumber(IdNumber);
	}

	/**
	 * Sets the id photo file entry ID of this customer.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID of this customer
	 */
	@Override
	public void setIdPhotoFileEntryId(long idPhotoFileEntryId) {
		model.setIdPhotoFileEntryId(idPhotoFileEntryId);
	}

	/**
	 * Sets the is pep of this customer.
	 *
	 * @param isPep the is pep of this customer
	 */
	@Override
	public void setIsPep(int isPep) {
		model.setIsPep(isPep);
	}

	/**
	 * Sets the job of this customer.
	 *
	 * @param Job the job of this customer
	 */
	@Override
	public void setJob(String Job) {
		model.setJob(Job);
	}

	/**
	 * Sets the job other of this customer.
	 *
	 * @param JobOther the job other of this customer
	 */
	@Override
	public void setJobOther(String JobOther) {
		model.setJobOther(JobOther);
	}

	/**
	 * Sets the kitas number of this customer.
	 *
	 * @param KitasNumber the kitas number of this customer
	 */
	@Override
	public void setKitasNumber(String KitasNumber) {
		model.setKitasNumber(KitasNumber);
	}

	/**
	 * Sets the leads ID of this customer.
	 *
	 * @param LeadsId the leads ID of this customer
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the marital status of this customer.
	 *
	 * @param MaritalStatus the marital status of this customer
	 */
	@Override
	public void setMaritalStatus(String MaritalStatus) {
		model.setMaritalStatus(MaritalStatus);
	}

	/**
	 * Sets the mobile phone of this customer.
	 *
	 * @param MobilePhone the mobile phone of this customer
	 */
	@Override
	public void setMobilePhone(String MobilePhone) {
		model.setMobilePhone(MobilePhone);
	}

	/**
	 * Sets the modified date of this customer.
	 *
	 * @param modifiedDate the modified date of this customer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this customer.
	 *
	 * @param Name the name of this customer
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the nationality of this customer.
	 *
	 * @param Nationality the nationality of this customer
	 */
	@Override
	public void setNationality(String Nationality) {
		model.setNationality(Nationality);
	}

	/**
	 * Sets the passport number of this customer.
	 *
	 * @param PassportNumber the passport number of this customer
	 */
	@Override
	public void setPassportNumber(String PassportNumber) {
		model.setPassportNumber(PassportNumber);
	}

	/**
	 * Sets the phone of this customer.
	 *
	 * @param Phone the phone of this customer
	 */
	@Override
	public void setPhone(String Phone) {
		model.setPhone(Phone);
	}

	/**
	 * Sets the photo file url of this customer.
	 *
	 * @param PhotoFileUrl the photo file url of this customer
	 */
	@Override
	public void setPhotoFileUrl(String PhotoFileUrl) {
		model.setPhotoFileUrl(PhotoFileUrl);
	}

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this customer.
	 *
	 * @param ProductCode the product code of this customer
	 */
	@Override
	public void setProductCode(String ProductCode) {
		model.setProductCode(ProductCode);
	}

	/**
	 * Sets the province of this customer.
	 *
	 * @param Province the province of this customer
	 */
	@Override
	public void setProvince(String Province) {
		model.setProvince(Province);
	}

	/**
	 * Sets the relationship of this customer.
	 *
	 * @param Relationship the relationship of this customer
	 */
	@Override
	public void setRelationship(String Relationship) {
		model.setRelationship(Relationship);
	}

	/**
	 * Sets the type of this customer.
	 *
	 * @param Type the type of this customer
	 */
	@Override
	public void setType(String Type) {
		model.setType(Type);
	}

	/**
	 * Sets the user ID of this customer.
	 *
	 * @param userId the user ID of this customer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this customer.
	 *
	 * @param userName the user name of this customer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this customer.
	 *
	 * @param userUuid the user uuid of this customer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the zip of this customer.
	 *
	 * @param Zip the zip of this customer
	 */
	@Override
	public void setZip(String Zip) {
		model.setZip(Zip);
	}

	@Override
	protected CustomerWrapper wrap(Customer customer) {
		return new CustomerWrapper(customer);
	}

}