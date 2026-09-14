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

package com.mypage.user.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.user.model.CreditType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CreditTypeCacheModel
	implements CacheModel<CreditType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CreditTypeCacheModel)) {
			return false;
		}

		CreditTypeCacheModel creditTypeCacheModel =
			(CreditTypeCacheModel)object;

		if (creditTypeId == creditTypeCacheModel.creditTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, creditTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{creditTypeId=");
		sb.append(creditTypeId);
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
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", agentType=");
		sb.append(agentType);
		sb.append(", limit=");
		sb.append(limit);
		sb.append(", overrideGracePeriod=");
		sb.append(overrideGracePeriod);
		sb.append(", nettPremiAllowed=");
		sb.append(nettPremiAllowed);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditType toEntityModel() {
		CreditTypeImpl creditTypeImpl = new CreditTypeImpl();

		creditTypeImpl.setCreditTypeId(creditTypeId);
		creditTypeImpl.setGroupId(groupId);
		creditTypeImpl.setCompanyId(companyId);
		creditTypeImpl.setUserId(userId);

		if (userName == null) {
			creditTypeImpl.setUserName("");
		}
		else {
			creditTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditTypeImpl.setCreateDate(null);
		}
		else {
			creditTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditTypeImpl.setModifiedDate(null);
		}
		else {
			creditTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditTypeImpl.setMypageUserId(mypageUserId);

		if (name == null) {
			creditTypeImpl.setName("");
		}
		else {
			creditTypeImpl.setName(name);
		}

		if (agentType == null) {
			creditTypeImpl.setAgentType("");
		}
		else {
			creditTypeImpl.setAgentType(agentType);
		}

		creditTypeImpl.setLimit(limit);
		creditTypeImpl.setOverrideGracePeriod(overrideGracePeriod);
		creditTypeImpl.setNettPremiAllowed(nettPremiAllowed);
		creditTypeImpl.setActive(active);

		creditTypeImpl.resetOriginalValues();

		return creditTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creditTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		mypageUserId = objectInput.readLong();
		name = objectInput.readUTF();
		agentType = objectInput.readUTF();

		limit = objectInput.readDouble();

		overrideGracePeriod = objectInput.readInt();

		nettPremiAllowed = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(creditTypeId);

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

		objectOutput.writeLong(mypageUserId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (agentType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agentType);
		}

		objectOutput.writeDouble(limit);

		objectOutput.writeInt(overrideGracePeriod);

		objectOutput.writeInt(nettPremiAllowed);

		objectOutput.writeInt(active);
	}

	public long creditTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mypageUserId;
	public String name;
	public String agentType;
	public double limit;
	public int overrideGracePeriod;
	public int nettPremiAllowed;
	public int active;

}