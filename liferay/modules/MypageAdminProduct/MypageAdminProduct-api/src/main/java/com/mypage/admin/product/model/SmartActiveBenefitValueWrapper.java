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
 * This class is a wrapper for {@link SmartActiveBenefitValue}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValue
 * @generated
 */
public class SmartActiveBenefitValueWrapper
	extends BaseModelWrapper<SmartActiveBenefitValue>
	implements ModelWrapper<SmartActiveBenefitValue>, SmartActiveBenefitValue {

	public SmartActiveBenefitValueWrapper(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		super(smartActiveBenefitValue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"smartActiveBenefitValueId", getSmartActiveBenefitValueId());
		attributes.put("value", getValue());
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
		Long smartActiveBenefitValueId = (Long)attributes.get(
			"smartActiveBenefitValueId");

		if (smartActiveBenefitValueId != null) {
			setSmartActiveBenefitValueId(smartActiveBenefitValueId);
		}

		Long value = (Long)attributes.get("value");

		if (value != null) {
			setValue(value);
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
	 * Returns the active of this smart active benefit value.
	 *
	 * @return the active of this smart active benefit value
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart active benefit value.
	 *
	 * @return the company ID of this smart active benefit value
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active benefit value.
	 *
	 * @return the create date of this smart active benefit value
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart active benefit value.
	 *
	 * @return the group ID of this smart active benefit value
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart active benefit value.
	 *
	 * @return the modified date of this smart active benefit value
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart active benefit value.
	 *
	 * @return the primary key of this smart active benefit value
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active benefit value ID of this smart active benefit value.
	 *
	 * @return the smart active benefit value ID of this smart active benefit value
	 */
	@Override
	public long getSmartActiveBenefitValueId() {
		return model.getSmartActiveBenefitValueId();
	}

	/**
	 * Returns the user ID of this smart active benefit value.
	 *
	 * @return the user ID of this smart active benefit value
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active benefit value.
	 *
	 * @return the user name of this smart active benefit value
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active benefit value.
	 *
	 * @return the user uuid of this smart active benefit value
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the value of this smart active benefit value.
	 *
	 * @return the value of this smart active benefit value
	 */
	@Override
	public long getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this smart active benefit value.
	 *
	 * @param active the active of this smart active benefit value
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart active benefit value.
	 *
	 * @param companyId the company ID of this smart active benefit value
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active benefit value.
	 *
	 * @param createDate the create date of this smart active benefit value
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart active benefit value.
	 *
	 * @param groupId the group ID of this smart active benefit value
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart active benefit value.
	 *
	 * @param modifiedDate the modified date of this smart active benefit value
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart active benefit value.
	 *
	 * @param primaryKey the primary key of this smart active benefit value
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active benefit value ID of this smart active benefit value.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID of this smart active benefit value
	 */
	@Override
	public void setSmartActiveBenefitValueId(long smartActiveBenefitValueId) {
		model.setSmartActiveBenefitValueId(smartActiveBenefitValueId);
	}

	/**
	 * Sets the user ID of this smart active benefit value.
	 *
	 * @param userId the user ID of this smart active benefit value
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active benefit value.
	 *
	 * @param userName the user name of this smart active benefit value
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active benefit value.
	 *
	 * @param userUuid the user uuid of this smart active benefit value
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the value of this smart active benefit value.
	 *
	 * @param value the value of this smart active benefit value
	 */
	@Override
	public void setValue(long value) {
		model.setValue(value);
	}

	@Override
	protected SmartActiveBenefitValueWrapper wrap(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		return new SmartActiveBenefitValueWrapper(smartActiveBenefitValue);
	}

}