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

import com.mypage.user.model.MypageUserRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageUserRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageUserRoleCacheModel
	implements CacheModel<MypageUserRole>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageUserRoleCacheModel)) {
			return false;
		}

		MypageUserRoleCacheModel mypageUserRoleCacheModel =
			(MypageUserRoleCacheModel)object;

		if (mypageUserRoleId == mypageUserRoleCacheModel.mypageUserRoleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageUserRoleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{mypageUserRoleId=");
		sb.append(mypageUserRoleId);
		sb.append(", name=");
		sb.append(name);
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
	public MypageUserRole toEntityModel() {
		MypageUserRoleImpl mypageUserRoleImpl = new MypageUserRoleImpl();

		mypageUserRoleImpl.setMypageUserRoleId(mypageUserRoleId);

		if (name == null) {
			mypageUserRoleImpl.setName("");
		}
		else {
			mypageUserRoleImpl.setName(name);
		}

		mypageUserRoleImpl.setActive(active);
		mypageUserRoleImpl.setGroupId(groupId);
		mypageUserRoleImpl.setCompanyId(companyId);
		mypageUserRoleImpl.setUserId(userId);

		if (userName == null) {
			mypageUserRoleImpl.setUserName("");
		}
		else {
			mypageUserRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageUserRoleImpl.setCreateDate(null);
		}
		else {
			mypageUserRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageUserRoleImpl.setModifiedDate(null);
		}
		else {
			mypageUserRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageUserRoleImpl.resetOriginalValues();

		return mypageUserRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageUserRoleId = objectInput.readLong();
		name = objectInput.readUTF();

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
		objectOutput.writeLong(mypageUserRoleId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
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

	public long mypageUserRoleId;
	public String name;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}