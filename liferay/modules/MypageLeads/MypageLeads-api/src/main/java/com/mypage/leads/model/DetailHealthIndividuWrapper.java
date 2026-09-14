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
 * This class is a wrapper for {@link DetailHealthIndividu}.
 * </p>
 *
 * @author Gositus
 * @see DetailHealthIndividu
 * @generated
 */
public class DetailHealthIndividuWrapper
	extends BaseModelWrapper<DetailHealthIndividu>
	implements DetailHealthIndividu, ModelWrapper<DetailHealthIndividu> {

	public DetailHealthIndividuWrapper(
		DetailHealthIndividu detailHealthIndividu) {

		super(detailHealthIndividu);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("detailHealthIndividuId", getDetailHealthIndividuId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("PlanId", getPlanId());
		attributes.put("PremiId", getPremiId());
		attributes.put("SameAddress", getSameAddress());
		attributes.put("CurrentAddress", getCurrentAddress());
		attributes.put("CurrentAddress2", getCurrentAddress2());
		attributes.put("CurrentZip", getCurrentZip());
		attributes.put("JobCat", getJobCat());
		attributes.put("JobType", getJobType());
		attributes.put("Job", getJob());
		attributes.put("JobPosition", getJobPosition());
		attributes.put("AccountBankNumber", getAccountBankNumber());
		attributes.put("AccountBankName", getAccountBankName());
		attributes.put("BankName", getBankName());
		attributes.put("HealthAgreement", getHealthAgreement());
		attributes.put("ChildAgreement", getChildAgreement());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long detailHealthIndividuId = (Long)attributes.get(
			"detailHealthIndividuId");

		if (detailHealthIndividuId != null) {
			setDetailHealthIndividuId(detailHealthIndividuId);
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

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		Long PlanId = (Long)attributes.get("PlanId");

		if (PlanId != null) {
			setPlanId(PlanId);
		}

		Long PremiId = (Long)attributes.get("PremiId");

		if (PremiId != null) {
			setPremiId(PremiId);
		}

		Integer SameAddress = (Integer)attributes.get("SameAddress");

		if (SameAddress != null) {
			setSameAddress(SameAddress);
		}

		String CurrentAddress = (String)attributes.get("CurrentAddress");

		if (CurrentAddress != null) {
			setCurrentAddress(CurrentAddress);
		}

		String CurrentAddress2 = (String)attributes.get("CurrentAddress2");

		if (CurrentAddress2 != null) {
			setCurrentAddress2(CurrentAddress2);
		}

		String CurrentZip = (String)attributes.get("CurrentZip");

		if (CurrentZip != null) {
			setCurrentZip(CurrentZip);
		}

		String JobCat = (String)attributes.get("JobCat");

		if (JobCat != null) {
			setJobCat(JobCat);
		}

		String JobType = (String)attributes.get("JobType");

		if (JobType != null) {
			setJobType(JobType);
		}

		String Job = (String)attributes.get("Job");

		if (Job != null) {
			setJob(Job);
		}

		String JobPosition = (String)attributes.get("JobPosition");

		if (JobPosition != null) {
			setJobPosition(JobPosition);
		}

		String AccountBankNumber = (String)attributes.get("AccountBankNumber");

		if (AccountBankNumber != null) {
			setAccountBankNumber(AccountBankNumber);
		}

		String AccountBankName = (String)attributes.get("AccountBankName");

		if (AccountBankName != null) {
			setAccountBankName(AccountBankName);
		}

		String BankName = (String)attributes.get("BankName");

		if (BankName != null) {
			setBankName(BankName);
		}

		Integer HealthAgreement = (Integer)attributes.get("HealthAgreement");

		if (HealthAgreement != null) {
			setHealthAgreement(HealthAgreement);
		}

		Integer ChildAgreement = (Integer)attributes.get("ChildAgreement");

		if (ChildAgreement != null) {
			setChildAgreement(ChildAgreement);
		}
	}

	/**
	 * Returns the account bank name of this detail health individu.
	 *
	 * @return the account bank name of this detail health individu
	 */
	@Override
	public String getAccountBankName() {
		return model.getAccountBankName();
	}

	/**
	 * Returns the account bank number of this detail health individu.
	 *
	 * @return the account bank number of this detail health individu
	 */
	@Override
	public String getAccountBankNumber() {
		return model.getAccountBankNumber();
	}

	/**
	 * Returns the bank name of this detail health individu.
	 *
	 * @return the bank name of this detail health individu
	 */
	@Override
	public String getBankName() {
		return model.getBankName();
	}

	/**
	 * Returns the child agreement of this detail health individu.
	 *
	 * @return the child agreement of this detail health individu
	 */
	@Override
	public Integer getChildAgreement() {
		return model.getChildAgreement();
	}

	/**
	 * Returns the company ID of this detail health individu.
	 *
	 * @return the company ID of this detail health individu
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this detail health individu.
	 *
	 * @return the create date of this detail health individu
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the current address of this detail health individu.
	 *
	 * @return the current address of this detail health individu
	 */
	@Override
	public String getCurrentAddress() {
		return model.getCurrentAddress();
	}

	/**
	 * Returns the current address2 of this detail health individu.
	 *
	 * @return the current address2 of this detail health individu
	 */
	@Override
	public String getCurrentAddress2() {
		return model.getCurrentAddress2();
	}

	/**
	 * Returns the current zip of this detail health individu.
	 *
	 * @return the current zip of this detail health individu
	 */
	@Override
	public String getCurrentZip() {
		return model.getCurrentZip();
	}

	/**
	 * Returns the detail health individu ID of this detail health individu.
	 *
	 * @return the detail health individu ID of this detail health individu
	 */
	@Override
	public long getDetailHealthIndividuId() {
		return model.getDetailHealthIndividuId();
	}

	/**
	 * Returns the group ID of this detail health individu.
	 *
	 * @return the group ID of this detail health individu
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the health agreement of this detail health individu.
	 *
	 * @return the health agreement of this detail health individu
	 */
	@Override
	public Integer getHealthAgreement() {
		return model.getHealthAgreement();
	}

	/**
	 * Returns the job of this detail health individu.
	 *
	 * @return the job of this detail health individu
	 */
	@Override
	public String getJob() {
		return model.getJob();
	}

	/**
	 * Returns the job cat of this detail health individu.
	 *
	 * @return the job cat of this detail health individu
	 */
	@Override
	public String getJobCat() {
		return model.getJobCat();
	}

	/**
	 * Returns the job position of this detail health individu.
	 *
	 * @return the job position of this detail health individu
	 */
	@Override
	public String getJobPosition() {
		return model.getJobPosition();
	}

	/**
	 * Returns the job type of this detail health individu.
	 *
	 * @return the job type of this detail health individu
	 */
	@Override
	public String getJobType() {
		return model.getJobType();
	}

	/**
	 * Returns the leads ID of this detail health individu.
	 *
	 * @return the leads ID of this detail health individu
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the modified date of this detail health individu.
	 *
	 * @return the modified date of this detail health individu
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan ID of this detail health individu.
	 *
	 * @return the plan ID of this detail health individu
	 */
	@Override
	public long getPlanId() {
		return model.getPlanId();
	}

	/**
	 * Returns the premi ID of this detail health individu.
	 *
	 * @return the premi ID of this detail health individu
	 */
	@Override
	public long getPremiId() {
		return model.getPremiId();
	}

	/**
	 * Returns the primary key of this detail health individu.
	 *
	 * @return the primary key of this detail health individu
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the same address of this detail health individu.
	 *
	 * @return the same address of this detail health individu
	 */
	@Override
	public Integer getSameAddress() {
		return model.getSameAddress();
	}

	/**
	 * Returns the user ID of this detail health individu.
	 *
	 * @return the user ID of this detail health individu
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail health individu.
	 *
	 * @return the user name of this detail health individu
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail health individu.
	 *
	 * @return the user uuid of this detail health individu
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
	 * Sets the account bank name of this detail health individu.
	 *
	 * @param AccountBankName the account bank name of this detail health individu
	 */
	@Override
	public void setAccountBankName(String AccountBankName) {
		model.setAccountBankName(AccountBankName);
	}

	/**
	 * Sets the account bank number of this detail health individu.
	 *
	 * @param AccountBankNumber the account bank number of this detail health individu
	 */
	@Override
	public void setAccountBankNumber(String AccountBankNumber) {
		model.setAccountBankNumber(AccountBankNumber);
	}

	/**
	 * Sets the bank name of this detail health individu.
	 *
	 * @param BankName the bank name of this detail health individu
	 */
	@Override
	public void setBankName(String BankName) {
		model.setBankName(BankName);
	}

	/**
	 * Sets the child agreement of this detail health individu.
	 *
	 * @param ChildAgreement the child agreement of this detail health individu
	 */
	@Override
	public void setChildAgreement(Integer ChildAgreement) {
		model.setChildAgreement(ChildAgreement);
	}

	/**
	 * Sets the company ID of this detail health individu.
	 *
	 * @param companyId the company ID of this detail health individu
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this detail health individu.
	 *
	 * @param createDate the create date of this detail health individu
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the current address of this detail health individu.
	 *
	 * @param CurrentAddress the current address of this detail health individu
	 */
	@Override
	public void setCurrentAddress(String CurrentAddress) {
		model.setCurrentAddress(CurrentAddress);
	}

	/**
	 * Sets the current address2 of this detail health individu.
	 *
	 * @param CurrentAddress2 the current address2 of this detail health individu
	 */
	@Override
	public void setCurrentAddress2(String CurrentAddress2) {
		model.setCurrentAddress2(CurrentAddress2);
	}

	/**
	 * Sets the current zip of this detail health individu.
	 *
	 * @param CurrentZip the current zip of this detail health individu
	 */
	@Override
	public void setCurrentZip(String CurrentZip) {
		model.setCurrentZip(CurrentZip);
	}

	/**
	 * Sets the detail health individu ID of this detail health individu.
	 *
	 * @param detailHealthIndividuId the detail health individu ID of this detail health individu
	 */
	@Override
	public void setDetailHealthIndividuId(long detailHealthIndividuId) {
		model.setDetailHealthIndividuId(detailHealthIndividuId);
	}

	/**
	 * Sets the group ID of this detail health individu.
	 *
	 * @param groupId the group ID of this detail health individu
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the health agreement of this detail health individu.
	 *
	 * @param HealthAgreement the health agreement of this detail health individu
	 */
	@Override
	public void setHealthAgreement(Integer HealthAgreement) {
		model.setHealthAgreement(HealthAgreement);
	}

	/**
	 * Sets the job of this detail health individu.
	 *
	 * @param Job the job of this detail health individu
	 */
	@Override
	public void setJob(String Job) {
		model.setJob(Job);
	}

	/**
	 * Sets the job cat of this detail health individu.
	 *
	 * @param JobCat the job cat of this detail health individu
	 */
	@Override
	public void setJobCat(String JobCat) {
		model.setJobCat(JobCat);
	}

	/**
	 * Sets the job position of this detail health individu.
	 *
	 * @param JobPosition the job position of this detail health individu
	 */
	@Override
	public void setJobPosition(String JobPosition) {
		model.setJobPosition(JobPosition);
	}

	/**
	 * Sets the job type of this detail health individu.
	 *
	 * @param JobType the job type of this detail health individu
	 */
	@Override
	public void setJobType(String JobType) {
		model.setJobType(JobType);
	}

	/**
	 * Sets the leads ID of this detail health individu.
	 *
	 * @param LeadsId the leads ID of this detail health individu
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the modified date of this detail health individu.
	 *
	 * @param modifiedDate the modified date of this detail health individu
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan ID of this detail health individu.
	 *
	 * @param PlanId the plan ID of this detail health individu
	 */
	@Override
	public void setPlanId(long PlanId) {
		model.setPlanId(PlanId);
	}

	/**
	 * Sets the premi ID of this detail health individu.
	 *
	 * @param PremiId the premi ID of this detail health individu
	 */
	@Override
	public void setPremiId(long PremiId) {
		model.setPremiId(PremiId);
	}

	/**
	 * Sets the primary key of this detail health individu.
	 *
	 * @param primaryKey the primary key of this detail health individu
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the same address of this detail health individu.
	 *
	 * @param SameAddress the same address of this detail health individu
	 */
	@Override
	public void setSameAddress(Integer SameAddress) {
		model.setSameAddress(SameAddress);
	}

	/**
	 * Sets the user ID of this detail health individu.
	 *
	 * @param userId the user ID of this detail health individu
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail health individu.
	 *
	 * @param userName the user name of this detail health individu
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail health individu.
	 *
	 * @param userUuid the user uuid of this detail health individu
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DetailHealthIndividuWrapper wrap(
		DetailHealthIndividu detailHealthIndividu) {

		return new DetailHealthIndividuWrapper(detailHealthIndividu);
	}

}