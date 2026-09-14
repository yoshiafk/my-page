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

import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveBenefitValueMapping in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveBenefitValueMappingCacheModel
	implements CacheModel<SmartActiveBenefitValueMapping>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveBenefitValueMappingCacheModel)) {
			return false;
		}

		SmartActiveBenefitValueMappingCacheModel
			smartActiveBenefitValueMappingCacheModel =
				(SmartActiveBenefitValueMappingCacheModel)object;

		if (smartActiveBenefitValueMappingId ==
				smartActiveBenefitValueMappingCacheModel.
					smartActiveBenefitValueMappingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveBenefitValueMappingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{smartActiveBenefitValueMappingId=");
		sb.append(smartActiveBenefitValueMappingId);
		sb.append(", smartActiveBenefitTypeId=");
		sb.append(smartActiveBenefitTypeId);
		sb.append(", smartActiveBenefitId=");
		sb.append(smartActiveBenefitId);
		sb.append(", smartActiveBenefitValueId=");
		sb.append(smartActiveBenefitValueId);
		sb.append(", value=");
		sb.append(value);
		sb.append(", limitValue=");
		sb.append(limitValue);
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
	public SmartActiveBenefitValueMapping toEntityModel() {
		SmartActiveBenefitValueMappingImpl smartActiveBenefitValueMappingImpl =
			new SmartActiveBenefitValueMappingImpl();

		smartActiveBenefitValueMappingImpl.setSmartActiveBenefitValueMappingId(
			smartActiveBenefitValueMappingId);
		smartActiveBenefitValueMappingImpl.setSmartActiveBenefitTypeId(
			smartActiveBenefitTypeId);
		smartActiveBenefitValueMappingImpl.setSmartActiveBenefitId(
			smartActiveBenefitId);
		smartActiveBenefitValueMappingImpl.setSmartActiveBenefitValueId(
			smartActiveBenefitValueId);

		if (value == null) {
			smartActiveBenefitValueMappingImpl.setValue("");
		}
		else {
			smartActiveBenefitValueMappingImpl.setValue(value);
		}

		smartActiveBenefitValueMappingImpl.setLimitValue(limitValue);
		smartActiveBenefitValueMappingImpl.setActive(active);
		smartActiveBenefitValueMappingImpl.setGroupId(groupId);
		smartActiveBenefitValueMappingImpl.setCompanyId(companyId);
		smartActiveBenefitValueMappingImpl.setUserId(userId);

		if (userName == null) {
			smartActiveBenefitValueMappingImpl.setUserName("");
		}
		else {
			smartActiveBenefitValueMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveBenefitValueMappingImpl.setCreateDate(null);
		}
		else {
			smartActiveBenefitValueMappingImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveBenefitValueMappingImpl.setModifiedDate(null);
		}
		else {
			smartActiveBenefitValueMappingImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		smartActiveBenefitValueMappingImpl.resetOriginalValues();

		return smartActiveBenefitValueMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		smartActiveBenefitValueMappingId = objectInput.readLong();

		smartActiveBenefitTypeId = objectInput.readLong();

		smartActiveBenefitId = objectInput.readLong();

		smartActiveBenefitValueId = objectInput.readLong();
		value = objectInput.readUTF();
		limitValue = (BigDecimal)objectInput.readObject();

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
		objectOutput.writeLong(smartActiveBenefitValueMappingId);

		objectOutput.writeLong(smartActiveBenefitTypeId);

		objectOutput.writeLong(smartActiveBenefitId);

		objectOutput.writeLong(smartActiveBenefitValueId);

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		objectOutput.writeObject(limitValue);

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

	public long smartActiveBenefitValueMappingId;
	public long smartActiveBenefitTypeId;
	public long smartActiveBenefitId;
	public long smartActiveBenefitValueId;
	public String value;
	public BigDecimal limitValue;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}