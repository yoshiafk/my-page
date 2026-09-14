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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.MasterCurrencyServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterCurrencySoap implements Serializable {

	public static MasterCurrencySoap toSoapModel(MasterCurrency model) {
		MasterCurrencySoap soapModel = new MasterCurrencySoap();

		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setName(model.getName());
		soapModel.setAmount(model.getAmount());
		soapModel.setIsDefault(model.getIsDefault());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MasterCurrencySoap[] toSoapModels(MasterCurrency[] models) {
		MasterCurrencySoap[] soapModels = new MasterCurrencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterCurrencySoap[][] toSoapModels(
		MasterCurrency[][] models) {

		MasterCurrencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MasterCurrencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterCurrencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterCurrencySoap[] toSoapModels(
		List<MasterCurrency> models) {

		List<MasterCurrencySoap> soapModels = new ArrayList<MasterCurrencySoap>(
			models.size());

		for (MasterCurrency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterCurrencySoap[soapModels.size()]);
	}

	public MasterCurrencySoap() {
	}

	public long getPrimaryKey() {
		return _currencyId;
	}

	public void setPrimaryKey(long pk) {
		setCurrencyId(pk);
	}

	public long getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(long currencyId) {
		_currencyId = currencyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public Integer getIsDefault() {
		return _isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		_isDefault = isDefault;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
		_active = active;
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

	private long _currencyId;
	private String _name;
	private double _amount;
	private Integer _isDefault;
	private Integer _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}