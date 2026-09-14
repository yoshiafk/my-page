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

package com.mypage.admin.product.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartActivePremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartActivePremiSoap implements Serializable {

	public static SmartActivePremiSoap toSoapModel(SmartActivePremi model) {
		SmartActivePremiSoap soapModel = new SmartActivePremiSoap();

		soapModel.setSmartActivePremiId(model.getSmartActivePremiId());
		soapModel.setRate(model.getRate());
		soapModel.setActive(model.getActive());
		soapModel.setSmartActiveClassRateId(model.getSmartActiveClassRateId());
		soapModel.setSmartActiveBenefitId(model.getSmartActiveBenefitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartActivePremiSoap[] toSoapModels(
		SmartActivePremi[] models) {

		SmartActivePremiSoap[] soapModels =
			new SmartActivePremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartActivePremiSoap[][] toSoapModels(
		SmartActivePremi[][] models) {

		SmartActivePremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartActivePremiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartActivePremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartActivePremiSoap[] toSoapModels(
		List<SmartActivePremi> models) {

		List<SmartActivePremiSoap> soapModels =
			new ArrayList<SmartActivePremiSoap>(models.size());

		for (SmartActivePremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SmartActivePremiSoap[soapModels.size()]);
	}

	public SmartActivePremiSoap() {
	}

	public long getPrimaryKey() {
		return _smartActivePremiId;
	}

	public void setPrimaryKey(long pk) {
		setSmartActivePremiId(pk);
	}

	public long getSmartActivePremiId() {
		return _smartActivePremiId;
	}

	public void setSmartActivePremiId(long smartActivePremiId) {
		_smartActivePremiId = smartActivePremiId;
	}

	public double getRate() {
		return _rate;
	}

	public void setRate(double rate) {
		_rate = rate;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	public long getSmartActiveClassRateId() {
		return _smartActiveClassRateId;
	}

	public void setSmartActiveClassRateId(long smartActiveClassRateId) {
		_smartActiveClassRateId = smartActiveClassRateId;
	}

	public long getSmartActiveBenefitId() {
		return _smartActiveBenefitId;
	}

	public void setSmartActiveBenefitId(long smartActiveBenefitId) {
		_smartActiveBenefitId = smartActiveBenefitId;
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

	private long _smartActivePremiId;
	private double _rate;
	private int _active;
	private long _smartActiveClassRateId;
	private long _smartActiveBenefitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}