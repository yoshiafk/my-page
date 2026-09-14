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

import com.mypage.admin.product.model.SmartActiveOccupation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveOccupation in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveOccupationCacheModel
	implements CacheModel<SmartActiveOccupation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveOccupationCacheModel)) {
			return false;
		}

		SmartActiveOccupationCacheModel smartActiveOccupationCacheModel =
			(SmartActiveOccupationCacheModel)object;

		if (smartActiveOccupationId ==
				smartActiveOccupationCacheModel.smartActiveOccupationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveOccupationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{smartActiveOccupationId=");
		sb.append(smartActiveOccupationId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", nameId=");
		sb.append(nameId);
		sb.append(", nameEn=");
		sb.append(nameEn);
		sb.append(", active=");
		sb.append(active);
		sb.append(", smartActiveClassRateId=");
		sb.append(smartActiveClassRateId);
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
	public SmartActiveOccupation toEntityModel() {
		SmartActiveOccupationImpl smartActiveOccupationImpl =
			new SmartActiveOccupationImpl();

		smartActiveOccupationImpl.setSmartActiveOccupationId(
			smartActiveOccupationId);

		if (code == null) {
			smartActiveOccupationImpl.setCode("");
		}
		else {
			smartActiveOccupationImpl.setCode(code);
		}

		if (nameId == null) {
			smartActiveOccupationImpl.setNameId("");
		}
		else {
			smartActiveOccupationImpl.setNameId(nameId);
		}

		if (nameEn == null) {
			smartActiveOccupationImpl.setNameEn("");
		}
		else {
			smartActiveOccupationImpl.setNameEn(nameEn);
		}

		smartActiveOccupationImpl.setActive(active);
		smartActiveOccupationImpl.setSmartActiveClassRateId(
			smartActiveClassRateId);
		smartActiveOccupationImpl.setGroupId(groupId);
		smartActiveOccupationImpl.setCompanyId(companyId);
		smartActiveOccupationImpl.setUserId(userId);

		if (userName == null) {
			smartActiveOccupationImpl.setUserName("");
		}
		else {
			smartActiveOccupationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveOccupationImpl.setCreateDate(null);
		}
		else {
			smartActiveOccupationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveOccupationImpl.setModifiedDate(null);
		}
		else {
			smartActiveOccupationImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveOccupationImpl.resetOriginalValues();

		return smartActiveOccupationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveOccupationId = objectInput.readLong();
		code = objectInput.readUTF();
		nameId = objectInput.readUTF();
		nameEn = objectInput.readUTF();

		active = objectInput.readInt();

		smartActiveClassRateId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartActiveOccupationId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

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

		objectOutput.writeLong(smartActiveClassRateId);

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

	public long smartActiveOccupationId;
	public String code;
	public String nameId;
	public String nameEn;
	public int active;
	public long smartActiveClassRateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}