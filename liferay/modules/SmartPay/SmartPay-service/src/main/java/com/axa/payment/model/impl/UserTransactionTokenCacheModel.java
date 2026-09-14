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

package com.axa.payment.model.impl;

import com.axa.payment.model.UserTransactionToken;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserTransactionToken in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class UserTransactionTokenCacheModel
	implements CacheModel<UserTransactionToken>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserTransactionTokenCacheModel)) {
			return false;
		}

		UserTransactionTokenCacheModel userTransactionTokenCacheModel =
			(UserTransactionTokenCacheModel)object;

		if (userTransactionTokenId ==
				userTransactionTokenCacheModel.userTransactionTokenId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userTransactionTokenId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{userTransactionTokenId=");
		sb.append(userTransactionTokenId);
		sb.append(", policyNumber=");
		sb.append(policyNumber);
		sb.append(", profileId=");
		sb.append(profileId);
		sb.append(", invoiceNumber=");
		sb.append(invoiceNumber);
		sb.append(", referenceNumber=");
		sb.append(referenceNumber);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", virtualAccount1=");
		sb.append(virtualAccount1);
		sb.append(", virtualAccount2=");
		sb.append(virtualAccount2);
		sb.append(", token=");
		sb.append(token);
		sb.append(", TimestampExpiryToken=");
		sb.append(TimestampExpiryToken);
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
	public UserTransactionToken toEntityModel() {
		UserTransactionTokenImpl userTransactionTokenImpl =
			new UserTransactionTokenImpl();

		userTransactionTokenImpl.setUserTransactionTokenId(
			userTransactionTokenId);

		if (policyNumber == null) {
			userTransactionTokenImpl.setPolicyNumber("");
		}
		else {
			userTransactionTokenImpl.setPolicyNumber(policyNumber);
		}

		if (profileId == null) {
			userTransactionTokenImpl.setProfileId("");
		}
		else {
			userTransactionTokenImpl.setProfileId(profileId);
		}

		if (invoiceNumber == null) {
			userTransactionTokenImpl.setInvoiceNumber("");
		}
		else {
			userTransactionTokenImpl.setInvoiceNumber(invoiceNumber);
		}

		if (referenceNumber == null) {
			userTransactionTokenImpl.setReferenceNumber("");
		}
		else {
			userTransactionTokenImpl.setReferenceNumber(referenceNumber);
		}

		if (fullName == null) {
			userTransactionTokenImpl.setFullName("");
		}
		else {
			userTransactionTokenImpl.setFullName(fullName);
		}

		if (email == null) {
			userTransactionTokenImpl.setEmail("");
		}
		else {
			userTransactionTokenImpl.setEmail(email);
		}

		if (phoneNumber == null) {
			userTransactionTokenImpl.setPhoneNumber("");
		}
		else {
			userTransactionTokenImpl.setPhoneNumber(phoneNumber);
		}

		userTransactionTokenImpl.setAmount(amount);

		if (channel == null) {
			userTransactionTokenImpl.setChannel("");
		}
		else {
			userTransactionTokenImpl.setChannel(channel);
		}

		if (virtualAccount1 == null) {
			userTransactionTokenImpl.setVirtualAccount1("");
		}
		else {
			userTransactionTokenImpl.setVirtualAccount1(virtualAccount1);
		}

		if (virtualAccount2 == null) {
			userTransactionTokenImpl.setVirtualAccount2("");
		}
		else {
			userTransactionTokenImpl.setVirtualAccount2(virtualAccount2);
		}

		if (token == null) {
			userTransactionTokenImpl.setToken("");
		}
		else {
			userTransactionTokenImpl.setToken(token);
		}

		userTransactionTokenImpl.setTimestampExpiryToken(TimestampExpiryToken);
		userTransactionTokenImpl.setGroupId(groupId);
		userTransactionTokenImpl.setCompanyId(companyId);
		userTransactionTokenImpl.setUserId(userId);

		if (userName == null) {
			userTransactionTokenImpl.setUserName("");
		}
		else {
			userTransactionTokenImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userTransactionTokenImpl.setCreateDate(null);
		}
		else {
			userTransactionTokenImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userTransactionTokenImpl.setModifiedDate(null);
		}
		else {
			userTransactionTokenImpl.setModifiedDate(new Date(modifiedDate));
		}

		userTransactionTokenImpl.resetOriginalValues();

		return userTransactionTokenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userTransactionTokenId = objectInput.readLong();
		policyNumber = objectInput.readUTF();
		profileId = objectInput.readUTF();
		invoiceNumber = objectInput.readUTF();
		referenceNumber = objectInput.readUTF();
		fullName = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();

		amount = objectInput.readDouble();
		channel = objectInput.readUTF();
		virtualAccount1 = objectInput.readUTF();
		virtualAccount2 = objectInput.readUTF();
		token = objectInput.readUTF();

		TimestampExpiryToken = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userTransactionTokenId);

		if (policyNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNumber);
		}

		if (profileId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profileId);
		}

		if (invoiceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(invoiceNumber);
		}

		if (referenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceNumber);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		objectOutput.writeDouble(amount);

		if (channel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(channel);
		}

		if (virtualAccount1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(virtualAccount1);
		}

		if (virtualAccount2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(virtualAccount2);
		}

		if (token == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(token);
		}

		objectOutput.writeLong(TimestampExpiryToken);

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

	public long userTransactionTokenId;
	public String policyNumber;
	public String profileId;
	public String invoiceNumber;
	public String referenceNumber;
	public String fullName;
	public String email;
	public String phoneNumber;
	public double amount;
	public String channel;
	public String virtualAccount1;
	public String virtualAccount2;
	public String token;
	public long TimestampExpiryToken;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}