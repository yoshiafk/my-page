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

package com.mypage.user.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserRegistrationLiability}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLiability
 * @generated
 */
public class UserRegistrationLiabilityWrapper
	extends BaseModelWrapper<UserRegistrationLiability>
	implements ModelWrapper<UserRegistrationLiability>,
			   UserRegistrationLiability {

	public UserRegistrationLiabilityWrapper(
		UserRegistrationLiability userRegistrationLiability) {

		super(userRegistrationLiability);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"userRegistrationLiabilityId", getUserRegistrationLiabilityId());
		attributes.put("name", getName());
		attributes.put("relationship", getRelationship());
		attributes.put("age", getAge());
		attributes.put("userRegistrationId", getUserRegistrationId());
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
		Long userRegistrationLiabilityId = (Long)attributes.get(
			"userRegistrationLiabilityId");

		if (userRegistrationLiabilityId != null) {
			setUserRegistrationLiabilityId(userRegistrationLiabilityId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String relationship = (String)attributes.get("relationship");

		if (relationship != null) {
			setRelationship(relationship);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Long userRegistrationId = (Long)attributes.get("userRegistrationId");

		if (userRegistrationId != null) {
			setUserRegistrationId(userRegistrationId);
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
	 * Returns the age of this user registration liability.
	 *
	 * @return the age of this user registration liability
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the company ID of this user registration liability.
	 *
	 * @return the company ID of this user registration liability
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user registration liability.
	 *
	 * @return the create date of this user registration liability
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this user registration liability.
	 *
	 * @return the group ID of this user registration liability
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this user registration liability.
	 *
	 * @return the modified date of this user registration liability
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this user registration liability.
	 *
	 * @return the name of this user registration liability
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this user registration liability.
	 *
	 * @return the primary key of this user registration liability
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the relationship of this user registration liability.
	 *
	 * @return the relationship of this user registration liability
	 */
	@Override
	public String getRelationship() {
		return model.getRelationship();
	}

	/**
	 * Returns the user ID of this user registration liability.
	 *
	 * @return the user ID of this user registration liability
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user registration liability.
	 *
	 * @return the user name of this user registration liability
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user registration ID of this user registration liability.
	 *
	 * @return the user registration ID of this user registration liability
	 */
	@Override
	public long getUserRegistrationId() {
		return model.getUserRegistrationId();
	}

	/**
	 * Returns the user registration liability ID of this user registration liability.
	 *
	 * @return the user registration liability ID of this user registration liability
	 */
	@Override
	public long getUserRegistrationLiabilityId() {
		return model.getUserRegistrationLiabilityId();
	}

	/**
	 * Returns the user uuid of this user registration liability.
	 *
	 * @return the user uuid of this user registration liability
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
	 * Sets the age of this user registration liability.
	 *
	 * @param age the age of this user registration liability
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the company ID of this user registration liability.
	 *
	 * @param companyId the company ID of this user registration liability
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user registration liability.
	 *
	 * @param createDate the create date of this user registration liability
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this user registration liability.
	 *
	 * @param groupId the group ID of this user registration liability
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this user registration liability.
	 *
	 * @param modifiedDate the modified date of this user registration liability
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this user registration liability.
	 *
	 * @param name the name of this user registration liability
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this user registration liability.
	 *
	 * @param primaryKey the primary key of this user registration liability
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the relationship of this user registration liability.
	 *
	 * @param relationship the relationship of this user registration liability
	 */
	@Override
	public void setRelationship(String relationship) {
		model.setRelationship(relationship);
	}

	/**
	 * Sets the user ID of this user registration liability.
	 *
	 * @param userId the user ID of this user registration liability
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user registration liability.
	 *
	 * @param userName the user name of this user registration liability
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user registration ID of this user registration liability.
	 *
	 * @param userRegistrationId the user registration ID of this user registration liability
	 */
	@Override
	public void setUserRegistrationId(long userRegistrationId) {
		model.setUserRegistrationId(userRegistrationId);
	}

	/**
	 * Sets the user registration liability ID of this user registration liability.
	 *
	 * @param userRegistrationLiabilityId the user registration liability ID of this user registration liability
	 */
	@Override
	public void setUserRegistrationLiabilityId(
		long userRegistrationLiabilityId) {

		model.setUserRegistrationLiabilityId(userRegistrationLiabilityId);
	}

	/**
	 * Sets the user uuid of this user registration liability.
	 *
	 * @param userUuid the user uuid of this user registration liability
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserRegistrationLiabilityWrapper wrap(
		UserRegistrationLiability userRegistrationLiability) {

		return new UserRegistrationLiabilityWrapper(userRegistrationLiability);
	}

}