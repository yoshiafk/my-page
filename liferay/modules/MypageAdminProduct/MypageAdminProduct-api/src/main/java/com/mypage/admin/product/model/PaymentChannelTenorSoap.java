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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.PaymentChannelTenorServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PaymentChannelTenorSoap implements Serializable {

	public static PaymentChannelTenorSoap toSoapModel(
		PaymentChannelTenor model) {

		PaymentChannelTenorSoap soapModel = new PaymentChannelTenorSoap();

		soapModel.setPaymentChannelTenorId(model.getPaymentChannelTenorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPaymentChannelId(model.getPaymentChannelId());
		soapModel.setPromoid(model.getPromoid());
		soapModel.setTenor(model.getTenor());
		soapModel.setTenorid(model.getTenorid());
		soapModel.setAcquirer(model.getAcquirer());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static PaymentChannelTenorSoap[] toSoapModels(
		PaymentChannelTenor[] models) {

		PaymentChannelTenorSoap[] soapModels =
			new PaymentChannelTenorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PaymentChannelTenorSoap[][] toSoapModels(
		PaymentChannelTenor[][] models) {

		PaymentChannelTenorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PaymentChannelTenorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PaymentChannelTenorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PaymentChannelTenorSoap[] toSoapModels(
		List<PaymentChannelTenor> models) {

		List<PaymentChannelTenorSoap> soapModels =
			new ArrayList<PaymentChannelTenorSoap>(models.size());

		for (PaymentChannelTenor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PaymentChannelTenorSoap[soapModels.size()]);
	}

	public PaymentChannelTenorSoap() {
	}

	public long getPrimaryKey() {
		return _paymentChannelTenorId;
	}

	public void setPrimaryKey(long pk) {
		setPaymentChannelTenorId(pk);
	}

	public long getPaymentChannelTenorId() {
		return _paymentChannelTenorId;
	}

	public void setPaymentChannelTenorId(long paymentChannelTenorId) {
		_paymentChannelTenorId = paymentChannelTenorId;
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

	public long getPaymentChannelId() {
		return _paymentChannelId;
	}

	public void setPaymentChannelId(long paymentChannelId) {
		_paymentChannelId = paymentChannelId;
	}

	public String getPromoid() {
		return _promoid;
	}

	public void setPromoid(String promoid) {
		_promoid = promoid;
	}

	public String getTenor() {
		return _tenor;
	}

	public void setTenor(String tenor) {
		_tenor = tenor;
	}

	public String getTenorid() {
		return _tenorid;
	}

	public void setTenorid(String tenorid) {
		_tenorid = tenorid;
	}

	public String getAcquirer() {
		return _acquirer;
	}

	public void setAcquirer(String acquirer) {
		_acquirer = acquirer;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
		_active = active;
	}

	private long _paymentChannelTenorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _paymentChannelId;
	private String _promoid;
	private String _tenor;
	private String _tenorid;
	private String _acquirer;
	private Integer _active;

}