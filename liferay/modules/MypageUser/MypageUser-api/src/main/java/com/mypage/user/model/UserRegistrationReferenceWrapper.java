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
 * This class is a wrapper for {@link UserRegistrationReference}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationReference
 * @generated
 */
public class UserRegistrationReferenceWrapper
	extends BaseModelWrapper<UserRegistrationReference>
	implements ModelWrapper<UserRegistrationReference>,
			   UserRegistrationReference {

	public UserRegistrationReferenceWrapper(
		UserRegistrationReference userRegistrationReference) {

		super(userRegistrationReference);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"userRegistrationReferenceId", getUserRegistrationReferenceId());
		attributes.put("name", getName());
		attributes.put("relation", getRelation());
		attributes.put("age", getAge());
		attributes.put("address", getAddress());
		attributes.put("phone", getPhone());
		attributes.put("job", getJob());
		attributes.put("year", getYear());
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
		Long userRegistrationReferenceId = (Long)attributes.get(
			"userRegistrationReferenceId");

		if (userRegistrationReferenceId != null) {
			setUserRegistrationReferenceId(userRegistrationReferenceId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String relation = (String)attributes.get("relation");

		if (relation != null) {
			setRelation(relation);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String job = (String)attributes.get("job");

		if (job != null) {
			setJob(job);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
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
	 * Returns the address of this user registration reference.
	 *
	 * @return the address of this user registration reference
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the age of this user registration reference.
	 *
	 * @return the age of this user registration reference
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the company ID of this user registration reference.
	 *
	 * @return the company ID of this user registration reference
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user registration reference.
	 *
	 * @return the create date of this user registration reference
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this user registration reference.
	 *
	 * @return the group ID of this user registration reference
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job of this user registration reference.
	 *
	 * @return the job of this user registration reference
	 */
	@Override
	public String getJob() {
		return model.getJob();
	}

	/**
	 * Returns the modified date of this user registration reference.
	 *
	 * @return the modified date of this user registration reference
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this user registration reference.
	 *
	 * @return the name of this user registration reference
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone of this user registration reference.
	 *
	 * @return the phone of this user registration reference
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this user registration reference.
	 *
	 * @return the primary key of this user registration reference
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the relation of this user registration reference.
	 *
	 * @return the relation of this user registration reference
	 */
	@Override
	public String getRelation() {
		return model.getRelation();
	}

	/**
	 * Returns the user ID of this user registration reference.
	 *
	 * @return the user ID of this user registration reference
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user registration reference.
	 *
	 * @return the user name of this user registration reference
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user registration ID of this user registration reference.
	 *
	 * @return the user registration ID of this user registration reference
	 */
	@Override
	public long getUserRegistrationId() {
		return model.getUserRegistrationId();
	}

	/**
	 * Returns the user registration reference ID of this user registration reference.
	 *
	 * @return the user registration reference ID of this user registration reference
	 */
	@Override
	public long getUserRegistrationReferenceId() {
		return model.getUserRegistrationReferenceId();
	}

	/**
	 * Returns the user uuid of this user registration reference.
	 *
	 * @return the user uuid of this user registration reference
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the year of this user registration reference.
	 *
	 * @return the year of this user registration reference
	 */
	@Override
	public int getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this user registration reference.
	 *
	 * @param address the address of this user registration reference
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the age of this user registration reference.
	 *
	 * @param age the age of this user registration reference
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the company ID of this user registration reference.
	 *
	 * @param companyId the company ID of this user registration reference
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user registration reference.
	 *
	 * @param createDate the create date of this user registration reference
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this user registration reference.
	 *
	 * @param groupId the group ID of this user registration reference
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job of this user registration reference.
	 *
	 * @param job the job of this user registration reference
	 */
	@Override
	public void setJob(String job) {
		model.setJob(job);
	}

	/**
	 * Sets the modified date of this user registration reference.
	 *
	 * @param modifiedDate the modified date of this user registration reference
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this user registration reference.
	 *
	 * @param name the name of this user registration reference
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone of this user registration reference.
	 *
	 * @param phone the phone of this user registration reference
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this user registration reference.
	 *
	 * @param primaryKey the primary key of this user registration reference
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the relation of this user registration reference.
	 *
	 * @param relation the relation of this user registration reference
	 */
	@Override
	public void setRelation(String relation) {
		model.setRelation(relation);
	}

	/**
	 * Sets the user ID of this user registration reference.
	 *
	 * @param userId the user ID of this user registration reference
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user registration reference.
	 *
	 * @param userName the user name of this user registration reference
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user registration ID of this user registration reference.
	 *
	 * @param userRegistrationId the user registration ID of this user registration reference
	 */
	@Override
	public void setUserRegistrationId(long userRegistrationId) {
		model.setUserRegistrationId(userRegistrationId);
	}

	/**
	 * Sets the user registration reference ID of this user registration reference.
	 *
	 * @param userRegistrationReferenceId the user registration reference ID of this user registration reference
	 */
	@Override
	public void setUserRegistrationReferenceId(
		long userRegistrationReferenceId) {

		model.setUserRegistrationReferenceId(userRegistrationReferenceId);
	}

	/**
	 * Sets the user uuid of this user registration reference.
	 *
	 * @param userUuid the user uuid of this user registration reference
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the year of this user registration reference.
	 *
	 * @param year the year of this user registration reference
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
	}

	@Override
	protected UserRegistrationReferenceWrapper wrap(
		UserRegistrationReference userRegistrationReference) {

		return new UserRegistrationReferenceWrapper(userRegistrationReference);
	}

}