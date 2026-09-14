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

import com.mypage.leads.model.DetailTlp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailTlp in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailTlpCacheModel
	implements CacheModel<DetailTlp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailTlpCacheModel)) {
			return false;
		}

		DetailTlpCacheModel detailTlpCacheModel = (DetailTlpCacheModel)object;

		if (detailTlpId == detailTlpCacheModel.detailTlpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, detailTlpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(139);

		sb.append("{detailTlpId=");
		sb.append(detailTlpId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", mainPolicyStartDate=");
		sb.append(mainPolicyStartDate);
		sb.append(", mainPolicyEndDate=");
		sb.append(mainPolicyEndDate);
		sb.append(", numberOfDays=");
		sb.append(numberOfDays);
		sb.append(", name=");
		sb.append(name);
		sb.append(", birthPlace=");
		sb.append(birthPlace);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", idNumber=");
		sb.append(idNumber);
		sb.append(", passportNumber=");
		sb.append(passportNumber);
		sb.append(", kitasNumber=");
		sb.append(kitasNumber);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", province=");
		sb.append(province);
		sb.append(", city=");
		sb.append(city);
		sb.append(", postCode=");
		sb.append(postCode);
		sb.append(", commercialOffer=");
		sb.append(commercialOffer);
		sb.append(", driveModel=");
		sb.append(driveModel);
		sb.append(", vehicleManufacture=");
		sb.append(vehicleManufacture);
		sb.append(", vehicleModel=");
		sb.append(vehicleModel);
		sb.append(", vehicleSubModel=");
		sb.append(vehicleSubModel);
		sb.append(", manufactureYear=");
		sb.append(manufactureYear);
		sb.append(", vehicleInsured=");
		sb.append(vehicleInsured);
		sb.append(", regionPlate=");
		sb.append(regionPlate);
		sb.append(", policeNumber=");
		sb.append(policeNumber);
		sb.append(", chassisNumber=");
		sb.append(chassisNumber);
		sb.append(", engineNumber=");
		sb.append(engineNumber);
		sb.append(", leadsId=");
		sb.append(leadsId);
		sb.append(", transactionId_=");
		sb.append(transactionId_);
		sb.append(", businessModel=");
		sb.append(businessModel);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", promoCode=");
		sb.append(promoCode);
		sb.append(", step1=");
		sb.append(step1);
		sb.append(", policyNumber=");
		sb.append(policyNumber);
		sb.append(", referenceNumber=");
		sb.append(referenceNumber);
		sb.append(", policyStatus=");
		sb.append(policyStatus);
		sb.append(", packageName=");
		sb.append(packageName);
		sb.append(", packageInfo=");
		sb.append(packageInfo);
		sb.append(", rate=");
		sb.append(rate);
		sb.append(", currency_=");
		sb.append(currency_);
		sb.append(", sumInsured=");
		sb.append(sumInsured);
		sb.append(", policyCost=");
		sb.append(policyCost);
		sb.append(", stampDuty=");
		sb.append(stampDuty);
		sb.append(", premium=");
		sb.append(premium);
		sb.append(", netPremium=");
		sb.append(netPremium);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", commision=");
		sb.append(commision);
		sb.append(", insuranceName=");
		sb.append(insuranceName);
		sb.append(", insurancePolicyNo=");
		sb.append(insurancePolicyNo);
		sb.append(", managedBy=");
		sb.append(managedBy);
		sb.append(", agentCode=");
		sb.append(agentCode);
		sb.append(", subAgent=");
		sb.append(subAgent);
		sb.append(", marketingCode=");
		sb.append(marketingCode);
		sb.append(", utmSource=");
		sb.append(utmSource);
		sb.append(", utmMedium=");
		sb.append(utmMedium);
		sb.append(", utmCampaign=");
		sb.append(utmCampaign);
		sb.append(", utmTerm=");
		sb.append(utmTerm);
		sb.append(", utmContent=");
		sb.append(utmContent);
		sb.append(", clickId=");
		sb.append(clickId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DetailTlp toEntityModel() {
		DetailTlpImpl detailTlpImpl = new DetailTlpImpl();

		detailTlpImpl.setDetailTlpId(detailTlpId);
		detailTlpImpl.setGroupId(groupId);
		detailTlpImpl.setCompanyId(companyId);
		detailTlpImpl.setUserId(userId);

		if (userName == null) {
			detailTlpImpl.setUserName("");
		}
		else {
			detailTlpImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailTlpImpl.setCreateDate(null);
		}
		else {
			detailTlpImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailTlpImpl.setModifiedDate(null);
		}
		else {
			detailTlpImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startDate == Long.MIN_VALUE) {
			detailTlpImpl.setStartDate(null);
		}
		else {
			detailTlpImpl.setStartDate(new Date(startDate));
		}

		if (expiredDate == Long.MIN_VALUE) {
			detailTlpImpl.setExpiredDate(null);
		}
		else {
			detailTlpImpl.setExpiredDate(new Date(expiredDate));
		}

		if (mainPolicyStartDate == Long.MIN_VALUE) {
			detailTlpImpl.setMainPolicyStartDate(null);
		}
		else {
			detailTlpImpl.setMainPolicyStartDate(new Date(mainPolicyStartDate));
		}

		if (mainPolicyEndDate == Long.MIN_VALUE) {
			detailTlpImpl.setMainPolicyEndDate(null);
		}
		else {
			detailTlpImpl.setMainPolicyEndDate(new Date(mainPolicyEndDate));
		}

		detailTlpImpl.setNumberOfDays(numberOfDays);

		if (name == null) {
			detailTlpImpl.setName("");
		}
		else {
			detailTlpImpl.setName(name);
		}

		if (birthPlace == null) {
			detailTlpImpl.setBirthPlace("");
		}
		else {
			detailTlpImpl.setBirthPlace(birthPlace);
		}

		if (dob == Long.MIN_VALUE) {
			detailTlpImpl.setDob(null);
		}
		else {
			detailTlpImpl.setDob(new Date(dob));
		}

		if (nationality == null) {
			detailTlpImpl.setNationality("");
		}
		else {
			detailTlpImpl.setNationality(nationality);
		}

		if (idNumber == null) {
			detailTlpImpl.setIdNumber("");
		}
		else {
			detailTlpImpl.setIdNumber(idNumber);
		}

		if (passportNumber == null) {
			detailTlpImpl.setPassportNumber("");
		}
		else {
			detailTlpImpl.setPassportNumber(passportNumber);
		}

		if (kitasNumber == null) {
			detailTlpImpl.setKitasNumber("");
		}
		else {
			detailTlpImpl.setKitasNumber(kitasNumber);
		}

		if (mobilePhone == null) {
			detailTlpImpl.setMobilePhone("");
		}
		else {
			detailTlpImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			detailTlpImpl.setEmail("");
		}
		else {
			detailTlpImpl.setEmail(email);
		}

		if (address == null) {
			detailTlpImpl.setAddress("");
		}
		else {
			detailTlpImpl.setAddress(address);
		}

		if (address2 == null) {
			detailTlpImpl.setAddress2("");
		}
		else {
			detailTlpImpl.setAddress2(address2);
		}

		if (province == null) {
			detailTlpImpl.setProvince("");
		}
		else {
			detailTlpImpl.setProvince(province);
		}

		if (city == null) {
			detailTlpImpl.setCity("");
		}
		else {
			detailTlpImpl.setCity(city);
		}

		if (postCode == null) {
			detailTlpImpl.setPostCode("");
		}
		else {
			detailTlpImpl.setPostCode(postCode);
		}

		detailTlpImpl.setCommercialOffer(commercialOffer);
		detailTlpImpl.setDriveModel(driveModel);

		if (vehicleManufacture == null) {
			detailTlpImpl.setVehicleManufacture("");
		}
		else {
			detailTlpImpl.setVehicleManufacture(vehicleManufacture);
		}

		if (vehicleModel == null) {
			detailTlpImpl.setVehicleModel("");
		}
		else {
			detailTlpImpl.setVehicleModel(vehicleModel);
		}

		if (vehicleSubModel == null) {
			detailTlpImpl.setVehicleSubModel("");
		}
		else {
			detailTlpImpl.setVehicleSubModel(vehicleSubModel);
		}

		detailTlpImpl.setManufactureYear(manufactureYear);
		detailTlpImpl.setVehicleInsured(vehicleInsured);

		if (regionPlate == null) {
			detailTlpImpl.setRegionPlate("");
		}
		else {
			detailTlpImpl.setRegionPlate(regionPlate);
		}

		if (policeNumber == null) {
			detailTlpImpl.setPoliceNumber("");
		}
		else {
			detailTlpImpl.setPoliceNumber(policeNumber);
		}

		if (chassisNumber == null) {
			detailTlpImpl.setChassisNumber("");
		}
		else {
			detailTlpImpl.setChassisNumber(chassisNumber);
		}

		if (engineNumber == null) {
			detailTlpImpl.setEngineNumber("");
		}
		else {
			detailTlpImpl.setEngineNumber(engineNumber);
		}

		detailTlpImpl.setLeadsId(leadsId);
		detailTlpImpl.setTransactionId_(transactionId_);

		if (businessModel == null) {
			detailTlpImpl.setBusinessModel("");
		}
		else {
			detailTlpImpl.setBusinessModel(businessModel);
		}

		if (channel == null) {
			detailTlpImpl.setChannel("");
		}
		else {
			detailTlpImpl.setChannel(channel);
		}

		if (promoCode == null) {
			detailTlpImpl.setPromoCode("");
		}
		else {
			detailTlpImpl.setPromoCode(promoCode);
		}

		detailTlpImpl.setStep1(step1);

		if (policyNumber == null) {
			detailTlpImpl.setPolicyNumber("");
		}
		else {
			detailTlpImpl.setPolicyNumber(policyNumber);
		}

		if (referenceNumber == null) {
			detailTlpImpl.setReferenceNumber("");
		}
		else {
			detailTlpImpl.setReferenceNumber(referenceNumber);
		}

		if (policyStatus == null) {
			detailTlpImpl.setPolicyStatus("");
		}
		else {
			detailTlpImpl.setPolicyStatus(policyStatus);
		}

		if (packageName == null) {
			detailTlpImpl.setPackageName("");
		}
		else {
			detailTlpImpl.setPackageName(packageName);
		}

		detailTlpImpl.setPackageInfo(packageInfo);
		detailTlpImpl.setRate(rate);

		if (currency_ == null) {
			detailTlpImpl.setCurrency_("");
		}
		else {
			detailTlpImpl.setCurrency_(currency_);
		}

		detailTlpImpl.setSumInsured(sumInsured);
		detailTlpImpl.setPolicyCost(policyCost);
		detailTlpImpl.setStampDuty(stampDuty);
		detailTlpImpl.setPremium(premium);
		detailTlpImpl.setNetPremium(netPremium);
		detailTlpImpl.setDiscount(discount);
		detailTlpImpl.setCommision(commision);

		if (insuranceName == null) {
			detailTlpImpl.setInsuranceName("");
		}
		else {
			detailTlpImpl.setInsuranceName(insuranceName);
		}

		if (insurancePolicyNo == null) {
			detailTlpImpl.setInsurancePolicyNo("");
		}
		else {
			detailTlpImpl.setInsurancePolicyNo(insurancePolicyNo);
		}

		detailTlpImpl.setManagedBy(managedBy);

		if (agentCode == null) {
			detailTlpImpl.setAgentCode("");
		}
		else {
			detailTlpImpl.setAgentCode(agentCode);
		}

		detailTlpImpl.setSubAgent(subAgent);

		if (marketingCode == null) {
			detailTlpImpl.setMarketingCode("");
		}
		else {
			detailTlpImpl.setMarketingCode(marketingCode);
		}

		if (utmSource == null) {
			detailTlpImpl.setUtmSource("");
		}
		else {
			detailTlpImpl.setUtmSource(utmSource);
		}

		if (utmMedium == null) {
			detailTlpImpl.setUtmMedium("");
		}
		else {
			detailTlpImpl.setUtmMedium(utmMedium);
		}

		if (utmCampaign == null) {
			detailTlpImpl.setUtmCampaign("");
		}
		else {
			detailTlpImpl.setUtmCampaign(utmCampaign);
		}

		if (utmTerm == null) {
			detailTlpImpl.setUtmTerm("");
		}
		else {
			detailTlpImpl.setUtmTerm(utmTerm);
		}

		if (utmContent == null) {
			detailTlpImpl.setUtmContent("");
		}
		else {
			detailTlpImpl.setUtmContent(utmContent);
		}

		if (clickId == null) {
			detailTlpImpl.setClickId("");
		}
		else {
			detailTlpImpl.setClickId(clickId);
		}

		detailTlpImpl.resetOriginalValues();

		return detailTlpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		detailTlpId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		startDate = objectInput.readLong();
		expiredDate = objectInput.readLong();
		mainPolicyStartDate = objectInput.readLong();
		mainPolicyEndDate = objectInput.readLong();

		numberOfDays = objectInput.readInt();
		name = objectInput.readUTF();
		birthPlace = objectInput.readUTF();
		dob = objectInput.readLong();
		nationality = objectInput.readUTF();
		idNumber = objectInput.readUTF();
		passportNumber = objectInput.readUTF();
		kitasNumber = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		address2 = objectInput.readUTF();
		province = objectInput.readUTF();
		city = objectInput.readUTF();
		postCode = objectInput.readUTF();

		commercialOffer = objectInput.readInt();

		driveModel = objectInput.readLong();
		vehicleManufacture = objectInput.readUTF();
		vehicleModel = objectInput.readUTF();
		vehicleSubModel = objectInput.readUTF();

		manufactureYear = objectInput.readInt();

		vehicleInsured = objectInput.readDouble();
		regionPlate = objectInput.readUTF();
		policeNumber = objectInput.readUTF();
		chassisNumber = objectInput.readUTF();
		engineNumber = objectInput.readUTF();

		leadsId = objectInput.readLong();

		transactionId_ = objectInput.readLong();
		businessModel = objectInput.readUTF();
		channel = objectInput.readUTF();
		promoCode = objectInput.readUTF();

		step1 = objectInput.readInt();
		policyNumber = objectInput.readUTF();
		referenceNumber = objectInput.readUTF();
		policyStatus = objectInput.readUTF();
		packageName = objectInput.readUTF();

		packageInfo = objectInput.readLong();

		rate = objectInput.readDouble();
		currency_ = objectInput.readUTF();

		sumInsured = objectInput.readDouble();

		policyCost = objectInput.readDouble();

		stampDuty = objectInput.readDouble();

		premium = objectInput.readDouble();

		netPremium = objectInput.readDouble();

		discount = objectInput.readDouble();

		commision = objectInput.readDouble();
		insuranceName = objectInput.readUTF();
		insurancePolicyNo = objectInput.readUTF();

		managedBy = objectInput.readLong();
		agentCode = objectInput.readUTF();

		subAgent = objectInput.readLong();
		marketingCode = objectInput.readUTF();
		utmSource = objectInput.readUTF();
		utmMedium = objectInput.readUTF();
		utmCampaign = objectInput.readUTF();
		utmTerm = objectInput.readUTF();
		utmContent = objectInput.readUTF();
		clickId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(detailTlpId);

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
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(expiredDate);
		objectOutput.writeLong(mainPolicyStartDate);
		objectOutput.writeLong(mainPolicyEndDate);

		objectOutput.writeInt(numberOfDays);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (birthPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(birthPlace);
		}

		objectOutput.writeLong(dob);

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (idNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idNumber);
		}

		if (passportNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passportNumber);
		}

		if (kitasNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kitasNumber);
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

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
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

		if (postCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postCode);
		}

		objectOutput.writeInt(commercialOffer);

		objectOutput.writeLong(driveModel);

		if (vehicleManufacture == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleManufacture);
		}

		if (vehicleModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleModel);
		}

		if (vehicleSubModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleSubModel);
		}

		objectOutput.writeInt(manufactureYear);

		objectOutput.writeDouble(vehicleInsured);

		if (regionPlate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(regionPlate);
		}

		if (policeNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policeNumber);
		}

		if (chassisNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chassisNumber);
		}

		if (engineNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(engineNumber);
		}

		objectOutput.writeLong(leadsId);

		objectOutput.writeLong(transactionId_);

		if (businessModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessModel);
		}

		if (channel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(channel);
		}

		if (promoCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoCode);
		}

		objectOutput.writeInt(step1);

		if (policyNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNumber);
		}

		if (referenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceNumber);
		}

		if (policyStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyStatus);
		}

		if (packageName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(packageName);
		}

		objectOutput.writeLong(packageInfo);

		objectOutput.writeDouble(rate);

		if (currency_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency_);
		}

		objectOutput.writeDouble(sumInsured);

		objectOutput.writeDouble(policyCost);

		objectOutput.writeDouble(stampDuty);

		objectOutput.writeDouble(premium);

		objectOutput.writeDouble(netPremium);

		objectOutput.writeDouble(discount);

		objectOutput.writeDouble(commision);

		if (insuranceName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuranceName);
		}

		if (insurancePolicyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insurancePolicyNo);
		}

		objectOutput.writeLong(managedBy);

		if (agentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agentCode);
		}

		objectOutput.writeLong(subAgent);

		if (marketingCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(marketingCode);
		}

		if (utmSource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmSource);
		}

		if (utmMedium == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmMedium);
		}

		if (utmCampaign == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmCampaign);
		}

		if (utmTerm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmTerm);
		}

		if (utmContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmContent);
		}

		if (clickId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clickId);
		}
	}

	public long detailTlpId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long startDate;
	public long expiredDate;
	public long mainPolicyStartDate;
	public long mainPolicyEndDate;
	public int numberOfDays;
	public String name;
	public String birthPlace;
	public long dob;
	public String nationality;
	public String idNumber;
	public String passportNumber;
	public String kitasNumber;
	public String mobilePhone;
	public String email;
	public String address;
	public String address2;
	public String province;
	public String city;
	public String postCode;
	public int commercialOffer;
	public long driveModel;
	public String vehicleManufacture;
	public String vehicleModel;
	public String vehicleSubModel;
	public int manufactureYear;
	public double vehicleInsured;
	public String regionPlate;
	public String policeNumber;
	public String chassisNumber;
	public String engineNumber;
	public long leadsId;
	public long transactionId_;
	public String businessModel;
	public String channel;
	public String promoCode;
	public int step1;
	public String policyNumber;
	public String referenceNumber;
	public String policyStatus;
	public String packageName;
	public long packageInfo;
	public double rate;
	public String currency_;
	public double sumInsured;
	public double policyCost;
	public double stampDuty;
	public double premium;
	public double netPremium;
	public double discount;
	public double commision;
	public String insuranceName;
	public String insurancePolicyNo;
	public long managedBy;
	public String agentCode;
	public long subAgent;
	public String marketingCode;
	public String utmSource;
	public String utmMedium;
	public String utmCampaign;
	public String utmTerm;
	public String utmContent;
	public String clickId;

}