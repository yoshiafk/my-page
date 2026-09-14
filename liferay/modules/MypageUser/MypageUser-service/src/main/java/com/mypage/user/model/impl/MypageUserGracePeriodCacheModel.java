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

import com.mypage.user.model.MypageUserGracePeriod;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageUserGracePeriod in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageUserGracePeriodCacheModel
	implements CacheModel<MypageUserGracePeriod>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageUserGracePeriodCacheModel)) {
			return false;
		}

		MypageUserGracePeriodCacheModel mypageUserGracePeriodCacheModel =
			(MypageUserGracePeriodCacheModel)object;

		if (mypageUserGracePeriodId ==
				mypageUserGracePeriodCacheModel.mypageUserGracePeriodId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageUserGracePeriodId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{mypageUserGracePeriodId=");
		sb.append(mypageUserGracePeriodId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MypageUserGracePeriod toEntityModel() {
		MypageUserGracePeriodImpl mypageUserGracePeriodImpl =
			new MypageUserGracePeriodImpl();

		mypageUserGracePeriodImpl.setMypageUserGracePeriodId(
			mypageUserGracePeriodId);
		mypageUserGracePeriodImpl.setGroupId(groupId);
		mypageUserGracePeriodImpl.setCompanyId(companyId);
		mypageUserGracePeriodImpl.setUserId(userId);

		if (userName == null) {
			mypageUserGracePeriodImpl.setUserName("");
		}
		else {
			mypageUserGracePeriodImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageUserGracePeriodImpl.setCreateDate(null);
		}
		else {
			mypageUserGracePeriodImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageUserGracePeriodImpl.setModifiedDate(null);
		}
		else {
			mypageUserGracePeriodImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageUserGracePeriodImpl.setMypageUserId(mypageUserId);

		if (code == null) {
			mypageUserGracePeriodImpl.setCode("");
		}
		else {
			mypageUserGracePeriodImpl.setCode(code);
		}

		mypageUserGracePeriodImpl.setValue(value);

		mypageUserGracePeriodImpl.resetOriginalValues();

		return mypageUserGracePeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageUserGracePeriodId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		mypageUserId = objectInput.readLong();
		code = objectInput.readUTF();

		value = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mypageUserGracePeriodId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(value);
	}

	public long mypageUserGracePeriodId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mypageUserId;
	public String code;
	public int value;

}