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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelDomesticInsuredTypeServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelDomesticInsuredTypeSoap implements Serializable {

	public static TravelDomesticInsuredTypeSoap toSoapModel(
		TravelDomesticInsuredType model) {

		TravelDomesticInsuredTypeSoap soapModel =
			new TravelDomesticInsuredTypeSoap();

		soapModel.setTravelDomesticInsuredTypeId(
			model.getTravelDomesticInsuredTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static TravelDomesticInsuredTypeSoap[] toSoapModels(
		TravelDomesticInsuredType[] models) {

		TravelDomesticInsuredTypeSoap[] soapModels =
			new TravelDomesticInsuredTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticInsuredTypeSoap[][] toSoapModels(
		TravelDomesticInsuredType[][] models) {

		TravelDomesticInsuredTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelDomesticInsuredTypeSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDomesticInsuredTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticInsuredTypeSoap[] toSoapModels(
		List<TravelDomesticInsuredType> models) {

		List<TravelDomesticInsuredTypeSoap> soapModels =
			new ArrayList<TravelDomesticInsuredTypeSoap>(models.size());

		for (TravelDomesticInsuredType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelDomesticInsuredTypeSoap[soapModels.size()]);
	}

	public TravelDomesticInsuredTypeSoap() {
	}

	public long getPrimaryKey() {
		return _travelDomesticInsuredTypeId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDomesticInsuredTypeId(pk);
	}

	public long getTravelDomesticInsuredTypeId() {
		return _travelDomesticInsuredTypeId;
	}

	public void setTravelDomesticInsuredTypeId(
		long travelDomesticInsuredTypeId) {

		_travelDomesticInsuredTypeId = travelDomesticInsuredTypeId;
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

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _travelDomesticInsuredTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _code;
	private int _active;

}