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
 * This class is used by SOAP remote services, specifically {@link com.mypage.agencyportal.service.http.AgentTokenServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AgentTokenSoap implements Serializable {

	public static AgentTokenSoap toSoapModel(AgentToken model) {
		AgentTokenSoap soapModel = new AgentTokenSoap();

		soapModel.setAgentTokenId(model.getAgentTokenId());
		soapModel.setDeptCode(model.getDeptCode());
		soapModel.setToken(model.getToken());
		soapModel.setIsValid(model.getIsValid());
		soapModel.setApiRequestToken(model.getApiRequestToken());
		soapModel.setApiRequestTokenExpired(model.getApiRequestTokenExpired());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AgentTokenSoap[] toSoapModels(AgentToken[] models) {
		AgentTokenSoap[] soapModels = new AgentTokenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgentTokenSoap[][] toSoapModels(AgentToken[][] models) {
		AgentTokenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AgentTokenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgentTokenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgentTokenSoap[] toSoapModels(List<AgentToken> models) {
		List<AgentTokenSoap> soapModels = new ArrayList<AgentTokenSoap>(
			models.size());

		for (AgentToken model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgentTokenSoap[soapModels.size()]);
	}

	public AgentTokenSoap() {
	}

	public long getPrimaryKey() {
		return _agentTokenId;
	}

	public void setPrimaryKey(long pk) {
		setAgentTokenId(pk);
	}

	public long getAgentTokenId() {
		return _agentTokenId;
	}

	public void setAgentTokenId(long agentTokenId) {
		_agentTokenId = agentTokenId;
	}

	public String getDeptCode() {
		return _deptCode;
	}

	public void setDeptCode(String deptCode) {
		_deptCode = deptCode;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public int getIsValid() {
		return _isValid;
	}

	public void setIsValid(int isValid) {
		_isValid = isValid;
	}

	public String getApiRequestToken() {
		return _apiRequestToken;
	}

	public void setApiRequestToken(String apiRequestToken) {
		_apiRequestToken = apiRequestToken;
	}

	public Date getApiRequestTokenExpired() {
		return _apiRequestTokenExpired;
	}

	public void setApiRequestTokenExpired(Date apiRequestTokenExpired) {
		_apiRequestTokenExpired = apiRequestTokenExpired;
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

	private long _agentTokenId;
	private String _deptCode;
	private String _token;
	private int _isValid;
	private String _apiRequestToken;
	private Date _apiRequestTokenExpired;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}