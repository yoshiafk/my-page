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

import com.mypage.admin.product.model.HealthSmeType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HealthSmeType in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class HealthSmeTypeCacheModel
	implements CacheModel<HealthSmeType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HealthSmeTypeCacheModel)) {
			return false;
		}

		HealthSmeTypeCacheModel healthSmeTypeCacheModel =
			(HealthSmeTypeCacheModel)object;

		if (healthSmeTypeId == healthSmeTypeCacheModel.healthSmeTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, healthSmeTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{healthSmeTypeId=");
		sb.append(healthSmeTypeId);
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
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append(", typeCode=");
		sb.append(typeCode);
		sb.append(", typeDescription=");
		sb.append(typeDescription);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HealthSmeType toEntityModel() {
		HealthSmeTypeImpl healthSmeTypeImpl = new HealthSmeTypeImpl();

		healthSmeTypeImpl.setHealthSmeTypeId(healthSmeTypeId);
		healthSmeTypeImpl.setGroupId(groupId);
		healthSmeTypeImpl.setCompanyId(companyId);
		healthSmeTypeImpl.setUserId(userId);

		if (userName == null) {
			healthSmeTypeImpl.setUserName("");
		}
		else {
			healthSmeTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			healthSmeTypeImpl.setCreateDate(null);
		}
		else {
			healthSmeTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			healthSmeTypeImpl.setModifiedDate(null);
		}
		else {
			healthSmeTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (typeName == null) {
			healthSmeTypeImpl.setTypeName("");
		}
		else {
			healthSmeTypeImpl.setTypeName(typeName);
		}

		if (typeCode == null) {
			healthSmeTypeImpl.setTypeCode("");
		}
		else {
			healthSmeTypeImpl.setTypeCode(typeCode);
		}

		if (typeDescription == null) {
			healthSmeTypeImpl.setTypeDescription("");
		}
		else {
			healthSmeTypeImpl.setTypeDescription(typeDescription);
		}

		healthSmeTypeImpl.setActive(active);

		healthSmeTypeImpl.resetOriginalValues();

		return healthSmeTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		healthSmeTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		typeName = objectInput.readUTF();
		typeCode = objectInput.readUTF();
		typeDescription = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(healthSmeTypeId);

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

		if (typeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeName);
		}

		if (typeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeCode);
		}

		if (typeDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeDescription);
		}

		objectOutput.writeInt(active);
	}

	public long healthSmeTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String typeName;
	public String typeCode;
	public String typeDescription;
	public int active;

}