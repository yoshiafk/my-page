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

import com.mypage.admin.product.model.CompanyType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompanyType in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class CompanyTypeCacheModel
	implements CacheModel<CompanyType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CompanyTypeCacheModel)) {
			return false;
		}

		CompanyTypeCacheModel companyTypeCacheModel =
			(CompanyTypeCacheModel)object;

		if (companyTypeId == companyTypeCacheModel.companyTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{companyTypeId=");
		sb.append(companyTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", sort=");
		sb.append(sort);
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
	public CompanyType toEntityModel() {
		CompanyTypeImpl companyTypeImpl = new CompanyTypeImpl();

		companyTypeImpl.setCompanyTypeId(companyTypeId);

		if (name == null) {
			companyTypeImpl.setName("");
		}
		else {
			companyTypeImpl.setName(name);
		}

		if (label == null) {
			companyTypeImpl.setLabel("");
		}
		else {
			companyTypeImpl.setLabel(label);
		}

		companyTypeImpl.setSort(sort);
		companyTypeImpl.setActive(active);
		companyTypeImpl.setGroupId(groupId);
		companyTypeImpl.setCompanyId(companyId);
		companyTypeImpl.setUserId(userId);

		if (userName == null) {
			companyTypeImpl.setUserName("");
		}
		else {
			companyTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			companyTypeImpl.setCreateDate(null);
		}
		else {
			companyTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			companyTypeImpl.setModifiedDate(null);
		}
		else {
			companyTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		companyTypeImpl.resetOriginalValues();

		return companyTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		label = objectInput.readUTF();

		sort = objectInput.readInt();

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
		objectOutput.writeLong(companyTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (label == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label);
		}

		objectOutput.writeInt(sort);

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

	public long companyTypeId;
	public String name;
	public String label;
	public int sort;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}