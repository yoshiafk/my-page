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

import com.mypage.leads.model.DetailSmartactive;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailSmartactive in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailSmartactiveCacheModel
	implements CacheModel<DetailSmartactive>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailSmartactiveCacheModel)) {
			return false;
		}

		DetailSmartactiveCacheModel detailSmartactiveCacheModel =
			(DetailSmartactiveCacheModel)object;

		if (DetailId == detailSmartactiveCacheModel.DetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, DetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{DetailId=");
		sb.append(DetailId);
		sb.append(", LeadsId=");
		sb.append(LeadsId);
		sb.append(", ExcludedActivityStatus=");
		sb.append(ExcludedActivityStatus);
		sb.append(", JobType=");
		sb.append(JobType);
		sb.append(", MainBenefitValue=");
		sb.append(MainBenefitValue);
		sb.append(", StartPeriode=");
		sb.append(StartPeriode);
		sb.append(", EndPeriode=");
		sb.append(EndPeriode);
		sb.append(", ListBenefitId=");
		sb.append(ListBenefitId);
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
	public DetailSmartactive toEntityModel() {
		DetailSmartactiveImpl detailSmartactiveImpl =
			new DetailSmartactiveImpl();

		detailSmartactiveImpl.setDetailId(DetailId);
		detailSmartactiveImpl.setLeadsId(LeadsId);
		detailSmartactiveImpl.setExcludedActivityStatus(ExcludedActivityStatus);
		detailSmartactiveImpl.setJobType(JobType);

		if (MainBenefitValue == null) {
			detailSmartactiveImpl.setMainBenefitValue("");
		}
		else {
			detailSmartactiveImpl.setMainBenefitValue(MainBenefitValue);
		}

		if (StartPeriode == Long.MIN_VALUE) {
			detailSmartactiveImpl.setStartPeriode(null);
		}
		else {
			detailSmartactiveImpl.setStartPeriode(new Date(StartPeriode));
		}

		if (EndPeriode == Long.MIN_VALUE) {
			detailSmartactiveImpl.setEndPeriode(null);
		}
		else {
			detailSmartactiveImpl.setEndPeriode(new Date(EndPeriode));
		}

		if (ListBenefitId == null) {
			detailSmartactiveImpl.setListBenefitId("");
		}
		else {
			detailSmartactiveImpl.setListBenefitId(ListBenefitId);
		}

		detailSmartactiveImpl.setGroupId(groupId);
		detailSmartactiveImpl.setCompanyId(companyId);
		detailSmartactiveImpl.setUserId(userId);

		if (userName == null) {
			detailSmartactiveImpl.setUserName("");
		}
		else {
			detailSmartactiveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailSmartactiveImpl.setCreateDate(null);
		}
		else {
			detailSmartactiveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailSmartactiveImpl.setModifiedDate(null);
		}
		else {
			detailSmartactiveImpl.setModifiedDate(new Date(modifiedDate));
		}

		detailSmartactiveImpl.resetOriginalValues();

		return detailSmartactiveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		DetailId = objectInput.readLong();

		LeadsId = objectInput.readLong();

		ExcludedActivityStatus = objectInput.readInt();

		JobType = objectInput.readLong();
		MainBenefitValue = objectInput.readUTF();
		StartPeriode = objectInput.readLong();
		EndPeriode = objectInput.readLong();
		ListBenefitId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(DetailId);

		objectOutput.writeLong(LeadsId);

		objectOutput.writeInt(ExcludedActivityStatus);

		objectOutput.writeLong(JobType);

		if (MainBenefitValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MainBenefitValue);
		}

		objectOutput.writeLong(StartPeriode);
		objectOutput.writeLong(EndPeriode);

		if (ListBenefitId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ListBenefitId);
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
	}

	public long DetailId;
	public long LeadsId;
	public int ExcludedActivityStatus;
	public long JobType;
	public String MainBenefitValue;
	public long StartPeriode;
	public long EndPeriode;
	public String ListBenefitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}