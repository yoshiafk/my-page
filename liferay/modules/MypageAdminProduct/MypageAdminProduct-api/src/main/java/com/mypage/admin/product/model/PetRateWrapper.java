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
 * This class is a wrapper for {@link PetRate}.
 * </p>
 *
 * @author Gositus Team
 * @see PetRate
 * @generated
 */
public class PetRateWrapper
	extends BaseModelWrapper<PetRate>
	implements ModelWrapper<PetRate>, PetRate {

	public PetRateWrapper(PetRate petRate) {
		super(petRate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("petRateId", getPetRateId());
		attributes.put("petPlan", getPetPlan());
		attributes.put("petRemarks", getPetRemarks());
		attributes.put("rate", getRate());
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
		Long petRateId = (Long)attributes.get("petRateId");

		if (petRateId != null) {
			setPetRateId(petRateId);
		}

		Long petPlan = (Long)attributes.get("petPlan");

		if (petPlan != null) {
			setPetPlan(petPlan);
		}

		Long petRemarks = (Long)attributes.get("petRemarks");

		if (petRemarks != null) {
			setPetRemarks(petRemarks);
		}

		String rate = (String)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
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
	 * Returns the active of this pet rate.
	 *
	 * @return the active of this pet rate
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this pet rate.
	 *
	 * @return the company ID of this pet rate
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pet rate.
	 *
	 * @return the create date of this pet rate
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this pet rate.
	 *
	 * @return the group ID of this pet rate
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pet rate.
	 *
	 * @return the modified date of this pet rate
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pet plan of this pet rate.
	 *
	 * @return the pet plan of this pet rate
	 */
	@Override
	public long getPetPlan() {
		return model.getPetPlan();
	}

	/**
	 * Returns the pet rate ID of this pet rate.
	 *
	 * @return the pet rate ID of this pet rate
	 */
	@Override
	public long getPetRateId() {
		return model.getPetRateId();
	}

	/**
	 * Returns the pet remarks of this pet rate.
	 *
	 * @return the pet remarks of this pet rate
	 */
	@Override
	public long getPetRemarks() {
		return model.getPetRemarks();
	}

	/**
	 * Returns the primary key of this pet rate.
	 *
	 * @return the primary key of this pet rate
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rate of this pet rate.
	 *
	 * @return the rate of this pet rate
	 */
	@Override
	public String getRate() {
		return model.getRate();
	}

	/**
	 * Returns the status of this pet rate.
	 *
	 * @return the status of this pet rate
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this pet rate was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this pet rate.
	 *
	 * @return the trash entry created when this pet rate was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this pet rate.
	 *
	 * @return the class primary key of the trash entry for this pet rate
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this pet rate.
	 *
	 * @return the trash handler for this pet rate
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this pet rate.
	 *
	 * @return the user ID of this pet rate
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pet rate.
	 *
	 * @return the user name of this pet rate
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pet rate.
	 *
	 * @return the user uuid of this pet rate
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pet rate is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this pet rate is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this pet rate is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this pet rate is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the active of this pet rate.
	 *
	 * @param active the active of this pet rate
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this pet rate.
	 *
	 * @param companyId the company ID of this pet rate
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pet rate.
	 *
	 * @param createDate the create date of this pet rate
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this pet rate.
	 *
	 * @param groupId the group ID of this pet rate
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pet rate.
	 *
	 * @param modifiedDate the modified date of this pet rate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pet plan of this pet rate.
	 *
	 * @param petPlan the pet plan of this pet rate
	 */
	@Override
	public void setPetPlan(long petPlan) {
		model.setPetPlan(petPlan);
	}

	/**
	 * Sets the pet rate ID of this pet rate.
	 *
	 * @param petRateId the pet rate ID of this pet rate
	 */
	@Override
	public void setPetRateId(long petRateId) {
		model.setPetRateId(petRateId);
	}

	/**
	 * Sets the pet remarks of this pet rate.
	 *
	 * @param petRemarks the pet remarks of this pet rate
	 */
	@Override
	public void setPetRemarks(long petRemarks) {
		model.setPetRemarks(petRemarks);
	}

	/**
	 * Sets the primary key of this pet rate.
	 *
	 * @param primaryKey the primary key of this pet rate
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rate of this pet rate.
	 *
	 * @param rate the rate of this pet rate
	 */
	@Override
	public void setRate(String rate) {
		model.setRate(rate);
	}

	/**
	 * Sets the user ID of this pet rate.
	 *
	 * @param userId the user ID of this pet rate
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pet rate.
	 *
	 * @param userName the user name of this pet rate
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pet rate.
	 *
	 * @param userUuid the user uuid of this pet rate
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PetRateWrapper wrap(PetRate petRate) {
		return new PetRateWrapper(petRate);
	}

}