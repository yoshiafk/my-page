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

import com.mypage.admin.product.model.TravelDomesticPremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticPremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticPremiCacheModel
	implements CacheModel<TravelDomesticPremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticPremiCacheModel)) {
			return false;
		}

		TravelDomesticPremiCacheModel travelDomesticPremiCacheModel =
			(TravelDomesticPremiCacheModel)object;

		if (travelDomesticPremiId ==
				travelDomesticPremiCacheModel.travelDomesticPremiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticPremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{travelDomesticPremiId=");
		sb.append(travelDomesticPremiId);
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
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", plan=");
		sb.append(plan);
		sb.append(", insuredType=");
		sb.append(insuredType);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticPremi toEntityModel() {
		TravelDomesticPremiImpl travelDomesticPremiImpl =
			new TravelDomesticPremiImpl();

		travelDomesticPremiImpl.setTravelDomesticPremiId(travelDomesticPremiId);
		travelDomesticPremiImpl.setGroupId(groupId);
		travelDomesticPremiImpl.setCompanyId(companyId);
		travelDomesticPremiImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticPremiImpl.setUserName("");
		}
		else {
			travelDomesticPremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticPremiImpl.setCreateDate(null);
		}
		else {
			travelDomesticPremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticPremiImpl.setModifiedDate(null);
		}
		else {
			travelDomesticPremiImpl.setModifiedDate(new Date(modifiedDate));
		}

		travelDomesticPremiImpl.setDuration(duration);

		if (plan == null) {
			travelDomesticPremiImpl.setPlan("");
		}
		else {
			travelDomesticPremiImpl.setPlan(plan);
		}

		if (insuredType == null) {
			travelDomesticPremiImpl.setInsuredType("");
		}
		else {
			travelDomesticPremiImpl.setInsuredType(insuredType);
		}

		if (currency == null) {
			travelDomesticPremiImpl.setCurrency("");
		}
		else {
			travelDomesticPremiImpl.setCurrency(currency);
		}

		travelDomesticPremiImpl.setAmount(amount);
		travelDomesticPremiImpl.setActive(active);

		travelDomesticPremiImpl.resetOriginalValues();

		return travelDomesticPremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticPremiId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		duration = objectInput.readInt();
		plan = objectInput.readUTF();
		insuredType = objectInput.readUTF();
		currency = objectInput.readUTF();

		amount = objectInput.readLong();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticPremiId);

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

		objectOutput.writeInt(duration);

		if (plan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plan);
		}

		if (insuredType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredType);
		}

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(amount);

		objectOutput.writeInt(active);
	}

	public long travelDomesticPremiId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int duration;
	public String plan;
	public String insuredType;
	public String currency;
	public long amount;
	public int active;

}