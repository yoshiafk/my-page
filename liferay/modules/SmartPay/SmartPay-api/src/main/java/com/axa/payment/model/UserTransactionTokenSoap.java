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
 * This class is used by SOAP remote services, specifically {@link com.axa.payment.service.http.UserTransactionTokenServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserTransactionTokenSoap implements Serializable {

	public static UserTransactionTokenSoap toSoapModel(
		UserTransactionToken model) {

		UserTransactionTokenSoap soapModel = new UserTransactionTokenSoap();

		soapModel.setUserTransactionTokenId(model.getUserTransactionTokenId());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setInvoiceNumber(model.getInvoiceNumber());
		soapModel.setReferenceNumber(model.getReferenceNumber());
		soapModel.setFullName(model.getFullName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setAmount(model.getAmount());
		soapModel.setChannel(model.getChannel());
		soapModel.setVirtualAccount1(model.getVirtualAccount1());
		soapModel.setVirtualAccount2(model.getVirtualAccount2());
		soapModel.setToken(model.getToken());
		soapModel.setTimestampExpiryToken(model.getTimestampExpiryToken());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserTransactionTokenSoap[] toSoapModels(
		UserTransactionToken[] models) {

		UserTransactionTokenSoap[] soapModels =
			new UserTransactionTokenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserTransactionTokenSoap[][] toSoapModels(
		UserTransactionToken[][] models) {

		UserTransactionTokenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserTransactionTokenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserTransactionTokenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserTransactionTokenSoap[] toSoapModels(
		List<UserTransactionToken> models) {

		List<UserTransactionTokenSoap> soapModels =
			new ArrayList<UserTransactionTokenSoap>(models.size());

		for (UserTransactionToken model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserTransactionTokenSoap[soapModels.size()]);
	}

	public UserTransactionTokenSoap() {
	}

	public long getPrimaryKey() {
		return _userTransactionTokenId;
	}

	public void setPrimaryKey(long pk) {
		setUserTransactionTokenId(pk);
	}

	public long getUserTransactionTokenId() {
		return _userTransactionTokenId;
	}

	public void setUserTransactionTokenId(long userTransactionTokenId) {
		_userTransactionTokenId = userTransactionTokenId;
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
	}

	public String getVirtualAccount1() {
		return _virtualAccount1;
	}

	public void setVirtualAccount1(String virtualAccount1) {
		_virtualAccount1 = virtualAccount1;
	}

	public String getVirtualAccount2() {
		return _virtualAccount2;
	}

	public void setVirtualAccount2(String virtualAccount2) {
		_virtualAccount2 = virtualAccount2;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public long getTimestampExpiryToken() {
		return _TimestampExpiryToken;
	}

	public void setTimestampExpiryToken(long TimestampExpiryToken) {
		_TimestampExpiryToken = TimestampExpiryToken;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _userTransactionTokenId;
	private String _policyNumber;
	private String _profileId;
	private String _invoiceNumber;
	private String _referenceNumber;
	private String _fullName;
	private String _email;
	private String _phoneNumber;
	private double _amount;
	private String _channel;
	private String _virtualAccount1;
	private String _virtualAccount2;
	private String _token;
	private long _TimestampExpiryToken;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}