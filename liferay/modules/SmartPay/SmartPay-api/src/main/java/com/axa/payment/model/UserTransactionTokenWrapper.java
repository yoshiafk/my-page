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

package com.axa.payment.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserTransactionToken}.
 * </p>
 *
 * @author Gositus Team
 * @see UserTransactionToken
 * @generated
 */
public class UserTransactionTokenWrapper
	extends BaseModelWrapper<UserTransactionToken>
	implements ModelWrapper<UserTransactionToken>, UserTransactionToken {

	public UserTransactionTokenWrapper(
		UserTransactionToken userTransactionToken) {

		super(userTransactionToken);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userTransactionTokenId", getUserTransactionTokenId());
		attributes.put("policyNumber", getPolicyNumber());
		attributes.put("profileId", getProfileId());
		attributes.put("invoiceNumber", getInvoiceNumber());
		attributes.put("referenceNumber", getReferenceNumber());
		attributes.put("fullName", getFullName());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("amount", getAmount());
		attributes.put("channel", getChannel());
		attributes.put("virtualAccount1", getVirtualAccount1());
		attributes.put("virtualAccount2", getVirtualAccount2());
		attributes.put("token", getToken());
		attributes.put("TimestampExpiryToken", getTimestampExpiryToken());
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
		Long userTransactionTokenId = (Long)attributes.get(
			"userTransactionTokenId");

		if (userTransactionTokenId != null) {
			setUserTransactionTokenId(userTransactionTokenId);
		}

		String policyNumber = (String)attributes.get("policyNumber");

		if (policyNumber != null) {
			setPolicyNumber(policyNumber);
		}

		String profileId = (String)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		String invoiceNumber = (String)attributes.get("invoiceNumber");

		if (invoiceNumber != null) {
			setInvoiceNumber(invoiceNumber);
		}

		String referenceNumber = (String)attributes.get("referenceNumber");

		if (referenceNumber != null) {
			setReferenceNumber(referenceNumber);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		String virtualAccount1 = (String)attributes.get("virtualAccount1");

		if (virtualAccount1 != null) {
			setVirtualAccount1(virtualAccount1);
		}

		String virtualAccount2 = (String)attributes.get("virtualAccount2");

		if (virtualAccount2 != null) {
			setVirtualAccount2(virtualAccount2);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		Long TimestampExpiryToken = (Long)attributes.get(
			"TimestampExpiryToken");

		if (TimestampExpiryToken != null) {
			setTimestampExpiryToken(TimestampExpiryToken);
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
	 * Returns the amount of this user transaction token.
	 *
	 * @return the amount of this user transaction token
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the channel of this user transaction token.
	 *
	 * @return the channel of this user transaction token
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the company ID of this user transaction token.
	 *
	 * @return the company ID of this user transaction token
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user transaction token.
	 *
	 * @return the create date of this user transaction token
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this user transaction token.
	 *
	 * @return the email of this user transaction token
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the full name of this user transaction token.
	 *
	 * @return the full name of this user transaction token
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this user transaction token.
	 *
	 * @return the group ID of this user transaction token
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the invoice number of this user transaction token.
	 *
	 * @return the invoice number of this user transaction token
	 */
	@Override
	public String getInvoiceNumber() {
		return model.getInvoiceNumber();
	}

	/**
	 * Returns the modified date of this user transaction token.
	 *
	 * @return the modified date of this user transaction token
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this user transaction token.
	 *
	 * @return the phone number of this user transaction token
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the policy number of this user transaction token.
	 *
	 * @return the policy number of this user transaction token
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the primary key of this user transaction token.
	 *
	 * @return the primary key of this user transaction token
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile ID of this user transaction token.
	 *
	 * @return the profile ID of this user transaction token
	 */
	@Override
	public String getProfileId() {
		return model.getProfileId();
	}

	/**
	 * Returns the reference number of this user transaction token.
	 *
	 * @return the reference number of this user transaction token
	 */
	@Override
	public String getReferenceNumber() {
		return model.getReferenceNumber();
	}

	/**
	 * Returns the status of this user transaction token.
	 *
	 * @return the status of this user transaction token
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the timestamp expiry token of this user transaction token.
	 *
	 * @return the timestamp expiry token of this user transaction token
	 */
	@Override
	public long getTimestampExpiryToken() {
		return model.getTimestampExpiryToken();
	}

	/**
	 * Returns the token of this user transaction token.
	 *
	 * @return the token of this user transaction token
	 */
	@Override
	public String getToken() {
		return model.getToken();
	}

	/**
	 * Returns the trash entry created when this user transaction token was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this user transaction token.
	 *
	 * @return the trash entry created when this user transaction token was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this user transaction token.
	 *
	 * @return the class primary key of the trash entry for this user transaction token
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this user transaction token.
	 *
	 * @return the trash handler for this user transaction token
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this user transaction token.
	 *
	 * @return the user ID of this user transaction token
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user transaction token.
	 *
	 * @return the user name of this user transaction token
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user transaction token ID of this user transaction token.
	 *
	 * @return the user transaction token ID of this user transaction token
	 */
	@Override
	public long getUserTransactionTokenId() {
		return model.getUserTransactionTokenId();
	}

	/**
	 * Returns the user uuid of this user transaction token.
	 *
	 * @return the user uuid of this user transaction token
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the virtual account1 of this user transaction token.
	 *
	 * @return the virtual account1 of this user transaction token
	 */
	@Override
	public String getVirtualAccount1() {
		return model.getVirtualAccount1();
	}

	/**
	 * Returns the virtual account2 of this user transaction token.
	 *
	 * @return the virtual account2 of this user transaction token
	 */
	@Override
	public String getVirtualAccount2() {
		return model.getVirtualAccount2();
	}

	/**
	 * Returns <code>true</code> if this user transaction token is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this user transaction token is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this user transaction token is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this user transaction token is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the amount of this user transaction token.
	 *
	 * @param amount the amount of this user transaction token
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the channel of this user transaction token.
	 *
	 * @param channel the channel of this user transaction token
	 */
	@Override
	public void setChannel(String channel) {
		model.setChannel(channel);
	}

	/**
	 * Sets the company ID of this user transaction token.
	 *
	 * @param companyId the company ID of this user transaction token
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user transaction token.
	 *
	 * @param createDate the create date of this user transaction token
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this user transaction token.
	 *
	 * @param email the email of this user transaction token
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the full name of this user transaction token.
	 *
	 * @param fullName the full name of this user transaction token
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this user transaction token.
	 *
	 * @param groupId the group ID of this user transaction token
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the invoice number of this user transaction token.
	 *
	 * @param invoiceNumber the invoice number of this user transaction token
	 */
	@Override
	public void setInvoiceNumber(String invoiceNumber) {
		model.setInvoiceNumber(invoiceNumber);
	}

	/**
	 * Sets the modified date of this user transaction token.
	 *
	 * @param modifiedDate the modified date of this user transaction token
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this user transaction token.
	 *
	 * @param phoneNumber the phone number of this user transaction token
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the policy number of this user transaction token.
	 *
	 * @param policyNumber the policy number of this user transaction token
	 */
	@Override
	public void setPolicyNumber(String policyNumber) {
		model.setPolicyNumber(policyNumber);
	}

	/**
	 * Sets the primary key of this user transaction token.
	 *
	 * @param primaryKey the primary key of this user transaction token
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile ID of this user transaction token.
	 *
	 * @param profileId the profile ID of this user transaction token
	 */
	@Override
	public void setProfileId(String profileId) {
		model.setProfileId(profileId);
	}

	/**
	 * Sets the reference number of this user transaction token.
	 *
	 * @param referenceNumber the reference number of this user transaction token
	 */
	@Override
	public void setReferenceNumber(String referenceNumber) {
		model.setReferenceNumber(referenceNumber);
	}

	/**
	 * Sets the timestamp expiry token of this user transaction token.
	 *
	 * @param TimestampExpiryToken the timestamp expiry token of this user transaction token
	 */
	@Override
	public void setTimestampExpiryToken(long TimestampExpiryToken) {
		model.setTimestampExpiryToken(TimestampExpiryToken);
	}

	/**
	 * Sets the token of this user transaction token.
	 *
	 * @param token the token of this user transaction token
	 */
	@Override
	public void setToken(String token) {
		model.setToken(token);
	}

	/**
	 * Sets the user ID of this user transaction token.
	 *
	 * @param userId the user ID of this user transaction token
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user transaction token.
	 *
	 * @param userName the user name of this user transaction token
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user transaction token ID of this user transaction token.
	 *
	 * @param userTransactionTokenId the user transaction token ID of this user transaction token
	 */
	@Override
	public void setUserTransactionTokenId(long userTransactionTokenId) {
		model.setUserTransactionTokenId(userTransactionTokenId);
	}

	/**
	 * Sets the user uuid of this user transaction token.
	 *
	 * @param userUuid the user uuid of this user transaction token
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the virtual account1 of this user transaction token.
	 *
	 * @param virtualAccount1 the virtual account1 of this user transaction token
	 */
	@Override
	public void setVirtualAccount1(String virtualAccount1) {
		model.setVirtualAccount1(virtualAccount1);
	}

	/**
	 * Sets the virtual account2 of this user transaction token.
	 *
	 * @param virtualAccount2 the virtual account2 of this user transaction token
	 */
	@Override
	public void setVirtualAccount2(String virtualAccount2) {
		model.setVirtualAccount2(virtualAccount2);
	}

	@Override
	protected UserTransactionTokenWrapper wrap(
		UserTransactionToken userTransactionToken) {

		return new UserTransactionTokenWrapper(userTransactionToken);
	}

}