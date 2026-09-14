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
 * This class is a wrapper for {@link SmartTravelIntPlan}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartTravelIntPlan
 * @generated
 */
public class SmartTravelIntPlanWrapper
	extends BaseModelWrapper<SmartTravelIntPlan>
	implements ModelWrapper<SmartTravelIntPlan>, SmartTravelIntPlan {

	public SmartTravelIntPlanWrapper(SmartTravelIntPlan smartTravelIntPlan) {
		super(smartTravelIntPlan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartTravelIntPlanId", getSmartTravelIntPlanId());
		attributes.put("nameId", getNameId());
		attributes.put("nameEn", getNameEn());
		attributes.put("sort", getSort());
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
		Long smartTravelIntPlanId = (Long)attributes.get(
			"smartTravelIntPlanId");

		if (smartTravelIntPlanId != null) {
			setSmartTravelIntPlanId(smartTravelIntPlanId);
		}

		String nameId = (String)attributes.get("nameId");

		if (nameId != null) {
			setNameId(nameId);
		}

		String nameEn = (String)attributes.get("nameEn");

		if (nameEn != null) {
			setNameEn(nameEn);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
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
	 * Returns the active of this smart travel int plan.
	 *
	 * @return the active of this smart travel int plan
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart travel int plan.
	 *
	 * @return the company ID of this smart travel int plan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart travel int plan.
	 *
	 * @return the create date of this smart travel int plan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart travel int plan.
	 *
	 * @return the group ID of this smart travel int plan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart travel int plan.
	 *
	 * @return the modified date of this smart travel int plan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name en of this smart travel int plan.
	 *
	 * @return the name en of this smart travel int plan
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the name ID of this smart travel int plan.
	 *
	 * @return the name ID of this smart travel int plan
	 */
	@Override
	public String getNameId() {
		return model.getNameId();
	}

	/**
	 * Returns the primary key of this smart travel int plan.
	 *
	 * @return the primary key of this smart travel int plan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart travel int plan ID of this smart travel int plan.
	 *
	 * @return the smart travel int plan ID of this smart travel int plan
	 */
	@Override
	public long getSmartTravelIntPlanId() {
		return model.getSmartTravelIntPlanId();
	}

	/**
	 * Returns the sort of this smart travel int plan.
	 *
	 * @return the sort of this smart travel int plan
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the user ID of this smart travel int plan.
	 *
	 * @return the user ID of this smart travel int plan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart travel int plan.
	 *
	 * @return the user name of this smart travel int plan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart travel int plan.
	 *
	 * @return the user uuid of this smart travel int plan
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
	 * Sets the active of this smart travel int plan.
	 *
	 * @param active the active of this smart travel int plan
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart travel int plan.
	 *
	 * @param companyId the company ID of this smart travel int plan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart travel int plan.
	 *
	 * @param createDate the create date of this smart travel int plan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart travel int plan.
	 *
	 * @param groupId the group ID of this smart travel int plan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart travel int plan.
	 *
	 * @param modifiedDate the modified date of this smart travel int plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name en of this smart travel int plan.
	 *
	 * @param nameEn the name en of this smart travel int plan
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the name ID of this smart travel int plan.
	 *
	 * @param nameId the name ID of this smart travel int plan
	 */
	@Override
	public void setNameId(String nameId) {
		model.setNameId(nameId);
	}

	/**
	 * Sets the primary key of this smart travel int plan.
	 *
	 * @param primaryKey the primary key of this smart travel int plan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart travel int plan ID of this smart travel int plan.
	 *
	 * @param smartTravelIntPlanId the smart travel int plan ID of this smart travel int plan
	 */
	@Override
	public void setSmartTravelIntPlanId(long smartTravelIntPlanId) {
		model.setSmartTravelIntPlanId(smartTravelIntPlanId);
	}

	/**
	 * Sets the sort of this smart travel int plan.
	 *
	 * @param sort the sort of this smart travel int plan
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the user ID of this smart travel int plan.
	 *
	 * @param userId the user ID of this smart travel int plan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart travel int plan.
	 *
	 * @param userName the user name of this smart travel int plan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart travel int plan.
	 *
	 * @param userUuid the user uuid of this smart travel int plan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartTravelIntPlanWrapper wrap(
		SmartTravelIntPlan smartTravelIntPlan) {

		return new SmartTravelIntPlanWrapper(smartTravelIntPlan);
	}

}