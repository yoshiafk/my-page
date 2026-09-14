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
 * This class is a wrapper for {@link CompanyType}.
 * </p>
 *
 * @author Gositus Team
 * @see CompanyType
 * @generated
 */
public class CompanyTypeWrapper
	extends BaseModelWrapper<CompanyType>
	implements CompanyType, ModelWrapper<CompanyType> {

	public CompanyTypeWrapper(CompanyType companyType) {
		super(companyType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyTypeId", getCompanyTypeId());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("sort", getSort());
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
		Long companyTypeId = (Long)attributes.get("companyTypeId");

		if (companyTypeId != null) {
			setCompanyTypeId(companyTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
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
	 * Returns the active of this company type.
	 *
	 * @return the active of this company type
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this company type.
	 *
	 * @return the company ID of this company type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the company type ID of this company type.
	 *
	 * @return the company type ID of this company type
	 */
	@Override
	public long getCompanyTypeId() {
		return model.getCompanyTypeId();
	}

	/**
	 * Returns the create date of this company type.
	 *
	 * @return the create date of this company type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this company type.
	 *
	 * @return the group ID of this company type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the label of this company type.
	 *
	 * @return the label of this company type
	 */
	@Override
	public String getLabel() {
		return model.getLabel();
	}

	/**
	 * Returns the modified date of this company type.
	 *
	 * @return the modified date of this company type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this company type.
	 *
	 * @return the name of this company type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this company type.
	 *
	 * @return the primary key of this company type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this company type.
	 *
	 * @return the sort of this company type
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the user ID of this company type.
	 *
	 * @return the user ID of this company type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this company type.
	 *
	 * @return the user name of this company type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this company type.
	 *
	 * @return the user uuid of this company type
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
	 * Sets the active of this company type.
	 *
	 * @param active the active of this company type
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this company type.
	 *
	 * @param companyId the company ID of this company type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the company type ID of this company type.
	 *
	 * @param companyTypeId the company type ID of this company type
	 */
	@Override
	public void setCompanyTypeId(long companyTypeId) {
		model.setCompanyTypeId(companyTypeId);
	}

	/**
	 * Sets the create date of this company type.
	 *
	 * @param createDate the create date of this company type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this company type.
	 *
	 * @param groupId the group ID of this company type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the label of this company type.
	 *
	 * @param label the label of this company type
	 */
	@Override
	public void setLabel(String label) {
		model.setLabel(label);
	}

	/**
	 * Sets the modified date of this company type.
	 *
	 * @param modifiedDate the modified date of this company type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this company type.
	 *
	 * @param name the name of this company type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this company type.
	 *
	 * @param primaryKey the primary key of this company type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this company type.
	 *
	 * @param sort the sort of this company type
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the user ID of this company type.
	 *
	 * @param userId the user ID of this company type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this company type.
	 *
	 * @param userName the user name of this company type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this company type.
	 *
	 * @param userUuid the user uuid of this company type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CompanyTypeWrapper wrap(CompanyType companyType) {
		return new CompanyTypeWrapper(companyType);
	}

}