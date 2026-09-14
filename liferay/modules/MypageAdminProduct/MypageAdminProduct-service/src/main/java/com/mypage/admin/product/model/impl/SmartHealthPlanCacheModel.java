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

import com.mypage.admin.product.model.SmartHealthPlan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartHealthPlan in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartHealthPlanCacheModel
	implements CacheModel<SmartHealthPlan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartHealthPlanCacheModel)) {
			return false;
		}

		SmartHealthPlanCacheModel smartHealthPlanCacheModel =
			(SmartHealthPlanCacheModel)object;

		if (smartHealthPlanId == smartHealthPlanCacheModel.smartHealthPlanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartHealthPlanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{smartHealthPlanId=");
		sb.append(smartHealthPlanId);
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
		sb.append(", planName=");
		sb.append(planName);
		sb.append(", planGroup=");
		sb.append(planGroup);
		sb.append(", isRecommended=");
		sb.append(isRecommended);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SmartHealthPlan toEntityModel() {
		SmartHealthPlanImpl smartHealthPlanImpl = new SmartHealthPlanImpl();

		smartHealthPlanImpl.setSmartHealthPlanId(smartHealthPlanId);
		smartHealthPlanImpl.setGroupId(groupId);
		smartHealthPlanImpl.setCompanyId(companyId);
		smartHealthPlanImpl.setUserId(userId);

		if (userName == null) {
			smartHealthPlanImpl.setUserName("");
		}
		else {
			smartHealthPlanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartHealthPlanImpl.setCreateDate(null);
		}
		else {
			smartHealthPlanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartHealthPlanImpl.setModifiedDate(null);
		}
		else {
			smartHealthPlanImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (planName == null) {
			smartHealthPlanImpl.setPlanName("");
		}
		else {
			smartHealthPlanImpl.setPlanName(planName);
		}

		if (planGroup == null) {
			smartHealthPlanImpl.setPlanGroup("");
		}
		else {
			smartHealthPlanImpl.setPlanGroup(planGroup);
		}

		smartHealthPlanImpl.setIsRecommended(isRecommended);
		smartHealthPlanImpl.setActive(active);

		smartHealthPlanImpl.resetOriginalValues();

		return smartHealthPlanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartHealthPlanId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		planName = objectInput.readUTF();
		planGroup = objectInput.readUTF();

		isRecommended = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartHealthPlanId);

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

		if (planName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(planName);
		}

		if (planGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(planGroup);
		}

		objectOutput.writeInt(isRecommended);

		objectOutput.writeInt(active);
	}

	public long smartHealthPlanId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String planName;
	public String planGroup;
	public int isRecommended;
	public int active;

}