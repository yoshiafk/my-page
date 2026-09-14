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

import com.mypage.admin.product.model.SmartActiveClassRate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveClassRate in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveClassRateCacheModel
	implements CacheModel<SmartActiveClassRate>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveClassRateCacheModel)) {
			return false;
		}

		SmartActiveClassRateCacheModel smartActiveClassRateCacheModel =
			(SmartActiveClassRateCacheModel)object;

		if (smartActiveClassRateId ==
				smartActiveClassRateCacheModel.smartActiveClassRateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveClassRateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{smartActiveClassRateId=");
		sb.append(smartActiveClassRateId);
		sb.append(", nameId=");
		sb.append(nameId);
		sb.append(", nameEn=");
		sb.append(nameEn);
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
	public SmartActiveClassRate toEntityModel() {
		SmartActiveClassRateImpl smartActiveClassRateImpl =
			new SmartActiveClassRateImpl();

		smartActiveClassRateImpl.setSmartActiveClassRateId(
			smartActiveClassRateId);

		if (nameId == null) {
			smartActiveClassRateImpl.setNameId("");
		}
		else {
			smartActiveClassRateImpl.setNameId(nameId);
		}

		if (nameEn == null) {
			smartActiveClassRateImpl.setNameEn("");
		}
		else {
			smartActiveClassRateImpl.setNameEn(nameEn);
		}

		smartActiveClassRateImpl.setActive(active);
		smartActiveClassRateImpl.setGroupId(groupId);
		smartActiveClassRateImpl.setCompanyId(companyId);
		smartActiveClassRateImpl.setUserId(userId);

		if (userName == null) {
			smartActiveClassRateImpl.setUserName("");
		}
		else {
			smartActiveClassRateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveClassRateImpl.setCreateDate(null);
		}
		else {
			smartActiveClassRateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveClassRateImpl.setModifiedDate(null);
		}
		else {
			smartActiveClassRateImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveClassRateImpl.resetOriginalValues();

		return smartActiveClassRateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveClassRateId = objectInput.readLong();
		nameId = objectInput.readUTF();
		nameEn = objectInput.readUTF();

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
		objectOutput.writeLong(smartActiveClassRateId);

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

	public long smartActiveClassRateId;
	public String nameId;
	public String nameEn;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}