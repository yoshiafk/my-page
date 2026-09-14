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
 * This class is a wrapper for {@link PersonalAccidentPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see PersonalAccidentPremi
 * @generated
 */
public class PersonalAccidentPremiWrapper
	extends BaseModelWrapper<PersonalAccidentPremi>
	implements ModelWrapper<PersonalAccidentPremi>, PersonalAccidentPremi {

	public PersonalAccidentPremiWrapper(
		PersonalAccidentPremi personalAccidentPremi) {

		super(personalAccidentPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personalAccidentPremiId", getPersonalAccidentPremiId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("premiType", getPremiType());
		attributes.put("amount", getAmount());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personalAccidentPremiId = (Long)attributes.get(
			"personalAccidentPremiId");

		if (personalAccidentPremiId != null) {
			setPersonalAccidentPremiId(personalAccidentPremiId);
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

		String premiType = (String)attributes.get("premiType");

		if (premiType != null) {
			setPremiType(premiType);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this personal accident premi.
	 *
	 * @return the active of this personal accident premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this personal accident premi.
	 *
	 * @return the amount of this personal accident premi
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this personal accident premi.
	 *
	 * @return the company ID of this personal accident premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this personal accident premi.
	 *
	 * @return the create date of this personal accident premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this personal accident premi.
	 *
	 * @return the group ID of this personal accident premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this personal accident premi.
	 *
	 * @return the modified date of this personal accident premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal accident premi ID of this personal accident premi.
	 *
	 * @return the personal accident premi ID of this personal accident premi
	 */
	@Override
	public long getPersonalAccidentPremiId() {
		return model.getPersonalAccidentPremiId();
	}

	/**
	 * Returns the premi type of this personal accident premi.
	 *
	 * @return the premi type of this personal accident premi
	 */
	@Override
	public String getPremiType() {
		return model.getPremiType();
	}

	/**
	 * Returns the primary key of this personal accident premi.
	 *
	 * @return the primary key of this personal accident premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this personal accident premi.
	 *
	 * @return the user ID of this personal accident premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this personal accident premi.
	 *
	 * @return the user name of this personal accident premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this personal accident premi.
	 *
	 * @return the user uuid of this personal accident premi
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
	 * Sets the active of this personal accident premi.
	 *
	 * @param active the active of this personal accident premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this personal accident premi.
	 *
	 * @param amount the amount of this personal accident premi
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this personal accident premi.
	 *
	 * @param companyId the company ID of this personal accident premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this personal accident premi.
	 *
	 * @param createDate the create date of this personal accident premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this personal accident premi.
	 *
	 * @param groupId the group ID of this personal accident premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this personal accident premi.
	 *
	 * @param modifiedDate the modified date of this personal accident premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal accident premi ID of this personal accident premi.
	 *
	 * @param personalAccidentPremiId the personal accident premi ID of this personal accident premi
	 */
	@Override
	public void setPersonalAccidentPremiId(long personalAccidentPremiId) {
		model.setPersonalAccidentPremiId(personalAccidentPremiId);
	}

	/**
	 * Sets the premi type of this personal accident premi.
	 *
	 * @param premiType the premi type of this personal accident premi
	 */
	@Override
	public void setPremiType(String premiType) {
		model.setPremiType(premiType);
	}

	/**
	 * Sets the primary key of this personal accident premi.
	 *
	 * @param primaryKey the primary key of this personal accident premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this personal accident premi.
	 *
	 * @param userId the user ID of this personal accident premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this personal accident premi.
	 *
	 * @param userName the user name of this personal accident premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this personal accident premi.
	 *
	 * @param userUuid the user uuid of this personal accident premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PersonalAccidentPremiWrapper wrap(
		PersonalAccidentPremi personalAccidentPremi) {

		return new PersonalAccidentPremiWrapper(personalAccidentPremi);
	}

}