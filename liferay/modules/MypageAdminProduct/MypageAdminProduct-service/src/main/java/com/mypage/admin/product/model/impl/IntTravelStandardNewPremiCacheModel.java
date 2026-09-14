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

import com.mypage.admin.product.model.IntTravelStandardNewPremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing IntTravelStandardNewPremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class IntTravelStandardNewPremiCacheModel
	implements CacheModel<IntTravelStandardNewPremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IntTravelStandardNewPremiCacheModel)) {
			return false;
		}

		IntTravelStandardNewPremiCacheModel
			intTravelStandardNewPremiCacheModel =
				(IntTravelStandardNewPremiCacheModel)object;

		if (intTravelStandardNewPremiId ==
				intTravelStandardNewPremiCacheModel.
					intTravelStandardNewPremiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, intTravelStandardNewPremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{intTravelStandardNewPremiId=");
		sb.append(intTravelStandardNewPremiId);
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
		sb.append(", travelType=");
		sb.append(travelType);
		sb.append(", packageType=");
		sb.append(packageType);
		sb.append(", peopleType=");
		sb.append(peopleType);
		sb.append(", mainInsured=");
		sb.append(mainInsured);
		sb.append(", spouse=");
		sb.append(spouse);
		sb.append(", child=");
		sb.append(child);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", additionalPrice=");
		sb.append(additionalPrice);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IntTravelStandardNewPremi toEntityModel() {
		IntTravelStandardNewPremiImpl intTravelStandardNewPremiImpl =
			new IntTravelStandardNewPremiImpl();

		intTravelStandardNewPremiImpl.setIntTravelStandardNewPremiId(
			intTravelStandardNewPremiId);
		intTravelStandardNewPremiImpl.setGroupId(groupId);
		intTravelStandardNewPremiImpl.setCompanyId(companyId);
		intTravelStandardNewPremiImpl.setUserId(userId);

		if (userName == null) {
			intTravelStandardNewPremiImpl.setUserName("");
		}
		else {
			intTravelStandardNewPremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			intTravelStandardNewPremiImpl.setCreateDate(null);
		}
		else {
			intTravelStandardNewPremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			intTravelStandardNewPremiImpl.setModifiedDate(null);
		}
		else {
			intTravelStandardNewPremiImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (travelType == null) {
			intTravelStandardNewPremiImpl.setTravelType("");
		}
		else {
			intTravelStandardNewPremiImpl.setTravelType(travelType);
		}

		if (packageType == null) {
			intTravelStandardNewPremiImpl.setPackageType("");
		}
		else {
			intTravelStandardNewPremiImpl.setPackageType(packageType);
		}

		if (peopleType == null) {
			intTravelStandardNewPremiImpl.setPeopleType("");
		}
		else {
			intTravelStandardNewPremiImpl.setPeopleType(peopleType);
		}

		intTravelStandardNewPremiImpl.setMainInsured(mainInsured);
		intTravelStandardNewPremiImpl.setSpouse(spouse);
		intTravelStandardNewPremiImpl.setChild(child);

		if (currency == null) {
			intTravelStandardNewPremiImpl.setCurrency("");
		}
		else {
			intTravelStandardNewPremiImpl.setCurrency(currency);
		}

		intTravelStandardNewPremiImpl.setAmount(amount);
		intTravelStandardNewPremiImpl.setAdditionalPrice(additionalPrice);
		intTravelStandardNewPremiImpl.setActive(active);

		intTravelStandardNewPremiImpl.resetOriginalValues();

		return intTravelStandardNewPremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		intTravelStandardNewPremiId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		travelType = objectInput.readUTF();
		packageType = objectInput.readUTF();
		peopleType = objectInput.readUTF();

		mainInsured = objectInput.readInt();

		spouse = objectInput.readInt();

		child = objectInput.readInt();
		currency = objectInput.readUTF();
		amount = (BigDecimal)objectInput.readObject();
		additionalPrice = (BigDecimal)objectInput.readObject();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(intTravelStandardNewPremiId);

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

		if (travelType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelType);
		}

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

		objectOutput.writeInt(mainInsured);

		objectOutput.writeInt(spouse);

		objectOutput.writeInt(child);

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeObject(amount);
		objectOutput.writeObject(additionalPrice);

		objectOutput.writeInt(active);
	}

	public long intTravelStandardNewPremiId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String travelType;
	public String packageType;
	public String peopleType;
	public int mainInsured;
	public int spouse;
	public int child;
	public String currency;
	public BigDecimal amount;
	public BigDecimal additionalPrice;
	public int active;

}