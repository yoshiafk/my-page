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

import com.mypage.admin.product.model.SmartActiveLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveLink in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveLinkCacheModel
	implements CacheModel<SmartActiveLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveLinkCacheModel)) {
			return false;
		}

		SmartActiveLinkCacheModel smartActiveLinkCacheModel =
			(SmartActiveLinkCacheModel)object;

		if (smartActiveLinkId == smartActiveLinkCacheModel.smartActiveLinkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{smartActiveLinkId=");
		sb.append(smartActiveLinkId);
		sb.append(", category=");
		sb.append(category);
		sb.append(", title=");
		sb.append(title);
		sb.append(", fileUploadEntryId=");
		sb.append(fileUploadEntryId);
		sb.append(", fileUploadUrl=");
		sb.append(fileUploadUrl);
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
	public SmartActiveLink toEntityModel() {
		SmartActiveLinkImpl smartActiveLinkImpl = new SmartActiveLinkImpl();

		smartActiveLinkImpl.setSmartActiveLinkId(smartActiveLinkId);

		if (category == null) {
			smartActiveLinkImpl.setCategory("");
		}
		else {
			smartActiveLinkImpl.setCategory(category);
		}

		if (title == null) {
			smartActiveLinkImpl.setTitle("");
		}
		else {
			smartActiveLinkImpl.setTitle(title);
		}

		smartActiveLinkImpl.setFileUploadEntryId(fileUploadEntryId);

		if (fileUploadUrl == null) {
			smartActiveLinkImpl.setFileUploadUrl("");
		}
		else {
			smartActiveLinkImpl.setFileUploadUrl(fileUploadUrl);
		}

		smartActiveLinkImpl.setActive(active);
		smartActiveLinkImpl.setGroupId(groupId);
		smartActiveLinkImpl.setCompanyId(companyId);
		smartActiveLinkImpl.setUserId(userId);

		if (userName == null) {
			smartActiveLinkImpl.setUserName("");
		}
		else {
			smartActiveLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveLinkImpl.setCreateDate(null);
		}
		else {
			smartActiveLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveLinkImpl.setModifiedDate(null);
		}
		else {
			smartActiveLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveLinkImpl.resetOriginalValues();

		return smartActiveLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveLinkId = objectInput.readLong();
		category = objectInput.readUTF();
		title = objectInput.readUTF();

		fileUploadEntryId = objectInput.readLong();
		fileUploadUrl = objectInput.readUTF();

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
		objectOutput.writeLong(smartActiveLinkId);

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(fileUploadEntryId);

		if (fileUploadUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileUploadUrl);
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

	public long smartActiveLinkId;
	public String category;
	public String title;
	public long fileUploadEntryId;
	public String fileUploadUrl;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}