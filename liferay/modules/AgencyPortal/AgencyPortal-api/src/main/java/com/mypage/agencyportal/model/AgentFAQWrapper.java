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
 * This class is a wrapper for {@link AgentFAQ}.
 * </p>
 *
 * @author Gositus Team
 * @see AgentFAQ
 * @generated
 */
public class AgentFAQWrapper
	extends BaseModelWrapper<AgentFAQ>
	implements AgentFAQ, ModelWrapper<AgentFAQ> {

	public AgentFAQWrapper(AgentFAQ agentFAQ) {
		super(agentFAQ);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agentFaqId", getAgentFaqId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("categoryId", getCategoryId());
		attributes.put("category", getCategory());
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
		Long agentFaqId = (Long)attributes.get("agentFaqId");

		if (agentFaqId != null) {
			setAgentFaqId(agentFaqId);
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
	 * Returns the active of this agent faq.
	 *
	 * @return the active of this agent faq
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the agent faq ID of this agent faq.
	 *
	 * @return the agent faq ID of this agent faq
	 */
	@Override
	public long getAgentFaqId() {
		return model.getAgentFaqId();
	}

	/**
	 * Returns the category of this agent faq.
	 *
	 * @return the category of this agent faq
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the category ID of this agent faq.
	 *
	 * @return the category ID of this agent faq
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this agent faq.
	 *
	 * @return the company ID of this agent faq
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this agent faq.
	 *
	 * @return the create date of this agent faq
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this agent faq.
	 *
	 * @return the description of this agent faq
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this agent faq.
	 *
	 * @return the group ID of this agent faq
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this agent faq.
	 *
	 * @return the modified date of this agent faq
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this agent faq.
	 *
	 * @return the primary key of this agent faq
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this agent faq.
	 *
	 * @return the status of this agent faq
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this agent faq.
	 *
	 * @return the title of this agent faq
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the trash entry created when this agent faq was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this agent faq.
	 *
	 * @return the trash entry created when this agent faq was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this agent faq.
	 *
	 * @return the class primary key of the trash entry for this agent faq
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this agent faq.
	 *
	 * @return the trash handler for this agent faq
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this agent faq.
	 *
	 * @return the user ID of this agent faq
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agent faq.
	 *
	 * @return the user name of this agent faq
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agent faq.
	 *
	 * @return the user uuid of this agent faq
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this agent faq is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this agent faq is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this agent faq is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this agent faq is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the active of this agent faq.
	 *
	 * @param active the active of this agent faq
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the agent faq ID of this agent faq.
	 *
	 * @param agentFaqId the agent faq ID of this agent faq
	 */
	@Override
	public void setAgentFaqId(long agentFaqId) {
		model.setAgentFaqId(agentFaqId);
	}

	/**
	 * Sets the category of this agent faq.
	 *
	 * @param category the category of this agent faq
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the category ID of this agent faq.
	 *
	 * @param categoryId the category ID of this agent faq
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this agent faq.
	 *
	 * @param companyId the company ID of this agent faq
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this agent faq.
	 *
	 * @param createDate the create date of this agent faq
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this agent faq.
	 *
	 * @param description the description of this agent faq
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this agent faq.
	 *
	 * @param groupId the group ID of this agent faq
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this agent faq.
	 *
	 * @param modifiedDate the modified date of this agent faq
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this agent faq.
	 *
	 * @param primaryKey the primary key of this agent faq
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this agent faq.
	 *
	 * @param title the title of this agent faq
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this agent faq.
	 *
	 * @param userId the user ID of this agent faq
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agent faq.
	 *
	 * @param userName the user name of this agent faq
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agent faq.
	 *
	 * @param userUuid the user uuid of this agent faq
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AgentFAQWrapper wrap(AgentFAQ agentFAQ) {
		return new AgentFAQWrapper(agentFAQ);
	}

}