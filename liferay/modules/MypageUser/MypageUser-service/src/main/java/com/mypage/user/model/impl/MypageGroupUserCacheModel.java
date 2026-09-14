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

import com.mypage.user.model.MypageGroupUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageGroupUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageGroupUserCacheModel
	implements CacheModel<MypageGroupUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageGroupUserCacheModel)) {
			return false;
		}

		MypageGroupUserCacheModel mypageGroupUserCacheModel =
			(MypageGroupUserCacheModel)object;

		if (mypageGroupUserId == mypageGroupUserCacheModel.mypageGroupUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageGroupUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{mypageGroupUserId=");
		sb.append(mypageGroupUserId);
		sb.append(", mypageGroupId=");
		sb.append(mypageGroupId);
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
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
	public MypageGroupUser toEntityModel() {
		MypageGroupUserImpl mypageGroupUserImpl = new MypageGroupUserImpl();

		mypageGroupUserImpl.setMypageGroupUserId(mypageGroupUserId);
		mypageGroupUserImpl.setMypageGroupId(mypageGroupId);
		mypageGroupUserImpl.setMypageUserId(mypageUserId);
		mypageGroupUserImpl.setGroupId(groupId);
		mypageGroupUserImpl.setCompanyId(companyId);
		mypageGroupUserImpl.setUserId(userId);

		if (userName == null) {
			mypageGroupUserImpl.setUserName("");
		}
		else {
			mypageGroupUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageGroupUserImpl.setCreateDate(null);
		}
		else {
			mypageGroupUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageGroupUserImpl.setModifiedDate(null);
		}
		else {
			mypageGroupUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageGroupUserImpl.resetOriginalValues();

		return mypageGroupUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageGroupUserId = objectInput.readLong();

		mypageGroupId = objectInput.readLong();

		mypageUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mypageGroupUserId);

		objectOutput.writeLong(mypageGroupId);

		objectOutput.writeLong(mypageUserId);

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

	public long mypageGroupUserId;
	public long mypageGroupId;
	public long mypageUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}