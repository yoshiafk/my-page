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
 * This class is a wrapper for {@link BlacklistCustomer}.
 * </p>
 *
 * @author Gositus Team
 * @see BlacklistCustomer
 * @generated
 */
public class BlacklistCustomerWrapper
	extends BaseModelWrapper<BlacklistCustomer>
	implements BlacklistCustomer, ModelWrapper<BlacklistCustomer> {

	public BlacklistCustomerWrapper(BlacklistCustomer blacklistCustomer) {
		super(blacklistCustomer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("blacklistCustomerId", getBlacklistCustomerId());
		attributes.put("fullName", getFullName());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("ktp", getKtp());
		attributes.put("kitas", getKitas());
		attributes.put("email", getEmail());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("active", getActive());
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
		Long blacklistCustomerId = (Long)attributes.get("blacklistCustomerId");

		if (blacklistCustomerId != null) {
			setBlacklistCustomerId(blacklistCustomerId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String ktp = (String)attributes.get("ktp");

		if (ktp != null) {
			setKtp(ktp);
		}

		String kitas = (String)attributes.get("kitas");

		if (kitas != null) {
			setKitas(kitas);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	 * Returns the active of this blacklist customer.
	 *
	 * @return the active of this blacklist customer
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the blacklist customer ID of this blacklist customer.
	 *
	 * @return the blacklist customer ID of this blacklist customer
	 */
	@Override
	public long getBlacklistCustomerId() {
		return model.getBlacklistCustomerId();
	}

	/**
	 * Returns the company ID of this blacklist customer.
	 *
	 * @return the company ID of this blacklist customer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this blacklist customer.
	 *
	 * @return the create date of this blacklist customer
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of birth of this blacklist customer.
	 *
	 * @return the date of birth of this blacklist customer
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the email of this blacklist customer.
	 *
	 * @return the email of this blacklist customer
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this blacklist customer.
	 *
	 * @return the first name of this blacklist customer
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the full name of this blacklist customer.
	 *
	 * @return the full name of this blacklist customer
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this blacklist customer.
	 *
	 * @return the group ID of this blacklist customer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the kitas of this blacklist customer.
	 *
	 * @return the kitas of this blacklist customer
	 */
	@Override
	public String getKitas() {
		return model.getKitas();
	}

	/**
	 * Returns the ktp of this blacklist customer.
	 *
	 * @return the ktp of this blacklist customer
	 */
	@Override
	public String getKtp() {
		return model.getKtp();
	}

	/**
	 * Returns the last name of this blacklist customer.
	 *
	 * @return the last name of this blacklist customer
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the middle name of this blacklist customer.
	 *
	 * @return the middle name of this blacklist customer
	 */
	@Override
	public String getMiddleName() {
		return model.getMiddleName();
	}

	/**
	 * Returns the modified date of this blacklist customer.
	 *
	 * @return the modified date of this blacklist customer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this blacklist customer.
	 *
	 * @return the primary key of this blacklist customer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this blacklist customer.
	 *
	 * @return the user ID of this blacklist customer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this blacklist customer.
	 *
	 * @return the user name of this blacklist customer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this blacklist customer.
	 *
	 * @return the user uuid of this blacklist customer
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
	 * Sets the active of this blacklist customer.
	 *
	 * @param active the active of this blacklist customer
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the blacklist customer ID of this blacklist customer.
	 *
	 * @param blacklistCustomerId the blacklist customer ID of this blacklist customer
	 */
	@Override
	public void setBlacklistCustomerId(long blacklistCustomerId) {
		model.setBlacklistCustomerId(blacklistCustomerId);
	}

	/**
	 * Sets the company ID of this blacklist customer.
	 *
	 * @param companyId the company ID of this blacklist customer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this blacklist customer.
	 *
	 * @param createDate the create date of this blacklist customer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of birth of this blacklist customer.
	 *
	 * @param dateOfBirth the date of birth of this blacklist customer
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the email of this blacklist customer.
	 *
	 * @param email the email of this blacklist customer
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this blacklist customer.
	 *
	 * @param firstName the first name of this blacklist customer
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the full name of this blacklist customer.
	 *
	 * @param fullName the full name of this blacklist customer
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this blacklist customer.
	 *
	 * @param groupId the group ID of this blacklist customer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the kitas of this blacklist customer.
	 *
	 * @param kitas the kitas of this blacklist customer
	 */
	@Override
	public void setKitas(String kitas) {
		model.setKitas(kitas);
	}

	/**
	 * Sets the ktp of this blacklist customer.
	 *
	 * @param ktp the ktp of this blacklist customer
	 */
	@Override
	public void setKtp(String ktp) {
		model.setKtp(ktp);
	}

	/**
	 * Sets the last name of this blacklist customer.
	 *
	 * @param lastName the last name of this blacklist customer
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the middle name of this blacklist customer.
	 *
	 * @param middleName the middle name of this blacklist customer
	 */
	@Override
	public void setMiddleName(String middleName) {
		model.setMiddleName(middleName);
	}

	/**
	 * Sets the modified date of this blacklist customer.
	 *
	 * @param modifiedDate the modified date of this blacklist customer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this blacklist customer.
	 *
	 * @param primaryKey the primary key of this blacklist customer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this blacklist customer.
	 *
	 * @param userId the user ID of this blacklist customer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this blacklist customer.
	 *
	 * @param userName the user name of this blacklist customer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this blacklist customer.
	 *
	 * @param userUuid the user uuid of this blacklist customer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected BlacklistCustomerWrapper wrap(
		BlacklistCustomer blacklistCustomer) {

		return new BlacklistCustomerWrapper(blacklistCustomer);
	}

}