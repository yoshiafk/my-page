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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.IntTravelStandardNewPremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class IntTravelStandardNewPremiSoap implements Serializable {

	public static IntTravelStandardNewPremiSoap toSoapModel(
		IntTravelStandardNewPremi model) {

		IntTravelStandardNewPremiSoap soapModel =
			new IntTravelStandardNewPremiSoap();

		soapModel.setIntTravelStandardNewPremiId(
			model.getIntTravelStandardNewPremiId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTravelType(model.getTravelType());
		soapModel.setPackageType(model.getPackageType());
		soapModel.setPeopleType(model.getPeopleType());
		soapModel.setMainInsured(model.getMainInsured());
		soapModel.setSpouse(model.getSpouse());
		soapModel.setChild(model.getChild());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setAmount(model.getAmount());
		soapModel.setAdditionalPrice(model.getAdditionalPrice());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static IntTravelStandardNewPremiSoap[] toSoapModels(
		IntTravelStandardNewPremi[] models) {

		IntTravelStandardNewPremiSoap[] soapModels =
			new IntTravelStandardNewPremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IntTravelStandardNewPremiSoap[][] toSoapModels(
		IntTravelStandardNewPremi[][] models) {

		IntTravelStandardNewPremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new IntTravelStandardNewPremiSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new IntTravelStandardNewPremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IntTravelStandardNewPremiSoap[] toSoapModels(
		List<IntTravelStandardNewPremi> models) {

		List<IntTravelStandardNewPremiSoap> soapModels =
			new ArrayList<IntTravelStandardNewPremiSoap>(models.size());

		for (IntTravelStandardNewPremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new IntTravelStandardNewPremiSoap[soapModels.size()]);
	}

	public IntTravelStandardNewPremiSoap() {
	}

	public long getPrimaryKey() {
		return _intTravelStandardNewPremiId;
	}

	public void setPrimaryKey(long pk) {
		setIntTravelStandardNewPremiId(pk);
	}

	public long getIntTravelStandardNewPremiId() {
		return _intTravelStandardNewPremiId;
	}

	public void setIntTravelStandardNewPremiId(
		long intTravelStandardNewPremiId) {

		_intTravelStandardNewPremiId = intTravelStandardNewPremiId;
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

	public String getTravelType() {
		return _travelType;
	}

	public void setTravelType(String travelType) {
		_travelType = travelType;
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

	public int getMainInsured() {
		return _mainInsured;
	}

	public void setMainInsured(int mainInsured) {
		_mainInsured = mainInsured;
	}

	public int getSpouse() {
		return _spouse;
	}

	public void setSpouse(int spouse) {
		_spouse = spouse;
	}

	public int getChild() {
		return _child;
	}

	public void setChild(int child) {
		_child = child;
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

	public BigDecimal getAdditionalPrice() {
		return _additionalPrice;
	}

	public void setAdditionalPrice(BigDecimal additionalPrice) {
		_additionalPrice = additionalPrice;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _intTravelStandardNewPremiId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _travelType;
	private String _packageType;
	private String _peopleType;
	private int _mainInsured;
	private int _spouse;
	private int _child;
	private String _currency;
	private BigDecimal _amount;
	private BigDecimal _additionalPrice;
	private int _active;

}