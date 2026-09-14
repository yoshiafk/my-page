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

import com.mypage.admin.product.model.MasterCountry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterCountry in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterCountryCacheModel
	implements CacheModel<MasterCountry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterCountryCacheModel)) {
			return false;
		}

		MasterCountryCacheModel masterCountryCacheModel =
			(MasterCountryCacheModel)object;

		if (countryId == masterCountryCacheModel.countryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, countryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{countryId=");
		sb.append(countryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", isPlatinum=");
		sb.append(isPlatinum);
		sb.append(", isGold=");
		sb.append(isGold);
		sb.append(", isSpecialAsia=");
		sb.append(isSpecialAsia);
		sb.append(", isSchengen=");
		sb.append(isSchengen);
		sb.append(", isSanctionCountry=");
		sb.append(isSanctionCountry);
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
	public MasterCountry toEntityModel() {
		MasterCountryImpl masterCountryImpl = new MasterCountryImpl();

		masterCountryImpl.setCountryId(countryId);

		if (name == null) {
			masterCountryImpl.setName("");
		}
		else {
			masterCountryImpl.setName(name);
		}

		masterCountryImpl.setIsPlatinum(isPlatinum);
		masterCountryImpl.setIsGold(isGold);
		masterCountryImpl.setIsSpecialAsia(isSpecialAsia);
		masterCountryImpl.setIsSchengen(isSchengen);
		masterCountryImpl.setIsSanctionCountry(isSanctionCountry);
		masterCountryImpl.setActive(active);
		masterCountryImpl.setGroupId(groupId);
		masterCountryImpl.setCompanyId(companyId);
		masterCountryImpl.setUserId(userId);

		if (userName == null) {
			masterCountryImpl.setUserName("");
		}
		else {
			masterCountryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterCountryImpl.setCreateDate(null);
		}
		else {
			masterCountryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterCountryImpl.setModifiedDate(null);
		}
		else {
			masterCountryImpl.setModifiedDate(new Date(modifiedDate));
		}

		masterCountryImpl.resetOriginalValues();

		return masterCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryId = objectInput.readLong();
		name = objectInput.readUTF();

		isPlatinum = objectInput.readInt();

		isGold = objectInput.readInt();

		isSpecialAsia = objectInput.readInt();

		isSchengen = objectInput.readInt();

		isSanctionCountry = objectInput.readInt();

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
		objectOutput.writeLong(countryId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(isPlatinum);

		objectOutput.writeInt(isGold);

		objectOutput.writeInt(isSpecialAsia);

		objectOutput.writeInt(isSchengen);

		objectOutput.writeInt(isSanctionCountry);

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

	public long countryId;
	public String name;
	public int isPlatinum;
	public int isGold;
	public int isSpecialAsia;
	public int isSchengen;
	public int isSanctionCountry;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}