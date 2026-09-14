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
 * This class is a wrapper for {@link Leads}.
 * </p>
 *
 * @author Gositus
 * @see Leads
 * @generated
 */
public class LeadsWrapper
	extends BaseModelWrapper<Leads> implements Leads, ModelWrapper<Leads> {

	public LeadsWrapper(Leads leads) {
		super(leads);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LeadsId", getLeadsId());
		attributes.put("LeadsParentId", getLeadsParentId());
		attributes.put("LeadsType", getLeadsType());
		attributes.put("BussinesModel", getBussinesModel());
		attributes.put("CommercialOffers", getCommercialOffers());
		attributes.put("PolicyNumber", getPolicyNumber());
		attributes.put("ReferenceNumber", getReferenceNumber());
		attributes.put("Currency", getCurrency());
		attributes.put("PolicyCost", getPolicyCost());
		attributes.put("StampDuty", getStampDuty());
		attributes.put("Premium", getPremium());
		attributes.put("NetPremium", getNetPremium());
		attributes.put("Discount", getDiscount());
		attributes.put("DiscountAmount", getDiscountAmount());
		attributes.put("Commission", getCommission());
		attributes.put("Channel", getChannel());
		attributes.put("PromoCode", getPromoCode());
		attributes.put("ProductCode", getProductCode());
		attributes.put("UtmSource", getUtmSource());
		attributes.put("UtmMedium", getUtmMedium());
		attributes.put("UtmCampaign", getUtmCampaign());
		attributes.put("UtmTerm", getUtmTerm());
		attributes.put("UtmContent", getUtmContent());
		attributes.put("ClickId", getClickId());
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
		attributes.put("idPhotoFileEntryId", getIdPhotoFileEntryId());
		attributes.put("Address", getAddress());
		attributes.put("Address2", getAddress2());
		attributes.put("Province", getProvince());
		attributes.put("City", getCity());
		attributes.put("Zip", getZip());
		attributes.put("Active", getActive());
		attributes.put("Token", getToken());
		attributes.put("PolicyStartDate", getPolicyStartDate());
		attributes.put("PolicyEndDate", getPolicyEndDate());
		attributes.put("TempCode", getTempCode());
		attributes.put("Status", getStatus());
		attributes.put("PaymentStatus", getPaymentStatus());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("managedBy", getManagedBy());
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
		attributes.put("PhotoFileUrl", getPhotoFileUrl());
		attributes.put("WorkLocation", getWorkLocation());
		attributes.put("WorkLocationOther", getWorkLocationOther());
		attributes.put("MonthlyIncome", getMonthlyIncome());
		attributes.put("PaymentSource", getPaymentSource());
		attributes.put("PaymentSourceOther", getPaymentSourceOther());
		attributes.put("Beneficiary", getBeneficiary());
		attributes.put("BeneficiaryRelationship", getBeneficiaryRelationship());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		Long LeadsParentId = (Long)attributes.get("LeadsParentId");

		if (LeadsParentId != null) {
			setLeadsParentId(LeadsParentId);
		}

		String LeadsType = (String)attributes.get("LeadsType");

		if (LeadsType != null) {
			setLeadsType(LeadsType);
		}

		String BussinesModel = (String)attributes.get("BussinesModel");

		if (BussinesModel != null) {
			setBussinesModel(BussinesModel);
		}

		Integer CommercialOffers = (Integer)attributes.get("CommercialOffers");

		if (CommercialOffers != null) {
			setCommercialOffers(CommercialOffers);
		}

		String PolicyNumber = (String)attributes.get("PolicyNumber");

		if (PolicyNumber != null) {
			setPolicyNumber(PolicyNumber);
		}

		String ReferenceNumber = (String)attributes.get("ReferenceNumber");

		if (ReferenceNumber != null) {
			setReferenceNumber(ReferenceNumber);
		}

		String Currency = (String)attributes.get("Currency");

		if (Currency != null) {
			setCurrency(Currency);
		}

		Double PolicyCost = (Double)attributes.get("PolicyCost");

		if (PolicyCost != null) {
			setPolicyCost(PolicyCost);
		}

		Double StampDuty = (Double)attributes.get("StampDuty");

		if (StampDuty != null) {
			setStampDuty(StampDuty);
		}

		Double Premium = (Double)attributes.get("Premium");

		if (Premium != null) {
			setPremium(Premium);
		}

		Double NetPremium = (Double)attributes.get("NetPremium");

		if (NetPremium != null) {
			setNetPremium(NetPremium);
		}

		Double Discount = (Double)attributes.get("Discount");

		if (Discount != null) {
			setDiscount(Discount);
		}

		Double DiscountAmount = (Double)attributes.get("DiscountAmount");

		if (DiscountAmount != null) {
			setDiscountAmount(DiscountAmount);
		}

		Double Commission = (Double)attributes.get("Commission");

		if (Commission != null) {
			setCommission(Commission);
		}

		String Channel = (String)attributes.get("Channel");

		if (Channel != null) {
			setChannel(Channel);
		}

		String PromoCode = (String)attributes.get("PromoCode");

		if (PromoCode != null) {
			setPromoCode(PromoCode);
		}

		String ProductCode = (String)attributes.get("ProductCode");

		if (ProductCode != null) {
			setProductCode(ProductCode);
		}

		String UtmSource = (String)attributes.get("UtmSource");

		if (UtmSource != null) {
			setUtmSource(UtmSource);
		}

		String UtmMedium = (String)attributes.get("UtmMedium");

		if (UtmMedium != null) {
			setUtmMedium(UtmMedium);
		}

		String UtmCampaign = (String)attributes.get("UtmCampaign");

		if (UtmCampaign != null) {
			setUtmCampaign(UtmCampaign);
		}

		String UtmTerm = (String)attributes.get("UtmTerm");

		if (UtmTerm != null) {
			setUtmTerm(UtmTerm);
		}

		String UtmContent = (String)attributes.get("UtmContent");

		if (UtmContent != null) {
			setUtmContent(UtmContent);
		}

		String ClickId = (String)attributes.get("ClickId");

		if (ClickId != null) {
			setClickId(ClickId);
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

		Long idPhotoFileEntryId = (Long)attributes.get("idPhotoFileEntryId");

		if (idPhotoFileEntryId != null) {
			setIdPhotoFileEntryId(idPhotoFileEntryId);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
		}

		String Address2 = (String)attributes.get("Address2");

		if (Address2 != null) {
			setAddress2(Address2);
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

		Integer Active = (Integer)attributes.get("Active");

		if (Active != null) {
			setActive(Active);
		}

		String Token = (String)attributes.get("Token");

		if (Token != null) {
			setToken(Token);
		}

		Date PolicyStartDate = (Date)attributes.get("PolicyStartDate");

		if (PolicyStartDate != null) {
			setPolicyStartDate(PolicyStartDate);
		}

		Date PolicyEndDate = (Date)attributes.get("PolicyEndDate");

		if (PolicyEndDate != null) {
			setPolicyEndDate(PolicyEndDate);
		}

		String TempCode = (String)attributes.get("TempCode");

		if (TempCode != null) {
			setTempCode(TempCode);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		String PaymentStatus = (String)attributes.get("PaymentStatus");

		if (PaymentStatus != null) {
			setPaymentStatus(PaymentStatus);
		}

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		String managedBy = (String)attributes.get("managedBy");

		if (managedBy != null) {
			setManagedBy(managedBy);
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

		String PhotoFileUrl = (String)attributes.get("PhotoFileUrl");

		if (PhotoFileUrl != null) {
			setPhotoFileUrl(PhotoFileUrl);
		}

		String WorkLocation = (String)attributes.get("WorkLocation");

		if (WorkLocation != null) {
			setWorkLocation(WorkLocation);
		}

		String WorkLocationOther = (String)attributes.get("WorkLocationOther");

		if (WorkLocationOther != null) {
			setWorkLocationOther(WorkLocationOther);
		}

		String MonthlyIncome = (String)attributes.get("MonthlyIncome");

		if (MonthlyIncome != null) {
			setMonthlyIncome(MonthlyIncome);
		}

		String PaymentSource = (String)attributes.get("PaymentSource");

		if (PaymentSource != null) {
			setPaymentSource(PaymentSource);
		}

		String PaymentSourceOther = (String)attributes.get(
			"PaymentSourceOther");

		if (PaymentSourceOther != null) {
			setPaymentSourceOther(PaymentSourceOther);
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
	}

	/**
	 * Returns the active of this leads.
	 *
	 * @return the active of this leads
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the address of this leads.
	 *
	 * @return the address of this leads
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this leads.
	 *
	 * @return the address2 of this leads
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the age of this leads.
	 *
	 * @return the age of this leads
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the beneficiary of this leads.
	 *
	 * @return the beneficiary of this leads
	 */
	@Override
	public String getBeneficiary() {
		return model.getBeneficiary();
	}

	/**
	 * Returns the beneficiary relationship of this leads.
	 *
	 * @return the beneficiary relationship of this leads
	 */
	@Override
	public String getBeneficiaryRelationship() {
		return model.getBeneficiaryRelationship();
	}

	/**
	 * Returns the birth place of this leads.
	 *
	 * @return the birth place of this leads
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the bussines model of this leads.
	 *
	 * @return the bussines model of this leads
	 */
	@Override
	public String getBussinesModel() {
		return model.getBussinesModel();
	}

	/**
	 * Returns the channel of this leads.
	 *
	 * @return the channel of this leads
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the city of this leads.
	 *
	 * @return the city of this leads
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the click ID of this leads.
	 *
	 * @return the click ID of this leads
	 */
	@Override
	public String getClickId() {
		return model.getClickId();
	}

	/**
	 * Returns the commercial offers of this leads.
	 *
	 * @return the commercial offers of this leads
	 */
	@Override
	public int getCommercialOffers() {
		return model.getCommercialOffers();
	}

	/**
	 * Returns the commission of this leads.
	 *
	 * @return the commission of this leads
	 */
	@Override
	public double getCommission() {
		return model.getCommission();
	}

	/**
	 * Returns the company ID of this leads.
	 *
	 * @return the company ID of this leads
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country code of this leads.
	 *
	 * @return the country code of this leads
	 */
	@Override
	public String getCountryCode() {
		return model.getCountryCode();
	}

	/**
	 * Returns the create date of this leads.
	 *
	 * @return the create date of this leads
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this leads.
	 *
	 * @return the currency of this leads
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the discount of this leads.
	 *
	 * @return the discount of this leads
	 */
	@Override
	public double getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the discount amount of this leads.
	 *
	 * @return the discount amount of this leads
	 */
	@Override
	public double getDiscountAmount() {
		return model.getDiscountAmount();
	}

	/**
	 * Returns the dob of this leads.
	 *
	 * @return the dob of this leads
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the email of this leads.
	 *
	 * @return the email of this leads
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the gender of this leads.
	 *
	 * @return the gender of this leads
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this leads.
	 *
	 * @return the group ID of this leads
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this leads.
	 *
	 * @return the id number of this leads
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the id photo file entry ID of this leads.
	 *
	 * @return the id photo file entry ID of this leads
	 */
	@Override
	public long getIdPhotoFileEntryId() {
		return model.getIdPhotoFileEntryId();
	}

	/**
	 * Returns the is pep of this leads.
	 *
	 * @return the is pep of this leads
	 */
	@Override
	public int getIsPep() {
		return model.getIsPep();
	}

	/**
	 * Returns the job of this leads.
	 *
	 * @return the job of this leads
	 */
	@Override
	public String getJob() {
		return model.getJob();
	}

	/**
	 * Returns the job other of this leads.
	 *
	 * @return the job other of this leads
	 */
	@Override
	public String getJobOther() {
		return model.getJobOther();
	}

	/**
	 * Returns the kitas number of this leads.
	 *
	 * @return the kitas number of this leads
	 */
	@Override
	public String getKitasNumber() {
		return model.getKitasNumber();
	}

	/**
	 * Returns the leads ID of this leads.
	 *
	 * @return the leads ID of this leads
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the leads parent ID of this leads.
	 *
	 * @return the leads parent ID of this leads
	 */
	@Override
	public long getLeadsParentId() {
		return model.getLeadsParentId();
	}

	/**
	 * Returns the leads type of this leads.
	 *
	 * @return the leads type of this leads
	 */
	@Override
	public String getLeadsType() {
		return model.getLeadsType();
	}

	/**
	 * Returns the managed by of this leads.
	 *
	 * @return the managed by of this leads
	 */
	@Override
	public String getManagedBy() {
		return model.getManagedBy();
	}

	/**
	 * Returns the marital status of this leads.
	 *
	 * @return the marital status of this leads
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile phone of this leads.
	 *
	 * @return the mobile phone of this leads
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this leads.
	 *
	 * @return the modified date of this leads
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthly income of this leads.
	 *
	 * @return the monthly income of this leads
	 */
	@Override
	public String getMonthlyIncome() {
		return model.getMonthlyIncome();
	}

	/**
	 * Returns the mypage user ID of this leads.
	 *
	 * @return the mypage user ID of this leads
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this leads.
	 *
	 * @return the mypage user uuid of this leads
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the name of this leads.
	 *
	 * @return the name of this leads
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nationality of this leads.
	 *
	 * @return the nationality of this leads
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the net premium of this leads.
	 *
	 * @return the net premium of this leads
	 */
	@Override
	public double getNetPremium() {
		return model.getNetPremium();
	}

	/**
	 * Returns the passport number of this leads.
	 *
	 * @return the passport number of this leads
	 */
	@Override
	public String getPassportNumber() {
		return model.getPassportNumber();
	}

	/**
	 * Returns the payment source of this leads.
	 *
	 * @return the payment source of this leads
	 */
	@Override
	public String getPaymentSource() {
		return model.getPaymentSource();
	}

	/**
	 * Returns the payment source other of this leads.
	 *
	 * @return the payment source other of this leads
	 */
	@Override
	public String getPaymentSourceOther() {
		return model.getPaymentSourceOther();
	}

	/**
	 * Returns the payment status of this leads.
	 *
	 * @return the payment status of this leads
	 */
	@Override
	public String getPaymentStatus() {
		return model.getPaymentStatus();
	}

	/**
	 * Returns the phone of this leads.
	 *
	 * @return the phone of this leads
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the photo file url of this leads.
	 *
	 * @return the photo file url of this leads
	 */
	@Override
	public String getPhotoFileUrl() {
		return model.getPhotoFileUrl();
	}

	/**
	 * Returns the policy cost of this leads.
	 *
	 * @return the policy cost of this leads
	 */
	@Override
	public double getPolicyCost() {
		return model.getPolicyCost();
	}

	/**
	 * Returns the policy end date of this leads.
	 *
	 * @return the policy end date of this leads
	 */
	@Override
	public Date getPolicyEndDate() {
		return model.getPolicyEndDate();
	}

	/**
	 * Returns the policy number of this leads.
	 *
	 * @return the policy number of this leads
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the policy start date of this leads.
	 *
	 * @return the policy start date of this leads
	 */
	@Override
	public Date getPolicyStartDate() {
		return model.getPolicyStartDate();
	}

	/**
	 * Returns the premium of this leads.
	 *
	 * @return the premium of this leads
	 */
	@Override
	public double getPremium() {
		return model.getPremium();
	}

	/**
	 * Returns the primary key of this leads.
	 *
	 * @return the primary key of this leads
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this leads.
	 *
	 * @return the product code of this leads
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the promo code of this leads.
	 *
	 * @return the promo code of this leads
	 */
	@Override
	public String getPromoCode() {
		return model.getPromoCode();
	}

	/**
	 * Returns the province of this leads.
	 *
	 * @return the province of this leads
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the reference number of this leads.
	 *
	 * @return the reference number of this leads
	 */
	@Override
	public String getReferenceNumber() {
		return model.getReferenceNumber();
	}

	/**
	 * Returns the stamp duty of this leads.
	 *
	 * @return the stamp duty of this leads
	 */
	@Override
	public double getStampDuty() {
		return model.getStampDuty();
	}

	/**
	 * Returns the status of this leads.
	 *
	 * @return the status of this leads
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the temp code of this leads.
	 *
	 * @return the temp code of this leads
	 */
	@Override
	public String getTempCode() {
		return model.getTempCode();
	}

	/**
	 * Returns the token of this leads.
	 *
	 * @return the token of this leads
	 */
	@Override
	public String getToken() {
		return model.getToken();
	}

	/**
	 * Returns the user ID of this leads.
	 *
	 * @return the user ID of this leads
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this leads.
	 *
	 * @return the user name of this leads
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this leads.
	 *
	 * @return the user uuid of this leads
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm campaign of this leads.
	 *
	 * @return the utm campaign of this leads
	 */
	@Override
	public String getUtmCampaign() {
		return model.getUtmCampaign();
	}

	/**
	 * Returns the utm content of this leads.
	 *
	 * @return the utm content of this leads
	 */
	@Override
	public String getUtmContent() {
		return model.getUtmContent();
	}

	/**
	 * Returns the utm medium of this leads.
	 *
	 * @return the utm medium of this leads
	 */
	@Override
	public String getUtmMedium() {
		return model.getUtmMedium();
	}

	/**
	 * Returns the utm source of this leads.
	 *
	 * @return the utm source of this leads
	 */
	@Override
	public String getUtmSource() {
		return model.getUtmSource();
	}

	/**
	 * Returns the utm term of this leads.
	 *
	 * @return the utm term of this leads
	 */
	@Override
	public String getUtmTerm() {
		return model.getUtmTerm();
	}

	/**
	 * Returns the work location of this leads.
	 *
	 * @return the work location of this leads
	 */
	@Override
	public String getWorkLocation() {
		return model.getWorkLocation();
	}

	/**
	 * Returns the work location other of this leads.
	 *
	 * @return the work location other of this leads
	 */
	@Override
	public String getWorkLocationOther() {
		return model.getWorkLocationOther();
	}

	/**
	 * Returns the zip of this leads.
	 *
	 * @return the zip of this leads
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
	 * Sets the active of this leads.
	 *
	 * @param Active the active of this leads
	 */
	@Override
	public void setActive(int Active) {
		model.setActive(Active);
	}

	/**
	 * Sets the address of this leads.
	 *
	 * @param Address the address of this leads
	 */
	@Override
	public void setAddress(String Address) {
		model.setAddress(Address);
	}

	/**
	 * Sets the address2 of this leads.
	 *
	 * @param Address2 the address2 of this leads
	 */
	@Override
	public void setAddress2(String Address2) {
		model.setAddress2(Address2);
	}

	/**
	 * Sets the age of this leads.
	 *
	 * @param Age the age of this leads
	 */
	@Override
	public void setAge(int Age) {
		model.setAge(Age);
	}

	/**
	 * Sets the beneficiary of this leads.
	 *
	 * @param Beneficiary the beneficiary of this leads
	 */
	@Override
	public void setBeneficiary(String Beneficiary) {
		model.setBeneficiary(Beneficiary);
	}

	/**
	 * Sets the beneficiary relationship of this leads.
	 *
	 * @param BeneficiaryRelationship the beneficiary relationship of this leads
	 */
	@Override
	public void setBeneficiaryRelationship(String BeneficiaryRelationship) {
		model.setBeneficiaryRelationship(BeneficiaryRelationship);
	}

	/**
	 * Sets the birth place of this leads.
	 *
	 * @param BirthPlace the birth place of this leads
	 */
	@Override
	public void setBirthPlace(String BirthPlace) {
		model.setBirthPlace(BirthPlace);
	}

	/**
	 * Sets the bussines model of this leads.
	 *
	 * @param BussinesModel the bussines model of this leads
	 */
	@Override
	public void setBussinesModel(String BussinesModel) {
		model.setBussinesModel(BussinesModel);
	}

	/**
	 * Sets the channel of this leads.
	 *
	 * @param Channel the channel of this leads
	 */
	@Override
	public void setChannel(String Channel) {
		model.setChannel(Channel);
	}

	/**
	 * Sets the city of this leads.
	 *
	 * @param City the city of this leads
	 */
	@Override
	public void setCity(String City) {
		model.setCity(City);
	}

	/**
	 * Sets the click ID of this leads.
	 *
	 * @param ClickId the click ID of this leads
	 */
	@Override
	public void setClickId(String ClickId) {
		model.setClickId(ClickId);
	}

	/**
	 * Sets the commercial offers of this leads.
	 *
	 * @param CommercialOffers the commercial offers of this leads
	 */
	@Override
	public void setCommercialOffers(int CommercialOffers) {
		model.setCommercialOffers(CommercialOffers);
	}

	/**
	 * Sets the commission of this leads.
	 *
	 * @param Commission the commission of this leads
	 */
	@Override
	public void setCommission(double Commission) {
		model.setCommission(Commission);
	}

	/**
	 * Sets the company ID of this leads.
	 *
	 * @param companyId the company ID of this leads
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country code of this leads.
	 *
	 * @param CountryCode the country code of this leads
	 */
	@Override
	public void setCountryCode(String CountryCode) {
		model.setCountryCode(CountryCode);
	}

	/**
	 * Sets the create date of this leads.
	 *
	 * @param createDate the create date of this leads
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this leads.
	 *
	 * @param Currency the currency of this leads
	 */
	@Override
	public void setCurrency(String Currency) {
		model.setCurrency(Currency);
	}

	/**
	 * Sets the discount of this leads.
	 *
	 * @param Discount the discount of this leads
	 */
	@Override
	public void setDiscount(double Discount) {
		model.setDiscount(Discount);
	}

	/**
	 * Sets the discount amount of this leads.
	 *
	 * @param DiscountAmount the discount amount of this leads
	 */
	@Override
	public void setDiscountAmount(double DiscountAmount) {
		model.setDiscountAmount(DiscountAmount);
	}

	/**
	 * Sets the dob of this leads.
	 *
	 * @param Dob the dob of this leads
	 */
	@Override
	public void setDob(Date Dob) {
		model.setDob(Dob);
	}

	/**
	 * Sets the email of this leads.
	 *
	 * @param Email the email of this leads
	 */
	@Override
	public void setEmail(String Email) {
		model.setEmail(Email);
	}

	/**
	 * Sets the gender of this leads.
	 *
	 * @param Gender the gender of this leads
	 */
	@Override
	public void setGender(String Gender) {
		model.setGender(Gender);
	}

	/**
	 * Sets the group ID of this leads.
	 *
	 * @param groupId the group ID of this leads
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this leads.
	 *
	 * @param IdNumber the id number of this leads
	 */
	@Override
	public void setIdNumber(String IdNumber) {
		model.setIdNumber(IdNumber);
	}

	/**
	 * Sets the id photo file entry ID of this leads.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID of this leads
	 */
	@Override
	public void setIdPhotoFileEntryId(long idPhotoFileEntryId) {
		model.setIdPhotoFileEntryId(idPhotoFileEntryId);
	}

	/**
	 * Sets the is pep of this leads.
	 *
	 * @param isPep the is pep of this leads
	 */
	@Override
	public void setIsPep(int isPep) {
		model.setIsPep(isPep);
	}

	/**
	 * Sets the job of this leads.
	 *
	 * @param Job the job of this leads
	 */
	@Override
	public void setJob(String Job) {
		model.setJob(Job);
	}

	/**
	 * Sets the job other of this leads.
	 *
	 * @param JobOther the job other of this leads
	 */
	@Override
	public void setJobOther(String JobOther) {
		model.setJobOther(JobOther);
	}

	/**
	 * Sets the kitas number of this leads.
	 *
	 * @param KitasNumber the kitas number of this leads
	 */
	@Override
	public void setKitasNumber(String KitasNumber) {
		model.setKitasNumber(KitasNumber);
	}

	/**
	 * Sets the leads ID of this leads.
	 *
	 * @param LeadsId the leads ID of this leads
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the leads parent ID of this leads.
	 *
	 * @param LeadsParentId the leads parent ID of this leads
	 */
	@Override
	public void setLeadsParentId(long LeadsParentId) {
		model.setLeadsParentId(LeadsParentId);
	}

	/**
	 * Sets the leads type of this leads.
	 *
	 * @param LeadsType the leads type of this leads
	 */
	@Override
	public void setLeadsType(String LeadsType) {
		model.setLeadsType(LeadsType);
	}

	/**
	 * Sets the managed by of this leads.
	 *
	 * @param managedBy the managed by of this leads
	 */
	@Override
	public void setManagedBy(String managedBy) {
		model.setManagedBy(managedBy);
	}

	/**
	 * Sets the marital status of this leads.
	 *
	 * @param MaritalStatus the marital status of this leads
	 */
	@Override
	public void setMaritalStatus(String MaritalStatus) {
		model.setMaritalStatus(MaritalStatus);
	}

	/**
	 * Sets the mobile phone of this leads.
	 *
	 * @param MobilePhone the mobile phone of this leads
	 */
	@Override
	public void setMobilePhone(String MobilePhone) {
		model.setMobilePhone(MobilePhone);
	}

	/**
	 * Sets the modified date of this leads.
	 *
	 * @param modifiedDate the modified date of this leads
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthly income of this leads.
	 *
	 * @param MonthlyIncome the monthly income of this leads
	 */
	@Override
	public void setMonthlyIncome(String MonthlyIncome) {
		model.setMonthlyIncome(MonthlyIncome);
	}

	/**
	 * Sets the mypage user ID of this leads.
	 *
	 * @param mypageUserId the mypage user ID of this leads
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this leads.
	 *
	 * @param mypageUserUuid the mypage user uuid of this leads
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the name of this leads.
	 *
	 * @param Name the name of this leads
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the nationality of this leads.
	 *
	 * @param Nationality the nationality of this leads
	 */
	@Override
	public void setNationality(String Nationality) {
		model.setNationality(Nationality);
	}

	/**
	 * Sets the net premium of this leads.
	 *
	 * @param NetPremium the net premium of this leads
	 */
	@Override
	public void setNetPremium(double NetPremium) {
		model.setNetPremium(NetPremium);
	}

	/**
	 * Sets the passport number of this leads.
	 *
	 * @param PassportNumber the passport number of this leads
	 */
	@Override
	public void setPassportNumber(String PassportNumber) {
		model.setPassportNumber(PassportNumber);
	}

	/**
	 * Sets the payment source of this leads.
	 *
	 * @param PaymentSource the payment source of this leads
	 */
	@Override
	public void setPaymentSource(String PaymentSource) {
		model.setPaymentSource(PaymentSource);
	}

	/**
	 * Sets the payment source other of this leads.
	 *
	 * @param PaymentSourceOther the payment source other of this leads
	 */
	@Override
	public void setPaymentSourceOther(String PaymentSourceOther) {
		model.setPaymentSourceOther(PaymentSourceOther);
	}

	/**
	 * Sets the payment status of this leads.
	 *
	 * @param PaymentStatus the payment status of this leads
	 */
	@Override
	public void setPaymentStatus(String PaymentStatus) {
		model.setPaymentStatus(PaymentStatus);
	}

	/**
	 * Sets the phone of this leads.
	 *
	 * @param Phone the phone of this leads
	 */
	@Override
	public void setPhone(String Phone) {
		model.setPhone(Phone);
	}

	/**
	 * Sets the photo file url of this leads.
	 *
	 * @param PhotoFileUrl the photo file url of this leads
	 */
	@Override
	public void setPhotoFileUrl(String PhotoFileUrl) {
		model.setPhotoFileUrl(PhotoFileUrl);
	}

	/**
	 * Sets the policy cost of this leads.
	 *
	 * @param PolicyCost the policy cost of this leads
	 */
	@Override
	public void setPolicyCost(double PolicyCost) {
		model.setPolicyCost(PolicyCost);
	}

	/**
	 * Sets the policy end date of this leads.
	 *
	 * @param PolicyEndDate the policy end date of this leads
	 */
	@Override
	public void setPolicyEndDate(Date PolicyEndDate) {
		model.setPolicyEndDate(PolicyEndDate);
	}

	/**
	 * Sets the policy number of this leads.
	 *
	 * @param PolicyNumber the policy number of this leads
	 */
	@Override
	public void setPolicyNumber(String PolicyNumber) {
		model.setPolicyNumber(PolicyNumber);
	}

	/**
	 * Sets the policy start date of this leads.
	 *
	 * @param PolicyStartDate the policy start date of this leads
	 */
	@Override
	public void setPolicyStartDate(Date PolicyStartDate) {
		model.setPolicyStartDate(PolicyStartDate);
	}

	/**
	 * Sets the premium of this leads.
	 *
	 * @param Premium the premium of this leads
	 */
	@Override
	public void setPremium(double Premium) {
		model.setPremium(Premium);
	}

	/**
	 * Sets the primary key of this leads.
	 *
	 * @param primaryKey the primary key of this leads
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this leads.
	 *
	 * @param ProductCode the product code of this leads
	 */
	@Override
	public void setProductCode(String ProductCode) {
		model.setProductCode(ProductCode);
	}

	/**
	 * Sets the promo code of this leads.
	 *
	 * @param PromoCode the promo code of this leads
	 */
	@Override
	public void setPromoCode(String PromoCode) {
		model.setPromoCode(PromoCode);
	}

	/**
	 * Sets the province of this leads.
	 *
	 * @param Province the province of this leads
	 */
	@Override
	public void setProvince(String Province) {
		model.setProvince(Province);
	}

	/**
	 * Sets the reference number of this leads.
	 *
	 * @param ReferenceNumber the reference number of this leads
	 */
	@Override
	public void setReferenceNumber(String ReferenceNumber) {
		model.setReferenceNumber(ReferenceNumber);
	}

	/**
	 * Sets the stamp duty of this leads.
	 *
	 * @param StampDuty the stamp duty of this leads
	 */
	@Override
	public void setStampDuty(double StampDuty) {
		model.setStampDuty(StampDuty);
	}

	/**
	 * Sets the status of this leads.
	 *
	 * @param Status the status of this leads
	 */
	@Override
	public void setStatus(String Status) {
		model.setStatus(Status);
	}

	/**
	 * Sets the temp code of this leads.
	 *
	 * @param TempCode the temp code of this leads
	 */
	@Override
	public void setTempCode(String TempCode) {
		model.setTempCode(TempCode);
	}

	/**
	 * Sets the token of this leads.
	 *
	 * @param Token the token of this leads
	 */
	@Override
	public void setToken(String Token) {
		model.setToken(Token);
	}

	/**
	 * Sets the user ID of this leads.
	 *
	 * @param userId the user ID of this leads
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this leads.
	 *
	 * @param userName the user name of this leads
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this leads.
	 *
	 * @param userUuid the user uuid of this leads
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm campaign of this leads.
	 *
	 * @param UtmCampaign the utm campaign of this leads
	 */
	@Override
	public void setUtmCampaign(String UtmCampaign) {
		model.setUtmCampaign(UtmCampaign);
	}

	/**
	 * Sets the utm content of this leads.
	 *
	 * @param UtmContent the utm content of this leads
	 */
	@Override
	public void setUtmContent(String UtmContent) {
		model.setUtmContent(UtmContent);
	}

	/**
	 * Sets the utm medium of this leads.
	 *
	 * @param UtmMedium the utm medium of this leads
	 */
	@Override
	public void setUtmMedium(String UtmMedium) {
		model.setUtmMedium(UtmMedium);
	}

	/**
	 * Sets the utm source of this leads.
	 *
	 * @param UtmSource the utm source of this leads
	 */
	@Override
	public void setUtmSource(String UtmSource) {
		model.setUtmSource(UtmSource);
	}

	/**
	 * Sets the utm term of this leads.
	 *
	 * @param UtmTerm the utm term of this leads
	 */
	@Override
	public void setUtmTerm(String UtmTerm) {
		model.setUtmTerm(UtmTerm);
	}

	/**
	 * Sets the work location of this leads.
	 *
	 * @param WorkLocation the work location of this leads
	 */
	@Override
	public void setWorkLocation(String WorkLocation) {
		model.setWorkLocation(WorkLocation);
	}

	/**
	 * Sets the work location other of this leads.
	 *
	 * @param WorkLocationOther the work location other of this leads
	 */
	@Override
	public void setWorkLocationOther(String WorkLocationOther) {
		model.setWorkLocationOther(WorkLocationOther);
	}

	/**
	 * Sets the zip of this leads.
	 *
	 * @param Zip the zip of this leads
	 */
	@Override
	public void setZip(String Zip) {
		model.setZip(Zip);
	}

	@Override
	protected LeadsWrapper wrap(Leads leads) {
		return new LeadsWrapper(leads);
	}

}