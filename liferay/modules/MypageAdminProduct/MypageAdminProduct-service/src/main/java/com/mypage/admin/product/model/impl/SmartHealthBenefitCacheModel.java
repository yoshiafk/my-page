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

import com.mypage.admin.product.model.SmartHealthBenefit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartHealthBenefit in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartHealthBenefitCacheModel
	implements CacheModel<SmartHealthBenefit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartHealthBenefitCacheModel)) {
			return false;
		}

		SmartHealthBenefitCacheModel smartHealthBenefitCacheModel =
			(SmartHealthBenefitCacheModel)object;

		if (smartHealthBenefitId ==
				smartHealthBenefitCacheModel.smartHealthBenefitId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartHealthBenefitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{smartHealthBenefitId=");
		sb.append(smartHealthBenefitId);
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
		sb.append(", benefitTitle=");
		sb.append(benefitTitle);
		sb.append(", benefitContent=");
		sb.append(benefitContent);
		sb.append(", smartHealthBenefitGroupId=");
		sb.append(smartHealthBenefitGroupId);
		sb.append(", smartHealthPlanId=");
		sb.append(smartHealthPlanId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SmartHealthBenefit toEntityModel() {
		SmartHealthBenefitImpl smartHealthBenefitImpl =
			new SmartHealthBenefitImpl();

		smartHealthBenefitImpl.setSmartHealthBenefitId(smartHealthBenefitId);
		smartHealthBenefitImpl.setGroupId(groupId);
		smartHealthBenefitImpl.setCompanyId(companyId);
		smartHealthBenefitImpl.setUserId(userId);

		if (userName == null) {
			smartHealthBenefitImpl.setUserName("");
		}
		else {
			smartHealthBenefitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartHealthBenefitImpl.setCreateDate(null);
		}
		else {
			smartHealthBenefitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartHealthBenefitImpl.setModifiedDate(null);
		}
		else {
			smartHealthBenefitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (benefitTitle == null) {
			smartHealthBenefitImpl.setBenefitTitle("");
		}
		else {
			smartHealthBenefitImpl.setBenefitTitle(benefitTitle);
		}

		if (benefitContent == null) {
			smartHealthBenefitImpl.setBenefitContent("");
		}
		else {
			smartHealthBenefitImpl.setBenefitContent(benefitContent);
		}

		smartHealthBenefitImpl.setSmartHealthBenefitGroupId(
			smartHealthBenefitGroupId);
		smartHealthBenefitImpl.setSmartHealthPlanId(smartHealthPlanId);
		smartHealthBenefitImpl.setActive(active);

		smartHealthBenefitImpl.resetOriginalValues();

		return smartHealthBenefitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartHealthBenefitId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		benefitTitle = objectInput.readUTF();
		benefitContent = objectInput.readUTF();

		smartHealthBenefitGroupId = objectInput.readLong();

		smartHealthPlanId = objectInput.readLong();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartHealthBenefitId);

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

		if (benefitTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitTitle);
		}

		if (benefitContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitContent);
		}

		objectOutput.writeLong(smartHealthBenefitGroupId);

		objectOutput.writeLong(smartHealthPlanId);

		objectOutput.writeInt(active);
	}

	public long smartHealthBenefitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String benefitTitle;
	public String benefitContent;
	public long smartHealthBenefitGroupId;
	public long smartHealthPlanId;
	public int active;

}