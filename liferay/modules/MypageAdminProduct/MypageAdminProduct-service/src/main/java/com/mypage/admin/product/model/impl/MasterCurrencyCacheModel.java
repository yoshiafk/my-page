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

import com.mypage.admin.product.model.MasterCurrency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterCurrency in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterCurrencyCacheModel
	implements CacheModel<MasterCurrency>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterCurrencyCacheModel)) {
			return false;
		}

		MasterCurrencyCacheModel masterCurrencyCacheModel =
			(MasterCurrencyCacheModel)object;

		if (currencyId == masterCurrencyCacheModel.currencyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, currencyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{currencyId=");
		sb.append(currencyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", isDefault=");
		sb.append(isDefault);
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
	public MasterCurrency toEntityModel() {
		MasterCurrencyImpl masterCurrencyImpl = new MasterCurrencyImpl();

		masterCurrencyImpl.setCurrencyId(currencyId);

		if (name == null) {
			masterCurrencyImpl.setName("");
		}
		else {
			masterCurrencyImpl.setName(name);
		}

		masterCurrencyImpl.setAmount(amount);
		masterCurrencyImpl.setIsDefault(isDefault);
		masterCurrencyImpl.setActive(active);
		masterCurrencyImpl.setGroupId(groupId);
		masterCurrencyImpl.setCompanyId(companyId);
		masterCurrencyImpl.setUserId(userId);

		if (userName == null) {
			masterCurrencyImpl.setUserName("");
		}
		else {
			masterCurrencyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterCurrencyImpl.setCreateDate(null);
		}
		else {
			masterCurrencyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterCurrencyImpl.setModifiedDate(null);
		}
		else {
			masterCurrencyImpl.setModifiedDate(new Date(modifiedDate));
		}

		masterCurrencyImpl.resetOriginalValues();

		return masterCurrencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		currencyId = objectInput.readLong();
		name = objectInput.readUTF();

		amount = objectInput.readDouble();

		isDefault = objectInput.readInt();

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
		objectOutput.writeLong(currencyId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(amount);

		objectOutput.writeInt(isDefault);

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

	public long currencyId;
	public String name;
	public double amount;
	public int isDefault;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}