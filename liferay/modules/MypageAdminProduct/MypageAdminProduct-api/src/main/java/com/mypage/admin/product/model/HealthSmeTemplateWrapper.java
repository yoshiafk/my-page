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
 * This class is a wrapper for {@link HealthSmeTemplate}.
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeTemplate
 * @generated
 */
public class HealthSmeTemplateWrapper
	extends BaseModelWrapper<HealthSmeTemplate>
	implements HealthSmeTemplate, ModelWrapper<HealthSmeTemplate> {

	public HealthSmeTemplateWrapper(HealthSmeTemplate healthSmeTemplate) {
		super(healthSmeTemplate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("healthSmeTemplateId", getHealthSmeTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("amount", getAmount());
		attributes.put("annualLimit", getAnnualLimit());
		attributes.put("healthSmeTypeId", getHealthSmeTypeId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long healthSmeTemplateId = (Long)attributes.get("healthSmeTemplateId");

		if (healthSmeTemplateId != null) {
			setHealthSmeTemplateId(healthSmeTemplateId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long annualLimit = (Long)attributes.get("annualLimit");

		if (annualLimit != null) {
			setAnnualLimit(annualLimit);
		}

		Long healthSmeTypeId = (Long)attributes.get("healthSmeTypeId");

		if (healthSmeTypeId != null) {
			setHealthSmeTypeId(healthSmeTypeId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this health sme template.
	 *
	 * @return the active of this health sme template
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this health sme template.
	 *
	 * @return the amount of this health sme template
	 */
	@Override
	public long getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the annual limit of this health sme template.
	 *
	 * @return the annual limit of this health sme template
	 */
	@Override
	public long getAnnualLimit() {
		return model.getAnnualLimit();
	}

	/**
	 * Returns the code of this health sme template.
	 *
	 * @return the code of this health sme template
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this health sme template.
	 *
	 * @return the company ID of this health sme template
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this health sme template.
	 *
	 * @return the create date of this health sme template
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this health sme template.
	 *
	 * @return the description of this health sme template
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this health sme template.
	 *
	 * @return the group ID of this health sme template
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health sme template ID of this health sme template.
	 *
	 * @return the health sme template ID of this health sme template
	 */
	@Override
	public long getHealthSmeTemplateId() {
		return model.getHealthSmeTemplateId();
	}

	/**
	 * Returns the health sme type ID of this health sme template.
	 *
	 * @return the health sme type ID of this health sme template
	 */
	@Override
	public long getHealthSmeTypeId() {
		return model.getHealthSmeTypeId();
	}

	/**
	 * Returns the modified date of this health sme template.
	 *
	 * @return the modified date of this health sme template
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this health sme template.
	 *
	 * @return the name of this health sme template
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this health sme template.
	 *
	 * @return the primary key of this health sme template
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this health sme template.
	 *
	 * @return the user ID of this health sme template
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this health sme template.
	 *
	 * @return the user name of this health sme template
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this health sme template.
	 *
	 * @return the user uuid of this health sme template
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
	 * Sets the active of this health sme template.
	 *
	 * @param active the active of this health sme template
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this health sme template.
	 *
	 * @param amount the amount of this health sme template
	 */
	@Override
	public void setAmount(long amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the annual limit of this health sme template.
	 *
	 * @param annualLimit the annual limit of this health sme template
	 */
	@Override
	public void setAnnualLimit(long annualLimit) {
		model.setAnnualLimit(annualLimit);
	}

	/**
	 * Sets the code of this health sme template.
	 *
	 * @param code the code of this health sme template
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this health sme template.
	 *
	 * @param companyId the company ID of this health sme template
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this health sme template.
	 *
	 * @param createDate the create date of this health sme template
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this health sme template.
	 *
	 * @param description the description of this health sme template
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this health sme template.
	 *
	 * @param groupId the group ID of this health sme template
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health sme template ID of this health sme template.
	 *
	 * @param healthSmeTemplateId the health sme template ID of this health sme template
	 */
	@Override
	public void setHealthSmeTemplateId(long healthSmeTemplateId) {
		model.setHealthSmeTemplateId(healthSmeTemplateId);
	}

	/**
	 * Sets the health sme type ID of this health sme template.
	 *
	 * @param healthSmeTypeId the health sme type ID of this health sme template
	 */
	@Override
	public void setHealthSmeTypeId(long healthSmeTypeId) {
		model.setHealthSmeTypeId(healthSmeTypeId);
	}

	/**
	 * Sets the modified date of this health sme template.
	 *
	 * @param modifiedDate the modified date of this health sme template
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this health sme template.
	 *
	 * @param name the name of this health sme template
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this health sme template.
	 *
	 * @param primaryKey the primary key of this health sme template
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this health sme template.
	 *
	 * @param userId the user ID of this health sme template
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this health sme template.
	 *
	 * @param userName the user name of this health sme template
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this health sme template.
	 *
	 * @param userUuid the user uuid of this health sme template
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected HealthSmeTemplateWrapper wrap(
		HealthSmeTemplate healthSmeTemplate) {

		return new HealthSmeTemplateWrapper(healthSmeTemplate);
	}

}