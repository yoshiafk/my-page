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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.HealthSmeTypeServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HealthSmeTypeSoap implements Serializable {

	public static HealthSmeTypeSoap toSoapModel(HealthSmeType model) {
		HealthSmeTypeSoap soapModel = new HealthSmeTypeSoap();

		soapModel.setHealthSmeTypeId(model.getHealthSmeTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTypeName(model.getTypeName());
		soapModel.setTypeCode(model.getTypeCode());
		soapModel.setTypeDescription(model.getTypeDescription());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static HealthSmeTypeSoap[] toSoapModels(HealthSmeType[] models) {
		HealthSmeTypeSoap[] soapModels = new HealthSmeTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HealthSmeTypeSoap[][] toSoapModels(HealthSmeType[][] models) {
		HealthSmeTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HealthSmeTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HealthSmeTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HealthSmeTypeSoap[] toSoapModels(List<HealthSmeType> models) {
		List<HealthSmeTypeSoap> soapModels = new ArrayList<HealthSmeTypeSoap>(
			models.size());

		for (HealthSmeType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HealthSmeTypeSoap[soapModels.size()]);
	}

	public HealthSmeTypeSoap() {
	}

	public long getPrimaryKey() {
		return _healthSmeTypeId;
	}

	public void setPrimaryKey(long pk) {
		setHealthSmeTypeId(pk);
	}

	public long getHealthSmeTypeId() {
		return _healthSmeTypeId;
	}

	public void setHealthSmeTypeId(long healthSmeTypeId) {
		_healthSmeTypeId = healthSmeTypeId;
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

	public String getTypeName() {
		return _typeName;
	}

	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	public String getTypeCode() {
		return _typeCode;
	}

	public void setTypeCode(String typeCode) {
		_typeCode = typeCode;
	}

	public String getTypeDescription() {
		return _typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		_typeDescription = typeDescription;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _healthSmeTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _typeName;
	private String _typeCode;
	private String _typeDescription;
	private int _active;

}