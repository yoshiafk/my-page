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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.PetRemarksServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PetRemarksSoap implements Serializable {

	public static PetRemarksSoap toSoapModel(PetRemarks model) {
		PetRemarksSoap soapModel = new PetRemarksSoap();

		soapModel.setPetRemarksId(model.getPetRemarksId());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PetRemarksSoap[] toSoapModels(PetRemarks[] models) {
		PetRemarksSoap[] soapModels = new PetRemarksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PetRemarksSoap[][] toSoapModels(PetRemarks[][] models) {
		PetRemarksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PetRemarksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PetRemarksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PetRemarksSoap[] toSoapModels(List<PetRemarks> models) {
		List<PetRemarksSoap> soapModels = new ArrayList<PetRemarksSoap>(
			models.size());

		for (PetRemarks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PetRemarksSoap[soapModels.size()]);
	}

	public PetRemarksSoap() {
	}

	public long getPrimaryKey() {
		return _petRemarksId;
	}

	public void setPrimaryKey(long pk) {
		setPetRemarksId(pk);
	}

	public long getPetRemarksId() {
		return _petRemarksId;
	}

	public void setPetRemarksId(long petRemarksId) {
		_petRemarksId = petRemarksId;
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

	private long _petRemarksId;
	private String _name;
	private String _code;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}