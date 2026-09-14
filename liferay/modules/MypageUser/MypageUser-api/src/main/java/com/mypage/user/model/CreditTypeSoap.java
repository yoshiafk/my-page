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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.CreditTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CreditTypeSoap implements Serializable {

	public static CreditTypeSoap toSoapModel(CreditType model) {
		CreditTypeSoap soapModel = new CreditTypeSoap();

		soapModel.setCreditTypeId(model.getCreditTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setName(model.getName());
		soapModel.setAgentType(model.getAgentType());
		soapModel.setLimit(model.getLimit());
		soapModel.setOverrideGracePeriod(model.getOverrideGracePeriod());
		soapModel.setNettPremiAllowed(model.getNettPremiAllowed());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static CreditTypeSoap[] toSoapModels(CreditType[] models) {
		CreditTypeSoap[] soapModels = new CreditTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditTypeSoap[][] toSoapModels(CreditType[][] models) {
		CreditTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditTypeSoap[] toSoapModels(List<CreditType> models) {
		List<CreditTypeSoap> soapModels = new ArrayList<CreditTypeSoap>(
			models.size());

		for (CreditType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditTypeSoap[soapModels.size()]);
	}

	public CreditTypeSoap() {
	}

	public long getPrimaryKey() {
		return _creditTypeId;
	}

	public void setPrimaryKey(long pk) {
		setCreditTypeId(pk);
	}

	public long getCreditTypeId() {
		return _creditTypeId;
	}

	public void setCreditTypeId(long creditTypeId) {
		_creditTypeId = creditTypeId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAgentType() {
		return _agentType;
	}

	public void setAgentType(String agentType) {
		_agentType = agentType;
	}

	public double getLimit() {
		return _limit;
	}

	public void setLimit(double limit) {
		_limit = limit;
	}

	public int getOverrideGracePeriod() {
		return _overrideGracePeriod;
	}

	public void setOverrideGracePeriod(int overrideGracePeriod) {
		_overrideGracePeriod = overrideGracePeriod;
	}

	public int getNettPremiAllowed() {
		return _nettPremiAllowed;
	}

	public void setNettPremiAllowed(int nettPremiAllowed) {
		_nettPremiAllowed = nettPremiAllowed;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _creditTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mypageUserId;
	private String _name;
	private String _agentType;
	private double _limit;
	private int _overrideGracePeriod;
	private int _nettPremiAllowed;
	private int _active;

}