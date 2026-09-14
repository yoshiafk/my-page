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
 * This class is a wrapper for {@link TravelDomesticPlan}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticPlan
 * @generated
 */
public class TravelDomesticPlanWrapper
	extends BaseModelWrapper<TravelDomesticPlan>
	implements ModelWrapper<TravelDomesticPlan>, TravelDomesticPlan {

	public TravelDomesticPlanWrapper(TravelDomesticPlan travelDomesticPlan) {
		super(travelDomesticPlan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("travelDomesticPlanId", getTravelDomesticPlanId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("toproTsi", getToproTsi());
		attributes.put("toproAtsi", getToproAtsi());
		attributes.put("sort", getSort());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDomesticPlanId = (Long)attributes.get(
			"travelDomesticPlanId");

		if (travelDomesticPlanId != null) {
			setTravelDomesticPlanId(travelDomesticPlanId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer toproTsi = (Integer)attributes.get("toproTsi");

		if (toproTsi != null) {
			setToproTsi(toproTsi);
		}

		Integer toproAtsi = (Integer)attributes.get("toproAtsi");

		if (toproAtsi != null) {
			setToproAtsi(toproAtsi);
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
	 * Returns the active of this travel domestic plan.
	 *
	 * @return the active of this travel domestic plan
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this travel domestic plan.
	 *
	 * @return the code of this travel domestic plan
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this travel domestic plan.
	 *
	 * @return the company ID of this travel domestic plan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel domestic plan.
	 *
	 * @return the create date of this travel domestic plan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this travel domestic plan.
	 *
	 * @return the group ID of this travel domestic plan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this travel domestic plan.
	 *
	 * @return the modified date of this travel domestic plan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this travel domestic plan.
	 *
	 * @return the name of this travel domestic plan
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this travel domestic plan.
	 *
	 * @return the primary key of this travel domestic plan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this travel domestic plan.
	 *
	 * @return the sort of this travel domestic plan
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the topro atsi of this travel domestic plan.
	 *
	 * @return the topro atsi of this travel domestic plan
	 */
	@Override
	public int getToproAtsi() {
		return model.getToproAtsi();
	}

	/**
	 * Returns the topro tsi of this travel domestic plan.
	 *
	 * @return the topro tsi of this travel domestic plan
	 */
	@Override
	public int getToproTsi() {
		return model.getToproTsi();
	}

	/**
	 * Returns the travel domestic plan ID of this travel domestic plan.
	 *
	 * @return the travel domestic plan ID of this travel domestic plan
	 */
	@Override
	public long getTravelDomesticPlanId() {
		return model.getTravelDomesticPlanId();
	}

	/**
	 * Returns the user ID of this travel domestic plan.
	 *
	 * @return the user ID of this travel domestic plan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel domestic plan.
	 *
	 * @return the user name of this travel domestic plan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel domestic plan.
	 *
	 * @return the user uuid of this travel domestic plan
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
	 * Sets the active of this travel domestic plan.
	 *
	 * @param active the active of this travel domestic plan
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this travel domestic plan.
	 *
	 * @param code the code of this travel domestic plan
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this travel domestic plan.
	 *
	 * @param companyId the company ID of this travel domestic plan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel domestic plan.
	 *
	 * @param createDate the create date of this travel domestic plan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this travel domestic plan.
	 *
	 * @param groupId the group ID of this travel domestic plan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this travel domestic plan.
	 *
	 * @param modifiedDate the modified date of this travel domestic plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this travel domestic plan.
	 *
	 * @param name the name of this travel domestic plan
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this travel domestic plan.
	 *
	 * @param primaryKey the primary key of this travel domestic plan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this travel domestic plan.
	 *
	 * @param sort the sort of this travel domestic plan
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the topro atsi of this travel domestic plan.
	 *
	 * @param toproAtsi the topro atsi of this travel domestic plan
	 */
	@Override
	public void setToproAtsi(int toproAtsi) {
		model.setToproAtsi(toproAtsi);
	}

	/**
	 * Sets the topro tsi of this travel domestic plan.
	 *
	 * @param toproTsi the topro tsi of this travel domestic plan
	 */
	@Override
	public void setToproTsi(int toproTsi) {
		model.setToproTsi(toproTsi);
	}

	/**
	 * Sets the travel domestic plan ID of this travel domestic plan.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID of this travel domestic plan
	 */
	@Override
	public void setTravelDomesticPlanId(long travelDomesticPlanId) {
		model.setTravelDomesticPlanId(travelDomesticPlanId);
	}

	/**
	 * Sets the user ID of this travel domestic plan.
	 *
	 * @param userId the user ID of this travel domestic plan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel domestic plan.
	 *
	 * @param userName the user name of this travel domestic plan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel domestic plan.
	 *
	 * @param userUuid the user uuid of this travel domestic plan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelDomesticPlanWrapper wrap(
		TravelDomesticPlan travelDomesticPlan) {

		return new TravelDomesticPlanWrapper(travelDomesticPlan);
	}

}