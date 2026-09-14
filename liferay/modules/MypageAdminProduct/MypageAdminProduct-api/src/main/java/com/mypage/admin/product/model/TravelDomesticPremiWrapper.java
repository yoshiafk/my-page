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
 * This class is a wrapper for {@link TravelDomesticPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticPremi
 * @generated
 */
public class TravelDomesticPremiWrapper
	extends BaseModelWrapper<TravelDomesticPremi>
	implements ModelWrapper<TravelDomesticPremi>, TravelDomesticPremi {

	public TravelDomesticPremiWrapper(TravelDomesticPremi travelDomesticPremi) {
		super(travelDomesticPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("travelDomesticPremiId", getTravelDomesticPremiId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("duration", getDuration());
		attributes.put("plan", getPlan());
		attributes.put("insuredType", getInsuredType());
		attributes.put("currency", getCurrency());
		attributes.put("amount", getAmount());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDomesticPremiId = (Long)attributes.get(
			"travelDomesticPremiId");

		if (travelDomesticPremiId != null) {
			setTravelDomesticPremiId(travelDomesticPremiId);
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

		Integer duration = (Integer)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String plan = (String)attributes.get("plan");

		if (plan != null) {
			setPlan(plan);
		}

		String insuredType = (String)attributes.get("insuredType");

		if (insuredType != null) {
			setInsuredType(insuredType);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this travel domestic premi.
	 *
	 * @return the active of this travel domestic premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this travel domestic premi.
	 *
	 * @return the amount of this travel domestic premi
	 */
	@Override
	public Long getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this travel domestic premi.
	 *
	 * @return the company ID of this travel domestic premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel domestic premi.
	 *
	 * @return the create date of this travel domestic premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this travel domestic premi.
	 *
	 * @return the currency of this travel domestic premi
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the duration of this travel domestic premi.
	 *
	 * @return the duration of this travel domestic premi
	 */
	@Override
	public int getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the group ID of this travel domestic premi.
	 *
	 * @return the group ID of this travel domestic premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the insured type of this travel domestic premi.
	 *
	 * @return the insured type of this travel domestic premi
	 */
	@Override
	public String getInsuredType() {
		return model.getInsuredType();
	}

	/**
	 * Returns the modified date of this travel domestic premi.
	 *
	 * @return the modified date of this travel domestic premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan of this travel domestic premi.
	 *
	 * @return the plan of this travel domestic premi
	 */
	@Override
	public String getPlan() {
		return model.getPlan();
	}

	/**
	 * Returns the primary key of this travel domestic premi.
	 *
	 * @return the primary key of this travel domestic premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the travel domestic premi ID of this travel domestic premi.
	 *
	 * @return the travel domestic premi ID of this travel domestic premi
	 */
	@Override
	public long getTravelDomesticPremiId() {
		return model.getTravelDomesticPremiId();
	}

	/**
	 * Returns the user ID of this travel domestic premi.
	 *
	 * @return the user ID of this travel domestic premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel domestic premi.
	 *
	 * @return the user name of this travel domestic premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel domestic premi.
	 *
	 * @return the user uuid of this travel domestic premi
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
	 * Sets the active of this travel domestic premi.
	 *
	 * @param active the active of this travel domestic premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this travel domestic premi.
	 *
	 * @param amount the amount of this travel domestic premi
	 */
	@Override
	public void setAmount(Long amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this travel domestic premi.
	 *
	 * @param companyId the company ID of this travel domestic premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel domestic premi.
	 *
	 * @param createDate the create date of this travel domestic premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this travel domestic premi.
	 *
	 * @param currency the currency of this travel domestic premi
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the duration of this travel domestic premi.
	 *
	 * @param duration the duration of this travel domestic premi
	 */
	@Override
	public void setDuration(int duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the group ID of this travel domestic premi.
	 *
	 * @param groupId the group ID of this travel domestic premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the insured type of this travel domestic premi.
	 *
	 * @param insuredType the insured type of this travel domestic premi
	 */
	@Override
	public void setInsuredType(String insuredType) {
		model.setInsuredType(insuredType);
	}

	/**
	 * Sets the modified date of this travel domestic premi.
	 *
	 * @param modifiedDate the modified date of this travel domestic premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan of this travel domestic premi.
	 *
	 * @param plan the plan of this travel domestic premi
	 */
	@Override
	public void setPlan(String plan) {
		model.setPlan(plan);
	}

	/**
	 * Sets the primary key of this travel domestic premi.
	 *
	 * @param primaryKey the primary key of this travel domestic premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the travel domestic premi ID of this travel domestic premi.
	 *
	 * @param travelDomesticPremiId the travel domestic premi ID of this travel domestic premi
	 */
	@Override
	public void setTravelDomesticPremiId(long travelDomesticPremiId) {
		model.setTravelDomesticPremiId(travelDomesticPremiId);
	}

	/**
	 * Sets the user ID of this travel domestic premi.
	 *
	 * @param userId the user ID of this travel domestic premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel domestic premi.
	 *
	 * @param userName the user name of this travel domestic premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel domestic premi.
	 *
	 * @param userUuid the user uuid of this travel domestic premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelDomesticPremiWrapper wrap(
		TravelDomesticPremi travelDomesticPremi) {

		return new TravelDomesticPremiWrapper(travelDomesticPremi);
	}

}