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

import com.mypage.admin.product.model.HealthIndividuPremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HealthIndividuPremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class HealthIndividuPremiCacheModel
	implements CacheModel<HealthIndividuPremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HealthIndividuPremiCacheModel)) {
			return false;
		}

		HealthIndividuPremiCacheModel healthIndividuPremiCacheModel =
			(HealthIndividuPremiCacheModel)object;

		if (healthIndividuPremiId ==
				healthIndividuPremiCacheModel.healthIndividuPremiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, healthIndividuPremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{healthIndividuPremiId=");
		sb.append(healthIndividuPremiId);
		sb.append(", planId=");
		sb.append(planId);
		sb.append(", age=");
		sb.append(age);
		sb.append(", premi=");
		sb.append(premi);
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
	public HealthIndividuPremi toEntityModel() {
		HealthIndividuPremiImpl healthIndividuPremiImpl =
			new HealthIndividuPremiImpl();

		healthIndividuPremiImpl.setHealthIndividuPremiId(healthIndividuPremiId);
		healthIndividuPremiImpl.setPlanId(planId);
		healthIndividuPremiImpl.setAge(age);
		healthIndividuPremiImpl.setPremi(premi);
		healthIndividuPremiImpl.setActive(active);
		healthIndividuPremiImpl.setGroupId(groupId);
		healthIndividuPremiImpl.setCompanyId(companyId);
		healthIndividuPremiImpl.setUserId(userId);

		if (userName == null) {
			healthIndividuPremiImpl.setUserName("");
		}
		else {
			healthIndividuPremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			healthIndividuPremiImpl.setCreateDate(null);
		}
		else {
			healthIndividuPremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			healthIndividuPremiImpl.setModifiedDate(null);
		}
		else {
			healthIndividuPremiImpl.setModifiedDate(new Date(modifiedDate));
		}

		healthIndividuPremiImpl.resetOriginalValues();

		return healthIndividuPremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		healthIndividuPremiId = objectInput.readLong();

		planId = objectInput.readLong();

		age = objectInput.readInt();

		premi = objectInput.readLong();

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
		objectOutput.writeLong(healthIndividuPremiId);

		objectOutput.writeLong(planId);

		objectOutput.writeInt(age);

		objectOutput.writeLong(premi);

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

	public long healthIndividuPremiId;
	public long planId;
	public int age;
	public long premi;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}