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

package com.mypage.user.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CreditType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditType
 * @generated
 */
public class CreditTypeWrapper
	extends BaseModelWrapper<CreditType>
	implements CreditType, ModelWrapper<CreditType> {

	public CreditTypeWrapper(CreditType creditType) {
		super(creditType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creditTypeId", getCreditTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("name", getName());
		attributes.put("agentType", getAgentType());
		attributes.put("limit", getLimit());
		attributes.put("overrideGracePeriod", getOverrideGracePeriod());
		attributes.put("nettPremiAllowed", getNettPremiAllowed());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creditTypeId = (Long)attributes.get("creditTypeId");

		if (creditTypeId != null) {
			setCreditTypeId(creditTypeId);
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

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String agentType = (String)attributes.get("agentType");

		if (agentType != null) {
			setAgentType(agentType);
		}

		Double limit = (Double)attributes.get("limit");

		if (limit != null) {
			setLimit(limit);
		}

		Integer overrideGracePeriod = (Integer)attributes.get(
			"overrideGracePeriod");

		if (overrideGracePeriod != null) {
			setOverrideGracePeriod(overrideGracePeriod);
		}

		Integer nettPremiAllowed = (Integer)attributes.get("nettPremiAllowed");

		if (nettPremiAllowed != null) {
			setNettPremiAllowed(nettPremiAllowed);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this credit type.
	 *
	 * @return the active of this credit type
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the agent type of this credit type.
	 *
	 * @return the agent type of this credit type
	 */
	@Override
	public String getAgentType() {
		return model.getAgentType();
	}

	/**
	 * Returns the company ID of this credit type.
	 *
	 * @return the company ID of this credit type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this credit type.
	 *
	 * @return the create date of this credit type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the credit type ID of this credit type.
	 *
	 * @return the credit type ID of this credit type
	 */
	@Override
	public long getCreditTypeId() {
		return model.getCreditTypeId();
	}

	/**
	 * Returns the group ID of this credit type.
	 *
	 * @return the group ID of this credit type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the limit of this credit type.
	 *
	 * @return the limit of this credit type
	 */
	@Override
	public double getLimit() {
		return model.getLimit();
	}

	/**
	 * Returns the modified date of this credit type.
	 *
	 * @return the modified date of this credit type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this credit type.
	 *
	 * @return the mypage user ID of this credit type
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this credit type.
	 *
	 * @return the mypage user uuid of this credit type
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the name of this credit type.
	 *
	 * @return the name of this credit type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nett premi allowed of this credit type.
	 *
	 * @return the nett premi allowed of this credit type
	 */
	@Override
	public int getNettPremiAllowed() {
		return model.getNettPremiAllowed();
	}

	/**
	 * Returns the override grace period of this credit type.
	 *
	 * @return the override grace period of this credit type
	 */
	@Override
	public int getOverrideGracePeriod() {
		return model.getOverrideGracePeriod();
	}

	/**
	 * Returns the primary key of this credit type.
	 *
	 * @return the primary key of this credit type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this credit type.
	 *
	 * @return the user ID of this credit type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this credit type.
	 *
	 * @return the user name of this credit type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this credit type.
	 *
	 * @return the user uuid of this credit type
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
	 * Sets the active of this credit type.
	 *
	 * @param active the active of this credit type
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the agent type of this credit type.
	 *
	 * @param agentType the agent type of this credit type
	 */
	@Override
	public void setAgentType(String agentType) {
		model.setAgentType(agentType);
	}

	/**
	 * Sets the company ID of this credit type.
	 *
	 * @param companyId the company ID of this credit type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this credit type.
	 *
	 * @param createDate the create date of this credit type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the credit type ID of this credit type.
	 *
	 * @param creditTypeId the credit type ID of this credit type
	 */
	@Override
	public void setCreditTypeId(long creditTypeId) {
		model.setCreditTypeId(creditTypeId);
	}

	/**
	 * Sets the group ID of this credit type.
	 *
	 * @param groupId the group ID of this credit type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the limit of this credit type.
	 *
	 * @param limit the limit of this credit type
	 */
	@Override
	public void setLimit(double limit) {
		model.setLimit(limit);
	}

	/**
	 * Sets the modified date of this credit type.
	 *
	 * @param modifiedDate the modified date of this credit type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this credit type.
	 *
	 * @param mypageUserId the mypage user ID of this credit type
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this credit type.
	 *
	 * @param mypageUserUuid the mypage user uuid of this credit type
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the name of this credit type.
	 *
	 * @param name the name of this credit type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the nett premi allowed of this credit type.
	 *
	 * @param nettPremiAllowed the nett premi allowed of this credit type
	 */
	@Override
	public void setNettPremiAllowed(int nettPremiAllowed) {
		model.setNettPremiAllowed(nettPremiAllowed);
	}

	/**
	 * Sets the override grace period of this credit type.
	 *
	 * @param overrideGracePeriod the override grace period of this credit type
	 */
	@Override
	public void setOverrideGracePeriod(int overrideGracePeriod) {
		model.setOverrideGracePeriod(overrideGracePeriod);
	}

	/**
	 * Sets the primary key of this credit type.
	 *
	 * @param primaryKey the primary key of this credit type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this credit type.
	 *
	 * @param userId the user ID of this credit type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this credit type.
	 *
	 * @param userName the user name of this credit type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this credit type.
	 *
	 * @param userUuid the user uuid of this credit type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CreditTypeWrapper wrap(CreditType creditType) {
		return new CreditTypeWrapper(creditType);
	}

}