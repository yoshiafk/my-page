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

import com.mypage.admin.product.model.MasterCity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterCity in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterCityCacheModel
	implements CacheModel<MasterCity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterCityCacheModel)) {
			return false;
		}

		MasterCityCacheModel masterCityCacheModel =
			(MasterCityCacheModel)object;

		if (masterCityId == masterCityCacheModel.masterCityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterCityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{masterCityId=");
		sb.append(masterCityId);
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
		sb.append(", provinceId=");
		sb.append(provinceId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", parEarthquakeZone=");
		sb.append(parEarthquakeZone);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterCity toEntityModel() {
		MasterCityImpl masterCityImpl = new MasterCityImpl();

		masterCityImpl.setMasterCityId(masterCityId);
		masterCityImpl.setGroupId(groupId);
		masterCityImpl.setCompanyId(companyId);
		masterCityImpl.setUserId(userId);

		if (userName == null) {
			masterCityImpl.setUserName("");
		}
		else {
			masterCityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterCityImpl.setCreateDate(null);
		}
		else {
			masterCityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterCityImpl.setModifiedDate(null);
		}
		else {
			masterCityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			masterCityImpl.setName("");
		}
		else {
			masterCityImpl.setName(name);
		}

		masterCityImpl.setProvinceId(provinceId);

		if (status == null) {
			masterCityImpl.setStatus("");
		}
		else {
			masterCityImpl.setStatus(status);
		}

		masterCityImpl.setParEarthquakeZone(parEarthquakeZone);
		masterCityImpl.setActive(active);

		masterCityImpl.resetOriginalValues();

		return masterCityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterCityId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		provinceId = objectInput.readLong();
		status = objectInput.readUTF();

		parEarthquakeZone = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterCityId);

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

		objectOutput.writeLong(provinceId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeInt(parEarthquakeZone);

		objectOutput.writeInt(active);
	}

	public long masterCityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long provinceId;
	public String status;
	public int parEarthquakeZone;
	public int active;

}