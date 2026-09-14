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

import com.mypage.agencyportal.model.AgentSalesTools;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentSalesTools in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentSalesToolsCacheModel
	implements CacheModel<AgentSalesTools>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentSalesToolsCacheModel)) {
			return false;
		}

		AgentSalesToolsCacheModel agentSalesToolsCacheModel =
			(AgentSalesToolsCacheModel)object;

		if (agentSalesToolsId == agentSalesToolsCacheModel.agentSalesToolsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentSalesToolsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{agentSalesToolsId=");
		sb.append(agentSalesToolsId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", category=");
		sb.append(category);
		sb.append(", fileUploadEntryId=");
		sb.append(fileUploadEntryId);
		sb.append(", fileUploadUrl=");
		sb.append(fileUploadUrl);
		sb.append(", mypageUserRoleId=");
		sb.append(mypageUserRoleId);
		sb.append(", role=");
		sb.append(role);
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
	public AgentSalesTools toEntityModel() {
		AgentSalesToolsImpl agentSalesToolsImpl = new AgentSalesToolsImpl();

		agentSalesToolsImpl.setAgentSalesToolsId(agentSalesToolsId);

		if (title == null) {
			agentSalesToolsImpl.setTitle("");
		}
		else {
			agentSalesToolsImpl.setTitle(title);
		}

		if (description == null) {
			agentSalesToolsImpl.setDescription("");
		}
		else {
			agentSalesToolsImpl.setDescription(description);
		}

		agentSalesToolsImpl.setCategoryId(categoryId);

		if (category == null) {
			agentSalesToolsImpl.setCategory("");
		}
		else {
			agentSalesToolsImpl.setCategory(category);
		}

		agentSalesToolsImpl.setFileUploadEntryId(fileUploadEntryId);

		if (fileUploadUrl == null) {
			agentSalesToolsImpl.setFileUploadUrl("");
		}
		else {
			agentSalesToolsImpl.setFileUploadUrl(fileUploadUrl);
		}

		agentSalesToolsImpl.setMypageUserRoleId(mypageUserRoleId);

		if (role == null) {
			agentSalesToolsImpl.setRole("");
		}
		else {
			agentSalesToolsImpl.setRole(role);
		}

		agentSalesToolsImpl.setActive(active);
		agentSalesToolsImpl.setGroupId(groupId);
		agentSalesToolsImpl.setCompanyId(companyId);
		agentSalesToolsImpl.setUserId(userId);

		if (userName == null) {
			agentSalesToolsImpl.setUserName("");
		}
		else {
			agentSalesToolsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentSalesToolsImpl.setCreateDate(null);
		}
		else {
			agentSalesToolsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentSalesToolsImpl.setModifiedDate(null);
		}
		else {
			agentSalesToolsImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentSalesToolsImpl.resetOriginalValues();

		return agentSalesToolsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentSalesToolsId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		categoryId = objectInput.readLong();
		category = objectInput.readUTF();

		fileUploadEntryId = objectInput.readLong();
		fileUploadUrl = objectInput.readUTF();

		mypageUserRoleId = objectInput.readLong();
		role = objectInput.readUTF();

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
		objectOutput.writeLong(agentSalesToolsId);

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

		objectOutput.writeLong(fileUploadEntryId);

		if (fileUploadUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileUploadUrl);
		}

		objectOutput.writeLong(mypageUserRoleId);

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
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

	public long agentSalesToolsId;
	public String title;
	public String description;
	public long categoryId;
	public String category;
	public long fileUploadEntryId;
	public String fileUploadUrl;
	public long mypageUserRoleId;
	public String role;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}