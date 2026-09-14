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

import com.mypage.admin.product.model.PersonalAccidentPremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersonalAccidentPremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PersonalAccidentPremiCacheModel
	implements CacheModel<PersonalAccidentPremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersonalAccidentPremiCacheModel)) {
			return false;
		}

		PersonalAccidentPremiCacheModel personalAccidentPremiCacheModel =
			(PersonalAccidentPremiCacheModel)object;

		if (personalAccidentPremiId ==
				personalAccidentPremiCacheModel.personalAccidentPremiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personalAccidentPremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{personalAccidentPremiId=");
		sb.append(personalAccidentPremiId);
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
		sb.append(", premiType=");
		sb.append(premiType);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersonalAccidentPremi toEntityModel() {
		PersonalAccidentPremiImpl personalAccidentPremiImpl =
			new PersonalAccidentPremiImpl();

		personalAccidentPremiImpl.setPersonalAccidentPremiId(
			personalAccidentPremiId);
		personalAccidentPremiImpl.setGroupId(groupId);
		personalAccidentPremiImpl.setCompanyId(companyId);
		personalAccidentPremiImpl.setUserId(userId);

		if (userName == null) {
			personalAccidentPremiImpl.setUserName("");
		}
		else {
			personalAccidentPremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personalAccidentPremiImpl.setCreateDate(null);
		}
		else {
			personalAccidentPremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personalAccidentPremiImpl.setModifiedDate(null);
		}
		else {
			personalAccidentPremiImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (premiType == null) {
			personalAccidentPremiImpl.setPremiType("");
		}
		else {
			personalAccidentPremiImpl.setPremiType(premiType);
		}

		personalAccidentPremiImpl.setAmount(amount);
		personalAccidentPremiImpl.setActive(active);

		personalAccidentPremiImpl.resetOriginalValues();

		return personalAccidentPremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personalAccidentPremiId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		premiType = objectInput.readUTF();

		amount = objectInput.readDouble();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(personalAccidentPremiId);

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

		if (premiType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(premiType);
		}

		objectOutput.writeDouble(amount);

		objectOutput.writeInt(active);
	}

	public long personalAccidentPremiId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String premiType;
	public double amount;
	public int active;

}