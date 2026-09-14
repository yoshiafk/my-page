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
 * This class is a wrapper for {@link SmartActiveFeature}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveFeature
 * @generated
 */
public class SmartActiveFeatureWrapper
	extends BaseModelWrapper<SmartActiveFeature>
	implements ModelWrapper<SmartActiveFeature>, SmartActiveFeature {

	public SmartActiveFeatureWrapper(SmartActiveFeature smartActiveFeature) {
		super(smartActiveFeature);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartActiveFeatureId", getSmartActiveFeatureId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("fileUploadEntryId", getFileUploadEntryId());
		attributes.put("fileUploadUrl", getFileUploadUrl());
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
		Long smartActiveFeatureId = (Long)attributes.get(
			"smartActiveFeatureId");

		if (smartActiveFeatureId != null) {
			setSmartActiveFeatureId(smartActiveFeatureId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long fileUploadEntryId = (Long)attributes.get("fileUploadEntryId");

		if (fileUploadEntryId != null) {
			setFileUploadEntryId(fileUploadEntryId);
		}

		String fileUploadUrl = (String)attributes.get("fileUploadUrl");

		if (fileUploadUrl != null) {
			setFileUploadUrl(fileUploadUrl);
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
	 * Returns the active of this smart active feature.
	 *
	 * @return the active of this smart active feature
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart active feature.
	 *
	 * @return the company ID of this smart active feature
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active feature.
	 *
	 * @return the create date of this smart active feature
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this smart active feature.
	 *
	 * @return the description of this smart active feature
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the file upload entry ID of this smart active feature.
	 *
	 * @return the file upload entry ID of this smart active feature
	 */
	@Override
	public long getFileUploadEntryId() {
		return model.getFileUploadEntryId();
	}

	/**
	 * Returns the file upload url of this smart active feature.
	 *
	 * @return the file upload url of this smart active feature
	 */
	@Override
	public String getFileUploadUrl() {
		return model.getFileUploadUrl();
	}

	/**
	 * Returns the group ID of this smart active feature.
	 *
	 * @return the group ID of this smart active feature
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart active feature.
	 *
	 * @return the modified date of this smart active feature
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart active feature.
	 *
	 * @return the primary key of this smart active feature
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active feature ID of this smart active feature.
	 *
	 * @return the smart active feature ID of this smart active feature
	 */
	@Override
	public long getSmartActiveFeatureId() {
		return model.getSmartActiveFeatureId();
	}

	/**
	 * Returns the sort of this smart active feature.
	 *
	 * @return the sort of this smart active feature
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the title of this smart active feature.
	 *
	 * @return the title of this smart active feature
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this smart active feature.
	 *
	 * @return the user ID of this smart active feature
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active feature.
	 *
	 * @return the user name of this smart active feature
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active feature.
	 *
	 * @return the user uuid of this smart active feature
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
	 * Sets the active of this smart active feature.
	 *
	 * @param active the active of this smart active feature
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart active feature.
	 *
	 * @param companyId the company ID of this smart active feature
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active feature.
	 *
	 * @param createDate the create date of this smart active feature
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this smart active feature.
	 *
	 * @param description the description of this smart active feature
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the file upload entry ID of this smart active feature.
	 *
	 * @param fileUploadEntryId the file upload entry ID of this smart active feature
	 */
	@Override
	public void setFileUploadEntryId(long fileUploadEntryId) {
		model.setFileUploadEntryId(fileUploadEntryId);
	}

	/**
	 * Sets the file upload url of this smart active feature.
	 *
	 * @param fileUploadUrl the file upload url of this smart active feature
	 */
	@Override
	public void setFileUploadUrl(String fileUploadUrl) {
		model.setFileUploadUrl(fileUploadUrl);
	}

	/**
	 * Sets the group ID of this smart active feature.
	 *
	 * @param groupId the group ID of this smart active feature
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart active feature.
	 *
	 * @param modifiedDate the modified date of this smart active feature
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart active feature.
	 *
	 * @param primaryKey the primary key of this smart active feature
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active feature ID of this smart active feature.
	 *
	 * @param smartActiveFeatureId the smart active feature ID of this smart active feature
	 */
	@Override
	public void setSmartActiveFeatureId(long smartActiveFeatureId) {
		model.setSmartActiveFeatureId(smartActiveFeatureId);
	}

	/**
	 * Sets the sort of this smart active feature.
	 *
	 * @param sort the sort of this smart active feature
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the title of this smart active feature.
	 *
	 * @param title the title of this smart active feature
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this smart active feature.
	 *
	 * @param userId the user ID of this smart active feature
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active feature.
	 *
	 * @param userName the user name of this smart active feature
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active feature.
	 *
	 * @param userUuid the user uuid of this smart active feature
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActiveFeatureWrapper wrap(
		SmartActiveFeature smartActiveFeature) {

		return new SmartActiveFeatureWrapper(smartActiveFeature);
	}

}