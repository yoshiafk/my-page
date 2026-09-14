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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.HealthSmeFacilityServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HealthSmeFacilitySoap implements Serializable {

	public static HealthSmeFacilitySoap toSoapModel(HealthSmeFacility model) {
		HealthSmeFacilitySoap soapModel = new HealthSmeFacilitySoap();

		soapModel.setHealthSmeFacilityId(model.getHealthSmeFacilityId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setHealthSmeTypeId(model.getHealthSmeTypeId());
		soapModel.setDefaultMinimum(model.getDefaultMinimum());
		soapModel.setMinimum(model.getMinimum());
		soapModel.setDefaultNormal(model.getDefaultNormal());
		soapModel.setNormal(model.getNormal());
		soapModel.setDefaultMaximum(model.getDefaultMaximum());
		soapModel.setMaximum(model.getMaximum());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static HealthSmeFacilitySoap[] toSoapModels(
		HealthSmeFacility[] models) {

		HealthSmeFacilitySoap[] soapModels =
			new HealthSmeFacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HealthSmeFacilitySoap[][] toSoapModels(
		HealthSmeFacility[][] models) {

		HealthSmeFacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new HealthSmeFacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new HealthSmeFacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HealthSmeFacilitySoap[] toSoapModels(
		List<HealthSmeFacility> models) {

		List<HealthSmeFacilitySoap> soapModels =
			new ArrayList<HealthSmeFacilitySoap>(models.size());

		for (HealthSmeFacility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HealthSmeFacilitySoap[soapModels.size()]);
	}

	public HealthSmeFacilitySoap() {
	}

	public long getPrimaryKey() {
		return _healthSmeFacilityId;
	}

	public void setPrimaryKey(long pk) {
		setHealthSmeFacilityId(pk);
	}

	public long getHealthSmeFacilityId() {
		return _healthSmeFacilityId;
	}

	public void setHealthSmeFacilityId(long healthSmeFacilityId) {
		_healthSmeFacilityId = healthSmeFacilityId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getHealthSmeTypeId() {
		return _healthSmeTypeId;
	}

	public void setHealthSmeTypeId(long healthSmeTypeId) {
		_healthSmeTypeId = healthSmeTypeId;
	}

	public int getDefaultMinimum() {
		return _defaultMinimum;
	}

	public void setDefaultMinimum(int defaultMinimum) {
		_defaultMinimum = defaultMinimum;
	}

	public double getMinimum() {
		return _minimum;
	}

	public void setMinimum(double minimum) {
		_minimum = minimum;
	}

	public int getDefaultNormal() {
		return _defaultNormal;
	}

	public void setDefaultNormal(int defaultNormal) {
		_defaultNormal = defaultNormal;
	}

	public double getNormal() {
		return _normal;
	}

	public void setNormal(double normal) {
		_normal = normal;
	}

	public int getDefaultMaximum() {
		return _defaultMaximum;
	}

	public void setDefaultMaximum(int defaultMaximum) {
		_defaultMaximum = defaultMaximum;
	}

	public double getMaximum() {
		return _maximum;
	}

	public void setMaximum(double maximum) {
		_maximum = maximum;
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

	private long _healthSmeFacilityId;
	private String _name;
	private String _description;
	private long _healthSmeTypeId;
	private int _defaultMinimum;
	private double _minimum;
	private int _defaultNormal;
	private double _normal;
	private int _defaultMaximum;
	private double _maximum;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}