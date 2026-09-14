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
 * This class is a wrapper for {@link SmartHealthBenefitGroup}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthBenefitGroup
 * @generated
 */
public class SmartHealthBenefitGroupWrapper
	extends BaseModelWrapper<SmartHealthBenefitGroup>
	implements ModelWrapper<SmartHealthBenefitGroup>, SmartHealthBenefitGroup {

	public SmartHealthBenefitGroupWrapper(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		super(smartHealthBenefitGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"smartHealthBenefitGroupId", getSmartHealthBenefitGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupName", getGroupName());
		attributes.put("groupDescription", getGroupDescription());
		attributes.put("groupCode", getGroupCode());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long smartHealthBenefitGroupId = (Long)attributes.get(
			"smartHealthBenefitGroupId");

		if (smartHealthBenefitGroupId != null) {
			setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
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

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String groupDescription = (String)attributes.get("groupDescription");

		if (groupDescription != null) {
			setGroupDescription(groupDescription);
		}

		String groupCode = (String)attributes.get("groupCode");

		if (groupCode != null) {
			setGroupCode(groupCode);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this smart health benefit group.
	 *
	 * @return the active of this smart health benefit group
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart health benefit group.
	 *
	 * @return the company ID of this smart health benefit group
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart health benefit group.
	 *
	 * @return the create date of this smart health benefit group
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group code of this smart health benefit group.
	 *
	 * @return the group code of this smart health benefit group
	 */
	@Override
	public String getGroupCode() {
		return model.getGroupCode();
	}

	/**
	 * Returns the group description of this smart health benefit group.
	 *
	 * @return the group description of this smart health benefit group
	 */
	@Override
	public String getGroupDescription() {
		return model.getGroupDescription();
	}

	/**
	 * Returns the group ID of this smart health benefit group.
	 *
	 * @return the group ID of this smart health benefit group
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the group name of this smart health benefit group.
	 *
	 * @return the group name of this smart health benefit group
	 */
	@Override
	public String getGroupName() {
		return model.getGroupName();
	}

	/**
	 * Returns the modified date of this smart health benefit group.
	 *
	 * @return the modified date of this smart health benefit group
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart health benefit group.
	 *
	 * @return the primary key of this smart health benefit group
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart health benefit group ID of this smart health benefit group.
	 *
	 * @return the smart health benefit group ID of this smart health benefit group
	 */
	@Override
	public long getSmartHealthBenefitGroupId() {
		return model.getSmartHealthBenefitGroupId();
	}

	/**
	 * Returns the user ID of this smart health benefit group.
	 *
	 * @return the user ID of this smart health benefit group
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart health benefit group.
	 *
	 * @return the user name of this smart health benefit group
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart health benefit group.
	 *
	 * @return the user uuid of this smart health benefit group
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
	 * Sets the active of this smart health benefit group.
	 *
	 * @param active the active of this smart health benefit group
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart health benefit group.
	 *
	 * @param companyId the company ID of this smart health benefit group
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart health benefit group.
	 *
	 * @param createDate the create date of this smart health benefit group
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group code of this smart health benefit group.
	 *
	 * @param groupCode the group code of this smart health benefit group
	 */
	@Override
	public void setGroupCode(String groupCode) {
		model.setGroupCode(groupCode);
	}

	/**
	 * Sets the group description of this smart health benefit group.
	 *
	 * @param groupDescription the group description of this smart health benefit group
	 */
	@Override
	public void setGroupDescription(String groupDescription) {
		model.setGroupDescription(groupDescription);
	}

	/**
	 * Sets the group ID of this smart health benefit group.
	 *
	 * @param groupId the group ID of this smart health benefit group
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the group name of this smart health benefit group.
	 *
	 * @param groupName the group name of this smart health benefit group
	 */
	@Override
	public void setGroupName(String groupName) {
		model.setGroupName(groupName);
	}

	/**
	 * Sets the modified date of this smart health benefit group.
	 *
	 * @param modifiedDate the modified date of this smart health benefit group
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart health benefit group.
	 *
	 * @param primaryKey the primary key of this smart health benefit group
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart health benefit group ID of this smart health benefit group.
	 *
	 * @param smartHealthBenefitGroupId the smart health benefit group ID of this smart health benefit group
	 */
	@Override
	public void setSmartHealthBenefitGroupId(long smartHealthBenefitGroupId) {
		model.setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
	}

	/**
	 * Sets the user ID of this smart health benefit group.
	 *
	 * @param userId the user ID of this smart health benefit group
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart health benefit group.
	 *
	 * @param userName the user name of this smart health benefit group
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart health benefit group.
	 *
	 * @param userUuid the user uuid of this smart health benefit group
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartHealthBenefitGroupWrapper wrap(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		return new SmartHealthBenefitGroupWrapper(smartHealthBenefitGroup);
	}

}