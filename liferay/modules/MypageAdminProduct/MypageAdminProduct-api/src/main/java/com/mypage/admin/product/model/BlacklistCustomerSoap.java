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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.BlacklistCustomerServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BlacklistCustomerSoap implements Serializable {

	public static BlacklistCustomerSoap toSoapModel(BlacklistCustomer model) {
		BlacklistCustomerSoap soapModel = new BlacklistCustomerSoap();

		soapModel.setBlacklistCustomerId(model.getBlacklistCustomerId());
		soapModel.setFullName(model.getFullName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setKtp(model.getKtp());
		soapModel.setKitas(model.getKitas());
		soapModel.setEmail(model.getEmail());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BlacklistCustomerSoap[] toSoapModels(
		BlacklistCustomer[] models) {

		BlacklistCustomerSoap[] soapModels =
			new BlacklistCustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BlacklistCustomerSoap[][] toSoapModels(
		BlacklistCustomer[][] models) {

		BlacklistCustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BlacklistCustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BlacklistCustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BlacklistCustomerSoap[] toSoapModels(
		List<BlacklistCustomer> models) {

		List<BlacklistCustomerSoap> soapModels =
			new ArrayList<BlacklistCustomerSoap>(models.size());

		for (BlacklistCustomer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BlacklistCustomerSoap[soapModels.size()]);
	}

	public BlacklistCustomerSoap() {
	}

	public long getPrimaryKey() {
		return _blacklistCustomerId;
	}

	public void setPrimaryKey(long pk) {
		setBlacklistCustomerId(pk);
	}

	public long getBlacklistCustomerId() {
		return _blacklistCustomerId;
	}

	public void setBlacklistCustomerId(long blacklistCustomerId) {
		_blacklistCustomerId = blacklistCustomerId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getKtp() {
		return _ktp;
	}

	public void setKtp(String ktp) {
		_ktp = ktp;
	}

	public String getKitas() {
		return _kitas;
	}

	public void setKitas(String kitas) {
		_kitas = kitas;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
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

	private long _blacklistCustomerId;
	private String _fullName;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _ktp;
	private String _kitas;
	private String _email;
	private Date _dateOfBirth;
	private Integer _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}