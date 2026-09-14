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

import com.mypage.user.model.UserOneTimeCode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserOneTimeCode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserOneTimeCodeCacheModel
	implements CacheModel<UserOneTimeCode>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserOneTimeCodeCacheModel)) {
			return false;
		}

		UserOneTimeCodeCacheModel userOneTimeCodeCacheModel =
			(UserOneTimeCodeCacheModel)object;

		if (userOneTimeCodeId == userOneTimeCodeCacheModel.userOneTimeCodeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userOneTimeCodeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{userOneTimeCodeId=");
		sb.append(userOneTimeCodeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", sharedSecret=");
		sb.append(sharedSecret);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", TimestampExpiryDate=");
		sb.append(TimestampExpiryDate);
		sb.append(", isUsed=");
		sb.append(isUsed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserOneTimeCode toEntityModel() {
		UserOneTimeCodeImpl userOneTimeCodeImpl = new UserOneTimeCodeImpl();

		userOneTimeCodeImpl.setUserOneTimeCodeId(userOneTimeCodeId);
		userOneTimeCodeImpl.setGroupId(groupId);
		userOneTimeCodeImpl.setCompanyId(companyId);
		userOneTimeCodeImpl.setUserId(userId);

		if (sharedSecret == null) {
			userOneTimeCodeImpl.setSharedSecret("");
		}
		else {
			userOneTimeCodeImpl.setSharedSecret(sharedSecret);
		}

		if (createDate == Long.MIN_VALUE) {
			userOneTimeCodeImpl.setCreateDate(null);
		}
		else {
			userOneTimeCodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userOneTimeCodeImpl.setModifiedDate(null);
		}
		else {
			userOneTimeCodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (expiryDate == Long.MIN_VALUE) {
			userOneTimeCodeImpl.setExpiryDate(null);
		}
		else {
			userOneTimeCodeImpl.setExpiryDate(new Date(expiryDate));
		}

		userOneTimeCodeImpl.setTimestampExpiryDate(TimestampExpiryDate);
		userOneTimeCodeImpl.setIsUsed(isUsed);

		userOneTimeCodeImpl.resetOriginalValues();

		return userOneTimeCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userOneTimeCodeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		sharedSecret = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		expiryDate = objectInput.readLong();

		TimestampExpiryDate = objectInput.readLong();

		isUsed = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userOneTimeCodeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (sharedSecret == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sharedSecret);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(expiryDate);

		objectOutput.writeLong(TimestampExpiryDate);

		objectOutput.writeInt(isUsed);
	}

	public long userOneTimeCodeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String sharedSecret;
	public long createDate;
	public long modifiedDate;
	public long expiryDate;
	public long TimestampExpiryDate;
	public int isUsed;

}