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

import com.mypage.user.model.MypageUserTimeline;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageUserTimeline in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageUserTimelineCacheModel
	implements CacheModel<MypageUserTimeline>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageUserTimelineCacheModel)) {
			return false;
		}

		MypageUserTimelineCacheModel mypageUserTimelineCacheModel =
			(MypageUserTimelineCacheModel)object;

		if (mypageUserTimelineId ==
				mypageUserTimelineCacheModel.mypageUserTimelineId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageUserTimelineId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mypageUserTimelineId=");
		sb.append(mypageUserTimelineId);
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
		sb.append(", imgUploadTimelineEntryId=");
		sb.append(imgUploadTimelineEntryId);
		sb.append(", imgUploadTimelineUrl=");
		sb.append(imgUploadTimelineUrl);
		sb.append(", videoUploadTimelineUrl=");
		sb.append(videoUploadTimelineUrl);
		sb.append(", text=");
		sb.append(text);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MypageUserTimeline toEntityModel() {
		MypageUserTimelineImpl mypageUserTimelineImpl =
			new MypageUserTimelineImpl();

		mypageUserTimelineImpl.setMypageUserTimelineId(mypageUserTimelineId);
		mypageUserTimelineImpl.setGroupId(groupId);
		mypageUserTimelineImpl.setCompanyId(companyId);
		mypageUserTimelineImpl.setUserId(userId);

		if (userName == null) {
			mypageUserTimelineImpl.setUserName("");
		}
		else {
			mypageUserTimelineImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageUserTimelineImpl.setCreateDate(null);
		}
		else {
			mypageUserTimelineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageUserTimelineImpl.setModifiedDate(null);
		}
		else {
			mypageUserTimelineImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageUserTimelineImpl.setMypageUserId(mypageUserId);
		mypageUserTimelineImpl.setImgUploadTimelineEntryId(
			imgUploadTimelineEntryId);

		if (imgUploadTimelineUrl == null) {
			mypageUserTimelineImpl.setImgUploadTimelineUrl("");
		}
		else {
			mypageUserTimelineImpl.setImgUploadTimelineUrl(
				imgUploadTimelineUrl);
		}

		if (videoUploadTimelineUrl == null) {
			mypageUserTimelineImpl.setVideoUploadTimelineUrl("");
		}
		else {
			mypageUserTimelineImpl.setVideoUploadTimelineUrl(
				videoUploadTimelineUrl);
		}

		if (text == null) {
			mypageUserTimelineImpl.setText("");
		}
		else {
			mypageUserTimelineImpl.setText(text);
		}

		mypageUserTimelineImpl.resetOriginalValues();

		return mypageUserTimelineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageUserTimelineId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		mypageUserId = objectInput.readLong();

		imgUploadTimelineEntryId = objectInput.readLong();
		imgUploadTimelineUrl = objectInput.readUTF();
		videoUploadTimelineUrl = objectInput.readUTF();
		text = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mypageUserTimelineId);

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

		objectOutput.writeLong(imgUploadTimelineEntryId);

		if (imgUploadTimelineUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imgUploadTimelineUrl);
		}

		if (videoUploadTimelineUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videoUploadTimelineUrl);
		}

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}
	}

	public long mypageUserTimelineId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mypageUserId;
	public long imgUploadTimelineEntryId;
	public String imgUploadTimelineUrl;
	public String videoUploadTimelineUrl;
	public String text;

}