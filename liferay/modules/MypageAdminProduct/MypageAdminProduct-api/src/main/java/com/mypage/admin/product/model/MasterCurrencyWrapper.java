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
 * This class is a wrapper for {@link MasterCurrency}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterCurrency
 * @generated
 */
public class MasterCurrencyWrapper
	extends BaseModelWrapper<MasterCurrency>
	implements MasterCurrency, ModelWrapper<MasterCurrency> {

	public MasterCurrencyWrapper(MasterCurrency masterCurrency) {
		super(masterCurrency);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("currencyId", getCurrencyId());
		attributes.put("name", getName());
		attributes.put("amount", getAmount());
		attributes.put("isDefault", getIsDefault());
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
		Long currencyId = (Long)attributes.get("currencyId");

		if (currencyId != null) {
			setCurrencyId(currencyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer isDefault = (Integer)attributes.get("isDefault");

		if (isDefault != null) {
			setIsDefault(isDefault);
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
	 * Returns the active of this master currency.
	 *
	 * @return the active of this master currency
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this master currency.
	 *
	 * @return the amount of this master currency
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this master currency.
	 *
	 * @return the company ID of this master currency
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master currency.
	 *
	 * @return the create date of this master currency
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency ID of this master currency.
	 *
	 * @return the currency ID of this master currency
	 */
	@Override
	public long getCurrencyId() {
		return model.getCurrencyId();
	}

	/**
	 * Returns the group ID of this master currency.
	 *
	 * @return the group ID of this master currency
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is default of this master currency.
	 *
	 * @return the is default of this master currency
	 */
	@Override
	public Integer getIsDefault() {
		return model.getIsDefault();
	}

	/**
	 * Returns the modified date of this master currency.
	 *
	 * @return the modified date of this master currency
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master currency.
	 *
	 * @return the name of this master currency
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master currency.
	 *
	 * @return the primary key of this master currency
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master currency.
	 *
	 * @return the user ID of this master currency
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master currency.
	 *
	 * @return the user name of this master currency
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master currency.
	 *
	 * @return the user uuid of this master currency
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
	 * Sets the active of this master currency.
	 *
	 * @param active the active of this master currency
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this master currency.
	 *
	 * @param amount the amount of this master currency
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this master currency.
	 *
	 * @param companyId the company ID of this master currency
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master currency.
	 *
	 * @param createDate the create date of this master currency
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency ID of this master currency.
	 *
	 * @param currencyId the currency ID of this master currency
	 */
	@Override
	public void setCurrencyId(long currencyId) {
		model.setCurrencyId(currencyId);
	}

	/**
	 * Sets the group ID of this master currency.
	 *
	 * @param groupId the group ID of this master currency
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is default of this master currency.
	 *
	 * @param isDefault the is default of this master currency
	 */
	@Override
	public void setIsDefault(Integer isDefault) {
		model.setIsDefault(isDefault);
	}

	/**
	 * Sets the modified date of this master currency.
	 *
	 * @param modifiedDate the modified date of this master currency
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master currency.
	 *
	 * @param name the name of this master currency
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master currency.
	 *
	 * @param primaryKey the primary key of this master currency
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master currency.
	 *
	 * @param userId the user ID of this master currency
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master currency.
	 *
	 * @param userName the user name of this master currency
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master currency.
	 *
	 * @param userUuid the user uuid of this master currency
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterCurrencyWrapper wrap(MasterCurrency masterCurrency) {
		return new MasterCurrencyWrapper(masterCurrency);
	}

}