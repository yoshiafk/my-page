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

import com.mypage.leads.model.Customer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Customer in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class CustomerCacheModel
	implements CacheModel<Customer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerCacheModel)) {
			return false;
		}

		CustomerCacheModel customerCacheModel = (CustomerCacheModel)object;

		if (customerId == customerCacheModel.customerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{customerId=");
		sb.append(customerId);
		sb.append(", LeadsId=");
		sb.append(LeadsId);
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
		sb.append(", Address=");
		sb.append(Address);
		sb.append(", Address2=");
		sb.append(Address2);
		sb.append(", Relationship=");
		sb.append(Relationship);
		sb.append(", Province=");
		sb.append(Province);
		sb.append(", City=");
		sb.append(City);
		sb.append(", Zip=");
		sb.append(Zip);
		sb.append(", Beneficiary=");
		sb.append(Beneficiary);
		sb.append(", BeneficiaryRelationship=");
		sb.append(BeneficiaryRelationship);
		sb.append(", Type=");
		sb.append(Type);
		sb.append(", ProductCode=");
		sb.append(ProductCode);
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
		sb.append(", idPhotoFileEntryId=");
		sb.append(idPhotoFileEntryId);
		sb.append(", PhotoFileUrl=");
		sb.append(PhotoFileUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Customer toEntityModel() {
		CustomerImpl customerImpl = new CustomerImpl();

		customerImpl.setCustomerId(customerId);
		customerImpl.setLeadsId(LeadsId);

		if (Name == null) {
			customerImpl.setName("");
		}
		else {
			customerImpl.setName(Name);
		}

		if (Email == null) {
			customerImpl.setEmail("");
		}
		else {
			customerImpl.setEmail(Email);
		}

		if (MobilePhone == null) {
			customerImpl.setMobilePhone("");
		}
		else {
			customerImpl.setMobilePhone(MobilePhone);
		}

		if (Gender == null) {
			customerImpl.setGender("");
		}
		else {
			customerImpl.setGender(Gender);
		}

		if (Dob == Long.MIN_VALUE) {
			customerImpl.setDob(null);
		}
		else {
			customerImpl.setDob(new Date(Dob));
		}

		if (BirthPlace == null) {
			customerImpl.setBirthPlace("");
		}
		else {
			customerImpl.setBirthPlace(BirthPlace);
		}

		if (Nationality == null) {
			customerImpl.setNationality("");
		}
		else {
			customerImpl.setNationality(Nationality);
		}

		if (IdNumber == null) {
			customerImpl.setIdNumber("");
		}
		else {
			customerImpl.setIdNumber(IdNumber);
		}

		if (PassportNumber == null) {
			customerImpl.setPassportNumber("");
		}
		else {
			customerImpl.setPassportNumber(PassportNumber);
		}

		if (KitasNumber == null) {
			customerImpl.setKitasNumber("");
		}
		else {
			customerImpl.setKitasNumber(KitasNumber);
		}

		if (Address == null) {
			customerImpl.setAddress("");
		}
		else {
			customerImpl.setAddress(Address);
		}

		if (Address2 == null) {
			customerImpl.setAddress2("");
		}
		else {
			customerImpl.setAddress2(Address2);
		}

		if (Relationship == null) {
			customerImpl.setRelationship("");
		}
		else {
			customerImpl.setRelationship(Relationship);
		}

		if (Province == null) {
			customerImpl.setProvince("");
		}
		else {
			customerImpl.setProvince(Province);
		}

		if (City == null) {
			customerImpl.setCity("");
		}
		else {
			customerImpl.setCity(City);
		}

		if (Zip == null) {
			customerImpl.setZip("");
		}
		else {
			customerImpl.setZip(Zip);
		}

		if (Beneficiary == null) {
			customerImpl.setBeneficiary("");
		}
		else {
			customerImpl.setBeneficiary(Beneficiary);
		}

		if (BeneficiaryRelationship == null) {
			customerImpl.setBeneficiaryRelationship("");
		}
		else {
			customerImpl.setBeneficiaryRelationship(BeneficiaryRelationship);
		}

		if (Type == null) {
			customerImpl.setType("");
		}
		else {
			customerImpl.setType(Type);
		}

		if (ProductCode == null) {
			customerImpl.setProductCode("");
		}
		else {
			customerImpl.setProductCode(ProductCode);
		}

		customerImpl.setGroupId(groupId);
		customerImpl.setCompanyId(companyId);
		customerImpl.setUserId(userId);

		if (userName == null) {
			customerImpl.setUserName("");
		}
		else {
			customerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customerImpl.setCreateDate(null);
		}
		else {
			customerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customerImpl.setModifiedDate(null);
		}
		else {
			customerImpl.setModifiedDate(new Date(modifiedDate));
		}

		customerImpl.setIsPep(isPep);

		if (CountryCode == null) {
			customerImpl.setCountryCode("");
		}
		else {
			customerImpl.setCountryCode(CountryCode);
		}

		if (Job == null) {
			customerImpl.setJob("");
		}
		else {
			customerImpl.setJob(Job);
		}

		if (JobOther == null) {
			customerImpl.setJobOther("");
		}
		else {
			customerImpl.setJobOther(JobOther);
		}

		customerImpl.setAge(Age);

		if (MaritalStatus == null) {
			customerImpl.setMaritalStatus("");
		}
		else {
			customerImpl.setMaritalStatus(MaritalStatus);
		}

		if (Phone == null) {
			customerImpl.setPhone("");
		}
		else {
			customerImpl.setPhone(Phone);
		}

		customerImpl.setIdPhotoFileEntryId(idPhotoFileEntryId);

		if (PhotoFileUrl == null) {
			customerImpl.setPhotoFileUrl("");
		}
		else {
			customerImpl.setPhotoFileUrl(PhotoFileUrl);
		}

		customerImpl.resetOriginalValues();

		return customerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerId = objectInput.readLong();

		LeadsId = objectInput.readLong();
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
		Address = objectInput.readUTF();
		Address2 = objectInput.readUTF();
		Relationship = objectInput.readUTF();
		Province = objectInput.readUTF();
		City = objectInput.readUTF();
		Zip = objectInput.readUTF();
		Beneficiary = objectInput.readUTF();
		BeneficiaryRelationship = objectInput.readUTF();
		Type = objectInput.readUTF();
		ProductCode = objectInput.readUTF();

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

		idPhotoFileEntryId = objectInput.readLong();
		PhotoFileUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(customerId);

		objectOutput.writeLong(LeadsId);

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

		if (Relationship == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Relationship);
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

		if (Type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Type);
		}

		if (ProductCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ProductCode);
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

		objectOutput.writeLong(idPhotoFileEntryId);

		if (PhotoFileUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PhotoFileUrl);
		}
	}

	public long customerId;
	public long LeadsId;
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
	public String Address;
	public String Address2;
	public String Relationship;
	public String Province;
	public String City;
	public String Zip;
	public String Beneficiary;
	public String BeneficiaryRelationship;
	public String Type;
	public String ProductCode;
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
	public long idPhotoFileEntryId;
	public String PhotoFileUrl;

}