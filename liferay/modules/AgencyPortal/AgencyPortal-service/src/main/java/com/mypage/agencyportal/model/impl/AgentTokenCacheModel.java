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

import com.mypage.agencyportal.model.AgentToken;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentToken in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentTokenCacheModel
	implements CacheModel<AgentToken>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentTokenCacheModel)) {
			return false;
		}

		AgentTokenCacheModel agentTokenCacheModel =
			(AgentTokenCacheModel)object;

		if (agentTokenId == agentTokenCacheModel.agentTokenId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentTokenId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{agentTokenId=");
		sb.append(agentTokenId);
		sb.append(", deptCode=");
		sb.append(deptCode);
		sb.append(", token=");
		sb.append(token);
		sb.append(", isValid=");
		sb.append(isValid);
		sb.append(", apiRequestToken=");
		sb.append(apiRequestToken);
		sb.append(", apiRequestTokenExpired=");
		sb.append(apiRequestTokenExpired);
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
	public AgentToken toEntityModel() {
		AgentTokenImpl agentTokenImpl = new AgentTokenImpl();

		agentTokenImpl.setAgentTokenId(agentTokenId);

		if (deptCode == null) {
			agentTokenImpl.setDeptCode("");
		}
		else {
			agentTokenImpl.setDeptCode(deptCode);
		}

		if (token == null) {
			agentTokenImpl.setToken("");
		}
		else {
			agentTokenImpl.setToken(token);
		}

		agentTokenImpl.setIsValid(isValid);

		if (apiRequestToken == null) {
			agentTokenImpl.setApiRequestToken("");
		}
		else {
			agentTokenImpl.setApiRequestToken(apiRequestToken);
		}

		if (apiRequestTokenExpired == Long.MIN_VALUE) {
			agentTokenImpl.setApiRequestTokenExpired(null);
		}
		else {
			agentTokenImpl.setApiRequestTokenExpired(
				new Date(apiRequestTokenExpired));
		}

		agentTokenImpl.setGroupId(groupId);
		agentTokenImpl.setCompanyId(companyId);
		agentTokenImpl.setUserId(userId);

		if (userName == null) {
			agentTokenImpl.setUserName("");
		}
		else {
			agentTokenImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentTokenImpl.setCreateDate(null);
		}
		else {
			agentTokenImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentTokenImpl.setModifiedDate(null);
		}
		else {
			agentTokenImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentTokenImpl.resetOriginalValues();

		return agentTokenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentTokenId = objectInput.readLong();
		deptCode = objectInput.readUTF();
		token = objectInput.readUTF();

		isValid = objectInput.readInt();
		apiRequestToken = objectInput.readUTF();
		apiRequestTokenExpired = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(agentTokenId);

		if (deptCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deptCode);
		}

		if (token == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(token);
		}

		objectOutput.writeInt(isValid);

		if (apiRequestToken == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(apiRequestToken);
		}

		objectOutput.writeLong(apiRequestTokenExpired);

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

	public long agentTokenId;
	public String deptCode;
	public String token;
	public int isValid;
	public String apiRequestToken;
	public long apiRequestTokenExpired;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}