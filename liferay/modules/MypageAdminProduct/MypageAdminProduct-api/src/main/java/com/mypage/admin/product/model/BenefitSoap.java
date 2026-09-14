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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.BenefitServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BenefitSoap implements Serializable {

	public static BenefitSoap toSoapModel(Benefit model) {
		BenefitSoap soapModel = new BenefitSoap();

		soapModel.setBenefitId(model.getBenefitId());
		soapModel.setNameId(model.getNameId());
		soapModel.setNameEn(model.getNameEn());
		soapModel.setSort(model.getSort());
		soapModel.setBenefitTypeId(model.getBenefitTypeId());
		soapModel.setActive(model.getActive());
		soapModel.setPlanName(model.getPlanName());
		soapModel.setBenefitValue(model.getBenefitValue());
		soapModel.setExternalCode(model.getExternalCode());
		soapModel.setBenefitDescription(model.getBenefitDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BenefitSoap[] toSoapModels(Benefit[] models) {
		BenefitSoap[] soapModels = new BenefitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BenefitSoap[][] toSoapModels(Benefit[][] models) {
		BenefitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BenefitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BenefitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BenefitSoap[] toSoapModels(List<Benefit> models) {
		List<BenefitSoap> soapModels = new ArrayList<BenefitSoap>(
			models.size());

		for (Benefit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BenefitSoap[soapModels.size()]);
	}

	public BenefitSoap() {
	}

	public long getPrimaryKey() {
		return _benefitId;
	}

	public void setPrimaryKey(long pk) {
		setBenefitId(pk);
	}

	public long getBenefitId() {
		return _benefitId;
	}

	public void setBenefitId(long benefitId) {
		_benefitId = benefitId;
	}

	public String getNameId() {
		return _nameId;
	}

	public void setNameId(String nameId) {
		_nameId = nameId;
	}

	public String getNameEn() {
		return _nameEn;
	}

	public void setNameEn(String nameEn) {
		_nameEn = nameEn;
	}

	public int getSort() {
		return _sort;
	}

	public void setSort(int sort) {
		_sort = sort;
	}

	public long getBenefitTypeId() {
		return _benefitTypeId;
	}

	public void setBenefitTypeId(long benefitTypeId) {
		_benefitTypeId = benefitTypeId;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	public String getPlanName() {
		return _planName;
	}

	public void setPlanName(String planName) {
		_planName = planName;
	}

	public String getBenefitValue() {
		return _benefitValue;
	}

	public void setBenefitValue(String benefitValue) {
		_benefitValue = benefitValue;
	}

	public String getExternalCode() {
		return _externalCode;
	}

	public void setExternalCode(String externalCode) {
		_externalCode = externalCode;
	}

	public String getBenefitDescription() {
		return _benefitDescription;
	}

	public void setBenefitDescription(String benefitDescription) {
		_benefitDescription = benefitDescription;
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

	private long _benefitId;
	private String _nameId;
	private String _nameEn;
	private int _sort;
	private long _benefitTypeId;
	private int _active;
	private String _planName;
	private String _benefitValue;
	private String _externalCode;
	private String _benefitDescription;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}