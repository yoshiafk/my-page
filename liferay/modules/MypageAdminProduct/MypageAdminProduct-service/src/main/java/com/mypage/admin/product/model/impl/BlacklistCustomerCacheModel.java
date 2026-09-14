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

package com.mypage.admin.product.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.admin.product.model.BlacklistCustomer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BlacklistCustomer in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class BlacklistCustomerCacheModel
	implements CacheModel<BlacklistCustomer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BlacklistCustomerCacheModel)) {
			return false;
		}

		BlacklistCustomerCacheModel blacklistCustomerCacheModel =
			(BlacklistCustomerCacheModel)object;

		if (blacklistCustomerId ==
				blacklistCustomerCacheModel.blacklistCustomerId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, blacklistCustomerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{blacklistCustomerId=");
		sb.append(blacklistCustomerId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", ktp=");
		sb.append(ktp);
		sb.append(", kitas=");
		sb.append(kitas);
		sb.append(", email=");
		sb.append(email);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
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
	public BlacklistCustomer toEntityModel() {
		BlacklistCustomerImpl blacklistCustomerImpl =
			new BlacklistCustomerImpl();

		blacklistCustomerImpl.setBlacklistCustomerId(blacklistCustomerId);

		if (fullName == null) {
			blacklistCustomerImpl.setFullName("");
		}
		else {
			blacklistCustomerImpl.setFullName(fullName);
		}

		if (firstName == null) {
			blacklistCustomerImpl.setFirstName("");
		}
		else {
			blacklistCustomerImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			blacklistCustomerImpl.setMiddleName("");
		}
		else {
			blacklistCustomerImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			blacklistCustomerImpl.setLastName("");
		}
		else {
			blacklistCustomerImpl.setLastName(lastName);
		}

		if (ktp == null) {
			blacklistCustomerImpl.setKtp("");
		}
		else {
			blacklistCustomerImpl.setKtp(ktp);
		}

		if (kitas == null) {
			blacklistCustomerImpl.setKitas("");
		}
		else {
			blacklistCustomerImpl.setKitas(kitas);
		}

		if (email == null) {
			blacklistCustomerImpl.setEmail("");
		}
		else {
			blacklistCustomerImpl.setEmail(email);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			blacklistCustomerImpl.setDateOfBirth(null);
		}
		else {
			blacklistCustomerImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		blacklistCustomerImpl.setActive(active);
		blacklistCustomerImpl.setGroupId(groupId);
		blacklistCustomerImpl.setCompanyId(companyId);
		blacklistCustomerImpl.setUserId(userId);

		if (userName == null) {
			blacklistCustomerImpl.setUserName("");
		}
		else {
			blacklistCustomerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			blacklistCustomerImpl.setCreateDate(null);
		}
		else {
			blacklistCustomerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			blacklistCustomerImpl.setModifiedDate(null);
		}
		else {
			blacklistCustomerImpl.setModifiedDate(new Date(modifiedDate));
		}

		blacklistCustomerImpl.resetOriginalValues();

		return blacklistCustomerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		blacklistCustomerId = objectInput.readLong();
		fullName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		ktp = objectInput.readUTF();
		kitas = objectInput.readUTF();
		email = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();

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
		objectOutput.writeLong(blacklistCustomerId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (ktp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ktp);
		}

		if (kitas == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kitas);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(dateOfBirth);

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

	public long blacklistCustomerId;
	public String fullName;
	public String firstName;
	public String middleName;
	public String lastName;
	public String ktp;
	public String kitas;
	public String email;
	public long dateOfBirth;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}