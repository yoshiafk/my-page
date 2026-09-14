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
 * This class is a wrapper for {@link SmartHealthPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthPremi
 * @generated
 */
public class SmartHealthPremiWrapper
	extends BaseModelWrapper<SmartHealthPremi>
	implements ModelWrapper<SmartHealthPremi>, SmartHealthPremi {

	public SmartHealthPremiWrapper(SmartHealthPremi smartHealthPremi) {
		super(smartHealthPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartHealthPremiId", getSmartHealthPremiId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("age", getAge());
		attributes.put("gender", getGender());
		attributes.put("currency", getCurrency());
		attributes.put("amount", getAmount());
		attributes.put("planId", getPlanId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long smartHealthPremiId = (Long)attributes.get("smartHealthPremiId");

		if (smartHealthPremiId != null) {
			setSmartHealthPremiId(smartHealthPremiId);
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

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long planId = (Long)attributes.get("planId");

		if (planId != null) {
			setPlanId(planId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the age of this smart health premi.
	 *
	 * @return the age of this smart health premi
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the amount of this smart health premi.
	 *
	 * @return the amount of this smart health premi
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this smart health premi.
	 *
	 * @return the company ID of this smart health premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart health premi.
	 *
	 * @return the create date of this smart health premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this smart health premi.
	 *
	 * @return the currency of this smart health premi
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the gender of this smart health premi.
	 *
	 * @return the gender of this smart health premi
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this smart health premi.
	 *
	 * @return the group ID of this smart health premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart health premi.
	 *
	 * @return the modified date of this smart health premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan ID of this smart health premi.
	 *
	 * @return the plan ID of this smart health premi
	 */
	@Override
	public long getPlanId() {
		return model.getPlanId();
	}

	/**
	 * Returns the primary key of this smart health premi.
	 *
	 * @return the primary key of this smart health premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart health premi ID of this smart health premi.
	 *
	 * @return the smart health premi ID of this smart health premi
	 */
	@Override
	public long getSmartHealthPremiId() {
		return model.getSmartHealthPremiId();
	}

	/**
	 * Returns the status of this smart health premi.
	 *
	 * @return the status of this smart health premi
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this smart health premi.
	 *
	 * @return the user ID of this smart health premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart health premi.
	 *
	 * @return the user name of this smart health premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart health premi.
	 *
	 * @return the user uuid of this smart health premi
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
	 * Sets the age of this smart health premi.
	 *
	 * @param age the age of this smart health premi
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the amount of this smart health premi.
	 *
	 * @param amount the amount of this smart health premi
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this smart health premi.
	 *
	 * @param companyId the company ID of this smart health premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart health premi.
	 *
	 * @param createDate the create date of this smart health premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this smart health premi.
	 *
	 * @param currency the currency of this smart health premi
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the gender of this smart health premi.
	 *
	 * @param gender the gender of this smart health premi
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this smart health premi.
	 *
	 * @param groupId the group ID of this smart health premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart health premi.
	 *
	 * @param modifiedDate the modified date of this smart health premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan ID of this smart health premi.
	 *
	 * @param planId the plan ID of this smart health premi
	 */
	@Override
	public void setPlanId(long planId) {
		model.setPlanId(planId);
	}

	/**
	 * Sets the primary key of this smart health premi.
	 *
	 * @param primaryKey the primary key of this smart health premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart health premi ID of this smart health premi.
	 *
	 * @param smartHealthPremiId the smart health premi ID of this smart health premi
	 */
	@Override
	public void setSmartHealthPremiId(long smartHealthPremiId) {
		model.setSmartHealthPremiId(smartHealthPremiId);
	}

	/**
	 * Sets the status of this smart health premi.
	 *
	 * @param status the status of this smart health premi
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this smart health premi.
	 *
	 * @param userId the user ID of this smart health premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart health premi.
	 *
	 * @param userName the user name of this smart health premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart health premi.
	 *
	 * @param userUuid the user uuid of this smart health premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartHealthPremiWrapper wrap(SmartHealthPremi smartHealthPremi) {
		return new SmartHealthPremiWrapper(smartHealthPremi);
	}

}