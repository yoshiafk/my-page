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

import com.mypage.user.model.UserRegistrationEducation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserRegistrationEducation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRegistrationEducationCacheModel
	implements CacheModel<UserRegistrationEducation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRegistrationEducationCacheModel)) {
			return false;
		}

		UserRegistrationEducationCacheModel
			userRegistrationEducationCacheModel =
				(UserRegistrationEducationCacheModel)object;

		if (userRegistrationEducationId ==
				userRegistrationEducationCacheModel.
					userRegistrationEducationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRegistrationEducationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{userRegistrationEducationId=");
		sb.append(userRegistrationEducationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", year=");
		sb.append(year);
		sb.append(", graduate=");
		sb.append(graduate);
		sb.append(", courseType=");
		sb.append(courseType);
		sb.append(", title=");
		sb.append(title);
		sb.append(", eduType=");
		sb.append(eduType);
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
	public UserRegistrationEducation toEntityModel() {
		UserRegistrationEducationImpl userRegistrationEducationImpl =
			new UserRegistrationEducationImpl();

		userRegistrationEducationImpl.setUserRegistrationEducationId(
			userRegistrationEducationId);

		if (name == null) {
			userRegistrationEducationImpl.setName("");
		}
		else {
			userRegistrationEducationImpl.setName(name);
		}

		userRegistrationEducationImpl.setYear(year);
		userRegistrationEducationImpl.setGraduate(graduate);

		if (courseType == null) {
			userRegistrationEducationImpl.setCourseType("");
		}
		else {
			userRegistrationEducationImpl.setCourseType(courseType);
		}

		if (title == null) {
			userRegistrationEducationImpl.setTitle("");
		}
		else {
			userRegistrationEducationImpl.setTitle(title);
		}

		if (eduType == null) {
			userRegistrationEducationImpl.setEduType("");
		}
		else {
			userRegistrationEducationImpl.setEduType(eduType);
		}

		userRegistrationEducationImpl.setUserRegistrationId(userRegistrationId);
		userRegistrationEducationImpl.setGroupId(groupId);
		userRegistrationEducationImpl.setCompanyId(companyId);
		userRegistrationEducationImpl.setUserId(userId);

		if (userName == null) {
			userRegistrationEducationImpl.setUserName("");
		}
		else {
			userRegistrationEducationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userRegistrationEducationImpl.setCreateDate(null);
		}
		else {
			userRegistrationEducationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userRegistrationEducationImpl.setModifiedDate(null);
		}
		else {
			userRegistrationEducationImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		userRegistrationEducationImpl.resetOriginalValues();

		return userRegistrationEducationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRegistrationEducationId = objectInput.readLong();
		name = objectInput.readUTF();

		year = objectInput.readInt();

		graduate = objectInput.readInt();
		courseType = objectInput.readUTF();
		title = objectInput.readUTF();
		eduType = objectInput.readUTF();

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
		objectOutput.writeLong(userRegistrationEducationId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(year);

		objectOutput.writeInt(graduate);

		if (courseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(courseType);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (eduType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eduType);
		}

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

	public long userRegistrationEducationId;
	public String name;
	public int year;
	public int graduate;
	public String courseType;
	public String title;
	public String eduType;
	public long userRegistrationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}