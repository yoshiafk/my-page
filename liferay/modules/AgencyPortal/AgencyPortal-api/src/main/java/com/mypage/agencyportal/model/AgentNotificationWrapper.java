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

package com.mypage.agencyportal.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AgentNotification}.
 * </p>
 *
 * @author Gositus Team
 * @see AgentNotification
 * @generated
 */
public class AgentNotificationWrapper
	extends BaseModelWrapper<AgentNotification>
	implements AgentNotification, ModelWrapper<AgentNotification> {

	public AgentNotificationWrapper(AgentNotification agentNotification) {
		super(agentNotification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agentNotificationId", getAgentNotificationId());
		attributes.put("title", getTitle());
		attributes.put("location", getLocation());
		attributes.put("address", getAddress());
		attributes.put("startDate", getStartDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endDate", getEndDate());
		attributes.put("endTime", getEndTime());
		attributes.put("mypageUserRoleId", getMypageUserRoleId());
		attributes.put("role", getRole());
		attributes.put("mypageUserGroupId", getMypageUserGroupId());
		attributes.put("group", getGroup());
		attributes.put("referenceId", getReferenceId());
		attributes.put("description", getDescription());
		attributes.put("link", getLink());
		attributes.put("category", getCategory());
		attributes.put("fileUploadEntryId", getFileUploadEntryId());
		attributes.put("fileUploadUrl", getFileUploadUrl());
		attributes.put("isAllDay", getIsAllDay());
		attributes.put("isRead", getIsRead());
		attributes.put("active", getActive());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long agentNotificationId = (Long)attributes.get("agentNotificationId");

		if (agentNotificationId != null) {
			setAgentNotificationId(agentNotificationId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long mypageUserRoleId = (Long)attributes.get("mypageUserRoleId");

		if (mypageUserRoleId != null) {
			setMypageUserRoleId(mypageUserRoleId);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Long mypageUserGroupId = (Long)attributes.get("mypageUserGroupId");

		if (mypageUserGroupId != null) {
			setMypageUserGroupId(mypageUserGroupId);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		Long referenceId = (Long)attributes.get("referenceId");

		if (referenceId != null) {
			setReferenceId(referenceId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long fileUploadEntryId = (Long)attributes.get("fileUploadEntryId");

		if (fileUploadEntryId != null) {
			setFileUploadEntryId(fileUploadEntryId);
		}

		String fileUploadUrl = (String)attributes.get("fileUploadUrl");

		if (fileUploadUrl != null) {
			setFileUploadUrl(fileUploadUrl);
		}

		Integer isAllDay = (Integer)attributes.get("isAllDay");

		if (isAllDay != null) {
			setIsAllDay(isAllDay);
		}

		Integer isRead = (Integer)attributes.get("isRead");

		if (isRead != null) {
			setIsRead(isRead);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the active of this agent notification.
	 *
	 * @return the active of this agent notification
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the address of this agent notification.
	 *
	 * @return the address of this agent notification
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the agent notification ID of this agent notification.
	 *
	 * @return the agent notification ID of this agent notification
	 */
	@Override
	public long getAgentNotificationId() {
		return model.getAgentNotificationId();
	}

	/**
	 * Returns the category of this agent notification.
	 *
	 * @return the category of this agent notification
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the company ID of this agent notification.
	 *
	 * @return the company ID of this agent notification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this agent notification.
	 *
	 * @return the create date of this agent notification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this agent notification.
	 *
	 * @return the description of this agent notification
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this agent notification.
	 *
	 * @return the end date of this agent notification
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the end time of this agent notification.
	 *
	 * @return the end time of this agent notification
	 */
	@Override
	public String getEndTime() {
		return model.getEndTime();
	}

	/**
	 * Returns the file upload entry ID of this agent notification.
	 *
	 * @return the file upload entry ID of this agent notification
	 */
	@Override
	public long getFileUploadEntryId() {
		return model.getFileUploadEntryId();
	}

	/**
	 * Returns the file upload url of this agent notification.
	 *
	 * @return the file upload url of this agent notification
	 */
	@Override
	public String getFileUploadUrl() {
		return model.getFileUploadUrl();
	}

	/**
	 * Returns the group of this agent notification.
	 *
	 * @return the group of this agent notification
	 */
	@Override
	public String getGroup() {
		return model.getGroup();
	}

	/**
	 * Returns the group ID of this agent notification.
	 *
	 * @return the group ID of this agent notification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is all day of this agent notification.
	 *
	 * @return the is all day of this agent notification
	 */
	@Override
	public int getIsAllDay() {
		return model.getIsAllDay();
	}

	/**
	 * Returns the is read of this agent notification.
	 *
	 * @return the is read of this agent notification
	 */
	@Override
	public int getIsRead() {
		return model.getIsRead();
	}

	/**
	 * Returns the link of this agent notification.
	 *
	 * @return the link of this agent notification
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the location of this agent notification.
	 *
	 * @return the location of this agent notification
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this agent notification.
	 *
	 * @return the modified date of this agent notification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user group ID of this agent notification.
	 *
	 * @return the mypage user group ID of this agent notification
	 */
	@Override
	public long getMypageUserGroupId() {
		return model.getMypageUserGroupId();
	}

	/**
	 * Returns the mypage user ID of this agent notification.
	 *
	 * @return the mypage user ID of this agent notification
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user role ID of this agent notification.
	 *
	 * @return the mypage user role ID of this agent notification
	 */
	@Override
	public long getMypageUserRoleId() {
		return model.getMypageUserRoleId();
	}

	/**
	 * Returns the mypage user uuid of this agent notification.
	 *
	 * @return the mypage user uuid of this agent notification
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the primary key of this agent notification.
	 *
	 * @return the primary key of this agent notification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference ID of this agent notification.
	 *
	 * @return the reference ID of this agent notification
	 */
	@Override
	public long getReferenceId() {
		return model.getReferenceId();
	}

	/**
	 * Returns the role of this agent notification.
	 *
	 * @return the role of this agent notification
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the start date of this agent notification.
	 *
	 * @return the start date of this agent notification
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the start time of this agent notification.
	 *
	 * @return the start time of this agent notification
	 */
	@Override
	public String getStartTime() {
		return model.getStartTime();
	}

	/**
	 * Returns the status of this agent notification.
	 *
	 * @return the status of this agent notification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this agent notification.
	 *
	 * @return the title of this agent notification
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the trash entry created when this agent notification was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this agent notification.
	 *
	 * @return the trash entry created when this agent notification was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this agent notification.
	 *
	 * @return the class primary key of the trash entry for this agent notification
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this agent notification.
	 *
	 * @return the trash handler for this agent notification
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this agent notification.
	 *
	 * @return the user ID of this agent notification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agent notification.
	 *
	 * @return the user name of this agent notification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agent notification.
	 *
	 * @return the user uuid of this agent notification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this agent notification is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this agent notification is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this agent notification is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this agent notification is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this agent notification.
	 *
	 * @param active the active of this agent notification
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the address of this agent notification.
	 *
	 * @param address the address of this agent notification
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the agent notification ID of this agent notification.
	 *
	 * @param agentNotificationId the agent notification ID of this agent notification
	 */
	@Override
	public void setAgentNotificationId(long agentNotificationId) {
		model.setAgentNotificationId(agentNotificationId);
	}

	/**
	 * Sets the category of this agent notification.
	 *
	 * @param category the category of this agent notification
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the company ID of this agent notification.
	 *
	 * @param companyId the company ID of this agent notification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this agent notification.
	 *
	 * @param createDate the create date of this agent notification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this agent notification.
	 *
	 * @param description the description of this agent notification
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this agent notification.
	 *
	 * @param endDate the end date of this agent notification
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the end time of this agent notification.
	 *
	 * @param endTime the end time of this agent notification
	 */
	@Override
	public void setEndTime(String endTime) {
		model.setEndTime(endTime);
	}

	/**
	 * Sets the file upload entry ID of this agent notification.
	 *
	 * @param fileUploadEntryId the file upload entry ID of this agent notification
	 */
	@Override
	public void setFileUploadEntryId(long fileUploadEntryId) {
		model.setFileUploadEntryId(fileUploadEntryId);
	}

	/**
	 * Sets the file upload url of this agent notification.
	 *
	 * @param fileUploadUrl the file upload url of this agent notification
	 */
	@Override
	public void setFileUploadUrl(String fileUploadUrl) {
		model.setFileUploadUrl(fileUploadUrl);
	}

	/**
	 * Sets the group of this agent notification.
	 *
	 * @param group the group of this agent notification
	 */
	@Override
	public void setGroup(String group) {
		model.setGroup(group);
	}

	/**
	 * Sets the group ID of this agent notification.
	 *
	 * @param groupId the group ID of this agent notification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is all day of this agent notification.
	 *
	 * @param isAllDay the is all day of this agent notification
	 */
	@Override
	public void setIsAllDay(int isAllDay) {
		model.setIsAllDay(isAllDay);
	}

	/**
	 * Sets the is read of this agent notification.
	 *
	 * @param isRead the is read of this agent notification
	 */
	@Override
	public void setIsRead(int isRead) {
		model.setIsRead(isRead);
	}

	/**
	 * Sets the link of this agent notification.
	 *
	 * @param link the link of this agent notification
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the location of this agent notification.
	 *
	 * @param location the location of this agent notification
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this agent notification.
	 *
	 * @param modifiedDate the modified date of this agent notification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user group ID of this agent notification.
	 *
	 * @param mypageUserGroupId the mypage user group ID of this agent notification
	 */
	@Override
	public void setMypageUserGroupId(long mypageUserGroupId) {
		model.setMypageUserGroupId(mypageUserGroupId);
	}

	/**
	 * Sets the mypage user ID of this agent notification.
	 *
	 * @param mypageUserId the mypage user ID of this agent notification
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user role ID of this agent notification.
	 *
	 * @param mypageUserRoleId the mypage user role ID of this agent notification
	 */
	@Override
	public void setMypageUserRoleId(long mypageUserRoleId) {
		model.setMypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Sets the mypage user uuid of this agent notification.
	 *
	 * @param mypageUserUuid the mypage user uuid of this agent notification
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the primary key of this agent notification.
	 *
	 * @param primaryKey the primary key of this agent notification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference ID of this agent notification.
	 *
	 * @param referenceId the reference ID of this agent notification
	 */
	@Override
	public void setReferenceId(long referenceId) {
		model.setReferenceId(referenceId);
	}

	/**
	 * Sets the role of this agent notification.
	 *
	 * @param role the role of this agent notification
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the start date of this agent notification.
	 *
	 * @param startDate the start date of this agent notification
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the start time of this agent notification.
	 *
	 * @param startTime the start time of this agent notification
	 */
	@Override
	public void setStartTime(String startTime) {
		model.setStartTime(startTime);
	}

	/**
	 * Sets the title of this agent notification.
	 *
	 * @param title the title of this agent notification
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this agent notification.
	 *
	 * @param userId the user ID of this agent notification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agent notification.
	 *
	 * @param userName the user name of this agent notification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agent notification.
	 *
	 * @param userUuid the user uuid of this agent notification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AgentNotificationWrapper wrap(
		AgentNotification agentNotification) {

		return new AgentNotificationWrapper(agentNotification);
	}

}