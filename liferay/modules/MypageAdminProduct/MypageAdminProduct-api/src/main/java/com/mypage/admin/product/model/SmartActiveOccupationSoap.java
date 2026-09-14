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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartActiveOccupationServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartActiveOccupationSoap implements Serializable {

	public static SmartActiveOccupationSoap toSoapModel(
		SmartActiveOccupation model) {

		SmartActiveOccupationSoap soapModel = new SmartActiveOccupationSoap();

		soapModel.setSmartActiveOccupationId(
			model.getSmartActiveOccupationId());
		soapModel.setCode(model.getCode());
		soapModel.setNameId(model.getNameId());
		soapModel.setNameEn(model.getNameEn());
		soapModel.setActive(model.getActive());
		soapModel.setSmartActiveClassRateId(model.getSmartActiveClassRateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartActiveOccupationSoap[] toSoapModels(
		SmartActiveOccupation[] models) {

		SmartActiveOccupationSoap[] soapModels =
			new SmartActiveOccupationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveOccupationSoap[][] toSoapModels(
		SmartActiveOccupation[][] models) {

		SmartActiveOccupationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartActiveOccupationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartActiveOccupationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveOccupationSoap[] toSoapModels(
		List<SmartActiveOccupation> models) {

		List<SmartActiveOccupationSoap> soapModels =
			new ArrayList<SmartActiveOccupationSoap>(models.size());

		for (SmartActiveOccupation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmartActiveOccupationSoap[soapModels.size()]);
	}

	public SmartActiveOccupationSoap() {
	}

	public long getPrimaryKey() {
		return _smartActiveOccupationId;
	}

	public void setPrimaryKey(long pk) {
		setSmartActiveOccupationId(pk);
	}

	public long getSmartActiveOccupationId() {
		return _smartActiveOccupationId;
	}

	public void setSmartActiveOccupationId(long smartActiveOccupationId) {
		_smartActiveOccupationId = smartActiveOccupationId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getNameId() {
		return _nameId;
	}

	public void setNameId(String nameId) {
		_nameId = nameId;
	}

	public String getNameEn() {
		return _nameEn;
	}

	public void setNameEn(String nameEn) {
		_nameEn = nameEn;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	public long getSmartActiveClassRateId() {
		return _smartActiveClassRateId;
	}

	public void setSmartActiveClassRateId(long smartActiveClassRateId) {
		_smartActiveClassRateId = smartActiveClassRateId;
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

	private long _smartActiveOccupationId;
	private String _code;
	private String _nameId;
	private String _nameEn;
	private int _active;
	private long _smartActiveClassRateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}