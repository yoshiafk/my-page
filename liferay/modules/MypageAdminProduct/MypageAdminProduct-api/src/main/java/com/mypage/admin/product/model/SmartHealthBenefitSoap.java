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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartHealthBenefitServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartHealthBenefitSoap implements Serializable {

	public static SmartHealthBenefitSoap toSoapModel(SmartHealthBenefit model) {
		SmartHealthBenefitSoap soapModel = new SmartHealthBenefitSoap();

		soapModel.setSmartHealthBenefitId(model.getSmartHealthBenefitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBenefitTitle(model.getBenefitTitle());
		soapModel.setBenefitContent(model.getBenefitContent());
		soapModel.setSmartHealthBenefitGroupId(
			model.getSmartHealthBenefitGroupId());
		soapModel.setSmartHealthPlanId(model.getSmartHealthPlanId());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static SmartHealthBenefitSoap[] toSoapModels(
		SmartHealthBenefit[] models) {

		SmartHealthBenefitSoap[] soapModels =
			new SmartHealthBenefitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthBenefitSoap[][] toSoapModels(
		SmartHealthBenefit[][] models) {

		SmartHealthBenefitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartHealthBenefitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartHealthBenefitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthBenefitSoap[] toSoapModels(
		List<SmartHealthBenefit> models) {

		List<SmartHealthBenefitSoap> soapModels =
			new ArrayList<SmartHealthBenefitSoap>(models.size());

		for (SmartHealthBenefit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmartHealthBenefitSoap[soapModels.size()]);
	}

	public SmartHealthBenefitSoap() {
	}

	public long getPrimaryKey() {
		return _smartHealthBenefitId;
	}

	public void setPrimaryKey(long pk) {
		setSmartHealthBenefitId(pk);
	}

	public long getSmartHealthBenefitId() {
		return _smartHealthBenefitId;
	}

	public void setSmartHealthBenefitId(long smartHealthBenefitId) {
		_smartHealthBenefitId = smartHealthBenefitId;
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

	public String getBenefitTitle() {
		return _benefitTitle;
	}

	public void setBenefitTitle(String benefitTitle) {
		_benefitTitle = benefitTitle;
	}

	public String getBenefitContent() {
		return _benefitContent;
	}

	public void setBenefitContent(String benefitContent) {
		_benefitContent = benefitContent;
	}

	public long getSmartHealthBenefitGroupId() {
		return _smartHealthBenefitGroupId;
	}

	public void setSmartHealthBenefitGroupId(long smartHealthBenefitGroupId) {
		_smartHealthBenefitGroupId = smartHealthBenefitGroupId;
	}

	public long getSmartHealthPlanId() {
		return _smartHealthPlanId;
	}

	public void setSmartHealthPlanId(long smartHealthPlanId) {
		_smartHealthPlanId = smartHealthPlanId;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _smartHealthBenefitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _benefitTitle;
	private String _benefitContent;
	private long _smartHealthBenefitGroupId;
	private long _smartHealthPlanId;
	private int _active;

}