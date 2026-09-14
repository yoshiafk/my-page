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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.StiBenefitValueMappingServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StiBenefitValueMappingSoap implements Serializable {

	public static StiBenefitValueMappingSoap toSoapModel(
		StiBenefitValueMapping model) {

		StiBenefitValueMappingSoap soapModel = new StiBenefitValueMappingSoap();

		soapModel.setBenefitValueMappingId(model.getBenefitValueMappingId());
		soapModel.setBenefitTypeId(model.getBenefitTypeId());
		soapModel.setBenefitId(model.getBenefitId());
		soapModel.setPlanId(model.getPlanId());
		soapModel.setBenefitValue(model.getBenefitValue());
		soapModel.setBenefitValueUSD(model.getBenefitValueUSD());
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

	public static StiBenefitValueMappingSoap[] toSoapModels(
		StiBenefitValueMapping[] models) {

		StiBenefitValueMappingSoap[] soapModels =
			new StiBenefitValueMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StiBenefitValueMappingSoap[][] toSoapModels(
		StiBenefitValueMapping[][] models) {

		StiBenefitValueMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StiBenefitValueMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StiBenefitValueMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StiBenefitValueMappingSoap[] toSoapModels(
		List<StiBenefitValueMapping> models) {

		List<StiBenefitValueMappingSoap> soapModels =
			new ArrayList<StiBenefitValueMappingSoap>(models.size());

		for (StiBenefitValueMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StiBenefitValueMappingSoap[soapModels.size()]);
	}

	public StiBenefitValueMappingSoap() {
	}

	public long getPrimaryKey() {
		return _benefitValueMappingId;
	}

	public void setPrimaryKey(long pk) {
		setBenefitValueMappingId(pk);
	}

	public long getBenefitValueMappingId() {
		return _benefitValueMappingId;
	}

	public void setBenefitValueMappingId(long benefitValueMappingId) {
		_benefitValueMappingId = benefitValueMappingId;
	}

	public long getBenefitTypeId() {
		return _benefitTypeId;
	}

	public void setBenefitTypeId(long benefitTypeId) {
		_benefitTypeId = benefitTypeId;
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

	public String getBenefitValue() {
		return _benefitValue;
	}

	public void setBenefitValue(String benefitValue) {
		_benefitValue = benefitValue;
	}

	public String getBenefitValueUSD() {
		return _benefitValueUSD;
	}

	public void setBenefitValueUSD(String benefitValueUSD) {
		_benefitValueUSD = benefitValueUSD;
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

	private long _benefitValueMappingId;
	private long _benefitTypeId;
	private long _benefitId;
	private long _planId;
	private String _benefitValue;
	private String _benefitValueUSD;
	private int _sort;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}