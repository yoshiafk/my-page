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

package com.mypage.leads.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DetailSmartactive}.
 * </p>
 *
 * @author Gositus
 * @see DetailSmartactive
 * @generated
 */
public class DetailSmartactiveWrapper
	extends BaseModelWrapper<DetailSmartactive>
	implements DetailSmartactive, ModelWrapper<DetailSmartactive> {

	public DetailSmartactiveWrapper(DetailSmartactive detailSmartactive) {
		super(detailSmartactive);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("DetailId", getDetailId());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("ExcludedActivityStatus", getExcludedActivityStatus());
		attributes.put("JobType", getJobType());
		attributes.put("MainBenefitValue", getMainBenefitValue());
		attributes.put("StartPeriode", getStartPeriode());
		attributes.put("EndPeriode", getEndPeriode());
		attributes.put("ListBenefitId", getListBenefitId());
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
		Long DetailId = (Long)attributes.get("DetailId");

		if (DetailId != null) {
			setDetailId(DetailId);
		}

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		Integer ExcludedActivityStatus = (Integer)attributes.get(
			"ExcludedActivityStatus");

		if (ExcludedActivityStatus != null) {
			setExcludedActivityStatus(ExcludedActivityStatus);
		}

		Long JobType = (Long)attributes.get("JobType");

		if (JobType != null) {
			setJobType(JobType);
		}

		String MainBenefitValue = (String)attributes.get("MainBenefitValue");

		if (MainBenefitValue != null) {
			setMainBenefitValue(MainBenefitValue);
		}

		Date StartPeriode = (Date)attributes.get("StartPeriode");

		if (StartPeriode != null) {
			setStartPeriode(StartPeriode);
		}

		Date EndPeriode = (Date)attributes.get("EndPeriode");

		if (EndPeriode != null) {
			setEndPeriode(EndPeriode);
		}

		String ListBenefitId = (String)attributes.get("ListBenefitId");

		if (ListBenefitId != null) {
			setListBenefitId(ListBenefitId);
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
	 * Returns the company ID of this detail smartactive.
	 *
	 * @return the company ID of this detail smartactive
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this detail smartactive.
	 *
	 * @return the create date of this detail smartactive
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the detail ID of this detail smartactive.
	 *
	 * @return the detail ID of this detail smartactive
	 */
	@Override
	public long getDetailId() {
		return model.getDetailId();
	}

	/**
	 * Returns the end periode of this detail smartactive.
	 *
	 * @return the end periode of this detail smartactive
	 */
	@Override
	public Date getEndPeriode() {
		return model.getEndPeriode();
	}

	/**
	 * Returns the excluded activity status of this detail smartactive.
	 *
	 * @return the excluded activity status of this detail smartactive
	 */
	@Override
	public int getExcludedActivityStatus() {
		return model.getExcludedActivityStatus();
	}

	/**
	 * Returns the group ID of this detail smartactive.
	 *
	 * @return the group ID of this detail smartactive
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job type of this detail smartactive.
	 *
	 * @return the job type of this detail smartactive
	 */
	@Override
	public long getJobType() {
		return model.getJobType();
	}

	/**
	 * Returns the leads ID of this detail smartactive.
	 *
	 * @return the leads ID of this detail smartactive
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the list benefit ID of this detail smartactive.
	 *
	 * @return the list benefit ID of this detail smartactive
	 */
	@Override
	public String getListBenefitId() {
		return model.getListBenefitId();
	}

	/**
	 * Returns the main benefit value of this detail smartactive.
	 *
	 * @return the main benefit value of this detail smartactive
	 */
	@Override
	public String getMainBenefitValue() {
		return model.getMainBenefitValue();
	}

	/**
	 * Returns the modified date of this detail smartactive.
	 *
	 * @return the modified date of this detail smartactive
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this detail smartactive.
	 *
	 * @return the primary key of this detail smartactive
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start periode of this detail smartactive.
	 *
	 * @return the start periode of this detail smartactive
	 */
	@Override
	public Date getStartPeriode() {
		return model.getStartPeriode();
	}

	/**
	 * Returns the user ID of this detail smartactive.
	 *
	 * @return the user ID of this detail smartactive
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail smartactive.
	 *
	 * @return the user name of this detail smartactive
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail smartactive.
	 *
	 * @return the user uuid of this detail smartactive
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
	 * Sets the company ID of this detail smartactive.
	 *
	 * @param companyId the company ID of this detail smartactive
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this detail smartactive.
	 *
	 * @param createDate the create date of this detail smartactive
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the detail ID of this detail smartactive.
	 *
	 * @param DetailId the detail ID of this detail smartactive
	 */
	@Override
	public void setDetailId(long DetailId) {
		model.setDetailId(DetailId);
	}

	/**
	 * Sets the end periode of this detail smartactive.
	 *
	 * @param EndPeriode the end periode of this detail smartactive
	 */
	@Override
	public void setEndPeriode(Date EndPeriode) {
		model.setEndPeriode(EndPeriode);
	}

	/**
	 * Sets the excluded activity status of this detail smartactive.
	 *
	 * @param ExcludedActivityStatus the excluded activity status of this detail smartactive
	 */
	@Override
	public void setExcludedActivityStatus(int ExcludedActivityStatus) {
		model.setExcludedActivityStatus(ExcludedActivityStatus);
	}

	/**
	 * Sets the group ID of this detail smartactive.
	 *
	 * @param groupId the group ID of this detail smartactive
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job type of this detail smartactive.
	 *
	 * @param JobType the job type of this detail smartactive
	 */
	@Override
	public void setJobType(long JobType) {
		model.setJobType(JobType);
	}

	/**
	 * Sets the leads ID of this detail smartactive.
	 *
	 * @param LeadsId the leads ID of this detail smartactive
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the list benefit ID of this detail smartactive.
	 *
	 * @param ListBenefitId the list benefit ID of this detail smartactive
	 */
	@Override
	public void setListBenefitId(String ListBenefitId) {
		model.setListBenefitId(ListBenefitId);
	}

	/**
	 * Sets the main benefit value of this detail smartactive.
	 *
	 * @param MainBenefitValue the main benefit value of this detail smartactive
	 */
	@Override
	public void setMainBenefitValue(String MainBenefitValue) {
		model.setMainBenefitValue(MainBenefitValue);
	}

	/**
	 * Sets the modified date of this detail smartactive.
	 *
	 * @param modifiedDate the modified date of this detail smartactive
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this detail smartactive.
	 *
	 * @param primaryKey the primary key of this detail smartactive
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start periode of this detail smartactive.
	 *
	 * @param StartPeriode the start periode of this detail smartactive
	 */
	@Override
	public void setStartPeriode(Date StartPeriode) {
		model.setStartPeriode(StartPeriode);
	}

	/**
	 * Sets the user ID of this detail smartactive.
	 *
	 * @param userId the user ID of this detail smartactive
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail smartactive.
	 *
	 * @param userName the user name of this detail smartactive
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail smartactive.
	 *
	 * @param userUuid the user uuid of this detail smartactive
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DetailSmartactiveWrapper wrap(
		DetailSmartactive detailSmartactive) {

		return new DetailSmartactiveWrapper(detailSmartactive);
	}

}