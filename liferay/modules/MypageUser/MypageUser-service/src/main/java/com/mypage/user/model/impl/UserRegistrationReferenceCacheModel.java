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

import com.mypage.user.model.UserRegistrationReference;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserRegistrationReference in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRegistrationReferenceCacheModel
	implements CacheModel<UserRegistrationReference>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRegistrationReferenceCacheModel)) {
			return false;
		}

		UserRegistrationReferenceCacheModel
			userRegistrationReferenceCacheModel =
				(UserRegistrationReferenceCacheModel)object;

		if (userRegistrationReferenceId ==
				userRegistrationReferenceCacheModel.
					userRegistrationReferenceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRegistrationReferenceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{userRegistrationReferenceId=");
		sb.append(userRegistrationReferenceId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", relation=");
		sb.append(relation);
		sb.append(", age=");
		sb.append(age);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", job=");
		sb.append(job);
		sb.append(", year=");
		sb.append(year);
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
	public UserRegistrationReference toEntityModel() {
		UserRegistrationReferenceImpl userRegistrationReferenceImpl =
			new UserRegistrationReferenceImpl();

		userRegistrationReferenceImpl.setUserRegistrationReferenceId(
			userRegistrationReferenceId);

		if (name == null) {
			userRegistrationReferenceImpl.setName("");
		}
		else {
			userRegistrationReferenceImpl.setName(name);
		}

		if (relation == null) {
			userRegistrationReferenceImpl.setRelation("");
		}
		else {
			userRegistrationReferenceImpl.setRelation(relation);
		}

		userRegistrationReferenceImpl.setAge(age);

		if (address == null) {
			userRegistrationReferenceImpl.setAddress("");
		}
		else {
			userRegistrationReferenceImpl.setAddress(address);
		}

		if (phone == null) {
			userRegistrationReferenceImpl.setPhone("");
		}
		else {
			userRegistrationReferenceImpl.setPhone(phone);
		}

		if (job == null) {
			userRegistrationReferenceImpl.setJob("");
		}
		else {
			userRegistrationReferenceImpl.setJob(job);
		}

		userRegistrationReferenceImpl.setYear(year);
		userRegistrationReferenceImpl.setUserRegistrationId(userRegistrationId);
		userRegistrationReferenceImpl.setGroupId(groupId);
		userRegistrationReferenceImpl.setCompanyId(companyId);
		userRegistrationReferenceImpl.setUserId(userId);

		if (userName == null) {
			userRegistrationReferenceImpl.setUserName("");
		}
		else {
			userRegistrationReferenceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userRegistrationReferenceImpl.setCreateDate(null);
		}
		else {
			userRegistrationReferenceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userRegistrationReferenceImpl.setModifiedDate(null);
		}
		else {
			userRegistrationReferenceImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		userRegistrationReferenceImpl.resetOriginalValues();

		return userRegistrationReferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRegistrationReferenceId = objectInput.readLong();
		name = objectInput.readUTF();
		relation = objectInput.readUTF();

		age = objectInput.readInt();
		address = objectInput.readUTF();
		phone = objectInput.readUTF();
		job = objectInput.readUTF();

		year = objectInput.readInt();

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
		objectOutput.writeLong(userRegistrationReferenceId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (relation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(relation);
		}

		objectOutput.writeInt(age);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (job == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(job);
		}

		objectOutput.writeInt(year);

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

	public long userRegistrationReferenceId;
	public String name;
	public String relation;
	public int age;
	public String address;
	public String phone;
	public String job;
	public int year;
	public long userRegistrationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}