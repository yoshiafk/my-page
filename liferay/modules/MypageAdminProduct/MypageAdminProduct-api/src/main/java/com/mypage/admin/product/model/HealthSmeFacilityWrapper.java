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
 * This class is a wrapper for {@link HealthSmeFacility}.
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeFacility
 * @generated
 */
public class HealthSmeFacilityWrapper
	extends BaseModelWrapper<HealthSmeFacility>
	implements HealthSmeFacility, ModelWrapper<HealthSmeFacility> {

	public HealthSmeFacilityWrapper(HealthSmeFacility healthSmeFacility) {
		super(healthSmeFacility);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("healthSmeFacilityId", getHealthSmeFacilityId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("healthSmeTypeId", getHealthSmeTypeId());
		attributes.put("defaultMinimum", getDefaultMinimum());
		attributes.put("minimum", getMinimum());
		attributes.put("defaultNormal", getDefaultNormal());
		attributes.put("normal", getNormal());
		attributes.put("defaultMaximum", getDefaultMaximum());
		attributes.put("maximum", getMaximum());
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
		Long healthSmeFacilityId = (Long)attributes.get("healthSmeFacilityId");

		if (healthSmeFacilityId != null) {
			setHealthSmeFacilityId(healthSmeFacilityId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long healthSmeTypeId = (Long)attributes.get("healthSmeTypeId");

		if (healthSmeTypeId != null) {
			setHealthSmeTypeId(healthSmeTypeId);
		}

		Integer defaultMinimum = (Integer)attributes.get("defaultMinimum");

		if (defaultMinimum != null) {
			setDefaultMinimum(defaultMinimum);
		}

		Double minimum = (Double)attributes.get("minimum");

		if (minimum != null) {
			setMinimum(minimum);
		}

		Integer defaultNormal = (Integer)attributes.get("defaultNormal");

		if (defaultNormal != null) {
			setDefaultNormal(defaultNormal);
		}

		Double normal = (Double)attributes.get("normal");

		if (normal != null) {
			setNormal(normal);
		}

		Integer defaultMaximum = (Integer)attributes.get("defaultMaximum");

		if (defaultMaximum != null) {
			setDefaultMaximum(defaultMaximum);
		}

		Double maximum = (Double)attributes.get("maximum");

		if (maximum != null) {
			setMaximum(maximum);
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
	 * Returns the active of this health sme facility.
	 *
	 * @return the active of this health sme facility
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this health sme facility.
	 *
	 * @return the company ID of this health sme facility
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this health sme facility.
	 *
	 * @return the create date of this health sme facility
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the default maximum of this health sme facility.
	 *
	 * @return the default maximum of this health sme facility
	 */
	@Override
	public int getDefaultMaximum() {
		return model.getDefaultMaximum();
	}

	/**
	 * Returns the default minimum of this health sme facility.
	 *
	 * @return the default minimum of this health sme facility
	 */
	@Override
	public int getDefaultMinimum() {
		return model.getDefaultMinimum();
	}

	/**
	 * Returns the default normal of this health sme facility.
	 *
	 * @return the default normal of this health sme facility
	 */
	@Override
	public int getDefaultNormal() {
		return model.getDefaultNormal();
	}

	/**
	 * Returns the description of this health sme facility.
	 *
	 * @return the description of this health sme facility
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this health sme facility.
	 *
	 * @return the group ID of this health sme facility
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health sme facility ID of this health sme facility.
	 *
	 * @return the health sme facility ID of this health sme facility
	 */
	@Override
	public long getHealthSmeFacilityId() {
		return model.getHealthSmeFacilityId();
	}

	/**
	 * Returns the health sme type ID of this health sme facility.
	 *
	 * @return the health sme type ID of this health sme facility
	 */
	@Override
	public long getHealthSmeTypeId() {
		return model.getHealthSmeTypeId();
	}

	/**
	 * Returns the maximum of this health sme facility.
	 *
	 * @return the maximum of this health sme facility
	 */
	@Override
	public double getMaximum() {
		return model.getMaximum();
	}

	/**
	 * Returns the minimum of this health sme facility.
	 *
	 * @return the minimum of this health sme facility
	 */
	@Override
	public double getMinimum() {
		return model.getMinimum();
	}

	/**
	 * Returns the modified date of this health sme facility.
	 *
	 * @return the modified date of this health sme facility
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this health sme facility.
	 *
	 * @return the name of this health sme facility
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the normal of this health sme facility.
	 *
	 * @return the normal of this health sme facility
	 */
	@Override
	public double getNormal() {
		return model.getNormal();
	}

	/**
	 * Returns the primary key of this health sme facility.
	 *
	 * @return the primary key of this health sme facility
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this health sme facility.
	 *
	 * @return the user ID of this health sme facility
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this health sme facility.
	 *
	 * @return the user name of this health sme facility
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this health sme facility.
	 *
	 * @return the user uuid of this health sme facility
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
	 * Sets the active of this health sme facility.
	 *
	 * @param active the active of this health sme facility
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this health sme facility.
	 *
	 * @param companyId the company ID of this health sme facility
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this health sme facility.
	 *
	 * @param createDate the create date of this health sme facility
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the default maximum of this health sme facility.
	 *
	 * @param defaultMaximum the default maximum of this health sme facility
	 */
	@Override
	public void setDefaultMaximum(int defaultMaximum) {
		model.setDefaultMaximum(defaultMaximum);
	}

	/**
	 * Sets the default minimum of this health sme facility.
	 *
	 * @param defaultMinimum the default minimum of this health sme facility
	 */
	@Override
	public void setDefaultMinimum(int defaultMinimum) {
		model.setDefaultMinimum(defaultMinimum);
	}

	/**
	 * Sets the default normal of this health sme facility.
	 *
	 * @param defaultNormal the default normal of this health sme facility
	 */
	@Override
	public void setDefaultNormal(int defaultNormal) {
		model.setDefaultNormal(defaultNormal);
	}

	/**
	 * Sets the description of this health sme facility.
	 *
	 * @param description the description of this health sme facility
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this health sme facility.
	 *
	 * @param groupId the group ID of this health sme facility
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health sme facility ID of this health sme facility.
	 *
	 * @param healthSmeFacilityId the health sme facility ID of this health sme facility
	 */
	@Override
	public void setHealthSmeFacilityId(long healthSmeFacilityId) {
		model.setHealthSmeFacilityId(healthSmeFacilityId);
	}

	/**
	 * Sets the health sme type ID of this health sme facility.
	 *
	 * @param healthSmeTypeId the health sme type ID of this health sme facility
	 */
	@Override
	public void setHealthSmeTypeId(long healthSmeTypeId) {
		model.setHealthSmeTypeId(healthSmeTypeId);
	}

	/**
	 * Sets the maximum of this health sme facility.
	 *
	 * @param maximum the maximum of this health sme facility
	 */
	@Override
	public void setMaximum(double maximum) {
		model.setMaximum(maximum);
	}

	/**
	 * Sets the minimum of this health sme facility.
	 *
	 * @param minimum the minimum of this health sme facility
	 */
	@Override
	public void setMinimum(double minimum) {
		model.setMinimum(minimum);
	}

	/**
	 * Sets the modified date of this health sme facility.
	 *
	 * @param modifiedDate the modified date of this health sme facility
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this health sme facility.
	 *
	 * @param name the name of this health sme facility
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the normal of this health sme facility.
	 *
	 * @param normal the normal of this health sme facility
	 */
	@Override
	public void setNormal(double normal) {
		model.setNormal(normal);
	}

	/**
	 * Sets the primary key of this health sme facility.
	 *
	 * @param primaryKey the primary key of this health sme facility
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this health sme facility.
	 *
	 * @param userId the user ID of this health sme facility
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this health sme facility.
	 *
	 * @param userName the user name of this health sme facility
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this health sme facility.
	 *
	 * @param userUuid the user uuid of this health sme facility
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected HealthSmeFacilityWrapper wrap(
		HealthSmeFacility healthSmeFacility) {

		return new HealthSmeFacilityWrapper(healthSmeFacility);
	}

}