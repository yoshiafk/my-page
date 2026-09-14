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

import com.mypage.admin.product.model.SmartActiveClass;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveClass in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveClassCacheModel
	implements CacheModel<SmartActiveClass>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveClassCacheModel)) {
			return false;
		}

		SmartActiveClassCacheModel smartActiveClassCacheModel =
			(SmartActiveClassCacheModel)object;

		if (smartActiveClassId ==
				smartActiveClassCacheModel.smartActiveClassId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveClassId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{smartActiveClassId=");
		sb.append(smartActiveClassId);
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
	public SmartActiveClass toEntityModel() {
		SmartActiveClassImpl smartActiveClassImpl = new SmartActiveClassImpl();

		smartActiveClassImpl.setSmartActiveClassId(smartActiveClassId);

		if (nameId == null) {
			smartActiveClassImpl.setNameId("");
		}
		else {
			smartActiveClassImpl.setNameId(nameId);
		}

		if (nameEn == null) {
			smartActiveClassImpl.setNameEn("");
		}
		else {
			smartActiveClassImpl.setNameEn(nameEn);
		}

		smartActiveClassImpl.setActive(active);
		smartActiveClassImpl.setGroupId(groupId);
		smartActiveClassImpl.setCompanyId(companyId);
		smartActiveClassImpl.setUserId(userId);

		if (userName == null) {
			smartActiveClassImpl.setUserName("");
		}
		else {
			smartActiveClassImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveClassImpl.setCreateDate(null);
		}
		else {
			smartActiveClassImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveClassImpl.setModifiedDate(null);
		}
		else {
			smartActiveClassImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveClassImpl.resetOriginalValues();

		return smartActiveClassImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveClassId = objectInput.readLong();
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
		objectOutput.writeLong(smartActiveClassId);

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

	public long smartActiveClassId;
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