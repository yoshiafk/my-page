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
 * This class is a wrapper for {@link MasterProvince}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterProvince
 * @generated
 */
public class MasterProvinceWrapper
	extends BaseModelWrapper<MasterProvince>
	implements MasterProvince, ModelWrapper<MasterProvince> {

	public MasterProvinceWrapper(MasterProvince masterProvince) {
		super(masterProvince);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterProvinceId", getMasterProvinceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("countryId", getCountryId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterProvinceId = (Long)attributes.get("masterProvinceId");

		if (masterProvinceId != null) {
			setMasterProvinceId(masterProvinceId);
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

		Integer countryId = (Integer)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this master province.
	 *
	 * @return the active of this master province
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this master province.
	 *
	 * @return the company ID of this master province
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country ID of this master province.
	 *
	 * @return the country ID of this master province
	 */
	@Override
	public Integer getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this master province.
	 *
	 * @return the create date of this master province
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master province.
	 *
	 * @return the group ID of this master province
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the master province ID of this master province.
	 *
	 * @return the master province ID of this master province
	 */
	@Override
	public long getMasterProvinceId() {
		return model.getMasterProvinceId();
	}

	/**
	 * Returns the modified date of this master province.
	 *
	 * @return the modified date of this master province
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master province.
	 *
	 * @return the name of this master province
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master province.
	 *
	 * @return the primary key of this master province
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master province.
	 *
	 * @return the user ID of this master province
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master province.
	 *
	 * @return the user name of this master province
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master province.
	 *
	 * @return the user uuid of this master province
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
	 * Sets the active of this master province.
	 *
	 * @param active the active of this master province
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this master province.
	 *
	 * @param companyId the company ID of this master province
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country ID of this master province.
	 *
	 * @param countryId the country ID of this master province
	 */
	@Override
	public void setCountryId(Integer countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this master province.
	 *
	 * @param createDate the create date of this master province
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master province.
	 *
	 * @param groupId the group ID of this master province
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the master province ID of this master province.
	 *
	 * @param masterProvinceId the master province ID of this master province
	 */
	@Override
	public void setMasterProvinceId(long masterProvinceId) {
		model.setMasterProvinceId(masterProvinceId);
	}

	/**
	 * Sets the modified date of this master province.
	 *
	 * @param modifiedDate the modified date of this master province
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master province.
	 *
	 * @param name the name of this master province
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master province.
	 *
	 * @param primaryKey the primary key of this master province
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master province.
	 *
	 * @param userId the user ID of this master province
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master province.
	 *
	 * @param userName the user name of this master province
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master province.
	 *
	 * @param userUuid the user uuid of this master province
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterProvinceWrapper wrap(MasterProvince masterProvince) {
		return new MasterProvinceWrapper(masterProvince);
	}

}