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

import com.mypage.admin.product.model.PaymentChannelTenor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PaymentChannelTenor in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PaymentChannelTenorCacheModel
	implements CacheModel<PaymentChannelTenor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PaymentChannelTenorCacheModel)) {
			return false;
		}

		PaymentChannelTenorCacheModel paymentChannelTenorCacheModel =
			(PaymentChannelTenorCacheModel)object;

		if (paymentChannelTenorId ==
				paymentChannelTenorCacheModel.paymentChannelTenorId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paymentChannelTenorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{paymentChannelTenorId=");
		sb.append(paymentChannelTenorId);
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
		sb.append(", paymentChannelId=");
		sb.append(paymentChannelId);
		sb.append(", promoid=");
		sb.append(promoid);
		sb.append(", tenor=");
		sb.append(tenor);
		sb.append(", tenorid=");
		sb.append(tenorid);
		sb.append(", acquirer=");
		sb.append(acquirer);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PaymentChannelTenor toEntityModel() {
		PaymentChannelTenorImpl paymentChannelTenorImpl =
			new PaymentChannelTenorImpl();

		paymentChannelTenorImpl.setPaymentChannelTenorId(paymentChannelTenorId);
		paymentChannelTenorImpl.setGroupId(groupId);
		paymentChannelTenorImpl.setCompanyId(companyId);
		paymentChannelTenorImpl.setUserId(userId);

		if (userName == null) {
			paymentChannelTenorImpl.setUserName("");
		}
		else {
			paymentChannelTenorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			paymentChannelTenorImpl.setCreateDate(null);
		}
		else {
			paymentChannelTenorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			paymentChannelTenorImpl.setModifiedDate(null);
		}
		else {
			paymentChannelTenorImpl.setModifiedDate(new Date(modifiedDate));
		}

		paymentChannelTenorImpl.setPaymentChannelId(paymentChannelId);

		if (promoid == null) {
			paymentChannelTenorImpl.setPromoid("");
		}
		else {
			paymentChannelTenorImpl.setPromoid(promoid);
		}

		if (tenor == null) {
			paymentChannelTenorImpl.setTenor("");
		}
		else {
			paymentChannelTenorImpl.setTenor(tenor);
		}

		if (tenorid == null) {
			paymentChannelTenorImpl.setTenorid("");
		}
		else {
			paymentChannelTenorImpl.setTenorid(tenorid);
		}

		if (acquirer == null) {
			paymentChannelTenorImpl.setAcquirer("");
		}
		else {
			paymentChannelTenorImpl.setAcquirer(acquirer);
		}

		paymentChannelTenorImpl.setActive(active);

		paymentChannelTenorImpl.resetOriginalValues();

		return paymentChannelTenorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paymentChannelTenorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		paymentChannelId = objectInput.readLong();
		promoid = objectInput.readUTF();
		tenor = objectInput.readUTF();
		tenorid = objectInput.readUTF();
		acquirer = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(paymentChannelTenorId);

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

		objectOutput.writeLong(paymentChannelId);

		if (promoid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoid);
		}

		if (tenor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenor);
		}

		if (tenorid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenorid);
		}

		if (acquirer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(acquirer);
		}

		objectOutput.writeInt(active);
	}

	public long paymentChannelTenorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long paymentChannelId;
	public String promoid;
	public String tenor;
	public String tenorid;
	public String acquirer;
	public int active;

}