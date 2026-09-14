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

import com.mypage.admin.product.model.SmartActiveToproBenefitMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveToproBenefitMapping in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveToproBenefitMappingCacheModel
	implements CacheModel<SmartActiveToproBenefitMapping>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveToproBenefitMappingCacheModel)) {
			return false;
		}

		SmartActiveToproBenefitMappingCacheModel
			smartActiveToproBenefitMappingCacheModel =
				(SmartActiveToproBenefitMappingCacheModel)object;

		if (smartActiveToproBenefitMappingId ==
				smartActiveToproBenefitMappingCacheModel.
					smartActiveToproBenefitMappingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveToproBenefitMappingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{smartActiveToproBenefitMappingId=");
		sb.append(smartActiveToproBenefitMappingId);
		sb.append(", smartActiveToproId=");
		sb.append(smartActiveToproId);
		sb.append(", ListBenefitId=");
		sb.append(ListBenefitId);
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
	public SmartActiveToproBenefitMapping toEntityModel() {
		SmartActiveToproBenefitMappingImpl smartActiveToproBenefitMappingImpl =
			new SmartActiveToproBenefitMappingImpl();

		smartActiveToproBenefitMappingImpl.setSmartActiveToproBenefitMappingId(
			smartActiveToproBenefitMappingId);
		smartActiveToproBenefitMappingImpl.setSmartActiveToproId(
			smartActiveToproId);

		if (ListBenefitId == null) {
			smartActiveToproBenefitMappingImpl.setListBenefitId("");
		}
		else {
			smartActiveToproBenefitMappingImpl.setListBenefitId(ListBenefitId);
		}

		smartActiveToproBenefitMappingImpl.setActive(active);
		smartActiveToproBenefitMappingImpl.setGroupId(groupId);
		smartActiveToproBenefitMappingImpl.setCompanyId(companyId);
		smartActiveToproBenefitMappingImpl.setUserId(userId);

		if (userName == null) {
			smartActiveToproBenefitMappingImpl.setUserName("");
		}
		else {
			smartActiveToproBenefitMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveToproBenefitMappingImpl.setCreateDate(null);
		}
		else {
			smartActiveToproBenefitMappingImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveToproBenefitMappingImpl.setModifiedDate(null);
		}
		else {
			smartActiveToproBenefitMappingImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		smartActiveToproBenefitMappingImpl.resetOriginalValues();

		return smartActiveToproBenefitMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveToproBenefitMappingId = objectInput.readLong();

		smartActiveToproId = objectInput.readLong();
		ListBenefitId = objectInput.readUTF();

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
		objectOutput.writeLong(smartActiveToproBenefitMappingId);

		objectOutput.writeLong(smartActiveToproId);

		if (ListBenefitId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ListBenefitId);
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

	public long smartActiveToproBenefitMappingId;
	public long smartActiveToproId;
	public String ListBenefitId;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}