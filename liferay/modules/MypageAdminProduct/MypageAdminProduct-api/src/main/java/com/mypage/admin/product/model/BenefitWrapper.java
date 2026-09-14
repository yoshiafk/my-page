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
 * This class is a wrapper for {@link Benefit}.
 * </p>
 *
 * @author Gositus Team
 * @see Benefit
 * @generated
 */
public class BenefitWrapper
	extends BaseModelWrapper<Benefit>
	implements Benefit, ModelWrapper<Benefit> {

	public BenefitWrapper(Benefit benefit) {
		super(benefit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("benefitId", getBenefitId());
		attributes.put("nameId", getNameId());
		attributes.put("nameEn", getNameEn());
		attributes.put("sort", getSort());
		attributes.put("benefitTypeId", getBenefitTypeId());
		attributes.put("active", getActive());
		attributes.put("planName", getPlanName());
		attributes.put("benefitValue", getBenefitValue());
		attributes.put("externalCode", getExternalCode());
		attributes.put("benefitDescription", getBenefitDescription());
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
		Long benefitId = (Long)attributes.get("benefitId");

		if (benefitId != null) {
			setBenefitId(benefitId);
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

		Long benefitTypeId = (Long)attributes.get("benefitTypeId");

		if (benefitTypeId != null) {
			setBenefitTypeId(benefitTypeId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String planName = (String)attributes.get("planName");

		if (planName != null) {
			setPlanName(planName);
		}

		String benefitValue = (String)attributes.get("benefitValue");

		if (benefitValue != null) {
			setBenefitValue(benefitValue);
		}

		String externalCode = (String)attributes.get("externalCode");

		if (externalCode != null) {
			setExternalCode(externalCode);
		}

		String benefitDescription = (String)attributes.get(
			"benefitDescription");

		if (benefitDescription != null) {
			setBenefitDescription(benefitDescription);
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
	 * Returns the active of this benefit.
	 *
	 * @return the active of this benefit
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit description of this benefit.
	 *
	 * @return the benefit description of this benefit
	 */
	@Override
	public String getBenefitDescription() {
		return model.getBenefitDescription();
	}

	/**
	 * Returns the benefit ID of this benefit.
	 *
	 * @return the benefit ID of this benefit
	 */
	@Override
	public long getBenefitId() {
		return model.getBenefitId();
	}

	/**
	 * Returns the benefit type ID of this benefit.
	 *
	 * @return the benefit type ID of this benefit
	 */
	@Override
	public long getBenefitTypeId() {
		return model.getBenefitTypeId();
	}

	/**
	 * Returns the benefit value of this benefit.
	 *
	 * @return the benefit value of this benefit
	 */
	@Override
	public String getBenefitValue() {
		return model.getBenefitValue();
	}

	/**
	 * Returns the company ID of this benefit.
	 *
	 * @return the company ID of this benefit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this benefit.
	 *
	 * @return the create date of this benefit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external code of this benefit.
	 *
	 * @return the external code of this benefit
	 */
	@Override
	public String getExternalCode() {
		return model.getExternalCode();
	}

	/**
	 * Returns the group ID of this benefit.
	 *
	 * @return the group ID of this benefit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this benefit.
	 *
	 * @return the modified date of this benefit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name en of this benefit.
	 *
	 * @return the name en of this benefit
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the name ID of this benefit.
	 *
	 * @return the name ID of this benefit
	 */
	@Override
	public String getNameId() {
		return model.getNameId();
	}

	/**
	 * Returns the plan name of this benefit.
	 *
	 * @return the plan name of this benefit
	 */
	@Override
	public String getPlanName() {
		return model.getPlanName();
	}

	/**
	 * Returns the primary key of this benefit.
	 *
	 * @return the primary key of this benefit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this benefit.
	 *
	 * @return the sort of this benefit
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the user ID of this benefit.
	 *
	 * @return the user ID of this benefit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this benefit.
	 *
	 * @return the user name of this benefit
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this benefit.
	 *
	 * @return the user uuid of this benefit
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
	 * Sets the active of this benefit.
	 *
	 * @param active the active of this benefit
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit description of this benefit.
	 *
	 * @param benefitDescription the benefit description of this benefit
	 */
	@Override
	public void setBenefitDescription(String benefitDescription) {
		model.setBenefitDescription(benefitDescription);
	}

	/**
	 * Sets the benefit ID of this benefit.
	 *
	 * @param benefitId the benefit ID of this benefit
	 */
	@Override
	public void setBenefitId(long benefitId) {
		model.setBenefitId(benefitId);
	}

	/**
	 * Sets the benefit type ID of this benefit.
	 *
	 * @param benefitTypeId the benefit type ID of this benefit
	 */
	@Override
	public void setBenefitTypeId(long benefitTypeId) {
		model.setBenefitTypeId(benefitTypeId);
	}

	/**
	 * Sets the benefit value of this benefit.
	 *
	 * @param benefitValue the benefit value of this benefit
	 */
	@Override
	public void setBenefitValue(String benefitValue) {
		model.setBenefitValue(benefitValue);
	}

	/**
	 * Sets the company ID of this benefit.
	 *
	 * @param companyId the company ID of this benefit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this benefit.
	 *
	 * @param createDate the create date of this benefit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external code of this benefit.
	 *
	 * @param externalCode the external code of this benefit
	 */
	@Override
	public void setExternalCode(String externalCode) {
		model.setExternalCode(externalCode);
	}

	/**
	 * Sets the group ID of this benefit.
	 *
	 * @param groupId the group ID of this benefit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this benefit.
	 *
	 * @param modifiedDate the modified date of this benefit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name en of this benefit.
	 *
	 * @param nameEn the name en of this benefit
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the name ID of this benefit.
	 *
	 * @param nameId the name ID of this benefit
	 */
	@Override
	public void setNameId(String nameId) {
		model.setNameId(nameId);
	}

	/**
	 * Sets the plan name of this benefit.
	 *
	 * @param planName the plan name of this benefit
	 */
	@Override
	public void setPlanName(String planName) {
		model.setPlanName(planName);
	}

	/**
	 * Sets the primary key of this benefit.
	 *
	 * @param primaryKey the primary key of this benefit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this benefit.
	 *
	 * @param sort the sort of this benefit
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the user ID of this benefit.
	 *
	 * @param userId the user ID of this benefit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this benefit.
	 *
	 * @param userName the user name of this benefit
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this benefit.
	 *
	 * @param userUuid the user uuid of this benefit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected BenefitWrapper wrap(Benefit benefit) {
		return new BenefitWrapper(benefit);
	}

}