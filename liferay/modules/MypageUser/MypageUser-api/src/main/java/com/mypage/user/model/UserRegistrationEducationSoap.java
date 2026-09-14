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
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.UserRegistrationEducationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserRegistrationEducationSoap implements Serializable {

	public static UserRegistrationEducationSoap toSoapModel(
		UserRegistrationEducation model) {

		UserRegistrationEducationSoap soapModel =
			new UserRegistrationEducationSoap();

		soapModel.setUserRegistrationEducationId(
			model.getUserRegistrationEducationId());
		soapModel.setName(model.getName());
		soapModel.setYear(model.getYear());
		soapModel.setGraduate(model.getGraduate());
		soapModel.setCourseType(model.getCourseType());
		soapModel.setTitle(model.getTitle());
		soapModel.setEduType(model.getEduType());
		soapModel.setUserRegistrationId(model.getUserRegistrationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserRegistrationEducationSoap[] toSoapModels(
		UserRegistrationEducation[] models) {

		UserRegistrationEducationSoap[] soapModels =
			new UserRegistrationEducationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationEducationSoap[][] toSoapModels(
		UserRegistrationEducation[][] models) {

		UserRegistrationEducationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserRegistrationEducationSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new UserRegistrationEducationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationEducationSoap[] toSoapModels(
		List<UserRegistrationEducation> models) {

		List<UserRegistrationEducationSoap> soapModels =
			new ArrayList<UserRegistrationEducationSoap>(models.size());

		for (UserRegistrationEducation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserRegistrationEducationSoap[soapModels.size()]);
	}

	public UserRegistrationEducationSoap() {
	}

	public long getPrimaryKey() {
		return _userRegistrationEducationId;
	}

	public void setPrimaryKey(long pk) {
		setUserRegistrationEducationId(pk);
	}

	public long getUserRegistrationEducationId() {
		return _userRegistrationEducationId;
	}

	public void setUserRegistrationEducationId(
		long userRegistrationEducationId) {

		_userRegistrationEducationId = userRegistrationEducationId;
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

	public int getGraduate() {
		return _graduate;
	}

	public void setGraduate(int graduate) {
		_graduate = graduate;
	}

	public String getCourseType() {
		return _courseType;
	}

	public void setCourseType(String courseType) {
		_courseType = courseType;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getEduType() {
		return _eduType;
	}

	public void setEduType(String eduType) {
		_eduType = eduType;
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

	private long _userRegistrationEducationId;
	private String _name;
	private int _year;
	private int _graduate;
	private String _courseType;
	private String _title;
	private String _eduType;
	private long _userRegistrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}