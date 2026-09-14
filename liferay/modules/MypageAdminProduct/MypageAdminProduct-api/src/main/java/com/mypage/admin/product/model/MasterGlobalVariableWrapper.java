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
 * This class is a wrapper for {@link MasterGlobalVariable}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterGlobalVariable
 * @generated
 */
public class MasterGlobalVariableWrapper
	extends BaseModelWrapper<MasterGlobalVariable>
	implements MasterGlobalVariable, ModelWrapper<MasterGlobalVariable> {

	public MasterGlobalVariableWrapper(
		MasterGlobalVariable masterGlobalVariable) {

		super(masterGlobalVariable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterGlobalVariableId", getMasterGlobalVariableId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("group", getGroup());
		attributes.put("name", getName());
		attributes.put("value", getValue());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterGlobalVariableId = (Long)attributes.get(
			"masterGlobalVariableId");

		if (masterGlobalVariableId != null) {
			setMasterGlobalVariableId(masterGlobalVariableId);
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

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this master global variable.
	 *
	 * @return the active of this master global variable
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this master global variable.
	 *
	 * @return the company ID of this master global variable
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master global variable.
	 *
	 * @return the create date of this master global variable
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group of this master global variable.
	 *
	 * @return the group of this master global variable
	 */
	@Override
	public String getGroup() {
		return model.getGroup();
	}

	/**
	 * Returns the group ID of this master global variable.
	 *
	 * @return the group ID of this master global variable
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image file entry ID of this master global variable.
	 *
	 * @return the image file entry ID of this master global variable
	 */
	@Override
	public Long getImageFileEntryId() {
		return model.getImageFileEntryId();
	}

	/**
	 * Returns the master global variable ID of this master global variable.
	 *
	 * @return the master global variable ID of this master global variable
	 */
	@Override
	public long getMasterGlobalVariableId() {
		return model.getMasterGlobalVariableId();
	}

	/**
	 * Returns the modified date of this master global variable.
	 *
	 * @return the modified date of this master global variable
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master global variable.
	 *
	 * @return the name of this master global variable
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master global variable.
	 *
	 * @return the primary key of this master global variable
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master global variable.
	 *
	 * @return the user ID of this master global variable
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master global variable.
	 *
	 * @return the user name of this master global variable
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master global variable.
	 *
	 * @return the user uuid of this master global variable
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the value of this master global variable.
	 *
	 * @return the value of this master global variable
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this master global variable.
	 *
	 * @param active the active of this master global variable
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this master global variable.
	 *
	 * @param companyId the company ID of this master global variable
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master global variable.
	 *
	 * @param createDate the create date of this master global variable
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group of this master global variable.
	 *
	 * @param group the group of this master global variable
	 */
	@Override
	public void setGroup(String group) {
		model.setGroup(group);
	}

	/**
	 * Sets the group ID of this master global variable.
	 *
	 * @param groupId the group ID of this master global variable
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image file entry ID of this master global variable.
	 *
	 * @param imageFileEntryId the image file entry ID of this master global variable
	 */
	@Override
	public void setImageFileEntryId(Long imageFileEntryId) {
		model.setImageFileEntryId(imageFileEntryId);
	}

	/**
	 * Sets the master global variable ID of this master global variable.
	 *
	 * @param masterGlobalVariableId the master global variable ID of this master global variable
	 */
	@Override
	public void setMasterGlobalVariableId(long masterGlobalVariableId) {
		model.setMasterGlobalVariableId(masterGlobalVariableId);
	}

	/**
	 * Sets the modified date of this master global variable.
	 *
	 * @param modifiedDate the modified date of this master global variable
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master global variable.
	 *
	 * @param name the name of this master global variable
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master global variable.
	 *
	 * @param primaryKey the primary key of this master global variable
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master global variable.
	 *
	 * @param userId the user ID of this master global variable
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master global variable.
	 *
	 * @param userName the user name of this master global variable
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master global variable.
	 *
	 * @param userUuid the user uuid of this master global variable
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the value of this master global variable.
	 *
	 * @param value the value of this master global variable
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected MasterGlobalVariableWrapper wrap(
		MasterGlobalVariable masterGlobalVariable) {

		return new MasterGlobalVariableWrapper(masterGlobalVariable);
	}

}