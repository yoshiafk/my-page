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

import com.mypage.admin.product.model.TravelInternationalPremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing TravelInternationalPremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelInternationalPremiCacheModel
	implements CacheModel<TravelInternationalPremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelInternationalPremiCacheModel)) {
			return false;
		}

		TravelInternationalPremiCacheModel travelInternationalPremiCacheModel =
			(TravelInternationalPremiCacheModel)object;

		if (premiId == travelInternationalPremiCacheModel.premiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, premiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{premiId=");
		sb.append(premiId);
		sb.append(", packageType=");
		sb.append(packageType);
		sb.append(", peopleType=");
		sb.append(peopleType);
		sb.append(", adultCount=");
		sb.append(adultCount);
		sb.append(", childrenCount=");
		sb.append(childrenCount);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", minDuration=");
		sb.append(minDuration);
		sb.append(", maxDuration=");
		sb.append(maxDuration);
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
	public TravelInternationalPremi toEntityModel() {
		TravelInternationalPremiImpl travelInternationalPremiImpl =
			new TravelInternationalPremiImpl();

		travelInternationalPremiImpl.setPremiId(premiId);

		if (packageType == null) {
			travelInternationalPremiImpl.setPackageType("");
		}
		else {
			travelInternationalPremiImpl.setPackageType(packageType);
		}

		if (peopleType == null) {
			travelInternationalPremiImpl.setPeopleType("");
		}
		else {
			travelInternationalPremiImpl.setPeopleType(peopleType);
		}

		travelInternationalPremiImpl.setAdultCount(adultCount);
		travelInternationalPremiImpl.setChildrenCount(childrenCount);

		if (currency == null) {
			travelInternationalPremiImpl.setCurrency("");
		}
		else {
			travelInternationalPremiImpl.setCurrency(currency);
		}

		travelInternationalPremiImpl.setAmount(amount);
		travelInternationalPremiImpl.setMinDuration(minDuration);
		travelInternationalPremiImpl.setMaxDuration(maxDuration);
		travelInternationalPremiImpl.setActive(active);
		travelInternationalPremiImpl.setGroupId(groupId);
		travelInternationalPremiImpl.setCompanyId(companyId);
		travelInternationalPremiImpl.setUserId(userId);

		if (userName == null) {
			travelInternationalPremiImpl.setUserName("");
		}
		else {
			travelInternationalPremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelInternationalPremiImpl.setCreateDate(null);
		}
		else {
			travelInternationalPremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelInternationalPremiImpl.setModifiedDate(null);
		}
		else {
			travelInternationalPremiImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		travelInternationalPremiImpl.setStatus(status);
		travelInternationalPremiImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			travelInternationalPremiImpl.setStatusByUserName("");
		}
		else {
			travelInternationalPremiImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			travelInternationalPremiImpl.setStatusDate(null);
		}
		else {
			travelInternationalPremiImpl.setStatusDate(new Date(statusDate));
		}

		travelInternationalPremiImpl.resetOriginalValues();

		return travelInternationalPremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		premiId = objectInput.readLong();
		packageType = objectInput.readUTF();
		peopleType = objectInput.readUTF();

		adultCount = objectInput.readInt();

		childrenCount = objectInput.readInt();
		currency = objectInput.readUTF();
		amount = (BigDecimal)objectInput.readObject();

		minDuration = objectInput.readInt();

		maxDuration = objectInput.readInt();

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
		objectOutput.writeLong(premiId);

		if (packageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(packageType);
		}

		if (peopleType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(peopleType);
		}

		objectOutput.writeInt(adultCount);

		objectOutput.writeInt(childrenCount);

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeObject(amount);

		objectOutput.writeInt(minDuration);

		objectOutput.writeInt(maxDuration);

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

	public long premiId;
	public String packageType;
	public String peopleType;
	public int adultCount;
	public int childrenCount;
	public String currency;
	public BigDecimal amount;
	public int minDuration;
	public int maxDuration;
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