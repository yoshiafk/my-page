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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.MasterGlobalVariableServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterGlobalVariableSoap implements Serializable {

	public static MasterGlobalVariableSoap toSoapModel(
		MasterGlobalVariable model) {

		MasterGlobalVariableSoap soapModel = new MasterGlobalVariableSoap();

		soapModel.setMasterGlobalVariableId(model.getMasterGlobalVariableId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroup(model.getGroup());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static MasterGlobalVariableSoap[] toSoapModels(
		MasterGlobalVariable[] models) {

		MasterGlobalVariableSoap[] soapModels =
			new MasterGlobalVariableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterGlobalVariableSoap[][] toSoapModels(
		MasterGlobalVariable[][] models) {

		MasterGlobalVariableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MasterGlobalVariableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterGlobalVariableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterGlobalVariableSoap[] toSoapModels(
		List<MasterGlobalVariable> models) {

		List<MasterGlobalVariableSoap> soapModels =
			new ArrayList<MasterGlobalVariableSoap>(models.size());

		for (MasterGlobalVariable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MasterGlobalVariableSoap[soapModels.size()]);
	}

	public MasterGlobalVariableSoap() {
	}

	public long getPrimaryKey() {
		return _masterGlobalVariableId;
	}

	public void setPrimaryKey(long pk) {
		setMasterGlobalVariableId(pk);
	}

	public long getMasterGlobalVariableId() {
		return _masterGlobalVariableId;
	}

	public void setMasterGlobalVariableId(long masterGlobalVariableId) {
		_masterGlobalVariableId = masterGlobalVariableId;
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

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public Long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(Long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _masterGlobalVariableId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _group;
	private String _name;
	private String _value;
	private Long _imageFileEntryId;
	private int _active;

}