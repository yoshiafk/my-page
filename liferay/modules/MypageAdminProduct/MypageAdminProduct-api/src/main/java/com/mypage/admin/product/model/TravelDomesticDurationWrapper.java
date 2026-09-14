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
 * This class is a wrapper for {@link TravelDomesticDuration}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticDuration
 * @generated
 */
public class TravelDomesticDurationWrapper
	extends BaseModelWrapper<TravelDomesticDuration>
	implements ModelWrapper<TravelDomesticDuration>, TravelDomesticDuration {

	public TravelDomesticDurationWrapper(
		TravelDomesticDuration travelDomesticDuration) {

		super(travelDomesticDuration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"travelDomesticDurationId", getTravelDomesticDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("dayFrom", getDayFrom());
		attributes.put("dayTo", getDayTo());
		attributes.put("label", getLabel());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDomesticDurationId = (Long)attributes.get(
			"travelDomesticDurationId");

		if (travelDomesticDurationId != null) {
			setTravelDomesticDurationId(travelDomesticDurationId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer dayFrom = (Integer)attributes.get("dayFrom");

		if (dayFrom != null) {
			setDayFrom(dayFrom);
		}

		Integer dayTo = (Integer)attributes.get("dayTo");

		if (dayTo != null) {
			setDayTo(dayTo);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this travel domestic duration.
	 *
	 * @return the active of this travel domestic duration
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this travel domestic duration.
	 *
	 * @return the code of this travel domestic duration
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this travel domestic duration.
	 *
	 * @return the company ID of this travel domestic duration
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel domestic duration.
	 *
	 * @return the create date of this travel domestic duration
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the day from of this travel domestic duration.
	 *
	 * @return the day from of this travel domestic duration
	 */
	@Override
	public int getDayFrom() {
		return model.getDayFrom();
	}

	/**
	 * Returns the day to of this travel domestic duration.
	 *
	 * @return the day to of this travel domestic duration
	 */
	@Override
	public int getDayTo() {
		return model.getDayTo();
	}

	/**
	 * Returns the group ID of this travel domestic duration.
	 *
	 * @return the group ID of this travel domestic duration
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the label of this travel domestic duration.
	 *
	 * @return the label of this travel domestic duration
	 */
	@Override
	public String getLabel() {
		return model.getLabel();
	}

	/**
	 * Returns the modified date of this travel domestic duration.
	 *
	 * @return the modified date of this travel domestic duration
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this travel domestic duration.
	 *
	 * @return the primary key of this travel domestic duration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this travel domestic duration.
	 *
	 * @return the status of this travel domestic duration
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this travel domestic duration was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this travel domestic duration.
	 *
	 * @return the trash entry created when this travel domestic duration was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this travel domestic duration.
	 *
	 * @return the class primary key of the trash entry for this travel domestic duration
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this travel domestic duration.
	 *
	 * @return the trash handler for this travel domestic duration
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the travel domestic duration ID of this travel domestic duration.
	 *
	 * @return the travel domestic duration ID of this travel domestic duration
	 */
	@Override
	public long getTravelDomesticDurationId() {
		return model.getTravelDomesticDurationId();
	}

	/**
	 * Returns the user ID of this travel domestic duration.
	 *
	 * @return the user ID of this travel domestic duration
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel domestic duration.
	 *
	 * @return the user name of this travel domestic duration
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel domestic duration.
	 *
	 * @return the user uuid of this travel domestic duration
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this travel domestic duration is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this travel domestic duration is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this travel domestic duration is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this travel domestic duration is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this travel domestic duration.
	 *
	 * @param active the active of this travel domestic duration
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this travel domestic duration.
	 *
	 * @param code the code of this travel domestic duration
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this travel domestic duration.
	 *
	 * @param companyId the company ID of this travel domestic duration
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel domestic duration.
	 *
	 * @param createDate the create date of this travel domestic duration
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the day from of this travel domestic duration.
	 *
	 * @param dayFrom the day from of this travel domestic duration
	 */
	@Override
	public void setDayFrom(int dayFrom) {
		model.setDayFrom(dayFrom);
	}

	/**
	 * Sets the day to of this travel domestic duration.
	 *
	 * @param dayTo the day to of this travel domestic duration
	 */
	@Override
	public void setDayTo(int dayTo) {
		model.setDayTo(dayTo);
	}

	/**
	 * Sets the group ID of this travel domestic duration.
	 *
	 * @param groupId the group ID of this travel domestic duration
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the label of this travel domestic duration.
	 *
	 * @param label the label of this travel domestic duration
	 */
	@Override
	public void setLabel(String label) {
		model.setLabel(label);
	}

	/**
	 * Sets the modified date of this travel domestic duration.
	 *
	 * @param modifiedDate the modified date of this travel domestic duration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this travel domestic duration.
	 *
	 * @param primaryKey the primary key of this travel domestic duration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the travel domestic duration ID of this travel domestic duration.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID of this travel domestic duration
	 */
	@Override
	public void setTravelDomesticDurationId(long travelDomesticDurationId) {
		model.setTravelDomesticDurationId(travelDomesticDurationId);
	}

	/**
	 * Sets the user ID of this travel domestic duration.
	 *
	 * @param userId the user ID of this travel domestic duration
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel domestic duration.
	 *
	 * @param userName the user name of this travel domestic duration
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel domestic duration.
	 *
	 * @param userUuid the user uuid of this travel domestic duration
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelDomesticDurationWrapper wrap(
		TravelDomesticDuration travelDomesticDuration) {

		return new TravelDomesticDurationWrapper(travelDomesticDuration);
	}

}