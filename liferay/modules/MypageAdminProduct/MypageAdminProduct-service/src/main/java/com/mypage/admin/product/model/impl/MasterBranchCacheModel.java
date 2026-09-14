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

import com.mypage.admin.product.model.MasterBranch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterBranch in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterBranchCacheModel
	implements CacheModel<MasterBranch>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterBranchCacheModel)) {
			return false;
		}

		MasterBranchCacheModel masterBranchCacheModel =
			(MasterBranchCacheModel)object;

		if (masterBranchId == masterBranchCacheModel.masterBranchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterBranchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{masterBranchId=");
		sb.append(masterBranchId);
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
		sb.append(", agiCode=");
		sb.append(agiCode);
		sb.append(", magiCode=");
		sb.append(magiCode);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterBranch toEntityModel() {
		MasterBranchImpl masterBranchImpl = new MasterBranchImpl();

		masterBranchImpl.setMasterBranchId(masterBranchId);
		masterBranchImpl.setGroupId(groupId);
		masterBranchImpl.setCompanyId(companyId);
		masterBranchImpl.setUserId(userId);

		if (userName == null) {
			masterBranchImpl.setUserName("");
		}
		else {
			masterBranchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterBranchImpl.setCreateDate(null);
		}
		else {
			masterBranchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterBranchImpl.setModifiedDate(null);
		}
		else {
			masterBranchImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			masterBranchImpl.setName("");
		}
		else {
			masterBranchImpl.setName(name);
		}

		if (agiCode == null) {
			masterBranchImpl.setAgiCode("");
		}
		else {
			masterBranchImpl.setAgiCode(agiCode);
		}

		if (magiCode == null) {
			masterBranchImpl.setMagiCode("");
		}
		else {
			masterBranchImpl.setMagiCode(magiCode);
		}

		masterBranchImpl.setActive(active);

		masterBranchImpl.resetOriginalValues();

		return masterBranchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterBranchId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		agiCode = objectInput.readUTF();
		magiCode = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterBranchId);

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

		if (agiCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agiCode);
		}

		if (magiCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(magiCode);
		}

		objectOutput.writeInt(active);
	}

	public long masterBranchId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String agiCode;
	public String magiCode;
	public int active;

}