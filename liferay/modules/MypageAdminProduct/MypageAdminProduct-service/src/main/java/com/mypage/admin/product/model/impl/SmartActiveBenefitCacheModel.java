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

package com.mypage.admin.product.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.admin.product.model.SmartActiveBenefit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveBenefit in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveBenefitCacheModel
	implements CacheModel<SmartActiveBenefit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveBenefitCacheModel)) {
			return false;
		}

		SmartActiveBenefitCacheModel smartActiveBenefitCacheModel =
			(SmartActiveBenefitCacheModel)object;

		if (smartActiveBenefitId ==
				smartActiveBenefitCacheModel.smartActiveBenefitId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveBenefitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{smartActiveBenefitId=");
		sb.append(smartActiveBenefitId);
		sb.append(", nameId=");
		sb.append(nameId);
		sb.append(", nameEn=");
		sb.append(nameEn);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", smartActiveBenefitTypeId=");
		sb.append(smartActiveBenefitTypeId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", description=");
		sb.append(description);
		sb.append(", limit_=");
		sb.append(limit_);
		sb.append(", externalCode=");
		sb.append(externalCode);
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
	public SmartActiveBenefit toEntityModel() {
		SmartActiveBenefitImpl smartActiveBenefitImpl =
			new SmartActiveBenefitImpl();

		smartActiveBenefitImpl.setSmartActiveBenefitId(smartActiveBenefitId);

		if (nameId == null) {
			smartActiveBenefitImpl.setNameId("");
		}
		else {
			smartActiveBenefitImpl.setNameId(nameId);
		}

		if (nameEn == null) {
			smartActiveBenefitImpl.setNameEn("");
		}
		else {
			smartActiveBenefitImpl.setNameEn(nameEn);
		}

		smartActiveBenefitImpl.setSort(sort);
		smartActiveBenefitImpl.setSmartActiveBenefitTypeId(
			smartActiveBenefitTypeId);
		smartActiveBenefitImpl.setActive(active);

		if (description == null) {
			smartActiveBenefitImpl.setDescription("");
		}
		else {
			smartActiveBenefitImpl.setDescription(description);
		}

		if (limit_ == null) {
			smartActiveBenefitImpl.setLimit_("");
		}
		else {
			smartActiveBenefitImpl.setLimit_(limit_);
		}

		if (externalCode == null) {
			smartActiveBenefitImpl.setExternalCode("");
		}
		else {
			smartActiveBenefitImpl.setExternalCode(externalCode);
		}

		smartActiveBenefitImpl.setGroupId(groupId);
		smartActiveBenefitImpl.setCompanyId(companyId);
		smartActiveBenefitImpl.setUserId(userId);

		if (userName == null) {
			smartActiveBenefitImpl.setUserName("");
		}
		else {
			smartActiveBenefitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveBenefitImpl.setCreateDate(null);
		}
		else {
			smartActiveBenefitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveBenefitImpl.setModifiedDate(null);
		}
		else {
			smartActiveBenefitImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveBenefitImpl.resetOriginalValues();

		return smartActiveBenefitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveBenefitId = objectInput.readLong();
		nameId = objectInput.readUTF();
		nameEn = objectInput.readUTF();

		sort = objectInput.readInt();

		smartActiveBenefitTypeId = objectInput.readLong();

		active = objectInput.readInt();
		description = objectInput.readUTF();
		limit_ = objectInput.readUTF();
		externalCode = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartActiveBenefitId);

		if (nameId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameId);
		}

		if (nameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameEn);
		}

		objectOutput.writeInt(sort);

		objectOutput.writeLong(smartActiveBenefitTypeId);

		objectOutput.writeInt(active);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (limit_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(limit_);
		}

		if (externalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCode);
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

	public long smartActiveBenefitId;
	public String nameId;
	public String nameEn;
	public int sort;
	public long smartActiveBenefitTypeId;
	public int active;
	public String description;
	public String limit_;
	public String externalCode;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}