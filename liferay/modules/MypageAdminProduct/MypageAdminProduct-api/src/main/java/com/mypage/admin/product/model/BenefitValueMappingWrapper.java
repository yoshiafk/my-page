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
 * This class is a wrapper for {@link BenefitValueMapping}.
 * </p>
 *
 * @author Gositus Team
 * @see BenefitValueMapping
 * @generated
 */
public class BenefitValueMappingWrapper
	extends BaseModelWrapper<BenefitValueMapping>
	implements BenefitValueMapping, ModelWrapper<BenefitValueMapping> {

	public BenefitValueMappingWrapper(BenefitValueMapping benefitValueMapping) {
		super(benefitValueMapping);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("benefitValueMappingId", getBenefitValueMappingId());
		attributes.put("benefitTypeId", getBenefitTypeId());
		attributes.put("benefitId", getBenefitId());
		attributes.put("planId", getPlanId());
		attributes.put("benefitValue", getBenefitValue());
		attributes.put("benefitValueUSD", getBenefitValueUSD());
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
		Long benefitValueMappingId = (Long)attributes.get(
			"benefitValueMappingId");

		if (benefitValueMappingId != null) {
			setBenefitValueMappingId(benefitValueMappingId);
		}

		Long benefitTypeId = (Long)attributes.get("benefitTypeId");

		if (benefitTypeId != null) {
			setBenefitTypeId(benefitTypeId);
		}

		Long benefitId = (Long)attributes.get("benefitId");

		if (benefitId != null) {
			setBenefitId(benefitId);
		}

		Long planId = (Long)attributes.get("planId");

		if (planId != null) {
			setPlanId(planId);
		}

		String benefitValue = (String)attributes.get("benefitValue");

		if (benefitValue != null) {
			setBenefitValue(benefitValue);
		}

		String benefitValueUSD = (String)attributes.get("benefitValueUSD");

		if (benefitValueUSD != null) {
			setBenefitValueUSD(benefitValueUSD);
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
	 * Returns the active of this benefit value mapping.
	 *
	 * @return the active of this benefit value mapping
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit ID of this benefit value mapping.
	 *
	 * @return the benefit ID of this benefit value mapping
	 */
	@Override
	public long getBenefitId() {
		return model.getBenefitId();
	}

	/**
	 * Returns the benefit type ID of this benefit value mapping.
	 *
	 * @return the benefit type ID of this benefit value mapping
	 */
	@Override
	public long getBenefitTypeId() {
		return model.getBenefitTypeId();
	}

	/**
	 * Returns the benefit value of this benefit value mapping.
	 *
	 * @return the benefit value of this benefit value mapping
	 */
	@Override
	public String getBenefitValue() {
		return model.getBenefitValue();
	}

	/**
	 * Returns the benefit value mapping ID of this benefit value mapping.
	 *
	 * @return the benefit value mapping ID of this benefit value mapping
	 */
	@Override
	public long getBenefitValueMappingId() {
		return model.getBenefitValueMappingId();
	}

	/**
	 * Returns the benefit value usd of this benefit value mapping.
	 *
	 * @return the benefit value usd of this benefit value mapping
	 */
	@Override
	public String getBenefitValueUSD() {
		return model.getBenefitValueUSD();
	}

	/**
	 * Returns the company ID of this benefit value mapping.
	 *
	 * @return the company ID of this benefit value mapping
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this benefit value mapping.
	 *
	 * @return the create date of this benefit value mapping
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this benefit value mapping.
	 *
	 * @return the group ID of this benefit value mapping
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this benefit value mapping.
	 *
	 * @return the modified date of this benefit value mapping
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan ID of this benefit value mapping.
	 *
	 * @return the plan ID of this benefit value mapping
	 */
	@Override
	public long getPlanId() {
		return model.getPlanId();
	}

	/**
	 * Returns the primary key of this benefit value mapping.
	 *
	 * @return the primary key of this benefit value mapping
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this benefit value mapping.
	 *
	 * @return the sort of this benefit value mapping
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the user ID of this benefit value mapping.
	 *
	 * @return the user ID of this benefit value mapping
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this benefit value mapping.
	 *
	 * @return the user name of this benefit value mapping
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this benefit value mapping.
	 *
	 * @return the user uuid of this benefit value mapping
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
	 * Sets the active of this benefit value mapping.
	 *
	 * @param active the active of this benefit value mapping
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit ID of this benefit value mapping.
	 *
	 * @param benefitId the benefit ID of this benefit value mapping
	 */
	@Override
	public void setBenefitId(long benefitId) {
		model.setBenefitId(benefitId);
	}

	/**
	 * Sets the benefit type ID of this benefit value mapping.
	 *
	 * @param benefitTypeId the benefit type ID of this benefit value mapping
	 */
	@Override
	public void setBenefitTypeId(long benefitTypeId) {
		model.setBenefitTypeId(benefitTypeId);
	}

	/**
	 * Sets the benefit value of this benefit value mapping.
	 *
	 * @param benefitValue the benefit value of this benefit value mapping
	 */
	@Override
	public void setBenefitValue(String benefitValue) {
		model.setBenefitValue(benefitValue);
	}

	/**
	 * Sets the benefit value mapping ID of this benefit value mapping.
	 *
	 * @param benefitValueMappingId the benefit value mapping ID of this benefit value mapping
	 */
	@Override
	public void setBenefitValueMappingId(long benefitValueMappingId) {
		model.setBenefitValueMappingId(benefitValueMappingId);
	}

	/**
	 * Sets the benefit value usd of this benefit value mapping.
	 *
	 * @param benefitValueUSD the benefit value usd of this benefit value mapping
	 */
	@Override
	public void setBenefitValueUSD(String benefitValueUSD) {
		model.setBenefitValueUSD(benefitValueUSD);
	}

	/**
	 * Sets the company ID of this benefit value mapping.
	 *
	 * @param companyId the company ID of this benefit value mapping
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this benefit value mapping.
	 *
	 * @param createDate the create date of this benefit value mapping
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this benefit value mapping.
	 *
	 * @param groupId the group ID of this benefit value mapping
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this benefit value mapping.
	 *
	 * @param modifiedDate the modified date of this benefit value mapping
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan ID of this benefit value mapping.
	 *
	 * @param planId the plan ID of this benefit value mapping
	 */
	@Override
	public void setPlanId(long planId) {
		model.setPlanId(planId);
	}

	/**
	 * Sets the primary key of this benefit value mapping.
	 *
	 * @param primaryKey the primary key of this benefit value mapping
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this benefit value mapping.
	 *
	 * @param sort the sort of this benefit value mapping
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the user ID of this benefit value mapping.
	 *
	 * @param userId the user ID of this benefit value mapping
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this benefit value mapping.
	 *
	 * @param userName the user name of this benefit value mapping
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this benefit value mapping.
	 *
	 * @param userUuid the user uuid of this benefit value mapping
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected BenefitValueMappingWrapper wrap(
		BenefitValueMapping benefitValueMapping) {

		return new BenefitValueMappingWrapper(benefitValueMapping);
	}

}