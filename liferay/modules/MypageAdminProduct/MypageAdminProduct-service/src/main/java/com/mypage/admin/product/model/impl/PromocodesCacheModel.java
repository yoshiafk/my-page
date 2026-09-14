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

import com.mypage.admin.product.model.Promocodes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Promocodes in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PromocodesCacheModel
	implements CacheModel<Promocodes>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PromocodesCacheModel)) {
			return false;
		}

		PromocodesCacheModel promocodesCacheModel =
			(PromocodesCacheModel)object;

		if (promocodeId == promocodesCacheModel.promocodeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, promocodeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", promocodeId=");
		sb.append(promocodeId);
		sb.append(", products=");
		sb.append(products);
		sb.append(", promocode=");
		sb.append(promocode);
		sb.append(", commission=");
		sb.append(commission);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", isB2C=");
		sb.append(isB2C);
		sb.append(", isB2B2C=");
		sb.append(isB2B2C);
		sb.append(", isB2B=");
		sb.append(isB2B);
		sb.append(", user=");
		sb.append(user);
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", promoType=");
		sb.append(promoType);
		sb.append(", birthdayMonth=");
		sb.append(birthdayMonth);
		sb.append(", limit=");
		sb.append(limit);
		sb.append(", terms=");
		sb.append(terms);
		sb.append(", plan=");
		sb.append(plan);
		sb.append(", paymentChannel=");
		sb.append(paymentChannel);
		sb.append(", utmCampaignId=");
		sb.append(utmCampaignId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Promocodes toEntityModel() {
		PromocodesImpl promocodesImpl = new PromocodesImpl();

		if (uuid == null) {
			promocodesImpl.setUuid("");
		}
		else {
			promocodesImpl.setUuid(uuid);
		}

		promocodesImpl.setPromocodeId(promocodeId);

		if (products == null) {
			promocodesImpl.setProducts("");
		}
		else {
			promocodesImpl.setProducts(products);
		}

		if (promocode == null) {
			promocodesImpl.setPromocode("");
		}
		else {
			promocodesImpl.setPromocode(promocode);
		}

		promocodesImpl.setCommission(commission);
		promocodesImpl.setDiscount(discount);
		promocodesImpl.setIsB2C(isB2C);
		promocodesImpl.setIsB2B2C(isB2B2C);
		promocodesImpl.setIsB2B(isB2B);

		if (user == null) {
			promocodesImpl.setUser("");
		}
		else {
			promocodesImpl.setUser(user);
		}

		promocodesImpl.setMypageUserId(mypageUserId);

		if (startDate == Long.MIN_VALUE) {
			promocodesImpl.setStartDate(null);
		}
		else {
			promocodesImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			promocodesImpl.setEndDate(null);
		}
		else {
			promocodesImpl.setEndDate(new Date(endDate));
		}

		if (promoType == null) {
			promocodesImpl.setPromoType("");
		}
		else {
			promocodesImpl.setPromoType(promoType);
		}

		if (birthdayMonth == Long.MIN_VALUE) {
			promocodesImpl.setBirthdayMonth(null);
		}
		else {
			promocodesImpl.setBirthdayMonth(new Date(birthdayMonth));
		}

		promocodesImpl.setLimit(limit);

		if (terms == null) {
			promocodesImpl.setTerms("");
		}
		else {
			promocodesImpl.setTerms(terms);
		}

		if (plan == null) {
			promocodesImpl.setPlan("");
		}
		else {
			promocodesImpl.setPlan(plan);
		}

		if (paymentChannel == null) {
			promocodesImpl.setPaymentChannel("");
		}
		else {
			promocodesImpl.setPaymentChannel(paymentChannel);
		}

		if (utmCampaignId == null) {
			promocodesImpl.setUtmCampaignId("");
		}
		else {
			promocodesImpl.setUtmCampaignId(utmCampaignId);
		}

		promocodesImpl.setActive(active);
		promocodesImpl.setGroupId(groupId);
		promocodesImpl.setCompanyId(companyId);
		promocodesImpl.setUserId(userId);

		if (userName == null) {
			promocodesImpl.setUserName("");
		}
		else {
			promocodesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			promocodesImpl.setCreateDate(null);
		}
		else {
			promocodesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			promocodesImpl.setModifiedDate(null);
		}
		else {
			promocodesImpl.setModifiedDate(new Date(modifiedDate));
		}

		promocodesImpl.setStatus(status);
		promocodesImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			promocodesImpl.setStatusByUserName("");
		}
		else {
			promocodesImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			promocodesImpl.setStatusDate(null);
		}
		else {
			promocodesImpl.setStatusDate(new Date(statusDate));
		}

		promocodesImpl.resetOriginalValues();

		return promocodesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		promocodeId = objectInput.readLong();
		products = objectInput.readUTF();
		promocode = objectInput.readUTF();

		commission = objectInput.readDouble();

		discount = objectInput.readDouble();

		isB2C = objectInput.readInt();

		isB2B2C = objectInput.readInt();

		isB2B = objectInput.readInt();
		user = objectInput.readUTF();

		mypageUserId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		promoType = objectInput.readUTF();
		birthdayMonth = objectInput.readLong();

		limit = objectInput.readInt();
		terms = objectInput.readUTF();
		plan = objectInput.readUTF();
		paymentChannel = objectInput.readUTF();
		utmCampaignId = objectInput.readUTF();

		active = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(promocodeId);

		if (products == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(products);
		}

		if (promocode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promocode);
		}

		objectOutput.writeDouble(commission);

		objectOutput.writeDouble(discount);

		objectOutput.writeInt(isB2C);

		objectOutput.writeInt(isB2B2C);

		objectOutput.writeInt(isB2B);

		if (user == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(user);
		}

		objectOutput.writeLong(mypageUserId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (promoType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoType);
		}

		objectOutput.writeLong(birthdayMonth);

		objectOutput.writeInt(limit);

		if (terms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(terms);
		}

		if (plan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plan);
		}

		if (paymentChannel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentChannel);
		}

		if (utmCampaignId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utmCampaignId);
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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long promocodeId;
	public String products;
	public String promocode;
	public double commission;
	public double discount;
	public int isB2C;
	public int isB2B2C;
	public int isB2B;
	public String user;
	public long mypageUserId;
	public long startDate;
	public long endDate;
	public String promoType;
	public long birthdayMonth;
	public int limit;
	public String terms;
	public String plan;
	public String paymentChannel;
	public String utmCampaignId;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}