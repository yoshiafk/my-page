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
 * This class is a wrapper for {@link AgentMarkCalendar}.
 * </p>
 *
 * @author Gositus Team
 * @see AgentMarkCalendar
 * @generated
 */
public class AgentMarkCalendarWrapper
	extends BaseModelWrapper<AgentMarkCalendar>
	implements AgentMarkCalendar, ModelWrapper<AgentMarkCalendar> {

	public AgentMarkCalendarWrapper(AgentMarkCalendar agentMarkCalendar) {
		super(agentMarkCalendar);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agentMarkCalendarId", getAgentMarkCalendarId());
		attributes.put("agentCalendarId", getAgentCalendarId());
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
		Long agentMarkCalendarId = (Long)attributes.get("agentMarkCalendarId");

		if (agentMarkCalendarId != null) {
			setAgentMarkCalendarId(agentMarkCalendarId);
		}

		Long agentCalendarId = (Long)attributes.get("agentCalendarId");

		if (agentCalendarId != null) {
			setAgentCalendarId(agentCalendarId);
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
	 * Returns the agent calendar ID of this agent mark calendar.
	 *
	 * @return the agent calendar ID of this agent mark calendar
	 */
	@Override
	public long getAgentCalendarId() {
		return model.getAgentCalendarId();
	}

	/**
	 * Returns the agent mark calendar ID of this agent mark calendar.
	 *
	 * @return the agent mark calendar ID of this agent mark calendar
	 */
	@Override
	public long getAgentMarkCalendarId() {
		return model.getAgentMarkCalendarId();
	}

	/**
	 * Returns the company ID of this agent mark calendar.
	 *
	 * @return the company ID of this agent mark calendar
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this agent mark calendar.
	 *
	 * @return the create date of this agent mark calendar
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this agent mark calendar.
	 *
	 * @return the group ID of this agent mark calendar
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this agent mark calendar.
	 *
	 * @return the modified date of this agent mark calendar
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this agent mark calendar.
	 *
	 * @return the mypage user ID of this agent mark calendar
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this agent mark calendar.
	 *
	 * @return the mypage user uuid of this agent mark calendar
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the primary key of this agent mark calendar.
	 *
	 * @return the primary key of this agent mark calendar
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this agent mark calendar.
	 *
	 * @return the status of this agent mark calendar
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this agent mark calendar was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this agent mark calendar.
	 *
	 * @return the trash entry created when this agent mark calendar was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this agent mark calendar.
	 *
	 * @return the class primary key of the trash entry for this agent mark calendar
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this agent mark calendar.
	 *
	 * @return the trash handler for this agent mark calendar
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this agent mark calendar.
	 *
	 * @return the user ID of this agent mark calendar
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agent mark calendar.
	 *
	 * @return the user name of this agent mark calendar
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agent mark calendar.
	 *
	 * @return the user uuid of this agent mark calendar
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this agent mark calendar is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this agent mark calendar is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this agent mark calendar is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this agent mark calendar is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the agent calendar ID of this agent mark calendar.
	 *
	 * @param agentCalendarId the agent calendar ID of this agent mark calendar
	 */
	@Override
	public void setAgentCalendarId(long agentCalendarId) {
		model.setAgentCalendarId(agentCalendarId);
	}

	/**
	 * Sets the agent mark calendar ID of this agent mark calendar.
	 *
	 * @param agentMarkCalendarId the agent mark calendar ID of this agent mark calendar
	 */
	@Override
	public void setAgentMarkCalendarId(long agentMarkCalendarId) {
		model.setAgentMarkCalendarId(agentMarkCalendarId);
	}

	/**
	 * Sets the company ID of this agent mark calendar.
	 *
	 * @param companyId the company ID of this agent mark calendar
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this agent mark calendar.
	 *
	 * @param createDate the create date of this agent mark calendar
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this agent mark calendar.
	 *
	 * @param groupId the group ID of this agent mark calendar
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this agent mark calendar.
	 *
	 * @param modifiedDate the modified date of this agent mark calendar
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this agent mark calendar.
	 *
	 * @param mypageUserId the mypage user ID of this agent mark calendar
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this agent mark calendar.
	 *
	 * @param mypageUserUuid the mypage user uuid of this agent mark calendar
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the primary key of this agent mark calendar.
	 *
	 * @param primaryKey the primary key of this agent mark calendar
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this agent mark calendar.
	 *
	 * @param userId the user ID of this agent mark calendar
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agent mark calendar.
	 *
	 * @param userName the user name of this agent mark calendar
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agent mark calendar.
	 *
	 * @param userUuid the user uuid of this agent mark calendar
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AgentMarkCalendarWrapper wrap(
		AgentMarkCalendar agentMarkCalendar) {

		return new AgentMarkCalendarWrapper(agentMarkCalendar);
	}

}