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
 * This class is a wrapper for {@link PaymentTransaction}.
 * </p>
 *
 * @author Gositus Team
 * @see PaymentTransaction
 * @generated
 */
public class PaymentTransactionWrapper
	extends BaseModelWrapper<PaymentTransaction>
	implements ModelWrapper<PaymentTransaction>, PaymentTransaction {

	public PaymentTransactionWrapper(PaymentTransaction paymentTransaction) {
		super(paymentTransaction);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paymentTransactionId", getPaymentTransactionId());
		attributes.put("policyNumber", getPolicyNumber());
		attributes.put("profileId", getProfileId());
		attributes.put("invoiceNumber", getInvoiceNumber());
		attributes.put("referenceNumber", getReferenceNumber());
		attributes.put("requestId", getRequestId());
		attributes.put("policyDueDate", getPolicyDueDate());
		attributes.put("paymentMethod", getPaymentMethod());
		attributes.put("paymentChannel", getPaymentChannel());
		attributes.put("amount", getAmount());
		attributes.put("status_", getStatus_());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("checkCounter", getCheckCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long paymentTransactionId = (Long)attributes.get(
			"paymentTransactionId");

		if (paymentTransactionId != null) {
			setPaymentTransactionId(paymentTransactionId);
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

		String requestId = (String)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		String policyDueDate = (String)attributes.get("policyDueDate");

		if (policyDueDate != null) {
			setPolicyDueDate(policyDueDate);
		}

		String paymentMethod = (String)attributes.get("paymentMethod");

		if (paymentMethod != null) {
			setPaymentMethod(paymentMethod);
		}

		String paymentChannel = (String)attributes.get("paymentChannel");

		if (paymentChannel != null) {
			setPaymentChannel(paymentChannel);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String status_ = (String)attributes.get("status_");

		if (status_ != null) {
			setStatus_(status_);
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

		String createBy = (String)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Integer checkCounter = (Integer)attributes.get("checkCounter");

		if (checkCounter != null) {
			setCheckCounter(checkCounter);
		}
	}

	/**
	 * Returns the amount of this payment transaction.
	 *
	 * @return the amount of this payment transaction
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the check counter of this payment transaction.
	 *
	 * @return the check counter of this payment transaction
	 */
	@Override
	public int getCheckCounter() {
		return model.getCheckCounter();
	}

	/**
	 * Returns the company ID of this payment transaction.
	 *
	 * @return the company ID of this payment transaction
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create by of this payment transaction.
	 *
	 * @return the create by of this payment transaction
	 */
	@Override
	public String getCreateBy() {
		return model.getCreateBy();
	}

	/**
	 * Returns the create date of this payment transaction.
	 *
	 * @return the create date of this payment transaction
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this payment transaction.
	 *
	 * @return the group ID of this payment transaction
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the invoice number of this payment transaction.
	 *
	 * @return the invoice number of this payment transaction
	 */
	@Override
	public String getInvoiceNumber() {
		return model.getInvoiceNumber();
	}

	/**
	 * Returns the modified by of this payment transaction.
	 *
	 * @return the modified by of this payment transaction
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this payment transaction.
	 *
	 * @return the modified date of this payment transaction
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the payment channel of this payment transaction.
	 *
	 * @return the payment channel of this payment transaction
	 */
	@Override
	public String getPaymentChannel() {
		return model.getPaymentChannel();
	}

	/**
	 * Returns the payment method of this payment transaction.
	 *
	 * @return the payment method of this payment transaction
	 */
	@Override
	public String getPaymentMethod() {
		return model.getPaymentMethod();
	}

	/**
	 * Returns the payment transaction ID of this payment transaction.
	 *
	 * @return the payment transaction ID of this payment transaction
	 */
	@Override
	public long getPaymentTransactionId() {
		return model.getPaymentTransactionId();
	}

	/**
	 * Returns the policy due date of this payment transaction.
	 *
	 * @return the policy due date of this payment transaction
	 */
	@Override
	public String getPolicyDueDate() {
		return model.getPolicyDueDate();
	}

	/**
	 * Returns the policy number of this payment transaction.
	 *
	 * @return the policy number of this payment transaction
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the primary key of this payment transaction.
	 *
	 * @return the primary key of this payment transaction
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile ID of this payment transaction.
	 *
	 * @return the profile ID of this payment transaction
	 */
	@Override
	public String getProfileId() {
		return model.getProfileId();
	}

	/**
	 * Returns the reference number of this payment transaction.
	 *
	 * @return the reference number of this payment transaction
	 */
	@Override
	public String getReferenceNumber() {
		return model.getReferenceNumber();
	}

	/**
	 * Returns the request ID of this payment transaction.
	 *
	 * @return the request ID of this payment transaction
	 */
	@Override
	public String getRequestId() {
		return model.getRequestId();
	}

	/**
	 * Returns the status of this payment transaction.
	 *
	 * @return the status of this payment transaction
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status_ of this payment transaction.
	 *
	 * @return the status_ of this payment transaction
	 */
	@Override
	public String getStatus_() {
		return model.getStatus_();
	}

	/**
	 * Returns the trash entry created when this payment transaction was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this payment transaction.
	 *
	 * @return the trash entry created when this payment transaction was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this payment transaction.
	 *
	 * @return the class primary key of the trash entry for this payment transaction
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this payment transaction.
	 *
	 * @return the trash handler for this payment transaction
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this payment transaction.
	 *
	 * @return the user ID of this payment transaction
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this payment transaction.
	 *
	 * @return the user name of this payment transaction
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this payment transaction.
	 *
	 * @return the user uuid of this payment transaction
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this payment transaction is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this payment transaction is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this payment transaction is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this payment transaction is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the amount of this payment transaction.
	 *
	 * @param amount the amount of this payment transaction
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the check counter of this payment transaction.
	 *
	 * @param checkCounter the check counter of this payment transaction
	 */
	@Override
	public void setCheckCounter(int checkCounter) {
		model.setCheckCounter(checkCounter);
	}

	/**
	 * Sets the company ID of this payment transaction.
	 *
	 * @param companyId the company ID of this payment transaction
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create by of this payment transaction.
	 *
	 * @param createBy the create by of this payment transaction
	 */
	@Override
	public void setCreateBy(String createBy) {
		model.setCreateBy(createBy);
	}

	/**
	 * Sets the create date of this payment transaction.
	 *
	 * @param createDate the create date of this payment transaction
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this payment transaction.
	 *
	 * @param groupId the group ID of this payment transaction
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the invoice number of this payment transaction.
	 *
	 * @param invoiceNumber the invoice number of this payment transaction
	 */
	@Override
	public void setInvoiceNumber(String invoiceNumber) {
		model.setInvoiceNumber(invoiceNumber);
	}

	/**
	 * Sets the modified by of this payment transaction.
	 *
	 * @param modifiedBy the modified by of this payment transaction
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this payment transaction.
	 *
	 * @param modifiedDate the modified date of this payment transaction
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the payment channel of this payment transaction.
	 *
	 * @param paymentChannel the payment channel of this payment transaction
	 */
	@Override
	public void setPaymentChannel(String paymentChannel) {
		model.setPaymentChannel(paymentChannel);
	}

	/**
	 * Sets the payment method of this payment transaction.
	 *
	 * @param paymentMethod the payment method of this payment transaction
	 */
	@Override
	public void setPaymentMethod(String paymentMethod) {
		model.setPaymentMethod(paymentMethod);
	}

	/**
	 * Sets the payment transaction ID of this payment transaction.
	 *
	 * @param paymentTransactionId the payment transaction ID of this payment transaction
	 */
	@Override
	public void setPaymentTransactionId(long paymentTransactionId) {
		model.setPaymentTransactionId(paymentTransactionId);
	}

	/**
	 * Sets the policy due date of this payment transaction.
	 *
	 * @param policyDueDate the policy due date of this payment transaction
	 */
	@Override
	public void setPolicyDueDate(String policyDueDate) {
		model.setPolicyDueDate(policyDueDate);
	}

	/**
	 * Sets the policy number of this payment transaction.
	 *
	 * @param policyNumber the policy number of this payment transaction
	 */
	@Override
	public void setPolicyNumber(String policyNumber) {
		model.setPolicyNumber(policyNumber);
	}

	/**
	 * Sets the primary key of this payment transaction.
	 *
	 * @param primaryKey the primary key of this payment transaction
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile ID of this payment transaction.
	 *
	 * @param profileId the profile ID of this payment transaction
	 */
	@Override
	public void setProfileId(String profileId) {
		model.setProfileId(profileId);
	}

	/**
	 * Sets the reference number of this payment transaction.
	 *
	 * @param referenceNumber the reference number of this payment transaction
	 */
	@Override
	public void setReferenceNumber(String referenceNumber) {
		model.setReferenceNumber(referenceNumber);
	}

	/**
	 * Sets the request ID of this payment transaction.
	 *
	 * @param requestId the request ID of this payment transaction
	 */
	@Override
	public void setRequestId(String requestId) {
		model.setRequestId(requestId);
	}

	/**
	 * Sets the status_ of this payment transaction.
	 *
	 * @param status_ the status_ of this payment transaction
	 */
	@Override
	public void setStatus_(String status_) {
		model.setStatus_(status_);
	}

	/**
	 * Sets the user ID of this payment transaction.
	 *
	 * @param userId the user ID of this payment transaction
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this payment transaction.
	 *
	 * @param userName the user name of this payment transaction
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this payment transaction.
	 *
	 * @param userUuid the user uuid of this payment transaction
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PaymentTransactionWrapper wrap(
		PaymentTransaction paymentTransaction) {

		return new PaymentTransactionWrapper(paymentTransaction);
	}

}