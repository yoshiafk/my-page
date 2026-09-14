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
 * This class is a wrapper for {@link SmartHealthBenefit}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthBenefit
 * @generated
 */
public class SmartHealthBenefitWrapper
	extends BaseModelWrapper<SmartHealthBenefit>
	implements ModelWrapper<SmartHealthBenefit>, SmartHealthBenefit {

	public SmartHealthBenefitWrapper(SmartHealthBenefit smartHealthBenefit) {
		super(smartHealthBenefit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartHealthBenefitId", getSmartHealthBenefitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("benefitTitle", getBenefitTitle());
		attributes.put("benefitContent", getBenefitContent());
		attributes.put(
			"smartHealthBenefitGroupId", getSmartHealthBenefitGroupId());
		attributes.put("smartHealthPlanId", getSmartHealthPlanId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long smartHealthBenefitId = (Long)attributes.get(
			"smartHealthBenefitId");

		if (smartHealthBenefitId != null) {
			setSmartHealthBenefitId(smartHealthBenefitId);
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

		String benefitTitle = (String)attributes.get("benefitTitle");

		if (benefitTitle != null) {
			setBenefitTitle(benefitTitle);
		}

		String benefitContent = (String)attributes.get("benefitContent");

		if (benefitContent != null) {
			setBenefitContent(benefitContent);
		}

		Long smartHealthBenefitGroupId = (Long)attributes.get(
			"smartHealthBenefitGroupId");

		if (smartHealthBenefitGroupId != null) {
			setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
		}

		Long smartHealthPlanId = (Long)attributes.get("smartHealthPlanId");

		if (smartHealthPlanId != null) {
			setSmartHealthPlanId(smartHealthPlanId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this smart health benefit.
	 *
	 * @return the active of this smart health benefit
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit content of this smart health benefit.
	 *
	 * @return the benefit content of this smart health benefit
	 */
	@Override
	public String getBenefitContent() {
		return model.getBenefitContent();
	}

	/**
	 * Returns the benefit title of this smart health benefit.
	 *
	 * @return the benefit title of this smart health benefit
	 */
	@Override
	public String getBenefitTitle() {
		return model.getBenefitTitle();
	}

	/**
	 * Returns the company ID of this smart health benefit.
	 *
	 * @return the company ID of this smart health benefit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart health benefit.
	 *
	 * @return the create date of this smart health benefit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart health benefit.
	 *
	 * @return the group ID of this smart health benefit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart health benefit.
	 *
	 * @return the modified date of this smart health benefit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart health benefit.
	 *
	 * @return the primary key of this smart health benefit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart health benefit group ID of this smart health benefit.
	 *
	 * @return the smart health benefit group ID of this smart health benefit
	 */
	@Override
	public long getSmartHealthBenefitGroupId() {
		return model.getSmartHealthBenefitGroupId();
	}

	/**
	 * Returns the smart health benefit ID of this smart health benefit.
	 *
	 * @return the smart health benefit ID of this smart health benefit
	 */
	@Override
	public long getSmartHealthBenefitId() {
		return model.getSmartHealthBenefitId();
	}

	/**
	 * Returns the smart health plan ID of this smart health benefit.
	 *
	 * @return the smart health plan ID of this smart health benefit
	 */
	@Override
	public long getSmartHealthPlanId() {
		return model.getSmartHealthPlanId();
	}

	/**
	 * Returns the user ID of this smart health benefit.
	 *
	 * @return the user ID of this smart health benefit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart health benefit.
	 *
	 * @return the user name of this smart health benefit
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart health benefit.
	 *
	 * @return the user uuid of this smart health benefit
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
	 * Sets the active of this smart health benefit.
	 *
	 * @param active the active of this smart health benefit
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit content of this smart health benefit.
	 *
	 * @param benefitContent the benefit content of this smart health benefit
	 */
	@Override
	public void setBenefitContent(String benefitContent) {
		model.setBenefitContent(benefitContent);
	}

	/**
	 * Sets the benefit title of this smart health benefit.
	 *
	 * @param benefitTitle the benefit title of this smart health benefit
	 */
	@Override
	public void setBenefitTitle(String benefitTitle) {
		model.setBenefitTitle(benefitTitle);
	}

	/**
	 * Sets the company ID of this smart health benefit.
	 *
	 * @param companyId the company ID of this smart health benefit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart health benefit.
	 *
	 * @param createDate the create date of this smart health benefit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart health benefit.
	 *
	 * @param groupId the group ID of this smart health benefit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart health benefit.
	 *
	 * @param modifiedDate the modified date of this smart health benefit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart health benefit.
	 *
	 * @param primaryKey the primary key of this smart health benefit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart health benefit group ID of this smart health benefit.
	 *
	 * @param smartHealthBenefitGroupId the smart health benefit group ID of this smart health benefit
	 */
	@Override
	public void setSmartHealthBenefitGroupId(long smartHealthBenefitGroupId) {
		model.setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
	}

	/**
	 * Sets the smart health benefit ID of this smart health benefit.
	 *
	 * @param smartHealthBenefitId the smart health benefit ID of this smart health benefit
	 */
	@Override
	public void setSmartHealthBenefitId(long smartHealthBenefitId) {
		model.setSmartHealthBenefitId(smartHealthBenefitId);
	}

	/**
	 * Sets the smart health plan ID of this smart health benefit.
	 *
	 * @param smartHealthPlanId the smart health plan ID of this smart health benefit
	 */
	@Override
	public void setSmartHealthPlanId(long smartHealthPlanId) {
		model.setSmartHealthPlanId(smartHealthPlanId);
	}

	/**
	 * Sets the user ID of this smart health benefit.
	 *
	 * @param userId the user ID of this smart health benefit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart health benefit.
	 *
	 * @param userName the user name of this smart health benefit
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart health benefit.
	 *
	 * @param userUuid the user uuid of this smart health benefit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartHealthBenefitWrapper wrap(
		SmartHealthBenefit smartHealthBenefit) {

		return new SmartHealthBenefitWrapper(smartHealthBenefit);
	}

}