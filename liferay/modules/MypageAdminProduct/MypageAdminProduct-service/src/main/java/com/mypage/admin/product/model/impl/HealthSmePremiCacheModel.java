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

import com.mypage.admin.product.model.HealthSmePremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HealthSmePremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class HealthSmePremiCacheModel
	implements CacheModel<HealthSmePremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HealthSmePremiCacheModel)) {
			return false;
		}

		HealthSmePremiCacheModel healthSmePremiCacheModel =
			(HealthSmePremiCacheModel)object;

		if (healthSmePremiId == healthSmePremiCacheModel.healthSmePremiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, healthSmePremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{healthSmePremiId=");
		sb.append(healthSmePremiId);
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
		sb.append(", premiType=");
		sb.append(premiType);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", healthSmeTemplateId=");
		sb.append(healthSmeTemplateId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HealthSmePremi toEntityModel() {
		HealthSmePremiImpl healthSmePremiImpl = new HealthSmePremiImpl();

		healthSmePremiImpl.setHealthSmePremiId(healthSmePremiId);
		healthSmePremiImpl.setGroupId(groupId);
		healthSmePremiImpl.setCompanyId(companyId);
		healthSmePremiImpl.setUserId(userId);

		if (userName == null) {
			healthSmePremiImpl.setUserName("");
		}
		else {
			healthSmePremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			healthSmePremiImpl.setCreateDate(null);
		}
		else {
			healthSmePremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			healthSmePremiImpl.setModifiedDate(null);
		}
		else {
			healthSmePremiImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			healthSmePremiImpl.setName("");
		}
		else {
			healthSmePremiImpl.setName(name);
		}

		if (premiType == null) {
			healthSmePremiImpl.setPremiType("");
		}
		else {
			healthSmePremiImpl.setPremiType(premiType);
		}

		healthSmePremiImpl.setAmount(amount);
		healthSmePremiImpl.setHealthSmeTemplateId(healthSmeTemplateId);
		healthSmePremiImpl.setActive(active);

		healthSmePremiImpl.resetOriginalValues();

		return healthSmePremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		healthSmePremiId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		premiType = objectInput.readUTF();

		amount = objectInput.readLong();

		healthSmeTemplateId = objectInput.readLong();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(healthSmePremiId);

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

		if (premiType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(premiType);
		}

		objectOutput.writeLong(amount);

		objectOutput.writeLong(healthSmeTemplateId);

		objectOutput.writeInt(active);
	}

	public long healthSmePremiId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String premiType;
	public long amount;
	public long healthSmeTemplateId;
	public int active;

}