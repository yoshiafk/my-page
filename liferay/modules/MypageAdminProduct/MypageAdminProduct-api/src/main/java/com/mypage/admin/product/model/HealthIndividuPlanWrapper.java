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
 * This class is a wrapper for {@link HealthIndividuPlan}.
 * </p>
 *
 * @author Gositus Team
 * @see HealthIndividuPlan
 * @generated
 */
public class HealthIndividuPlanWrapper
	extends BaseModelWrapper<HealthIndividuPlan>
	implements HealthIndividuPlan, ModelWrapper<HealthIndividuPlan> {

	public HealthIndividuPlanWrapper(HealthIndividuPlan healthIndividuPlan) {
		super(healthIndividuPlan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("healthIndividuPlanId", getHealthIndividuPlanId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("limitYear", getLimitYear());
		attributes.put("limitDisability", getLimitDisability());
		attributes.put("inpatient", getInpatient());
		attributes.put("outpatient", getOutpatient());
		attributes.put("ambulanceService", getAmbulanceService());
		attributes.put("personalAccident", getPersonalAccident());
		attributes.put("detail", getDetail());
		attributes.put("benefit", getBenefit());
		attributes.put("benefitIcon", getBenefitIcon());
		attributes.put("recommended", getRecommended());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long healthIndividuPlanId = (Long)attributes.get(
			"healthIndividuPlanId");

		if (healthIndividuPlanId != null) {
			setHealthIndividuPlanId(healthIndividuPlanId);
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

		Long limitYear = (Long)attributes.get("limitYear");

		if (limitYear != null) {
			setLimitYear(limitYear);
		}

		Long limitDisability = (Long)attributes.get("limitDisability");

		if (limitDisability != null) {
			setLimitDisability(limitDisability);
		}

		Long inpatient = (Long)attributes.get("inpatient");

		if (inpatient != null) {
			setInpatient(inpatient);
		}

		Long outpatient = (Long)attributes.get("outpatient");

		if (outpatient != null) {
			setOutpatient(outpatient);
		}

		Long ambulanceService = (Long)attributes.get("ambulanceService");

		if (ambulanceService != null) {
			setAmbulanceService(ambulanceService);
		}

		Long personalAccident = (Long)attributes.get("personalAccident");

		if (personalAccident != null) {
			setPersonalAccident(personalAccident);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		String benefit = (String)attributes.get("benefit");

		if (benefit != null) {
			setBenefit(benefit);
		}

		String benefitIcon = (String)attributes.get("benefitIcon");

		if (benefitIcon != null) {
			setBenefitIcon(benefitIcon);
		}

		Integer recommended = (Integer)attributes.get("recommended");

		if (recommended != null) {
			setRecommended(recommended);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this health individu plan.
	 *
	 * @return the active of this health individu plan
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the ambulance service of this health individu plan.
	 *
	 * @return the ambulance service of this health individu plan
	 */
	@Override
	public long getAmbulanceService() {
		return model.getAmbulanceService();
	}

	/**
	 * Returns the benefit of this health individu plan.
	 *
	 * @return the benefit of this health individu plan
	 */
	@Override
	public String getBenefit() {
		return model.getBenefit();
	}

	/**
	 * Returns the benefit icon of this health individu plan.
	 *
	 * @return the benefit icon of this health individu plan
	 */
	@Override
	public String getBenefitIcon() {
		return model.getBenefitIcon();
	}

	/**
	 * Returns the company ID of this health individu plan.
	 *
	 * @return the company ID of this health individu plan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this health individu plan.
	 *
	 * @return the create date of this health individu plan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the detail of this health individu plan.
	 *
	 * @return the detail of this health individu plan
	 */
	@Override
	public String getDetail() {
		return model.getDetail();
	}

	/**
	 * Returns the group ID of this health individu plan.
	 *
	 * @return the group ID of this health individu plan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health individu plan ID of this health individu plan.
	 *
	 * @return the health individu plan ID of this health individu plan
	 */
	@Override
	public long getHealthIndividuPlanId() {
		return model.getHealthIndividuPlanId();
	}

	/**
	 * Returns the inpatient of this health individu plan.
	 *
	 * @return the inpatient of this health individu plan
	 */
	@Override
	public long getInpatient() {
		return model.getInpatient();
	}

	/**
	 * Returns the limit disability of this health individu plan.
	 *
	 * @return the limit disability of this health individu plan
	 */
	@Override
	public long getLimitDisability() {
		return model.getLimitDisability();
	}

	/**
	 * Returns the limit year of this health individu plan.
	 *
	 * @return the limit year of this health individu plan
	 */
	@Override
	public long getLimitYear() {
		return model.getLimitYear();
	}

	/**
	 * Returns the modified date of this health individu plan.
	 *
	 * @return the modified date of this health individu plan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this health individu plan.
	 *
	 * @return the name of this health individu plan
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the outpatient of this health individu plan.
	 *
	 * @return the outpatient of this health individu plan
	 */
	@Override
	public long getOutpatient() {
		return model.getOutpatient();
	}

	/**
	 * Returns the personal accident of this health individu plan.
	 *
	 * @return the personal accident of this health individu plan
	 */
	@Override
	public long getPersonalAccident() {
		return model.getPersonalAccident();
	}

	/**
	 * Returns the primary key of this health individu plan.
	 *
	 * @return the primary key of this health individu plan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recommended of this health individu plan.
	 *
	 * @return the recommended of this health individu plan
	 */
	@Override
	public int getRecommended() {
		return model.getRecommended();
	}

	/**
	 * Returns the user ID of this health individu plan.
	 *
	 * @return the user ID of this health individu plan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this health individu plan.
	 *
	 * @return the user name of this health individu plan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this health individu plan.
	 *
	 * @return the user uuid of this health individu plan
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
	 * Sets the active of this health individu plan.
	 *
	 * @param active the active of this health individu plan
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the ambulance service of this health individu plan.
	 *
	 * @param ambulanceService the ambulance service of this health individu plan
	 */
	@Override
	public void setAmbulanceService(long ambulanceService) {
		model.setAmbulanceService(ambulanceService);
	}

	/**
	 * Sets the benefit of this health individu plan.
	 *
	 * @param benefit the benefit of this health individu plan
	 */
	@Override
	public void setBenefit(String benefit) {
		model.setBenefit(benefit);
	}

	/**
	 * Sets the benefit icon of this health individu plan.
	 *
	 * @param benefitIcon the benefit icon of this health individu plan
	 */
	@Override
	public void setBenefitIcon(String benefitIcon) {
		model.setBenefitIcon(benefitIcon);
	}

	/**
	 * Sets the company ID of this health individu plan.
	 *
	 * @param companyId the company ID of this health individu plan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this health individu plan.
	 *
	 * @param createDate the create date of this health individu plan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the detail of this health individu plan.
	 *
	 * @param detail the detail of this health individu plan
	 */
	@Override
	public void setDetail(String detail) {
		model.setDetail(detail);
	}

	/**
	 * Sets the group ID of this health individu plan.
	 *
	 * @param groupId the group ID of this health individu plan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health individu plan ID of this health individu plan.
	 *
	 * @param healthIndividuPlanId the health individu plan ID of this health individu plan
	 */
	@Override
	public void setHealthIndividuPlanId(long healthIndividuPlanId) {
		model.setHealthIndividuPlanId(healthIndividuPlanId);
	}

	/**
	 * Sets the inpatient of this health individu plan.
	 *
	 * @param inpatient the inpatient of this health individu plan
	 */
	@Override
	public void setInpatient(long inpatient) {
		model.setInpatient(inpatient);
	}

	/**
	 * Sets the limit disability of this health individu plan.
	 *
	 * @param limitDisability the limit disability of this health individu plan
	 */
	@Override
	public void setLimitDisability(long limitDisability) {
		model.setLimitDisability(limitDisability);
	}

	/**
	 * Sets the limit year of this health individu plan.
	 *
	 * @param limitYear the limit year of this health individu plan
	 */
	@Override
	public void setLimitYear(long limitYear) {
		model.setLimitYear(limitYear);
	}

	/**
	 * Sets the modified date of this health individu plan.
	 *
	 * @param modifiedDate the modified date of this health individu plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this health individu plan.
	 *
	 * @param name the name of this health individu plan
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the outpatient of this health individu plan.
	 *
	 * @param outpatient the outpatient of this health individu plan
	 */
	@Override
	public void setOutpatient(long outpatient) {
		model.setOutpatient(outpatient);
	}

	/**
	 * Sets the personal accident of this health individu plan.
	 *
	 * @param personalAccident the personal accident of this health individu plan
	 */
	@Override
	public void setPersonalAccident(long personalAccident) {
		model.setPersonalAccident(personalAccident);
	}

	/**
	 * Sets the primary key of this health individu plan.
	 *
	 * @param primaryKey the primary key of this health individu plan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recommended of this health individu plan.
	 *
	 * @param recommended the recommended of this health individu plan
	 */
	@Override
	public void setRecommended(int recommended) {
		model.setRecommended(recommended);
	}

	/**
	 * Sets the user ID of this health individu plan.
	 *
	 * @param userId the user ID of this health individu plan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this health individu plan.
	 *
	 * @param userName the user name of this health individu plan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this health individu plan.
	 *
	 * @param userUuid the user uuid of this health individu plan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected HealthIndividuPlanWrapper wrap(
		HealthIndividuPlan healthIndividuPlan) {

		return new HealthIndividuPlanWrapper(healthIndividuPlan);
	}

}