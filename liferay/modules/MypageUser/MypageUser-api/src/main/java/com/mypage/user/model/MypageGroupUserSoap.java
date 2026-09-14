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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.MypageGroupUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MypageGroupUserSoap implements Serializable {

	public static MypageGroupUserSoap toSoapModel(MypageGroupUser model) {
		MypageGroupUserSoap soapModel = new MypageGroupUserSoap();

		soapModel.setMypageGroupUserId(model.getMypageGroupUserId());
		soapModel.setMypageGroupId(model.getMypageGroupId());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MypageGroupUserSoap[] toSoapModels(MypageGroupUser[] models) {
		MypageGroupUserSoap[] soapModels =
			new MypageGroupUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MypageGroupUserSoap[][] toSoapModels(
		MypageGroupUser[][] models) {

		MypageGroupUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MypageGroupUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MypageGroupUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MypageGroupUserSoap[] toSoapModels(
		List<MypageGroupUser> models) {

		List<MypageGroupUserSoap> soapModels =
			new ArrayList<MypageGroupUserSoap>(models.size());

		for (MypageGroupUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MypageGroupUserSoap[soapModels.size()]);
	}

	public MypageGroupUserSoap() {
	}

	public long getPrimaryKey() {
		return _mypageGroupUserId;
	}

	public void setPrimaryKey(long pk) {
		setMypageGroupUserId(pk);
	}

	public long getMypageGroupUserId() {
		return _mypageGroupUserId;
	}

	public void setMypageGroupUserId(long mypageGroupUserId) {
		_mypageGroupUserId = mypageGroupUserId;
	}

	public long getMypageGroupId() {
		return _mypageGroupId;
	}

	public void setMypageGroupId(long mypageGroupId) {
		_mypageGroupId = mypageGroupId;
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

	private long _mypageGroupUserId;
	private long _mypageGroupId;
	private long _mypageUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}