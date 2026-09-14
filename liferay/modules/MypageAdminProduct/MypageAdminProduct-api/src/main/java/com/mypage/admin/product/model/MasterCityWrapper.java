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
 * This class is a wrapper for {@link MasterCity}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterCity
 * @generated
 */
public class MasterCityWrapper
	extends BaseModelWrapper<MasterCity>
	implements MasterCity, ModelWrapper<MasterCity> {

	public MasterCityWrapper(MasterCity masterCity) {
		super(masterCity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterCityId", getMasterCityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("provinceId", getProvinceId());
		attributes.put("status", getStatus());
		attributes.put("parEarthquakeZone", getParEarthquakeZone());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterCityId = (Long)attributes.get("masterCityId");

		if (masterCityId != null) {
			setMasterCityId(masterCityId);
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

		Long provinceId = (Long)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer parEarthquakeZone = (Integer)attributes.get(
			"parEarthquakeZone");

		if (parEarthquakeZone != null) {
			setParEarthquakeZone(parEarthquakeZone);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this master city.
	 *
	 * @return the active of this master city
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this master city.
	 *
	 * @return the company ID of this master city
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master city.
	 *
	 * @return the create date of this master city
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master city.
	 *
	 * @return the group ID of this master city
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the master city ID of this master city.
	 *
	 * @return the master city ID of this master city
	 */
	@Override
	public long getMasterCityId() {
		return model.getMasterCityId();
	}

	/**
	 * Returns the modified date of this master city.
	 *
	 * @return the modified date of this master city
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master city.
	 *
	 * @return the name of this master city
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the par earthquake zone of this master city.
	 *
	 * @return the par earthquake zone of this master city
	 */
	@Override
	public Integer getParEarthquakeZone() {
		return model.getParEarthquakeZone();
	}

	/**
	 * Returns the primary key of this master city.
	 *
	 * @return the primary key of this master city
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the province ID of this master city.
	 *
	 * @return the province ID of this master city
	 */
	@Override
	public long getProvinceId() {
		return model.getProvinceId();
	}

	/**
	 * Returns the status of this master city.
	 *
	 * @return the status of this master city
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this master city.
	 *
	 * @return the user ID of this master city
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master city.
	 *
	 * @return the user name of this master city
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master city.
	 *
	 * @return the user uuid of this master city
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
	 * Sets the active of this master city.
	 *
	 * @param active the active of this master city
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this master city.
	 *
	 * @param companyId the company ID of this master city
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master city.
	 *
	 * @param createDate the create date of this master city
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master city.
	 *
	 * @param groupId the group ID of this master city
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the master city ID of this master city.
	 *
	 * @param masterCityId the master city ID of this master city
	 */
	@Override
	public void setMasterCityId(long masterCityId) {
		model.setMasterCityId(masterCityId);
	}

	/**
	 * Sets the modified date of this master city.
	 *
	 * @param modifiedDate the modified date of this master city
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master city.
	 *
	 * @param name the name of this master city
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the par earthquake zone of this master city.
	 *
	 * @param parEarthquakeZone the par earthquake zone of this master city
	 */
	@Override
	public void setParEarthquakeZone(Integer parEarthquakeZone) {
		model.setParEarthquakeZone(parEarthquakeZone);
	}

	/**
	 * Sets the primary key of this master city.
	 *
	 * @param primaryKey the primary key of this master city
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the province ID of this master city.
	 *
	 * @param provinceId the province ID of this master city
	 */
	@Override
	public void setProvinceId(long provinceId) {
		model.setProvinceId(provinceId);
	}

	/**
	 * Sets the status of this master city.
	 *
	 * @param status the status of this master city
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this master city.
	 *
	 * @param userId the user ID of this master city
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master city.
	 *
	 * @param userName the user name of this master city
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master city.
	 *
	 * @param userUuid the user uuid of this master city
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterCityWrapper wrap(MasterCity masterCity) {
		return new MasterCityWrapper(masterCity);
	}

}