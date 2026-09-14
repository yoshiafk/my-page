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

import com.mypage.admin.product.model.TravelDomesticInsuredType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticInsuredType in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticInsuredTypeCacheModel
	implements CacheModel<TravelDomesticInsuredType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticInsuredTypeCacheModel)) {
			return false;
		}

		TravelDomesticInsuredTypeCacheModel
			travelDomesticInsuredTypeCacheModel =
				(TravelDomesticInsuredTypeCacheModel)object;

		if (travelDomesticInsuredTypeId ==
				travelDomesticInsuredTypeCacheModel.
					travelDomesticInsuredTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticInsuredTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{travelDomesticInsuredTypeId=");
		sb.append(travelDomesticInsuredTypeId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticInsuredType toEntityModel() {
		TravelDomesticInsuredTypeImpl travelDomesticInsuredTypeImpl =
			new TravelDomesticInsuredTypeImpl();

		travelDomesticInsuredTypeImpl.setTravelDomesticInsuredTypeId(
			travelDomesticInsuredTypeId);
		travelDomesticInsuredTypeImpl.setGroupId(groupId);
		travelDomesticInsuredTypeImpl.setCompanyId(companyId);
		travelDomesticInsuredTypeImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticInsuredTypeImpl.setUserName("");
		}
		else {
			travelDomesticInsuredTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticInsuredTypeImpl.setCreateDate(null);
		}
		else {
			travelDomesticInsuredTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticInsuredTypeImpl.setModifiedDate(null);
		}
		else {
			travelDomesticInsuredTypeImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (name == null) {
			travelDomesticInsuredTypeImpl.setName("");
		}
		else {
			travelDomesticInsuredTypeImpl.setName(name);
		}

		if (code == null) {
			travelDomesticInsuredTypeImpl.setCode("");
		}
		else {
			travelDomesticInsuredTypeImpl.setCode(code);
		}

		travelDomesticInsuredTypeImpl.setActive(active);

		travelDomesticInsuredTypeImpl.resetOriginalValues();

		return travelDomesticInsuredTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticInsuredTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticInsuredTypeId);

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

		objectOutput.writeInt(active);
	}

	public long travelDomesticInsuredTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
	public int active;

}