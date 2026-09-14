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

import com.mypage.admin.product.model.Industry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Industry in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class IndustryCacheModel
	implements CacheModel<Industry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IndustryCacheModel)) {
			return false;
		}

		IndustryCacheModel industryCacheModel = (IndustryCacheModel)object;

		if (industryId == industryCacheModel.industryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, industryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{industryId=");
		sb.append(industryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", industryCategoryId=");
		sb.append(industryCategoryId);
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
	public Industry toEntityModel() {
		IndustryImpl industryImpl = new IndustryImpl();

		industryImpl.setIndustryId(industryId);

		if (name == null) {
			industryImpl.setName("");
		}
		else {
			industryImpl.setName(name);
		}

		industryImpl.setIndustryCategoryId(industryCategoryId);
		industryImpl.setActive(active);
		industryImpl.setGroupId(groupId);
		industryImpl.setCompanyId(companyId);
		industryImpl.setUserId(userId);

		if (userName == null) {
			industryImpl.setUserName("");
		}
		else {
			industryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			industryImpl.setCreateDate(null);
		}
		else {
			industryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			industryImpl.setModifiedDate(null);
		}
		else {
			industryImpl.setModifiedDate(new Date(modifiedDate));
		}

		industryImpl.resetOriginalValues();

		return industryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		industryId = objectInput.readLong();
		name = objectInput.readUTF();

		industryCategoryId = objectInput.readLong();

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
		objectOutput.writeLong(industryId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(industryCategoryId);

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

	public long industryId;
	public String name;
	public long industryCategoryId;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}