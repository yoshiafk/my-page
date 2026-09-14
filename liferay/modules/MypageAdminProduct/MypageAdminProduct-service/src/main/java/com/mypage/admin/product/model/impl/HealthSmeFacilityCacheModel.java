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

import com.mypage.admin.product.model.HealthSmeFacility;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HealthSmeFacility in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class HealthSmeFacilityCacheModel
	implements CacheModel<HealthSmeFacility>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HealthSmeFacilityCacheModel)) {
			return false;
		}

		HealthSmeFacilityCacheModel healthSmeFacilityCacheModel =
			(HealthSmeFacilityCacheModel)object;

		if (healthSmeFacilityId ==
				healthSmeFacilityCacheModel.healthSmeFacilityId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, healthSmeFacilityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{healthSmeFacilityId=");
		sb.append(healthSmeFacilityId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", healthSmeTypeId=");
		sb.append(healthSmeTypeId);
		sb.append(", defaultMinimum=");
		sb.append(defaultMinimum);
		sb.append(", minimum=");
		sb.append(minimum);
		sb.append(", defaultNormal=");
		sb.append(defaultNormal);
		sb.append(", normal=");
		sb.append(normal);
		sb.append(", defaultMaximum=");
		sb.append(defaultMaximum);
		sb.append(", maximum=");
		sb.append(maximum);
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
	public HealthSmeFacility toEntityModel() {
		HealthSmeFacilityImpl healthSmeFacilityImpl =
			new HealthSmeFacilityImpl();

		healthSmeFacilityImpl.setHealthSmeFacilityId(healthSmeFacilityId);

		if (name == null) {
			healthSmeFacilityImpl.setName("");
		}
		else {
			healthSmeFacilityImpl.setName(name);
		}

		if (description == null) {
			healthSmeFacilityImpl.setDescription("");
		}
		else {
			healthSmeFacilityImpl.setDescription(description);
		}

		healthSmeFacilityImpl.setHealthSmeTypeId(healthSmeTypeId);
		healthSmeFacilityImpl.setDefaultMinimum(defaultMinimum);
		healthSmeFacilityImpl.setMinimum(minimum);
		healthSmeFacilityImpl.setDefaultNormal(defaultNormal);
		healthSmeFacilityImpl.setNormal(normal);
		healthSmeFacilityImpl.setDefaultMaximum(defaultMaximum);
		healthSmeFacilityImpl.setMaximum(maximum);
		healthSmeFacilityImpl.setActive(active);
		healthSmeFacilityImpl.setGroupId(groupId);
		healthSmeFacilityImpl.setCompanyId(companyId);
		healthSmeFacilityImpl.setUserId(userId);

		if (userName == null) {
			healthSmeFacilityImpl.setUserName("");
		}
		else {
			healthSmeFacilityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			healthSmeFacilityImpl.setCreateDate(null);
		}
		else {
			healthSmeFacilityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			healthSmeFacilityImpl.setModifiedDate(null);
		}
		else {
			healthSmeFacilityImpl.setModifiedDate(new Date(modifiedDate));
		}

		healthSmeFacilityImpl.resetOriginalValues();

		return healthSmeFacilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		healthSmeFacilityId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		healthSmeTypeId = objectInput.readLong();

		defaultMinimum = objectInput.readInt();

		minimum = objectInput.readDouble();

		defaultNormal = objectInput.readInt();

		normal = objectInput.readDouble();

		defaultMaximum = objectInput.readInt();

		maximum = objectInput.readDouble();

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
		objectOutput.writeLong(healthSmeFacilityId);

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

		objectOutput.writeLong(healthSmeTypeId);

		objectOutput.writeInt(defaultMinimum);

		objectOutput.writeDouble(minimum);

		objectOutput.writeInt(defaultNormal);

		objectOutput.writeDouble(normal);

		objectOutput.writeInt(defaultMaximum);

		objectOutput.writeDouble(maximum);

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

	public long healthSmeFacilityId;
	public String name;
	public String description;
	public long healthSmeTypeId;
	public int defaultMinimum;
	public double minimum;
	public int defaultNormal;
	public double normal;
	public int defaultMaximum;
	public double maximum;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}