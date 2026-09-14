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

package com.mypage.admin.product.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IndustryCategory}.
 * </p>
 *
 * @author Gositus Team
 * @see IndustryCategory
 * @generated
 */
public class IndustryCategoryWrapper
	extends BaseModelWrapper<IndustryCategory>
	implements IndustryCategory, ModelWrapper<IndustryCategory> {

	public IndustryCategoryWrapper(IndustryCategory industryCategory) {
		super(industryCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("industryCategoryId", getIndustryCategoryId());
		attributes.put("name", getName());
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
		Long industryCategoryId = (Long)attributes.get("industryCategoryId");

		if (industryCategoryId != null) {
			setIndustryCategoryId(industryCategoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	 * Returns the active of this industry category.
	 *
	 * @return the active of this industry category
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this industry category.
	 *
	 * @return the company ID of this industry category
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this industry category.
	 *
	 * @return the create date of this industry category
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this industry category.
	 *
	 * @return the group ID of this industry category
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the industry category ID of this industry category.
	 *
	 * @return the industry category ID of this industry category
	 */
	@Override
	public long getIndustryCategoryId() {
		return model.getIndustryCategoryId();
	}

	/**
	 * Returns the modified date of this industry category.
	 *
	 * @return the modified date of this industry category
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this industry category.
	 *
	 * @return the name of this industry category
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this industry category.
	 *
	 * @return the primary key of this industry category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this industry category.
	 *
	 * @return the user ID of this industry category
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this industry category.
	 *
	 * @return the user name of this industry category
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this industry category.
	 *
	 * @return the user uuid of this industry category
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this industry category.
	 *
	 * @param active the active of this industry category
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this industry category.
	 *
	 * @param companyId the company ID of this industry category
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this industry category.
	 *
	 * @param createDate the create date of this industry category
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this industry category.
	 *
	 * @param groupId the group ID of this industry category
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the industry category ID of this industry category.
	 *
	 * @param industryCategoryId the industry category ID of this industry category
	 */
	@Override
	public void setIndustryCategoryId(long industryCategoryId) {
		model.setIndustryCategoryId(industryCategoryId);
	}

	/**
	 * Sets the modified date of this industry category.
	 *
	 * @param modifiedDate the modified date of this industry category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this industry category.
	 *
	 * @param name the name of this industry category
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this industry category.
	 *
	 * @param primaryKey the primary key of this industry category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this industry category.
	 *
	 * @param userId the user ID of this industry category
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this industry category.
	 *
	 * @param userName the user name of this industry category
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this industry category.
	 *
	 * @param userUuid the user uuid of this industry category
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected IndustryCategoryWrapper wrap(IndustryCategory industryCategory) {
		return new IndustryCategoryWrapper(industryCategory);
	}

}