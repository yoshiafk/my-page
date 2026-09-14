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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.UserRegistrationReferenceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserRegistrationReferenceSoap implements Serializable {

	public static UserRegistrationReferenceSoap toSoapModel(
		UserRegistrationReference model) {

		UserRegistrationReferenceSoap soapModel =
			new UserRegistrationReferenceSoap();

		soapModel.setUserRegistrationReferenceId(
			model.getUserRegistrationReferenceId());
		soapModel.setName(model.getName());
		soapModel.setRelation(model.getRelation());
		soapModel.setAge(model.getAge());
		soapModel.setAddress(model.getAddress());
		soapModel.setPhone(model.getPhone());
		soapModel.setJob(model.getJob());
		soapModel.setYear(model.getYear());
		soapModel.setUserRegistrationId(model.getUserRegistrationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserRegistrationReferenceSoap[] toSoapModels(
		UserRegistrationReference[] models) {

		UserRegistrationReferenceSoap[] soapModels =
			new UserRegistrationReferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationReferenceSoap[][] toSoapModels(
		UserRegistrationReference[][] models) {

		UserRegistrationReferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserRegistrationReferenceSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new UserRegistrationReferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationReferenceSoap[] toSoapModels(
		List<UserRegistrationReference> models) {

		List<UserRegistrationReferenceSoap> soapModels =
			new ArrayList<UserRegistrationReferenceSoap>(models.size());

		for (UserRegistrationReference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserRegistrationReferenceSoap[soapModels.size()]);
	}

	public UserRegistrationReferenceSoap() {
	}

	public long getPrimaryKey() {
		return _userRegistrationReferenceId;
	}

	public void setPrimaryKey(long pk) {
		setUserRegistrationReferenceId(pk);
	}

	public long getUserRegistrationReferenceId() {
		return _userRegistrationReferenceId;
	}

	public void setUserRegistrationReferenceId(
		long userRegistrationReferenceId) {

		_userRegistrationReferenceId = userRegistrationReferenceId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getRelation() {
		return _relation;
	}

	public void setRelation(String relation) {
		_relation = relation;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getJob() {
		return _job;
	}

	public void setJob(String job) {
		_job = job;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
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

	private long _userRegistrationReferenceId;
	private String _name;
	private String _relation;
	private int _age;
	private String _address;
	private String _phone;
	private String _job;
	private int _year;
	private long _userRegistrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}