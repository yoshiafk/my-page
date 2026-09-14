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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartHealthPlanServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartHealthPlanSoap implements Serializable {

	public static SmartHealthPlanSoap toSoapModel(SmartHealthPlan model) {
		SmartHealthPlanSoap soapModel = new SmartHealthPlanSoap();

		soapModel.setSmartHealthPlanId(model.getSmartHealthPlanId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPlanName(model.getPlanName());
		soapModel.setPlanGroup(model.getPlanGroup());
		soapModel.setIsRecommended(model.getIsRecommended());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static SmartHealthPlanSoap[] toSoapModels(SmartHealthPlan[] models) {
		SmartHealthPlanSoap[] soapModels =
			new SmartHealthPlanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthPlanSoap[][] toSoapModels(
		SmartHealthPlan[][] models) {

		SmartHealthPlanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartHealthPlanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartHealthPlanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthPlanSoap[] toSoapModels(
		List<SmartHealthPlan> models) {

		List<SmartHealthPlanSoap> soapModels =
			new ArrayList<SmartHealthPlanSoap>(models.size());

		for (SmartHealthPlan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SmartHealthPlanSoap[soapModels.size()]);
	}

	public SmartHealthPlanSoap() {
	}

	public long getPrimaryKey() {
		return _smartHealthPlanId;
	}

	public void setPrimaryKey(long pk) {
		setSmartHealthPlanId(pk);
	}

	public long getSmartHealthPlanId() {
		return _smartHealthPlanId;
	}

	public void setSmartHealthPlanId(long smartHealthPlanId) {
		_smartHealthPlanId = smartHealthPlanId;
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

	public String getPlanName() {
		return _planName;
	}

	public void setPlanName(String planName) {
		_planName = planName;
	}

	public String getPlanGroup() {
		return _planGroup;
	}

	public void setPlanGroup(String planGroup) {
		_planGroup = planGroup;
	}

	public Integer getIsRecommended() {
		return _isRecommended;
	}

	public void setIsRecommended(Integer isRecommended) {
		_isRecommended = isRecommended;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
		_active = active;
	}

	private long _smartHealthPlanId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _planName;
	private String _planGroup;
	private Integer _isRecommended;
	private Integer _active;

}