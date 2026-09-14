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

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelInternationalPremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelInternationalPremiSoap implements Serializable {

	public static TravelInternationalPremiSoap toSoapModel(
		TravelInternationalPremi model) {

		TravelInternationalPremiSoap soapModel =
			new TravelInternationalPremiSoap();

		soapModel.setPremiId(model.getPremiId());
		soapModel.setPackageType(model.getPackageType());
		soapModel.setPeopleType(model.getPeopleType());
		soapModel.setAdultCount(model.getAdultCount());
		soapModel.setChildrenCount(model.getChildrenCount());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setAmount(model.getAmount());
		soapModel.setMinDuration(model.getMinDuration());
		soapModel.setMaxDuration(model.getMaxDuration());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static TravelInternationalPremiSoap[] toSoapModels(
		TravelInternationalPremi[] models) {

		TravelInternationalPremiSoap[] soapModels =
			new TravelInternationalPremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelInternationalPremiSoap[][] toSoapModels(
		TravelInternationalPremi[][] models) {

		TravelInternationalPremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelInternationalPremiSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new TravelInternationalPremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelInternationalPremiSoap[] toSoapModels(
		List<TravelInternationalPremi> models) {

		List<TravelInternationalPremiSoap> soapModels =
			new ArrayList<TravelInternationalPremiSoap>(models.size());

		for (TravelInternationalPremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelInternationalPremiSoap[soapModels.size()]);
	}

	public TravelInternationalPremiSoap() {
	}

	public long getPrimaryKey() {
		return _premiId;
	}

	public void setPrimaryKey(long pk) {
		setPremiId(pk);
	}

	public long getPremiId() {
		return _premiId;
	}

	public void setPremiId(long premiId) {
		_premiId = premiId;
	}

	public String getPackageType() {
		return _packageType;
	}

	public void setPackageType(String packageType) {
		_packageType = packageType;
	}

	public String getPeopleType() {
		return _peopleType;
	}

	public void setPeopleType(String peopleType) {
		_peopleType = peopleType;
	}

	public int getAdultCount() {
		return _adultCount;
	}

	public void setAdultCount(int adultCount) {
		_adultCount = adultCount;
	}

	public int getChildrenCount() {
		return _childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		_childrenCount = childrenCount;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public BigDecimal getAmount() {
		return _amount;
	}

	public void setAmount(BigDecimal amount) {
		_amount = amount;
	}

	public int getMinDuration() {
		return _minDuration;
	}

	public void setMinDuration(int minDuration) {
		_minDuration = minDuration;
	}

	public int getMaxDuration() {
		return _maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		_maxDuration = maxDuration;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _premiId;
	private String _packageType;
	private String _peopleType;
	private int _adultCount;
	private int _childrenCount;
	private String _currency;
	private BigDecimal _amount;
	private int _minDuration;
	private int _maxDuration;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}