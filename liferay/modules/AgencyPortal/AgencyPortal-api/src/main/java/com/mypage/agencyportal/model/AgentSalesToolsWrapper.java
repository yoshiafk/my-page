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
 * This class is a wrapper for {@link AgentSalesTools}.
 * </p>
 *
 * @author Gositus Team
 * @see AgentSalesTools
 * @generated
 */
public class AgentSalesToolsWrapper
	extends BaseModelWrapper<AgentSalesTools>
	implements AgentSalesTools, ModelWrapper<AgentSalesTools> {

	public AgentSalesToolsWrapper(AgentSalesTools agentSalesTools) {
		super(agentSalesTools);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agentSalesToolsId", getAgentSalesToolsId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("categoryId", getCategoryId());
		attributes.put("category", getCategory());
		attributes.put("fileUploadEntryId", getFileUploadEntryId());
		attributes.put("fileUploadUrl", getFileUploadUrl());
		attributes.put("mypageUserRoleId", getMypageUserRoleId());
		attributes.put("role", getRole());
		attributes.put("active", getActive());
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
		Long agentSalesToolsId = (Long)attributes.get("agentSalesToolsId");

		if (agentSalesToolsId != null) {
			setAgentSalesToolsId(agentSalesToolsId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		Long mypageUserRoleId = (Long)attributes.get("mypageUserRoleId");

		if (mypageUserRoleId != null) {
			setMypageUserRoleId(mypageUserRoleId);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	 * Returns the active of this agent sales tools.
	 *
	 * @return the active of this agent sales tools
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the agent sales tools ID of this agent sales tools.
	 *
	 * @return the agent sales tools ID of this agent sales tools
	 */
	@Override
	public long getAgentSalesToolsId() {
		return model.getAgentSalesToolsId();
	}

	/**
	 * Returns the category of this agent sales tools.
	 *
	 * @return the category of this agent sales tools
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the category ID of this agent sales tools.
	 *
	 * @return the category ID of this agent sales tools
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this agent sales tools.
	 *
	 * @return the company ID of this agent sales tools
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this agent sales tools.
	 *
	 * @return the create date of this agent sales tools
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this agent sales tools.
	 *
	 * @return the description of this agent sales tools
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the file upload entry ID of this agent sales tools.
	 *
	 * @return the file upload entry ID of this agent sales tools
	 */
	@Override
	public long getFileUploadEntryId() {
		return model.getFileUploadEntryId();
	}

	/**
	 * Returns the file upload url of this agent sales tools.
	 *
	 * @return the file upload url of this agent sales tools
	 */
	@Override
	public String getFileUploadUrl() {
		return model.getFileUploadUrl();
	}

	/**
	 * Returns the group ID of this agent sales tools.
	 *
	 * @return the group ID of this agent sales tools
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this agent sales tools.
	 *
	 * @return the modified date of this agent sales tools
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user role ID of this agent sales tools.
	 *
	 * @return the mypage user role ID of this agent sales tools
	 */
	@Override
	public long getMypageUserRoleId() {
		return model.getMypageUserRoleId();
	}

	/**
	 * Returns the primary key of this agent sales tools.
	 *
	 * @return the primary key of this agent sales tools
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this agent sales tools.
	 *
	 * @return the role of this agent sales tools
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the status of this agent sales tools.
	 *
	 * @return the status of this agent sales tools
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this agent sales tools.
	 *
	 * @return the title of this agent sales tools
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the trash entry created when this agent sales tools was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this agent sales tools.
	 *
	 * @return the trash entry created when this agent sales tools was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this agent sales tools.
	 *
	 * @return the class primary key of the trash entry for this agent sales tools
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this agent sales tools.
	 *
	 * @return the trash handler for this agent sales tools
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this agent sales tools.
	 *
	 * @return the user ID of this agent sales tools
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agent sales tools.
	 *
	 * @return the user name of this agent sales tools
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agent sales tools.
	 *
	 * @return the user uuid of this agent sales tools
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this agent sales tools is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this agent sales tools is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this agent sales tools is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this agent sales tools is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the active of this agent sales tools.
	 *
	 * @param active the active of this agent sales tools
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the agent sales tools ID of this agent sales tools.
	 *
	 * @param agentSalesToolsId the agent sales tools ID of this agent sales tools
	 */
	@Override
	public void setAgentSalesToolsId(long agentSalesToolsId) {
		model.setAgentSalesToolsId(agentSalesToolsId);
	}

	/**
	 * Sets the category of this agent sales tools.
	 *
	 * @param category the category of this agent sales tools
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the category ID of this agent sales tools.
	 *
	 * @param categoryId the category ID of this agent sales tools
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this agent sales tools.
	 *
	 * @param companyId the company ID of this agent sales tools
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this agent sales tools.
	 *
	 * @param createDate the create date of this agent sales tools
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this agent sales tools.
	 *
	 * @param description the description of this agent sales tools
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the file upload entry ID of this agent sales tools.
	 *
	 * @param fileUploadEntryId the file upload entry ID of this agent sales tools
	 */
	@Override
	public void setFileUploadEntryId(long fileUploadEntryId) {
		model.setFileUploadEntryId(fileUploadEntryId);
	}

	/**
	 * Sets the file upload url of this agent sales tools.
	 *
	 * @param fileUploadUrl the file upload url of this agent sales tools
	 */
	@Override
	public void setFileUploadUrl(String fileUploadUrl) {
		model.setFileUploadUrl(fileUploadUrl);
	}

	/**
	 * Sets the group ID of this agent sales tools.
	 *
	 * @param groupId the group ID of this agent sales tools
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this agent sales tools.
	 *
	 * @param modifiedDate the modified date of this agent sales tools
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user role ID of this agent sales tools.
	 *
	 * @param mypageUserRoleId the mypage user role ID of this agent sales tools
	 */
	@Override
	public void setMypageUserRoleId(long mypageUserRoleId) {
		model.setMypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Sets the primary key of this agent sales tools.
	 *
	 * @param primaryKey the primary key of this agent sales tools
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this agent sales tools.
	 *
	 * @param role the role of this agent sales tools
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the title of this agent sales tools.
	 *
	 * @param title the title of this agent sales tools
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this agent sales tools.
	 *
	 * @param userId the user ID of this agent sales tools
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agent sales tools.
	 *
	 * @param userName the user name of this agent sales tools
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agent sales tools.
	 *
	 * @param userUuid the user uuid of this agent sales tools
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AgentSalesToolsWrapper wrap(AgentSalesTools agentSalesTools) {
		return new AgentSalesToolsWrapper(agentSalesTools);
	}

}