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
 * This class is a wrapper for {@link TravelInternationalPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelInternationalPremi
 * @generated
 */
public class TravelInternationalPremiWrapper
	extends BaseModelWrapper<TravelInternationalPremi>
	implements ModelWrapper<TravelInternationalPremi>,
			   TravelInternationalPremi {

	public TravelInternationalPremiWrapper(
		TravelInternationalPremi travelInternationalPremi) {

		super(travelInternationalPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("premiId", getPremiId());
		attributes.put("packageType", getPackageType());
		attributes.put("peopleType", getPeopleType());
		attributes.put("adultCount", getAdultCount());
		attributes.put("childrenCount", getChildrenCount());
		attributes.put("currency", getCurrency());
		attributes.put("amount", getAmount());
		attributes.put("minDuration", getMinDuration());
		attributes.put("maxDuration", getMaxDuration());
		attributes.put("active", getActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long premiId = (Long)attributes.get("premiId");

		if (premiId != null) {
			setPremiId(premiId);
		}

		String packageType = (String)attributes.get("packageType");

		if (packageType != null) {
			setPackageType(packageType);
		}

		String peopleType = (String)attributes.get("peopleType");

		if (peopleType != null) {
			setPeopleType(peopleType);
		}

		Integer adultCount = (Integer)attributes.get("adultCount");

		if (adultCount != null) {
			setAdultCount(adultCount);
		}

		Integer childrenCount = (Integer)attributes.get("childrenCount");

		if (childrenCount != null) {
			setChildrenCount(childrenCount);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		BigDecimal amount = (BigDecimal)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer minDuration = (Integer)attributes.get("minDuration");

		if (minDuration != null) {
			setMinDuration(minDuration);
		}

		Integer maxDuration = (Integer)attributes.get("maxDuration");

		if (maxDuration != null) {
			setMaxDuration(maxDuration);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the active of this travel international premi.
	 *
	 * @return the active of this travel international premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the adult count of this travel international premi.
	 *
	 * @return the adult count of this travel international premi
	 */
	@Override
	public int getAdultCount() {
		return model.getAdultCount();
	}

	/**
	 * Returns the amount of this travel international premi.
	 *
	 * @return the amount of this travel international premi
	 */
	@Override
	public BigDecimal getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the children count of this travel international premi.
	 *
	 * @return the children count of this travel international premi
	 */
	@Override
	public int getChildrenCount() {
		return model.getChildrenCount();
	}

	/**
	 * Returns the company ID of this travel international premi.
	 *
	 * @return the company ID of this travel international premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel international premi.
	 *
	 * @return the create date of this travel international premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this travel international premi.
	 *
	 * @return the currency of this travel international premi
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the group ID of this travel international premi.
	 *
	 * @return the group ID of this travel international premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the max duration of this travel international premi.
	 *
	 * @return the max duration of this travel international premi
	 */
	@Override
	public int getMaxDuration() {
		return model.getMaxDuration();
	}

	/**
	 * Returns the min duration of this travel international premi.
	 *
	 * @return the min duration of this travel international premi
	 */
	@Override
	public int getMinDuration() {
		return model.getMinDuration();
	}

	/**
	 * Returns the modified date of this travel international premi.
	 *
	 * @return the modified date of this travel international premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the package type of this travel international premi.
	 *
	 * @return the package type of this travel international premi
	 */
	@Override
	public String getPackageType() {
		return model.getPackageType();
	}

	/**
	 * Returns the people type of this travel international premi.
	 *
	 * @return the people type of this travel international premi
	 */
	@Override
	public String getPeopleType() {
		return model.getPeopleType();
	}

	/**
	 * Returns the premi ID of this travel international premi.
	 *
	 * @return the premi ID of this travel international premi
	 */
	@Override
	public long getPremiId() {
		return model.getPremiId();
	}

	/**
	 * Returns the primary key of this travel international premi.
	 *
	 * @return the primary key of this travel international premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this travel international premi.
	 *
	 * @return the status of this travel international premi
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this travel international premi.
	 *
	 * @return the status by user ID of this travel international premi
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this travel international premi.
	 *
	 * @return the status by user name of this travel international premi
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this travel international premi.
	 *
	 * @return the status by user uuid of this travel international premi
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this travel international premi.
	 *
	 * @return the status date of this travel international premi
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this travel international premi.
	 *
	 * @return the user ID of this travel international premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel international premi.
	 *
	 * @return the user name of this travel international premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel international premi.
	 *
	 * @return the user uuid of this travel international premi
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is approved.
	 *
	 * @return <code>true</code> if this travel international premi is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is denied.
	 *
	 * @return <code>true</code> if this travel international premi is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is a draft.
	 *
	 * @return <code>true</code> if this travel international premi is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is expired.
	 *
	 * @return <code>true</code> if this travel international premi is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is inactive.
	 *
	 * @return <code>true</code> if this travel international premi is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is incomplete.
	 *
	 * @return <code>true</code> if this travel international premi is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is pending.
	 *
	 * @return <code>true</code> if this travel international premi is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this travel international premi is scheduled.
	 *
	 * @return <code>true</code> if this travel international premi is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this travel international premi.
	 *
	 * @param active the active of this travel international premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the adult count of this travel international premi.
	 *
	 * @param adultCount the adult count of this travel international premi
	 */
	@Override
	public void setAdultCount(int adultCount) {
		model.setAdultCount(adultCount);
	}

	/**
	 * Sets the amount of this travel international premi.
	 *
	 * @param amount the amount of this travel international premi
	 */
	@Override
	public void setAmount(BigDecimal amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the children count of this travel international premi.
	 *
	 * @param childrenCount the children count of this travel international premi
	 */
	@Override
	public void setChildrenCount(int childrenCount) {
		model.setChildrenCount(childrenCount);
	}

	/**
	 * Sets the company ID of this travel international premi.
	 *
	 * @param companyId the company ID of this travel international premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel international premi.
	 *
	 * @param createDate the create date of this travel international premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this travel international premi.
	 *
	 * @param currency the currency of this travel international premi
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the group ID of this travel international premi.
	 *
	 * @param groupId the group ID of this travel international premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the max duration of this travel international premi.
	 *
	 * @param maxDuration the max duration of this travel international premi
	 */
	@Override
	public void setMaxDuration(int maxDuration) {
		model.setMaxDuration(maxDuration);
	}

	/**
	 * Sets the min duration of this travel international premi.
	 *
	 * @param minDuration the min duration of this travel international premi
	 */
	@Override
	public void setMinDuration(int minDuration) {
		model.setMinDuration(minDuration);
	}

	/**
	 * Sets the modified date of this travel international premi.
	 *
	 * @param modifiedDate the modified date of this travel international premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the package type of this travel international premi.
	 *
	 * @param packageType the package type of this travel international premi
	 */
	@Override
	public void setPackageType(String packageType) {
		model.setPackageType(packageType);
	}

	/**
	 * Sets the people type of this travel international premi.
	 *
	 * @param peopleType the people type of this travel international premi
	 */
	@Override
	public void setPeopleType(String peopleType) {
		model.setPeopleType(peopleType);
	}

	/**
	 * Sets the premi ID of this travel international premi.
	 *
	 * @param premiId the premi ID of this travel international premi
	 */
	@Override
	public void setPremiId(long premiId) {
		model.setPremiId(premiId);
	}

	/**
	 * Sets the primary key of this travel international premi.
	 *
	 * @param primaryKey the primary key of this travel international premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this travel international premi.
	 *
	 * @param status the status of this travel international premi
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this travel international premi.
	 *
	 * @param statusByUserId the status by user ID of this travel international premi
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this travel international premi.
	 *
	 * @param statusByUserName the status by user name of this travel international premi
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this travel international premi.
	 *
	 * @param statusByUserUuid the status by user uuid of this travel international premi
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this travel international premi.
	 *
	 * @param statusDate the status date of this travel international premi
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this travel international premi.
	 *
	 * @param userId the user ID of this travel international premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel international premi.
	 *
	 * @param userName the user name of this travel international premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel international premi.
	 *
	 * @param userUuid the user uuid of this travel international premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelInternationalPremiWrapper wrap(
		TravelInternationalPremi travelInternationalPremi) {

		return new TravelInternationalPremiWrapper(travelInternationalPremi);
	}

}