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
 * This class is a wrapper for {@link HealthSmeType}.
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeType
 * @generated
 */
public class HealthSmeTypeWrapper
	extends BaseModelWrapper<HealthSmeType>
	implements HealthSmeType, ModelWrapper<HealthSmeType> {

	public HealthSmeTypeWrapper(HealthSmeType healthSmeType) {
		super(healthSmeType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("healthSmeTypeId", getHealthSmeTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typeName", getTypeName());
		attributes.put("typeCode", getTypeCode());
		attributes.put("typeDescription", getTypeDescription());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long healthSmeTypeId = (Long)attributes.get("healthSmeTypeId");

		if (healthSmeTypeId != null) {
			setHealthSmeTypeId(healthSmeTypeId);
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

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}

		String typeCode = (String)attributes.get("typeCode");

		if (typeCode != null) {
			setTypeCode(typeCode);
		}

		String typeDescription = (String)attributes.get("typeDescription");

		if (typeDescription != null) {
			setTypeDescription(typeDescription);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this health sme type.
	 *
	 * @return the active of this health sme type
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this health sme type.
	 *
	 * @return the company ID of this health sme type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this health sme type.
	 *
	 * @return the create date of this health sme type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this health sme type.
	 *
	 * @return the group ID of this health sme type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health sme type ID of this health sme type.
	 *
	 * @return the health sme type ID of this health sme type
	 */
	@Override
	public long getHealthSmeTypeId() {
		return model.getHealthSmeTypeId();
	}

	/**
	 * Returns the modified date of this health sme type.
	 *
	 * @return the modified date of this health sme type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this health sme type.
	 *
	 * @return the primary key of this health sme type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type code of this health sme type.
	 *
	 * @return the type code of this health sme type
	 */
	@Override
	public String getTypeCode() {
		return model.getTypeCode();
	}

	/**
	 * Returns the type description of this health sme type.
	 *
	 * @return the type description of this health sme type
	 */
	@Override
	public String getTypeDescription() {
		return model.getTypeDescription();
	}

	/**
	 * Returns the type name of this health sme type.
	 *
	 * @return the type name of this health sme type
	 */
	@Override
	public String getTypeName() {
		return model.getTypeName();
	}

	/**
	 * Returns the user ID of this health sme type.
	 *
	 * @return the user ID of this health sme type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this health sme type.
	 *
	 * @return the user name of this health sme type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this health sme type.
	 *
	 * @return the user uuid of this health sme type
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
	 * Sets the active of this health sme type.
	 *
	 * @param active the active of this health sme type
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this health sme type.
	 *
	 * @param companyId the company ID of this health sme type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this health sme type.
	 *
	 * @param createDate the create date of this health sme type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this health sme type.
	 *
	 * @param groupId the group ID of this health sme type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health sme type ID of this health sme type.
	 *
	 * @param healthSmeTypeId the health sme type ID of this health sme type
	 */
	@Override
	public void setHealthSmeTypeId(long healthSmeTypeId) {
		model.setHealthSmeTypeId(healthSmeTypeId);
	}

	/**
	 * Sets the modified date of this health sme type.
	 *
	 * @param modifiedDate the modified date of this health sme type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this health sme type.
	 *
	 * @param primaryKey the primary key of this health sme type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type code of this health sme type.
	 *
	 * @param typeCode the type code of this health sme type
	 */
	@Override
	public void setTypeCode(String typeCode) {
		model.setTypeCode(typeCode);
	}

	/**
	 * Sets the type description of this health sme type.
	 *
	 * @param typeDescription the type description of this health sme type
	 */
	@Override
	public void setTypeDescription(String typeDescription) {
		model.setTypeDescription(typeDescription);
	}

	/**
	 * Sets the type name of this health sme type.
	 *
	 * @param typeName the type name of this health sme type
	 */
	@Override
	public void setTypeName(String typeName) {
		model.setTypeName(typeName);
	}

	/**
	 * Sets the user ID of this health sme type.
	 *
	 * @param userId the user ID of this health sme type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this health sme type.
	 *
	 * @param userName the user name of this health sme type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this health sme type.
	 *
	 * @param userUuid the user uuid of this health sme type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected HealthSmeTypeWrapper wrap(HealthSmeType healthSmeType) {
		return new HealthSmeTypeWrapper(healthSmeType);
	}

}