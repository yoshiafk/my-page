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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartHealthPremiServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartHealthPremiSoap implements Serializable {

	public static SmartHealthPremiSoap toSoapModel(SmartHealthPremi model) {
		SmartHealthPremiSoap soapModel = new SmartHealthPremiSoap();

		soapModel.setSmartHealthPremiId(model.getSmartHealthPremiId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAge(model.getAge());
		soapModel.setGender(model.getGender());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setAmount(model.getAmount());
		soapModel.setPlanId(model.getPlanId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SmartHealthPremiSoap[] toSoapModels(
		SmartHealthPremi[] models) {

		SmartHealthPremiSoap[] soapModels =
			new SmartHealthPremiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthPremiSoap[][] toSoapModels(
		SmartHealthPremi[][] models) {

		SmartHealthPremiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartHealthPremiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartHealthPremiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthPremiSoap[] toSoapModels(
		List<SmartHealthPremi> models) {

		List<SmartHealthPremiSoap> soapModels =
			new ArrayList<SmartHealthPremiSoap>(models.size());

		for (SmartHealthPremi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SmartHealthPremiSoap[soapModels.size()]);
	}

	public SmartHealthPremiSoap() {
	}

	public long getPrimaryKey() {
		return _smartHealthPremiId;
	}

	public void setPrimaryKey(long pk) {
		setSmartHealthPremiId(pk);
	}

	public long getSmartHealthPremiId() {
		return _smartHealthPremiId;
	}

	public void setSmartHealthPremiId(long smartHealthPremiId) {
		_smartHealthPremiId = smartHealthPremiId;
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

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getPlanId() {
		return _planId;
	}

	public void setPlanId(long planId) {
		_planId = planId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _smartHealthPremiId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _age;
	private String _gender;
	private String _currency;
	private double _amount;
	private long _planId;
	private int _status;

}