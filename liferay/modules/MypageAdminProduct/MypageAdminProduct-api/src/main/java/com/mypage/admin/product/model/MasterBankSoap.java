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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.MasterBankServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterBankSoap implements Serializable {

	public static MasterBankSoap toSoapModel(MasterBank model) {
		MasterBankSoap soapModel = new MasterBankSoap();

		soapModel.setMasterBankId(model.getMasterBankId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBankCode(model.getBankCode());
		soapModel.setBankDesc(model.getBankDesc());
		soapModel.setName(model.getName());
		soapModel.setDetail(model.getDetail());
		soapModel.setImageURL(model.getImageURL());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setOrder(model.getOrder());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static MasterBankSoap[] toSoapModels(MasterBank[] models) {
		MasterBankSoap[] soapModels = new MasterBankSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterBankSoap[][] toSoapModels(MasterBank[][] models) {
		MasterBankSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterBankSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterBankSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterBankSoap[] toSoapModels(List<MasterBank> models) {
		List<MasterBankSoap> soapModels = new ArrayList<MasterBankSoap>(
			models.size());

		for (MasterBank model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterBankSoap[soapModels.size()]);
	}

	public MasterBankSoap() {
	}

	public long getPrimaryKey() {
		return _masterBankId;
	}

	public void setPrimaryKey(long pk) {
		setMasterBankId(pk);
	}

	public long getMasterBankId() {
		return _masterBankId;
	}

	public void setMasterBankId(long masterBankId) {
		_masterBankId = masterBankId;
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

	public String getBankCode() {
		return _bankCode;
	}

	public void setBankCode(String bankCode) {
		_bankCode = bankCode;
	}

	public String getBankDesc() {
		return _bankDesc;
	}

	public void setBankDesc(String bankDesc) {
		_bankDesc = bankDesc;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDetail() {
		return _detail;
	}

	public void setDetail(String detail) {
		_detail = detail;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	public Long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(Long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public Integer getOrder() {
		return _order;
	}

	public void setOrder(Integer order) {
		_order = order;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
		_active = active;
	}

	private long _masterBankId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _bankCode;
	private String _bankDesc;
	private String _name;
	private String _detail;
	private String _imageURL;
	private Long _imageFileEntryId;
	private Integer _order;
	private Integer _active;

}