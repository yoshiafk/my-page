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

import com.mypage.admin.product.model.TravelDomesticPlan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticPlan in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticPlanCacheModel
	implements CacheModel<TravelDomesticPlan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticPlanCacheModel)) {
			return false;
		}

		TravelDomesticPlanCacheModel travelDomesticPlanCacheModel =
			(TravelDomesticPlanCacheModel)object;

		if (travelDomesticPlanId ==
				travelDomesticPlanCacheModel.travelDomesticPlanId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticPlanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{travelDomesticPlanId=");
		sb.append(travelDomesticPlanId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", toproTsi=");
		sb.append(toproTsi);
		sb.append(", toproAtsi=");
		sb.append(toproAtsi);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticPlan toEntityModel() {
		TravelDomesticPlanImpl travelDomesticPlanImpl =
			new TravelDomesticPlanImpl();

		travelDomesticPlanImpl.setTravelDomesticPlanId(travelDomesticPlanId);
		travelDomesticPlanImpl.setGroupId(groupId);
		travelDomesticPlanImpl.setCompanyId(companyId);
		travelDomesticPlanImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticPlanImpl.setUserName("");
		}
		else {
			travelDomesticPlanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticPlanImpl.setCreateDate(null);
		}
		else {
			travelDomesticPlanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticPlanImpl.setModifiedDate(null);
		}
		else {
			travelDomesticPlanImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			travelDomesticPlanImpl.setName("");
		}
		else {
			travelDomesticPlanImpl.setName(name);
		}

		if (code == null) {
			travelDomesticPlanImpl.setCode("");
		}
		else {
			travelDomesticPlanImpl.setCode(code);
		}

		travelDomesticPlanImpl.setToproTsi(toproTsi);
		travelDomesticPlanImpl.setToproAtsi(toproAtsi);
		travelDomesticPlanImpl.setSort(sort);
		travelDomesticPlanImpl.setActive(active);

		travelDomesticPlanImpl.resetOriginalValues();

		return travelDomesticPlanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticPlanId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		toproTsi = objectInput.readInt();

		toproAtsi = objectInput.readInt();

		sort = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticPlanId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(toproTsi);

		objectOutput.writeInt(toproAtsi);

		objectOutput.writeInt(sort);

		objectOutput.writeInt(active);
	}

	public long travelDomesticPlanId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
	public int toproTsi;
	public int toproAtsi;
	public int sort;
	public int active;

}