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
 * This class is a wrapper for {@link SmartActiveToproBenefitMapping}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveToproBenefitMapping
 * @generated
 */
public class SmartActiveToproBenefitMappingWrapper
	extends BaseModelWrapper<SmartActiveToproBenefitMapping>
	implements ModelWrapper<SmartActiveToproBenefitMapping>,
			   SmartActiveToproBenefitMapping {

	public SmartActiveToproBenefitMappingWrapper(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		super(smartActiveToproBenefitMapping);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"smartActiveToproBenefitMappingId",
			getSmartActiveToproBenefitMappingId());
		attributes.put("smartActiveToproId", getSmartActiveToproId());
		attributes.put("ListBenefitId", getListBenefitId());
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
		Long smartActiveToproBenefitMappingId = (Long)attributes.get(
			"smartActiveToproBenefitMappingId");

		if (smartActiveToproBenefitMappingId != null) {
			setSmartActiveToproBenefitMappingId(
				smartActiveToproBenefitMappingId);
		}

		Long smartActiveToproId = (Long)attributes.get("smartActiveToproId");

		if (smartActiveToproId != null) {
			setSmartActiveToproId(smartActiveToproId);
		}

		String ListBenefitId = (String)attributes.get("ListBenefitId");

		if (ListBenefitId != null) {
			setListBenefitId(ListBenefitId);
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
	 * Returns the active of this smart active topro benefit mapping.
	 *
	 * @return the active of this smart active topro benefit mapping
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart active topro benefit mapping.
	 *
	 * @return the company ID of this smart active topro benefit mapping
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active topro benefit mapping.
	 *
	 * @return the create date of this smart active topro benefit mapping
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart active topro benefit mapping.
	 *
	 * @return the group ID of this smart active topro benefit mapping
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the list benefit ID of this smart active topro benefit mapping.
	 *
	 * @return the list benefit ID of this smart active topro benefit mapping
	 */
	@Override
	public String getListBenefitId() {
		return model.getListBenefitId();
	}

	/**
	 * Returns the modified date of this smart active topro benefit mapping.
	 *
	 * @return the modified date of this smart active topro benefit mapping
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart active topro benefit mapping.
	 *
	 * @return the primary key of this smart active topro benefit mapping
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active topro benefit mapping ID of this smart active topro benefit mapping.
	 *
	 * @return the smart active topro benefit mapping ID of this smart active topro benefit mapping
	 */
	@Override
	public long getSmartActiveToproBenefitMappingId() {
		return model.getSmartActiveToproBenefitMappingId();
	}

	/**
	 * Returns the smart active topro ID of this smart active topro benefit mapping.
	 *
	 * @return the smart active topro ID of this smart active topro benefit mapping
	 */
	@Override
	public long getSmartActiveToproId() {
		return model.getSmartActiveToproId();
	}

	/**
	 * Returns the user ID of this smart active topro benefit mapping.
	 *
	 * @return the user ID of this smart active topro benefit mapping
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active topro benefit mapping.
	 *
	 * @return the user name of this smart active topro benefit mapping
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active topro benefit mapping.
	 *
	 * @return the user uuid of this smart active topro benefit mapping
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
	 * Sets the active of this smart active topro benefit mapping.
	 *
	 * @param active the active of this smart active topro benefit mapping
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart active topro benefit mapping.
	 *
	 * @param companyId the company ID of this smart active topro benefit mapping
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active topro benefit mapping.
	 *
	 * @param createDate the create date of this smart active topro benefit mapping
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart active topro benefit mapping.
	 *
	 * @param groupId the group ID of this smart active topro benefit mapping
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the list benefit ID of this smart active topro benefit mapping.
	 *
	 * @param ListBenefitId the list benefit ID of this smart active topro benefit mapping
	 */
	@Override
	public void setListBenefitId(String ListBenefitId) {
		model.setListBenefitId(ListBenefitId);
	}

	/**
	 * Sets the modified date of this smart active topro benefit mapping.
	 *
	 * @param modifiedDate the modified date of this smart active topro benefit mapping
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart active topro benefit mapping.
	 *
	 * @param primaryKey the primary key of this smart active topro benefit mapping
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active topro benefit mapping ID of this smart active topro benefit mapping.
	 *
	 * @param smartActiveToproBenefitMappingId the smart active topro benefit mapping ID of this smart active topro benefit mapping
	 */
	@Override
	public void setSmartActiveToproBenefitMappingId(
		long smartActiveToproBenefitMappingId) {

		model.setSmartActiveToproBenefitMappingId(
			smartActiveToproBenefitMappingId);
	}

	/**
	 * Sets the smart active topro ID of this smart active topro benefit mapping.
	 *
	 * @param smartActiveToproId the smart active topro ID of this smart active topro benefit mapping
	 */
	@Override
	public void setSmartActiveToproId(long smartActiveToproId) {
		model.setSmartActiveToproId(smartActiveToproId);
	}

	/**
	 * Sets the user ID of this smart active topro benefit mapping.
	 *
	 * @param userId the user ID of this smart active topro benefit mapping
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active topro benefit mapping.
	 *
	 * @param userName the user name of this smart active topro benefit mapping
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active topro benefit mapping.
	 *
	 * @param userUuid the user uuid of this smart active topro benefit mapping
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActiveToproBenefitMappingWrapper wrap(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		return new SmartActiveToproBenefitMappingWrapper(
			smartActiveToproBenefitMapping);
	}

}