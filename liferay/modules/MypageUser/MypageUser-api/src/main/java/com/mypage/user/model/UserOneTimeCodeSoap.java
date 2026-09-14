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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.UserOneTimeCodeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserOneTimeCodeSoap implements Serializable {

	public static UserOneTimeCodeSoap toSoapModel(UserOneTimeCode model) {
		UserOneTimeCodeSoap soapModel = new UserOneTimeCodeSoap();

		soapModel.setUserOneTimeCodeId(model.getUserOneTimeCodeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSharedSecret(model.getSharedSecret());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setTimestampExpiryDate(model.getTimestampExpiryDate());
		soapModel.setIsUsed(model.getIsUsed());

		return soapModel;
	}

	public static UserOneTimeCodeSoap[] toSoapModels(UserOneTimeCode[] models) {
		UserOneTimeCodeSoap[] soapModels =
			new UserOneTimeCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserOneTimeCodeSoap[][] toSoapModels(
		UserOneTimeCode[][] models) {

		UserOneTimeCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserOneTimeCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserOneTimeCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserOneTimeCodeSoap[] toSoapModels(
		List<UserOneTimeCode> models) {

		List<UserOneTimeCodeSoap> soapModels =
			new ArrayList<UserOneTimeCodeSoap>(models.size());

		for (UserOneTimeCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserOneTimeCodeSoap[soapModels.size()]);
	}

	public UserOneTimeCodeSoap() {
	}

	public long getPrimaryKey() {
		return _userOneTimeCodeId;
	}

	public void setPrimaryKey(long pk) {
		setUserOneTimeCodeId(pk);
	}

	public long getUserOneTimeCodeId() {
		return _userOneTimeCodeId;
	}

	public void setUserOneTimeCodeId(long userOneTimeCodeId) {
		_userOneTimeCodeId = userOneTimeCodeId;
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

	public String getSharedSecret() {
		return _sharedSecret;
	}

	public void setSharedSecret(String sharedSecret) {
		_sharedSecret = sharedSecret;
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

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public long getTimestampExpiryDate() {
		return _TimestampExpiryDate;
	}

	public void setTimestampExpiryDate(long TimestampExpiryDate) {
		_TimestampExpiryDate = TimestampExpiryDate;
	}

	public int getIsUsed() {
		return _isUsed;
	}

	public void setIsUsed(int isUsed) {
		_isUsed = isUsed;
	}

	private long _userOneTimeCodeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _sharedSecret;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _expiryDate;
	private long _TimestampExpiryDate;
	private int _isUsed;

}