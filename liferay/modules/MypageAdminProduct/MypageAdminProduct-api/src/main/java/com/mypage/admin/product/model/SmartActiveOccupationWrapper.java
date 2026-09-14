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
 * This class is a wrapper for {@link SmartActiveOccupation}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveOccupation
 * @generated
 */
public class SmartActiveOccupationWrapper
	extends BaseModelWrapper<SmartActiveOccupation>
	implements ModelWrapper<SmartActiveOccupation>, SmartActiveOccupation {

	public SmartActiveOccupationWrapper(
		SmartActiveOccupation smartActiveOccupation) {

		super(smartActiveOccupation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartActiveOccupationId", getSmartActiveOccupationId());
		attributes.put("code", getCode());
		attributes.put("nameId", getNameId());
		attributes.put("nameEn", getNameEn());
		attributes.put("active", getActive());
		attributes.put("smartActiveClassRateId", getSmartActiveClassRateId());
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
		Long smartActiveOccupationId = (Long)attributes.get(
			"smartActiveOccupationId");

		if (smartActiveOccupationId != null) {
			setSmartActiveOccupationId(smartActiveOccupationId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String nameId = (String)attributes.get("nameId");

		if (nameId != null) {
			setNameId(nameId);
		}

		String nameEn = (String)attributes.get("nameEn");

		if (nameEn != null) {
			setNameEn(nameEn);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long smartActiveClassRateId = (Long)attributes.get(
			"smartActiveClassRateId");

		if (smartActiveClassRateId != null) {
			setSmartActiveClassRateId(smartActiveClassRateId);
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
	 * Returns the active of this smart active occupation.
	 *
	 * @return the active of this smart active occupation
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this smart active occupation.
	 *
	 * @return the code of this smart active occupation
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this smart active occupation.
	 *
	 * @return the company ID of this smart active occupation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active occupation.
	 *
	 * @return the create date of this smart active occupation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart active occupation.
	 *
	 * @return the group ID of this smart active occupation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart active occupation.
	 *
	 * @return the modified date of this smart active occupation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name en of this smart active occupation.
	 *
	 * @return the name en of this smart active occupation
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the name ID of this smart active occupation.
	 *
	 * @return the name ID of this smart active occupation
	 */
	@Override
	public String getNameId() {
		return model.getNameId();
	}

	/**
	 * Returns the primary key of this smart active occupation.
	 *
	 * @return the primary key of this smart active occupation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active class rate ID of this smart active occupation.
	 *
	 * @return the smart active class rate ID of this smart active occupation
	 */
	@Override
	public long getSmartActiveClassRateId() {
		return model.getSmartActiveClassRateId();
	}

	/**
	 * Returns the smart active occupation ID of this smart active occupation.
	 *
	 * @return the smart active occupation ID of this smart active occupation
	 */
	@Override
	public long getSmartActiveOccupationId() {
		return model.getSmartActiveOccupationId();
	}

	/**
	 * Returns the user ID of this smart active occupation.
	 *
	 * @return the user ID of this smart active occupation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active occupation.
	 *
	 * @return the user name of this smart active occupation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active occupation.
	 *
	 * @return the user uuid of this smart active occupation
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
	 * Sets the active of this smart active occupation.
	 *
	 * @param active the active of this smart active occupation
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this smart active occupation.
	 *
	 * @param code the code of this smart active occupation
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this smart active occupation.
	 *
	 * @param companyId the company ID of this smart active occupation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active occupation.
	 *
	 * @param createDate the create date of this smart active occupation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart active occupation.
	 *
	 * @param groupId the group ID of this smart active occupation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart active occupation.
	 *
	 * @param modifiedDate the modified date of this smart active occupation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name en of this smart active occupation.
	 *
	 * @param nameEn the name en of this smart active occupation
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the name ID of this smart active occupation.
	 *
	 * @param nameId the name ID of this smart active occupation
	 */
	@Override
	public void setNameId(String nameId) {
		model.setNameId(nameId);
	}

	/**
	 * Sets the primary key of this smart active occupation.
	 *
	 * @param primaryKey the primary key of this smart active occupation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active class rate ID of this smart active occupation.
	 *
	 * @param smartActiveClassRateId the smart active class rate ID of this smart active occupation
	 */
	@Override
	public void setSmartActiveClassRateId(long smartActiveClassRateId) {
		model.setSmartActiveClassRateId(smartActiveClassRateId);
	}

	/**
	 * Sets the smart active occupation ID of this smart active occupation.
	 *
	 * @param smartActiveOccupationId the smart active occupation ID of this smart active occupation
	 */
	@Override
	public void setSmartActiveOccupationId(long smartActiveOccupationId) {
		model.setSmartActiveOccupationId(smartActiveOccupationId);
	}

	/**
	 * Sets the user ID of this smart active occupation.
	 *
	 * @param userId the user ID of this smart active occupation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active occupation.
	 *
	 * @param userName the user name of this smart active occupation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active occupation.
	 *
	 * @param userUuid the user uuid of this smart active occupation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActiveOccupationWrapper wrap(
		SmartActiveOccupation smartActiveOccupation) {

		return new SmartActiveOccupationWrapper(smartActiveOccupation);
	}

}