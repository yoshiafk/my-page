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
 * This class is a wrapper for {@link TravelDomesticBenefit}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticBenefit
 * @generated
 */
public class TravelDomesticBenefitWrapper
	extends BaseModelWrapper<TravelDomesticBenefit>
	implements ModelWrapper<TravelDomesticBenefit>, TravelDomesticBenefit {

	public TravelDomesticBenefitWrapper(
		TravelDomesticBenefit travelDomesticBenefit) {

		super(travelDomesticBenefit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("travelDomesticBenefitId", getTravelDomesticBenefitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("plan", getPlan());
		attributes.put("amount", getAmount());
		attributes.put("benefit", getBenefit());
		attributes.put("benefitValue", getBenefitValue());
		attributes.put("group", getGroup());
		attributes.put("sort", getSort());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDomesticBenefitId = (Long)attributes.get(
			"travelDomesticBenefitId");

		if (travelDomesticBenefitId != null) {
			setTravelDomesticBenefitId(travelDomesticBenefitId);
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

		String plan = (String)attributes.get("plan");

		if (plan != null) {
			setPlan(plan);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String benefit = (String)attributes.get("benefit");

		if (benefit != null) {
			setBenefit(benefit);
		}

		Long benefitValue = (Long)attributes.get("benefitValue");

		if (benefitValue != null) {
			setBenefitValue(benefitValue);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this travel domestic benefit.
	 *
	 * @return the active of this travel domestic benefit
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this travel domestic benefit.
	 *
	 * @return the amount of this travel domestic benefit
	 */
	@Override
	public String getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the benefit of this travel domestic benefit.
	 *
	 * @return the benefit of this travel domestic benefit
	 */
	@Override
	public String getBenefit() {
		return model.getBenefit();
	}

	/**
	 * Returns the benefit value of this travel domestic benefit.
	 *
	 * @return the benefit value of this travel domestic benefit
	 */
	@Override
	public Long getBenefitValue() {
		return model.getBenefitValue();
	}

	/**
	 * Returns the company ID of this travel domestic benefit.
	 *
	 * @return the company ID of this travel domestic benefit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel domestic benefit.
	 *
	 * @return the create date of this travel domestic benefit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group of this travel domestic benefit.
	 *
	 * @return the group of this travel domestic benefit
	 */
	@Override
	public String getGroup() {
		return model.getGroup();
	}

	/**
	 * Returns the group ID of this travel domestic benefit.
	 *
	 * @return the group ID of this travel domestic benefit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this travel domestic benefit.
	 *
	 * @return the modified date of this travel domestic benefit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan of this travel domestic benefit.
	 *
	 * @return the plan of this travel domestic benefit
	 */
	@Override
	public String getPlan() {
		return model.getPlan();
	}

	/**
	 * Returns the primary key of this travel domestic benefit.
	 *
	 * @return the primary key of this travel domestic benefit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this travel domestic benefit.
	 *
	 * @return the sort of this travel domestic benefit
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the status of this travel domestic benefit.
	 *
	 * @return the status of this travel domestic benefit
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this travel domestic benefit was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this travel domestic benefit.
	 *
	 * @return the trash entry created when this travel domestic benefit was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this travel domestic benefit.
	 *
	 * @return the class primary key of the trash entry for this travel domestic benefit
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this travel domestic benefit.
	 *
	 * @return the trash handler for this travel domestic benefit
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the travel domestic benefit ID of this travel domestic benefit.
	 *
	 * @return the travel domestic benefit ID of this travel domestic benefit
	 */
	@Override
	public long getTravelDomesticBenefitId() {
		return model.getTravelDomesticBenefitId();
	}

	/**
	 * Returns the user ID of this travel domestic benefit.
	 *
	 * @return the user ID of this travel domestic benefit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel domestic benefit.
	 *
	 * @return the user name of this travel domestic benefit
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel domestic benefit.
	 *
	 * @return the user uuid of this travel domestic benefit
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this travel domestic benefit is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this travel domestic benefit is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this travel domestic benefit is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this travel domestic benefit is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the active of this travel domestic benefit.
	 *
	 * @param active the active of this travel domestic benefit
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this travel domestic benefit.
	 *
	 * @param amount the amount of this travel domestic benefit
	 */
	@Override
	public void setAmount(String amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the benefit of this travel domestic benefit.
	 *
	 * @param benefit the benefit of this travel domestic benefit
	 */
	@Override
	public void setBenefit(String benefit) {
		model.setBenefit(benefit);
	}

	/**
	 * Sets the benefit value of this travel domestic benefit.
	 *
	 * @param benefitValue the benefit value of this travel domestic benefit
	 */
	@Override
	public void setBenefitValue(Long benefitValue) {
		model.setBenefitValue(benefitValue);
	}

	/**
	 * Sets the company ID of this travel domestic benefit.
	 *
	 * @param companyId the company ID of this travel domestic benefit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel domestic benefit.
	 *
	 * @param createDate the create date of this travel domestic benefit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group of this travel domestic benefit.
	 *
	 * @param group the group of this travel domestic benefit
	 */
	@Override
	public void setGroup(String group) {
		model.setGroup(group);
	}

	/**
	 * Sets the group ID of this travel domestic benefit.
	 *
	 * @param groupId the group ID of this travel domestic benefit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this travel domestic benefit.
	 *
	 * @param modifiedDate the modified date of this travel domestic benefit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan of this travel domestic benefit.
	 *
	 * @param plan the plan of this travel domestic benefit
	 */
	@Override
	public void setPlan(String plan) {
		model.setPlan(plan);
	}

	/**
	 * Sets the primary key of this travel domestic benefit.
	 *
	 * @param primaryKey the primary key of this travel domestic benefit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this travel domestic benefit.
	 *
	 * @param sort the sort of this travel domestic benefit
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the travel domestic benefit ID of this travel domestic benefit.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID of this travel domestic benefit
	 */
	@Override
	public void setTravelDomesticBenefitId(long travelDomesticBenefitId) {
		model.setTravelDomesticBenefitId(travelDomesticBenefitId);
	}

	/**
	 * Sets the user ID of this travel domestic benefit.
	 *
	 * @param userId the user ID of this travel domestic benefit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel domestic benefit.
	 *
	 * @param userName the user name of this travel domestic benefit
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel domestic benefit.
	 *
	 * @param userUuid the user uuid of this travel domestic benefit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelDomesticBenefitWrapper wrap(
		TravelDomesticBenefit travelDomesticBenefit) {

		return new TravelDomesticBenefitWrapper(travelDomesticBenefit);
	}

}