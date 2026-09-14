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
 * This class is a wrapper for {@link SmartActiveBenefit}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefit
 * @generated
 */
public class SmartActiveBenefitWrapper
	extends BaseModelWrapper<SmartActiveBenefit>
	implements ModelWrapper<SmartActiveBenefit>, SmartActiveBenefit {

	public SmartActiveBenefitWrapper(SmartActiveBenefit smartActiveBenefit) {
		super(smartActiveBenefit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartActiveBenefitId", getSmartActiveBenefitId());
		attributes.put("nameId", getNameId());
		attributes.put("nameEn", getNameEn());
		attributes.put("sort", getSort());
		attributes.put(
			"smartActiveBenefitTypeId", getSmartActiveBenefitTypeId());
		attributes.put("active", getActive());
		attributes.put("description", getDescription());
		attributes.put("limit_", getLimit_());
		attributes.put("externalCode", getExternalCode());
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
		Long smartActiveBenefitId = (Long)attributes.get(
			"smartActiveBenefitId");

		if (smartActiveBenefitId != null) {
			setSmartActiveBenefitId(smartActiveBenefitId);
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

		Long smartActiveBenefitTypeId = (Long)attributes.get(
			"smartActiveBenefitTypeId");

		if (smartActiveBenefitTypeId != null) {
			setSmartActiveBenefitTypeId(smartActiveBenefitTypeId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String limit_ = (String)attributes.get("limit_");

		if (limit_ != null) {
			setLimit_(limit_);
		}

		String externalCode = (String)attributes.get("externalCode");

		if (externalCode != null) {
			setExternalCode(externalCode);
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
	 * Returns the active of this smart active benefit.
	 *
	 * @return the active of this smart active benefit
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart active benefit.
	 *
	 * @return the company ID of this smart active benefit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active benefit.
	 *
	 * @return the create date of this smart active benefit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this smart active benefit.
	 *
	 * @return the description of this smart active benefit
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external code of this smart active benefit.
	 *
	 * @return the external code of this smart active benefit
	 */
	@Override
	public String getExternalCode() {
		return model.getExternalCode();
	}

	/**
	 * Returns the group ID of this smart active benefit.
	 *
	 * @return the group ID of this smart active benefit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the limit_ of this smart active benefit.
	 *
	 * @return the limit_ of this smart active benefit
	 */
	@Override
	public String getLimit_() {
		return model.getLimit_();
	}

	/**
	 * Returns the modified date of this smart active benefit.
	 *
	 * @return the modified date of this smart active benefit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name en of this smart active benefit.
	 *
	 * @return the name en of this smart active benefit
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the name ID of this smart active benefit.
	 *
	 * @return the name ID of this smart active benefit
	 */
	@Override
	public String getNameId() {
		return model.getNameId();
	}

	/**
	 * Returns the primary key of this smart active benefit.
	 *
	 * @return the primary key of this smart active benefit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active benefit ID of this smart active benefit.
	 *
	 * @return the smart active benefit ID of this smart active benefit
	 */
	@Override
	public long getSmartActiveBenefitId() {
		return model.getSmartActiveBenefitId();
	}

	/**
	 * Returns the smart active benefit type ID of this smart active benefit.
	 *
	 * @return the smart active benefit type ID of this smart active benefit
	 */
	@Override
	public long getSmartActiveBenefitTypeId() {
		return model.getSmartActiveBenefitTypeId();
	}

	/**
	 * Returns the sort of this smart active benefit.
	 *
	 * @return the sort of this smart active benefit
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the user ID of this smart active benefit.
	 *
	 * @return the user ID of this smart active benefit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active benefit.
	 *
	 * @return the user name of this smart active benefit
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active benefit.
	 *
	 * @return the user uuid of this smart active benefit
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
	 * Sets the active of this smart active benefit.
	 *
	 * @param active the active of this smart active benefit
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart active benefit.
	 *
	 * @param companyId the company ID of this smart active benefit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active benefit.
	 *
	 * @param createDate the create date of this smart active benefit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this smart active benefit.
	 *
	 * @param description the description of this smart active benefit
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external code of this smart active benefit.
	 *
	 * @param externalCode the external code of this smart active benefit
	 */
	@Override
	public void setExternalCode(String externalCode) {
		model.setExternalCode(externalCode);
	}

	/**
	 * Sets the group ID of this smart active benefit.
	 *
	 * @param groupId the group ID of this smart active benefit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the limit_ of this smart active benefit.
	 *
	 * @param limit_ the limit_ of this smart active benefit
	 */
	@Override
	public void setLimit_(String limit_) {
		model.setLimit_(limit_);
	}

	/**
	 * Sets the modified date of this smart active benefit.
	 *
	 * @param modifiedDate the modified date of this smart active benefit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name en of this smart active benefit.
	 *
	 * @param nameEn the name en of this smart active benefit
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the name ID of this smart active benefit.
	 *
	 * @param nameId the name ID of this smart active benefit
	 */
	@Override
	public void setNameId(String nameId) {
		model.setNameId(nameId);
	}

	/**
	 * Sets the primary key of this smart active benefit.
	 *
	 * @param primaryKey the primary key of this smart active benefit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active benefit ID of this smart active benefit.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID of this smart active benefit
	 */
	@Override
	public void setSmartActiveBenefitId(long smartActiveBenefitId) {
		model.setSmartActiveBenefitId(smartActiveBenefitId);
	}

	/**
	 * Sets the smart active benefit type ID of this smart active benefit.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID of this smart active benefit
	 */
	@Override
	public void setSmartActiveBenefitTypeId(long smartActiveBenefitTypeId) {
		model.setSmartActiveBenefitTypeId(smartActiveBenefitTypeId);
	}

	/**
	 * Sets the sort of this smart active benefit.
	 *
	 * @param sort the sort of this smart active benefit
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the user ID of this smart active benefit.
	 *
	 * @param userId the user ID of this smart active benefit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active benefit.
	 *
	 * @param userName the user name of this smart active benefit
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active benefit.
	 *
	 * @param userUuid the user uuid of this smart active benefit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActiveBenefitWrapper wrap(
		SmartActiveBenefit smartActiveBenefit) {

		return new SmartActiveBenefitWrapper(smartActiveBenefit);
	}

}