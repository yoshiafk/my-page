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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelDomesticPlanServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelDomesticPlanSoap implements Serializable {

	public static TravelDomesticPlanSoap toSoapModel(TravelDomesticPlan model) {
		TravelDomesticPlanSoap soapModel = new TravelDomesticPlanSoap();

		soapModel.setTravelDomesticPlanId(model.getTravelDomesticPlanId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setToproTsi(model.getToproTsi());
		soapModel.setToproAtsi(model.getToproAtsi());
		soapModel.setSort(model.getSort());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static TravelDomesticPlanSoap[] toSoapModels(
		TravelDomesticPlan[] models) {

		TravelDomesticPlanSoap[] soapModels =
			new TravelDomesticPlanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticPlanSoap[][] toSoapModels(
		TravelDomesticPlan[][] models) {

		TravelDomesticPlanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelDomesticPlanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDomesticPlanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticPlanSoap[] toSoapModels(
		List<TravelDomesticPlan> models) {

		List<TravelDomesticPlanSoap> soapModels =
			new ArrayList<TravelDomesticPlanSoap>(models.size());

		for (TravelDomesticPlan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelDomesticPlanSoap[soapModels.size()]);
	}

	public TravelDomesticPlanSoap() {
	}

	public long getPrimaryKey() {
		return _travelDomesticPlanId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDomesticPlanId(pk);
	}

	public long getTravelDomesticPlanId() {
		return _travelDomesticPlanId;
	}

	public void setTravelDomesticPlanId(long travelDomesticPlanId) {
		_travelDomesticPlanId = travelDomesticPlanId;
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

	public int getToproTsi() {
		return _toproTsi;
	}

	public void setToproTsi(int toproTsi) {
		_toproTsi = toproTsi;
	}

	public int getToproAtsi() {
		return _toproAtsi;
	}

	public void setToproAtsi(int toproAtsi) {
		_toproAtsi = toproAtsi;
	}

	public int getSort() {
		return _sort;
	}

	public void setSort(int sort) {
		_sort = sort;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _travelDomesticPlanId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _code;
	private int _toproTsi;
	private int _toproAtsi;
	private int _sort;
	private int _active;

}