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

import com.mypage.admin.product.model.TravelDomesticDuration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticDuration in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticDurationCacheModel
	implements CacheModel<TravelDomesticDuration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticDurationCacheModel)) {
			return false;
		}

		TravelDomesticDurationCacheModel travelDomesticDurationCacheModel =
			(TravelDomesticDurationCacheModel)object;

		if (travelDomesticDurationId ==
				travelDomesticDurationCacheModel.travelDomesticDurationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticDurationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{travelDomesticDurationId=");
		sb.append(travelDomesticDurationId);
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
		sb.append(", dayFrom=");
		sb.append(dayFrom);
		sb.append(", dayTo=");
		sb.append(dayTo);
		sb.append(", label=");
		sb.append(label);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticDuration toEntityModel() {
		TravelDomesticDurationImpl travelDomesticDurationImpl =
			new TravelDomesticDurationImpl();

		travelDomesticDurationImpl.setTravelDomesticDurationId(
			travelDomesticDurationId);
		travelDomesticDurationImpl.setGroupId(groupId);
		travelDomesticDurationImpl.setCompanyId(companyId);
		travelDomesticDurationImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticDurationImpl.setUserName("");
		}
		else {
			travelDomesticDurationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticDurationImpl.setCreateDate(null);
		}
		else {
			travelDomesticDurationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticDurationImpl.setModifiedDate(null);
		}
		else {
			travelDomesticDurationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			travelDomesticDurationImpl.setCode("");
		}
		else {
			travelDomesticDurationImpl.setCode(code);
		}

		travelDomesticDurationImpl.setDayFrom(dayFrom);
		travelDomesticDurationImpl.setDayTo(dayTo);

		if (label == null) {
			travelDomesticDurationImpl.setLabel("");
		}
		else {
			travelDomesticDurationImpl.setLabel(label);
		}

		travelDomesticDurationImpl.setActive(active);

		travelDomesticDurationImpl.resetOriginalValues();

		return travelDomesticDurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticDurationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();

		dayFrom = objectInput.readInt();

		dayTo = objectInput.readInt();
		label = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticDurationId);

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

		objectOutput.writeInt(dayFrom);

		objectOutput.writeInt(dayTo);

		if (label == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label);
		}

		objectOutput.writeInt(active);
	}

	public long travelDomesticDurationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public int dayFrom;
	public int dayTo;
	public String label;
	public int active;

}