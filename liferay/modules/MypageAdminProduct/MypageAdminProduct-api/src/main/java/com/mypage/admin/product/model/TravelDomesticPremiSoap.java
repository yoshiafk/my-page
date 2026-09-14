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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelDomesticPremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelDomesticPremiSoap implements Serializable {

	public static TravelDomesticPremiSoap toSoapModel(
		TravelDomesticPremi model) {

		TravelDomesticPremiSoap soapModel = new TravelDomesticPremiSoap();

		soapModel.setTravelDomesticPremiId(model.getTravelDomesticPremiId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDuration(model.getDuration());
		soapModel.setPlan(model.getPlan());
		soapModel.setInsuredType(model.getInsuredType());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setAmount(model.getAmount());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static TravelDomesticPremiSoap[] toSoapModels(
		TravelDomesticPremi[] models) {

		TravelDomesticPremiSoap[] soapModels =
			new TravelDomesticPremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticPremiSoap[][] toSoapModels(
		TravelDomesticPremi[][] models) {

		TravelDomesticPremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelDomesticPremiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDomesticPremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticPremiSoap[] toSoapModels(
		List<TravelDomesticPremi> models) {

		List<TravelDomesticPremiSoap> soapModels =
			new ArrayList<TravelDomesticPremiSoap>(models.size());

		for (TravelDomesticPremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelDomesticPremiSoap[soapModels.size()]);
	}

	public TravelDomesticPremiSoap() {
	}

	public long getPrimaryKey() {
		return _travelDomesticPremiId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDomesticPremiId(pk);
	}

	public long getTravelDomesticPremiId() {
		return _travelDomesticPremiId;
	}

	public void setTravelDomesticPremiId(long travelDomesticPremiId) {
		_travelDomesticPremiId = travelDomesticPremiId;
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

	public int getDuration() {
		return _duration;
	}

	public void setDuration(int duration) {
		_duration = duration;
	}

	public String getPlan() {
		return _plan;
	}

	public void setPlan(String plan) {
		_plan = plan;
	}

	public String getInsuredType() {
		return _insuredType;
	}

	public void setInsuredType(String insuredType) {
		_insuredType = insuredType;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public Long getAmount() {
		return _amount;
	}

	public void setAmount(Long amount) {
		_amount = amount;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _travelDomesticPremiId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _duration;
	private String _plan;
	private String _insuredType;
	private String _currency;
	private Long _amount;
	private int _active;

}