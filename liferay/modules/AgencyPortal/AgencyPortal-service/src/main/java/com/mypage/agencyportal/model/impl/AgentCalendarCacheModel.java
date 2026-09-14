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

import com.mypage.agencyportal.model.AgentCalendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentCalendar in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentCalendarCacheModel
	implements CacheModel<AgentCalendar>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentCalendarCacheModel)) {
			return false;
		}

		AgentCalendarCacheModel agentCalendarCacheModel =
			(AgentCalendarCacheModel)object;

		if (agentCalendarId == agentCalendarCacheModel.agentCalendarId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentCalendarId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{agentCalendarId=");
		sb.append(agentCalendarId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", location=");
		sb.append(location);
		sb.append(", address=");
		sb.append(address);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", mypageUserRoleId=");
		sb.append(mypageUserRoleId);
		sb.append(", role=");
		sb.append(role);
		sb.append(", mypageUserGroupId=");
		sb.append(mypageUserGroupId);
		sb.append(", group=");
		sb.append(group);
		sb.append(", description=");
		sb.append(description);
		sb.append(", link=");
		sb.append(link);
		sb.append(", category=");
		sb.append(category);
		sb.append(", fileUploadEntryId=");
		sb.append(fileUploadEntryId);
		sb.append(", fileUploadUrl=");
		sb.append(fileUploadUrl);
		sb.append(", isAllDay=");
		sb.append(isAllDay);
		sb.append(", active=");
		sb.append(active);
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
	public AgentCalendar toEntityModel() {
		AgentCalendarImpl agentCalendarImpl = new AgentCalendarImpl();

		agentCalendarImpl.setAgentCalendarId(agentCalendarId);

		if (title == null) {
			agentCalendarImpl.setTitle("");
		}
		else {
			agentCalendarImpl.setTitle(title);
		}

		if (location == null) {
			agentCalendarImpl.setLocation("");
		}
		else {
			agentCalendarImpl.setLocation(location);
		}

		if (address == null) {
			agentCalendarImpl.setAddress("");
		}
		else {
			agentCalendarImpl.setAddress(address);
		}

		if (startDate == Long.MIN_VALUE) {
			agentCalendarImpl.setStartDate(null);
		}
		else {
			agentCalendarImpl.setStartDate(new Date(startDate));
		}

		if (startTime == null) {
			agentCalendarImpl.setStartTime("");
		}
		else {
			agentCalendarImpl.setStartTime(startTime);
		}

		if (endDate == Long.MIN_VALUE) {
			agentCalendarImpl.setEndDate(null);
		}
		else {
			agentCalendarImpl.setEndDate(new Date(endDate));
		}

		if (endTime == null) {
			agentCalendarImpl.setEndTime("");
		}
		else {
			agentCalendarImpl.setEndTime(endTime);
		}

		agentCalendarImpl.setMypageUserRoleId(mypageUserRoleId);

		if (role == null) {
			agentCalendarImpl.setRole("");
		}
		else {
			agentCalendarImpl.setRole(role);
		}

		agentCalendarImpl.setMypageUserGroupId(mypageUserGroupId);

		if (group == null) {
			agentCalendarImpl.setGroup("");
		}
		else {
			agentCalendarImpl.setGroup(group);
		}

		if (description == null) {
			agentCalendarImpl.setDescription("");
		}
		else {
			agentCalendarImpl.setDescription(description);
		}

		if (link == null) {
			agentCalendarImpl.setLink("");
		}
		else {
			agentCalendarImpl.setLink(link);
		}

		if (category == null) {
			agentCalendarImpl.setCategory("");
		}
		else {
			agentCalendarImpl.setCategory(category);
		}

		agentCalendarImpl.setFileUploadEntryId(fileUploadEntryId);

		if (fileUploadUrl == null) {
			agentCalendarImpl.setFileUploadUrl("");
		}
		else {
			agentCalendarImpl.setFileUploadUrl(fileUploadUrl);
		}

		agentCalendarImpl.setIsAllDay(isAllDay);
		agentCalendarImpl.setActive(active);
		agentCalendarImpl.setMypageUserId(mypageUserId);
		agentCalendarImpl.setGroupId(groupId);
		agentCalendarImpl.setCompanyId(companyId);
		agentCalendarImpl.setUserId(userId);

		if (userName == null) {
			agentCalendarImpl.setUserName("");
		}
		else {
			agentCalendarImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentCalendarImpl.setCreateDate(null);
		}
		else {
			agentCalendarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentCalendarImpl.setModifiedDate(null);
		}
		else {
			agentCalendarImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentCalendarImpl.resetOriginalValues();

		return agentCalendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentCalendarId = objectInput.readLong();
		title = objectInput.readUTF();
		location = objectInput.readUTF();
		address = objectInput.readUTF();
		startDate = objectInput.readLong();
		startTime = objectInput.readUTF();
		endDate = objectInput.readLong();
		endTime = objectInput.readUTF();

		mypageUserRoleId = objectInput.readLong();
		role = objectInput.readUTF();

		mypageUserGroupId = objectInput.readLong();
		group = objectInput.readUTF();
		description = objectInput.readUTF();
		link = objectInput.readUTF();
		category = objectInput.readUTF();

		fileUploadEntryId = objectInput.readLong();
		fileUploadUrl = objectInput.readUTF();

		isAllDay = objectInput.readInt();

		active = objectInput.readInt();

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
		objectOutput.writeLong(agentCalendarId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(startDate);

		if (startTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startTime);
		}

		objectOutput.writeLong(endDate);

		if (endTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endTime);
		}

		objectOutput.writeLong(mypageUserRoleId);

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		objectOutput.writeLong(mypageUserGroupId);

		if (group == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(group);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

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

		objectOutput.writeInt(isAllDay);

		objectOutput.writeInt(active);

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

	public long agentCalendarId;
	public String title;
	public String location;
	public String address;
	public long startDate;
	public String startTime;
	public long endDate;
	public String endTime;
	public long mypageUserRoleId;
	public String role;
	public long mypageUserGroupId;
	public String group;
	public String description;
	public String link;
	public String category;
	public long fileUploadEntryId;
	public String fileUploadUrl;
	public int isAllDay;
	public int active;
	public long mypageUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}