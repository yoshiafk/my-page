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

package com.mypage.agencyportal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.agencyportal.model.AgentFAQCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentFAQCategory in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentFAQCategoryCacheModel
	implements CacheModel<AgentFAQCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentFAQCategoryCacheModel)) {
			return false;
		}

		AgentFAQCategoryCacheModel agentFAQCategoryCacheModel =
			(AgentFAQCategoryCacheModel)object;

		if (agentFaqCategoryId ==
				agentFAQCategoryCacheModel.agentFaqCategoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentFaqCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{agentFaqCategoryId=");
		sb.append(agentFaqCategoryId);
		sb.append(", category=");
		sb.append(category);
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
	public AgentFAQCategory toEntityModel() {
		AgentFAQCategoryImpl agentFAQCategoryImpl = new AgentFAQCategoryImpl();

		agentFAQCategoryImpl.setAgentFaqCategoryId(agentFaqCategoryId);

		if (category == null) {
			agentFAQCategoryImpl.setCategory("");
		}
		else {
			agentFAQCategoryImpl.setCategory(category);
		}

		agentFAQCategoryImpl.setActive(active);
		agentFAQCategoryImpl.setGroupId(groupId);
		agentFAQCategoryImpl.setCompanyId(companyId);
		agentFAQCategoryImpl.setUserId(userId);

		if (userName == null) {
			agentFAQCategoryImpl.setUserName("");
		}
		else {
			agentFAQCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentFAQCategoryImpl.setCreateDate(null);
		}
		else {
			agentFAQCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentFAQCategoryImpl.setModifiedDate(null);
		}
		else {
			agentFAQCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentFAQCategoryImpl.resetOriginalValues();

		return agentFAQCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentFaqCategoryId = objectInput.readLong();
		category = objectInput.readUTF();

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
		objectOutput.writeLong(agentFaqCategoryId);

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
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

	public long agentFaqCategoryId;
	public String category;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}