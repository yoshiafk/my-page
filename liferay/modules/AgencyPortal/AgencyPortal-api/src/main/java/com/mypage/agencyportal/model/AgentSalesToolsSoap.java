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

package com.mypage.agencyportal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.agencyportal.service.http.AgentSalesToolsServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AgentSalesToolsSoap implements Serializable {

	public static AgentSalesToolsSoap toSoapModel(AgentSalesTools model) {
		AgentSalesToolsSoap soapModel = new AgentSalesToolsSoap();

		soapModel.setAgentSalesToolsId(model.getAgentSalesToolsId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCategory(model.getCategory());
		soapModel.setFileUploadEntryId(model.getFileUploadEntryId());
		soapModel.setFileUploadUrl(model.getFileUploadUrl());
		soapModel.setMypageUserRoleId(model.getMypageUserRoleId());
		soapModel.setRole(model.getRole());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AgentSalesToolsSoap[] toSoapModels(AgentSalesTools[] models) {
		AgentSalesToolsSoap[] soapModels =
			new AgentSalesToolsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgentSalesToolsSoap[][] toSoapModels(
		AgentSalesTools[][] models) {

		AgentSalesToolsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AgentSalesToolsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgentSalesToolsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgentSalesToolsSoap[] toSoapModels(
		List<AgentSalesTools> models) {

		List<AgentSalesToolsSoap> soapModels =
			new ArrayList<AgentSalesToolsSoap>(models.size());

		for (AgentSalesTools model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgentSalesToolsSoap[soapModels.size()]);
	}

	public AgentSalesToolsSoap() {
	}

	public long getPrimaryKey() {
		return _agentSalesToolsId;
	}

	public void setPrimaryKey(long pk) {
		setAgentSalesToolsId(pk);
	}

	public long getAgentSalesToolsId() {
		return _agentSalesToolsId;
	}

	public void setAgentSalesToolsId(long agentSalesToolsId) {
		_agentSalesToolsId = agentSalesToolsId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
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

	public long getMypageUserRoleId() {
		return _mypageUserRoleId;
	}

	public void setMypageUserRoleId(long mypageUserRoleId) {
		_mypageUserRoleId = mypageUserRoleId;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
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

	private long _agentSalesToolsId;
	private String _title;
	private String _description;
	private long _categoryId;
	private String _category;
	private long _fileUploadEntryId;
	private String _fileUploadUrl;
	private long _mypageUserRoleId;
	private String _role;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}