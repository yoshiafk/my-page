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
 * This class is used by SOAP remote services, specifically {@link com.mypage.agencyportal.service.http.AgentMarkCalendarServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AgentMarkCalendarSoap implements Serializable {

	public static AgentMarkCalendarSoap toSoapModel(AgentMarkCalendar model) {
		AgentMarkCalendarSoap soapModel = new AgentMarkCalendarSoap();

		soapModel.setAgentMarkCalendarId(model.getAgentMarkCalendarId());
		soapModel.setAgentCalendarId(model.getAgentCalendarId());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AgentMarkCalendarSoap[] toSoapModels(
		AgentMarkCalendar[] models) {

		AgentMarkCalendarSoap[] soapModels =
			new AgentMarkCalendarSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgentMarkCalendarSoap[][] toSoapModels(
		AgentMarkCalendar[][] models) {

		AgentMarkCalendarSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AgentMarkCalendarSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgentMarkCalendarSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgentMarkCalendarSoap[] toSoapModels(
		List<AgentMarkCalendar> models) {

		List<AgentMarkCalendarSoap> soapModels =
			new ArrayList<AgentMarkCalendarSoap>(models.size());

		for (AgentMarkCalendar model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgentMarkCalendarSoap[soapModels.size()]);
	}

	public AgentMarkCalendarSoap() {
	}

	public long getPrimaryKey() {
		return _agentMarkCalendarId;
	}

	public void setPrimaryKey(long pk) {
		setAgentMarkCalendarId(pk);
	}

	public long getAgentMarkCalendarId() {
		return _agentMarkCalendarId;
	}

	public void setAgentMarkCalendarId(long agentMarkCalendarId) {
		_agentMarkCalendarId = agentMarkCalendarId;
	}

	public long getAgentCalendarId() {
		return _agentCalendarId;
	}

	public void setAgentCalendarId(long agentCalendarId) {
		_agentCalendarId = agentCalendarId;
	}

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
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

	private long _agentMarkCalendarId;
	private long _agentCalendarId;
	private long _mypageUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}