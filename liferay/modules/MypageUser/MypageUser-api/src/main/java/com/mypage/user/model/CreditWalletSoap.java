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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.CreditWalletServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CreditWalletSoap implements Serializable {

	public static CreditWalletSoap toSoapModel(CreditWallet model) {
		CreditWalletSoap soapModel = new CreditWalletSoap();

		soapModel.setCreditWalletId(model.getCreditWalletId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreditTypeId(model.getCreditTypeId());
		soapModel.setDateIssued(model.getDateIssued());
		soapModel.setDateExpired(model.getDateExpired());
		soapModel.setAmount(model.getAmount());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static CreditWalletSoap[] toSoapModels(CreditWallet[] models) {
		CreditWalletSoap[] soapModels = new CreditWalletSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditWalletSoap[][] toSoapModels(CreditWallet[][] models) {
		CreditWalletSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditWalletSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditWalletSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditWalletSoap[] toSoapModels(List<CreditWallet> models) {
		List<CreditWalletSoap> soapModels = new ArrayList<CreditWalletSoap>(
			models.size());

		for (CreditWallet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditWalletSoap[soapModels.size()]);
	}

	public CreditWalletSoap() {
	}

	public long getPrimaryKey() {
		return _creditWalletId;
	}

	public void setPrimaryKey(long pk) {
		setCreditWalletId(pk);
	}

	public long getCreditWalletId() {
		return _creditWalletId;
	}

	public void setCreditWalletId(long creditWalletId) {
		_creditWalletId = creditWalletId;
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

	public long getCreditTypeId() {
		return _creditTypeId;
	}

	public void setCreditTypeId(long creditTypeId) {
		_creditTypeId = creditTypeId;
	}

	public Date getDateIssued() {
		return _dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		_dateIssued = dateIssued;
	}

	public Date getDateExpired() {
		return _dateExpired;
	}

	public void setDateExpired(Date dateExpired) {
		_dateExpired = dateExpired;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _creditWalletId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditTypeId;
	private Date _dateIssued;
	private Date _dateExpired;
	private double _amount;
	private int _active;

}