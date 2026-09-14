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
 * This class is used by SOAP remote services, specifically {@link com.mypage.agencyportal.service.http.AgentNotificationServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AgentNotificationSoap implements Serializable {

	public static AgentNotificationSoap toSoapModel(AgentNotification model) {
		AgentNotificationSoap soapModel = new AgentNotificationSoap();

		soapModel.setAgentNotificationId(model.getAgentNotificationId());
		soapModel.setTitle(model.getTitle());
		soapModel.setLocation(model.getLocation());
		soapModel.setAddress(model.getAddress());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setMypageUserRoleId(model.getMypageUserRoleId());
		soapModel.setRole(model.getRole());
		soapModel.setMypageUserGroupId(model.getMypageUserGroupId());
		soapModel.setGroup(model.getGroup());
		soapModel.setReferenceId(model.getReferenceId());
		soapModel.setDescription(model.getDescription());
		soapModel.setLink(model.getLink());
		soapModel.setCategory(model.getCategory());
		soapModel.setFileUploadEntryId(model.getFileUploadEntryId());
		soapModel.setFileUploadUrl(model.getFileUploadUrl());
		soapModel.setIsAllDay(model.getIsAllDay());
		soapModel.setIsRead(model.getIsRead());
		soapModel.setActive(model.getActive());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AgentNotificationSoap[] toSoapModels(
		AgentNotification[] models) {

		AgentNotificationSoap[] soapModels =
			new AgentNotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgentNotificationSoap[][] toSoapModels(
		AgentNotification[][] models) {

		AgentNotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AgentNotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgentNotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgentNotificationSoap[] toSoapModels(
		List<AgentNotification> models) {

		List<AgentNotificationSoap> soapModels =
			new ArrayList<AgentNotificationSoap>(models.size());

		for (AgentNotification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgentNotificationSoap[soapModels.size()]);
	}

	public AgentNotificationSoap() {
	}

	public long getPrimaryKey() {
		return _agentNotificationId;
	}

	public void setPrimaryKey(long pk) {
		setAgentNotificationId(pk);
	}

	public long getAgentNotificationId() {
		return _agentNotificationId;
	}

	public void setAgentNotificationId(long agentNotificationId) {
		_agentNotificationId = agentNotificationId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public String getStartTime() {
		return _startTime;
	}

	public void setStartTime(String startTime) {
		_startTime = startTime;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getEndTime() {
		return _endTime;
	}

	public void setEndTime(String endTime) {
		_endTime = endTime;
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

	public long getMypageUserGroupId() {
		return _mypageUserGroupId;
	}

	public void setMypageUserGroupId(long mypageUserGroupId) {
		_mypageUserGroupId = mypageUserGroupId;
	}

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	public long getReferenceId() {
		return _referenceId;
	}

	public void setReferenceId(long referenceId) {
		_referenceId = referenceId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
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

	public int getIsAllDay() {
		return _isAllDay;
	}

	public void setIsAllDay(int isAllDay) {
		_isAllDay = isAllDay;
	}

	public int getIsRead() {
		return _isRead;
	}

	public void setIsRead(int isRead) {
		_isRead = isRead;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
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

	private long _agentNotificationId;
	private String _title;
	private String _location;
	private String _address;
	private Date _startDate;
	private String _startTime;
	private Date _endDate;
	private String _endTime;
	private long _mypageUserRoleId;
	private String _role;
	private long _mypageUserGroupId;
	private String _group;
	private long _referenceId;
	private String _description;
	private String _link;
	private String _category;
	private long _fileUploadEntryId;
	private String _fileUploadUrl;
	private int _isAllDay;
	private int _isRead;
	private int _active;
	private long _mypageUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}