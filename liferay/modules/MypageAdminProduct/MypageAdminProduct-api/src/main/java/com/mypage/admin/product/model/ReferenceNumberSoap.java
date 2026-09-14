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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.ReferenceNumberServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ReferenceNumberSoap implements Serializable {

	public static ReferenceNumberSoap toSoapModel(ReferenceNumber model) {
		ReferenceNumberSoap soapModel = new ReferenceNumberSoap();

		soapModel.setReferenceNumberId(model.getReferenceNumberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserRole(model.getUserRole());
		soapModel.setChannel(model.getChannel());
		soapModel.setType(model.getType());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setBusinessType(model.getBusinessType());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setPrefix(model.getPrefix());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static ReferenceNumberSoap[] toSoapModels(ReferenceNumber[] models) {
		ReferenceNumberSoap[] soapModels =
			new ReferenceNumberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReferenceNumberSoap[][] toSoapModels(
		ReferenceNumber[][] models) {

		ReferenceNumberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ReferenceNumberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReferenceNumberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReferenceNumberSoap[] toSoapModels(
		List<ReferenceNumber> models) {

		List<ReferenceNumberSoap> soapModels =
			new ArrayList<ReferenceNumberSoap>(models.size());

		for (ReferenceNumber model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReferenceNumberSoap[soapModels.size()]);
	}

	public ReferenceNumberSoap() {
	}

	public long getPrimaryKey() {
		return _referenceNumberId;
	}

	public void setPrimaryKey(long pk) {
		setReferenceNumberId(pk);
	}

	public long getReferenceNumberId() {
		return _referenceNumberId;
	}

	public void setReferenceNumberId(long referenceNumberId) {
		_referenceNumberId = referenceNumberId;
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

	public String getUserRole() {
		return _userRole;
	}

	public void setUserRole(String userRole) {
		_userRole = userRole;
	}

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getProductCode() {
		return _productCode;
	}

	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	public String getBusinessType() {
		return _businessType;
	}

	public void setBusinessType(String businessType) {
		_businessType = businessType;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public String getPrefix() {
		return _prefix;
	}

	public void setPrefix(String prefix) {
		_prefix = prefix;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _referenceNumberId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userRole;
	private String _channel;
	private String _type;
	private String _productCode;
	private String _businessType;
	private String _currency;
	private String _prefix;
	private int _active;

}