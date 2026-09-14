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

package com.mypage.leads.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.DetailSmartactiveServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DetailSmartactiveSoap implements Serializable {

	public static DetailSmartactiveSoap toSoapModel(DetailSmartactive model) {
		DetailSmartactiveSoap soapModel = new DetailSmartactiveSoap();

		soapModel.setDetailId(model.getDetailId());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setExcludedActivityStatus(model.getExcludedActivityStatus());
		soapModel.setJobType(model.getJobType());
		soapModel.setMainBenefitValue(model.getMainBenefitValue());
		soapModel.setStartPeriode(model.getStartPeriode());
		soapModel.setEndPeriode(model.getEndPeriode());
		soapModel.setListBenefitId(model.getListBenefitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static DetailSmartactiveSoap[] toSoapModels(
		DetailSmartactive[] models) {

		DetailSmartactiveSoap[] soapModels =
			new DetailSmartactiveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DetailSmartactiveSoap[][] toSoapModels(
		DetailSmartactive[][] models) {

		DetailSmartactiveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DetailSmartactiveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DetailSmartactiveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DetailSmartactiveSoap[] toSoapModels(
		List<DetailSmartactive> models) {

		List<DetailSmartactiveSoap> soapModels =
			new ArrayList<DetailSmartactiveSoap>(models.size());

		for (DetailSmartactive model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DetailSmartactiveSoap[soapModels.size()]);
	}

	public DetailSmartactiveSoap() {
	}

	public long getPrimaryKey() {
		return _DetailId;
	}

	public void setPrimaryKey(long pk) {
		setDetailId(pk);
	}

	public long getDetailId() {
		return _DetailId;
	}

	public void setDetailId(long DetailId) {
		_DetailId = DetailId;
	}

	public long getLeadsId() {
		return _LeadsId;
	}

	public void setLeadsId(long LeadsId) {
		_LeadsId = LeadsId;
	}

	public int getExcludedActivityStatus() {
		return _ExcludedActivityStatus;
	}

	public void setExcludedActivityStatus(int ExcludedActivityStatus) {
		_ExcludedActivityStatus = ExcludedActivityStatus;
	}

	public long getJobType() {
		return _JobType;
	}

	public void setJobType(long JobType) {
		_JobType = JobType;
	}

	public String getMainBenefitValue() {
		return _MainBenefitValue;
	}

	public void setMainBenefitValue(String MainBenefitValue) {
		_MainBenefitValue = MainBenefitValue;
	}

	public Date getStartPeriode() {
		return _StartPeriode;
	}

	public void setStartPeriode(Date StartPeriode) {
		_StartPeriode = StartPeriode;
	}

	public Date getEndPeriode() {
		return _EndPeriode;
	}

	public void setEndPeriode(Date EndPeriode) {
		_EndPeriode = EndPeriode;
	}

	public String getListBenefitId() {
		return _ListBenefitId;
	}

	public void setListBenefitId(String ListBenefitId) {
		_ListBenefitId = ListBenefitId;
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

	private long _DetailId;
	private long _LeadsId;
	private int _ExcludedActivityStatus;
	private long _JobType;
	private String _MainBenefitValue;
	private Date _StartPeriode;
	private Date _EndPeriode;
	private String _ListBenefitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}