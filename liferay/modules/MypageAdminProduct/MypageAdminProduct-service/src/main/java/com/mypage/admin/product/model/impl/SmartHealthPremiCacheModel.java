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

import com.mypage.admin.product.model.SmartHealthPremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartHealthPremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartHealthPremiCacheModel
	implements CacheModel<SmartHealthPremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartHealthPremiCacheModel)) {
			return false;
		}

		SmartHealthPremiCacheModel smartHealthPremiCacheModel =
			(SmartHealthPremiCacheModel)object;

		if (smartHealthPremiId ==
				smartHealthPremiCacheModel.smartHealthPremiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartHealthPremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{smartHealthPremiId=");
		sb.append(smartHealthPremiId);
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
		sb.append(", age=");
		sb.append(age);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", planId=");
		sb.append(planId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SmartHealthPremi toEntityModel() {
		SmartHealthPremiImpl smartHealthPremiImpl = new SmartHealthPremiImpl();

		smartHealthPremiImpl.setSmartHealthPremiId(smartHealthPremiId);
		smartHealthPremiImpl.setGroupId(groupId);
		smartHealthPremiImpl.setCompanyId(companyId);
		smartHealthPremiImpl.setUserId(userId);

		if (userName == null) {
			smartHealthPremiImpl.setUserName("");
		}
		else {
			smartHealthPremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartHealthPremiImpl.setCreateDate(null);
		}
		else {
			smartHealthPremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartHealthPremiImpl.setModifiedDate(null);
		}
		else {
			smartHealthPremiImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartHealthPremiImpl.setAge(age);

		if (gender == null) {
			smartHealthPremiImpl.setGender("");
		}
		else {
			smartHealthPremiImpl.setGender(gender);
		}

		if (currency == null) {
			smartHealthPremiImpl.setCurrency("");
		}
		else {
			smartHealthPremiImpl.setCurrency(currency);
		}

		smartHealthPremiImpl.setAmount(amount);
		smartHealthPremiImpl.setPlanId(planId);
		smartHealthPremiImpl.setStatus(status);

		smartHealthPremiImpl.resetOriginalValues();

		return smartHealthPremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartHealthPremiId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		age = objectInput.readInt();
		gender = objectInput.readUTF();
		currency = objectInput.readUTF();

		amount = objectInput.readDouble();

		planId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartHealthPremiId);

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

		objectOutput.writeInt(age);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeDouble(amount);

		objectOutput.writeLong(planId);

		objectOutput.writeInt(status);
	}

	public long smartHealthPremiId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int age;
	public String gender;
	public String currency;
	public double amount;
	public long planId;
	public int status;

}