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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.MypageUserLicensesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MypageUserLicensesSoap implements Serializable {

	public static MypageUserLicensesSoap toSoapModel(MypageUserLicenses model) {
		MypageUserLicensesSoap soapModel = new MypageUserLicensesSoap();

		soapModel.setMypageUserLicensesId(model.getMypageUserLicensesId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setProductId(model.getProductId());

		return soapModel;
	}

	public static MypageUserLicensesSoap[] toSoapModels(
		MypageUserLicenses[] models) {

		MypageUserLicensesSoap[] soapModels =
			new MypageUserLicensesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MypageUserLicensesSoap[][] toSoapModels(
		MypageUserLicenses[][] models) {

		MypageUserLicensesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MypageUserLicensesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MypageUserLicensesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MypageUserLicensesSoap[] toSoapModels(
		List<MypageUserLicenses> models) {

		List<MypageUserLicensesSoap> soapModels =
			new ArrayList<MypageUserLicensesSoap>(models.size());

		for (MypageUserLicenses model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MypageUserLicensesSoap[soapModels.size()]);
	}

	public MypageUserLicensesSoap() {
	}

	public long getPrimaryKey() {
		return _mypageUserLicensesId;
	}

	public void setPrimaryKey(long pk) {
		setMypageUserLicensesId(pk);
	}

	public long getMypageUserLicensesId() {
		return _mypageUserLicensesId;
	}

	public void setMypageUserLicensesId(long mypageUserLicensesId) {
		_mypageUserLicensesId = mypageUserLicensesId;
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

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	private long _mypageUserLicensesId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mypageUserId;
	private long _productId;

}