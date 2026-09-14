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
 * This class is a wrapper for {@link CreditWalletHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletHistory
 * @generated
 */
public class CreditWalletHistoryWrapper
	extends BaseModelWrapper<CreditWalletHistory>
	implements CreditWalletHistory, ModelWrapper<CreditWalletHistory> {

	public CreditWalletHistoryWrapper(CreditWalletHistory creditWalletHistory) {
		super(creditWalletHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creditWalletHistoryId", getCreditWalletHistoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("creditWalletId", getCreditWalletId());
		attributes.put("leadsId", getLeadsId());
		attributes.put("operation", getOperation());
		attributes.put("amount", getAmount());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creditWalletHistoryId = (Long)attributes.get(
			"creditWalletHistoryId");

		if (creditWalletHistoryId != null) {
			setCreditWalletHistoryId(creditWalletHistoryId);
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

		Long creditWalletId = (Long)attributes.get("creditWalletId");

		if (creditWalletId != null) {
			setCreditWalletId(creditWalletId);
		}

		Long leadsId = (Long)attributes.get("leadsId");

		if (leadsId != null) {
			setLeadsId(leadsId);
		}

		String operation = (String)attributes.get("operation");

		if (operation != null) {
			setOperation(operation);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this credit wallet history.
	 *
	 * @return the active of this credit wallet history
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this credit wallet history.
	 *
	 * @return the amount of this credit wallet history
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this credit wallet history.
	 *
	 * @return the company ID of this credit wallet history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this credit wallet history.
	 *
	 * @return the create date of this credit wallet history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the credit wallet history ID of this credit wallet history.
	 *
	 * @return the credit wallet history ID of this credit wallet history
	 */
	@Override
	public long getCreditWalletHistoryId() {
		return model.getCreditWalletHistoryId();
	}

	/**
	 * Returns the credit wallet ID of this credit wallet history.
	 *
	 * @return the credit wallet ID of this credit wallet history
	 */
	@Override
	public long getCreditWalletId() {
		return model.getCreditWalletId();
	}

	/**
	 * Returns the group ID of this credit wallet history.
	 *
	 * @return the group ID of this credit wallet history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leads ID of this credit wallet history.
	 *
	 * @return the leads ID of this credit wallet history
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the modified date of this credit wallet history.
	 *
	 * @return the modified date of this credit wallet history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this credit wallet history.
	 *
	 * @return the mypage user ID of this credit wallet history
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this credit wallet history.
	 *
	 * @return the mypage user uuid of this credit wallet history
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the operation of this credit wallet history.
	 *
	 * @return the operation of this credit wallet history
	 */
	@Override
	public String getOperation() {
		return model.getOperation();
	}

	/**
	 * Returns the primary key of this credit wallet history.
	 *
	 * @return the primary key of this credit wallet history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this credit wallet history.
	 *
	 * @return the user ID of this credit wallet history
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this credit wallet history.
	 *
	 * @return the user name of this credit wallet history
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this credit wallet history.
	 *
	 * @return the user uuid of this credit wallet history
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
	 * Sets the active of this credit wallet history.
	 *
	 * @param active the active of this credit wallet history
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this credit wallet history.
	 *
	 * @param amount the amount of this credit wallet history
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this credit wallet history.
	 *
	 * @param companyId the company ID of this credit wallet history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this credit wallet history.
	 *
	 * @param createDate the create date of this credit wallet history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the credit wallet history ID of this credit wallet history.
	 *
	 * @param creditWalletHistoryId the credit wallet history ID of this credit wallet history
	 */
	@Override
	public void setCreditWalletHistoryId(long creditWalletHistoryId) {
		model.setCreditWalletHistoryId(creditWalletHistoryId);
	}

	/**
	 * Sets the credit wallet ID of this credit wallet history.
	 *
	 * @param creditWalletId the credit wallet ID of this credit wallet history
	 */
	@Override
	public void setCreditWalletId(long creditWalletId) {
		model.setCreditWalletId(creditWalletId);
	}

	/**
	 * Sets the group ID of this credit wallet history.
	 *
	 * @param groupId the group ID of this credit wallet history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leads ID of this credit wallet history.
	 *
	 * @param leadsId the leads ID of this credit wallet history
	 */
	@Override
	public void setLeadsId(long leadsId) {
		model.setLeadsId(leadsId);
	}

	/**
	 * Sets the modified date of this credit wallet history.
	 *
	 * @param modifiedDate the modified date of this credit wallet history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this credit wallet history.
	 *
	 * @param mypageUserId the mypage user ID of this credit wallet history
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this credit wallet history.
	 *
	 * @param mypageUserUuid the mypage user uuid of this credit wallet history
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the operation of this credit wallet history.
	 *
	 * @param operation the operation of this credit wallet history
	 */
	@Override
	public void setOperation(String operation) {
		model.setOperation(operation);
	}

	/**
	 * Sets the primary key of this credit wallet history.
	 *
	 * @param primaryKey the primary key of this credit wallet history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this credit wallet history.
	 *
	 * @param userId the user ID of this credit wallet history
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this credit wallet history.
	 *
	 * @param userName the user name of this credit wallet history
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this credit wallet history.
	 *
	 * @param userUuid the user uuid of this credit wallet history
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CreditWalletHistoryWrapper wrap(
		CreditWalletHistory creditWalletHistory) {

		return new CreditWalletHistoryWrapper(creditWalletHistory);
	}

}