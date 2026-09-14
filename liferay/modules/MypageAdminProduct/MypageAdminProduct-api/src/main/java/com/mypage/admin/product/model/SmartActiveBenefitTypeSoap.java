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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartActiveBenefitTypeServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartActiveBenefitTypeSoap implements Serializable {

	public static SmartActiveBenefitTypeSoap toSoapModel(
		SmartActiveBenefitType model) {

		SmartActiveBenefitTypeSoap soapModel = new SmartActiveBenefitTypeSoap();

		soapModel.setSmartActiveBenefitTypeId(
			model.getSmartActiveBenefitTypeId());
		soapModel.setNameId(model.getNameId());
		soapModel.setNameEn(model.getNameEn());
		soapModel.setSort(model.getSort());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartActiveBenefitTypeSoap[] toSoapModels(
		SmartActiveBenefitType[] models) {

		SmartActiveBenefitTypeSoap[] soapModels =
			new SmartActiveBenefitTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveBenefitTypeSoap[][] toSoapModels(
		SmartActiveBenefitType[][] models) {

		SmartActiveBenefitTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartActiveBenefitTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartActiveBenefitTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveBenefitTypeSoap[] toSoapModels(
		List<SmartActiveBenefitType> models) {

		List<SmartActiveBenefitTypeSoap> soapModels =
			new ArrayList<SmartActiveBenefitTypeSoap>(models.size());

		for (SmartActiveBenefitType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmartActiveBenefitTypeSoap[soapModels.size()]);
	}

	public SmartActiveBenefitTypeSoap() {
	}

	public long getPrimaryKey() {
		return _smartActiveBenefitTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSmartActiveBenefitTypeId(pk);
	}

	public long getSmartActiveBenefitTypeId() {
		return _smartActiveBenefitTypeId;
	}

	public void setSmartActiveBenefitTypeId(long smartActiveBenefitTypeId) {
		_smartActiveBenefitTypeId = smartActiveBenefitTypeId;
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

	private long _smartActiveBenefitTypeId;
	private String _nameId;
	private String _nameEn;
	private int _sort;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}