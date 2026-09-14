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

import com.mypage.admin.product.model.PetRate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PetRate in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PetRateCacheModel implements CacheModel<PetRate>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetRateCacheModel)) {
			return false;
		}

		PetRateCacheModel petRateCacheModel = (PetRateCacheModel)object;

		if (petRateId == petRateCacheModel.petRateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petRateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{petRateId=");
		sb.append(petRateId);
		sb.append(", petPlan=");
		sb.append(petPlan);
		sb.append(", petRemarks=");
		sb.append(petRemarks);
		sb.append(", rate=");
		sb.append(rate);
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
	public PetRate toEntityModel() {
		PetRateImpl petRateImpl = new PetRateImpl();

		petRateImpl.setPetRateId(petRateId);
		petRateImpl.setPetPlan(petPlan);
		petRateImpl.setPetRemarks(petRemarks);

		if (rate == null) {
			petRateImpl.setRate("");
		}
		else {
			petRateImpl.setRate(rate);
		}

		petRateImpl.setActive(active);
		petRateImpl.setGroupId(groupId);
		petRateImpl.setCompanyId(companyId);
		petRateImpl.setUserId(userId);

		if (userName == null) {
			petRateImpl.setUserName("");
		}
		else {
			petRateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petRateImpl.setCreateDate(null);
		}
		else {
			petRateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petRateImpl.setModifiedDate(null);
		}
		else {
			petRateImpl.setModifiedDate(new Date(modifiedDate));
		}

		petRateImpl.resetOriginalValues();

		return petRateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		petRateId = objectInput.readLong();

		petPlan = objectInput.readLong();

		petRemarks = objectInput.readLong();
		rate = objectInput.readUTF();

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
		objectOutput.writeLong(petRateId);

		objectOutput.writeLong(petPlan);

		objectOutput.writeLong(petRemarks);

		if (rate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rate);
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

	public long petRateId;
	public long petPlan;
	public long petRemarks;
	public String rate;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}