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
 * This class is a wrapper for {@link CreditWallet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditWallet
 * @generated
 */
public class CreditWalletWrapper
	extends BaseModelWrapper<CreditWallet>
	implements CreditWallet, ModelWrapper<CreditWallet> {

	public CreditWalletWrapper(CreditWallet creditWallet) {
		super(creditWallet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creditWalletId", getCreditWalletId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditTypeId", getCreditTypeId());
		attributes.put("dateIssued", getDateIssued());
		attributes.put("dateExpired", getDateExpired());
		attributes.put("amount", getAmount());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creditWalletId = (Long)attributes.get("creditWalletId");

		if (creditWalletId != null) {
			setCreditWalletId(creditWalletId);
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

		Long creditTypeId = (Long)attributes.get("creditTypeId");

		if (creditTypeId != null) {
			setCreditTypeId(creditTypeId);
		}

		Date dateIssued = (Date)attributes.get("dateIssued");

		if (dateIssued != null) {
			setDateIssued(dateIssued);
		}

		Date dateExpired = (Date)attributes.get("dateExpired");

		if (dateExpired != null) {
			setDateExpired(dateExpired);
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
	 * Returns the active of this credit wallet.
	 *
	 * @return the active of this credit wallet
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this credit wallet.
	 *
	 * @return the amount of this credit wallet
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this credit wallet.
	 *
	 * @return the company ID of this credit wallet
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this credit wallet.
	 *
	 * @return the create date of this credit wallet
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the credit type ID of this credit wallet.
	 *
	 * @return the credit type ID of this credit wallet
	 */
	@Override
	public long getCreditTypeId() {
		return model.getCreditTypeId();
	}

	/**
	 * Returns the credit wallet ID of this credit wallet.
	 *
	 * @return the credit wallet ID of this credit wallet
	 */
	@Override
	public long getCreditWalletId() {
		return model.getCreditWalletId();
	}

	/**
	 * Returns the date expired of this credit wallet.
	 *
	 * @return the date expired of this credit wallet
	 */
	@Override
	public Date getDateExpired() {
		return model.getDateExpired();
	}

	/**
	 * Returns the date issued of this credit wallet.
	 *
	 * @return the date issued of this credit wallet
	 */
	@Override
	public Date getDateIssued() {
		return model.getDateIssued();
	}

	/**
	 * Returns the group ID of this credit wallet.
	 *
	 * @return the group ID of this credit wallet
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this credit wallet.
	 *
	 * @return the modified date of this credit wallet
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this credit wallet.
	 *
	 * @return the primary key of this credit wallet
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this credit wallet.
	 *
	 * @return the user ID of this credit wallet
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this credit wallet.
	 *
	 * @return the user name of this credit wallet
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this credit wallet.
	 *
	 * @return the user uuid of this credit wallet
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
	 * Sets the active of this credit wallet.
	 *
	 * @param active the active of this credit wallet
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this credit wallet.
	 *
	 * @param amount the amount of this credit wallet
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this credit wallet.
	 *
	 * @param companyId the company ID of this credit wallet
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this credit wallet.
	 *
	 * @param createDate the create date of this credit wallet
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the credit type ID of this credit wallet.
	 *
	 * @param creditTypeId the credit type ID of this credit wallet
	 */
	@Override
	public void setCreditTypeId(long creditTypeId) {
		model.setCreditTypeId(creditTypeId);
	}

	/**
	 * Sets the credit wallet ID of this credit wallet.
	 *
	 * @param creditWalletId the credit wallet ID of this credit wallet
	 */
	@Override
	public void setCreditWalletId(long creditWalletId) {
		model.setCreditWalletId(creditWalletId);
	}

	/**
	 * Sets the date expired of this credit wallet.
	 *
	 * @param dateExpired the date expired of this credit wallet
	 */
	@Override
	public void setDateExpired(Date dateExpired) {
		model.setDateExpired(dateExpired);
	}

	/**
	 * Sets the date issued of this credit wallet.
	 *
	 * @param dateIssued the date issued of this credit wallet
	 */
	@Override
	public void setDateIssued(Date dateIssued) {
		model.setDateIssued(dateIssued);
	}

	/**
	 * Sets the group ID of this credit wallet.
	 *
	 * @param groupId the group ID of this credit wallet
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this credit wallet.
	 *
	 * @param modifiedDate the modified date of this credit wallet
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this credit wallet.
	 *
	 * @param primaryKey the primary key of this credit wallet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this credit wallet.
	 *
	 * @param userId the user ID of this credit wallet
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this credit wallet.
	 *
	 * @param userName the user name of this credit wallet
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this credit wallet.
	 *
	 * @param userUuid the user uuid of this credit wallet
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CreditWalletWrapper wrap(CreditWallet creditWallet) {
		return new CreditWalletWrapper(creditWallet);
	}

}