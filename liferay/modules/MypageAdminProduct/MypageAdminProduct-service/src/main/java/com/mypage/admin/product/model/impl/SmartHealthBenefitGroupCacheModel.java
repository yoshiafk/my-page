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

import com.mypage.admin.product.model.SmartHealthBenefitGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartHealthBenefitGroup in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartHealthBenefitGroupCacheModel
	implements CacheModel<SmartHealthBenefitGroup>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartHealthBenefitGroupCacheModel)) {
			return false;
		}

		SmartHealthBenefitGroupCacheModel smartHealthBenefitGroupCacheModel =
			(SmartHealthBenefitGroupCacheModel)object;

		if (smartHealthBenefitGroupId ==
				smartHealthBenefitGroupCacheModel.smartHealthBenefitGroupId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartHealthBenefitGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{smartHealthBenefitGroupId=");
		sb.append(smartHealthBenefitGroupId);
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
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", groupDescription=");
		sb.append(groupDescription);
		sb.append(", groupCode=");
		sb.append(groupCode);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SmartHealthBenefitGroup toEntityModel() {
		SmartHealthBenefitGroupImpl smartHealthBenefitGroupImpl =
			new SmartHealthBenefitGroupImpl();

		smartHealthBenefitGroupImpl.setSmartHealthBenefitGroupId(
			smartHealthBenefitGroupId);
		smartHealthBenefitGroupImpl.setGroupId(groupId);
		smartHealthBenefitGroupImpl.setCompanyId(companyId);
		smartHealthBenefitGroupImpl.setUserId(userId);

		if (userName == null) {
			smartHealthBenefitGroupImpl.setUserName("");
		}
		else {
			smartHealthBenefitGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartHealthBenefitGroupImpl.setCreateDate(null);
		}
		else {
			smartHealthBenefitGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartHealthBenefitGroupImpl.setModifiedDate(null);
		}
		else {
			smartHealthBenefitGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (groupName == null) {
			smartHealthBenefitGroupImpl.setGroupName("");
		}
		else {
			smartHealthBenefitGroupImpl.setGroupName(groupName);
		}

		if (groupDescription == null) {
			smartHealthBenefitGroupImpl.setGroupDescription("");
		}
		else {
			smartHealthBenefitGroupImpl.setGroupDescription(groupDescription);
		}

		if (groupCode == null) {
			smartHealthBenefitGroupImpl.setGroupCode("");
		}
		else {
			smartHealthBenefitGroupImpl.setGroupCode(groupCode);
		}

		smartHealthBenefitGroupImpl.setActive(active);

		smartHealthBenefitGroupImpl.resetOriginalValues();

		return smartHealthBenefitGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartHealthBenefitGroupId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupName = objectInput.readUTF();
		groupDescription = objectInput.readUTF();
		groupCode = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartHealthBenefitGroupId);

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

		if (groupName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (groupDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupDescription);
		}

		if (groupCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupCode);
		}

		objectOutput.writeInt(active);
	}

	public long smartHealthBenefitGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String groupName;
	public String groupDescription;
	public String groupCode;
	public int active;

}