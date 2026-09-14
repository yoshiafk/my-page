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
 * This class is a wrapper for {@link MasterOccupation}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterOccupation
 * @generated
 */
public class MasterOccupationWrapper
	extends BaseModelWrapper<MasterOccupation>
	implements MasterOccupation, ModelWrapper<MasterOccupation> {

	public MasterOccupationWrapper(MasterOccupation masterOccupation) {
		super(masterOccupation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterOccupationId", getMasterOccupationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put(
			"masterOccupationCategoryId", getMasterOccupationCategoryId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterOccupationId = (Long)attributes.get("masterOccupationId");

		if (masterOccupationId != null) {
			setMasterOccupationId(masterOccupationId);
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

		Long masterOccupationCategoryId = (Long)attributes.get(
			"masterOccupationCategoryId");

		if (masterOccupationCategoryId != null) {
			setMasterOccupationCategoryId(masterOccupationCategoryId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this master occupation.
	 *
	 * @return the active of this master occupation
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this master occupation.
	 *
	 * @return the company ID of this master occupation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master occupation.
	 *
	 * @return the create date of this master occupation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master occupation.
	 *
	 * @return the group ID of this master occupation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the master occupation category ID of this master occupation.
	 *
	 * @return the master occupation category ID of this master occupation
	 */
	@Override
	public long getMasterOccupationCategoryId() {
		return model.getMasterOccupationCategoryId();
	}

	/**
	 * Returns the master occupation ID of this master occupation.
	 *
	 * @return the master occupation ID of this master occupation
	 */
	@Override
	public long getMasterOccupationId() {
		return model.getMasterOccupationId();
	}

	/**
	 * Returns the modified date of this master occupation.
	 *
	 * @return the modified date of this master occupation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master occupation.
	 *
	 * @return the name of this master occupation
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master occupation.
	 *
	 * @return the primary key of this master occupation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master occupation.
	 *
	 * @return the user ID of this master occupation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master occupation.
	 *
	 * @return the user name of this master occupation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master occupation.
	 *
	 * @return the user uuid of this master occupation
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
	 * Sets the active of this master occupation.
	 *
	 * @param active the active of this master occupation
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this master occupation.
	 *
	 * @param companyId the company ID of this master occupation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master occupation.
	 *
	 * @param createDate the create date of this master occupation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master occupation.
	 *
	 * @param groupId the group ID of this master occupation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the master occupation category ID of this master occupation.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID of this master occupation
	 */
	@Override
	public void setMasterOccupationCategoryId(long masterOccupationCategoryId) {
		model.setMasterOccupationCategoryId(masterOccupationCategoryId);
	}

	/**
	 * Sets the master occupation ID of this master occupation.
	 *
	 * @param masterOccupationId the master occupation ID of this master occupation
	 */
	@Override
	public void setMasterOccupationId(long masterOccupationId) {
		model.setMasterOccupationId(masterOccupationId);
	}

	/**
	 * Sets the modified date of this master occupation.
	 *
	 * @param modifiedDate the modified date of this master occupation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master occupation.
	 *
	 * @param name the name of this master occupation
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master occupation.
	 *
	 * @param primaryKey the primary key of this master occupation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master occupation.
	 *
	 * @param userId the user ID of this master occupation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master occupation.
	 *
	 * @param userName the user name of this master occupation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master occupation.
	 *
	 * @param userUuid the user uuid of this master occupation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterOccupationWrapper wrap(MasterOccupation masterOccupation) {
		return new MasterOccupationWrapper(masterOccupation);
	}

}