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

package com.mypage.user.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.UserRegistrationJobExpServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserRegistrationJobExpSoap implements Serializable {

	public static UserRegistrationJobExpSoap toSoapModel(
		UserRegistrationJobExp model) {

		UserRegistrationJobExpSoap soapModel = new UserRegistrationJobExpSoap();

		soapModel.setUserRegistrationJobExpId(
			model.getUserRegistrationJobExpId());
		soapModel.setName(model.getName());
		soapModel.setYear(model.getYear());
		soapModel.setJobHead(model.getJobHead());
		soapModel.setJobPosition(model.getJobPosition());
		soapModel.setJobIncome(model.getJobIncome());
		soapModel.setOtherInsuranceCompany(model.getOtherInsuranceCompany());
		soapModel.setUserRegistrationId(model.getUserRegistrationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserRegistrationJobExpSoap[] toSoapModels(
		UserRegistrationJobExp[] models) {

		UserRegistrationJobExpSoap[] soapModels =
			new UserRegistrationJobExpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationJobExpSoap[][] toSoapModels(
		UserRegistrationJobExp[][] models) {

		UserRegistrationJobExpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserRegistrationJobExpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserRegistrationJobExpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationJobExpSoap[] toSoapModels(
		List<UserRegistrationJobExp> models) {

		List<UserRegistrationJobExpSoap> soapModels =
			new ArrayList<UserRegistrationJobExpSoap>(models.size());

		for (UserRegistrationJobExp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserRegistrationJobExpSoap[soapModels.size()]);
	}

	public UserRegistrationJobExpSoap() {
	}

	public long getPrimaryKey() {
		return _userRegistrationJobExpId;
	}

	public void setPrimaryKey(long pk) {
		setUserRegistrationJobExpId(pk);
	}

	public long getUserRegistrationJobExpId() {
		return _userRegistrationJobExpId;
	}

	public void setUserRegistrationJobExpId(long userRegistrationJobExpId) {
		_userRegistrationJobExpId = userRegistrationJobExpId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public String getJobHead() {
		return _jobHead;
	}

	public void setJobHead(String jobHead) {
		_jobHead = jobHead;
	}

	public String getJobPosition() {
		return _jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		_jobPosition = jobPosition;
	}

	public String getJobIncome() {
		return _jobIncome;
	}

	public void setJobIncome(String jobIncome) {
		_jobIncome = jobIncome;
	}

	public int getOtherInsuranceCompany() {
		return _otherInsuranceCompany;
	}

	public void setOtherInsuranceCompany(int otherInsuranceCompany) {
		_otherInsuranceCompany = otherInsuranceCompany;
	}

	public long getUserRegistrationId() {
		return _userRegistrationId;
	}

	public void setUserRegistrationId(long userRegistrationId) {
		_userRegistrationId = userRegistrationId;
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

	private long _userRegistrationJobExpId;
	private String _name;
	private int _year;
	private String _jobHead;
	private String _jobPosition;
	private String _jobIncome;
	private int _otherInsuranceCompany;
	private long _userRegistrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}