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
 * This class is a wrapper for {@link TravelIntBenefit}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelIntBenefit
 * @generated
 */
public class TravelIntBenefitWrapper
	extends BaseModelWrapper<TravelIntBenefit>
	implements ModelWrapper<TravelIntBenefit>, TravelIntBenefit {

	public TravelIntBenefitWrapper(TravelIntBenefit travelIntBenefit) {
		super(travelIntBenefit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("travelIntBenefitId", getTravelIntBenefitId());
		attributes.put("benefitName", getBenefitName());
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
		Long travelIntBenefitId = (Long)attributes.get("travelIntBenefitId");

		if (travelIntBenefitId != null) {
			setTravelIntBenefitId(travelIntBenefitId);
		}

		String benefitName = (String)attributes.get("benefitName");

		if (benefitName != null) {
			setBenefitName(benefitName);
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
	 * Returns the active of this travel int benefit.
	 *
	 * @return the active of this travel int benefit
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit name of this travel int benefit.
	 *
	 * @return the benefit name of this travel int benefit
	 */
	@Override
	public String getBenefitName() {
		return model.getBenefitName();
	}

	/**
	 * Returns the company ID of this travel int benefit.
	 *
	 * @return the company ID of this travel int benefit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel int benefit.
	 *
	 * @return the create date of this travel int benefit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this travel int benefit.
	 *
	 * @return the group ID of this travel int benefit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this travel int benefit.
	 *
	 * @return the modified date of this travel int benefit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this travel int benefit.
	 *
	 * @return the primary key of this travel int benefit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the travel int benefit ID of this travel int benefit.
	 *
	 * @return the travel int benefit ID of this travel int benefit
	 */
	@Override
	public long getTravelIntBenefitId() {
		return model.getTravelIntBenefitId();
	}

	/**
	 * Returns the user ID of this travel int benefit.
	 *
	 * @return the user ID of this travel int benefit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel int benefit.
	 *
	 * @return the user name of this travel int benefit
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel int benefit.
	 *
	 * @return the user uuid of this travel int benefit
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
	 * Sets the active of this travel int benefit.
	 *
	 * @param active the active of this travel int benefit
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit name of this travel int benefit.
	 *
	 * @param benefitName the benefit name of this travel int benefit
	 */
	@Override
	public void setBenefitName(String benefitName) {
		model.setBenefitName(benefitName);
	}

	/**
	 * Sets the company ID of this travel int benefit.
	 *
	 * @param companyId the company ID of this travel int benefit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel int benefit.
	 *
	 * @param createDate the create date of this travel int benefit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this travel int benefit.
	 *
	 * @param groupId the group ID of this travel int benefit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this travel int benefit.
	 *
	 * @param modifiedDate the modified date of this travel int benefit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this travel int benefit.
	 *
	 * @param primaryKey the primary key of this travel int benefit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the travel int benefit ID of this travel int benefit.
	 *
	 * @param travelIntBenefitId the travel int benefit ID of this travel int benefit
	 */
	@Override
	public void setTravelIntBenefitId(long travelIntBenefitId) {
		model.setTravelIntBenefitId(travelIntBenefitId);
	}

	/**
	 * Sets the user ID of this travel int benefit.
	 *
	 * @param userId the user ID of this travel int benefit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel int benefit.
	 *
	 * @param userName the user name of this travel int benefit
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel int benefit.
	 *
	 * @param userUuid the user uuid of this travel int benefit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelIntBenefitWrapper wrap(TravelIntBenefit travelIntBenefit) {
		return new TravelIntBenefitWrapper(travelIntBenefit);
	}

}