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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelIntBenefitValueServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelIntBenefitValueSoap implements Serializable {

	public static TravelIntBenefitValueSoap toSoapModel(
		TravelIntBenefitValue model) {

		TravelIntBenefitValueSoap soapModel = new TravelIntBenefitValueSoap();

		soapModel.setTravelIntBenefitValueId(
			model.getTravelIntBenefitValueId());
		soapModel.setTravelIntBenefitId(model.getTravelIntBenefitId());
		soapModel.setCurrencyName(model.getCurrencyName());
		soapModel.setPackageType(model.getPackageType());
		soapModel.setBenefitValue(model.getBenefitValue());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TravelIntBenefitValueSoap[] toSoapModels(
		TravelIntBenefitValue[] models) {

		TravelIntBenefitValueSoap[] soapModels =
			new TravelIntBenefitValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelIntBenefitValueSoap[][] toSoapModels(
		TravelIntBenefitValue[][] models) {

		TravelIntBenefitValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelIntBenefitValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TravelIntBenefitValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelIntBenefitValueSoap[] toSoapModels(
		List<TravelIntBenefitValue> models) {

		List<TravelIntBenefitValueSoap> soapModels =
			new ArrayList<TravelIntBenefitValueSoap>(models.size());

		for (TravelIntBenefitValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelIntBenefitValueSoap[soapModels.size()]);
	}

	public TravelIntBenefitValueSoap() {
	}

	public long getPrimaryKey() {
		return _travelIntBenefitValueId;
	}

	public void setPrimaryKey(long pk) {
		setTravelIntBenefitValueId(pk);
	}

	public long getTravelIntBenefitValueId() {
		return _travelIntBenefitValueId;
	}

	public void setTravelIntBenefitValueId(long travelIntBenefitValueId) {
		_travelIntBenefitValueId = travelIntBenefitValueId;
	}

	public long getTravelIntBenefitId() {
		return _travelIntBenefitId;
	}

	public void setTravelIntBenefitId(long travelIntBenefitId) {
		_travelIntBenefitId = travelIntBenefitId;
	}

	public String getCurrencyName() {
		return _currencyName;
	}

	public void setCurrencyName(String currencyName) {
		_currencyName = currencyName;
	}

	public String getPackageType() {
		return _packageType;
	}

	public void setPackageType(String packageType) {
		_packageType = packageType;
	}

	public String getBenefitValue() {
		return _benefitValue;
	}

	public void setBenefitValue(String benefitValue) {
		_benefitValue = benefitValue;
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

	private long _travelIntBenefitValueId;
	private long _travelIntBenefitId;
	private String _currencyName;
	private String _packageType;
	private String _benefitValue;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}