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

package com.aii.esppk.admin.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.aii.esppk.admin.service.http.SppkUserServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SppkUserSoap implements Serializable {

	public static SppkUserSoap toSoapModel(SppkUser model) {
		SppkUserSoap soapModel = new SppkUserSoap();

		soapModel.setSppkUserId(model.getSppkUserId());
		soapModel.setSppkLoginCode(model.getSppkLoginCode());
		soapModel.setPassword(model.getPassword());
		soapModel.setFullName(model.getFullName());
		soapModel.setRoleCode(model.getRoleCode());
		soapModel.setEmail(model.getEmail());
		soapModel.setAllAccess(model.getAllAccess());
		soapModel.setAccessData(model.getAccessData());
		soapModel.setAccessMonitoring(model.getAccessMonitoring());
		soapModel.setActive(model.getActive());
		soapModel.setExpireDate(model.getExpireDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOtpCode(model.getOtpCode());
		soapModel.setOtpExpired(model.getOtpExpired());

		return soapModel;
	}

	public static SppkUserSoap[] toSoapModels(SppkUser[] models) {
		SppkUserSoap[] soapModels = new SppkUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SppkUserSoap[][] toSoapModels(SppkUser[][] models) {
		SppkUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SppkUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SppkUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SppkUserSoap[] toSoapModels(List<SppkUser> models) {
		List<SppkUserSoap> soapModels = new ArrayList<SppkUserSoap>(
			models.size());

		for (SppkUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SppkUserSoap[soapModels.size()]);
	}

	public SppkUserSoap() {
	}

	public long getPrimaryKey() {
		return _sppkUserId;
	}

	public void setPrimaryKey(long pk) {
		setSppkUserId(pk);
	}

	public long getSppkUserId() {
		return _sppkUserId;
	}

	public void setSppkUserId(long sppkUserId) {
		_sppkUserId = sppkUserId;
	}

	public String getSppkLoginCode() {
		return _sppkLoginCode;
	}

	public void setSppkLoginCode(String sppkLoginCode) {
		_sppkLoginCode = sppkLoginCode;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getRoleCode() {
		return _roleCode;
	}

	public void setRoleCode(String roleCode) {
		_roleCode = roleCode;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public int getAllAccess() {
		return _allAccess;
	}

	public void setAllAccess(int allAccess) {
		_allAccess = allAccess;
	}

	public int getAccessData() {
		return _accessData;
	}

	public void setAccessData(int accessData) {
		_accessData = accessData;
	}

	public int getAccessMonitoring() {
		return _accessMonitoring;
	}

	public void setAccessMonitoring(int accessMonitoring) {
		_accessMonitoring = accessMonitoring;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	public Date getExpireDate() {
		return _expireDate;
	}

	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
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

	public String getOtpCode() {
		return _otpCode;
	}

	public void setOtpCode(String otpCode) {
		_otpCode = otpCode;
	}

	public Date getOtpExpired() {
		return _otpExpired;
	}

	public void setOtpExpired(Date otpExpired) {
		_otpExpired = otpExpired;
	}

	private long _sppkUserId;
	private String _sppkLoginCode;
	private String _password;
	private String _fullName;
	private String _roleCode;
	private String _email;
	private int _allAccess;
	private int _accessData;
	private int _accessMonitoring;
	private int _active;
	private Date _expireDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _otpCode;
	private Date _otpExpired;

}