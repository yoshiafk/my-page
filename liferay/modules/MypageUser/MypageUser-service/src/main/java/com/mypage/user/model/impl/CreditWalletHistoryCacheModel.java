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

import com.mypage.user.model.CreditWalletHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditWalletHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CreditWalletHistoryCacheModel
	implements CacheModel<CreditWalletHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CreditWalletHistoryCacheModel)) {
			return false;
		}

		CreditWalletHistoryCacheModel creditWalletHistoryCacheModel =
			(CreditWalletHistoryCacheModel)object;

		if (creditWalletHistoryId ==
				creditWalletHistoryCacheModel.creditWalletHistoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, creditWalletHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{creditWalletHistoryId=");
		sb.append(creditWalletHistoryId);
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
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
		sb.append(", creditWalletId=");
		sb.append(creditWalletId);
		sb.append(", leadsId=");
		sb.append(leadsId);
		sb.append(", operation=");
		sb.append(operation);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CreditWalletHistory toEntityModel() {
		CreditWalletHistoryImpl creditWalletHistoryImpl =
			new CreditWalletHistoryImpl();

		creditWalletHistoryImpl.setCreditWalletHistoryId(creditWalletHistoryId);
		creditWalletHistoryImpl.setGroupId(groupId);
		creditWalletHistoryImpl.setCompanyId(companyId);
		creditWalletHistoryImpl.setUserId(userId);

		if (userName == null) {
			creditWalletHistoryImpl.setUserName("");
		}
		else {
			creditWalletHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creditWalletHistoryImpl.setCreateDate(null);
		}
		else {
			creditWalletHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creditWalletHistoryImpl.setModifiedDate(null);
		}
		else {
			creditWalletHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditWalletHistoryImpl.setMypageUserId(mypageUserId);
		creditWalletHistoryImpl.setCreditWalletId(creditWalletId);
		creditWalletHistoryImpl.setLeadsId(leadsId);

		if (operation == null) {
			creditWalletHistoryImpl.setOperation("");
		}
		else {
			creditWalletHistoryImpl.setOperation(operation);
		}

		creditWalletHistoryImpl.setAmount(amount);
		creditWalletHistoryImpl.setActive(active);

		creditWalletHistoryImpl.resetOriginalValues();

		return creditWalletHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creditWalletHistoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		mypageUserId = objectInput.readLong();

		creditWalletId = objectInput.readLong();

		leadsId = objectInput.readLong();
		operation = objectInput.readUTF();

		amount = objectInput.readDouble();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(creditWalletHistoryId);

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

		objectOutput.writeLong(mypageUserId);

		objectOutput.writeLong(creditWalletId);

		objectOutput.writeLong(leadsId);

		if (operation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(operation);
		}

		objectOutput.writeDouble(amount);

		objectOutput.writeInt(active);
	}

	public long creditWalletHistoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mypageUserId;
	public long creditWalletId;
	public long leadsId;
	public String operation;
	public double amount;
	public int active;

}