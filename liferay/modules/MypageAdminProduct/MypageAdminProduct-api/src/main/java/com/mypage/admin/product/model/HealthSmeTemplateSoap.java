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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.HealthSmeTemplateServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HealthSmeTemplateSoap implements Serializable {

	public static HealthSmeTemplateSoap toSoapModel(HealthSmeTemplate model) {
		HealthSmeTemplateSoap soapModel = new HealthSmeTemplateSoap();

		soapModel.setHealthSmeTemplateId(model.getHealthSmeTemplateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setAmount(model.getAmount());
		soapModel.setAnnualLimit(model.getAnnualLimit());
		soapModel.setHealthSmeTypeId(model.getHealthSmeTypeId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static HealthSmeTemplateSoap[] toSoapModels(
		HealthSmeTemplate[] models) {

		HealthSmeTemplateSoap[] soapModels =
			new HealthSmeTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HealthSmeTemplateSoap[][] toSoapModels(
		HealthSmeTemplate[][] models) {

		HealthSmeTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new HealthSmeTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HealthSmeTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HealthSmeTemplateSoap[] toSoapModels(
		List<HealthSmeTemplate> models) {

		List<HealthSmeTemplateSoap> soapModels =
			new ArrayList<HealthSmeTemplateSoap>(models.size());

		for (HealthSmeTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HealthSmeTemplateSoap[soapModels.size()]);
	}

	public HealthSmeTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _healthSmeTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setHealthSmeTemplateId(pk);
	}

	public long getHealthSmeTemplateId() {
		return _healthSmeTemplateId;
	}

	public void setHealthSmeTemplateId(long healthSmeTemplateId) {
		_healthSmeTemplateId = healthSmeTemplateId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getAmount() {
		return _amount;
	}

	public void setAmount(long amount) {
		_amount = amount;
	}

	public long getAnnualLimit() {
		return _annualLimit;
	}

	public void setAnnualLimit(long annualLimit) {
		_annualLimit = annualLimit;
	}

	public long getHealthSmeTypeId() {
		return _healthSmeTypeId;
	}

	public void setHealthSmeTypeId(long healthSmeTypeId) {
		_healthSmeTypeId = healthSmeTypeId;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _healthSmeTemplateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _code;
	private String _description;
	private long _amount;
	private long _annualLimit;
	private long _healthSmeTypeId;
	private int _active;

}