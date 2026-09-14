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

import com.mypage.admin.product.model.MasterPromoCode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterPromoCode in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterPromoCodeCacheModel
	implements CacheModel<MasterPromoCode>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterPromoCodeCacheModel)) {
			return false;
		}

		MasterPromoCodeCacheModel masterPromoCodeCacheModel =
			(MasterPromoCodeCacheModel)object;

		if (promoCodeId == masterPromoCodeCacheModel.promoCodeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, promoCodeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{promoCodeId=");
		sb.append(promoCodeId);
		sb.append(", isDefault=");
		sb.append(isDefault);
		sb.append(", productCode=");
		sb.append(productCode);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", promoType=");
		sb.append(promoType);
		sb.append(", promoCode=");
		sb.append(promoCode);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", activeDay=");
		sb.append(activeDay);
		sb.append(", limit=");
		sb.append(limit);
		sb.append(", network=");
		sb.append(network);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", isB2C=");
		sb.append(isB2C);
		sb.append(", isB2B2C=");
		sb.append(isB2B2C);
		sb.append(", isB2B=");
		sb.append(isB2B);
		sb.append(", payment=");
		sb.append(payment);
		sb.append(", birthdayMonth=");
		sb.append(birthdayMonth);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
		sb.append(", agentName=");
		sb.append(agentName);
		sb.append(", deptoreCode=");
		sb.append(deptoreCode);
		sb.append(", commission=");
		sb.append(commission);
		sb.append(", plan_=");
		sb.append(plan_);
		sb.append(", promoCodeTerms=");
		sb.append(promoCodeTerms);
		sb.append(", travellerType=");
		sb.append(travellerType);
		sb.append(", utmId=");
		sb.append(utmId);
		sb.append(", paymentChannelId=");
		sb.append(paymentChannelId);
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
	public MasterPromoCode toEntityModel() {
		MasterPromoCodeImpl masterPromoCodeImpl = new MasterPromoCodeImpl();

		masterPromoCodeImpl.setPromoCodeId(promoCodeId);
		masterPromoCodeImpl.setIsDefault(isDefault);

		if (productCode == null) {
			masterPromoCodeImpl.setProductCode("");
		}
		else {
			masterPromoCodeImpl.setProductCode(productCode);
		}

		if (productName == null) {
			masterPromoCodeImpl.setProductName("");
		}
		else {
			masterPromoCodeImpl.setProductName(productName);
		}

		if (promoType == null) {
			masterPromoCodeImpl.setPromoType("");
		}
		else {
			masterPromoCodeImpl.setPromoType(promoType);
		}

		if (promoCode == null) {
			masterPromoCodeImpl.setPromoCode("");
		}
		else {
			masterPromoCodeImpl.setPromoCode(promoCode);
		}

		masterPromoCodeImpl.setDiscount(discount);

		if (startDate == Long.MIN_VALUE) {
			masterPromoCodeImpl.setStartDate(null);
		}
		else {
			masterPromoCodeImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			masterPromoCodeImpl.setEndDate(null);
		}
		else {
			masterPromoCodeImpl.setEndDate(new Date(endDate));
		}

		if (activeDay == null) {
			masterPromoCodeImpl.setActiveDay("");
		}
		else {
			masterPromoCodeImpl.setActiveDay(activeDay);
		}

		if (limit == null) {
			masterPromoCodeImpl.setLimit("");
		}
		else {
			masterPromoCodeImpl.setLimit(limit);
		}

		if (network == null) {
			masterPromoCodeImpl.setNetwork("");
		}
		else {
			masterPromoCodeImpl.setNetwork(network);
		}

		if (channel == null) {
			masterPromoCodeImpl.setChannel("");
		}
		else {
			masterPromoCodeImpl.setChannel(channel);
		}

		masterPromoCodeImpl.setIsB2C(isB2C);
		masterPromoCodeImpl.setIsB2B2C(isB2B2C);
		masterPromoCodeImpl.setIsB2B(isB2B);

		if (payment == null) {
			masterPromoCodeImpl.setPayment("");
		}
		else {
			masterPromoCodeImpl.setPayment(payment);
		}

		if (birthdayMonth == null) {
			masterPromoCodeImpl.setBirthdayMonth("");
		}
		else {
			masterPromoCodeImpl.setBirthdayMonth(birthdayMonth);
		}

		if (remarks == null) {
			masterPromoCodeImpl.setRemarks("");
		}
		else {
			masterPromoCodeImpl.setRemarks(remarks);
		}

		masterPromoCodeImpl.setMypageUserId(mypageUserId);

		if (agentName == null) {
			masterPromoCodeImpl.setAgentName("");
		}
		else {
			masterPromoCodeImpl.setAgentName(agentName);
		}

		if (deptoreCode == null) {
			masterPromoCodeImpl.setDeptoreCode("");
		}
		else {
			masterPromoCodeImpl.setDeptoreCode(deptoreCode);
		}

		if (commission == null) {
			masterPromoCodeImpl.setCommission("");
		}
		else {
			masterPromoCodeImpl.setCommission(commission);
		}

		if (plan_ == null) {
			masterPromoCodeImpl.setPlan_("");
		}
		else {
			masterPromoCodeImpl.setPlan_(plan_);
		}

		if (promoCodeTerms == null) {
			masterPromoCodeImpl.setPromoCodeTerms("");
		}
		else {
			masterPromoCodeImpl.setPromoCodeTerms(promoCodeTerms);
		}

		if (travellerType == null) {
			masterPromoCodeImpl.setTravellerType("");
		}
		else {
			masterPromoCodeImpl.setTravellerType(travellerType);
		}

		if (utmId == null) {
			masterPromoCodeImpl.setUtmId("");
		}
		else {
			masterPromoCodeImpl.setUtmId(utmId);
		}

		if (paymentChannelId == null) {
			masterPromoCodeImpl.setPaymentChannelId("");
		}
		else {
			masterPromoCodeImpl.setPaymentChannelId(paymentChannelId);
		}

		masterPromoCodeImpl.setActive(active);
		masterPromoCodeImpl.setGroupId(groupId);
		masterPromoCodeImpl.setCompanyId(companyId);
		masterPromoCodeImpl.setUserId(userId);

		if (userName == null) {
			masterPromoCodeImpl.setUserName("");
		}
		else {
			masterPromoCodeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterPromoCodeImpl.setCreateDate(null);
		}
		else {
			masterPromoCodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterPromoCodeImpl.setModifiedDate(null);
		}
		else {
			masterPromoCodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		masterPromoCodeImpl.resetOriginalValues();

		return masterPromoCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		promoCodeId = objectInput.readLong();

		isDefault = objectInput.readInt();
		productCode = objectInput.readUTF();
		productName = objectInput.readUTF();
		promoType = objectInput.readUTF();
		promoCode = objectInput.readUTF();

		discount = objectInput.readDouble();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		activeDay = objectInput.readUTF();
		limit = objectInput.readUTF();
		network = objectInput.readUTF();
		channel = objectInput.readUTF();

		isB2C = objectInput.readInt();

		isB2B2C = objectInput.readInt();

		isB2B = objectInput.readInt();
		payment = objectInput.readUTF();
		birthdayMonth = objectInput.readUTF();
		remarks = objectInput.readUTF();

		mypageUserId = objectInput.readLong();
		agentName = objectInput.readUTF();
		deptoreCode = objectInput.readUTF();
		commission = objectInput.readUTF();
		plan_ = objectInput.readUTF();
		promoCodeTerms = objectInput.readUTF();
		travellerType = objectInput.readUTF();
		utmId = objectInput.readUTF();
		paymentChannelId = objectInput.readUTF();

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
		objectOutput.writeLong(promoCodeId);

		objectOutput.writeInt(isDefault);

		if (productCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCode);
		}

		if (productName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (promoType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoType);
		}

		if (promoCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoCode);
		}

		objectOutput.writeDouble(discount);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (activeDay == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(activeDay);
		}

		if (limit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(limit);
		}

		if (network == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(network);
		}

		if (channel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(channel);
		}

		objectOutput.writeInt(isB2C);

		objectOutput.writeInt(isB2B2C);

		objectOutput.writeInt(isB2B);

		if (payment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(payment);
		}

		if (birthdayMonth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(birthdayMonth);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(mypageUserId);

		if (agentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agentName);
		}

		if (deptoreCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deptoreCode);
		}

		if (commission == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commission);
		}

		if (plan_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plan_);
		}

		if (promoCodeTerms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoCodeTerms);
		}

		if (travellerType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travellerType);
		}

		if (utmId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmId);
		}

		if (paymentChannelId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentChannelId);
		}

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

	public long promoCodeId;
	public int isDefault;
	public String productCode;
	public String productName;
	public String promoType;
	public String promoCode;
	public double discount;
	public long startDate;
	public long endDate;
	public String activeDay;
	public String limit;
	public String network;
	public String channel;
	public int isB2C;
	public int isB2B2C;
	public int isB2B;
	public String payment;
	public String birthdayMonth;
	public String remarks;
	public long mypageUserId;
	public String agentName;
	public String deptoreCode;
	public String commission;
	public String plan_;
	public String promoCodeTerms;
	public String travellerType;
	public String utmId;
	public String paymentChannelId;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}