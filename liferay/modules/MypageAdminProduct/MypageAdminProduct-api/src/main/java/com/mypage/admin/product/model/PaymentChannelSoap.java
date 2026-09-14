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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.PaymentChannelServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PaymentChannelSoap implements Serializable {

	public static PaymentChannelSoap toSoapModel(PaymentChannel model) {
		PaymentChannelSoap soapModel = new PaymentChannelSoap();

		soapModel.setPaymentChannelId(model.getPaymentChannelId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setMinPayment(model.getMinPayment());
		soapModel.setMaxPayment(model.getMaxPayment());
		soapModel.setDescription(model.getDescription());
		soapModel.setMasterBankId(model.getMasterBankId());
		soapModel.setMdrAxa(model.getMdrAxa());
		soapModel.setMdrUser(model.getMdrUser());
		soapModel.setPgFeePct(model.getPgFeePct());
		soapModel.setPgFeeAmt(model.getPgFeeAmt());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setImageURL(model.getImageURL());
		soapModel.setUtmOnly(model.getUtmOnly());
		soapModel.setMallId(model.getMallId());
		soapModel.setSharedKey(model.getSharedKey());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static PaymentChannelSoap[] toSoapModels(PaymentChannel[] models) {
		PaymentChannelSoap[] soapModels = new PaymentChannelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PaymentChannelSoap[][] toSoapModels(
		PaymentChannel[][] models) {

		PaymentChannelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PaymentChannelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PaymentChannelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PaymentChannelSoap[] toSoapModels(
		List<PaymentChannel> models) {

		List<PaymentChannelSoap> soapModels = new ArrayList<PaymentChannelSoap>(
			models.size());

		for (PaymentChannel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PaymentChannelSoap[soapModels.size()]);
	}

	public PaymentChannelSoap() {
	}

	public long getPrimaryKey() {
		return _paymentChannelId;
	}

	public void setPrimaryKey(long pk) {
		setPaymentChannelId(pk);
	}

	public long getPaymentChannelId() {
		return _paymentChannelId;
	}

	public void setPaymentChannelId(long paymentChannelId) {
		_paymentChannelId = paymentChannelId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Double getMinPayment() {
		return _minPayment;
	}

	public void setMinPayment(Double minPayment) {
		_minPayment = minPayment;
	}

	public Double getMaxPayment() {
		return _maxPayment;
	}

	public void setMaxPayment(Double maxPayment) {
		_maxPayment = maxPayment;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getMasterBankId() {
		return _masterBankId;
	}

	public void setMasterBankId(long masterBankId) {
		_masterBankId = masterBankId;
	}

	public String getMdrAxa() {
		return _mdrAxa;
	}

	public void setMdrAxa(String mdrAxa) {
		_mdrAxa = mdrAxa;
	}

	public String getMdrUser() {
		return _mdrUser;
	}

	public void setMdrUser(String mdrUser) {
		_mdrUser = mdrUser;
	}

	public String getPgFeePct() {
		return _pgFeePct;
	}

	public void setPgFeePct(String pgFeePct) {
		_pgFeePct = pgFeePct;
	}

	public String getPgFeeAmt() {
		return _pgFeeAmt;
	}

	public void setPgFeeAmt(String pgFeeAmt) {
		_pgFeeAmt = pgFeeAmt;
	}

	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	public Integer getUtmOnly() {
		return _utmOnly;
	}

	public void setUtmOnly(Integer utmOnly) {
		_utmOnly = utmOnly;
	}

	public String getMallId() {
		return _mallId;
	}

	public void setMallId(String mallId) {
		_mallId = mallId;
	}

	public String getSharedKey() {
		return _sharedKey;
	}

	public void setSharedKey(String sharedKey) {
		_sharedKey = sharedKey;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
		_active = active;
	}

	private long _paymentChannelId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private Double _minPayment;
	private Double _maxPayment;
	private String _description;
	private long _masterBankId;
	private String _mdrAxa;
	private String _mdrUser;
	private String _pgFeePct;
	private String _pgFeeAmt;
	private long _imageFileEntryId;
	private String _imageURL;
	private Integer _utmOnly;
	private String _mallId;
	private String _sharedKey;
	private Integer _active;

}