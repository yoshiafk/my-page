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

import com.mypage.agencyportal.model.AgentFAQ;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentFAQ in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentFAQCacheModel
	implements CacheModel<AgentFAQ>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentFAQCacheModel)) {
			return false;
		}

		AgentFAQCacheModel agentFAQCacheModel = (AgentFAQCacheModel)object;

		if (agentFaqId == agentFAQCacheModel.agentFaqId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentFaqId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{agentFaqId=");
		sb.append(agentFaqId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", categoryId=");
		sb.append(categoryId);
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
	public AgentFAQ toEntityModel() {
		AgentFAQImpl agentFAQImpl = new AgentFAQImpl();

		agentFAQImpl.setAgentFaqId(agentFaqId);

		if (title == null) {
			agentFAQImpl.setTitle("");
		}
		else {
			agentFAQImpl.setTitle(title);
		}

		if (description == null) {
			agentFAQImpl.setDescription("");
		}
		else {
			agentFAQImpl.setDescription(description);
		}

		agentFAQImpl.setCategoryId(categoryId);

		if (category == null) {
			agentFAQImpl.setCategory("");
		}
		else {
			agentFAQImpl.setCategory(category);
		}

		agentFAQImpl.setActive(active);
		agentFAQImpl.setGroupId(groupId);
		agentFAQImpl.setCompanyId(companyId);
		agentFAQImpl.setUserId(userId);

		if (userName == null) {
			agentFAQImpl.setUserName("");
		}
		else {
			agentFAQImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentFAQImpl.setCreateDate(null);
		}
		else {
			agentFAQImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentFAQImpl.setModifiedDate(null);
		}
		else {
			agentFAQImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentFAQImpl.resetOriginalValues();

		return agentFAQImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentFaqId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		categoryId = objectInput.readLong();
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
		objectOutput.writeLong(agentFaqId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(categoryId);

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

	public long agentFaqId;
	public String title;
	public String description;
	public long categoryId;
	public String category;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}