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
 * This class is a wrapper for {@link SmartActiveClassRate}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveClassRate
 * @generated
 */
public class SmartActiveClassRateWrapper
	extends BaseModelWrapper<SmartActiveClassRate>
	implements ModelWrapper<SmartActiveClassRate>, SmartActiveClassRate {

	public SmartActiveClassRateWrapper(
		SmartActiveClassRate smartActiveClassRate) {

		super(smartActiveClassRate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartActiveClassRateId", getSmartActiveClassRateId());
		attributes.put("nameId", getNameId());
		attributes.put("nameEn", getNameEn());
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
		Long smartActiveClassRateId = (Long)attributes.get(
			"smartActiveClassRateId");

		if (smartActiveClassRateId != null) {
			setSmartActiveClassRateId(smartActiveClassRateId);
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
	 * Returns the active of this smart active class rate.
	 *
	 * @return the active of this smart active class rate
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart active class rate.
	 *
	 * @return the company ID of this smart active class rate
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active class rate.
	 *
	 * @return the create date of this smart active class rate
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart active class rate.
	 *
	 * @return the group ID of this smart active class rate
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart active class rate.
	 *
	 * @return the modified date of this smart active class rate
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name en of this smart active class rate.
	 *
	 * @return the name en of this smart active class rate
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the name ID of this smart active class rate.
	 *
	 * @return the name ID of this smart active class rate
	 */
	@Override
	public String getNameId() {
		return model.getNameId();
	}

	/**
	 * Returns the primary key of this smart active class rate.
	 *
	 * @return the primary key of this smart active class rate
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active class rate ID of this smart active class rate.
	 *
	 * @return the smart active class rate ID of this smart active class rate
	 */
	@Override
	public long getSmartActiveClassRateId() {
		return model.getSmartActiveClassRateId();
	}

	/**
	 * Returns the user ID of this smart active class rate.
	 *
	 * @return the user ID of this smart active class rate
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active class rate.
	 *
	 * @return the user name of this smart active class rate
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active class rate.
	 *
	 * @return the user uuid of this smart active class rate
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
	 * Sets the active of this smart active class rate.
	 *
	 * @param active the active of this smart active class rate
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart active class rate.
	 *
	 * @param companyId the company ID of this smart active class rate
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active class rate.
	 *
	 * @param createDate the create date of this smart active class rate
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart active class rate.
	 *
	 * @param groupId the group ID of this smart active class rate
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart active class rate.
	 *
	 * @param modifiedDate the modified date of this smart active class rate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name en of this smart active class rate.
	 *
	 * @param nameEn the name en of this smart active class rate
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the name ID of this smart active class rate.
	 *
	 * @param nameId the name ID of this smart active class rate
	 */
	@Override
	public void setNameId(String nameId) {
		model.setNameId(nameId);
	}

	/**
	 * Sets the primary key of this smart active class rate.
	 *
	 * @param primaryKey the primary key of this smart active class rate
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active class rate ID of this smart active class rate.
	 *
	 * @param smartActiveClassRateId the smart active class rate ID of this smart active class rate
	 */
	@Override
	public void setSmartActiveClassRateId(long smartActiveClassRateId) {
		model.setSmartActiveClassRateId(smartActiveClassRateId);
	}

	/**
	 * Sets the user ID of this smart active class rate.
	 *
	 * @param userId the user ID of this smart active class rate
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active class rate.
	 *
	 * @param userName the user name of this smart active class rate
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active class rate.
	 *
	 * @param userUuid the user uuid of this smart active class rate
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActiveClassRateWrapper wrap(
		SmartActiveClassRate smartActiveClassRate) {

		return new SmartActiveClassRateWrapper(smartActiveClassRate);
	}

}