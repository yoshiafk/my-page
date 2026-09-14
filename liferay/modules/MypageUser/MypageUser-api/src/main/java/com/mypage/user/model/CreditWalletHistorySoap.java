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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.CreditWalletHistoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CreditWalletHistorySoap implements Serializable {

	public static CreditWalletHistorySoap toSoapModel(
		CreditWalletHistory model) {

		CreditWalletHistorySoap soapModel = new CreditWalletHistorySoap();

		soapModel.setCreditWalletHistoryId(model.getCreditWalletHistoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setCreditWalletId(model.getCreditWalletId());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setOperation(model.getOperation());
		soapModel.setAmount(model.getAmount());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static CreditWalletHistorySoap[] toSoapModels(
		CreditWalletHistory[] models) {

		CreditWalletHistorySoap[] soapModels =
			new CreditWalletHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditWalletHistorySoap[][] toSoapModels(
		CreditWalletHistory[][] models) {

		CreditWalletHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CreditWalletHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditWalletHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditWalletHistorySoap[] toSoapModels(
		List<CreditWalletHistory> models) {

		List<CreditWalletHistorySoap> soapModels =
			new ArrayList<CreditWalletHistorySoap>(models.size());

		for (CreditWalletHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CreditWalletHistorySoap[soapModels.size()]);
	}

	public CreditWalletHistorySoap() {
	}

	public long getPrimaryKey() {
		return _creditWalletHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setCreditWalletHistoryId(pk);
	}

	public long getCreditWalletHistoryId() {
		return _creditWalletHistoryId;
	}

	public void setCreditWalletHistoryId(long creditWalletHistoryId) {
		_creditWalletHistoryId = creditWalletHistoryId;
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

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
	}

	public long getCreditWalletId() {
		return _creditWalletId;
	}

	public void setCreditWalletId(long creditWalletId) {
		_creditWalletId = creditWalletId;
	}

	public long getLeadsId() {
		return _leadsId;
	}

	public void setLeadsId(long leadsId) {
		_leadsId = leadsId;
	}

	public String getOperation() {
		return _operation;
	}

	public void setOperation(String operation) {
		_operation = operation;
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

	private long _creditWalletHistoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mypageUserId;
	private long _creditWalletId;
	private long _leadsId;
	private String _operation;
	private double _amount;
	private int _active;

}