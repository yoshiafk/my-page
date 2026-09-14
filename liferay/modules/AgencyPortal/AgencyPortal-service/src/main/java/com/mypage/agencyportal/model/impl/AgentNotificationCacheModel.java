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

import com.mypage.agencyportal.model.AgentNotification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentNotification in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentNotificationCacheModel
	implements CacheModel<AgentNotification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentNotificationCacheModel)) {
			return false;
		}

		AgentNotificationCacheModel agentNotificationCacheModel =
			(AgentNotificationCacheModel)object;

		if (agentNotificationId ==
				agentNotificationCacheModel.agentNotificationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentNotificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{agentNotificationId=");
		sb.append(agentNotificationId);
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
		sb.append(", referenceId=");
		sb.append(referenceId);
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
		sb.append(", isRead=");
		sb.append(isRead);
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
	public AgentNotification toEntityModel() {
		AgentNotificationImpl agentNotificationImpl =
			new AgentNotificationImpl();

		agentNotificationImpl.setAgentNotificationId(agentNotificationId);

		if (title == null) {
			agentNotificationImpl.setTitle("");
		}
		else {
			agentNotificationImpl.setTitle(title);
		}

		if (location == null) {
			agentNotificationImpl.setLocation("");
		}
		else {
			agentNotificationImpl.setLocation(location);
		}

		if (address == null) {
			agentNotificationImpl.setAddress("");
		}
		else {
			agentNotificationImpl.setAddress(address);
		}

		if (startDate == Long.MIN_VALUE) {
			agentNotificationImpl.setStartDate(null);
		}
		else {
			agentNotificationImpl.setStartDate(new Date(startDate));
		}

		if (startTime == null) {
			agentNotificationImpl.setStartTime("");
		}
		else {
			agentNotificationImpl.setStartTime(startTime);
		}

		if (endDate == Long.MIN_VALUE) {
			agentNotificationImpl.setEndDate(null);
		}
		else {
			agentNotificationImpl.setEndDate(new Date(endDate));
		}

		if (endTime == null) {
			agentNotificationImpl.setEndTime("");
		}
		else {
			agentNotificationImpl.setEndTime(endTime);
		}

		agentNotificationImpl.setMypageUserRoleId(mypageUserRoleId);

		if (role == null) {
			agentNotificationImpl.setRole("");
		}
		else {
			agentNotificationImpl.setRole(role);
		}

		agentNotificationImpl.setMypageUserGroupId(mypageUserGroupId);

		if (group == null) {
			agentNotificationImpl.setGroup("");
		}
		else {
			agentNotificationImpl.setGroup(group);
		}

		agentNotificationImpl.setReferenceId(referenceId);

		if (description == null) {
			agentNotificationImpl.setDescription("");
		}
		else {
			agentNotificationImpl.setDescription(description);
		}

		if (link == null) {
			agentNotificationImpl.setLink("");
		}
		else {
			agentNotificationImpl.setLink(link);
		}

		if (category == null) {
			agentNotificationImpl.setCategory("");
		}
		else {
			agentNotificationImpl.setCategory(category);
		}

		agentNotificationImpl.setFileUploadEntryId(fileUploadEntryId);

		if (fileUploadUrl == null) {
			agentNotificationImpl.setFileUploadUrl("");
		}
		else {
			agentNotificationImpl.setFileUploadUrl(fileUploadUrl);
		}

		agentNotificationImpl.setIsAllDay(isAllDay);
		agentNotificationImpl.setIsRead(isRead);
		agentNotificationImpl.setActive(active);
		agentNotificationImpl.setMypageUserId(mypageUserId);
		agentNotificationImpl.setGroupId(groupId);
		agentNotificationImpl.setCompanyId(companyId);
		agentNotificationImpl.setUserId(userId);

		if (userName == null) {
			agentNotificationImpl.setUserName("");
		}
		else {
			agentNotificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentNotificationImpl.setCreateDate(null);
		}
		else {
			agentNotificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentNotificationImpl.setModifiedDate(null);
		}
		else {
			agentNotificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentNotificationImpl.resetOriginalValues();

		return agentNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentNotificationId = objectInput.readLong();
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

		referenceId = objectInput.readLong();
		description = objectInput.readUTF();
		link = objectInput.readUTF();
		category = objectInput.readUTF();

		fileUploadEntryId = objectInput.readLong();
		fileUploadUrl = objectInput.readUTF();

		isAllDay = objectInput.readInt();

		isRead = objectInput.readInt();

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
		objectOutput.writeLong(agentNotificationId);

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

		objectOutput.writeLong(referenceId);

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

		objectOutput.writeInt(isRead);

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

	public long agentNotificationId;
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
	public long referenceId;
	public String description;
	public String link;
	public String category;
	public long fileUploadEntryId;
	public String fileUploadUrl;
	public int isAllDay;
	public int isRead;
	public int active;
	public long mypageUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}