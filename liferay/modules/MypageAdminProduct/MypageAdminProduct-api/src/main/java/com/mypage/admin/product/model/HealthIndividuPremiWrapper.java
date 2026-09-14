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
 * This class is a wrapper for {@link HealthIndividuPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see HealthIndividuPremi
 * @generated
 */
public class HealthIndividuPremiWrapper
	extends BaseModelWrapper<HealthIndividuPremi>
	implements HealthIndividuPremi, ModelWrapper<HealthIndividuPremi> {

	public HealthIndividuPremiWrapper(HealthIndividuPremi healthIndividuPremi) {
		super(healthIndividuPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("healthIndividuPremiId", getHealthIndividuPremiId());
		attributes.put("planId", getPlanId());
		attributes.put("age", getAge());
		attributes.put("premi", getPremi());
		attributes.put("active", getActive());
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
		Long healthIndividuPremiId = (Long)attributes.get(
			"healthIndividuPremiId");

		if (healthIndividuPremiId != null) {
			setHealthIndividuPremiId(healthIndividuPremiId);
		}

		Long planId = (Long)attributes.get("planId");

		if (planId != null) {
			setPlanId(planId);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Long premi = (Long)attributes.get("premi");

		if (premi != null) {
			setPremi(premi);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	 * Returns the active of this health individu premi.
	 *
	 * @return the active of this health individu premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the age of this health individu premi.
	 *
	 * @return the age of this health individu premi
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the company ID of this health individu premi.
	 *
	 * @return the company ID of this health individu premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this health individu premi.
	 *
	 * @return the create date of this health individu premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this health individu premi.
	 *
	 * @return the group ID of this health individu premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health individu premi ID of this health individu premi.
	 *
	 * @return the health individu premi ID of this health individu premi
	 */
	@Override
	public long getHealthIndividuPremiId() {
		return model.getHealthIndividuPremiId();
	}

	/**
	 * Returns the modified date of this health individu premi.
	 *
	 * @return the modified date of this health individu premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan ID of this health individu premi.
	 *
	 * @return the plan ID of this health individu premi
	 */
	@Override
	public long getPlanId() {
		return model.getPlanId();
	}

	/**
	 * Returns the premi of this health individu premi.
	 *
	 * @return the premi of this health individu premi
	 */
	@Override
	public long getPremi() {
		return model.getPremi();
	}

	/**
	 * Returns the primary key of this health individu premi.
	 *
	 * @return the primary key of this health individu premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this health individu premi.
	 *
	 * @return the user ID of this health individu premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this health individu premi.
	 *
	 * @return the user name of this health individu premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this health individu premi.
	 *
	 * @return the user uuid of this health individu premi
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
	 * Sets the active of this health individu premi.
	 *
	 * @param active the active of this health individu premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the age of this health individu premi.
	 *
	 * @param age the age of this health individu premi
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the company ID of this health individu premi.
	 *
	 * @param companyId the company ID of this health individu premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this health individu premi.
	 *
	 * @param createDate the create date of this health individu premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this health individu premi.
	 *
	 * @param groupId the group ID of this health individu premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health individu premi ID of this health individu premi.
	 *
	 * @param healthIndividuPremiId the health individu premi ID of this health individu premi
	 */
	@Override
	public void setHealthIndividuPremiId(long healthIndividuPremiId) {
		model.setHealthIndividuPremiId(healthIndividuPremiId);
	}

	/**
	 * Sets the modified date of this health individu premi.
	 *
	 * @param modifiedDate the modified date of this health individu premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan ID of this health individu premi.
	 *
	 * @param planId the plan ID of this health individu premi
	 */
	@Override
	public void setPlanId(long planId) {
		model.setPlanId(planId);
	}

	/**
	 * Sets the premi of this health individu premi.
	 *
	 * @param premi the premi of this health individu premi
	 */
	@Override
	public void setPremi(long premi) {
		model.setPremi(premi);
	}

	/**
	 * Sets the primary key of this health individu premi.
	 *
	 * @param primaryKey the primary key of this health individu premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this health individu premi.
	 *
	 * @param userId the user ID of this health individu premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this health individu premi.
	 *
	 * @param userName the user name of this health individu premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this health individu premi.
	 *
	 * @param userUuid the user uuid of this health individu premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected HealthIndividuPremiWrapper wrap(
		HealthIndividuPremi healthIndividuPremi) {

		return new HealthIndividuPremiWrapper(healthIndividuPremi);
	}

}