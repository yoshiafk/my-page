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

import com.mypage.user.model.UserRegistrationJobExp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserRegistrationJobExp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRegistrationJobExpCacheModel
	implements CacheModel<UserRegistrationJobExp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRegistrationJobExpCacheModel)) {
			return false;
		}

		UserRegistrationJobExpCacheModel userRegistrationJobExpCacheModel =
			(UserRegistrationJobExpCacheModel)object;

		if (userRegistrationJobExpId ==
				userRegistrationJobExpCacheModel.userRegistrationJobExpId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRegistrationJobExpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{userRegistrationJobExpId=");
		sb.append(userRegistrationJobExpId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", year=");
		sb.append(year);
		sb.append(", jobHead=");
		sb.append(jobHead);
		sb.append(", jobPosition=");
		sb.append(jobPosition);
		sb.append(", jobIncome=");
		sb.append(jobIncome);
		sb.append(", otherInsuranceCompany=");
		sb.append(otherInsuranceCompany);
		sb.append(", userRegistrationId=");
		sb.append(userRegistrationId);
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
	public UserRegistrationJobExp toEntityModel() {
		UserRegistrationJobExpImpl userRegistrationJobExpImpl =
			new UserRegistrationJobExpImpl();

		userRegistrationJobExpImpl.setUserRegistrationJobExpId(
			userRegistrationJobExpId);

		if (name == null) {
			userRegistrationJobExpImpl.setName("");
		}
		else {
			userRegistrationJobExpImpl.setName(name);
		}

		userRegistrationJobExpImpl.setYear(year);

		if (jobHead == null) {
			userRegistrationJobExpImpl.setJobHead("");
		}
		else {
			userRegistrationJobExpImpl.setJobHead(jobHead);
		}

		if (jobPosition == null) {
			userRegistrationJobExpImpl.setJobPosition("");
		}
		else {
			userRegistrationJobExpImpl.setJobPosition(jobPosition);
		}

		if (jobIncome == null) {
			userRegistrationJobExpImpl.setJobIncome("");
		}
		else {
			userRegistrationJobExpImpl.setJobIncome(jobIncome);
		}

		userRegistrationJobExpImpl.setOtherInsuranceCompany(
			otherInsuranceCompany);
		userRegistrationJobExpImpl.setUserRegistrationId(userRegistrationId);
		userRegistrationJobExpImpl.setGroupId(groupId);
		userRegistrationJobExpImpl.setCompanyId(companyId);
		userRegistrationJobExpImpl.setUserId(userId);

		if (userName == null) {
			userRegistrationJobExpImpl.setUserName("");
		}
		else {
			userRegistrationJobExpImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userRegistrationJobExpImpl.setCreateDate(null);
		}
		else {
			userRegistrationJobExpImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userRegistrationJobExpImpl.setModifiedDate(null);
		}
		else {
			userRegistrationJobExpImpl.setModifiedDate(new Date(modifiedDate));
		}

		userRegistrationJobExpImpl.resetOriginalValues();

		return userRegistrationJobExpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRegistrationJobExpId = objectInput.readLong();
		name = objectInput.readUTF();

		year = objectInput.readInt();
		jobHead = objectInput.readUTF();
		jobPosition = objectInput.readUTF();
		jobIncome = objectInput.readUTF();

		otherInsuranceCompany = objectInput.readInt();

		userRegistrationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userRegistrationJobExpId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(year);

		if (jobHead == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobHead);
		}

		if (jobPosition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobPosition);
		}

		if (jobIncome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobIncome);
		}

		objectOutput.writeInt(otherInsuranceCompany);

		objectOutput.writeLong(userRegistrationId);

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

	public long userRegistrationJobExpId;
	public String name;
	public int year;
	public String jobHead;
	public String jobPosition;
	public String jobIncome;
	public int otherInsuranceCompany;
	public long userRegistrationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}