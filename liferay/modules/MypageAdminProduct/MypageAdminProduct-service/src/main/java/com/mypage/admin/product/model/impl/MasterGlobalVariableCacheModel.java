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

import com.mypage.admin.product.model.MasterGlobalVariable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterGlobalVariable in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterGlobalVariableCacheModel
	implements CacheModel<MasterGlobalVariable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterGlobalVariableCacheModel)) {
			return false;
		}

		MasterGlobalVariableCacheModel masterGlobalVariableCacheModel =
			(MasterGlobalVariableCacheModel)object;

		if (masterGlobalVariableId ==
				masterGlobalVariableCacheModel.masterGlobalVariableId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterGlobalVariableId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{masterGlobalVariableId=");
		sb.append(masterGlobalVariableId);
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
		sb.append(", group=");
		sb.append(group);
		sb.append(", name=");
		sb.append(name);
		sb.append(", value=");
		sb.append(value);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterGlobalVariable toEntityModel() {
		MasterGlobalVariableImpl masterGlobalVariableImpl =
			new MasterGlobalVariableImpl();

		masterGlobalVariableImpl.setMasterGlobalVariableId(
			masterGlobalVariableId);
		masterGlobalVariableImpl.setGroupId(groupId);
		masterGlobalVariableImpl.setCompanyId(companyId);
		masterGlobalVariableImpl.setUserId(userId);

		if (userName == null) {
			masterGlobalVariableImpl.setUserName("");
		}
		else {
			masterGlobalVariableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterGlobalVariableImpl.setCreateDate(null);
		}
		else {
			masterGlobalVariableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterGlobalVariableImpl.setModifiedDate(null);
		}
		else {
			masterGlobalVariableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (group == null) {
			masterGlobalVariableImpl.setGroup("");
		}
		else {
			masterGlobalVariableImpl.setGroup(group);
		}

		if (name == null) {
			masterGlobalVariableImpl.setName("");
		}
		else {
			masterGlobalVariableImpl.setName(name);
		}

		if (value == null) {
			masterGlobalVariableImpl.setValue("");
		}
		else {
			masterGlobalVariableImpl.setValue(value);
		}

		masterGlobalVariableImpl.setImageFileEntryId(imageFileEntryId);
		masterGlobalVariableImpl.setActive(active);

		masterGlobalVariableImpl.resetOriginalValues();

		return masterGlobalVariableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterGlobalVariableId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		group = objectInput.readUTF();
		name = objectInput.readUTF();
		value = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterGlobalVariableId);

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

		if (group == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(group);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		objectOutput.writeLong(imageFileEntryId);

		objectOutput.writeInt(active);
	}

	public long masterGlobalVariableId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String group;
	public String name;
	public String value;
	public long imageFileEntryId;
	public int active;

}