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

import com.mypage.agencyportal.model.AgentMarkCalendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentMarkCalendar in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentMarkCalendarCacheModel
	implements CacheModel<AgentMarkCalendar>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentMarkCalendarCacheModel)) {
			return false;
		}

		AgentMarkCalendarCacheModel agentMarkCalendarCacheModel =
			(AgentMarkCalendarCacheModel)object;

		if (agentMarkCalendarId ==
				agentMarkCalendarCacheModel.agentMarkCalendarId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentMarkCalendarId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{agentMarkCalendarId=");
		sb.append(agentMarkCalendarId);
		sb.append(", agentCalendarId=");
		sb.append(agentCalendarId);
		sb.append(", mypageUserId=");
		sb.append(mypageUserId);
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
	public AgentMarkCalendar toEntityModel() {
		AgentMarkCalendarImpl agentMarkCalendarImpl =
			new AgentMarkCalendarImpl();

		agentMarkCalendarImpl.setAgentMarkCalendarId(agentMarkCalendarId);
		agentMarkCalendarImpl.setAgentCalendarId(agentCalendarId);
		agentMarkCalendarImpl.setMypageUserId(mypageUserId);
		agentMarkCalendarImpl.setGroupId(groupId);
		agentMarkCalendarImpl.setCompanyId(companyId);
		agentMarkCalendarImpl.setUserId(userId);

		if (userName == null) {
			agentMarkCalendarImpl.setUserName("");
		}
		else {
			agentMarkCalendarImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentMarkCalendarImpl.setCreateDate(null);
		}
		else {
			agentMarkCalendarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentMarkCalendarImpl.setModifiedDate(null);
		}
		else {
			agentMarkCalendarImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentMarkCalendarImpl.resetOriginalValues();

		return agentMarkCalendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentMarkCalendarId = objectInput.readLong();

		agentCalendarId = objectInput.readLong();

		mypageUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(agentMarkCalendarId);

		objectOutput.writeLong(agentCalendarId);

		objectOutput.writeLong(mypageUserId);

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

	public long agentMarkCalendarId;
	public long agentCalendarId;
	public long mypageUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}