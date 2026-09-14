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

import com.mypage.admin.product.model.ReferenceNumber;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReferenceNumber in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class ReferenceNumberCacheModel
	implements CacheModel<ReferenceNumber>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReferenceNumberCacheModel)) {
			return false;
		}

		ReferenceNumberCacheModel referenceNumberCacheModel =
			(ReferenceNumberCacheModel)object;

		if (referenceNumberId == referenceNumberCacheModel.referenceNumberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, referenceNumberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{referenceNumberId=");
		sb.append(referenceNumberId);
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
		sb.append(", userRole=");
		sb.append(userRole);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", type=");
		sb.append(type);
		sb.append(", productCode=");
		sb.append(productCode);
		sb.append(", businessType=");
		sb.append(businessType);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", prefix=");
		sb.append(prefix);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReferenceNumber toEntityModel() {
		ReferenceNumberImpl referenceNumberImpl = new ReferenceNumberImpl();

		referenceNumberImpl.setReferenceNumberId(referenceNumberId);
		referenceNumberImpl.setGroupId(groupId);
		referenceNumberImpl.setCompanyId(companyId);
		referenceNumberImpl.setUserId(userId);

		if (userName == null) {
			referenceNumberImpl.setUserName("");
		}
		else {
			referenceNumberImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			referenceNumberImpl.setCreateDate(null);
		}
		else {
			referenceNumberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			referenceNumberImpl.setModifiedDate(null);
		}
		else {
			referenceNumberImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userRole == null) {
			referenceNumberImpl.setUserRole("");
		}
		else {
			referenceNumberImpl.setUserRole(userRole);
		}

		if (channel == null) {
			referenceNumberImpl.setChannel("");
		}
		else {
			referenceNumberImpl.setChannel(channel);
		}

		if (type == null) {
			referenceNumberImpl.setType("");
		}
		else {
			referenceNumberImpl.setType(type);
		}

		if (productCode == null) {
			referenceNumberImpl.setProductCode("");
		}
		else {
			referenceNumberImpl.setProductCode(productCode);
		}

		if (businessType == null) {
			referenceNumberImpl.setBusinessType("");
		}
		else {
			referenceNumberImpl.setBusinessType(businessType);
		}

		if (currency == null) {
			referenceNumberImpl.setCurrency("");
		}
		else {
			referenceNumberImpl.setCurrency(currency);
		}

		if (prefix == null) {
			referenceNumberImpl.setPrefix("");
		}
		else {
			referenceNumberImpl.setPrefix(prefix);
		}

		referenceNumberImpl.setActive(active);

		referenceNumberImpl.resetOriginalValues();

		return referenceNumberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		referenceNumberId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userRole = objectInput.readUTF();
		channel = objectInput.readUTF();
		type = objectInput.readUTF();
		productCode = objectInput.readUTF();
		businessType = objectInput.readUTF();
		currency = objectInput.readUTF();
		prefix = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(referenceNumberId);

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

		if (userRole == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userRole);
		}

		if (channel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(channel);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (productCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCode);
		}

		if (businessType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessType);
		}

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		if (prefix == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prefix);
		}

		objectOutput.writeInt(active);
	}

	public long referenceNumberId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String userRole;
	public String channel;
	public String type;
	public String productCode;
	public String businessType;
	public String currency;
	public String prefix;
	public int active;

}