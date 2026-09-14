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

import com.mypage.user.model.MypageUserWorkingHour;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageUserWorkingHour in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageUserWorkingHourCacheModel
	implements CacheModel<MypageUserWorkingHour>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageUserWorkingHourCacheModel)) {
			return false;
		}

		MypageUserWorkingHourCacheModel mypageUserWorkingHourCacheModel =
			(MypageUserWorkingHourCacheModel)object;

		if (mypageUserWorkingHourId ==
				mypageUserWorkingHourCacheModel.mypageUserWorkingHourId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageUserWorkingHourId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mypageUserWorkingHourId=");
		sb.append(mypageUserWorkingHourId);
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
		sb.append(", day=");
		sb.append(day);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MypageUserWorkingHour toEntityModel() {
		MypageUserWorkingHourImpl mypageUserWorkingHourImpl =
			new MypageUserWorkingHourImpl();

		mypageUserWorkingHourImpl.setMypageUserWorkingHourId(
			mypageUserWorkingHourId);
		mypageUserWorkingHourImpl.setGroupId(groupId);
		mypageUserWorkingHourImpl.setCompanyId(companyId);
		mypageUserWorkingHourImpl.setUserId(userId);

		if (userName == null) {
			mypageUserWorkingHourImpl.setUserName("");
		}
		else {
			mypageUserWorkingHourImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageUserWorkingHourImpl.setCreateDate(null);
		}
		else {
			mypageUserWorkingHourImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageUserWorkingHourImpl.setModifiedDate(null);
		}
		else {
			mypageUserWorkingHourImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageUserWorkingHourImpl.setMypageUserId(mypageUserId);

		if (day == null) {
			mypageUserWorkingHourImpl.setDay("");
		}
		else {
			mypageUserWorkingHourImpl.setDay(day);
		}

		if (startTime == null) {
			mypageUserWorkingHourImpl.setStartTime("");
		}
		else {
			mypageUserWorkingHourImpl.setStartTime(startTime);
		}

		if (endTime == null) {
			mypageUserWorkingHourImpl.setEndTime("");
		}
		else {
			mypageUserWorkingHourImpl.setEndTime(endTime);
		}

		mypageUserWorkingHourImpl.setStatus(status);

		mypageUserWorkingHourImpl.resetOriginalValues();

		return mypageUserWorkingHourImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageUserWorkingHourId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		mypageUserId = objectInput.readLong();
		day = objectInput.readUTF();
		startTime = objectInput.readUTF();
		endTime = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mypageUserWorkingHourId);

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

		if (day == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(day);
		}

		if (startTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startTime);
		}

		if (endTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endTime);
		}

		objectOutput.writeInt(status);
	}

	public long mypageUserWorkingHourId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mypageUserId;
	public String day;
	public String startTime;
	public String endTime;
	public int status;

}