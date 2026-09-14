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

package com.mypage.user.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.user.model.CreditWallet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditWallet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CreditWalletCacheModel
	implements CacheModel<CreditWallet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CreditWalletCacheModel)) {
			return false;
		}

		CreditWalletCacheModel creditWalletCacheModel =
			(CreditWalletCacheModel)object;

		if (creditWalletId == creditWalletCacheModel.creditWalletId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, creditWalletId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{creditWalletId=");
		sb.append(creditWalletId);
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
		sb.append(", creditTypeId=");
		sb.append(creditTypeId);
		sb.append(", dateIssued=");
		sb.append(dateIssued);
		sb.append(", dateExpired=");
		sb.append(dateExpired);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditWallet toEntityModel() {
		CreditWalletImpl creditWalletImpl = new CreditWalletImpl();

		creditWalletImpl.setCreditWalletId(creditWalletId);
		creditWalletImpl.setGroupId(groupId);
		creditWalletImpl.setCompanyId(companyId);
		creditWalletImpl.setUserId(userId);

		if (userName == null) {
			creditWalletImpl.setUserName("");
		}
		else {
			creditWalletImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditWalletImpl.setCreateDate(null);
		}
		else {
			creditWalletImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditWalletImpl.setModifiedDate(null);
		}
		else {
			creditWalletImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditWalletImpl.setCreditTypeId(creditTypeId);

		if (dateIssued == Long.MIN_VALUE) {
			creditWalletImpl.setDateIssued(null);
		}
		else {
			creditWalletImpl.setDateIssued(new Date(dateIssued));
		}

		if (dateExpired == Long.MIN_VALUE) {
			creditWalletImpl.setDateExpired(null);
		}
		else {
			creditWalletImpl.setDateExpired(new Date(dateExpired));
		}

		creditWalletImpl.setAmount(amount);
		creditWalletImpl.setActive(active);

		creditWalletImpl.resetOriginalValues();

		return creditWalletImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creditWalletId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creditTypeId = objectInput.readLong();
		dateIssued = objectInput.readLong();
		dateExpired = objectInput.readLong();

		amount = objectInput.readDouble();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(creditWalletId);

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

		objectOutput.writeLong(creditTypeId);
		objectOutput.writeLong(dateIssued);
		objectOutput.writeLong(dateExpired);

		objectOutput.writeDouble(amount);

		objectOutput.writeInt(active);
	}

	public long creditWalletId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creditTypeId;
	public long dateIssued;
	public long dateExpired;
	public double amount;
	public int active;

}