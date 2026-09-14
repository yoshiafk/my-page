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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.MypageUserGracePeriodServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MypageUserGracePeriodSoap implements Serializable {

	public static MypageUserGracePeriodSoap toSoapModel(
		MypageUserGracePeriod model) {

		MypageUserGracePeriodSoap soapModel = new MypageUserGracePeriodSoap();

		soapModel.setMypageUserGracePeriodId(
			model.getMypageUserGracePeriodId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setCode(model.getCode());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static MypageUserGracePeriodSoap[] toSoapModels(
		MypageUserGracePeriod[] models) {

		MypageUserGracePeriodSoap[] soapModels =
			new MypageUserGracePeriodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MypageUserGracePeriodSoap[][] toSoapModels(
		MypageUserGracePeriod[][] models) {

		MypageUserGracePeriodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MypageUserGracePeriodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MypageUserGracePeriodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MypageUserGracePeriodSoap[] toSoapModels(
		List<MypageUserGracePeriod> models) {

		List<MypageUserGracePeriodSoap> soapModels =
			new ArrayList<MypageUserGracePeriodSoap>(models.size());

		for (MypageUserGracePeriod model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MypageUserGracePeriodSoap[soapModels.size()]);
	}

	public MypageUserGracePeriodSoap() {
	}

	public long getPrimaryKey() {
		return _mypageUserGracePeriodId;
	}

	public void setPrimaryKey(long pk) {
		setMypageUserGracePeriodId(pk);
	}

	public long getMypageUserGracePeriodId() {
		return _mypageUserGracePeriodId;
	}

	public void setMypageUserGracePeriodId(long mypageUserGracePeriodId) {
		_mypageUserGracePeriodId = mypageUserGracePeriodId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	private long _mypageUserGracePeriodId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mypageUserId;
	private String _code;
	private int _value;

}