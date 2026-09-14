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

import com.mypage.user.model.MypageUserLicenses;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageUserLicenses in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageUserLicensesCacheModel
	implements CacheModel<MypageUserLicenses>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageUserLicensesCacheModel)) {
			return false;
		}

		MypageUserLicensesCacheModel mypageUserLicensesCacheModel =
			(MypageUserLicensesCacheModel)object;

		if (mypageUserLicensesId ==
				mypageUserLicensesCacheModel.mypageUserLicensesId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageUserLicensesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{mypageUserLicensesId=");
		sb.append(mypageUserLicensesId);
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
		sb.append(", productId=");
		sb.append(productId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MypageUserLicenses toEntityModel() {
		MypageUserLicensesImpl mypageUserLicensesImpl =
			new MypageUserLicensesImpl();

		mypageUserLicensesImpl.setMypageUserLicensesId(mypageUserLicensesId);
		mypageUserLicensesImpl.setGroupId(groupId);
		mypageUserLicensesImpl.setCompanyId(companyId);
		mypageUserLicensesImpl.setUserId(userId);

		if (userName == null) {
			mypageUserLicensesImpl.setUserName("");
		}
		else {
			mypageUserLicensesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageUserLicensesImpl.setCreateDate(null);
		}
		else {
			mypageUserLicensesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageUserLicensesImpl.setModifiedDate(null);
		}
		else {
			mypageUserLicensesImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageUserLicensesImpl.setMypageUserId(mypageUserId);
		mypageUserLicensesImpl.setProductId(productId);

		mypageUserLicensesImpl.resetOriginalValues();

		return mypageUserLicensesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageUserLicensesId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		mypageUserId = objectInput.readLong();

		productId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mypageUserLicensesId);

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

		objectOutput.writeLong(productId);
	}

	public long mypageUserLicensesId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mypageUserId;
	public long productId;

}