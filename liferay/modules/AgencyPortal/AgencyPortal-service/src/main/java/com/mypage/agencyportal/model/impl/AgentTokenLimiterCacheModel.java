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

import com.mypage.agencyportal.model.AgentTokenLimiter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentTokenLimiter in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentTokenLimiterCacheModel
	implements CacheModel<AgentTokenLimiter>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentTokenLimiterCacheModel)) {
			return false;
		}

		AgentTokenLimiterCacheModel agentTokenLimiterCacheModel =
			(AgentTokenLimiterCacheModel)object;

		if (agentTokenLimiterId ==
				agentTokenLimiterCacheModel.agentTokenLimiterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentTokenLimiterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{agentTokenLimiterId=");
		sb.append(agentTokenLimiterId);
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
		sb.append(", deptCode=");
		sb.append(deptCode);
		sb.append(", token=");
		sb.append(token);
		sb.append(", isValid=");
		sb.append(isValid);
		sb.append(", tokenType=");
		sb.append(tokenType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AgentTokenLimiter toEntityModel() {
		AgentTokenLimiterImpl agentTokenLimiterImpl =
			new AgentTokenLimiterImpl();

		agentTokenLimiterImpl.setAgentTokenLimiterId(agentTokenLimiterId);
		agentTokenLimiterImpl.setGroupId(groupId);
		agentTokenLimiterImpl.setCompanyId(companyId);
		agentTokenLimiterImpl.setUserId(userId);

		if (userName == null) {
			agentTokenLimiterImpl.setUserName("");
		}
		else {
			agentTokenLimiterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentTokenLimiterImpl.setCreateDate(null);
		}
		else {
			agentTokenLimiterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentTokenLimiterImpl.setModifiedDate(null);
		}
		else {
			agentTokenLimiterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (deptCode == null) {
			agentTokenLimiterImpl.setDeptCode("");
		}
		else {
			agentTokenLimiterImpl.setDeptCode(deptCode);
		}

		if (token == null) {
			agentTokenLimiterImpl.setToken("");
		}
		else {
			agentTokenLimiterImpl.setToken(token);
		}

		agentTokenLimiterImpl.setIsValid(isValid);

		if (tokenType == null) {
			agentTokenLimiterImpl.setTokenType("");
		}
		else {
			agentTokenLimiterImpl.setTokenType(tokenType);
		}

		agentTokenLimiterImpl.resetOriginalValues();

		return agentTokenLimiterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentTokenLimiterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		deptCode = objectInput.readUTF();
		token = objectInput.readUTF();

		isValid = objectInput.readInt();
		tokenType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(agentTokenLimiterId);

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

		if (tokenType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tokenType);
		}
	}

	public long agentTokenLimiterId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String deptCode;
	public String token;
	public int isValid;
	public String tokenType;

}