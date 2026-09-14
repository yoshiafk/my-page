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

package com.mypage.leads.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.leads.model.Payment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Payment in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class PaymentCacheModel implements CacheModel<Payment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PaymentCacheModel)) {
			return false;
		}

		PaymentCacheModel paymentCacheModel = (PaymentCacheModel)object;

		if (paymentId == paymentCacheModel.paymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(89);

		sb.append("{paymentId=");
		sb.append(paymentId);
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
		sb.append(", TransactionId=");
		sb.append(TransactionId);
		sb.append(", SessionId=");
		sb.append(SessionId);
		sb.append(", LeadsId=");
		sb.append(LeadsId);
		sb.append(", Amount=");
		sb.append(Amount);
		sb.append(", Discount=");
		sb.append(Discount);
		sb.append(", DiscountAmount=");
		sb.append(DiscountAmount);
		sb.append(", PaymentStatus=");
		sb.append(PaymentStatus);
		sb.append(", PaymentChannelId=");
		sb.append(PaymentChannelId);
		sb.append(", LinkAjaRefNum=");
		sb.append(LinkAjaRefNum);
		sb.append(", Tenor=");
		sb.append(Tenor);
		sb.append(", PaymentCode=");
		sb.append(PaymentCode);
		sb.append(", PaymentMessage=");
		sb.append(PaymentMessage);
		sb.append(", CreditCardType=");
		sb.append(CreditCardType);
		sb.append(", TransactionDateTime=");
		sb.append(TransactionDateTime);
		sb.append(", PaymentDateTime=");
		sb.append(PaymentDateTime);
		sb.append(", Bank=");
		sb.append(Bank);
		sb.append(", ManagedBy=");
		sb.append(ManagedBy);
		sb.append(", ReportGenerated=");
		sb.append(ReportGenerated);
		sb.append(", DailyReportGenerated=");
		sb.append(DailyReportGenerated);
		sb.append(", WeeklyReportGenerated=");
		sb.append(WeeklyReportGenerated);
		sb.append(", MonthlyReportGenerated=");
		sb.append(MonthlyReportGenerated);
		sb.append(", CheckStatusCounter=");
		sb.append(CheckStatusCounter);
		sb.append(", UserCreditId=");
		sb.append(UserCreditId);
		sb.append(", CreditPaymentStatus=");
		sb.append(CreditPaymentStatus);
		sb.append(", CreditTransactionId=");
		sb.append(CreditTransactionId);
		sb.append(", CreditPaymentDate=");
		sb.append(CreditPaymentDate);
		sb.append(", CreditPaymentChannelId=");
		sb.append(CreditPaymentChannelId);
		sb.append(", CreditBank=");
		sb.append(CreditBank);
		sb.append(", CreditPaymentCode=");
		sb.append(CreditPaymentCode);
		sb.append(", CreditPaymentMessage=");
		sb.append(CreditPaymentMessage);
		sb.append(", ReportSettlementGenerated=");
		sb.append(ReportSettlementGenerated);
		sb.append(", CreditSettlementAttachmentId=");
		sb.append(CreditSettlementAttachmentId);
		sb.append(", UtmId=");
		sb.append(UtmId);
		sb.append(", Sojern=");
		sb.append(Sojern);
		sb.append(", InvolveAsia=");
		sb.append(InvolveAsia);
		sb.append(", Ada=");
		sb.append(Ada);
		sb.append(", Active=");
		sb.append(Active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Payment toEntityModel() {
		PaymentImpl paymentImpl = new PaymentImpl();

		paymentImpl.setPaymentId(paymentId);
		paymentImpl.setGroupId(groupId);
		paymentImpl.setCompanyId(companyId);
		paymentImpl.setUserId(userId);

		if (userName == null) {
			paymentImpl.setUserName("");
		}
		else {
			paymentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			paymentImpl.setCreateDate(null);
		}
		else {
			paymentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			paymentImpl.setModifiedDate(null);
		}
		else {
			paymentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (TransactionId == null) {
			paymentImpl.setTransactionId("");
		}
		else {
			paymentImpl.setTransactionId(TransactionId);
		}

		if (SessionId == null) {
			paymentImpl.setSessionId("");
		}
		else {
			paymentImpl.setSessionId(SessionId);
		}

		paymentImpl.setLeadsId(LeadsId);
		paymentImpl.setAmount(Amount);
		paymentImpl.setDiscount(Discount);
		paymentImpl.setDiscountAmount(DiscountAmount);

		if (PaymentStatus == null) {
			paymentImpl.setPaymentStatus("");
		}
		else {
			paymentImpl.setPaymentStatus(PaymentStatus);
		}

		paymentImpl.setPaymentChannelId(PaymentChannelId);

		if (LinkAjaRefNum == null) {
			paymentImpl.setLinkAjaRefNum("");
		}
		else {
			paymentImpl.setLinkAjaRefNum(LinkAjaRefNum);
		}

		if (Tenor == null) {
			paymentImpl.setTenor("");
		}
		else {
			paymentImpl.setTenor(Tenor);
		}

		if (PaymentCode == null) {
			paymentImpl.setPaymentCode("");
		}
		else {
			paymentImpl.setPaymentCode(PaymentCode);
		}

		if (PaymentMessage == null) {
			paymentImpl.setPaymentMessage("");
		}
		else {
			paymentImpl.setPaymentMessage(PaymentMessage);
		}

		if (CreditCardType == null) {
			paymentImpl.setCreditCardType("");
		}
		else {
			paymentImpl.setCreditCardType(CreditCardType);
		}

		if (TransactionDateTime == Long.MIN_VALUE) {
			paymentImpl.setTransactionDateTime(null);
		}
		else {
			paymentImpl.setTransactionDateTime(new Date(TransactionDateTime));
		}

		if (PaymentDateTime == Long.MIN_VALUE) {
			paymentImpl.setPaymentDateTime(null);
		}
		else {
			paymentImpl.setPaymentDateTime(new Date(PaymentDateTime));
		}

		if (Bank == null) {
			paymentImpl.setBank("");
		}
		else {
			paymentImpl.setBank(Bank);
		}

		paymentImpl.setManagedBy(ManagedBy);
		paymentImpl.setReportGenerated(ReportGenerated);
		paymentImpl.setDailyReportGenerated(DailyReportGenerated);
		paymentImpl.setWeeklyReportGenerated(WeeklyReportGenerated);
		paymentImpl.setMonthlyReportGenerated(MonthlyReportGenerated);
		paymentImpl.setCheckStatusCounter(CheckStatusCounter);
		paymentImpl.setUserCreditId(UserCreditId);

		if (CreditPaymentStatus == null) {
			paymentImpl.setCreditPaymentStatus("");
		}
		else {
			paymentImpl.setCreditPaymentStatus(CreditPaymentStatus);
		}

		if (CreditTransactionId == null) {
			paymentImpl.setCreditTransactionId("");
		}
		else {
			paymentImpl.setCreditTransactionId(CreditTransactionId);
		}

		if (CreditPaymentDate == Long.MIN_VALUE) {
			paymentImpl.setCreditPaymentDate(null);
		}
		else {
			paymentImpl.setCreditPaymentDate(new Date(CreditPaymentDate));
		}

		paymentImpl.setCreditPaymentChannelId(CreditPaymentChannelId);

		if (CreditBank == null) {
			paymentImpl.setCreditBank("");
		}
		else {
			paymentImpl.setCreditBank(CreditBank);
		}

		if (CreditPaymentCode == null) {
			paymentImpl.setCreditPaymentCode("");
		}
		else {
			paymentImpl.setCreditPaymentCode(CreditPaymentCode);
		}

		if (CreditPaymentMessage == null) {
			paymentImpl.setCreditPaymentMessage("");
		}
		else {
			paymentImpl.setCreditPaymentMessage(CreditPaymentMessage);
		}

		paymentImpl.setReportSettlementGenerated(ReportSettlementGenerated);
		paymentImpl.setCreditSettlementAttachmentId(
			CreditSettlementAttachmentId);
		paymentImpl.setUtmId(UtmId);
		paymentImpl.setSojern(Sojern);
		paymentImpl.setInvolveAsia(InvolveAsia);
		paymentImpl.setAda(Ada);
		paymentImpl.setActive(Active);

		paymentImpl.resetOriginalValues();

		return paymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paymentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		TransactionId = objectInput.readUTF();
		SessionId = objectInput.readUTF();

		LeadsId = objectInput.readLong();

		Amount = objectInput.readDouble();

		Discount = objectInput.readDouble();

		DiscountAmount = objectInput.readDouble();
		PaymentStatus = objectInput.readUTF();

		PaymentChannelId = objectInput.readLong();
		LinkAjaRefNum = objectInput.readUTF();
		Tenor = objectInput.readUTF();
		PaymentCode = objectInput.readUTF();
		PaymentMessage = objectInput.readUTF();
		CreditCardType = objectInput.readUTF();
		TransactionDateTime = objectInput.readLong();
		PaymentDateTime = objectInput.readLong();
		Bank = objectInput.readUTF();

		ManagedBy = objectInput.readLong();

		ReportGenerated = objectInput.readInt();

		DailyReportGenerated = objectInput.readInt();

		WeeklyReportGenerated = objectInput.readInt();

		MonthlyReportGenerated = objectInput.readInt();

		CheckStatusCounter = objectInput.readInt();

		UserCreditId = objectInput.readLong();
		CreditPaymentStatus = objectInput.readUTF();
		CreditTransactionId = objectInput.readUTF();
		CreditPaymentDate = objectInput.readLong();

		CreditPaymentChannelId = objectInput.readLong();
		CreditBank = objectInput.readUTF();
		CreditPaymentCode = objectInput.readUTF();
		CreditPaymentMessage = objectInput.readUTF();

		ReportSettlementGenerated = objectInput.readInt();

		CreditSettlementAttachmentId = objectInput.readLong();

		UtmId = objectInput.readLong();

		Sojern = objectInput.readInt();

		InvolveAsia = objectInput.readInt();

		Ada = objectInput.readInt();

		Active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(paymentId);

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

		if (TransactionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TransactionId);
		}

		if (SessionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SessionId);
		}

		objectOutput.writeLong(LeadsId);

		objectOutput.writeDouble(Amount);

		objectOutput.writeDouble(Discount);

		objectOutput.writeDouble(DiscountAmount);

		if (PaymentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PaymentStatus);
		}

		objectOutput.writeLong(PaymentChannelId);

		if (LinkAjaRefNum == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LinkAjaRefNum);
		}

		if (Tenor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Tenor);
		}

		if (PaymentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PaymentCode);
		}

		if (PaymentMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PaymentMessage);
		}

		if (CreditCardType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CreditCardType);
		}

		objectOutput.writeLong(TransactionDateTime);
		objectOutput.writeLong(PaymentDateTime);

		if (Bank == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Bank);
		}

		objectOutput.writeLong(ManagedBy);

		objectOutput.writeInt(ReportGenerated);

		objectOutput.writeInt(DailyReportGenerated);

		objectOutput.writeInt(WeeklyReportGenerated);

		objectOutput.writeInt(MonthlyReportGenerated);

		objectOutput.writeInt(CheckStatusCounter);

		objectOutput.writeLong(UserCreditId);

		if (CreditPaymentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CreditPaymentStatus);
		}

		if (CreditTransactionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CreditTransactionId);
		}

		objectOutput.writeLong(CreditPaymentDate);

		objectOutput.writeLong(CreditPaymentChannelId);

		if (CreditBank == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CreditBank);
		}

		if (CreditPaymentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CreditPaymentCode);
		}

		if (CreditPaymentMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CreditPaymentMessage);
		}

		objectOutput.writeInt(ReportSettlementGenerated);

		objectOutput.writeLong(CreditSettlementAttachmentId);

		objectOutput.writeLong(UtmId);

		objectOutput.writeInt(Sojern);

		objectOutput.writeInt(InvolveAsia);

		objectOutput.writeInt(Ada);

		objectOutput.writeInt(Active);
	}

	public long paymentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String TransactionId;
	public String SessionId;
	public long LeadsId;
	public double Amount;
	public double Discount;
	public double DiscountAmount;
	public String PaymentStatus;
	public long PaymentChannelId;
	public String LinkAjaRefNum;
	public String Tenor;
	public String PaymentCode;
	public String PaymentMessage;
	public String CreditCardType;
	public long TransactionDateTime;
	public long PaymentDateTime;
	public String Bank;
	public long ManagedBy;
	public int ReportGenerated;
	public int DailyReportGenerated;
	public int WeeklyReportGenerated;
	public int MonthlyReportGenerated;
	public int CheckStatusCounter;
	public long UserCreditId;
	public String CreditPaymentStatus;
	public String CreditTransactionId;
	public long CreditPaymentDate;
	public long CreditPaymentChannelId;
	public String CreditBank;
	public String CreditPaymentCode;
	public String CreditPaymentMessage;
	public int ReportSettlementGenerated;
	public long CreditSettlementAttachmentId;
	public long UtmId;
	public int Sojern;
	public int InvolveAsia;
	public int Ada;
	public int Active;

}