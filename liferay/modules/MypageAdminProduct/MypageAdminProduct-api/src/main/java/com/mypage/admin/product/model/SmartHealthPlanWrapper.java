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
 * This class is a wrapper for {@link SmartHealthPlan}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthPlan
 * @generated
 */
public class SmartHealthPlanWrapper
	extends BaseModelWrapper<SmartHealthPlan>
	implements ModelWrapper<SmartHealthPlan>, SmartHealthPlan {

	public SmartHealthPlanWrapper(SmartHealthPlan smartHealthPlan) {
		super(smartHealthPlan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartHealthPlanId", getSmartHealthPlanId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("planName", getPlanName());
		attributes.put("planGroup", getPlanGroup());
		attributes.put("isRecommended", getIsRecommended());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long smartHealthPlanId = (Long)attributes.get("smartHealthPlanId");

		if (smartHealthPlanId != null) {
			setSmartHealthPlanId(smartHealthPlanId);
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

		String planName = (String)attributes.get("planName");

		if (planName != null) {
			setPlanName(planName);
		}

		String planGroup = (String)attributes.get("planGroup");

		if (planGroup != null) {
			setPlanGroup(planGroup);
		}

		Integer isRecommended = (Integer)attributes.get("isRecommended");

		if (isRecommended != null) {
			setIsRecommended(isRecommended);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this smart health plan.
	 *
	 * @return the active of this smart health plan
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this smart health plan.
	 *
	 * @return the company ID of this smart health plan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart health plan.
	 *
	 * @return the create date of this smart health plan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart health plan.
	 *
	 * @return the group ID of this smart health plan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is recommended of this smart health plan.
	 *
	 * @return the is recommended of this smart health plan
	 */
	@Override
	public Integer getIsRecommended() {
		return model.getIsRecommended();
	}

	/**
	 * Returns the modified date of this smart health plan.
	 *
	 * @return the modified date of this smart health plan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plan group of this smart health plan.
	 *
	 * @return the plan group of this smart health plan
	 */
	@Override
	public String getPlanGroup() {
		return model.getPlanGroup();
	}

	/**
	 * Returns the plan name of this smart health plan.
	 *
	 * @return the plan name of this smart health plan
	 */
	@Override
	public String getPlanName() {
		return model.getPlanName();
	}

	/**
	 * Returns the primary key of this smart health plan.
	 *
	 * @return the primary key of this smart health plan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart health plan ID of this smart health plan.
	 *
	 * @return the smart health plan ID of this smart health plan
	 */
	@Override
	public long getSmartHealthPlanId() {
		return model.getSmartHealthPlanId();
	}

	/**
	 * Returns the status of this smart health plan.
	 *
	 * @return the status of this smart health plan
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this smart health plan was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this smart health plan.
	 *
	 * @return the trash entry created when this smart health plan was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this smart health plan.
	 *
	 * @return the class primary key of the trash entry for this smart health plan
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this smart health plan.
	 *
	 * @return the trash handler for this smart health plan
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this smart health plan.
	 *
	 * @return the user ID of this smart health plan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart health plan.
	 *
	 * @return the user name of this smart health plan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart health plan.
	 *
	 * @return the user uuid of this smart health plan
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this smart health plan is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this smart health plan is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this smart health plan is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this smart health plan is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this smart health plan.
	 *
	 * @param active the active of this smart health plan
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this smart health plan.
	 *
	 * @param companyId the company ID of this smart health plan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart health plan.
	 *
	 * @param createDate the create date of this smart health plan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart health plan.
	 *
	 * @param groupId the group ID of this smart health plan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is recommended of this smart health plan.
	 *
	 * @param isRecommended the is recommended of this smart health plan
	 */
	@Override
	public void setIsRecommended(Integer isRecommended) {
		model.setIsRecommended(isRecommended);
	}

	/**
	 * Sets the modified date of this smart health plan.
	 *
	 * @param modifiedDate the modified date of this smart health plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plan group of this smart health plan.
	 *
	 * @param planGroup the plan group of this smart health plan
	 */
	@Override
	public void setPlanGroup(String planGroup) {
		model.setPlanGroup(planGroup);
	}

	/**
	 * Sets the plan name of this smart health plan.
	 *
	 * @param planName the plan name of this smart health plan
	 */
	@Override
	public void setPlanName(String planName) {
		model.setPlanName(planName);
	}

	/**
	 * Sets the primary key of this smart health plan.
	 *
	 * @param primaryKey the primary key of this smart health plan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart health plan ID of this smart health plan.
	 *
	 * @param smartHealthPlanId the smart health plan ID of this smart health plan
	 */
	@Override
	public void setSmartHealthPlanId(long smartHealthPlanId) {
		model.setSmartHealthPlanId(smartHealthPlanId);
	}

	/**
	 * Sets the user ID of this smart health plan.
	 *
	 * @param userId the user ID of this smart health plan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart health plan.
	 *
	 * @param userName the user name of this smart health plan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart health plan.
	 *
	 * @param userUuid the user uuid of this smart health plan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartHealthPlanWrapper wrap(SmartHealthPlan smartHealthPlan) {
		return new SmartHealthPlanWrapper(smartHealthPlan);
	}

}