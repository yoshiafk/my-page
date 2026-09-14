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

import com.mypage.leads.model.DetailDrive;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailDrive in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailDriveCacheModel
	implements CacheModel<DetailDrive>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailDriveCacheModel)) {
			return false;
		}

		DetailDriveCacheModel detailDriveCacheModel =
			(DetailDriveCacheModel)object;

		if (detailDriveId == detailDriveCacheModel.detailDriveId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, detailDriveId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(157);

		sb.append("{detailDriveId=");
		sb.append(detailDriveId);
		sb.append(", leadsId=");
		sb.append(leadsId);
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
		sb.append(", vehicleCode=");
		sb.append(vehicleCode);
		sb.append(", VehicleManufacture=");
		sb.append(VehicleManufacture);
		sb.append(", vehicleModel=");
		sb.append(vehicleModel);
		sb.append(", vehicleSubModel=");
		sb.append(vehicleSubModel);
		sb.append(", vehicleBody=");
		sb.append(vehicleBody);
		sb.append(", manufactureYear=");
		sb.append(manufactureYear);
		sb.append(", manufactureAge=");
		sb.append(manufactureAge);
		sb.append(", coverageType=");
		sb.append(coverageType);
		sb.append(", vehicleType=");
		sb.append(vehicleType);
		sb.append(", typeOfUse=");
		sb.append(typeOfUse);
		sb.append(", vehicleInsured=");
		sb.append(vehicleInsured);
		sb.append(", accessoriesInsured=");
		sb.append(accessoriesInsured);
		sb.append(", sumInsured=");
		sb.append(sumInsured);
		sb.append(", regionPlate=");
		sb.append(regionPlate);
		sb.append(", cc=");
		sb.append(cc);
		sb.append(", make=");
		sb.append(make);
		sb.append(", dpg=");
		sb.append(dpg);
		sb.append(", seatCapacity=");
		sb.append(seatCapacity);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", commercialOffers=");
		sb.append(commercialOffers);
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
		sb.append(", policeNumber=");
		sb.append(policeNumber);
		sb.append(", chassisNumber=");
		sb.append(chassisNumber);
		sb.append(", engineNumber=");
		sb.append(engineNumber);
		sb.append(", policyNumber=");
		sb.append(policyNumber);
		sb.append(", referenceNumber=");
		sb.append(referenceNumber);
		sb.append(", policyStatus=");
		sb.append(policyStatus);
		sb.append(", currency=");
		sb.append(currency);
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
		sb.append(", commission=");
		sb.append(commission);
		sb.append(", leads=");
		sb.append(leads);
		sb.append(", transactionId=");
		sb.append(transactionId);
		sb.append(", bussinesModel=");
		sb.append(bussinesModel);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", promoCode=");
		sb.append(promoCode);
		sb.append(", step1=");
		sb.append(step1);
		sb.append(", step2=");
		sb.append(step2);
		sb.append(", step3=");
		sb.append(step3);
		sb.append(", dailyReportStatus=");
		sb.append(dailyReportStatus);
		sb.append(", dailyReportFile=");
		sb.append(dailyReportFile);
		sb.append(", dailyReportAgentStatus=");
		sb.append(dailyReportAgentStatus);
		sb.append(", dailyReportAgentFile=");
		sb.append(dailyReportAgentFile);
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
		sb.append(", managedBy=");
		sb.append(managedBy);
		sb.append(", agentCode=");
		sb.append(agentCode);
		sb.append(", subAgent=");
		sb.append(subAgent);
		sb.append(", marketingCode=");
		sb.append(marketingCode);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DetailDrive toEntityModel() {
		DetailDriveImpl detailDriveImpl = new DetailDriveImpl();

		detailDriveImpl.setDetailDriveId(detailDriveId);
		detailDriveImpl.setLeadsId(leadsId);
		detailDriveImpl.setGroupId(groupId);
		detailDriveImpl.setCompanyId(companyId);
		detailDriveImpl.setUserId(userId);

		if (userName == null) {
			detailDriveImpl.setUserName("");
		}
		else {
			detailDriveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailDriveImpl.setCreateDate(null);
		}
		else {
			detailDriveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailDriveImpl.setModifiedDate(null);
		}
		else {
			detailDriveImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (vehicleCode == null) {
			detailDriveImpl.setVehicleCode("");
		}
		else {
			detailDriveImpl.setVehicleCode(vehicleCode);
		}

		if (VehicleManufacture == null) {
			detailDriveImpl.setVehicleManufacture("");
		}
		else {
			detailDriveImpl.setVehicleManufacture(VehicleManufacture);
		}

		if (vehicleModel == null) {
			detailDriveImpl.setVehicleModel("");
		}
		else {
			detailDriveImpl.setVehicleModel(vehicleModel);
		}

		if (vehicleSubModel == null) {
			detailDriveImpl.setVehicleSubModel("");
		}
		else {
			detailDriveImpl.setVehicleSubModel(vehicleSubModel);
		}

		if (vehicleBody == null) {
			detailDriveImpl.setVehicleBody("");
		}
		else {
			detailDriveImpl.setVehicleBody(vehicleBody);
		}

		detailDriveImpl.setManufactureYear(manufactureYear);
		detailDriveImpl.setManufactureAge(manufactureAge);

		if (coverageType == null) {
			detailDriveImpl.setCoverageType("");
		}
		else {
			detailDriveImpl.setCoverageType(coverageType);
		}

		if (vehicleType == null) {
			detailDriveImpl.setVehicleType("");
		}
		else {
			detailDriveImpl.setVehicleType(vehicleType);
		}

		if (typeOfUse == null) {
			detailDriveImpl.setTypeOfUse("");
		}
		else {
			detailDriveImpl.setTypeOfUse(typeOfUse);
		}

		detailDriveImpl.setVehicleInsured(vehicleInsured);
		detailDriveImpl.setAccessoriesInsured(accessoriesInsured);
		detailDriveImpl.setSumInsured(sumInsured);

		if (regionPlate == null) {
			detailDriveImpl.setRegionPlate("");
		}
		else {
			detailDriveImpl.setRegionPlate(regionPlate);
		}

		detailDriveImpl.setCc(cc);

		if (make == null) {
			detailDriveImpl.setMake("");
		}
		else {
			detailDriveImpl.setMake(make);
		}

		if (dpg == null) {
			detailDriveImpl.setDpg("");
		}
		else {
			detailDriveImpl.setDpg(dpg);
		}

		detailDriveImpl.setSeatCapacity(seatCapacity);

		if (startDate == Long.MIN_VALUE) {
			detailDriveImpl.setStartDate(null);
		}
		else {
			detailDriveImpl.setStartDate(new Date(startDate));
		}

		if (expiredDate == Long.MIN_VALUE) {
			detailDriveImpl.setExpiredDate(null);
		}
		else {
			detailDriveImpl.setExpiredDate(new Date(expiredDate));
		}

		detailDriveImpl.setCommercialOffers(commercialOffers);

		if (name == null) {
			detailDriveImpl.setName("");
		}
		else {
			detailDriveImpl.setName(name);
		}

		if (birthPlace == null) {
			detailDriveImpl.setBirthPlace("");
		}
		else {
			detailDriveImpl.setBirthPlace(birthPlace);
		}

		if (dob == Long.MIN_VALUE) {
			detailDriveImpl.setDob(null);
		}
		else {
			detailDriveImpl.setDob(new Date(dob));
		}

		if (nationality == null) {
			detailDriveImpl.setNationality("");
		}
		else {
			detailDriveImpl.setNationality(nationality);
		}

		if (idNumber == null) {
			detailDriveImpl.setIdNumber("");
		}
		else {
			detailDriveImpl.setIdNumber(idNumber);
		}

		if (passportNumber == null) {
			detailDriveImpl.setPassportNumber("");
		}
		else {
			detailDriveImpl.setPassportNumber(passportNumber);
		}

		if (kitasNumber == null) {
			detailDriveImpl.setKitasNumber("");
		}
		else {
			detailDriveImpl.setKitasNumber(kitasNumber);
		}

		if (mobilePhone == null) {
			detailDriveImpl.setMobilePhone("");
		}
		else {
			detailDriveImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			detailDriveImpl.setEmail("");
		}
		else {
			detailDriveImpl.setEmail(email);
		}

		if (address == null) {
			detailDriveImpl.setAddress("");
		}
		else {
			detailDriveImpl.setAddress(address);
		}

		if (address2 == null) {
			detailDriveImpl.setAddress2("");
		}
		else {
			detailDriveImpl.setAddress2(address2);
		}

		if (province == null) {
			detailDriveImpl.setProvince("");
		}
		else {
			detailDriveImpl.setProvince(province);
		}

		if (city == null) {
			detailDriveImpl.setCity("");
		}
		else {
			detailDriveImpl.setCity(city);
		}

		if (policeNumber == null) {
			detailDriveImpl.setPoliceNumber("");
		}
		else {
			detailDriveImpl.setPoliceNumber(policeNumber);
		}

		if (chassisNumber == null) {
			detailDriveImpl.setChassisNumber("");
		}
		else {
			detailDriveImpl.setChassisNumber(chassisNumber);
		}

		if (engineNumber == null) {
			detailDriveImpl.setEngineNumber("");
		}
		else {
			detailDriveImpl.setEngineNumber(engineNumber);
		}

		if (policyNumber == null) {
			detailDriveImpl.setPolicyNumber("");
		}
		else {
			detailDriveImpl.setPolicyNumber(policyNumber);
		}

		if (referenceNumber == null) {
			detailDriveImpl.setReferenceNumber("");
		}
		else {
			detailDriveImpl.setReferenceNumber(referenceNumber);
		}

		if (policyStatus == null) {
			detailDriveImpl.setPolicyStatus("");
		}
		else {
			detailDriveImpl.setPolicyStatus(policyStatus);
		}

		if (currency == null) {
			detailDriveImpl.setCurrency("");
		}
		else {
			detailDriveImpl.setCurrency(currency);
		}

		detailDriveImpl.setPolicyCost(policyCost);
		detailDriveImpl.setStampDuty(stampDuty);
		detailDriveImpl.setPremium(premium);
		detailDriveImpl.setNetPremium(netPremium);
		detailDriveImpl.setDiscount(discount);

		if (commission == null) {
			detailDriveImpl.setCommission("");
		}
		else {
			detailDriveImpl.setCommission(commission);
		}

		detailDriveImpl.setLeads(leads);

		if (transactionId == null) {
			detailDriveImpl.setTransactionId("");
		}
		else {
			detailDriveImpl.setTransactionId(transactionId);
		}

		if (bussinesModel == null) {
			detailDriveImpl.setBussinesModel("");
		}
		else {
			detailDriveImpl.setBussinesModel(bussinesModel);
		}

		if (channel == null) {
			detailDriveImpl.setChannel("");
		}
		else {
			detailDriveImpl.setChannel(channel);
		}

		if (promoCode == null) {
			detailDriveImpl.setPromoCode("");
		}
		else {
			detailDriveImpl.setPromoCode(promoCode);
		}

		detailDriveImpl.setStep1(step1);
		detailDriveImpl.setStep2(step2);
		detailDriveImpl.setStep3(step3);
		detailDriveImpl.setDailyReportStatus(dailyReportStatus);
		detailDriveImpl.setDailyReportFile(dailyReportFile);
		detailDriveImpl.setDailyReportAgentStatus(dailyReportAgentStatus);
		detailDriveImpl.setDailyReportAgentFile(dailyReportAgentFile);

		if (utmSource == null) {
			detailDriveImpl.setUtmSource("");
		}
		else {
			detailDriveImpl.setUtmSource(utmSource);
		}

		if (utmMedium == null) {
			detailDriveImpl.setUtmMedium("");
		}
		else {
			detailDriveImpl.setUtmMedium(utmMedium);
		}

		if (utmCampaign == null) {
			detailDriveImpl.setUtmCampaign("");
		}
		else {
			detailDriveImpl.setUtmCampaign(utmCampaign);
		}

		if (utmTerm == null) {
			detailDriveImpl.setUtmTerm("");
		}
		else {
			detailDriveImpl.setUtmTerm(utmTerm);
		}

		if (utmContent == null) {
			detailDriveImpl.setUtmContent("");
		}
		else {
			detailDriveImpl.setUtmContent(utmContent);
		}

		if (clickId == null) {
			detailDriveImpl.setClickId("");
		}
		else {
			detailDriveImpl.setClickId(clickId);
		}

		detailDriveImpl.setManagedBy(managedBy);

		if (agentCode == null) {
			detailDriveImpl.setAgentCode("");
		}
		else {
			detailDriveImpl.setAgentCode(agentCode);
		}

		detailDriveImpl.setSubAgent(subAgent);

		if (marketingCode == null) {
			detailDriveImpl.setMarketingCode("");
		}
		else {
			detailDriveImpl.setMarketingCode(marketingCode);
		}

		detailDriveImpl.setActive(active);

		detailDriveImpl.resetOriginalValues();

		return detailDriveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		detailDriveId = objectInput.readLong();

		leadsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		vehicleCode = objectInput.readUTF();
		VehicleManufacture = objectInput.readUTF();
		vehicleModel = objectInput.readUTF();
		vehicleSubModel = objectInput.readUTF();
		vehicleBody = objectInput.readUTF();

		manufactureYear = objectInput.readInt();

		manufactureAge = objectInput.readInt();
		coverageType = objectInput.readUTF();
		vehicleType = objectInput.readUTF();
		typeOfUse = objectInput.readUTF();

		vehicleInsured = objectInput.readDouble();

		accessoriesInsured = objectInput.readDouble();

		sumInsured = objectInput.readDouble();
		regionPlate = objectInput.readUTF();

		cc = objectInput.readInt();
		make = objectInput.readUTF();
		dpg = objectInput.readUTF();

		seatCapacity = objectInput.readInt();
		startDate = objectInput.readLong();
		expiredDate = objectInput.readLong();

		commercialOffers = objectInput.readInt();
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
		policeNumber = objectInput.readUTF();
		chassisNumber = objectInput.readUTF();
		engineNumber = objectInput.readUTF();
		policyNumber = objectInput.readUTF();
		referenceNumber = objectInput.readUTF();
		policyStatus = objectInput.readUTF();
		currency = objectInput.readUTF();

		policyCost = objectInput.readDouble();

		stampDuty = objectInput.readDouble();

		premium = objectInput.readDouble();

		netPremium = objectInput.readDouble();

		discount = objectInput.readInt();
		commission = objectInput.readUTF();

		leads = objectInput.readLong();
		transactionId = objectInput.readUTF();
		bussinesModel = objectInput.readUTF();
		channel = objectInput.readUTF();
		promoCode = objectInput.readUTF();

		step1 = objectInput.readInt();

		step2 = objectInput.readInt();

		step3 = objectInput.readInt();

		dailyReportStatus = objectInput.readInt();

		dailyReportFile = objectInput.readLong();

		dailyReportAgentStatus = objectInput.readInt();

		dailyReportAgentFile = objectInput.readLong();
		utmSource = objectInput.readUTF();
		utmMedium = objectInput.readUTF();
		utmCampaign = objectInput.readUTF();
		utmTerm = objectInput.readUTF();
		utmContent = objectInput.readUTF();
		clickId = objectInput.readUTF();

		managedBy = objectInput.readLong();
		agentCode = objectInput.readUTF();

		subAgent = objectInput.readLong();
		marketingCode = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(detailDriveId);

		objectOutput.writeLong(leadsId);

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

		if (vehicleCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleCode);
		}

		if (VehicleManufacture == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(VehicleManufacture);
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

		if (vehicleBody == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleBody);
		}

		objectOutput.writeInt(manufactureYear);

		objectOutput.writeInt(manufactureAge);

		if (coverageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverageType);
		}

		if (vehicleType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleType);
		}

		if (typeOfUse == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeOfUse);
		}

		objectOutput.writeDouble(vehicleInsured);

		objectOutput.writeDouble(accessoriesInsured);

		objectOutput.writeDouble(sumInsured);

		if (regionPlate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(regionPlate);
		}

		objectOutput.writeInt(cc);

		if (make == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(make);
		}

		if (dpg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dpg);
		}

		objectOutput.writeInt(seatCapacity);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(expiredDate);

		objectOutput.writeInt(commercialOffers);

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

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeDouble(policyCost);

		objectOutput.writeDouble(stampDuty);

		objectOutput.writeDouble(premium);

		objectOutput.writeDouble(netPremium);

		objectOutput.writeInt(discount);

		if (commission == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commission);
		}

		objectOutput.writeLong(leads);

		if (transactionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(transactionId);
		}

		if (bussinesModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bussinesModel);
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

		objectOutput.writeInt(step2);

		objectOutput.writeInt(step3);

		objectOutput.writeInt(dailyReportStatus);

		objectOutput.writeLong(dailyReportFile);

		objectOutput.writeInt(dailyReportAgentStatus);

		objectOutput.writeLong(dailyReportAgentFile);

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

		objectOutput.writeInt(active);
	}

	public long detailDriveId;
	public long leadsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String vehicleCode;
	public String VehicleManufacture;
	public String vehicleModel;
	public String vehicleSubModel;
	public String vehicleBody;
	public int manufactureYear;
	public int manufactureAge;
	public String coverageType;
	public String vehicleType;
	public String typeOfUse;
	public double vehicleInsured;
	public double accessoriesInsured;
	public double sumInsured;
	public String regionPlate;
	public int cc;
	public String make;
	public String dpg;
	public int seatCapacity;
	public long startDate;
	public long expiredDate;
	public int commercialOffers;
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
	public String policeNumber;
	public String chassisNumber;
	public String engineNumber;
	public String policyNumber;
	public String referenceNumber;
	public String policyStatus;
	public String currency;
	public double policyCost;
	public double stampDuty;
	public double premium;
	public double netPremium;
	public int discount;
	public String commission;
	public long leads;
	public String transactionId;
	public String bussinesModel;
	public String channel;
	public String promoCode;
	public int step1;
	public int step2;
	public int step3;
	public int dailyReportStatus;
	public long dailyReportFile;
	public int dailyReportAgentStatus;
	public long dailyReportAgentFile;
	public String utmSource;
	public String utmMedium;
	public String utmCampaign;
	public String utmTerm;
	public String utmContent;
	public String clickId;
	public long managedBy;
	public String agentCode;
	public long subAgent;
	public String marketingCode;
	public int active;

}