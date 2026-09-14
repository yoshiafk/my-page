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

package com.mypage.leads.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.leads.model.Leads;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Leads in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class LeadsCacheModel implements CacheModel<Leads>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeadsCacheModel)) {
			return false;
		}

		LeadsCacheModel leadsCacheModel = (LeadsCacheModel)object;

		if (LeadsId == leadsCacheModel.LeadsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, LeadsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(141);

		sb.append("{LeadsId=");
		sb.append(LeadsId);
		sb.append(", LeadsParentId=");
		sb.append(LeadsParentId);
		sb.append(", LeadsType=");
		sb.append(LeadsType);
		sb.append(", BussinesModel=");
		sb.append(BussinesModel);
		sb.append(", CommercialOffers=");
		sb.append(CommercialOffers);
		sb.append(", PolicyNumber=");
		sb.append(PolicyNumber);
		sb.append(", ReferenceNumber=");
		sb.append(ReferenceNumber);
		sb.append(", Currency=");
		sb.append(Currency);
		sb.append(", PolicyCost=");
		sb.append(PolicyCost);
		sb.append(", StampDuty=");
		sb.append(StampDuty);
		sb.append(", Premium=");
		sb.append(Premium);
		sb.append(", NetPremium=");
		sb.append(NetPremium);
		sb.append(", Discount=");
		sb.append(Discount);
		sb.append(", DiscountAmount=");
		sb.append(DiscountAmount);
		sb.append(", Commission=");
		sb.append(Commission);
		sb.append(", Channel=");
		sb.append(Channel);
		sb.append(", PromoCode=");
		sb.append(PromoCode);
		sb.append(", ProductCode=");
		sb.append(ProductCode);
		sb.append(", UtmSource=");
		sb.append(UtmSource);
		sb.append(", UtmMedium=");
		sb.append(UtmMedium);
		sb.append(", UtmCampaign=");
		sb.append(UtmCampaign);
		sb.append(", UtmTerm=");
		sb.append(UtmTerm);
		sb.append(", UtmContent=");
		sb.append(UtmContent);
		sb.append(", ClickId=");
		sb.append(ClickId);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", MobilePhone=");
		sb.append(MobilePhone);
		sb.append(", Gender=");
		sb.append(Gender);
		sb.append(", Dob=");
		sb.append(Dob);
		sb.append(", BirthPlace=");
		sb.append(BirthPlace);
		sb.append(", Nationality=");
		sb.append(Nationality);
		sb.append(", IdNumber=");
		sb.append(IdNumber);
		sb.append(", PassportNumber=");
		sb.append(PassportNumber);
		sb.append(", KitasNumber=");
		sb.append(KitasNumber);
		sb.append(", idPhotoFileEntryId=");
		sb.append(idPhotoFileEntryId);
		sb.append(", Address=");
		sb.append(Address);
		sb.append(", Address2=");
		sb.append(Address2);
		sb.append(", Province=");
		sb.append(Province);
		sb.append(", City=");
		sb.append(City);
		sb.append(", Zip=");
		sb.append(Zip);
		sb.append(", Active=");
		sb.append(Active);
		sb.append(", Token=");
		sb.append(Token);
		sb.append(", PolicyStartDate=");
		sb.append(PolicyStartDate);
		sb.append(", PolicyEndDate=");
		sb.append(PolicyEndDate);
		sb.append(", TempCode=");
		sb.append(TempCode);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", PaymentStatus=");
		sb.append(PaymentStatus);
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
		sb.append(", managedBy=");
		sb.append(managedBy);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", isPep=");
		sb.append(isPep);
		sb.append(", CountryCode=");
		sb.append(CountryCode);
		sb.append(", Job=");
		sb.append(Job);
		sb.append(", JobOther=");
		sb.append(JobOther);
		sb.append(", Age=");
		sb.append(Age);
		sb.append(", MaritalStatus=");
		sb.append(MaritalStatus);
		sb.append(", Phone=");
		sb.append(Phone);
		sb.append(", PhotoFileUrl=");
		sb.append(PhotoFileUrl);
		sb.append(", WorkLocation=");
		sb.append(WorkLocation);
		sb.append(", WorkLocationOther=");
		sb.append(WorkLocationOther);
		sb.append(", MonthlyIncome=");
		sb.append(MonthlyIncome);
		sb.append(", PaymentSource=");
		sb.append(PaymentSource);
		sb.append(", PaymentSourceOther=");
		sb.append(PaymentSourceOther);
		sb.append(", Beneficiary=");
		sb.append(Beneficiary);
		sb.append(", BeneficiaryRelationship=");
		sb.append(BeneficiaryRelationship);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Leads toEntityModel() {
		LeadsImpl leadsImpl = new LeadsImpl();

		leadsImpl.setLeadsId(LeadsId);
		leadsImpl.setLeadsParentId(LeadsParentId);

		if (LeadsType == null) {
			leadsImpl.setLeadsType("");
		}
		else {
			leadsImpl.setLeadsType(LeadsType);
		}

		if (BussinesModel == null) {
			leadsImpl.setBussinesModel("");
		}
		else {
			leadsImpl.setBussinesModel(BussinesModel);
		}

		leadsImpl.setCommercialOffers(CommercialOffers);

		if (PolicyNumber == null) {
			leadsImpl.setPolicyNumber("");
		}
		else {
			leadsImpl.setPolicyNumber(PolicyNumber);
		}

		if (ReferenceNumber == null) {
			leadsImpl.setReferenceNumber("");
		}
		else {
			leadsImpl.setReferenceNumber(ReferenceNumber);
		}

		if (Currency == null) {
			leadsImpl.setCurrency("");
		}
		else {
			leadsImpl.setCurrency(Currency);
		}

		leadsImpl.setPolicyCost(PolicyCost);
		leadsImpl.setStampDuty(StampDuty);
		leadsImpl.setPremium(Premium);
		leadsImpl.setNetPremium(NetPremium);
		leadsImpl.setDiscount(Discount);
		leadsImpl.setDiscountAmount(DiscountAmount);
		leadsImpl.setCommission(Commission);

		if (Channel == null) {
			leadsImpl.setChannel("");
		}
		else {
			leadsImpl.setChannel(Channel);
		}

		if (PromoCode == null) {
			leadsImpl.setPromoCode("");
		}
		else {
			leadsImpl.setPromoCode(PromoCode);
		}

		if (ProductCode == null) {
			leadsImpl.setProductCode("");
		}
		else {
			leadsImpl.setProductCode(ProductCode);
		}

		if (UtmSource == null) {
			leadsImpl.setUtmSource("");
		}
		else {
			leadsImpl.setUtmSource(UtmSource);
		}

		if (UtmMedium == null) {
			leadsImpl.setUtmMedium("");
		}
		else {
			leadsImpl.setUtmMedium(UtmMedium);
		}

		if (UtmCampaign == null) {
			leadsImpl.setUtmCampaign("");
		}
		else {
			leadsImpl.setUtmCampaign(UtmCampaign);
		}

		if (UtmTerm == null) {
			leadsImpl.setUtmTerm("");
		}
		else {
			leadsImpl.setUtmTerm(UtmTerm);
		}

		if (UtmContent == null) {
			leadsImpl.setUtmContent("");
		}
		else {
			leadsImpl.setUtmContent(UtmContent);
		}

		if (ClickId == null) {
			leadsImpl.setClickId("");
		}
		else {
			leadsImpl.setClickId(ClickId);
		}

		if (Name == null) {
			leadsImpl.setName("");
		}
		else {
			leadsImpl.setName(Name);
		}

		if (Email == null) {
			leadsImpl.setEmail("");
		}
		else {
			leadsImpl.setEmail(Email);
		}

		if (MobilePhone == null) {
			leadsImpl.setMobilePhone("");
		}
		else {
			leadsImpl.setMobilePhone(MobilePhone);
		}

		if (Gender == null) {
			leadsImpl.setGender("");
		}
		else {
			leadsImpl.setGender(Gender);
		}

		if (Dob == Long.MIN_VALUE) {
			leadsImpl.setDob(null);
		}
		else {
			leadsImpl.setDob(new Date(Dob));
		}

		if (BirthPlace == null) {
			leadsImpl.setBirthPlace("");
		}
		else {
			leadsImpl.setBirthPlace(BirthPlace);
		}

		if (Nationality == null) {
			leadsImpl.setNationality("");
		}
		else {
			leadsImpl.setNationality(Nationality);
		}

		if (IdNumber == null) {
			leadsImpl.setIdNumber("");
		}
		else {
			leadsImpl.setIdNumber(IdNumber);
		}

		if (PassportNumber == null) {
			leadsImpl.setPassportNumber("");
		}
		else {
			leadsImpl.setPassportNumber(PassportNumber);
		}

		if (KitasNumber == null) {
			leadsImpl.setKitasNumber("");
		}
		else {
			leadsImpl.setKitasNumber(KitasNumber);
		}

		leadsImpl.setIdPhotoFileEntryId(idPhotoFileEntryId);

		if (Address == null) {
			leadsImpl.setAddress("");
		}
		else {
			leadsImpl.setAddress(Address);
		}

		if (Address2 == null) {
			leadsImpl.setAddress2("");
		}
		else {
			leadsImpl.setAddress2(Address2);
		}

		if (Province == null) {
			leadsImpl.setProvince("");
		}
		else {
			leadsImpl.setProvince(Province);
		}

		if (City == null) {
			leadsImpl.setCity("");
		}
		else {
			leadsImpl.setCity(City);
		}

		if (Zip == null) {
			leadsImpl.setZip("");
		}
		else {
			leadsImpl.setZip(Zip);
		}

		leadsImpl.setActive(Active);

		if (Token == null) {
			leadsImpl.setToken("");
		}
		else {
			leadsImpl.setToken(Token);
		}

		if (PolicyStartDate == Long.MIN_VALUE) {
			leadsImpl.setPolicyStartDate(null);
		}
		else {
			leadsImpl.setPolicyStartDate(new Date(PolicyStartDate));
		}

		if (PolicyEndDate == Long.MIN_VALUE) {
			leadsImpl.setPolicyEndDate(null);
		}
		else {
			leadsImpl.setPolicyEndDate(new Date(PolicyEndDate));
		}

		if (TempCode == null) {
			leadsImpl.setTempCode("");
		}
		else {
			leadsImpl.setTempCode(TempCode);
		}

		if (Status == null) {
			leadsImpl.setStatus("");
		}
		else {
			leadsImpl.setStatus(Status);
		}

		if (PaymentStatus == null) {
			leadsImpl.setPaymentStatus("");
		}
		else {
			leadsImpl.setPaymentStatus(PaymentStatus);
		}

		leadsImpl.setMypageUserId(mypageUserId);

		if (managedBy == null) {
			leadsImpl.setManagedBy("");
		}
		else {
			leadsImpl.setManagedBy(managedBy);
		}

		leadsImpl.setGroupId(groupId);
		leadsImpl.setCompanyId(companyId);
		leadsImpl.setUserId(userId);

		if (userName == null) {
			leadsImpl.setUserName("");
		}
		else {
			leadsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			leadsImpl.setCreateDate(null);
		}
		else {
			leadsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leadsImpl.setModifiedDate(null);
		}
		else {
			leadsImpl.setModifiedDate(new Date(modifiedDate));
		}

		leadsImpl.setIsPep(isPep);

		if (CountryCode == null) {
			leadsImpl.setCountryCode("");
		}
		else {
			leadsImpl.setCountryCode(CountryCode);
		}

		if (Job == null) {
			leadsImpl.setJob("");
		}
		else {
			leadsImpl.setJob(Job);
		}

		if (JobOther == null) {
			leadsImpl.setJobOther("");
		}
		else {
			leadsImpl.setJobOther(JobOther);
		}

		leadsImpl.setAge(Age);

		if (MaritalStatus == null) {
			leadsImpl.setMaritalStatus("");
		}
		else {
			leadsImpl.setMaritalStatus(MaritalStatus);
		}

		if (Phone == null) {
			leadsImpl.setPhone("");
		}
		else {
			leadsImpl.setPhone(Phone);
		}

		if (PhotoFileUrl == null) {
			leadsImpl.setPhotoFileUrl("");
		}
		else {
			leadsImpl.setPhotoFileUrl(PhotoFileUrl);
		}

		if (WorkLocation == null) {
			leadsImpl.setWorkLocation("");
		}
		else {
			leadsImpl.setWorkLocation(WorkLocation);
		}

		if (WorkLocationOther == null) {
			leadsImpl.setWorkLocationOther("");
		}
		else {
			leadsImpl.setWorkLocationOther(WorkLocationOther);
		}

		if (MonthlyIncome == null) {
			leadsImpl.setMonthlyIncome("");
		}
		else {
			leadsImpl.setMonthlyIncome(MonthlyIncome);
		}

		if (PaymentSource == null) {
			leadsImpl.setPaymentSource("");
		}
		else {
			leadsImpl.setPaymentSource(PaymentSource);
		}

		if (PaymentSourceOther == null) {
			leadsImpl.setPaymentSourceOther("");
		}
		else {
			leadsImpl.setPaymentSourceOther(PaymentSourceOther);
		}

		if (Beneficiary == null) {
			leadsImpl.setBeneficiary("");
		}
		else {
			leadsImpl.setBeneficiary(Beneficiary);
		}

		if (BeneficiaryRelationship == null) {
			leadsImpl.setBeneficiaryRelationship("");
		}
		else {
			leadsImpl.setBeneficiaryRelationship(BeneficiaryRelationship);
		}

		leadsImpl.resetOriginalValues();

		return leadsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		LeadsId = objectInput.readLong();

		LeadsParentId = objectInput.readLong();
		LeadsType = objectInput.readUTF();
		BussinesModel = objectInput.readUTF();

		CommercialOffers = objectInput.readInt();
		PolicyNumber = objectInput.readUTF();
		ReferenceNumber = objectInput.readUTF();
		Currency = objectInput.readUTF();

		PolicyCost = objectInput.readDouble();

		StampDuty = objectInput.readDouble();

		Premium = objectInput.readDouble();

		NetPremium = objectInput.readDouble();

		Discount = objectInput.readDouble();

		DiscountAmount = objectInput.readDouble();

		Commission = objectInput.readDouble();
		Channel = objectInput.readUTF();
		PromoCode = objectInput.readUTF();
		ProductCode = objectInput.readUTF();
		UtmSource = objectInput.readUTF();
		UtmMedium = objectInput.readUTF();
		UtmCampaign = objectInput.readUTF();
		UtmTerm = objectInput.readUTF();
		UtmContent = objectInput.readUTF();
		ClickId = objectInput.readUTF();
		Name = objectInput.readUTF();
		Email = objectInput.readUTF();
		MobilePhone = objectInput.readUTF();
		Gender = objectInput.readUTF();
		Dob = objectInput.readLong();
		BirthPlace = objectInput.readUTF();
		Nationality = objectInput.readUTF();
		IdNumber = objectInput.readUTF();
		PassportNumber = objectInput.readUTF();
		KitasNumber = objectInput.readUTF();

		idPhotoFileEntryId = objectInput.readLong();
		Address = objectInput.readUTF();
		Address2 = objectInput.readUTF();
		Province = objectInput.readUTF();
		City = objectInput.readUTF();
		Zip = objectInput.readUTF();

		Active = objectInput.readInt();
		Token = objectInput.readUTF();
		PolicyStartDate = objectInput.readLong();
		PolicyEndDate = objectInput.readLong();
		TempCode = objectInput.readUTF();
		Status = objectInput.readUTF();
		PaymentStatus = objectInput.readUTF();

		mypageUserId = objectInput.readLong();
		managedBy = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		isPep = objectInput.readInt();
		CountryCode = objectInput.readUTF();
		Job = objectInput.readUTF();
		JobOther = objectInput.readUTF();

		Age = objectInput.readInt();
		MaritalStatus = objectInput.readUTF();
		Phone = objectInput.readUTF();
		PhotoFileUrl = objectInput.readUTF();
		WorkLocation = objectInput.readUTF();
		WorkLocationOther = objectInput.readUTF();
		MonthlyIncome = objectInput.readUTF();
		PaymentSource = objectInput.readUTF();
		PaymentSourceOther = objectInput.readUTF();
		Beneficiary = objectInput.readUTF();
		BeneficiaryRelationship = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(LeadsId);

		objectOutput.writeLong(LeadsParentId);

		if (LeadsType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LeadsType);
		}

		if (BussinesModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BussinesModel);
		}

		objectOutput.writeInt(CommercialOffers);

		if (PolicyNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PolicyNumber);
		}

		if (ReferenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ReferenceNumber);
		}

		if (Currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Currency);
		}

		objectOutput.writeDouble(PolicyCost);

		objectOutput.writeDouble(StampDuty);

		objectOutput.writeDouble(Premium);

		objectOutput.writeDouble(NetPremium);

		objectOutput.writeDouble(Discount);

		objectOutput.writeDouble(DiscountAmount);

		objectOutput.writeDouble(Commission);

		if (Channel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Channel);
		}

		if (PromoCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PromoCode);
		}

		if (ProductCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ProductCode);
		}

		if (UtmSource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UtmSource);
		}

		if (UtmMedium == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UtmMedium);
		}

		if (UtmCampaign == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UtmCampaign);
		}

		if (UtmTerm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UtmTerm);
		}

		if (UtmContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UtmContent);
		}

		if (ClickId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ClickId);
		}

		if (Name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Name);
		}

		if (Email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Email);
		}

		if (MobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MobilePhone);
		}

		if (Gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Gender);
		}

		objectOutput.writeLong(Dob);

		if (BirthPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BirthPlace);
		}

		if (Nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Nationality);
		}

		if (IdNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IdNumber);
		}

		if (PassportNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PassportNumber);
		}

		if (KitasNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(KitasNumber);
		}

		objectOutput.writeLong(idPhotoFileEntryId);

		if (Address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Address);
		}

		if (Address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Address2);
		}

		if (Province == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Province);
		}

		if (City == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(City);
		}

		if (Zip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Zip);
		}

		objectOutput.writeInt(Active);

		if (Token == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Token);
		}

		objectOutput.writeLong(PolicyStartDate);
		objectOutput.writeLong(PolicyEndDate);

		if (TempCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TempCode);
		}

		if (Status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Status);
		}

		if (PaymentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PaymentStatus);
		}

		objectOutput.writeLong(mypageUserId);

		if (managedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managedBy);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(isPep);

		if (CountryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CountryCode);
		}

		if (Job == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Job);
		}

		if (JobOther == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(JobOther);
		}

		objectOutput.writeInt(Age);

		if (MaritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MaritalStatus);
		}

		if (Phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Phone);
		}

		if (PhotoFileUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PhotoFileUrl);
		}

		if (WorkLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(WorkLocation);
		}

		if (WorkLocationOther == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(WorkLocationOther);
		}

		if (MonthlyIncome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MonthlyIncome);
		}

		if (PaymentSource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PaymentSource);
		}

		if (PaymentSourceOther == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PaymentSourceOther);
		}

		if (Beneficiary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Beneficiary);
		}

		if (BeneficiaryRelationship == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BeneficiaryRelationship);
		}
	}

	public long LeadsId;
	public long LeadsParentId;
	public String LeadsType;
	public String BussinesModel;
	public int CommercialOffers;
	public String PolicyNumber;
	public String ReferenceNumber;
	public String Currency;
	public double PolicyCost;
	public double StampDuty;
	public double Premium;
	public double NetPremium;
	public double Discount;
	public double DiscountAmount;
	public double Commission;
	public String Channel;
	public String PromoCode;
	public String ProductCode;
	public String UtmSource;
	public String UtmMedium;
	public String UtmCampaign;
	public String UtmTerm;
	public String UtmContent;
	public String ClickId;
	public String Name;
	public String Email;
	public String MobilePhone;
	public String Gender;
	public long Dob;
	public String BirthPlace;
	public String Nationality;
	public String IdNumber;
	public String PassportNumber;
	public String KitasNumber;
	public long idPhotoFileEntryId;
	public String Address;
	public String Address2;
	public String Province;
	public String City;
	public String Zip;
	public int Active;
	public String Token;
	public long PolicyStartDate;
	public long PolicyEndDate;
	public String TempCode;
	public String Status;
	public String PaymentStatus;
	public long mypageUserId;
	public String managedBy;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int isPep;
	public String CountryCode;
	public String Job;
	public String JobOther;
	public int Age;
	public String MaritalStatus;
	public String Phone;
	public String PhotoFileUrl;
	public String WorkLocation;
	public String WorkLocationOther;
	public String MonthlyIncome;
	public String PaymentSource;
	public String PaymentSourceOther;
	public String Beneficiary;
	public String BeneficiaryRelationship;

}