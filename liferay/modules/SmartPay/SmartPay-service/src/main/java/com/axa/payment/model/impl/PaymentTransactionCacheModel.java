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

import com.axa.payment.model.PaymentTransaction;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PaymentTransaction in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PaymentTransactionCacheModel
	implements CacheModel<PaymentTransaction>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PaymentTransactionCacheModel)) {
			return false;
		}

		PaymentTransactionCacheModel paymentTransactionCacheModel =
			(PaymentTransactionCacheModel)object;

		if (paymentTransactionId ==
				paymentTransactionCacheModel.paymentTransactionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paymentTransactionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{paymentTransactionId=");
		sb.append(paymentTransactionId);
		sb.append(", policyNumber=");
		sb.append(policyNumber);
		sb.append(", profileId=");
		sb.append(profileId);
		sb.append(", invoiceNumber=");
		sb.append(invoiceNumber);
		sb.append(", referenceNumber=");
		sb.append(referenceNumber);
		sb.append(", requestId=");
		sb.append(requestId);
		sb.append(", policyDueDate=");
		sb.append(policyDueDate);
		sb.append(", paymentMethod=");
		sb.append(paymentMethod);
		sb.append(", paymentChannel=");
		sb.append(paymentChannel);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", status_=");
		sb.append(status_);
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
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", checkCounter=");
		sb.append(checkCounter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PaymentTransaction toEntityModel() {
		PaymentTransactionImpl paymentTransactionImpl =
			new PaymentTransactionImpl();

		paymentTransactionImpl.setPaymentTransactionId(paymentTransactionId);

		if (policyNumber == null) {
			paymentTransactionImpl.setPolicyNumber("");
		}
		else {
			paymentTransactionImpl.setPolicyNumber(policyNumber);
		}

		if (profileId == null) {
			paymentTransactionImpl.setProfileId("");
		}
		else {
			paymentTransactionImpl.setProfileId(profileId);
		}

		if (invoiceNumber == null) {
			paymentTransactionImpl.setInvoiceNumber("");
		}
		else {
			paymentTransactionImpl.setInvoiceNumber(invoiceNumber);
		}

		if (referenceNumber == null) {
			paymentTransactionImpl.setReferenceNumber("");
		}
		else {
			paymentTransactionImpl.setReferenceNumber(referenceNumber);
		}

		if (requestId == null) {
			paymentTransactionImpl.setRequestId("");
		}
		else {
			paymentTransactionImpl.setRequestId(requestId);
		}

		if (policyDueDate == null) {
			paymentTransactionImpl.setPolicyDueDate("");
		}
		else {
			paymentTransactionImpl.setPolicyDueDate(policyDueDate);
		}

		if (paymentMethod == null) {
			paymentTransactionImpl.setPaymentMethod("");
		}
		else {
			paymentTransactionImpl.setPaymentMethod(paymentMethod);
		}

		if (paymentChannel == null) {
			paymentTransactionImpl.setPaymentChannel("");
		}
		else {
			paymentTransactionImpl.setPaymentChannel(paymentChannel);
		}

		paymentTransactionImpl.setAmount(amount);

		if (status_ == null) {
			paymentTransactionImpl.setStatus_("");
		}
		else {
			paymentTransactionImpl.setStatus_(status_);
		}

		paymentTransactionImpl.setGroupId(groupId);
		paymentTransactionImpl.setCompanyId(companyId);
		paymentTransactionImpl.setUserId(userId);

		if (userName == null) {
			paymentTransactionImpl.setUserName("");
		}
		else {
			paymentTransactionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			paymentTransactionImpl.setCreateDate(null);
		}
		else {
			paymentTransactionImpl.setCreateDate(new Date(createDate));
		}

		if (createBy == null) {
			paymentTransactionImpl.setCreateBy("");
		}
		else {
			paymentTransactionImpl.setCreateBy(createBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			paymentTransactionImpl.setModifiedDate(null);
		}
		else {
			paymentTransactionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedBy == null) {
			paymentTransactionImpl.setModifiedBy("");
		}
		else {
			paymentTransactionImpl.setModifiedBy(modifiedBy);
		}

		paymentTransactionImpl.setCheckCounter(checkCounter);

		paymentTransactionImpl.resetOriginalValues();

		return paymentTransactionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paymentTransactionId = objectInput.readLong();
		policyNumber = objectInput.readUTF();
		profileId = objectInput.readUTF();
		invoiceNumber = objectInput.readUTF();
		referenceNumber = objectInput.readUTF();
		requestId = objectInput.readUTF();
		policyDueDate = objectInput.readUTF();
		paymentMethod = objectInput.readUTF();
		paymentChannel = objectInput.readUTF();

		amount = objectInput.readDouble();
		status_ = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		createBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();

		checkCounter = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(paymentTransactionId);

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

		if (requestId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestId);
		}

		if (policyDueDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyDueDate);
		}

		if (paymentMethod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentMethod);
		}

		if (paymentChannel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentChannel);
		}

		objectOutput.writeDouble(amount);

		if (status_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status_);
		}

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

		if (createBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createBy);
		}

		objectOutput.writeLong(modifiedDate);

		if (modifiedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeInt(checkCounter);
	}

	public long paymentTransactionId;
	public String policyNumber;
	public String profileId;
	public String invoiceNumber;
	public String referenceNumber;
	public String requestId;
	public String policyDueDate;
	public String paymentMethod;
	public String paymentChannel;
	public double amount;
	public String status_;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public String createBy;
	public long modifiedDate;
	public String modifiedBy;
	public int checkCounter;

}