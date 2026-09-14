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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.MasterCityServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterCitySoap implements Serializable {

	public static MasterCitySoap toSoapModel(MasterCity model) {
		MasterCitySoap soapModel = new MasterCitySoap();

		soapModel.setMasterCityId(model.getMasterCityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setProvinceId(model.getProvinceId());
		soapModel.setStatus(model.getStatus());
		soapModel.setParEarthquakeZone(model.getParEarthquakeZone());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static MasterCitySoap[] toSoapModels(MasterCity[] models) {
		MasterCitySoap[] soapModels = new MasterCitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterCitySoap[][] toSoapModels(MasterCity[][] models) {
		MasterCitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterCitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterCitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterCitySoap[] toSoapModels(List<MasterCity> models) {
		List<MasterCitySoap> soapModels = new ArrayList<MasterCitySoap>(
			models.size());

		for (MasterCity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterCitySoap[soapModels.size()]);
	}

	public MasterCitySoap() {
	}

	public long getPrimaryKey() {
		return _masterCityId;
	}

	public void setPrimaryKey(long pk) {
		setMasterCityId(pk);
	}

	public long getMasterCityId() {
		return _masterCityId;
	}

	public void setMasterCityId(long masterCityId) {
		_masterCityId = masterCityId;
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

	public long getProvinceId() {
		return _provinceId;
	}

	public void setProvinceId(long provinceId) {
		_provinceId = provinceId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Integer getParEarthquakeZone() {
		return _parEarthquakeZone;
	}

	public void setParEarthquakeZone(Integer parEarthquakeZone) {
		_parEarthquakeZone = parEarthquakeZone;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
		_active = active;
	}

	private long _masterCityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _provinceId;
	private String _status;
	private Integer _parEarthquakeZone;
	private Integer _active;

}