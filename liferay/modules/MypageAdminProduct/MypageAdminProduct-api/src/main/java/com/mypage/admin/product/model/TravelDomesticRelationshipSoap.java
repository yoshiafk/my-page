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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelDomesticRelationshipServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelDomesticRelationshipSoap implements Serializable {

	public static TravelDomesticRelationshipSoap toSoapModel(
		TravelDomesticRelationship model) {

		TravelDomesticRelationshipSoap soapModel =
			new TravelDomesticRelationshipSoap();

		soapModel.setTravelDomesticRelationshipId(
			model.getTravelDomesticRelationshipId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setSort(model.getSort());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static TravelDomesticRelationshipSoap[] toSoapModels(
		TravelDomesticRelationship[] models) {

		TravelDomesticRelationshipSoap[] soapModels =
			new TravelDomesticRelationshipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticRelationshipSoap[][] toSoapModels(
		TravelDomesticRelationship[][] models) {

		TravelDomesticRelationshipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelDomesticRelationshipSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDomesticRelationshipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticRelationshipSoap[] toSoapModels(
		List<TravelDomesticRelationship> models) {

		List<TravelDomesticRelationshipSoap> soapModels =
			new ArrayList<TravelDomesticRelationshipSoap>(models.size());

		for (TravelDomesticRelationship model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelDomesticRelationshipSoap[soapModels.size()]);
	}

	public TravelDomesticRelationshipSoap() {
	}

	public long getPrimaryKey() {
		return _travelDomesticRelationshipId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDomesticRelationshipId(pk);
	}

	public long getTravelDomesticRelationshipId() {
		return _travelDomesticRelationshipId;
	}

	public void setTravelDomesticRelationshipId(
		long travelDomesticRelationshipId) {

		_travelDomesticRelationshipId = travelDomesticRelationshipId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _travelDomesticRelationshipId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private int _sort;
	private int _active;

}