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

import com.mypage.admin.product.model.BenefitValueMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BenefitValueMapping in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class BenefitValueMappingCacheModel
	implements CacheModel<BenefitValueMapping>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BenefitValueMappingCacheModel)) {
			return false;
		}

		BenefitValueMappingCacheModel benefitValueMappingCacheModel =
			(BenefitValueMappingCacheModel)object;

		if (benefitValueMappingId ==
				benefitValueMappingCacheModel.benefitValueMappingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, benefitValueMappingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{benefitValueMappingId=");
		sb.append(benefitValueMappingId);
		sb.append(", benefitTypeId=");
		sb.append(benefitTypeId);
		sb.append(", benefitId=");
		sb.append(benefitId);
		sb.append(", planId=");
		sb.append(planId);
		sb.append(", benefitValue=");
		sb.append(benefitValue);
		sb.append(", benefitValueUSD=");
		sb.append(benefitValueUSD);
		sb.append(", sort=");
		sb.append(sort);
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
	public BenefitValueMapping toEntityModel() {
		BenefitValueMappingImpl benefitValueMappingImpl =
			new BenefitValueMappingImpl();

		benefitValueMappingImpl.setBenefitValueMappingId(benefitValueMappingId);
		benefitValueMappingImpl.setBenefitTypeId(benefitTypeId);
		benefitValueMappingImpl.setBenefitId(benefitId);
		benefitValueMappingImpl.setPlanId(planId);

		if (benefitValue == null) {
			benefitValueMappingImpl.setBenefitValue("");
		}
		else {
			benefitValueMappingImpl.setBenefitValue(benefitValue);
		}

		if (benefitValueUSD == null) {
			benefitValueMappingImpl.setBenefitValueUSD("");
		}
		else {
			benefitValueMappingImpl.setBenefitValueUSD(benefitValueUSD);
		}

		benefitValueMappingImpl.setSort(sort);
		benefitValueMappingImpl.setActive(active);
		benefitValueMappingImpl.setGroupId(groupId);
		benefitValueMappingImpl.setCompanyId(companyId);
		benefitValueMappingImpl.setUserId(userId);

		if (userName == null) {
			benefitValueMappingImpl.setUserName("");
		}
		else {
			benefitValueMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			benefitValueMappingImpl.setCreateDate(null);
		}
		else {
			benefitValueMappingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			benefitValueMappingImpl.setModifiedDate(null);
		}
		else {
			benefitValueMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		benefitValueMappingImpl.resetOriginalValues();

		return benefitValueMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		benefitValueMappingId = objectInput.readLong();

		benefitTypeId = objectInput.readLong();

		benefitId = objectInput.readLong();

		planId = objectInput.readLong();
		benefitValue = objectInput.readUTF();
		benefitValueUSD = objectInput.readUTF();

		sort = objectInput.readInt();

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
		objectOutput.writeLong(benefitValueMappingId);

		objectOutput.writeLong(benefitTypeId);

		objectOutput.writeLong(benefitId);

		objectOutput.writeLong(planId);

		if (benefitValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitValue);
		}

		if (benefitValueUSD == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitValueUSD);
		}

		objectOutput.writeInt(sort);

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

	public long benefitValueMappingId;
	public long benefitTypeId;
	public long benefitId;
	public long planId;
	public String benefitValue;
	public String benefitValueUSD;
	public int sort;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}