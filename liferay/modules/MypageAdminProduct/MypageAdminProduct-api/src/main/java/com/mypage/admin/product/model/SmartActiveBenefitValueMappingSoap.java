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

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartActiveBenefitValueMappingServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartActiveBenefitValueMappingSoap implements Serializable {

	public static SmartActiveBenefitValueMappingSoap toSoapModel(
		SmartActiveBenefitValueMapping model) {

		SmartActiveBenefitValueMappingSoap soapModel =
			new SmartActiveBenefitValueMappingSoap();

		soapModel.setSmartActiveBenefitValueMappingId(
			model.getSmartActiveBenefitValueMappingId());
		soapModel.setSmartActiveBenefitTypeId(
			model.getSmartActiveBenefitTypeId());
		soapModel.setSmartActiveBenefitId(model.getSmartActiveBenefitId());
		soapModel.setSmartActiveBenefitValueId(
			model.getSmartActiveBenefitValueId());
		soapModel.setValue(model.getValue());
		soapModel.setLimitValue(model.getLimitValue());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartActiveBenefitValueMappingSoap[] toSoapModels(
		SmartActiveBenefitValueMapping[] models) {

		SmartActiveBenefitValueMappingSoap[] soapModels =
			new SmartActiveBenefitValueMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveBenefitValueMappingSoap[][] toSoapModels(
		SmartActiveBenefitValueMapping[][] models) {

		SmartActiveBenefitValueMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SmartActiveBenefitValueMappingSoap
				[models.length][models[0].length];
		}
		else {
			soapModels = new SmartActiveBenefitValueMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveBenefitValueMappingSoap[] toSoapModels(
		List<SmartActiveBenefitValueMapping> models) {

		List<SmartActiveBenefitValueMappingSoap> soapModels =
			new ArrayList<SmartActiveBenefitValueMappingSoap>(models.size());

		for (SmartActiveBenefitValueMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmartActiveBenefitValueMappingSoap[soapModels.size()]);
	}

	public SmartActiveBenefitValueMappingSoap() {
	}

	public long getPrimaryKey() {
		return _smartActiveBenefitValueMappingId;
	}

	public void setPrimaryKey(long pk) {
		setSmartActiveBenefitValueMappingId(pk);
	}

	public long getSmartActiveBenefitValueMappingId() {
		return _smartActiveBenefitValueMappingId;
	}

	public void setSmartActiveBenefitValueMappingId(
		long smartActiveBenefitValueMappingId) {

		_smartActiveBenefitValueMappingId = smartActiveBenefitValueMappingId;
	}

	public long getSmartActiveBenefitTypeId() {
		return _smartActiveBenefitTypeId;
	}

	public void setSmartActiveBenefitTypeId(long smartActiveBenefitTypeId) {
		_smartActiveBenefitTypeId = smartActiveBenefitTypeId;
	}

	public long getSmartActiveBenefitId() {
		return _smartActiveBenefitId;
	}

	public void setSmartActiveBenefitId(long smartActiveBenefitId) {
		_smartActiveBenefitId = smartActiveBenefitId;
	}

	public long getSmartActiveBenefitValueId() {
		return _smartActiveBenefitValueId;
	}

	public void setSmartActiveBenefitValueId(long smartActiveBenefitValueId) {
		_smartActiveBenefitValueId = smartActiveBenefitValueId;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public BigDecimal getLimitValue() {
		return _limitValue;
	}

	public void setLimitValue(BigDecimal limitValue) {
		_limitValue = limitValue;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
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

	private long _smartActiveBenefitValueMappingId;
	private long _smartActiveBenefitTypeId;
	private long _smartActiveBenefitId;
	private long _smartActiveBenefitValueId;
	private String _value;
	private BigDecimal _limitValue;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}