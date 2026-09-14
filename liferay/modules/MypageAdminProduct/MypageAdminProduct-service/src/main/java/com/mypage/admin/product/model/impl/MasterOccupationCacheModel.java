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

import com.mypage.admin.product.model.MasterOccupation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterOccupation in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterOccupationCacheModel
	implements CacheModel<MasterOccupation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterOccupationCacheModel)) {
			return false;
		}

		MasterOccupationCacheModel masterOccupationCacheModel =
			(MasterOccupationCacheModel)object;

		if (masterOccupationId ==
				masterOccupationCacheModel.masterOccupationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterOccupationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{masterOccupationId=");
		sb.append(masterOccupationId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", masterOccupationCategoryId=");
		sb.append(masterOccupationCategoryId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterOccupation toEntityModel() {
		MasterOccupationImpl masterOccupationImpl = new MasterOccupationImpl();

		masterOccupationImpl.setMasterOccupationId(masterOccupationId);
		masterOccupationImpl.setGroupId(groupId);
		masterOccupationImpl.setCompanyId(companyId);
		masterOccupationImpl.setUserId(userId);

		if (userName == null) {
			masterOccupationImpl.setUserName("");
		}
		else {
			masterOccupationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterOccupationImpl.setCreateDate(null);
		}
		else {
			masterOccupationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterOccupationImpl.setModifiedDate(null);
		}
		else {
			masterOccupationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			masterOccupationImpl.setName("");
		}
		else {
			masterOccupationImpl.setName(name);
		}

		masterOccupationImpl.setMasterOccupationCategoryId(
			masterOccupationCategoryId);
		masterOccupationImpl.setActive(active);

		masterOccupationImpl.resetOriginalValues();

		return masterOccupationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterOccupationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		masterOccupationCategoryId = objectInput.readLong();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterOccupationId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(masterOccupationCategoryId);

		objectOutput.writeInt(active);
	}

	public long masterOccupationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long masterOccupationCategoryId;
	public int active;

}