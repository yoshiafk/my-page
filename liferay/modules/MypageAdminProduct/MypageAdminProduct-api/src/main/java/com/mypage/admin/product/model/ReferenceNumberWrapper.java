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
 * This class is a wrapper for {@link ReferenceNumber}.
 * </p>
 *
 * @author Gositus Team
 * @see ReferenceNumber
 * @generated
 */
public class ReferenceNumberWrapper
	extends BaseModelWrapper<ReferenceNumber>
	implements ModelWrapper<ReferenceNumber>, ReferenceNumber {

	public ReferenceNumberWrapper(ReferenceNumber referenceNumber) {
		super(referenceNumber);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("referenceNumberId", getReferenceNumberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userRole", getUserRole());
		attributes.put("channel", getChannel());
		attributes.put("type", getType());
		attributes.put("productCode", getProductCode());
		attributes.put("businessType", getBusinessType());
		attributes.put("currency", getCurrency());
		attributes.put("prefix", getPrefix());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long referenceNumberId = (Long)attributes.get("referenceNumberId");

		if (referenceNumberId != null) {
			setReferenceNumberId(referenceNumberId);
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

		String userRole = (String)attributes.get("userRole");

		if (userRole != null) {
			setUserRole(userRole);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String productCode = (String)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String prefix = (String)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this reference number.
	 *
	 * @return the active of this reference number
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the business type of this reference number.
	 *
	 * @return the business type of this reference number
	 */
	@Override
	public String getBusinessType() {
		return model.getBusinessType();
	}

	/**
	 * Returns the channel of this reference number.
	 *
	 * @return the channel of this reference number
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the company ID of this reference number.
	 *
	 * @return the company ID of this reference number
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this reference number.
	 *
	 * @return the create date of this reference number
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this reference number.
	 *
	 * @return the currency of this reference number
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the group ID of this reference number.
	 *
	 * @return the group ID of this reference number
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this reference number.
	 *
	 * @return the modified date of this reference number
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the prefix of this reference number.
	 *
	 * @return the prefix of this reference number
	 */
	@Override
	public String getPrefix() {
		return model.getPrefix();
	}

	/**
	 * Returns the primary key of this reference number.
	 *
	 * @return the primary key of this reference number
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this reference number.
	 *
	 * @return the product code of this reference number
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the reference number ID of this reference number.
	 *
	 * @return the reference number ID of this reference number
	 */
	@Override
	public long getReferenceNumberId() {
		return model.getReferenceNumberId();
	}

	/**
	 * Returns the type of this reference number.
	 *
	 * @return the type of this reference number
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this reference number.
	 *
	 * @return the user ID of this reference number
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this reference number.
	 *
	 * @return the user name of this reference number
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user role of this reference number.
	 *
	 * @return the user role of this reference number
	 */
	@Override
	public String getUserRole() {
		return model.getUserRole();
	}

	/**
	 * Returns the user uuid of this reference number.
	 *
	 * @return the user uuid of this reference number
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
	 * Sets the active of this reference number.
	 *
	 * @param active the active of this reference number
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the business type of this reference number.
	 *
	 * @param businessType the business type of this reference number
	 */
	@Override
	public void setBusinessType(String businessType) {
		model.setBusinessType(businessType);
	}

	/**
	 * Sets the channel of this reference number.
	 *
	 * @param channel the channel of this reference number
	 */
	@Override
	public void setChannel(String channel) {
		model.setChannel(channel);
	}

	/**
	 * Sets the company ID of this reference number.
	 *
	 * @param companyId the company ID of this reference number
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this reference number.
	 *
	 * @param createDate the create date of this reference number
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this reference number.
	 *
	 * @param currency the currency of this reference number
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the group ID of this reference number.
	 *
	 * @param groupId the group ID of this reference number
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this reference number.
	 *
	 * @param modifiedDate the modified date of this reference number
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the prefix of this reference number.
	 *
	 * @param prefix the prefix of this reference number
	 */
	@Override
	public void setPrefix(String prefix) {
		model.setPrefix(prefix);
	}

	/**
	 * Sets the primary key of this reference number.
	 *
	 * @param primaryKey the primary key of this reference number
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this reference number.
	 *
	 * @param productCode the product code of this reference number
	 */
	@Override
	public void setProductCode(String productCode) {
		model.setProductCode(productCode);
	}

	/**
	 * Sets the reference number ID of this reference number.
	 *
	 * @param referenceNumberId the reference number ID of this reference number
	 */
	@Override
	public void setReferenceNumberId(long referenceNumberId) {
		model.setReferenceNumberId(referenceNumberId);
	}

	/**
	 * Sets the type of this reference number.
	 *
	 * @param type the type of this reference number
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this reference number.
	 *
	 * @param userId the user ID of this reference number
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this reference number.
	 *
	 * @param userName the user name of this reference number
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user role of this reference number.
	 *
	 * @param userRole the user role of this reference number
	 */
	@Override
	public void setUserRole(String userRole) {
		model.setUserRole(userRole);
	}

	/**
	 * Sets the user uuid of this reference number.
	 *
	 * @param userUuid the user uuid of this reference number
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ReferenceNumberWrapper wrap(ReferenceNumber referenceNumber) {
		return new ReferenceNumberWrapper(referenceNumber);
	}

}