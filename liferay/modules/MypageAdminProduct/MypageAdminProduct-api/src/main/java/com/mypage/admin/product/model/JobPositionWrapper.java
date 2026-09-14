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
 * This class is a wrapper for {@link JobPosition}.
 * </p>
 *
 * @author Gositus Team
 * @see JobPosition
 * @generated
 */
public class JobPositionWrapper
	extends BaseModelWrapper<JobPosition>
	implements JobPosition, ModelWrapper<JobPosition> {

	public JobPositionWrapper(JobPosition jobPosition) {
		super(jobPosition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobPositionId", getJobPositionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobPositionId = (Long)attributes.get("jobPositionId");

		if (jobPositionId != null) {
			setJobPositionId(jobPositionId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this job position.
	 *
	 * @return the active of this job position
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this job position.
	 *
	 * @return the company ID of this job position
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this job position.
	 *
	 * @return the create date of this job position
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this job position.
	 *
	 * @return the group ID of this job position
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job position ID of this job position.
	 *
	 * @return the job position ID of this job position
	 */
	@Override
	public long getJobPositionId() {
		return model.getJobPositionId();
	}

	/**
	 * Returns the modified date of this job position.
	 *
	 * @return the modified date of this job position
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this job position.
	 *
	 * @return the name of this job position
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this job position.
	 *
	 * @return the primary key of this job position
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this job position.
	 *
	 * @return the user ID of this job position
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this job position.
	 *
	 * @return the user name of this job position
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this job position.
	 *
	 * @return the user uuid of this job position
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
	 * Sets the active of this job position.
	 *
	 * @param active the active of this job position
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this job position.
	 *
	 * @param companyId the company ID of this job position
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this job position.
	 *
	 * @param createDate the create date of this job position
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this job position.
	 *
	 * @param groupId the group ID of this job position
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job position ID of this job position.
	 *
	 * @param jobPositionId the job position ID of this job position
	 */
	@Override
	public void setJobPositionId(long jobPositionId) {
		model.setJobPositionId(jobPositionId);
	}

	/**
	 * Sets the modified date of this job position.
	 *
	 * @param modifiedDate the modified date of this job position
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this job position.
	 *
	 * @param name the name of this job position
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this job position.
	 *
	 * @param primaryKey the primary key of this job position
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this job position.
	 *
	 * @param userId the user ID of this job position
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this job position.
	 *
	 * @param userName the user name of this job position
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this job position.
	 *
	 * @param userUuid the user uuid of this job position
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected JobPositionWrapper wrap(JobPosition jobPosition) {
		return new JobPositionWrapper(jobPosition);
	}

}