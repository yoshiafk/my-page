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
 * This class is a wrapper for {@link TravelIntBenefitValue}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelIntBenefitValue
 * @generated
 */
public class TravelIntBenefitValueWrapper
	extends BaseModelWrapper<TravelIntBenefitValue>
	implements ModelWrapper<TravelIntBenefitValue>, TravelIntBenefitValue {

	public TravelIntBenefitValueWrapper(
		TravelIntBenefitValue travelIntBenefitValue) {

		super(travelIntBenefitValue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("travelIntBenefitValueId", getTravelIntBenefitValueId());
		attributes.put("travelIntBenefitId", getTravelIntBenefitId());
		attributes.put("currencyName", getCurrencyName());
		attributes.put("packageType", getPackageType());
		attributes.put("benefitValue", getBenefitValue());
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
		Long travelIntBenefitValueId = (Long)attributes.get(
			"travelIntBenefitValueId");

		if (travelIntBenefitValueId != null) {
			setTravelIntBenefitValueId(travelIntBenefitValueId);
		}

		Long travelIntBenefitId = (Long)attributes.get("travelIntBenefitId");

		if (travelIntBenefitId != null) {
			setTravelIntBenefitId(travelIntBenefitId);
		}

		String currencyName = (String)attributes.get("currencyName");

		if (currencyName != null) {
			setCurrencyName(currencyName);
		}

		String packageType = (String)attributes.get("packageType");

		if (packageType != null) {
			setPackageType(packageType);
		}

		String benefitValue = (String)attributes.get("benefitValue");

		if (benefitValue != null) {
			setBenefitValue(benefitValue);
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
	 * Returns the active of this travel int benefit value.
	 *
	 * @return the active of this travel int benefit value
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit value of this travel int benefit value.
	 *
	 * @return the benefit value of this travel int benefit value
	 */
	@Override
	public String getBenefitValue() {
		return model.getBenefitValue();
	}

	/**
	 * Returns the company ID of this travel int benefit value.
	 *
	 * @return the company ID of this travel int benefit value
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel int benefit value.
	 *
	 * @return the create date of this travel int benefit value
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency name of this travel int benefit value.
	 *
	 * @return the currency name of this travel int benefit value
	 */
	@Override
	public String getCurrencyName() {
		return model.getCurrencyName();
	}

	/**
	 * Returns the group ID of this travel int benefit value.
	 *
	 * @return the group ID of this travel int benefit value
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this travel int benefit value.
	 *
	 * @return the modified date of this travel int benefit value
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the package type of this travel int benefit value.
	 *
	 * @return the package type of this travel int benefit value
	 */
	@Override
	public String getPackageType() {
		return model.getPackageType();
	}

	/**
	 * Returns the primary key of this travel int benefit value.
	 *
	 * @return the primary key of this travel int benefit value
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the travel int benefit ID of this travel int benefit value.
	 *
	 * @return the travel int benefit ID of this travel int benefit value
	 */
	@Override
	public long getTravelIntBenefitId() {
		return model.getTravelIntBenefitId();
	}

	/**
	 * Returns the travel int benefit value ID of this travel int benefit value.
	 *
	 * @return the travel int benefit value ID of this travel int benefit value
	 */
	@Override
	public long getTravelIntBenefitValueId() {
		return model.getTravelIntBenefitValueId();
	}

	/**
	 * Returns the user ID of this travel int benefit value.
	 *
	 * @return the user ID of this travel int benefit value
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel int benefit value.
	 *
	 * @return the user name of this travel int benefit value
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel int benefit value.
	 *
	 * @return the user uuid of this travel int benefit value
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
	 * Sets the active of this travel int benefit value.
	 *
	 * @param active the active of this travel int benefit value
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit value of this travel int benefit value.
	 *
	 * @param benefitValue the benefit value of this travel int benefit value
	 */
	@Override
	public void setBenefitValue(String benefitValue) {
		model.setBenefitValue(benefitValue);
	}

	/**
	 * Sets the company ID of this travel int benefit value.
	 *
	 * @param companyId the company ID of this travel int benefit value
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel int benefit value.
	 *
	 * @param createDate the create date of this travel int benefit value
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency name of this travel int benefit value.
	 *
	 * @param currencyName the currency name of this travel int benefit value
	 */
	@Override
	public void setCurrencyName(String currencyName) {
		model.setCurrencyName(currencyName);
	}

	/**
	 * Sets the group ID of this travel int benefit value.
	 *
	 * @param groupId the group ID of this travel int benefit value
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this travel int benefit value.
	 *
	 * @param modifiedDate the modified date of this travel int benefit value
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the package type of this travel int benefit value.
	 *
	 * @param packageType the package type of this travel int benefit value
	 */
	@Override
	public void setPackageType(String packageType) {
		model.setPackageType(packageType);
	}

	/**
	 * Sets the primary key of this travel int benefit value.
	 *
	 * @param primaryKey the primary key of this travel int benefit value
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the travel int benefit ID of this travel int benefit value.
	 *
	 * @param travelIntBenefitId the travel int benefit ID of this travel int benefit value
	 */
	@Override
	public void setTravelIntBenefitId(long travelIntBenefitId) {
		model.setTravelIntBenefitId(travelIntBenefitId);
	}

	/**
	 * Sets the travel int benefit value ID of this travel int benefit value.
	 *
	 * @param travelIntBenefitValueId the travel int benefit value ID of this travel int benefit value
	 */
	@Override
	public void setTravelIntBenefitValueId(long travelIntBenefitValueId) {
		model.setTravelIntBenefitValueId(travelIntBenefitValueId);
	}

	/**
	 * Sets the user ID of this travel int benefit value.
	 *
	 * @param userId the user ID of this travel int benefit value
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel int benefit value.
	 *
	 * @param userName the user name of this travel int benefit value
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel int benefit value.
	 *
	 * @param userUuid the user uuid of this travel int benefit value
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelIntBenefitValueWrapper wrap(
		TravelIntBenefitValue travelIntBenefitValue) {

		return new TravelIntBenefitValueWrapper(travelIntBenefitValue);
	}

}