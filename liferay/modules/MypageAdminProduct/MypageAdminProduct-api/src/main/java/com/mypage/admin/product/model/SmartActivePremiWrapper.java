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
 * This class is a wrapper for {@link SmartActivePremi}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActivePremi
 * @generated
 */
public class SmartActivePremiWrapper
	extends BaseModelWrapper<SmartActivePremi>
	implements ModelWrapper<SmartActivePremi>, SmartActivePremi {

	public SmartActivePremiWrapper(SmartActivePremi smartActivePremi) {
		super(smartActivePremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartActivePremiId", getSmartActivePremiId());
		attributes.put("rate", getRate());
		attributes.put("active", getActive());
		attributes.put("smartActiveClassRateId", getSmartActiveClassRateId());
		attributes.put("smartActiveBenefitId", getSmartActiveBenefitId());
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
		Long smartActivePremiId = (Long)attributes.get("smartActivePremiId");

		if (smartActivePremiId != null) {
			setSmartActivePremiId(smartActivePremiId);
		}

		Double rate = (Double)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long smartActiveClassRateId = (Long)attributes.get(
			"smartActiveClassRateId");

		if (smartActiveClassRateId != null) {
			setSmartActiveClassRateId(smartActiveClassRateId);
		}

		Long smartActiveBenefitId = (Long)attributes.get(
			"smartActiveBenefitId");

		if (smartActiveBenefitId != null) {
			setSmartActiveBenefitId(smartActiveBenefitId);
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
	 * Returns the active of this smart active premi.
	 *
	 * @return the active of this smart active premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart active premi.
	 *
	 * @return the company ID of this smart active premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active premi.
	 *
	 * @return the create date of this smart active premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart active premi.
	 *
	 * @return the group ID of this smart active premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart active premi.
	 *
	 * @return the modified date of this smart active premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart active premi.
	 *
	 * @return the primary key of this smart active premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rate of this smart active premi.
	 *
	 * @return the rate of this smart active premi
	 */
	@Override
	public double getRate() {
		return model.getRate();
	}

	/**
	 * Returns the smart active benefit ID of this smart active premi.
	 *
	 * @return the smart active benefit ID of this smart active premi
	 */
	@Override
	public long getSmartActiveBenefitId() {
		return model.getSmartActiveBenefitId();
	}

	/**
	 * Returns the smart active class rate ID of this smart active premi.
	 *
	 * @return the smart active class rate ID of this smart active premi
	 */
	@Override
	public long getSmartActiveClassRateId() {
		return model.getSmartActiveClassRateId();
	}

	/**
	 * Returns the smart active premi ID of this smart active premi.
	 *
	 * @return the smart active premi ID of this smart active premi
	 */
	@Override
	public long getSmartActivePremiId() {
		return model.getSmartActivePremiId();
	}

	/**
	 * Returns the user ID of this smart active premi.
	 *
	 * @return the user ID of this smart active premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active premi.
	 *
	 * @return the user name of this smart active premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active premi.
	 *
	 * @return the user uuid of this smart active premi
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
	 * Sets the active of this smart active premi.
	 *
	 * @param active the active of this smart active premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart active premi.
	 *
	 * @param companyId the company ID of this smart active premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active premi.
	 *
	 * @param createDate the create date of this smart active premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart active premi.
	 *
	 * @param groupId the group ID of this smart active premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart active premi.
	 *
	 * @param modifiedDate the modified date of this smart active premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart active premi.
	 *
	 * @param primaryKey the primary key of this smart active premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rate of this smart active premi.
	 *
	 * @param rate the rate of this smart active premi
	 */
	@Override
	public void setRate(double rate) {
		model.setRate(rate);
	}

	/**
	 * Sets the smart active benefit ID of this smart active premi.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID of this smart active premi
	 */
	@Override
	public void setSmartActiveBenefitId(long smartActiveBenefitId) {
		model.setSmartActiveBenefitId(smartActiveBenefitId);
	}

	/**
	 * Sets the smart active class rate ID of this smart active premi.
	 *
	 * @param smartActiveClassRateId the smart active class rate ID of this smart active premi
	 */
	@Override
	public void setSmartActiveClassRateId(long smartActiveClassRateId) {
		model.setSmartActiveClassRateId(smartActiveClassRateId);
	}

	/**
	 * Sets the smart active premi ID of this smart active premi.
	 *
	 * @param smartActivePremiId the smart active premi ID of this smart active premi
	 */
	@Override
	public void setSmartActivePremiId(long smartActivePremiId) {
		model.setSmartActivePremiId(smartActivePremiId);
	}

	/**
	 * Sets the user ID of this smart active premi.
	 *
	 * @param userId the user ID of this smart active premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active premi.
	 *
	 * @param userName the user name of this smart active premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active premi.
	 *
	 * @param userUuid the user uuid of this smart active premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActivePremiWrapper wrap(SmartActivePremi smartActivePremi) {
		return new SmartActivePremiWrapper(smartActivePremi);
	}

}