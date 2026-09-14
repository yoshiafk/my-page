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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelDomesticBenefitServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelDomesticBenefitSoap implements Serializable {

	public static TravelDomesticBenefitSoap toSoapModel(
		TravelDomesticBenefit model) {

		TravelDomesticBenefitSoap soapModel = new TravelDomesticBenefitSoap();

		soapModel.setTravelDomesticBenefitId(
			model.getTravelDomesticBenefitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPlan(model.getPlan());
		soapModel.setAmount(model.getAmount());
		soapModel.setBenefit(model.getBenefit());
		soapModel.setBenefitValue(model.getBenefitValue());
		soapModel.setGroup(model.getGroup());
		soapModel.setSort(model.getSort());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static TravelDomesticBenefitSoap[] toSoapModels(
		TravelDomesticBenefit[] models) {

		TravelDomesticBenefitSoap[] soapModels =
			new TravelDomesticBenefitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticBenefitSoap[][] toSoapModels(
		TravelDomesticBenefit[][] models) {

		TravelDomesticBenefitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelDomesticBenefitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDomesticBenefitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticBenefitSoap[] toSoapModels(
		List<TravelDomesticBenefit> models) {

		List<TravelDomesticBenefitSoap> soapModels =
			new ArrayList<TravelDomesticBenefitSoap>(models.size());

		for (TravelDomesticBenefit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelDomesticBenefitSoap[soapModels.size()]);
	}

	public TravelDomesticBenefitSoap() {
	}

	public long getPrimaryKey() {
		return _travelDomesticBenefitId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDomesticBenefitId(pk);
	}

	public long getTravelDomesticBenefitId() {
		return _travelDomesticBenefitId;
	}

	public void setTravelDomesticBenefitId(long travelDomesticBenefitId) {
		_travelDomesticBenefitId = travelDomesticBenefitId;
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

	public String getPlan() {
		return _plan;
	}

	public void setPlan(String plan) {
		_plan = plan;
	}

	public String getAmount() {
		return _amount;
	}

	public void setAmount(String amount) {
		_amount = amount;
	}

	public String getBenefit() {
		return _benefit;
	}

	public void setBenefit(String benefit) {
		_benefit = benefit;
	}

	public Long getBenefitValue() {
		return _benefitValue;
	}

	public void setBenefitValue(Long benefitValue) {
		_benefitValue = benefitValue;
	}

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	public int getSort() {
		return _sort;
	}

	public void setSort(int sort) {
		_sort = sort;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _travelDomesticBenefitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _plan;
	private String _amount;
	private String _benefit;
	private Long _benefitValue;
	private String _group;
	private int _sort;
	private int _active;

}