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

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StiPremi}.
 * </p>
 *
 * @author Gositus Team
 * @see StiPremi
 * @generated
 */
public class StiPremiWrapper
	extends BaseModelWrapper<StiPremi>
	implements ModelWrapper<StiPremi>, StiPremi {

	public StiPremiWrapper(StiPremi stiPremi) {
		super(stiPremi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("premiId", getPremiId());
		attributes.put("travellerType", getTravellerType());
		attributes.put("currency", getCurrency());
		attributes.put("basic", getBasic());
		attributes.put("additional", getAdditional());
		attributes.put("annual", getAnnual());
		attributes.put("active", getActive());
		attributes.put("benefitId", getBenefitId());
		attributes.put("planId", getPlanId());
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
		Long premiId = (Long)attributes.get("premiId");

		if (premiId != null) {
			setPremiId(premiId);
		}

		String travellerType = (String)attributes.get("travellerType");

		if (travellerType != null) {
			setTravellerType(travellerType);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		BigDecimal basic = (BigDecimal)attributes.get("basic");

		if (basic != null) {
			setBasic(basic);
		}

		BigDecimal additional = (BigDecimal)attributes.get("additional");

		if (additional != null) {
			setAdditional(additional);
		}

		BigDecimal annual = (BigDecimal)attributes.get("annual");

		if (annual != null) {
			setAnnual(annual);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long benefitId = (Long)attributes.get("benefitId");

		if (benefitId != null) {
			setBenefitId(benefitId);
		}

		Long planId = (Long)attributes.get("planId");

		if (planId != null) {
			setPlanId(planId);
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
	 * Returns the active of this sti premi.
	 *
	 * @return the active of this sti premi
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the additional of this sti premi.
	 *
	 * @return the additional of this sti premi
	 */
	@Override
	public BigDecimal getAdditional() {
		return model.getAdditional();
	}

	/**
	 * Returns the annual of this sti premi.
	 *
	 * @return the annual of this sti premi
	 */
	@Override
	public BigDecimal getAnnual() {
		return model.getAnnual();
	}

	/**
	 * Returns the basic of this sti premi.
	 *
	 * @return the basic of this sti premi
	 */
	@Override
	public BigDecimal getBasic() {
		return model.getBasic();
	}

	/**
	 * Returns the benefit ID of this sti premi.
	 *
	 * @return the benefit ID of this sti premi
	 */
	@Override
	public long getBenefitId() {
		return model.getBenefitId();
	}

	/**
	 * Returns the company ID of this sti premi.
	 *
	 * @return the company ID of this sti premi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sti premi.
	 *
	 * @return the create date of this sti premi
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this sti premi.
	 *
	 * @return the currency of this sti premi
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the group ID of this sti premi.
	 *
	 * @return the group ID of this sti premi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this sti premi.
	 *
	 * @return the modified date of this sti premi
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan ID of this sti premi.
	 *
	 * @return the plan ID of this sti premi
	 */
	@Override
	public long getPlanId() {
		return model.getPlanId();
	}

	/**
	 * Returns the premi ID of this sti premi.
	 *
	 * @return the premi ID of this sti premi
	 */
	@Override
	public long getPremiId() {
		return model.getPremiId();
	}

	/**
	 * Returns the primary key of this sti premi.
	 *
	 * @return the primary key of this sti premi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the traveller type of this sti premi.
	 *
	 * @return the traveller type of this sti premi
	 */
	@Override
	public String getTravellerType() {
		return model.getTravellerType();
	}

	/**
	 * Returns the user ID of this sti premi.
	 *
	 * @return the user ID of this sti premi
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sti premi.
	 *
	 * @return the user name of this sti premi
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sti premi.
	 *
	 * @return the user uuid of this sti premi
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
	 * Sets the active of this sti premi.
	 *
	 * @param active the active of this sti premi
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the additional of this sti premi.
	 *
	 * @param additional the additional of this sti premi
	 */
	@Override
	public void setAdditional(BigDecimal additional) {
		model.setAdditional(additional);
	}

	/**
	 * Sets the annual of this sti premi.
	 *
	 * @param annual the annual of this sti premi
	 */
	@Override
	public void setAnnual(BigDecimal annual) {
		model.setAnnual(annual);
	}

	/**
	 * Sets the basic of this sti premi.
	 *
	 * @param basic the basic of this sti premi
	 */
	@Override
	public void setBasic(BigDecimal basic) {
		model.setBasic(basic);
	}

	/**
	 * Sets the benefit ID of this sti premi.
	 *
	 * @param benefitId the benefit ID of this sti premi
	 */
	@Override
	public void setBenefitId(long benefitId) {
		model.setBenefitId(benefitId);
	}

	/**
	 * Sets the company ID of this sti premi.
	 *
	 * @param companyId the company ID of this sti premi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sti premi.
	 *
	 * @param createDate the create date of this sti premi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this sti premi.
	 *
	 * @param currency the currency of this sti premi
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the group ID of this sti premi.
	 *
	 * @param groupId the group ID of this sti premi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this sti premi.
	 *
	 * @param modifiedDate the modified date of this sti premi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan ID of this sti premi.
	 *
	 * @param planId the plan ID of this sti premi
	 */
	@Override
	public void setPlanId(long planId) {
		model.setPlanId(planId);
	}

	/**
	 * Sets the premi ID of this sti premi.
	 *
	 * @param premiId the premi ID of this sti premi
	 */
	@Override
	public void setPremiId(long premiId) {
		model.setPremiId(premiId);
	}

	/**
	 * Sets the primary key of this sti premi.
	 *
	 * @param primaryKey the primary key of this sti premi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the traveller type of this sti premi.
	 *
	 * @param travellerType the traveller type of this sti premi
	 */
	@Override
	public void setTravellerType(String travellerType) {
		model.setTravellerType(travellerType);
	}

	/**
	 * Sets the user ID of this sti premi.
	 *
	 * @param userId the user ID of this sti premi
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sti premi.
	 *
	 * @param userName the user name of this sti premi
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sti premi.
	 *
	 * @param userUuid the user uuid of this sti premi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected StiPremiWrapper wrap(StiPremi stiPremi) {
		return new StiPremiWrapper(stiPremi);
	}

}