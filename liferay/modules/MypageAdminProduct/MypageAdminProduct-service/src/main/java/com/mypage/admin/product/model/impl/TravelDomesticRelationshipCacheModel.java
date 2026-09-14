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

import com.mypage.admin.product.model.TravelDomesticRelationship;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticRelationship in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticRelationshipCacheModel
	implements CacheModel<TravelDomesticRelationship>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticRelationshipCacheModel)) {
			return false;
		}

		TravelDomesticRelationshipCacheModel
			travelDomesticRelationshipCacheModel =
				(TravelDomesticRelationshipCacheModel)object;

		if (travelDomesticRelationshipId ==
				travelDomesticRelationshipCacheModel.
					travelDomesticRelationshipId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticRelationshipId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{travelDomesticRelationshipId=");
		sb.append(travelDomesticRelationshipId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticRelationship toEntityModel() {
		TravelDomesticRelationshipImpl travelDomesticRelationshipImpl =
			new TravelDomesticRelationshipImpl();

		travelDomesticRelationshipImpl.setTravelDomesticRelationshipId(
			travelDomesticRelationshipId);
		travelDomesticRelationshipImpl.setGroupId(groupId);
		travelDomesticRelationshipImpl.setCompanyId(companyId);
		travelDomesticRelationshipImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticRelationshipImpl.setUserName("");
		}
		else {
			travelDomesticRelationshipImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticRelationshipImpl.setCreateDate(null);
		}
		else {
			travelDomesticRelationshipImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticRelationshipImpl.setModifiedDate(null);
		}
		else {
			travelDomesticRelationshipImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (name == null) {
			travelDomesticRelationshipImpl.setName("");
		}
		else {
			travelDomesticRelationshipImpl.setName(name);
		}

		if (description == null) {
			travelDomesticRelationshipImpl.setDescription("");
		}
		else {
			travelDomesticRelationshipImpl.setDescription(description);
		}

		travelDomesticRelationshipImpl.setSort(sort);
		travelDomesticRelationshipImpl.setActive(active);

		travelDomesticRelationshipImpl.resetOriginalValues();

		return travelDomesticRelationshipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticRelationshipId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		sort = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticRelationshipId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(sort);

		objectOutput.writeInt(active);
	}

	public long travelDomesticRelationshipId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public int sort;
	public int active;

}