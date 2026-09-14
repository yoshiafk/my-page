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

import com.mypage.admin.product.model.JobPosition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobPosition in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class JobPositionCacheModel
	implements CacheModel<JobPosition>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobPositionCacheModel)) {
			return false;
		}

		JobPositionCacheModel jobPositionCacheModel =
			(JobPositionCacheModel)object;

		if (jobPositionId == jobPositionCacheModel.jobPositionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobPositionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{jobPositionId=");
		sb.append(jobPositionId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobPosition toEntityModel() {
		JobPositionImpl jobPositionImpl = new JobPositionImpl();

		jobPositionImpl.setJobPositionId(jobPositionId);
		jobPositionImpl.setGroupId(groupId);
		jobPositionImpl.setCompanyId(companyId);
		jobPositionImpl.setUserId(userId);

		if (userName == null) {
			jobPositionImpl.setUserName("");
		}
		else {
			jobPositionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			jobPositionImpl.setCreateDate(null);
		}
		else {
			jobPositionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobPositionImpl.setModifiedDate(null);
		}
		else {
			jobPositionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			jobPositionImpl.setName("");
		}
		else {
			jobPositionImpl.setName(name);
		}

		jobPositionImpl.setActive(active);

		jobPositionImpl.resetOriginalValues();

		return jobPositionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobPositionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(jobPositionId);

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

		objectOutput.writeInt(active);
	}

	public long jobPositionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public int active;

}