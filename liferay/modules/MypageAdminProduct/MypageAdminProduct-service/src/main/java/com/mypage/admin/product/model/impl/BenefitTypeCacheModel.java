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

import com.mypage.admin.product.model.BenefitType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BenefitType in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class BenefitTypeCacheModel
	implements CacheModel<BenefitType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BenefitTypeCacheModel)) {
			return false;
		}

		BenefitTypeCacheModel benefitTypeCacheModel =
			(BenefitTypeCacheModel)object;

		if (benefitTypeId == benefitTypeCacheModel.benefitTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, benefitTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{benefitTypeId=");
		sb.append(benefitTypeId);
		sb.append(", nameId=");
		sb.append(nameId);
		sb.append(", nameEn=");
		sb.append(nameEn);
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
	public BenefitType toEntityModel() {
		BenefitTypeImpl benefitTypeImpl = new BenefitTypeImpl();

		benefitTypeImpl.setBenefitTypeId(benefitTypeId);

		if (nameId == null) {
			benefitTypeImpl.setNameId("");
		}
		else {
			benefitTypeImpl.setNameId(nameId);
		}

		if (nameEn == null) {
			benefitTypeImpl.setNameEn("");
		}
		else {
			benefitTypeImpl.setNameEn(nameEn);
		}

		benefitTypeImpl.setSort(sort);
		benefitTypeImpl.setActive(active);
		benefitTypeImpl.setGroupId(groupId);
		benefitTypeImpl.setCompanyId(companyId);
		benefitTypeImpl.setUserId(userId);

		if (userName == null) {
			benefitTypeImpl.setUserName("");
		}
		else {
			benefitTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			benefitTypeImpl.setCreateDate(null);
		}
		else {
			benefitTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			benefitTypeImpl.setModifiedDate(null);
		}
		else {
			benefitTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		benefitTypeImpl.resetOriginalValues();

		return benefitTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		benefitTypeId = objectInput.readLong();
		nameId = objectInput.readUTF();
		nameEn = objectInput.readUTF();

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
		objectOutput.writeLong(benefitTypeId);

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

	public long benefitTypeId;
	public String nameId;
	public String nameEn;
	public int sort;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}