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

import com.mypage.admin.product.model.PaymentChannel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PaymentChannel in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PaymentChannelCacheModel
	implements CacheModel<PaymentChannel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PaymentChannelCacheModel)) {
			return false;
		}

		PaymentChannelCacheModel paymentChannelCacheModel =
			(PaymentChannelCacheModel)object;

		if (paymentChannelId == paymentChannelCacheModel.paymentChannelId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paymentChannelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{paymentChannelId=");
		sb.append(paymentChannelId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", minPayment=");
		sb.append(minPayment);
		sb.append(", maxPayment=");
		sb.append(maxPayment);
		sb.append(", description=");
		sb.append(description);
		sb.append(", masterBankId=");
		sb.append(masterBankId);
		sb.append(", mdrAxa=");
		sb.append(mdrAxa);
		sb.append(", mdrUser=");
		sb.append(mdrUser);
		sb.append(", pgFeePct=");
		sb.append(pgFeePct);
		sb.append(", pgFeeAmt=");
		sb.append(pgFeeAmt);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append(", utmOnly=");
		sb.append(utmOnly);
		sb.append(", mallId=");
		sb.append(mallId);
		sb.append(", sharedKey=");
		sb.append(sharedKey);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PaymentChannel toEntityModel() {
		PaymentChannelImpl paymentChannelImpl = new PaymentChannelImpl();

		paymentChannelImpl.setPaymentChannelId(paymentChannelId);
		paymentChannelImpl.setGroupId(groupId);
		paymentChannelImpl.setCompanyId(companyId);
		paymentChannelImpl.setUserId(userId);

		if (userName == null) {
			paymentChannelImpl.setUserName("");
		}
		else {
			paymentChannelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			paymentChannelImpl.setCreateDate(null);
		}
		else {
			paymentChannelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			paymentChannelImpl.setModifiedDate(null);
		}
		else {
			paymentChannelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			paymentChannelImpl.setCode("");
		}
		else {
			paymentChannelImpl.setCode(code);
		}

		if (name == null) {
			paymentChannelImpl.setName("");
		}
		else {
			paymentChannelImpl.setName(name);
		}

		paymentChannelImpl.setMinPayment(minPayment);
		paymentChannelImpl.setMaxPayment(maxPayment);

		if (description == null) {
			paymentChannelImpl.setDescription("");
		}
		else {
			paymentChannelImpl.setDescription(description);
		}

		paymentChannelImpl.setMasterBankId(masterBankId);

		if (mdrAxa == null) {
			paymentChannelImpl.setMdrAxa("");
		}
		else {
			paymentChannelImpl.setMdrAxa(mdrAxa);
		}

		if (mdrUser == null) {
			paymentChannelImpl.setMdrUser("");
		}
		else {
			paymentChannelImpl.setMdrUser(mdrUser);
		}

		if (pgFeePct == null) {
			paymentChannelImpl.setPgFeePct("");
		}
		else {
			paymentChannelImpl.setPgFeePct(pgFeePct);
		}

		if (pgFeeAmt == null) {
			paymentChannelImpl.setPgFeeAmt("");
		}
		else {
			paymentChannelImpl.setPgFeeAmt(pgFeeAmt);
		}

		paymentChannelImpl.setImageFileEntryId(imageFileEntryId);

		if (imageURL == null) {
			paymentChannelImpl.setImageURL("");
		}
		else {
			paymentChannelImpl.setImageURL(imageURL);
		}

		paymentChannelImpl.setUtmOnly(utmOnly);

		if (mallId == null) {
			paymentChannelImpl.setMallId("");
		}
		else {
			paymentChannelImpl.setMallId(mallId);
		}

		if (sharedKey == null) {
			paymentChannelImpl.setSharedKey("");
		}
		else {
			paymentChannelImpl.setSharedKey(sharedKey);
		}

		paymentChannelImpl.setActive(active);

		paymentChannelImpl.resetOriginalValues();

		return paymentChannelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paymentChannelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		minPayment = objectInput.readDouble();

		maxPayment = objectInput.readDouble();
		description = objectInput.readUTF();

		masterBankId = objectInput.readLong();
		mdrAxa = objectInput.readUTF();
		mdrUser = objectInput.readUTF();
		pgFeePct = objectInput.readUTF();
		pgFeeAmt = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();
		imageURL = objectInput.readUTF();

		utmOnly = objectInput.readInt();
		mallId = objectInput.readUTF();
		sharedKey = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(paymentChannelId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(minPayment);

		objectOutput.writeDouble(maxPayment);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(masterBankId);

		if (mdrAxa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mdrAxa);
		}

		if (mdrUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mdrUser);
		}

		if (pgFeePct == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgFeePct);
		}

		if (pgFeeAmt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgFeeAmt);
		}

		objectOutput.writeLong(imageFileEntryId);

		if (imageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageURL);
		}

		objectOutput.writeInt(utmOnly);

		if (mallId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mallId);
		}

		if (sharedKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sharedKey);
		}

		objectOutput.writeInt(active);
	}

	public long paymentChannelId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public double minPayment;
	public double maxPayment;
	public String description;
	public long masterBankId;
	public String mdrAxa;
	public String mdrUser;
	public String pgFeePct;
	public String pgFeeAmt;
	public long imageFileEntryId;
	public String imageURL;
	public int utmOnly;
	public String mallId;
	public String sharedKey;
	public int active;

}