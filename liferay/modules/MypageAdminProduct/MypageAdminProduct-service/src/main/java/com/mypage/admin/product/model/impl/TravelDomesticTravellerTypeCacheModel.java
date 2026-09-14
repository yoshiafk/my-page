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

import com.mypage.admin.product.model.TravelDomesticTravellerType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticTravellerType in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticTravellerTypeCacheModel
	implements CacheModel<TravelDomesticTravellerType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticTravellerTypeCacheModel)) {
			return false;
		}

		TravelDomesticTravellerTypeCacheModel
			travelDomesticTravellerTypeCacheModel =
				(TravelDomesticTravellerTypeCacheModel)object;

		if (travellerTypeId ==
				travelDomesticTravellerTypeCacheModel.travellerTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travellerTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{travellerTypeId=");
		sb.append(travellerTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
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
	public TravelDomesticTravellerType toEntityModel() {
		TravelDomesticTravellerTypeImpl travelDomesticTravellerTypeImpl =
			new TravelDomesticTravellerTypeImpl();

		travelDomesticTravellerTypeImpl.setTravellerTypeId(travellerTypeId);

		if (name == null) {
			travelDomesticTravellerTypeImpl.setName("");
		}
		else {
			travelDomesticTravellerTypeImpl.setName(name);
		}

		if (description == null) {
			travelDomesticTravellerTypeImpl.setDescription("");
		}
		else {
			travelDomesticTravellerTypeImpl.setDescription(description);
		}

		travelDomesticTravellerTypeImpl.setActive(active);
		travelDomesticTravellerTypeImpl.setGroupId(groupId);
		travelDomesticTravellerTypeImpl.setCompanyId(companyId);
		travelDomesticTravellerTypeImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticTravellerTypeImpl.setUserName("");
		}
		else {
			travelDomesticTravellerTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticTravellerTypeImpl.setCreateDate(null);
		}
		else {
			travelDomesticTravellerTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticTravellerTypeImpl.setModifiedDate(null);
		}
		else {
			travelDomesticTravellerTypeImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		travelDomesticTravellerTypeImpl.resetOriginalValues();

		return travelDomesticTravellerTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travellerTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

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
		objectOutput.writeLong(travellerTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
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

	public long travellerTypeId;
	public String name;
	public String description;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}