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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.axa.payment.service.http.PaymentTransactionServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PaymentTransactionSoap implements Serializable {

	public static PaymentTransactionSoap toSoapModel(PaymentTransaction model) {
		PaymentTransactionSoap soapModel = new PaymentTransactionSoap();

		soapModel.setPaymentTransactionId(model.getPaymentTransactionId());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setInvoiceNumber(model.getInvoiceNumber());
		soapModel.setReferenceNumber(model.getReferenceNumber());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setPolicyDueDate(model.getPolicyDueDate());
		soapModel.setPaymentMethod(model.getPaymentMethod());
		soapModel.setPaymentChannel(model.getPaymentChannel());
		soapModel.setAmount(model.getAmount());
		soapModel.setStatus_(model.getStatus_());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCheckCounter(model.getCheckCounter());

		return soapModel;
	}

	public static PaymentTransactionSoap[] toSoapModels(
		PaymentTransaction[] models) {

		PaymentTransactionSoap[] soapModels =
			new PaymentTransactionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PaymentTransactionSoap[][] toSoapModels(
		PaymentTransaction[][] models) {

		PaymentTransactionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PaymentTransactionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PaymentTransactionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PaymentTransactionSoap[] toSoapModels(
		List<PaymentTransaction> models) {

		List<PaymentTransactionSoap> soapModels =
			new ArrayList<PaymentTransactionSoap>(models.size());

		for (PaymentTransaction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PaymentTransactionSoap[soapModels.size()]);
	}

	public PaymentTransactionSoap() {
	}

	public long getPrimaryKey() {
		return _paymentTransactionId;
	}

	public void setPrimaryKey(long pk) {
		setPaymentTransactionId(pk);
	}

	public long getPaymentTransactionId() {
		return _paymentTransactionId;
	}

	public void setPaymentTransactionId(long paymentTransactionId) {
		_paymentTransactionId = paymentTransactionId;
	}

	public String getPolicyNumber() {
		return _policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		_policyNumber = policyNumber;
	}

	public String getProfileId() {
		return _profileId;
	}

	public void setProfileId(String profileId) {
		_profileId = profileId;
	}

	public String getInvoiceNumber() {
		return _invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		_invoiceNumber = invoiceNumber;
	}

	public String getReferenceNumber() {
		return _referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		_referenceNumber = referenceNumber;
	}

	public String getRequestId() {
		return _requestId;
	}

	public void setRequestId(String requestId) {
		_requestId = requestId;
	}

	public String getPolicyDueDate() {
		return _policyDueDate;
	}

	public void setPolicyDueDate(String policyDueDate) {
		_policyDueDate = policyDueDate;
	}

	public String getPaymentMethod() {
		return _paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		_paymentMethod = paymentMethod;
	}

	public String getPaymentChannel() {
		return _paymentChannel;
	}

	public void setPaymentChannel(String paymentChannel) {
		_paymentChannel = paymentChannel;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getStatus_() {
		return _status_;
	}

	public void setStatus_(String status_) {
		_status_ = status_;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(String createBy) {
		_createBy = createBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public int getCheckCounter() {
		return _checkCounter;
	}

	public void setCheckCounter(int checkCounter) {
		_checkCounter = checkCounter;
	}

	private long _paymentTransactionId;
	private String _policyNumber;
	private String _profileId;
	private String _invoiceNumber;
	private String _referenceNumber;
	private String _requestId;
	private String _policyDueDate;
	private String _paymentMethod;
	private String _paymentChannel;
	private double _amount;
	private String _status_;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private String _createBy;
	private Date _modifiedDate;
	private String _modifiedBy;
	private int _checkCounter;

}