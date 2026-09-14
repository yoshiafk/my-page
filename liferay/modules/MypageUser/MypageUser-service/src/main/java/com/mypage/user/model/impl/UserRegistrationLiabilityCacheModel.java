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

import com.mypage.user.model.UserRegistrationLiability;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserRegistrationLiability in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRegistrationLiabilityCacheModel
	implements CacheModel<UserRegistrationLiability>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRegistrationLiabilityCacheModel)) {
			return false;
		}

		UserRegistrationLiabilityCacheModel
			userRegistrationLiabilityCacheModel =
				(UserRegistrationLiabilityCacheModel)object;

		if (userRegistrationLiabilityId ==
				userRegistrationLiabilityCacheModel.
					userRegistrationLiabilityId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRegistrationLiabilityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{userRegistrationLiabilityId=");
		sb.append(userRegistrationLiabilityId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", relationship=");
		sb.append(relationship);
		sb.append(", age=");
		sb.append(age);
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
	public UserRegistrationLiability toEntityModel() {
		UserRegistrationLiabilityImpl userRegistrationLiabilityImpl =
			new UserRegistrationLiabilityImpl();

		userRegistrationLiabilityImpl.setUserRegistrationLiabilityId(
			userRegistrationLiabilityId);

		if (name == null) {
			userRegistrationLiabilityImpl.setName("");
		}
		else {
			userRegistrationLiabilityImpl.setName(name);
		}

		if (relationship == null) {
			userRegistrationLiabilityImpl.setRelationship("");
		}
		else {
			userRegistrationLiabilityImpl.setRelationship(relationship);
		}

		userRegistrationLiabilityImpl.setAge(age);
		userRegistrationLiabilityImpl.setUserRegistrationId(userRegistrationId);
		userRegistrationLiabilityImpl.setGroupId(groupId);
		userRegistrationLiabilityImpl.setCompanyId(companyId);
		userRegistrationLiabilityImpl.setUserId(userId);

		if (userName == null) {
			userRegistrationLiabilityImpl.setUserName("");
		}
		else {
			userRegistrationLiabilityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userRegistrationLiabilityImpl.setCreateDate(null);
		}
		else {
			userRegistrationLiabilityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userRegistrationLiabilityImpl.setModifiedDate(null);
		}
		else {
			userRegistrationLiabilityImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		userRegistrationLiabilityImpl.resetOriginalValues();

		return userRegistrationLiabilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRegistrationLiabilityId = objectInput.readLong();
		name = objectInput.readUTF();
		relationship = objectInput.readUTF();

		age = objectInput.readInt();

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
		objectOutput.writeLong(userRegistrationLiabilityId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (relationship == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(relationship);
		}

		objectOutput.writeInt(age);

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

	public long userRegistrationLiabilityId;
	public String name;
	public String relationship;
	public int age;
	public long userRegistrationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}