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

package com.mypage.user.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.MypageUserWorkingHourServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MypageUserWorkingHourSoap implements Serializable {

	public static MypageUserWorkingHourSoap toSoapModel(
		MypageUserWorkingHour model) {

		MypageUserWorkingHourSoap soapModel = new MypageUserWorkingHourSoap();

		soapModel.setMypageUserWorkingHourId(
			model.getMypageUserWorkingHourId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setDay(model.getDay());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static MypageUserWorkingHourSoap[] toSoapModels(
		MypageUserWorkingHour[] models) {

		MypageUserWorkingHourSoap[] soapModels =
			new MypageUserWorkingHourSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MypageUserWorkingHourSoap[][] toSoapModels(
		MypageUserWorkingHour[][] models) {

		MypageUserWorkingHourSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MypageUserWorkingHourSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MypageUserWorkingHourSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MypageUserWorkingHourSoap[] toSoapModels(
		List<MypageUserWorkingHour> models) {

		List<MypageUserWorkingHourSoap> soapModels =
			new ArrayList<MypageUserWorkingHourSoap>(models.size());

		for (MypageUserWorkingHour model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MypageUserWorkingHourSoap[soapModels.size()]);
	}

	public MypageUserWorkingHourSoap() {
	}

	public long getPrimaryKey() {
		return _mypageUserWorkingHourId;
	}

	public void setPrimaryKey(long pk) {
		setMypageUserWorkingHourId(pk);
	}

	public long getMypageUserWorkingHourId() {
		return _mypageUserWorkingHourId;
	}

	public void setMypageUserWorkingHourId(long mypageUserWorkingHourId) {
		_mypageUserWorkingHourId = mypageUserWorkingHourId;
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

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
	}

	public String getDay() {
		return _day;
	}

	public void setDay(String day) {
		_day = day;
	}

	public String getStartTime() {
		return _startTime;
	}

	public void setStartTime(String startTime) {
		_startTime = startTime;
	}

	public String getEndTime() {
		return _endTime;
	}

	public void setEndTime(String endTime) {
		_endTime = endTime;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _mypageUserWorkingHourId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mypageUserId;
	private String _day;
	private String _startTime;
	private String _endTime;
	private int _status;

}