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

import com.mypage.admin.product.model.MasterOccupationCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterOccupationCategory in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterOccupationCategoryCacheModel
	implements CacheModel<MasterOccupationCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterOccupationCategoryCacheModel)) {
			return false;
		}

		MasterOccupationCategoryCacheModel masterOccupationCategoryCacheModel =
			(MasterOccupationCategoryCacheModel)object;

		if (masterOccupationCategoryId ==
				masterOccupationCategoryCacheModel.masterOccupationCategoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterOccupationCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{masterOccupationCategoryId=");
		sb.append(masterOccupationCategoryId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterOccupationCategory toEntityModel() {
		MasterOccupationCategoryImpl masterOccupationCategoryImpl =
			new MasterOccupationCategoryImpl();

		masterOccupationCategoryImpl.setMasterOccupationCategoryId(
			masterOccupationCategoryId);
		masterOccupationCategoryImpl.setGroupId(groupId);
		masterOccupationCategoryImpl.setCompanyId(companyId);
		masterOccupationCategoryImpl.setUserId(userId);

		if (userName == null) {
			masterOccupationCategoryImpl.setUserName("");
		}
		else {
			masterOccupationCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterOccupationCategoryImpl.setCreateDate(null);
		}
		else {
			masterOccupationCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterOccupationCategoryImpl.setModifiedDate(null);
		}
		else {
			masterOccupationCategoryImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (name == null) {
			masterOccupationCategoryImpl.setName("");
		}
		else {
			masterOccupationCategoryImpl.setName(name);
		}

		masterOccupationCategoryImpl.setActive(active);

		masterOccupationCategoryImpl.resetOriginalValues();

		return masterOccupationCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterOccupationCategoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterOccupationCategoryId);

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

		objectOutput.writeInt(active);
	}

	public long masterOccupationCategoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public int active;

}