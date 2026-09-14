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

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IntTravelStandardNewPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see IntTravelStandardNewPremi
 * @generated
 */
public class IntTravelStandardNewPremiWrapper
	extends BaseModelWrapper<IntTravelStandardNewPremi>
	implements IntTravelStandardNewPremi,
			   ModelWrapper<IntTravelStandardNewPremi> {

	public IntTravelStandardNewPremiWrapper(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		super(intTravelStandardNewPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"intTravelStandardNewPremiId", getIntTravelStandardNewPremiId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("travelType", getTravelType());
		attributes.put("packageType", getPackageType());
		attributes.put("peopleType", getPeopleType());
		attributes.put("mainInsured", getMainInsured());
		attributes.put("spouse", getSpouse());
		attributes.put("child", getChild());
		attributes.put("currency", getCurrency());
		attributes.put("amount", getAmount());
		attributes.put("additionalPrice", getAdditionalPrice());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long intTravelStandardNewPremiId = (Long)attributes.get(
			"intTravelStandardNewPremiId");

		if (intTravelStandardNewPremiId != null) {
			setIntTravelStandardNewPremiId(intTravelStandardNewPremiId);
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

		String travelType = (String)attributes.get("travelType");

		if (travelType != null) {
			setTravelType(travelType);
		}

		String packageType = (String)attributes.get("packageType");

		if (packageType != null) {
			setPackageType(packageType);
		}

		String peopleType = (String)attributes.get("peopleType");

		if (peopleType != null) {
			setPeopleType(peopleType);
		}

		Integer mainInsured = (Integer)attributes.get("mainInsured");

		if (mainInsured != null) {
			setMainInsured(mainInsured);
		}

		Integer spouse = (Integer)attributes.get("spouse");

		if (spouse != null) {
			setSpouse(spouse);
		}

		Integer child = (Integer)attributes.get("child");

		if (child != null) {
			setChild(child);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		BigDecimal amount = (BigDecimal)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		BigDecimal additionalPrice = (BigDecimal)attributes.get(
			"additionalPrice");

		if (additionalPrice != null) {
			setAdditionalPrice(additionalPrice);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this int travel standard new premi.
	 *
	 * @return the active of this int travel standard new premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the additional price of this int travel standard new premi.
	 *
	 * @return the additional price of this int travel standard new premi
	 */
	@Override
	public BigDecimal getAdditionalPrice() {
		return model.getAdditionalPrice();
	}

	/**
	 * Returns the amount of this int travel standard new premi.
	 *
	 * @return the amount of this int travel standard new premi
	 */
	@Override
	public BigDecimal getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the child of this int travel standard new premi.
	 *
	 * @return the child of this int travel standard new premi
	 */
	@Override
	public int getChild() {
		return model.getChild();
	}

	/**
	 * Returns the company ID of this int travel standard new premi.
	 *
	 * @return the company ID of this int travel standard new premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this int travel standard new premi.
	 *
	 * @return the create date of this int travel standard new premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this int travel standard new premi.
	 *
	 * @return the currency of this int travel standard new premi
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the group ID of this int travel standard new premi.
	 *
	 * @return the group ID of this int travel standard new premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the int travel standard new premi ID of this int travel standard new premi.
	 *
	 * @return the int travel standard new premi ID of this int travel standard new premi
	 */
	@Override
	public long getIntTravelStandardNewPremiId() {
		return model.getIntTravelStandardNewPremiId();
	}

	/**
	 * Returns the main insured of this int travel standard new premi.
	 *
	 * @return the main insured of this int travel standard new premi
	 */
	@Override
	public int getMainInsured() {
		return model.getMainInsured();
	}

	/**
	 * Returns the modified date of this int travel standard new premi.
	 *
	 * @return the modified date of this int travel standard new premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the package type of this int travel standard new premi.
	 *
	 * @return the package type of this int travel standard new premi
	 */
	@Override
	public String getPackageType() {
		return model.getPackageType();
	}

	/**
	 * Returns the people type of this int travel standard new premi.
	 *
	 * @return the people type of this int travel standard new premi
	 */
	@Override
	public String getPeopleType() {
		return model.getPeopleType();
	}

	/**
	 * Returns the primary key of this int travel standard new premi.
	 *
	 * @return the primary key of this int travel standard new premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the spouse of this int travel standard new premi.
	 *
	 * @return the spouse of this int travel standard new premi
	 */
	@Override
	public int getSpouse() {
		return model.getSpouse();
	}

	/**
	 * Returns the travel type of this int travel standard new premi.
	 *
	 * @return the travel type of this int travel standard new premi
	 */
	@Override
	public String getTravelType() {
		return model.getTravelType();
	}

	/**
	 * Returns the user ID of this int travel standard new premi.
	 *
	 * @return the user ID of this int travel standard new premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this int travel standard new premi.
	 *
	 * @return the user name of this int travel standard new premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this int travel standard new premi.
	 *
	 * @return the user uuid of this int travel standard new premi
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
	 * Sets the active of this int travel standard new premi.
	 *
	 * @param active the active of this int travel standard new premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the additional price of this int travel standard new premi.
	 *
	 * @param additionalPrice the additional price of this int travel standard new premi
	 */
	@Override
	public void setAdditionalPrice(BigDecimal additionalPrice) {
		model.setAdditionalPrice(additionalPrice);
	}

	/**
	 * Sets the amount of this int travel standard new premi.
	 *
	 * @param amount the amount of this int travel standard new premi
	 */
	@Override
	public void setAmount(BigDecimal amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the child of this int travel standard new premi.
	 *
	 * @param child the child of this int travel standard new premi
	 */
	@Override
	public void setChild(int child) {
		model.setChild(child);
	}

	/**
	 * Sets the company ID of this int travel standard new premi.
	 *
	 * @param companyId the company ID of this int travel standard new premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this int travel standard new premi.
	 *
	 * @param createDate the create date of this int travel standard new premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this int travel standard new premi.
	 *
	 * @param currency the currency of this int travel standard new premi
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the group ID of this int travel standard new premi.
	 *
	 * @param groupId the group ID of this int travel standard new premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the int travel standard new premi ID of this int travel standard new premi.
	 *
	 * @param intTravelStandardNewPremiId the int travel standard new premi ID of this int travel standard new premi
	 */
	@Override
	public void setIntTravelStandardNewPremiId(
		long intTravelStandardNewPremiId) {

		model.setIntTravelStandardNewPremiId(intTravelStandardNewPremiId);
	}

	/**
	 * Sets the main insured of this int travel standard new premi.
	 *
	 * @param mainInsured the main insured of this int travel standard new premi
	 */
	@Override
	public void setMainInsured(int mainInsured) {
		model.setMainInsured(mainInsured);
	}

	/**
	 * Sets the modified date of this int travel standard new premi.
	 *
	 * @param modifiedDate the modified date of this int travel standard new premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the package type of this int travel standard new premi.
	 *
	 * @param packageType the package type of this int travel standard new premi
	 */
	@Override
	public void setPackageType(String packageType) {
		model.setPackageType(packageType);
	}

	/**
	 * Sets the people type of this int travel standard new premi.
	 *
	 * @param peopleType the people type of this int travel standard new premi
	 */
	@Override
	public void setPeopleType(String peopleType) {
		model.setPeopleType(peopleType);
	}

	/**
	 * Sets the primary key of this int travel standard new premi.
	 *
	 * @param primaryKey the primary key of this int travel standard new premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the spouse of this int travel standard new premi.
	 *
	 * @param spouse the spouse of this int travel standard new premi
	 */
	@Override
	public void setSpouse(int spouse) {
		model.setSpouse(spouse);
	}

	/**
	 * Sets the travel type of this int travel standard new premi.
	 *
	 * @param travelType the travel type of this int travel standard new premi
	 */
	@Override
	public void setTravelType(String travelType) {
		model.setTravelType(travelType);
	}

	/**
	 * Sets the user ID of this int travel standard new premi.
	 *
	 * @param userId the user ID of this int travel standard new premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this int travel standard new premi.
	 *
	 * @param userName the user name of this int travel standard new premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this int travel standard new premi.
	 *
	 * @param userUuid the user uuid of this int travel standard new premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected IntTravelStandardNewPremiWrapper wrap(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		return new IntTravelStandardNewPremiWrapper(intTravelStandardNewPremi);
	}

}