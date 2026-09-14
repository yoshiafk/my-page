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

import com.mypage.leads.model.DetailHealthIndividu;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailHealthIndividu in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailHealthIndividuCacheModel
	implements CacheModel<DetailHealthIndividu>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailHealthIndividuCacheModel)) {
			return false;
		}

		DetailHealthIndividuCacheModel detailHealthIndividuCacheModel =
			(DetailHealthIndividuCacheModel)object;

		if (detailHealthIndividuId ==
				detailHealthIndividuCacheModel.detailHealthIndividuId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, detailHealthIndividuId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{detailHealthIndividuId=");
		sb.append(detailHealthIndividuId);
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
		sb.append(", LeadsId=");
		sb.append(LeadsId);
		sb.append(", PlanId=");
		sb.append(PlanId);
		sb.append(", PremiId=");
		sb.append(PremiId);
		sb.append(", SameAddress=");
		sb.append(SameAddress);
		sb.append(", CurrentAddress=");
		sb.append(CurrentAddress);
		sb.append(", CurrentAddress2=");
		sb.append(CurrentAddress2);
		sb.append(", CurrentZip=");
		sb.append(CurrentZip);
		sb.append(", JobCat=");
		sb.append(JobCat);
		sb.append(", JobType=");
		sb.append(JobType);
		sb.append(", Job=");
		sb.append(Job);
		sb.append(", JobPosition=");
		sb.append(JobPosition);
		sb.append(", AccountBankNumber=");
		sb.append(AccountBankNumber);
		sb.append(", AccountBankName=");
		sb.append(AccountBankName);
		sb.append(", BankName=");
		sb.append(BankName);
		sb.append(", HealthAgreement=");
		sb.append(HealthAgreement);
		sb.append(", ChildAgreement=");
		sb.append(ChildAgreement);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DetailHealthIndividu toEntityModel() {
		DetailHealthIndividuImpl detailHealthIndividuImpl =
			new DetailHealthIndividuImpl();

		detailHealthIndividuImpl.setDetailHealthIndividuId(
			detailHealthIndividuId);
		detailHealthIndividuImpl.setGroupId(groupId);
		detailHealthIndividuImpl.setCompanyId(companyId);
		detailHealthIndividuImpl.setUserId(userId);

		if (userName == null) {
			detailHealthIndividuImpl.setUserName("");
		}
		else {
			detailHealthIndividuImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailHealthIndividuImpl.setCreateDate(null);
		}
		else {
			detailHealthIndividuImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailHealthIndividuImpl.setModifiedDate(null);
		}
		else {
			detailHealthIndividuImpl.setModifiedDate(new Date(modifiedDate));
		}

		detailHealthIndividuImpl.setLeadsId(LeadsId);
		detailHealthIndividuImpl.setPlanId(PlanId);
		detailHealthIndividuImpl.setPremiId(PremiId);
		detailHealthIndividuImpl.setSameAddress(SameAddress);

		if (CurrentAddress == null) {
			detailHealthIndividuImpl.setCurrentAddress("");
		}
		else {
			detailHealthIndividuImpl.setCurrentAddress(CurrentAddress);
		}

		if (CurrentAddress2 == null) {
			detailHealthIndividuImpl.setCurrentAddress2("");
		}
		else {
			detailHealthIndividuImpl.setCurrentAddress2(CurrentAddress2);
		}

		if (CurrentZip == null) {
			detailHealthIndividuImpl.setCurrentZip("");
		}
		else {
			detailHealthIndividuImpl.setCurrentZip(CurrentZip);
		}

		if (JobCat == null) {
			detailHealthIndividuImpl.setJobCat("");
		}
		else {
			detailHealthIndividuImpl.setJobCat(JobCat);
		}

		if (JobType == null) {
			detailHealthIndividuImpl.setJobType("");
		}
		else {
			detailHealthIndividuImpl.setJobType(JobType);
		}

		if (Job == null) {
			detailHealthIndividuImpl.setJob("");
		}
		else {
			detailHealthIndividuImpl.setJob(Job);
		}

		if (JobPosition == null) {
			detailHealthIndividuImpl.setJobPosition("");
		}
		else {
			detailHealthIndividuImpl.setJobPosition(JobPosition);
		}

		if (AccountBankNumber == null) {
			detailHealthIndividuImpl.setAccountBankNumber("");
		}
		else {
			detailHealthIndividuImpl.setAccountBankNumber(AccountBankNumber);
		}

		if (AccountBankName == null) {
			detailHealthIndividuImpl.setAccountBankName("");
		}
		else {
			detailHealthIndividuImpl.setAccountBankName(AccountBankName);
		}

		if (BankName == null) {
			detailHealthIndividuImpl.setBankName("");
		}
		else {
			detailHealthIndividuImpl.setBankName(BankName);
		}

		detailHealthIndividuImpl.setHealthAgreement(HealthAgreement);
		detailHealthIndividuImpl.setChildAgreement(ChildAgreement);

		detailHealthIndividuImpl.resetOriginalValues();

		return detailHealthIndividuImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		detailHealthIndividuId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		LeadsId = objectInput.readLong();

		PlanId = objectInput.readLong();

		PremiId = objectInput.readLong();

		SameAddress = objectInput.readInt();
		CurrentAddress = objectInput.readUTF();
		CurrentAddress2 = objectInput.readUTF();
		CurrentZip = objectInput.readUTF();
		JobCat = objectInput.readUTF();
		JobType = objectInput.readUTF();
		Job = objectInput.readUTF();
		JobPosition = objectInput.readUTF();
		AccountBankNumber = objectInput.readUTF();
		AccountBankName = objectInput.readUTF();
		BankName = objectInput.readUTF();

		HealthAgreement = objectInput.readInt();

		ChildAgreement = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(detailHealthIndividuId);

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

		objectOutput.writeLong(LeadsId);

		objectOutput.writeLong(PlanId);

		objectOutput.writeLong(PremiId);

		objectOutput.writeInt(SameAddress);

		if (CurrentAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CurrentAddress);
		}

		if (CurrentAddress2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CurrentAddress2);
		}

		if (CurrentZip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CurrentZip);
		}

		if (JobCat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(JobCat);
		}

		if (JobType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(JobType);
		}

		if (Job == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Job);
		}

		if (JobPosition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(JobPosition);
		}

		if (AccountBankNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(AccountBankNumber);
		}

		if (AccountBankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(AccountBankName);
		}

		if (BankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BankName);
		}

		objectOutput.writeInt(HealthAgreement);

		objectOutput.writeInt(ChildAgreement);
	}

	public long detailHealthIndividuId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long LeadsId;
	public long PlanId;
	public long PremiId;
	public int SameAddress;
	public String CurrentAddress;
	public String CurrentAddress2;
	public String CurrentZip;
	public String JobCat;
	public String JobType;
	public String Job;
	public String JobPosition;
	public String AccountBankNumber;
	public String AccountBankName;
	public String BankName;
	public int HealthAgreement;
	public int ChildAgreement;

}