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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.StiPremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StiPremiSoap implements Serializable {

	public static StiPremiSoap toSoapModel(StiPremi model) {
		StiPremiSoap soapModel = new StiPremiSoap();

		soapModel.setPremiId(model.getPremiId());
		soapModel.setTravellerType(model.getTravellerType());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setBasic(model.getBasic());
		soapModel.setAdditional(model.getAdditional());
		soapModel.setAnnual(model.getAnnual());
		soapModel.setActive(model.getActive());
		soapModel.setBenefitId(model.getBenefitId());
		soapModel.setPlanId(model.getPlanId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static StiPremiSoap[] toSoapModels(StiPremi[] models) {
		StiPremiSoap[] soapModels = new StiPremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StiPremiSoap[][] toSoapModels(StiPremi[][] models) {
		StiPremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StiPremiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StiPremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StiPremiSoap[] toSoapModels(List<StiPremi> models) {
		List<StiPremiSoap> soapModels = new ArrayList<StiPremiSoap>(
			models.size());

		for (StiPremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StiPremiSoap[soapModels.size()]);
	}

	public StiPremiSoap() {
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

	public String getTravellerType() {
		return _travellerType;
	}

	public void setTravellerType(String travellerType) {
		_travellerType = travellerType;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public BigDecimal getBasic() {
		return _basic;
	}

	public void setBasic(BigDecimal basic) {
		_basic = basic;
	}

	public BigDecimal getAdditional() {
		return _additional;
	}

	public void setAdditional(BigDecimal additional) {
		_additional = additional;
	}

	public BigDecimal getAnnual() {
		return _annual;
	}

	public void setAnnual(BigDecimal annual) {
		_annual = annual;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	public long getBenefitId() {
		return _benefitId;
	}

	public void setBenefitId(long benefitId) {
		_benefitId = benefitId;
	}

	public long getPlanId() {
		return _planId;
	}

	public void setPlanId(long planId) {
		_planId = planId;
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

	private long _premiId;
	private String _travellerType;
	private String _currency;
	private BigDecimal _basic;
	private BigDecimal _additional;
	private BigDecimal _annual;
	private int _active;
	private long _benefitId;
	private long _planId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}