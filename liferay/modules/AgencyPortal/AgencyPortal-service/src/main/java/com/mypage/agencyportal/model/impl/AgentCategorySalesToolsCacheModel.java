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

import com.mypage.agencyportal.model.AgentCategorySalesTools;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentCategorySalesTools in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentCategorySalesToolsCacheModel
	implements CacheModel<AgentCategorySalesTools>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentCategorySalesToolsCacheModel)) {
			return false;
		}

		AgentCategorySalesToolsCacheModel agentCategorySalesToolsCacheModel =
			(AgentCategorySalesToolsCacheModel)object;

		if (agentCategorySalesToolsId ==
				agentCategorySalesToolsCacheModel.agentCategorySalesToolsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentCategorySalesToolsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{agentCategorySalesToolsId=");
		sb.append(agentCategorySalesToolsId);
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
	public AgentCategorySalesTools toEntityModel() {
		AgentCategorySalesToolsImpl agentCategorySalesToolsImpl =
			new AgentCategorySalesToolsImpl();

		agentCategorySalesToolsImpl.setAgentCategorySalesToolsId(
			agentCategorySalesToolsId);

		if (category == null) {
			agentCategorySalesToolsImpl.setCategory("");
		}
		else {
			agentCategorySalesToolsImpl.setCategory(category);
		}

		agentCategorySalesToolsImpl.setActive(active);
		agentCategorySalesToolsImpl.setGroupId(groupId);
		agentCategorySalesToolsImpl.setCompanyId(companyId);
		agentCategorySalesToolsImpl.setUserId(userId);

		if (userName == null) {
			agentCategorySalesToolsImpl.setUserName("");
		}
		else {
			agentCategorySalesToolsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentCategorySalesToolsImpl.setCreateDate(null);
		}
		else {
			agentCategorySalesToolsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentCategorySalesToolsImpl.setModifiedDate(null);
		}
		else {
			agentCategorySalesToolsImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentCategorySalesToolsImpl.resetOriginalValues();

		return agentCategorySalesToolsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentCategorySalesToolsId = objectInput.readLong();
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
		objectOutput.writeLong(agentCategorySalesToolsId);

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

	public long agentCategorySalesToolsId;
	public String category;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}