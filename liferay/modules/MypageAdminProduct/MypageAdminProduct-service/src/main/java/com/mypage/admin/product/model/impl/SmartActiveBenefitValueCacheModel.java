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

import com.mypage.admin.product.model.SmartActiveBenefitValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveBenefitValue in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveBenefitValueCacheModel
	implements CacheModel<SmartActiveBenefitValue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveBenefitValueCacheModel)) {
			return false;
		}

		SmartActiveBenefitValueCacheModel smartActiveBenefitValueCacheModel =
			(SmartActiveBenefitValueCacheModel)object;

		if (smartActiveBenefitValueId ==
				smartActiveBenefitValueCacheModel.smartActiveBenefitValueId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveBenefitValueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{smartActiveBenefitValueId=");
		sb.append(smartActiveBenefitValueId);
		sb.append(", value=");
		sb.append(value);
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
	public SmartActiveBenefitValue toEntityModel() {
		SmartActiveBenefitValueImpl smartActiveBenefitValueImpl =
			new SmartActiveBenefitValueImpl();

		smartActiveBenefitValueImpl.setSmartActiveBenefitValueId(
			smartActiveBenefitValueId);
		smartActiveBenefitValueImpl.setValue(value);
		smartActiveBenefitValueImpl.setActive(active);
		smartActiveBenefitValueImpl.setGroupId(groupId);
		smartActiveBenefitValueImpl.setCompanyId(companyId);
		smartActiveBenefitValueImpl.setUserId(userId);

		if (userName == null) {
			smartActiveBenefitValueImpl.setUserName("");
		}
		else {
			smartActiveBenefitValueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveBenefitValueImpl.setCreateDate(null);
		}
		else {
			smartActiveBenefitValueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveBenefitValueImpl.setModifiedDate(null);
		}
		else {
			smartActiveBenefitValueImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveBenefitValueImpl.resetOriginalValues();

		return smartActiveBenefitValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveBenefitValueId = objectInput.readLong();

		value = objectInput.readLong();

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
		objectOutput.writeLong(smartActiveBenefitValueId);

		objectOutput.writeLong(value);

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

	public long smartActiveBenefitValueId;
	public long value;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}