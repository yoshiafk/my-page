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
 * This class is a wrapper for {@link UserRegistrationEducation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationEducation
 * @generated
 */
public class UserRegistrationEducationWrapper
	extends BaseModelWrapper<UserRegistrationEducation>
	implements ModelWrapper<UserRegistrationEducation>,
			   UserRegistrationEducation {

	public UserRegistrationEducationWrapper(
		UserRegistrationEducation userRegistrationEducation) {

		super(userRegistrationEducation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"userRegistrationEducationId", getUserRegistrationEducationId());
		attributes.put("name", getName());
		attributes.put("year", getYear());
		attributes.put("graduate", getGraduate());
		attributes.put("courseType", getCourseType());
		attributes.put("title", getTitle());
		attributes.put("eduType", getEduType());
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
		Long userRegistrationEducationId = (Long)attributes.get(
			"userRegistrationEducationId");

		if (userRegistrationEducationId != null) {
			setUserRegistrationEducationId(userRegistrationEducationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer graduate = (Integer)attributes.get("graduate");

		if (graduate != null) {
			setGraduate(graduate);
		}

		String courseType = (String)attributes.get("courseType");

		if (courseType != null) {
			setCourseType(courseType);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String eduType = (String)attributes.get("eduType");

		if (eduType != null) {
			setEduType(eduType);
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
	 * Returns the company ID of this user registration education.
	 *
	 * @return the company ID of this user registration education
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the course type of this user registration education.
	 *
	 * @return the course type of this user registration education
	 */
	@Override
	public String getCourseType() {
		return model.getCourseType();
	}

	/**
	 * Returns the create date of this user registration education.
	 *
	 * @return the create date of this user registration education
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the edu type of this user registration education.
	 *
	 * @return the edu type of this user registration education
	 */
	@Override
	public String getEduType() {
		return model.getEduType();
	}

	/**
	 * Returns the graduate of this user registration education.
	 *
	 * @return the graduate of this user registration education
	 */
	@Override
	public int getGraduate() {
		return model.getGraduate();
	}

	/**
	 * Returns the group ID of this user registration education.
	 *
	 * @return the group ID of this user registration education
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this user registration education.
	 *
	 * @return the modified date of this user registration education
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this user registration education.
	 *
	 * @return the name of this user registration education
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this user registration education.
	 *
	 * @return the primary key of this user registration education
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this user registration education.
	 *
	 * @return the title of this user registration education
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this user registration education.
	 *
	 * @return the user ID of this user registration education
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user registration education.
	 *
	 * @return the user name of this user registration education
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user registration education ID of this user registration education.
	 *
	 * @return the user registration education ID of this user registration education
	 */
	@Override
	public long getUserRegistrationEducationId() {
		return model.getUserRegistrationEducationId();
	}

	/**
	 * Returns the user registration ID of this user registration education.
	 *
	 * @return the user registration ID of this user registration education
	 */
	@Override
	public long getUserRegistrationId() {
		return model.getUserRegistrationId();
	}

	/**
	 * Returns the user uuid of this user registration education.
	 *
	 * @return the user uuid of this user registration education
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the year of this user registration education.
	 *
	 * @return the year of this user registration education
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
	 * Sets the company ID of this user registration education.
	 *
	 * @param companyId the company ID of this user registration education
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the course type of this user registration education.
	 *
	 * @param courseType the course type of this user registration education
	 */
	@Override
	public void setCourseType(String courseType) {
		model.setCourseType(courseType);
	}

	/**
	 * Sets the create date of this user registration education.
	 *
	 * @param createDate the create date of this user registration education
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the edu type of this user registration education.
	 *
	 * @param eduType the edu type of this user registration education
	 */
	@Override
	public void setEduType(String eduType) {
		model.setEduType(eduType);
	}

	/**
	 * Sets the graduate of this user registration education.
	 *
	 * @param graduate the graduate of this user registration education
	 */
	@Override
	public void setGraduate(int graduate) {
		model.setGraduate(graduate);
	}

	/**
	 * Sets the group ID of this user registration education.
	 *
	 * @param groupId the group ID of this user registration education
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this user registration education.
	 *
	 * @param modifiedDate the modified date of this user registration education
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this user registration education.
	 *
	 * @param name the name of this user registration education
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this user registration education.
	 *
	 * @param primaryKey the primary key of this user registration education
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this user registration education.
	 *
	 * @param title the title of this user registration education
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this user registration education.
	 *
	 * @param userId the user ID of this user registration education
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user registration education.
	 *
	 * @param userName the user name of this user registration education
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user registration education ID of this user registration education.
	 *
	 * @param userRegistrationEducationId the user registration education ID of this user registration education
	 */
	@Override
	public void setUserRegistrationEducationId(
		long userRegistrationEducationId) {

		model.setUserRegistrationEducationId(userRegistrationEducationId);
	}

	/**
	 * Sets the user registration ID of this user registration education.
	 *
	 * @param userRegistrationId the user registration ID of this user registration education
	 */
	@Override
	public void setUserRegistrationId(long userRegistrationId) {
		model.setUserRegistrationId(userRegistrationId);
	}

	/**
	 * Sets the user uuid of this user registration education.
	 *
	 * @param userUuid the user uuid of this user registration education
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the year of this user registration education.
	 *
	 * @param year the year of this user registration education
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
	}

	@Override
	protected UserRegistrationEducationWrapper wrap(
		UserRegistrationEducation userRegistrationEducation) {

		return new UserRegistrationEducationWrapper(userRegistrationEducation);
	}

}