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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.HealthSmePremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HealthSmePremiSoap implements Serializable {

	public static HealthSmePremiSoap toSoapModel(HealthSmePremi model) {
		HealthSmePremiSoap soapModel = new HealthSmePremiSoap();

		soapModel.setHealthSmePremiId(model.getHealthSmePremiId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setPremiType(model.getPremiType());
		soapModel.setAmount(model.getAmount());
		soapModel.setHealthSmeTemplateId(model.getHealthSmeTemplateId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static HealthSmePremiSoap[] toSoapModels(HealthSmePremi[] models) {
		HealthSmePremiSoap[] soapModels = new HealthSmePremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HealthSmePremiSoap[][] toSoapModels(
		HealthSmePremi[][] models) {

		HealthSmePremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new HealthSmePremiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HealthSmePremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HealthSmePremiSoap[] toSoapModels(
		List<HealthSmePremi> models) {

		List<HealthSmePremiSoap> soapModels = new ArrayList<HealthSmePremiSoap>(
			models.size());

		for (HealthSmePremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HealthSmePremiSoap[soapModels.size()]);
	}

	public HealthSmePremiSoap() {
	}

	public long getPrimaryKey() {
		return _healthSmePremiId;
	}

	public void setPrimaryKey(long pk) {
		setHealthSmePremiId(pk);
	}

	public long getHealthSmePremiId() {
		return _healthSmePremiId;
	}

	public void setHealthSmePremiId(long healthSmePremiId) {
		_healthSmePremiId = healthSmePremiId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPremiType() {
		return _premiType;
	}

	public void setPremiType(String premiType) {
		_premiType = premiType;
	}

	public long getAmount() {
		return _amount;
	}

	public void setAmount(long amount) {
		_amount = amount;
	}

	public long getHealthSmeTemplateId() {
		return _healthSmeTemplateId;
	}

	public void setHealthSmeTemplateId(long healthSmeTemplateId) {
		_healthSmeTemplateId = healthSmeTemplateId;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _healthSmePremiId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _premiType;
	private long _amount;
	private long _healthSmeTemplateId;
	private int _active;

}