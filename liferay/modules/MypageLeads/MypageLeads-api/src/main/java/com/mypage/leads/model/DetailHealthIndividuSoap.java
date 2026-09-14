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
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.DetailHealthIndividuServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DetailHealthIndividuSoap implements Serializable {

	public static DetailHealthIndividuSoap toSoapModel(
		DetailHealthIndividu model) {

		DetailHealthIndividuSoap soapModel = new DetailHealthIndividuSoap();

		soapModel.setDetailHealthIndividuId(model.getDetailHealthIndividuId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setPlanId(model.getPlanId());
		soapModel.setPremiId(model.getPremiId());
		soapModel.setSameAddress(model.getSameAddress());
		soapModel.setCurrentAddress(model.getCurrentAddress());
		soapModel.setCurrentAddress2(model.getCurrentAddress2());
		soapModel.setCurrentZip(model.getCurrentZip());
		soapModel.setJobCat(model.getJobCat());
		soapModel.setJobType(model.getJobType());
		soapModel.setJob(model.getJob());
		soapModel.setJobPosition(model.getJobPosition());
		soapModel.setAccountBankNumber(model.getAccountBankNumber());
		soapModel.setAccountBankName(model.getAccountBankName());
		soapModel.setBankName(model.getBankName());
		soapModel.setHealthAgreement(model.getHealthAgreement());
		soapModel.setChildAgreement(model.getChildAgreement());

		return soapModel;
	}

	public static DetailHealthIndividuSoap[] toSoapModels(
		DetailHealthIndividu[] models) {

		DetailHealthIndividuSoap[] soapModels =
			new DetailHealthIndividuSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DetailHealthIndividuSoap[][] toSoapModels(
		DetailHealthIndividu[][] models) {

		DetailHealthIndividuSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DetailHealthIndividuSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DetailHealthIndividuSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DetailHealthIndividuSoap[] toSoapModels(
		List<DetailHealthIndividu> models) {

		List<DetailHealthIndividuSoap> soapModels =
			new ArrayList<DetailHealthIndividuSoap>(models.size());

		for (DetailHealthIndividu model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DetailHealthIndividuSoap[soapModels.size()]);
	}

	public DetailHealthIndividuSoap() {
	}

	public long getPrimaryKey() {
		return _detailHealthIndividuId;
	}

	public void setPrimaryKey(long pk) {
		setDetailHealthIndividuId(pk);
	}

	public long getDetailHealthIndividuId() {
		return _detailHealthIndividuId;
	}

	public void setDetailHealthIndividuId(long detailHealthIndividuId) {
		_detailHealthIndividuId = detailHealthIndividuId;
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

	public long getLeadsId() {
		return _LeadsId;
	}

	public void setLeadsId(long LeadsId) {
		_LeadsId = LeadsId;
	}

	public long getPlanId() {
		return _PlanId;
	}

	public void setPlanId(long PlanId) {
		_PlanId = PlanId;
	}

	public long getPremiId() {
		return _PremiId;
	}

	public void setPremiId(long PremiId) {
		_PremiId = PremiId;
	}

	public Integer getSameAddress() {
		return _SameAddress;
	}

	public void setSameAddress(Integer SameAddress) {
		_SameAddress = SameAddress;
	}

	public String getCurrentAddress() {
		return _CurrentAddress;
	}

	public void setCurrentAddress(String CurrentAddress) {
		_CurrentAddress = CurrentAddress;
	}

	public String getCurrentAddress2() {
		return _CurrentAddress2;
	}

	public void setCurrentAddress2(String CurrentAddress2) {
		_CurrentAddress2 = CurrentAddress2;
	}

	public String getCurrentZip() {
		return _CurrentZip;
	}

	public void setCurrentZip(String CurrentZip) {
		_CurrentZip = CurrentZip;
	}

	public String getJobCat() {
		return _JobCat;
	}

	public void setJobCat(String JobCat) {
		_JobCat = JobCat;
	}

	public String getJobType() {
		return _JobType;
	}

	public void setJobType(String JobType) {
		_JobType = JobType;
	}

	public String getJob() {
		return _Job;
	}

	public void setJob(String Job) {
		_Job = Job;
	}

	public String getJobPosition() {
		return _JobPosition;
	}

	public void setJobPosition(String JobPosition) {
		_JobPosition = JobPosition;
	}

	public String getAccountBankNumber() {
		return _AccountBankNumber;
	}

	public void setAccountBankNumber(String AccountBankNumber) {
		_AccountBankNumber = AccountBankNumber;
	}

	public String getAccountBankName() {
		return _AccountBankName;
	}

	public void setAccountBankName(String AccountBankName) {
		_AccountBankName = AccountBankName;
	}

	public String getBankName() {
		return _BankName;
	}

	public void setBankName(String BankName) {
		_BankName = BankName;
	}

	public Integer getHealthAgreement() {
		return _HealthAgreement;
	}

	public void setHealthAgreement(Integer HealthAgreement) {
		_HealthAgreement = HealthAgreement;
	}

	public Integer getChildAgreement() {
		return _ChildAgreement;
	}

	public void setChildAgreement(Integer ChildAgreement) {
		_ChildAgreement = ChildAgreement;
	}

	private long _detailHealthIndividuId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _LeadsId;
	private long _PlanId;
	private long _PremiId;
	private Integer _SameAddress;
	private String _CurrentAddress;
	private String _CurrentAddress2;
	private String _CurrentZip;
	private String _JobCat;
	private String _JobType;
	private String _Job;
	private String _JobPosition;
	private String _AccountBankNumber;
	private String _AccountBankName;
	private String _BankName;
	private Integer _HealthAgreement;
	private Integer _ChildAgreement;

}