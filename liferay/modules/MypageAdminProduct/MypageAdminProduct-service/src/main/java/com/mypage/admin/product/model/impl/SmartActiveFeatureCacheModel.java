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

import com.mypage.admin.product.model.SmartActiveFeature;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveFeature in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveFeatureCacheModel
	implements CacheModel<SmartActiveFeature>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveFeatureCacheModel)) {
			return false;
		}

		SmartActiveFeatureCacheModel smartActiveFeatureCacheModel =
			(SmartActiveFeatureCacheModel)object;

		if (smartActiveFeatureId ==
				smartActiveFeatureCacheModel.smartActiveFeatureId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveFeatureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{smartActiveFeatureId=");
		sb.append(smartActiveFeatureId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", fileUploadEntryId=");
		sb.append(fileUploadEntryId);
		sb.append(", fileUploadUrl=");
		sb.append(fileUploadUrl);
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
	public SmartActiveFeature toEntityModel() {
		SmartActiveFeatureImpl smartActiveFeatureImpl =
			new SmartActiveFeatureImpl();

		smartActiveFeatureImpl.setSmartActiveFeatureId(smartActiveFeatureId);

		if (title == null) {
			smartActiveFeatureImpl.setTitle("");
		}
		else {
			smartActiveFeatureImpl.setTitle(title);
		}

		if (description == null) {
			smartActiveFeatureImpl.setDescription("");
		}
		else {
			smartActiveFeatureImpl.setDescription(description);
		}

		smartActiveFeatureImpl.setFileUploadEntryId(fileUploadEntryId);

		if (fileUploadUrl == null) {
			smartActiveFeatureImpl.setFileUploadUrl("");
		}
		else {
			smartActiveFeatureImpl.setFileUploadUrl(fileUploadUrl);
		}

		smartActiveFeatureImpl.setSort(sort);
		smartActiveFeatureImpl.setActive(active);
		smartActiveFeatureImpl.setGroupId(groupId);
		smartActiveFeatureImpl.setCompanyId(companyId);
		smartActiveFeatureImpl.setUserId(userId);

		if (userName == null) {
			smartActiveFeatureImpl.setUserName("");
		}
		else {
			smartActiveFeatureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveFeatureImpl.setCreateDate(null);
		}
		else {
			smartActiveFeatureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveFeatureImpl.setModifiedDate(null);
		}
		else {
			smartActiveFeatureImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveFeatureImpl.resetOriginalValues();

		return smartActiveFeatureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveFeatureId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		fileUploadEntryId = objectInput.readLong();
		fileUploadUrl = objectInput.readUTF();

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
		objectOutput.writeLong(smartActiveFeatureId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(fileUploadEntryId);

		if (fileUploadUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileUploadUrl);
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

	public long smartActiveFeatureId;
	public String title;
	public String description;
	public long fileUploadEntryId;
	public String fileUploadUrl;
	public int sort;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}