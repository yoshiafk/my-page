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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelIntBenefitServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelIntBenefitSoap implements Serializable {

	public static TravelIntBenefitSoap toSoapModel(TravelIntBenefit model) {
		TravelIntBenefitSoap soapModel = new TravelIntBenefitSoap();

		soapModel.setTravelIntBenefitId(model.getTravelIntBenefitId());
		soapModel.setBenefitName(model.getBenefitName());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TravelIntBenefitSoap[] toSoapModels(
		TravelIntBenefit[] models) {

		TravelIntBenefitSoap[] soapModels =
			new TravelIntBenefitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelIntBenefitSoap[][] toSoapModels(
		TravelIntBenefit[][] models) {

		TravelIntBenefitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelIntBenefitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TravelIntBenefitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelIntBenefitSoap[] toSoapModels(
		List<TravelIntBenefit> models) {

		List<TravelIntBenefitSoap> soapModels =
			new ArrayList<TravelIntBenefitSoap>(models.size());

		for (TravelIntBenefit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TravelIntBenefitSoap[soapModels.size()]);
	}

	public TravelIntBenefitSoap() {
	}

	public long getPrimaryKey() {
		return _travelIntBenefitId;
	}

	public void setPrimaryKey(long pk) {
		setTravelIntBenefitId(pk);
	}

	public long getTravelIntBenefitId() {
		return _travelIntBenefitId;
	}

	public void setTravelIntBenefitId(long travelIntBenefitId) {
		_travelIntBenefitId = travelIntBenefitId;
	}

	public String getBenefitName() {
		return _benefitName;
	}

	public void setBenefitName(String benefitName) {
		_benefitName = benefitName;
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

	private long _travelIntBenefitId;
	private String _benefitName;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}