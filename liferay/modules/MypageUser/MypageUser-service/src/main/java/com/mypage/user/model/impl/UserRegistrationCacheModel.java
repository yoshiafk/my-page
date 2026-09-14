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

package com.mypage.user.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.user.model.UserRegistration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRegistrationCacheModel
	implements CacheModel<UserRegistration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRegistrationCacheModel)) {
			return false;
		}

		UserRegistrationCacheModel userRegistrationCacheModel =
			(UserRegistrationCacheModel)object;

		if (userRegistrationId ==
				userRegistrationCacheModel.userRegistrationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRegistrationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(105);

		sb.append("{userRegistrationId=");
		sb.append(userRegistrationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", idNumber=");
		sb.append(idNumber);
		sb.append(", licenseNumber=");
		sb.append(licenseNumber);
		sb.append(", address=");
		sb.append(address);
		sb.append(", postalAddress=");
		sb.append(postalAddress);
		sb.append(", province=");
		sb.append(province);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthPlace=");
		sb.append(birthPlace);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", residenceStatus=");
		sb.append(residenceStatus);
		sb.append(", stayPeriod=");
		sb.append(stayPeriod);
		sb.append(", knowAXAFrom=");
		sb.append(knowAXAFrom);
		sb.append(", knowAXAFromOther=");
		sb.append(knowAXAFromOther);
		sb.append(", joinReason=");
		sb.append(joinReason);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", bankAccountName=");
		sb.append(bankAccountName);
		sb.append(", bankAccountNo=");
		sb.append(bankAccountNo);
		sb.append(", npwp=");
		sb.append(npwp);
		sb.append(", npwpName=");
		sb.append(npwpName);
		sb.append(", portfolioFire=");
		sb.append(portfolioFire);
		sb.append(", portfolioMotor=");
		sb.append(portfolioMotor);
		sb.append(", portfolioMarine=");
		sb.append(portfolioMarine);
		sb.append(", portfolioHealth=");
		sb.append(portfolioHealth);
		sb.append(", portfolioOther=");
		sb.append(portfolioOther);
		sb.append(", targetFire=");
		sb.append(targetFire);
		sb.append(", targetMotor=");
		sb.append(targetMotor);
		sb.append(", targetMarine=");
		sb.append(targetMarine);
		sb.append(", targetHealth=");
		sb.append(targetHealth);
		sb.append(", targetOther=");
		sb.append(targetOther);
		sb.append(", annualPremiIncome=");
		sb.append(annualPremiIncome);
		sb.append(", targetCase=");
		sb.append(targetCase);
		sb.append(", targetPremi=");
		sb.append(targetPremi);
		sb.append(", prospectSource=");
		sb.append(prospectSource);
		sb.append(", otherInsuranceJob=");
		sb.append(otherInsuranceJob);
		sb.append(", tnc=");
		sb.append(tnc);
		sb.append(", agentAFI=");
		sb.append(agentAFI);
		sb.append(", sentToMAS=");
		sb.append(sentToMAS);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", active=");
		sb.append(active);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserRegistration toEntityModel() {
		UserRegistrationImpl userRegistrationImpl = new UserRegistrationImpl();

		userRegistrationImpl.setUserRegistrationId(userRegistrationId);

		if (name == null) {
			userRegistrationImpl.setName("");
		}
		else {
			userRegistrationImpl.setName(name);
		}

		if (idNumber == null) {
			userRegistrationImpl.setIdNumber("");
		}
		else {
			userRegistrationImpl.setIdNumber(idNumber);
		}

		if (licenseNumber == null) {
			userRegistrationImpl.setLicenseNumber("");
		}
		else {
			userRegistrationImpl.setLicenseNumber(licenseNumber);
		}

		if (address == null) {
			userRegistrationImpl.setAddress("");
		}
		else {
			userRegistrationImpl.setAddress(address);
		}

		if (postalAddress == null) {
			userRegistrationImpl.setPostalAddress("");
		}
		else {
			userRegistrationImpl.setPostalAddress(postalAddress);
		}

		if (province == null) {
			userRegistrationImpl.setProvince("");
		}
		else {
			userRegistrationImpl.setProvince(province);
		}

		if (city == null) {
			userRegistrationImpl.setCity("");
		}
		else {
			userRegistrationImpl.setCity(city);
		}

		if (zip == null) {
			userRegistrationImpl.setZip("");
		}
		else {
			userRegistrationImpl.setZip(zip);
		}

		if (phone == null) {
			userRegistrationImpl.setPhone("");
		}
		else {
			userRegistrationImpl.setPhone(phone);
		}

		if (mobilePhone == null) {
			userRegistrationImpl.setMobilePhone("");
		}
		else {
			userRegistrationImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			userRegistrationImpl.setEmail("");
		}
		else {
			userRegistrationImpl.setEmail(email);
		}

		if (birthPlace == null) {
			userRegistrationImpl.setBirthPlace("");
		}
		else {
			userRegistrationImpl.setBirthPlace(birthPlace);
		}

		if (dob == Long.MIN_VALUE) {
			userRegistrationImpl.setDob(null);
		}
		else {
			userRegistrationImpl.setDob(new Date(dob));
		}

		if (gender == null) {
			userRegistrationImpl.setGender("");
		}
		else {
			userRegistrationImpl.setGender(gender);
		}

		if (maritalStatus == null) {
			userRegistrationImpl.setMaritalStatus("");
		}
		else {
			userRegistrationImpl.setMaritalStatus(maritalStatus);
		}

		if (residenceStatus == null) {
			userRegistrationImpl.setResidenceStatus("");
		}
		else {
			userRegistrationImpl.setResidenceStatus(residenceStatus);
		}

		userRegistrationImpl.setStayPeriod(stayPeriod);
		userRegistrationImpl.setKnowAXAFrom(knowAXAFrom);

		if (knowAXAFromOther == null) {
			userRegistrationImpl.setKnowAXAFromOther("");
		}
		else {
			userRegistrationImpl.setKnowAXAFromOther(knowAXAFromOther);
		}

		if (joinReason == null) {
			userRegistrationImpl.setJoinReason("");
		}
		else {
			userRegistrationImpl.setJoinReason(joinReason);
		}

		if (bankName == null) {
			userRegistrationImpl.setBankName("");
		}
		else {
			userRegistrationImpl.setBankName(bankName);
		}

		if (bankAccountName == null) {
			userRegistrationImpl.setBankAccountName("");
		}
		else {
			userRegistrationImpl.setBankAccountName(bankAccountName);
		}

		if (bankAccountNo == null) {
			userRegistrationImpl.setBankAccountNo("");
		}
		else {
			userRegistrationImpl.setBankAccountNo(bankAccountNo);
		}

		if (npwp == null) {
			userRegistrationImpl.setNpwp("");
		}
		else {
			userRegistrationImpl.setNpwp(npwp);
		}

		if (npwpName == null) {
			userRegistrationImpl.setNpwpName("");
		}
		else {
			userRegistrationImpl.setNpwpName(npwpName);
		}

		userRegistrationImpl.setPortfolioFire(portfolioFire);
		userRegistrationImpl.setPortfolioMotor(portfolioMotor);
		userRegistrationImpl.setPortfolioMarine(portfolioMarine);
		userRegistrationImpl.setPortfolioHealth(portfolioHealth);
		userRegistrationImpl.setPortfolioOther(portfolioOther);
		userRegistrationImpl.setTargetFire(targetFire);
		userRegistrationImpl.setTargetMotor(targetMotor);
		userRegistrationImpl.setTargetMarine(targetMarine);
		userRegistrationImpl.setTargetHealth(targetHealth);
		userRegistrationImpl.setTargetOther(targetOther);
		userRegistrationImpl.setAnnualPremiIncome(annualPremiIncome);
		userRegistrationImpl.setTargetCase(targetCase);
		userRegistrationImpl.setTargetPremi(targetPremi);

		if (prospectSource == null) {
			userRegistrationImpl.setProspectSource("");
		}
		else {
			userRegistrationImpl.setProspectSource(prospectSource);
		}

		userRegistrationImpl.setOtherInsuranceJob(otherInsuranceJob);
		userRegistrationImpl.setTnc(tnc);
		userRegistrationImpl.setAgentAFI(agentAFI);
		userRegistrationImpl.setSentToMAS(sentToMAS);
		userRegistrationImpl.setApproved(approved);
		userRegistrationImpl.setActive(active);
		userRegistrationImpl.setGroupId(groupId);
		userRegistrationImpl.setCompanyId(companyId);
		userRegistrationImpl.setUserId(userId);

		if (userName == null) {
			userRegistrationImpl.setUserName("");
		}
		else {
			userRegistrationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userRegistrationImpl.setCreateDate(null);
		}
		else {
			userRegistrationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userRegistrationImpl.setModifiedDate(null);
		}
		else {
			userRegistrationImpl.setModifiedDate(new Date(modifiedDate));
		}

		userRegistrationImpl.resetOriginalValues();

		return userRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRegistrationId = objectInput.readLong();
		name = objectInput.readUTF();
		idNumber = objectInput.readUTF();
		licenseNumber = objectInput.readUTF();
		address = objectInput.readUTF();
		postalAddress = objectInput.readUTF();
		province = objectInput.readUTF();
		city = objectInput.readUTF();
		zip = objectInput.readUTF();
		phone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		email = objectInput.readUTF();
		birthPlace = objectInput.readUTF();
		dob = objectInput.readLong();
		gender = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();
		residenceStatus = objectInput.readUTF();

		stayPeriod = objectInput.readInt();

		knowAXAFrom = objectInput.readInt();
		knowAXAFromOther = objectInput.readUTF();
		joinReason = objectInput.readUTF();
		bankName = objectInput.readUTF();
		bankAccountName = objectInput.readUTF();
		bankAccountNo = objectInput.readUTF();
		npwp = objectInput.readUTF();
		npwpName = objectInput.readUTF();

		portfolioFire = objectInput.readInt();

		portfolioMotor = objectInput.readInt();

		portfolioMarine = objectInput.readInt();

		portfolioHealth = objectInput.readInt();

		portfolioOther = objectInput.readInt();

		targetFire = objectInput.readInt();

		targetMotor = objectInput.readInt();

		targetMarine = objectInput.readInt();

		targetHealth = objectInput.readInt();

		targetOther = objectInput.readInt();

		annualPremiIncome = objectInput.readLong();

		targetCase = objectInput.readInt();

		targetPremi = objectInput.readLong();
		prospectSource = objectInput.readUTF();

		otherInsuranceJob = objectInput.readInt();

		tnc = objectInput.readInt();

		agentAFI = objectInput.readInt();

		sentToMAS = objectInput.readInt();

		approved = objectInput.readInt();

		active = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userRegistrationId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (idNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idNumber);
		}

		if (licenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseNumber);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (postalAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postalAddress);
		}

		if (province == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(province);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (zip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zip);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (birthPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(birthPlace);
		}

		objectOutput.writeLong(dob);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		if (residenceStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(residenceStatus);
		}

		objectOutput.writeInt(stayPeriod);

		objectOutput.writeInt(knowAXAFrom);

		if (knowAXAFromOther == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(knowAXAFromOther);
		}

		if (joinReason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(joinReason);
		}

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (bankAccountName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankAccountName);
		}

		if (bankAccountNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankAccountNo);
		}

		if (npwp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(npwp);
		}

		if (npwpName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(npwpName);
		}

		objectOutput.writeInt(portfolioFire);

		objectOutput.writeInt(portfolioMotor);

		objectOutput.writeInt(portfolioMarine);

		objectOutput.writeInt(portfolioHealth);

		objectOutput.writeInt(portfolioOther);

		objectOutput.writeInt(targetFire);

		objectOutput.writeInt(targetMotor);

		objectOutput.writeInt(targetMarine);

		objectOutput.writeInt(targetHealth);

		objectOutput.writeInt(targetOther);

		objectOutput.writeLong(annualPremiIncome);

		objectOutput.writeInt(targetCase);

		objectOutput.writeLong(targetPremi);

		if (prospectSource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prospectSource);
		}

		objectOutput.writeInt(otherInsuranceJob);

		objectOutput.writeInt(tnc);

		objectOutput.writeInt(agentAFI);

		objectOutput.writeInt(sentToMAS);

		objectOutput.writeInt(approved);

		objectOutput.writeInt(active);

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
	}

	public long userRegistrationId;
	public String name;
	public String idNumber;
	public String licenseNumber;
	public String address;
	public String postalAddress;
	public String province;
	public String city;
	public String zip;
	public String phone;
	public String mobilePhone;
	public String email;
	public String birthPlace;
	public long dob;
	public String gender;
	public String maritalStatus;
	public String residenceStatus;
	public int stayPeriod;
	public int knowAXAFrom;
	public String knowAXAFromOther;
	public String joinReason;
	public String bankName;
	public String bankAccountName;
	public String bankAccountNo;
	public String npwp;
	public String npwpName;
	public int portfolioFire;
	public int portfolioMotor;
	public int portfolioMarine;
	public int portfolioHealth;
	public int portfolioOther;
	public int targetFire;
	public int targetMotor;
	public int targetMarine;
	public int targetHealth;
	public int targetOther;
	public long annualPremiIncome;
	public int targetCase;
	public long targetPremi;
	public String prospectSource;
	public int otherInsuranceJob;
	public int tnc;
	public int agentAFI;
	public int sentToMAS;
	public int approved;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}