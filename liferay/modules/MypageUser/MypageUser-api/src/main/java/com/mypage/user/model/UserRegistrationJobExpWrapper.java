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
 * This class is a wrapper for {@link UserRegistrationJobExp}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationJobExp
 * @generated
 */
public class UserRegistrationJobExpWrapper
	extends BaseModelWrapper<UserRegistrationJobExp>
	implements ModelWrapper<UserRegistrationJobExp>, UserRegistrationJobExp {

	public UserRegistrationJobExpWrapper(
		UserRegistrationJobExp userRegistrationJobExp) {

		super(userRegistrationJobExp);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"userRegistrationJobExpId", getUserRegistrationJobExpId());
		attributes.put("name", getName());
		attributes.put("year", getYear());
		attributes.put("jobHead", getJobHead());
		attributes.put("jobPosition", getJobPosition());
		attributes.put("jobIncome", getJobIncome());
		attributes.put("otherInsuranceCompany", getOtherInsuranceCompany());
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
		Long userRegistrationJobExpId = (Long)attributes.get(
			"userRegistrationJobExpId");

		if (userRegistrationJobExpId != null) {
			setUserRegistrationJobExpId(userRegistrationJobExpId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String jobHead = (String)attributes.get("jobHead");

		if (jobHead != null) {
			setJobHead(jobHead);
		}

		String jobPosition = (String)attributes.get("jobPosition");

		if (jobPosition != null) {
			setJobPosition(jobPosition);
		}

		String jobIncome = (String)attributes.get("jobIncome");

		if (jobIncome != null) {
			setJobIncome(jobIncome);
		}

		Integer otherInsuranceCompany = (Integer)attributes.get(
			"otherInsuranceCompany");

		if (otherInsuranceCompany != null) {
			setOtherInsuranceCompany(otherInsuranceCompany);
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
	 * Returns the company ID of this user registration job exp.
	 *
	 * @return the company ID of this user registration job exp
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user registration job exp.
	 *
	 * @return the create date of this user registration job exp
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this user registration job exp.
	 *
	 * @return the group ID of this user registration job exp
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job head of this user registration job exp.
	 *
	 * @return the job head of this user registration job exp
	 */
	@Override
	public String getJobHead() {
		return model.getJobHead();
	}

	/**
	 * Returns the job income of this user registration job exp.
	 *
	 * @return the job income of this user registration job exp
	 */
	@Override
	public String getJobIncome() {
		return model.getJobIncome();
	}

	/**
	 * Returns the job position of this user registration job exp.
	 *
	 * @return the job position of this user registration job exp
	 */
	@Override
	public String getJobPosition() {
		return model.getJobPosition();
	}

	/**
	 * Returns the modified date of this user registration job exp.
	 *
	 * @return the modified date of this user registration job exp
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this user registration job exp.
	 *
	 * @return the name of this user registration job exp
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the other insurance company of this user registration job exp.
	 *
	 * @return the other insurance company of this user registration job exp
	 */
	@Override
	public int getOtherInsuranceCompany() {
		return model.getOtherInsuranceCompany();
	}

	/**
	 * Returns the primary key of this user registration job exp.
	 *
	 * @return the primary key of this user registration job exp
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user registration job exp.
	 *
	 * @return the user ID of this user registration job exp
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user registration job exp.
	 *
	 * @return the user name of this user registration job exp
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user registration ID of this user registration job exp.
	 *
	 * @return the user registration ID of this user registration job exp
	 */
	@Override
	public long getUserRegistrationId() {
		return model.getUserRegistrationId();
	}

	/**
	 * Returns the user registration job exp ID of this user registration job exp.
	 *
	 * @return the user registration job exp ID of this user registration job exp
	 */
	@Override
	public long getUserRegistrationJobExpId() {
		return model.getUserRegistrationJobExpId();
	}

	/**
	 * Returns the user uuid of this user registration job exp.
	 *
	 * @return the user uuid of this user registration job exp
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the year of this user registration job exp.
	 *
	 * @return the year of this user registration job exp
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
	 * Sets the company ID of this user registration job exp.
	 *
	 * @param companyId the company ID of this user registration job exp
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user registration job exp.
	 *
	 * @param createDate the create date of this user registration job exp
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this user registration job exp.
	 *
	 * @param groupId the group ID of this user registration job exp
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job head of this user registration job exp.
	 *
	 * @param jobHead the job head of this user registration job exp
	 */
	@Override
	public void setJobHead(String jobHead) {
		model.setJobHead(jobHead);
	}

	/**
	 * Sets the job income of this user registration job exp.
	 *
	 * @param jobIncome the job income of this user registration job exp
	 */
	@Override
	public void setJobIncome(String jobIncome) {
		model.setJobIncome(jobIncome);
	}

	/**
	 * Sets the job position of this user registration job exp.
	 *
	 * @param jobPosition the job position of this user registration job exp
	 */
	@Override
	public void setJobPosition(String jobPosition) {
		model.setJobPosition(jobPosition);
	}

	/**
	 * Sets the modified date of this user registration job exp.
	 *
	 * @param modifiedDate the modified date of this user registration job exp
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this user registration job exp.
	 *
	 * @param name the name of this user registration job exp
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the other insurance company of this user registration job exp.
	 *
	 * @param otherInsuranceCompany the other insurance company of this user registration job exp
	 */
	@Override
	public void setOtherInsuranceCompany(int otherInsuranceCompany) {
		model.setOtherInsuranceCompany(otherInsuranceCompany);
	}

	/**
	 * Sets the primary key of this user registration job exp.
	 *
	 * @param primaryKey the primary key of this user registration job exp
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user registration job exp.
	 *
	 * @param userId the user ID of this user registration job exp
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user registration job exp.
	 *
	 * @param userName the user name of this user registration job exp
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user registration ID of this user registration job exp.
	 *
	 * @param userRegistrationId the user registration ID of this user registration job exp
	 */
	@Override
	public void setUserRegistrationId(long userRegistrationId) {
		model.setUserRegistrationId(userRegistrationId);
	}

	/**
	 * Sets the user registration job exp ID of this user registration job exp.
	 *
	 * @param userRegistrationJobExpId the user registration job exp ID of this user registration job exp
	 */
	@Override
	public void setUserRegistrationJobExpId(long userRegistrationJobExpId) {
		model.setUserRegistrationJobExpId(userRegistrationJobExpId);
	}

	/**
	 * Sets the user uuid of this user registration job exp.
	 *
	 * @param userUuid the user uuid of this user registration job exp
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the year of this user registration job exp.
	 *
	 * @param year the year of this user registration job exp
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
	}

	@Override
	protected UserRegistrationJobExpWrapper wrap(
		UserRegistrationJobExp userRegistrationJobExp) {

		return new UserRegistrationJobExpWrapper(userRegistrationJobExp);
	}

}