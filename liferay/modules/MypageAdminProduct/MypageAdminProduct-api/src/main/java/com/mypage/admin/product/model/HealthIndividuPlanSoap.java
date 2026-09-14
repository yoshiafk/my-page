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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.HealthIndividuPlanServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HealthIndividuPlanSoap implements Serializable {

	public static HealthIndividuPlanSoap toSoapModel(HealthIndividuPlan model) {
		HealthIndividuPlanSoap soapModel = new HealthIndividuPlanSoap();

		soapModel.setHealthIndividuPlanId(model.getHealthIndividuPlanId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setLimitYear(model.getLimitYear());
		soapModel.setLimitDisability(model.getLimitDisability());
		soapModel.setInpatient(model.getInpatient());
		soapModel.setOutpatient(model.getOutpatient());
		soapModel.setAmbulanceService(model.getAmbulanceService());
		soapModel.setPersonalAccident(model.getPersonalAccident());
		soapModel.setDetail(model.getDetail());
		soapModel.setBenefit(model.getBenefit());
		soapModel.setBenefitIcon(model.getBenefitIcon());
		soapModel.setRecommended(model.getRecommended());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static HealthIndividuPlanSoap[] toSoapModels(
		HealthIndividuPlan[] models) {

		HealthIndividuPlanSoap[] soapModels =
			new HealthIndividuPlanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HealthIndividuPlanSoap[][] toSoapModels(
		HealthIndividuPlan[][] models) {

		HealthIndividuPlanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new HealthIndividuPlanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HealthIndividuPlanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HealthIndividuPlanSoap[] toSoapModels(
		List<HealthIndividuPlan> models) {

		List<HealthIndividuPlanSoap> soapModels =
			new ArrayList<HealthIndividuPlanSoap>(models.size());

		for (HealthIndividuPlan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new HealthIndividuPlanSoap[soapModels.size()]);
	}

	public HealthIndividuPlanSoap() {
	}

	public long getPrimaryKey() {
		return _healthIndividuPlanId;
	}

	public void setPrimaryKey(long pk) {
		setHealthIndividuPlanId(pk);
	}

	public long getHealthIndividuPlanId() {
		return _healthIndividuPlanId;
	}

	public void setHealthIndividuPlanId(long healthIndividuPlanId) {
		_healthIndividuPlanId = healthIndividuPlanId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getLimitYear() {
		return _limitYear;
	}

	public void setLimitYear(long limitYear) {
		_limitYear = limitYear;
	}

	public long getLimitDisability() {
		return _limitDisability;
	}

	public void setLimitDisability(long limitDisability) {
		_limitDisability = limitDisability;
	}

	public long getInpatient() {
		return _inpatient;
	}

	public void setInpatient(long inpatient) {
		_inpatient = inpatient;
	}

	public long getOutpatient() {
		return _outpatient;
	}

	public void setOutpatient(long outpatient) {
		_outpatient = outpatient;
	}

	public long getAmbulanceService() {
		return _ambulanceService;
	}

	public void setAmbulanceService(long ambulanceService) {
		_ambulanceService = ambulanceService;
	}

	public long getPersonalAccident() {
		return _personalAccident;
	}

	public void setPersonalAccident(long personalAccident) {
		_personalAccident = personalAccident;
	}

	public String getDetail() {
		return _detail;
	}

	public void setDetail(String detail) {
		_detail = detail;
	}

	public String getBenefit() {
		return _benefit;
	}

	public void setBenefit(String benefit) {
		_benefit = benefit;
	}

	public String getBenefitIcon() {
		return _benefitIcon;
	}

	public void setBenefitIcon(String benefitIcon) {
		_benefitIcon = benefitIcon;
	}

	public int getRecommended() {
		return _recommended;
	}

	public void setRecommended(int recommended) {
		_recommended = recommended;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _healthIndividuPlanId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _limitYear;
	private long _limitDisability;
	private long _inpatient;
	private long _outpatient;
	private long _ambulanceService;
	private long _personalAccident;
	private String _detail;
	private String _benefit;
	private String _benefitIcon;
	private int _recommended;
	private int _active;

}