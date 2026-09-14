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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartActiveLinkServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartActiveLinkSoap implements Serializable {

	public static SmartActiveLinkSoap toSoapModel(SmartActiveLink model) {
		SmartActiveLinkSoap soapModel = new SmartActiveLinkSoap();

		soapModel.setSmartActiveLinkId(model.getSmartActiveLinkId());
		soapModel.setCategory(model.getCategory());
		soapModel.setTitle(model.getTitle());
		soapModel.setFileUploadEntryId(model.getFileUploadEntryId());
		soapModel.setFileUploadUrl(model.getFileUploadUrl());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartActiveLinkSoap[] toSoapModels(SmartActiveLink[] models) {
		SmartActiveLinkSoap[] soapModels =
			new SmartActiveLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveLinkSoap[][] toSoapModels(
		SmartActiveLink[][] models) {

		SmartActiveLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartActiveLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartActiveLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveLinkSoap[] toSoapModels(
		List<SmartActiveLink> models) {

		List<SmartActiveLinkSoap> soapModels =
			new ArrayList<SmartActiveLinkSoap>(models.size());

		for (SmartActiveLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SmartActiveLinkSoap[soapModels.size()]);
	}

	public SmartActiveLinkSoap() {
	}

	public long getPrimaryKey() {
		return _smartActiveLinkId;
	}

	public void setPrimaryKey(long pk) {
		setSmartActiveLinkId(pk);
	}

	public long getSmartActiveLinkId() {
		return _smartActiveLinkId;
	}

	public void setSmartActiveLinkId(long smartActiveLinkId) {
		_smartActiveLinkId = smartActiveLinkId;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getFileUploadEntryId() {
		return _fileUploadEntryId;
	}

	public void setFileUploadEntryId(long fileUploadEntryId) {
		_fileUploadEntryId = fileUploadEntryId;
	}

	public String getFileUploadUrl() {
		return _fileUploadUrl;
	}

	public void setFileUploadUrl(String fileUploadUrl) {
		_fileUploadUrl = fileUploadUrl;
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

	private long _smartActiveLinkId;
	private String _category;
	private String _title;
	private long _fileUploadEntryId;
	private String _fileUploadUrl;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}