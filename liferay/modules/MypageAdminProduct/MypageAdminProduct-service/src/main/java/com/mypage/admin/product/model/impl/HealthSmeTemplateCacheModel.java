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

import com.mypage.admin.product.model.HealthSmeTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HealthSmeTemplate in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class HealthSmeTemplateCacheModel
	implements CacheModel<HealthSmeTemplate>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HealthSmeTemplateCacheModel)) {
			return false;
		}

		HealthSmeTemplateCacheModel healthSmeTemplateCacheModel =
			(HealthSmeTemplateCacheModel)object;

		if (healthSmeTemplateId ==
				healthSmeTemplateCacheModel.healthSmeTemplateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, healthSmeTemplateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{healthSmeTemplateId=");
		sb.append(healthSmeTemplateId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", annualLimit=");
		sb.append(annualLimit);
		sb.append(", healthSmeTypeId=");
		sb.append(healthSmeTypeId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HealthSmeTemplate toEntityModel() {
		HealthSmeTemplateImpl healthSmeTemplateImpl =
			new HealthSmeTemplateImpl();

		healthSmeTemplateImpl.setHealthSmeTemplateId(healthSmeTemplateId);
		healthSmeTemplateImpl.setGroupId(groupId);
		healthSmeTemplateImpl.setCompanyId(companyId);
		healthSmeTemplateImpl.setUserId(userId);

		if (userName == null) {
			healthSmeTemplateImpl.setUserName("");
		}
		else {
			healthSmeTemplateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			healthSmeTemplateImpl.setCreateDate(null);
		}
		else {
			healthSmeTemplateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			healthSmeTemplateImpl.setModifiedDate(null);
		}
		else {
			healthSmeTemplateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			healthSmeTemplateImpl.setName("");
		}
		else {
			healthSmeTemplateImpl.setName(name);
		}

		if (code == null) {
			healthSmeTemplateImpl.setCode("");
		}
		else {
			healthSmeTemplateImpl.setCode(code);
		}

		if (description == null) {
			healthSmeTemplateImpl.setDescription("");
		}
		else {
			healthSmeTemplateImpl.setDescription(description);
		}

		healthSmeTemplateImpl.setAmount(amount);
		healthSmeTemplateImpl.setAnnualLimit(annualLimit);
		healthSmeTemplateImpl.setHealthSmeTypeId(healthSmeTypeId);
		healthSmeTemplateImpl.setActive(active);

		healthSmeTemplateImpl.resetOriginalValues();

		return healthSmeTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		healthSmeTemplateId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();
		description = objectInput.readUTF();

		amount = objectInput.readLong();

		annualLimit = objectInput.readLong();

		healthSmeTypeId = objectInput.readLong();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(healthSmeTemplateId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(amount);

		objectOutput.writeLong(annualLimit);

		objectOutput.writeLong(healthSmeTypeId);

		objectOutput.writeInt(active);
	}

	public long healthSmeTemplateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
	public String description;
	public long amount;
	public long annualLimit;
	public long healthSmeTypeId;
	public int active;

}